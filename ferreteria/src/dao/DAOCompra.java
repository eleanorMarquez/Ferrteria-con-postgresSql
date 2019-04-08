package dao;

import entidades.Compra;
import entidades.DetalleProductoPresentaciones;
import entidades.Presentacion;
import entidades.Producto;
import entidades.Proveedor;
import entidades.TipoVentaCompra;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class DAOCompra extends DAOPostgres {

    public void Registrar(Compra compra) throws Exception {

        List<Parametro> parsCompra = new ArrayList<>();
        List<Parametro> parsDetalle = new ArrayList<>();
        float cantidad = 0;
//        List<Parametro> parsActualizarStock = new ArrayList<>();
        Object codigo;
        parsCompra.add(new Parametro("", false, Types.INTEGER));
        parsCompra.add(new Parametro("", compra.getSerie()));
        parsCompra.add(new Parametro("", compra.getNumeroFactura()));
        parsCompra.add(new Parametro("", compra.getProveedor().getCodigo()));
        parsCompra.add(new Parametro("", new java.sql.Date(compra.getFechaCompra().getTime())));
        parsCompra.add(new Parametro("", compra.getUsuario().getIdUsuario()));
//        parsCompra.add(new Parametro("", 1));
        parsCompra.add(new Parametro("", compra.getSubTotal()));
        parsCompra.add(new Parametro("", compra.getIgv()));
        parsCompra.add(new Parametro("", compra.getTotal()));
        parsCompra.add(new Parametro("", compra.getTipoCompra().getCodigo()));
//        serie, numero_factura, proveedor, fecha_compra, usuario
        parsDetalle.add(new Parametro("", 0));
        parsDetalle.add(new Parametro("", 0));
        parsDetalle.add(new Parametro("", 0));
        parsDetalle.add(new Parametro("", 0));
        parsDetalle.add(new Parametro("", 0));
        parsDetalle.add(new Parametro("", 0));
        parsDetalle.add(new Parametro("", 0));
        try {
            this.Conectar(true);
            codigo = this.EjecutarProcedimiento("{ ? = call fu_reg_compra(?, ?, ?, ?, ?, ?, ?, ?, ?)}", parsCompra);
            parsDetalle.get(0).setValor(codigo);
            for (DetalleProductoPresentaciones drr : compra.getListaDetalle()) {
                cantidad = (float) (drr.getCantidad() * drr.getPrecentacion().getCantidad());
                parsDetalle.get(1).setValor(drr.getProducto().getCodigo());
                parsDetalle.get(2).setValor(cantidad);
                parsDetalle.get(3).setValor(drr.getCantidad());
                parsDetalle.get(4).setValor(drr.getPrecentacion().getCodigo());
                parsDetalle.get(5).setValor(drr.getPrecio());
                parsDetalle.get(6).setValor(drr.getPrecioTotal());
                this.EjecutarProcedimiento(" { call fu_reg_detalle_compra(?, ?, ?, ?, ?, ?, ?) }", parsDetalle);
            }
            this.Cerrar(true);
        } catch (Exception e) {
            this.Cerrar(false);
            throw e;
        } finally {
            parsCompra.clear();
            parsCompra = null;
            parsDetalle.clear();
            parsDetalle = null;
        }
    }

    public List<Compra> listaComprasSerieNumero(boolean estado) throws Exception {
        List<Compra> lista;
        List<Parametro> pars = new ArrayList<>();
        pars.add(new Parametro("", false, Types.OTHER));
        pars.add(new Parametro("", estado));
        Compra compra;
        ResultSet rs = null;
        try {
            this.Conectar(true);
            rs = this.EjecutarProcedimientoDatos("{? = call  fu_lista_compras_serie_numero(?) }", pars);
            lista = new ArrayList<>();
            while (rs.next() == true) {
                compra = new Compra();
                compra.setCodigo(rs.getInt(1));
                compra.setSerie(rs.getString(2));
                compra.setNumeroFactura(rs.getString(3));
                compra.setTipoCompra(new TipoVentaCompra());
                compra.getTipoCompra().setNombre(rs.getString(4));
                lista.add(compra);
            }
            this.Cerrar(true);
        } catch (Exception e) {
            this.Cerrar(false);
            throw e;
        } finally {
            if (rs != null) {
                rs.close();
                rs = null;
            }
            pars.clear();
        }
        return lista;
    }

    public Compra compraDetalle(int codigo, String serie, String numero, boolean estado) throws Exception {
        List<DetalleProductoPresentaciones> listaDetalle = null;
        List<Parametro> pars = new ArrayList<>();
        List<Parametro> parsDetalle = new ArrayList();
        ResultSet rsDetalle = null;
        DetalleProductoPresentaciones dt;
        pars.add(new Parametro("", false, Types.OTHER));
        pars.add(new Parametro("", codigo));
        pars.add(new Parametro("", serie));
        pars.add(new Parametro("", numero));
        pars.add(new Parametro("", estado));

        parsDetalle.add(new Parametro("", false, Types.OTHER)); // esto es cunado retorna una lista 
        parsDetalle.add(new Parametro("", codigo));

        Compra compra = null;
        ResultSet rs = null;
        try {
            this.Conectar(true);
            rs = this.EjecutarProcedimientoDatos("{? = call  fu_lista_compras(?, ?, ?, ?) }", pars);
            while (rs.next() == true) {
                compra = new Compra();
                compra.setTipoCompra(new TipoVentaCompra());
                compra.getTipoCompra().setNombre(rs.getString(1));
                compra.setProveedor(new Proveedor());
                compra.getProveedor().setNombre(rs.getString(2));
                compra.setFechaCompra(rs.getDate(3));
                compra.setSubTotal(rs.getDouble(4));
                compra.setIgv(rs.getDouble(5));
                compra.setTotal(rs.getDouble(6));
                compra.setSerie(serie);
                compra.setNumeroFactura(numero);
                compra.setCodigo(codigo);
                rsDetalle = this.EjecutarProcedimientoDatos("{ ? = call fu_lstar_detalle_compra(?) } ", parsDetalle);
                listaDetalle = new ArrayList();
                while (rsDetalle.next() == true) {
                    dt = new DetalleProductoPresentaciones();
                    dt.setProducto(new Producto());
                    dt.getProducto().setNombre(rsDetalle.getString(1));
                    dt.setPrecentacion(new Presentacion());
                    dt.getPrecentacion().setPresentacion(rsDetalle.getString(2));
                    dt.setCantidad(rsDetalle.getDouble(3));
                    dt.setPrecio(rsDetalle.getDouble(4));
                    dt.setPrecioTotal(rsDetalle.getDouble(5));
                    dt.getProducto().setColor(rsDetalle.getString(6));
                    dt.setCantidadAuxiliar(rsDetalle.getDouble(7));
                    dt.getProducto().setCodigo(rsDetalle.getInt(8));
                    listaDetalle.add(dt);
                }
                compra.setListaDetalle(listaDetalle);
            }
            this.Cerrar(true);
        } catch (Exception e) {
            this.Cerrar(false);
            throw e;
        } finally {
            if (rs != null) {
                rs.close();
                rs = null;
            }
            if (rsDetalle != null) {
                rsDetalle.close();
                rs = null;
            }
            parsDetalle.clear();
            pars.clear();
        }
        return compra;
    }

    public void anularCompra(Compra compra) throws Exception {

        List<Parametro> parsCompra = new ArrayList<>();
        List<Parametro> parsDetalle = new ArrayList<>();
        float cantidad = 0;

        parsCompra.add(new Parametro("", compra.isEstado()));
        parsCompra.add(new Parametro("", compra.getCodigo()));

        parsDetalle.add(new Parametro("", 0));
        parsDetalle.add(new Parametro("", 0));
        try {
            this.Conectar(true);
            this.EjecutarProcedimiento(" { call fu_anular_compra(?, ?) }", parsCompra);
            
            for (DetalleProductoPresentaciones drr : compra.getListaDetalle()) {
//                cantidad = (float) (drr.getCantidad() * drr.getPrecentacion().getCantidad());
                parsDetalle.get(0).setValor(drr.getProducto().getCodigo());
                parsDetalle.get(1).setValor(drr.getCantidadAuxiliar());
                this.EjecutarProcedimiento(" { call fu_aumento_stock_producto(?, ?) }", parsDetalle);
            }
            this.Cerrar(true);
        } catch (Exception e) {
            this.Cerrar(false);
            throw e;
        } finally {
            parsCompra.clear();
            parsCompra = null;
            parsDetalle.clear();
            parsDetalle = null;
        }
    }

//    public Compra compra(int codigo, String serie, String numero, boolean estado) throws Exception {
//        List<Parametro> pars = new ArrayList<>();
//        pars.add(new Parametro("", false, Types.OTHER));
//        pars.add(new Parametro("", codigo));
//        pars.add(new Parametro("", serie));
//        pars.add(new Parametro("", numero));
//        pars.add(new Parametro("", estado));
//        Compra compra = null;
//        ResultSet rs = null;
//        try {
//            this.Conectar(true);
//            rs = this.EjecutarProcedimientoDatos("{? = call  fu_lista_compras(?, ?, ?, ?) }", pars);
//            while (rs.next() == true) {
//                compra = new Compra();
//                compra.setTipoCompra(new TipoVentaCompra());
//                compra.getTipoCompra().setNombre(rs.getString(1));
//                compra.setProveedor(new Proveedor());
//                compra.getProveedor().setNombre(rs.getString(2));
//                compra.setFechaCompra(rs.getDate(3));
//                compra.setSerie(serie);
//                compra.setNumeroFactura(numero);
//                compra.setCodigo(codigo);
//
//            }
//            this.Cerrar(true);
//        } catch (Exception e) {
//            this.Cerrar(false);
//            throw e;
//        } finally {
//            if (rs != null) {
//                rs.close();
//                rs = null;
//            }
//            pars.clear();
//        }
//        return compra;
//    }
//
//    public List<DetalleProductoPresentaciones> listaDetalle(int codigo) throws Exception {
//        List<DetalleProductoPresentaciones> listaDetalle = null;
//        List<Parametro> pars = new ArrayList();
//        ResultSet rs = null;
//        DetalleProductoPresentaciones dt;
//
//        pars.add(new Parametro("", false, Types.OTHER)); // esto es cunado retorna una lista 
//        pars.add(new Parametro("", codigo));
//        try {
//            this.Conectar(true);
//            rs = this.EjecutarProcedimientoDatos("{ ? = call fu_lstar_detalle_compra(?) } ", pars);
//            listaDetalle = new ArrayList();
//            while (rs.next() == true) {
//                dt = new DetalleProductoPresentaciones();
//                dt.setProducto(new Producto());
//                dt.getProducto().setNombre(rs.getString(1));
//                dt.setPrecentacion(new Presentacion());
//                dt.getPrecentacion().setPresentacion(rs.getString(2));
//                dt.setCantidad(rs.getDouble(3));
//                dt.setPrecio(rs.getDouble(4));
//                dt.setPrecioTotal(rs.getDouble(5));
//                dt.getProducto().setColor(rs.getString(6));
//                listaDetalle.add(dt);
//            }
//            this.Cerrar(true);
//        } catch (Exception e) {
//            this.Cerrar(false);
//            throw e;
//        }
//        return listaDetalle;
//    }
//
}
