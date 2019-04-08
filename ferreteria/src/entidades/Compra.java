
package entidades;

import java.util.Date;
import java.util.List;


public class Compra {
    private int codigo; 
    private String serie; 
    private String numeroFactura; 
    private Proveedor proveedor; 
    private Date fechaRegistro; 
    private Date fechaCompra; 
    private List<DetalleProductoPresentaciones> listaDetalle; 
    private Usuario usuario; 
    private double subTotal;
    private double igv;
    private double total;
    private boolean estado;
    private TipoVentaCompra tipoCompra; 

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    
    
    public TipoVentaCompra getTipoCompra() {
        return tipoCompra;
    }

    public void setTipoCompra(TipoVentaCompra tipoCompra) {
        this.tipoCompra = tipoCompra;
    }
    

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public List<DetalleProductoPresentaciones> getListaDetalle() {
        return listaDetalle;
    }

    public void setListaDetalle(List<DetalleProductoPresentaciones> listaDetalle) {
        this.listaDetalle = listaDetalle;
    }
    
    
    
    
    
    
}
