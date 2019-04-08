/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

//import java.sql.Types;
//import java.util.ArrayList;
//import java.util.List;
//import transferObjects.DetalleVenta;
//import transferObjects.Venta;
import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import entidades.Usuario;

public class DAOUsuario extends DAOPostgres {

    public List<Usuario> ListarUsuarios() throws Exception {
        List<Usuario> usuarios = null;
        Usuario us = null;
        Connection cn = null;
        Statement st = null; // SQL 
        ResultSet rs = null;
        String sql;
        sql = " select idusuario, nombre_usuario from usuario where estado = true";
        try {
            this.Conectar(true);
            rs = this.EjecutarOrdenDatos(sql);
            this.Cerrar(true);
            usuarios = new ArrayList<Usuario>();
            while (rs.next() == true) { // next devuelve un boleano ...  si hay datos devuelve falso caso contrario verdadero
                us = new Usuario();
                us.setIdUsuario(rs.getInt("idusuario"));
                us.setNombreUsuario(rs.getString("nombre_usuario"));
                usuarios.add(us);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (st != null) {
                st.close();
                st = null;
            }
            if (cn != null) {
                cn.close();
                cn = null;
            }
        }
        return usuarios;
    }

    public Usuario usuarioValidar(Usuario user) throws Exception {
        List<Usuario> usuarios = null;
        List<Parametro> pars = new ArrayList();
        Usuario us = null;
        Connection cn = null;
        Statement st = null; // SQL 
        ResultSet rs = null;
        pars.add(new Parametro("", false, Types.OTHER));
        pars.add(new Parametro("", user.getNombreUsuario()));
        pars.add(new Parametro("", user.getContraseña()));
        try {
            this.Conectar(true);
            rs = this.EjecutarProcedimientoDatos("{ ? = call fu_verificarusuario( ?, ? ) }", pars);
            this.Cerrar(true);
            usuarios = new ArrayList<Usuario>();
            while (rs.next() == true) { // next devuelve un boleano ...  si hay datos devuelve falso caso contrario verdadero
                us = new Usuario();
                us.setIdUsuario(rs.getInt("idusuario"));
                us.setNombreUsuario(rs.getString("nombre_usuario"));
                usuarios.add(us);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (st != null) {
                st.close();
                st = null;
            }
            if (cn != null) {
                cn.close();
                cn = null;
            }
        }
        return us;
    }

    public void cambioContraseña(Usuario user) throws Exception {
        List<Parametro> pars = new ArrayList();
        pars.add(new Parametro("", user.getContraseña()));
        pars.add(new Parametro("", user.getIdUsuario()));

        try {
            this.Conectar(true);
            this.EjecutarProcedimiento("{ call fu_cambio_password( ?, ? ) }", pars);
            this.Cerrar(true);
        } catch (Exception e) {
            this.Cerrar(true);
            throw e;
        } finally {

        }
    }

}
