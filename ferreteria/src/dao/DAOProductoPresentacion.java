package dao;

import entidades.DetalleProductoPresentaciones;
import entidades.Presentacion;
import entidades.Producto;
import entidades.ProductoPresentacion;
import entidades.Proveedor;
import entidades.UnidadMedida;
import ferreteria.Ferreteria;
import ferreteria.MetodosFunciones;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class DAOProductoPresentacion extends DAOPostgres {

    public void registrarPresentacionesDeProducto(Producto pr, Presentacion pre) throws Exception {

        List<Parametro> parsPresentaciones = new ArrayList<>();
        parsPresentaciones.add(new Parametro("", pr.getCodigo()));
        parsPresentaciones.add(new Parametro("", pre.getCodigo()));
        try {
            this.Conectar(true);
            this.EjecutarProcedimiento("{ call fu_reg_prod_presentacion(?, ?)}", parsPresentaciones);
//            for (DetalleProductoPresentaciones detalle : porPre.getListaDet()) {
//                parsPresentaciones.get(0).setValor(detalle.getProducto().getCodigo()); // capturo el codigo del producto 
//                parsPresentaciones.get(1).setValor(detalle.getPrecentacion().getCodigo()); // capturo el codigo del producto 
//                this.EjecutarProcedimiento("{ call fu_reg_prod_presentacion(?, ?)}", parsPresentaciones);
//            }
            this.Cerrar(true);
        } catch (Exception e) {
            this.Cerrar(false);
            throw e;
        }
    }

    public List<Presentacion> listaPresentacionCodigoProd(int codigo) throws Exception {
        List<Presentacion> listaPresentacion;
        List<Parametro> pars = new ArrayList();
        Presentacion pre;
        UnidadMedida unidadMedida;
        pars.add(new Parametro("", false, Types.OTHER));
        pars.add(new Parametro("", codigo));
        ResultSet rs = null;
        try {
            this.Conectar(true);
            rs = this.EjecutarProcedimientoDatos("{ ? = call fu_lista_presentacion_producto(?) }", pars);
            listaPresentacion = new ArrayList();
            while (rs.next() == true) {
                pre = new Presentacion();
                unidadMedida = new UnidadMedida(); 
                
                pre.setCodigo(rs.getInt(1));
                pre.setPresentacion(rs.getString(2));
                pre.setCantidad(rs.getDouble(3));
                pre.setUnidadMedida(unidadMedida);
                pre.getUnidadMedida().setNombre(rs.getString(4));
                listaPresentacion.add(pre);
            }
            this.Cerrar(true);
        } catch (Exception e) {
            this.Cerrar(false);
            throw e;
        } finally {
            pars.clear();
        }
        return listaPresentacion;
    }

    /**
     * Este metodo lo utilizao en le detalles de productos y presetnacion, para
     * listar los presentacion que tiene cada producto segun su codigo de
     * producto
     */
    public List<Presentacion> listaPresentacionDetallePresentacion(int codigo) throws Exception {
        List<Presentacion> listaPresentacion;
        List<Parametro> pars = new ArrayList();
        Presentacion pre;
        UnidadMedida unidadMedida;
        pars.add(new Parametro("", false, Types.OTHER));
        pars.add(new Parametro("", codigo));
        ResultSet rs = null;
        try {
            this.Conectar(true);
            rs = this.EjecutarProcedimientoDatos("{ ? = call fu_lista_presentacion_producto_codigo(?) }", pars);
            listaPresentacion = new ArrayList();
            while (rs.next() == true) {
                pre = new Presentacion();
                unidadMedida = new UnidadMedida();
//                pre.codigo, pre.nombre, pre.cantidad, uni.nombre, pre.descripcion  
                pre.setCodigo(rs.getInt(1));
                pre.setPresentacion(rs.getString(2));
                pre.setUnidadMedida(unidadMedida);
                pre.setCantidad(rs.getDouble(3));
                pre.getUnidadMedida().setNombre(rs.getString(4));
                pre.setDescripcion(rs.getString(5));
                listaPresentacion.add(pre);
            }
            this.Cerrar(true);
        } catch (Exception e) {
            this.Cerrar(false);
            throw e;
        } finally {
            pars.clear();
        }
        return listaPresentacion;
    }

    public void eliminarDetallePresentacion(Producto pr, Presentacion pre) throws Exception {
        List<Parametro> parsPresentaciones = new ArrayList<>();
        parsPresentaciones.add(new Parametro("", pre.getCodigo()));
        parsPresentaciones.add(new Parametro("", pr.getCodigo()));

        try {
            this.Conectar(true);
            this.EjecutarProcedimiento("{call fu_eliminar_presentaciones_detalle(?, ?)}", parsPresentaciones);
            this.Cerrar(true);
        } catch (Exception e) {
            this.Cerrar(false);
            throw e;
        }

    }
}
