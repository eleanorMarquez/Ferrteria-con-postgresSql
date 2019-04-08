
package entidades;

import java.util.List;



public class ProductoPresentacion {

    private Producto producto; 
    private List<Presentacion> listaPresentacion; 
    private List<DetalleProductoPresentaciones> listaDet; 

    public List<DetalleProductoPresentaciones> getListaDet() {
        return listaDet;
    }

    public void setListaDet(List<DetalleProductoPresentaciones> listaDet) {
        this.listaDet = listaDet;
    }

    public List<DetalleProductoPresentaciones> getListaDetalle() {
        return listaDetalle;
    }

    public void setListaDetalle(List<DetalleProductoPresentaciones> listaDetalle) {
        this.listaDetalle = listaDetalle;
    }
    
    
    private List<DetalleProductoPresentaciones> listaDetalle;

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public List<Presentacion> getListaPresentacion() {
        return listaPresentacion;
    }

    public void setListaPresentacion(List<Presentacion> listaPresentacion) {
        this.listaPresentacion = listaPresentacion;
    }
    
}
