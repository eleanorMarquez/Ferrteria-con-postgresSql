package dao;

import entidades.CategoriaProducto;
import entidades.Proveedor;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class DAOProveedor extends DAOPostgres {

    public void registroProveedor(Proveedor proveedor) throws Exception {
        List<Parametro> pars = new ArrayList<>();
        try {
            pars.add(new Parametro("", proveedor.getNombre()));
            pars.add(new Parametro("", proveedor.getRuc()));
            pars.add(new Parametro("", proveedor.getDireccion()));
            this.Conectar(true);
            this.EjecutarProcedimiento("{ call fu_reg_proveedor(?, ?, ?) }", pars);
            this.Cerrar(true);
        } catch (Exception e) {
            this.Cerrar(false);
            throw e;
        } finally {
            pars.clear();
        }
    }
   
    public void modificarProveedor(Proveedor proveedor) throws Exception {
        List<Parametro> pars = new ArrayList<>();
        try {
            pars.add(new Parametro("", proveedor.getNombre()));
            pars.add(new Parametro("", proveedor.getRuc()));
            pars.add(new Parametro("", proveedor.getDireccion()));
            pars.add(new Parametro("", proveedor.getCodigo()));
            this.Conectar(true);
            this.EjecutarProcedimiento("{ call fu_modificar_proveedor(?, ?, ?, ?) }", pars);
            this.Cerrar(true);
        } catch (Exception e) {
            this.Cerrar(false);
            throw e;
        } finally {
            pars.clear();
        }
    }
   
    
   
    
   
    public void darBajaDarAlta(Proveedor prov) throws Exception {
        List<Parametro> pars = new ArrayList<>();
        try {
            pars.add(new Parametro("", prov.getCodigo()));
            pars.add(new Parametro("", prov.isEstado()));
            this.Conectar(true);
            this.EjecutarProcedimiento("{ call fu_proveedor_eliminar_activar(?, ?) }", pars);
            this.Cerrar(true);
        } catch (Exception e) {
            this.Cerrar(false);
            throw e;
        } finally {
            pars.clear();
        }
    }
    
    public List<Proveedor> listaProveedores(boolean estado) throws Exception {
        List<Proveedor> listaProveedores;
        List<Parametro> pars = new ArrayList();
        Proveedor pro;
        pars.add(new Parametro("", false, Types.OTHER));
        pars.add(new Parametro("", estado));
        ResultSet rs = null;
        try {
            this.Conectar(true);
            rs = this.EjecutarProcedimientoDatos("{ ? = call fu_lista_proveedores(?) }", pars);
            listaProveedores = new ArrayList();
            while (rs.next() == true) {
                pro = new Proveedor();
                pro.setCodigo(rs.getInt(1));
                pro.setNombre(rs.getString(2));
                pro.setRuc(rs.getString(3));
                pro.setDireccion(rs.getString(3));
                listaProveedores.add(pro);
            }
            this.Cerrar(true);
        } catch (Exception e) {
            this.Cerrar(false);
            throw e;
        }
        return listaProveedores;
    }
    
}
