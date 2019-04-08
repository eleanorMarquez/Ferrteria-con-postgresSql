package dao;

import entidades.CategoriaProducto;
import entidades.Presentacion;
import entidades.UnidadMedida;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class DAOPresentacion extends DAOPostgres {

    public void registroPresentacion(Presentacion pre) throws Exception {
        List<Parametro> pars = new ArrayList<>();

        try {
            pars.add(new Parametro("", pre.getUnidadMedida().getCodigo()));
            pars.add(new Parametro("", pre.getPresentacion()));
            pars.add(new Parametro("", pre.getCantidad()));
            pars.add(new Parametro("", pre.getDescripcion()));
            this.Conectar(true);
            this.EjecutarProcedimiento("{ call fu_reg_presentacion(?, ?, ?, ?) }", pars);
            this.Cerrar(true);
        } catch (Exception e) {
            this.Cerrar(false);
            throw e;
        } finally {
            pars.clear();
        }
    }

    public void modificarPresentacion(Presentacion pre) throws Exception {
        List<Parametro> pars = new ArrayList<>();

        try {
//            nombre=pnombre, unidad_medida=punidad_medida, cantidad=pcantidad, descripcion=pdescripcion
//            pars.add(new Parametro("", pre.getNombreCategoria()));
            pars.add(new Parametro("", pre.getPresentacion()));
            pars.add(new Parametro("", pre.getUnidadMedida().getCodigo()));
            pars.add(new Parametro("", pre.getCantidad()));
            pars.add(new Parametro("", pre.getDescripcion()));
            pars.add(new Parametro("", pre.getCodigo()));
            this.Conectar(true);
            this.EjecutarProcedimiento("{ call fu_presentacion_modificar(?, ?, ?, ?, ?) }", pars);
            this.Cerrar(true);
        } catch (Exception e) {
            this.Cerrar(false);
            throw e;
        } finally {
            pars.clear();
        }
    }

    public void darBajaDarAlta(Presentacion pre) throws Exception {
        List<Parametro> pars = new ArrayList<>();
        try {
            pars.add(new Parametro("", pre.getCodigo()));
            pars.add(new Parametro("", pre.isEstado()));
            this.Conectar(true);
            this.EjecutarProcedimiento("{ call fu_presentacion_eliminar_activar(?, ?) }", pars);
            this.Cerrar(true);
        } catch (Exception e) {
            this.Cerrar(false);
            throw e;
        } finally {
            pars.clear();
        }
    }

    public List<Presentacion> listaPresentacion(boolean estado) throws Exception {
        List<Presentacion> listaPresentacion;
        List<Parametro> pars = new ArrayList();
        Presentacion pre;
        UnidadMedida unidadMedida;
        pars.add(new Parametro("", false, Types.OTHER));
        pars.add(new Parametro("", estado));
        ResultSet rs = null;
        try {
            this.Conectar(true);
            rs = this.EjecutarProcedimientoDatos("{ ? = call fu_lista_presentacion(?) }", pars);
            listaPresentacion = new ArrayList();
            while (rs.next() == true) {
                pre = new Presentacion();
                unidadMedida = new UnidadMedida();
                pre.setCodigo(rs.getInt(1));
                pre.setPresentacion(rs.getString(2));
                pre.setUnidadMedida(unidadMedida);
                pre.getUnidadMedida().setNombre(rs.getString(3));
                pre.setCantidad(rs.getDouble(4));
                pre.setDescripcion(rs.getString(5));
                pre.getUnidadMedida().setCodigo(rs.getInt(6)); 
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

}
