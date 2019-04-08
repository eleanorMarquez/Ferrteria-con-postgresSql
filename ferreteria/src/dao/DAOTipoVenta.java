
package dao;

import entidades.CategoriaProducto;
import entidades.Presentacion;
import entidades.Producto;
import entidades.TipoVentaCompra;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;


public class DAOTipoVenta extends DAOPostgres{
    
    
    
    public List<TipoVentaCompra> listaTipoVenta(boolean estado) throws Exception {
        List<TipoVentaCompra> listaTipoVenta;
        List<Parametro> pars = new ArrayList();
        TipoVentaCompra tipoVenta;

        pars.add(new Parametro("", false, Types.OTHER));
        pars.add(new Parametro("", estado));
        ResultSet rs = null;
        try {
            this.Conectar(true);
            rs = this.EjecutarProcedimientoDatos("{ ? = call fu_lista_tipo_venta(?) }", pars);
            listaTipoVenta = new ArrayList();
            while (rs.next() == true) {
                tipoVenta = new TipoVentaCompra();
                tipoVenta.setCodigo(rs.getInt(1));
                tipoVenta.setNombre(rs.getString(2));
                tipoVenta.setDescripcion(rs.getString(3));
                listaTipoVenta.add(tipoVenta);
            }
            this.Cerrar(true);
        } catch (Exception e) {
            this.Cerrar(false);
            throw e;
        } finally {
            pars.clear();
        }
        return listaTipoVenta;
    }


    
    
    
    
}
