package dao;

import entidades.DetalleVenta;
import entidades.Presentacion;
import entidades.Producto;
import entidades.TipoVentaCompra;
import entidades.Venta;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class DAOVenta extends DAOPostgres {

    public void Registrar(Venta venta) throws Exception {
        List<Parametro> parsCompra = new ArrayList<>();
        List<Parametro> parsDetalle = new ArrayList<>();
        float cantidad = 0;
        Object codigo;
        parsCompra.add(new Parametro("", false, Types.INTEGER));
        parsCompra.add(new Parametro("", venta.getSerie()));
        parsCompra.add(new Parametro("", venta.getNumero()));
        parsCompra.add(new Parametro("", venta.getCliente()));
        parsCompra.add(new Parametro("", new java.sql.Date(venta.getFechaVenta().getTime())));
        parsCompra.add(new Parametro("", venta.getUs().getIdUsuario()));
//        parsCompra.add(new Parametro("", 1));
        parsCompra.add(new Parametro("", venta.getTipoVenta().getCodigo()));
        parsCompra.add(new Parametro("", venta.getSubTotal()));
        parsCompra.add(new Parametro("", venta.getIgv()));
        parsCompra.add(new Parametro("", venta.getTotal()));

        parsDetalle.add(new Parametro("", 0));
        parsDetalle.add(new Parametro("", 0));
        parsDetalle.add(new Parametro("", 0));
        parsDetalle.add(new Parametro("", 0));
        parsDetalle.add(new Parametro("", 0));
        parsDetalle.add(new Parametro("", 0));
        parsDetalle.add(new Parametro("", 0));
        try {
            this.Conectar(true);
            codigo = this.EjecutarProcedimiento("{ ? = call fu_reg_venta(?, ?, ?, ?, ?, ?, ?, ?, ?)}", parsCompra);
            parsDetalle.get(0).setValor(codigo);
            for (DetalleVenta drr : venta.getListaDetalle()) {
                parsDetalle.get(1).setValor(drr.getProducto().getCodigo());
                cantidad = (float) (drr.getCantidad() * drr.getPresentacion().getCantidad());
                parsDetalle.get(2).setValor(cantidad);
                parsDetalle.get(3).setValor(drr.getPrecio());
                parsDetalle.get(4).setValor(drr.getCantidad());
                parsDetalle.get(5).setValor(drr.getPrecioTotal());
                parsDetalle.get(6).setValor(drr.getPresentacion().getCodigo());
                this.EjecutarProcedimiento("{call fu_reg_detalle_venta(?, ?, ?, ?, ?, ?, ?) }", parsDetalle);
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

    public Venta venta(Venta pventa) throws Exception {
        Venta venta = null;
        List<DetalleVenta> listaDetalleVenta = null;
        DetalleVenta detalle;
        List<Parametro> pars = new ArrayList();
        List<Parametro> parsDetalle = new ArrayList();
        ResultSet rs = null;
        ResultSet rsDetalle = null;
        DetalleVenta dv;
        pars.add(new Parametro("", false, Types.OTHER));
        pars.add(new Parametro("", pventa.getCodigo()));
        pars.add(new Parametro("", pventa.getSerie()));
        pars.add(new Parametro("", pventa.getNumero()));
        pars.add(new Parametro("", pventa.isEstado()));
        parsDetalle.add(new Parametro("", false, Types.OTHER));
        parsDetalle.add(new Parametro("", pventa.getCodigo()));

        try {
            this.Conectar(true);
            rs = this.EjecutarProcedimientoDatos(" { ? = call fu_lstar_venta(?, ?, ?, ?) } ", pars);
            while (rs.next() == true) {
                venta = new Venta();
                venta.setCodigo(pventa.getCodigo());
                venta.setSerie(pventa.getSerie());
                venta.setNumero(pventa.getNumero());
                venta.setTipoVenta(new TipoVentaCompra());
                venta.getTipoVenta().setNombre(rs.getString(1));
                venta.setCliente(rs.getString(2));
                venta.setFechaVenta(rs.getDate(3));
                venta.setSubTotal(rs.getDouble(4));
                venta.setIgv(rs.getDouble(5));
                venta.setTotal(rs.getDouble(6));

                rsDetalle = this.EjecutarProcedimientoDatos("{ ? = call  fu_lstar_venta_detalle (?) } ", parsDetalle);
                listaDetalleVenta = new ArrayList();
                while (rsDetalle.next() == true) {
                    detalle = new DetalleVenta();
                    detalle.setProducto(new Producto());
                    detalle.setPresentacion(new Presentacion());
                    detalle.getProducto().setCodigo(rsDetalle.getInt(1));
                    detalle.getProducto().setNombre(rsDetalle.getString(2));
                    detalle.getPresentacion().setPresentacion(rsDetalle.getString(3));
                    detalle.setCantidad(rsDetalle.getDouble(4));
                    detalle.setPrecio(rsDetalle.getDouble(5));
                    detalle.setPrecioTotal(rsDetalle.getDouble(6));
                    detalle.setCantidadAuxiliar(rsDetalle.getDouble(7));
                    detalle.getProducto().setColor(rsDetalle.getString(8));
                    listaDetalleVenta.add(detalle);
                }
                venta.setListaDetalle(listaDetalleVenta);
            }
            this.Cerrar(true);
        } catch (Exception e) {
            this.Cerrar(false);
            throw e;
        } finally {
            pars.clear();
        }
        return venta;
    }

    public void anular(Venta venta) throws Exception {
        List<Parametro> pars = new ArrayList();
        List<Parametro> parsDetalle = new ArrayList();

        pars.add(new Parametro("", venta.getCodigo()));
        pars.add(new Parametro("", venta.isEstado()));
        parsDetalle.add(new Parametro("", 0));
        parsDetalle.add(new Parametro("", 0));

        try {
            this.Conectar(true);
            this.EjecutarProcedimiento(" { call fu_anular_venta( ?, ? ) }", pars);
            for (DetalleVenta dv : venta.getListaDetalle()) {
                parsDetalle.get(0).setValor(dv.getProducto().getCodigo());
                parsDetalle.get(1).setValor(dv.getCantidadAuxiliar());
                this.EjecutarProcedimiento("{ call fu_aumento_stock_prducto_anular_venta(?, ?)}", parsDetalle);
            }
            this.Cerrar(true);
        } catch (Exception e) {
            this.Cerrar(false);
            throw e;
        } finally {
            pars.clear();
            parsDetalle.clear();
        }

    }

    public List<Venta> ventaSerieNumero(boolean estado) throws Exception {
        List<Venta> listaVenta = null;
        Venta venta = null;
        ResultSet rs = null;
        List<Parametro> pars = new ArrayList();
        pars.add(new Parametro("", false, Types.OTHER));
        pars.add(new Parametro("", estado));

        try {
            this.Conectar(true);
            rs = this.EjecutarProcedimientoDatos("{ ? = call fu_lstar_ventas_serie_numero(?) } ", pars);
            listaVenta = new ArrayList();
            while (rs.next() == true) {
                venta = new Venta();
                venta.setCodigo(rs.getInt(1));
                venta.setSerie(rs.getString(2));
                venta.setNumero(rs.getString(3));
                venta.setTipoVenta(new TipoVentaCompra());
                venta.getTipoVenta().setNombre(rs.getString(4));
                listaVenta.add(venta);
            }
            this.Cerrar(true);
        } catch (Exception e) {
            this.Cerrar(false);
            throw e;
        } finally {
            pars.clear();
        }
        return listaVenta;
    }

}
