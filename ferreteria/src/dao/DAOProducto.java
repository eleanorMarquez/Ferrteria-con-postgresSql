package dao;

import entidades.CategoriaProducto;
import entidades.Presentacion;
import entidades.Producto;
import entidades.UnidadMedida;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class DAOProducto extends DAOPostgres {

    public void registroProducto(Producto productos) throws Exception {
        List<Parametro> pars = new ArrayList<>();

        try {
            pars.add(new Parametro("", productos.getNombre()));
            pars.add(new Parametro("", productos.getCatProd().getCodigo()));
//            pars.add(new Parametro("", productos.getPre().getCodigo()));
            pars.add(new Parametro("", productos.getColor()));
            pars.add(new Parametro("", productos.getDescripcion()));
            pars.add(new Parametro("", productos.getUnidaMedida().getCodigo()));
            this.Conectar(true);
            this.EjecutarProcedimiento("{ call fu_reg_producto(?, ?, ?, ?, ?) }", pars);
            this.Cerrar(true);
        } catch (Exception e) {
            this.Cerrar(false);
            throw e;
        } finally {
            pars.clear();
        }
    }

    public void modificarProducto(Producto productos) throws Exception {
        List<Parametro> pars = new ArrayList<>();

        try {
            pars.add(new Parametro("", productos.getNombre()));
            pars.add(new Parametro("", productos.getCatProd().getCodigo()));
            pars.add(new Parametro("", productos.getColor()));
            pars.add(new Parametro("", productos.getDescripcion()));
            pars.add(new Parametro("", productos.getCodigo()));
            pars.add(new Parametro("", productos.getUnidaMedida().getCodigo()));
            
            this.Conectar(true);
            this.EjecutarProcedimiento("{ call fu_modificar_producto(?, ?, ?, ?, ?, ?) }", pars);
            this.Cerrar(true);
        } catch (Exception e) {
            this.Cerrar(false);
            throw e;
        } finally {
            pars.clear();
        }
    }

    public void darBajaDarAlta(Producto pro) throws Exception {
        List<Parametro> pars = new ArrayList<>();
        try {
            pars.add(new Parametro("", pro.getCodigo()));
            pars.add(new Parametro("", pro.isEstado()));
            this.Conectar(true);
            this.EjecutarProcedimiento("{ call fu_producto_eliminar_activar(?, ?) }", pars);
            this.Cerrar(true);
        } catch (Exception e) {
            this.Cerrar(false);
            throw e;
        } finally {
            pars.clear();
        }
    }

    public List<Producto> listaProductoss(boolean estado) throws Exception {
        List<Producto> listaProductos;
        List<Parametro> pars = new ArrayList();
        Producto pro;
        Presentacion pre;
        CategoriaProducto catPro;
        pars.add(new Parametro("", false, Types.OTHER));
        pars.add(new Parametro("", estado));
        ResultSet rs = null;
        try {
            this.Conectar(true);
            rs = this.EjecutarProcedimientoDatos("{ ? = call fu_lista_productos(?) }", pars);
            listaProductos = new ArrayList();
            while (rs.next() == true) {
                pro = new Producto();
                catPro = new CategoriaProducto();
                pro.setCodigo(rs.getInt(1));
                pro.setNombre(rs.getString(2));
                pro.setCatProd(catPro);
                pro.getCatProd().setCodigo(rs.getInt(3));
                pro.getCatProd().setNombreCategoria(rs.getString(4));
                pro.setColor(rs.getString(5));
                pro.setDescripcion(rs.getString(6));
                pro.setUnidaMedida(new UnidadMedida());
                pro.getUnidaMedida().setCodigo(rs.getInt(7));
                pro.getUnidaMedida().setNombre(rs.getString(8));
                listaProductos.add(pro);
            }
            this.Cerrar(true);
        } catch (Exception e) {
            this.Cerrar(false);
            throw e;
        } finally {
            pars.clear();
        }
        return listaProductos;
    }

    public List<Producto> listaProductosBusqueda(boolean estado, String nombre) throws Exception {
        List<Producto> listaProductos;
        List<Parametro> pars = new ArrayList();
        Producto pro;
        Presentacion pre;
        CategoriaProducto catPro;
        pars.add(new Parametro("", false, Types.OTHER));
        pars.add(new Parametro("", estado));
        pars.add(new Parametro("", nombre));
        ResultSet rs = null;
        try {
            this.Conectar(true);
            rs = this.EjecutarProcedimientoDatos("{ ? = call fu_lista_productos_busqueda(?, ?) }", pars);
            listaProductos = new ArrayList();
            while (rs.next() == true) {
                pro = new Producto();
                catPro = new CategoriaProducto();
                pro.setCodigo(rs.getInt(1));
                pro.setNombre(rs.getString(2));
                pro.setCatProd(catPro);
                pro.getCatProd().setCodigo(rs.getInt(3));
                pro.getCatProd().setNombreCategoria(rs.getString(4));
                pro.setColor(rs.getString(5));
                pro.setDescripcion(rs.getString(6));
                pro.setUnidaMedida(new UnidadMedida());
                pro.getUnidaMedida().setCodigo(rs.getInt(7));
                pro.getUnidaMedida().setNombre(rs.getString(8));
                listaProductos.add(pro);
            }
            this.Cerrar(true);
        } catch (Exception e) {
            this.Cerrar(false);
            throw e;
        } finally {
            pars.clear();
        }
        return listaProductos;
    }

}
