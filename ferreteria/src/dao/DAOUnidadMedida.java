package dao;

import entidades.UnidadMedida;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class DAOUnidadMedida extends DAOPostgres {

    public void registroUnidadMedida(UnidadMedida unidadMedida) throws Exception {
        List<Parametro> pars = new ArrayList<>();

        try {
            pars.add(new Parametro("", unidadMedida.getNombre()));
            pars.add(new Parametro("", unidadMedida.getDescripcion()));
            this.Conectar(true);
            this.EjecutarProcedimiento("{ call fu_reg_unidad_medida(?, ?) }", pars);
            this.Cerrar(true);
        } catch (Exception e) {
            this.Cerrar(false);
            throw e;
        } finally {
            pars.clear();
        }
    }
   
    public void modificarUnidadMedida(UnidadMedida unidadMedida) throws Exception {
        List<Parametro> pars = new ArrayList<>();

        try {
            pars.add(new Parametro("", unidadMedida.getNombre()));
            pars.add(new Parametro("", unidadMedida.getDescripcion()));
            pars.add(new Parametro("", unidadMedida.getCodigo()));
            this.Conectar(true);
            this.EjecutarProcedimiento("{ call fu_modificar_unidad_medida(?, ?, ?) }", pars);
            this.Cerrar(true);
        } catch (Exception e) {
            this.Cerrar(false);
            throw e;
        } finally {
            pars.clear();
        }
    }
    
   
    public void darBajaDarAlta(UnidadMedida unidadMedida) throws Exception {
        List<Parametro> pars = new ArrayList<>();
        try {
            pars.add(new Parametro("", unidadMedida.getCodigo()));
            pars.add(new Parametro("", unidadMedida.isEstado()));
            this.Conectar(true);
            this.EjecutarProcedimiento("{ call fu_eliminar_activar(?, ?) }", pars);
            this.Cerrar(true);
        } catch (Exception e) {
            this.Cerrar(false);
            throw e;
        } finally {
            pars.clear();
        }
    }
    public List<UnidadMedida> listaUnidaMedida(boolean estado) throws Exception {
        List<UnidadMedida> listaUnidadMedida;
        List<Parametro> pars = new ArrayList();
        UnidadMedida unidadMedida;
        pars.add(new Parametro("", false, Types.OTHER));
        pars.add(new Parametro("", estado));

        ResultSet rs = null;
        try {
            this.Conectar(true);
            rs = this.EjecutarProcedimientoDatos("{ ? = call fu_lista_unidad_medida(?) }", pars);
            listaUnidadMedida = new ArrayList();
            while (rs.next() == true) {
                unidadMedida = new UnidadMedida();
                unidadMedida.setCodigo(rs.getInt(1));
                unidadMedida.setNombre(rs.getString(2));
                unidadMedida.setDescripcion(rs.getString(3));
                listaUnidadMedida.add(unidadMedida);
            }
            this.Cerrar(true);
        } catch (Exception e) {
            this.Cerrar(false);
            throw e;
        }
        return listaUnidadMedida;
    }
    
}
