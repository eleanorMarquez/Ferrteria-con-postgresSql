package dao;

import entidades.CategoriaProducto;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class DAOCategoriaProducto extends DAOPostgres {

    public void registroCategoriaProducto(CategoriaProducto catPrd) throws Exception {
        List<Parametro> pars = new ArrayList<>();

        try {
            pars.add(new Parametro("", catPrd.getNombreCategoria()));
            pars.add(new Parametro("", catPrd.getDescripcion()));
            this.Conectar(true);
            this.EjecutarProcedimiento("{ call fu_reg_categoria_producto(?, ?) }", pars);
            this.Cerrar(true);
        } catch (Exception e) {
            this.Cerrar(false);
            throw e;
        } finally {
            pars.clear();
        }
    }

    public void modificarCategoriaProducto(CategoriaProducto catPro) throws Exception {
        List<Parametro> pars = new ArrayList<>();

        try {
            pars.add(new Parametro("", catPro.getNombreCategoria()));
            pars.add(new Parametro("", catPro.getDescripcion()));
            pars.add(new Parametro("", catPro.getCodigo()));
            this.Conectar(true);
            this.EjecutarProcedimiento("{ call fu_modificar_categoria_producto(?, ?, ?) }", pars);
            this.Cerrar(true);
        } catch (Exception e) {
            this.Cerrar(false);
            throw e;
        } finally {
            pars.clear();
        }
    }

    public void darBajaDarAlta(CategoriaProducto catPro) throws Exception {
        List<Parametro> pars = new ArrayList<>();
        try {
            pars.add(new Parametro("", catPro.getCodigo()));
            pars.add(new Parametro("", catPro.isEstado()));
            this.Conectar(true);
            this.EjecutarProcedimiento("{ call fu__categoria_pro_eliminar_activar(?, ?) }", pars);
            this.Cerrar(true);
        } catch (Exception e) {
            this.Cerrar(false);
            throw e;
        } finally {
            pars.clear();
        }
    }

    public List<CategoriaProducto> listaCategoriaProductos(boolean estado) throws Exception {
        List<CategoriaProducto> listaCategorias;
        List<Parametro> pars = new ArrayList();
        CategoriaProducto catPro;
        pars.add(new Parametro("", false, Types.OTHER));
        pars.add(new Parametro("", estado));

        ResultSet rs = null;
        try {
            this.Conectar(true);
            rs = this.EjecutarProcedimientoDatos("{ ? = call fu_lista_categoria_producto(?) }", pars);
            listaCategorias = new ArrayList();
            while (rs.next() == true) {
                catPro = new CategoriaProducto();
                catPro.setCodigo(rs.getInt(1));
                catPro.setNombreCategoria(rs.getString(2));
                catPro.setDescripcion(rs.getString(3));
                listaCategorias.add(catPro);
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
        }
        return listaCategorias;
    }

}
