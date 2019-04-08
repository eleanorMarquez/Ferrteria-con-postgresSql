package entidades;

import java.util.Date;
import java.util.List;

public class Venta {
    
    
    private int codigo; 
    private String serie; 
    private String numero; 
    private String cliente; 
    private Date fechaRegistro; 
    private Date fechaVenta;
    private boolean estado; 
    private double subTotal;
    private double total;
    private double igv; 
    private Usuario us; 
    private TipoVentaCompra tipoVenta; 
    List<DetalleVenta> listaDetalle; 

    public TipoVentaCompra getTipoVenta() {
        return tipoVenta;
    }

    public void setTipoVenta(TipoVentaCompra tipoVenta) {
        this.tipoVenta = tipoVenta;
    }
    
    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    
    public Usuario getUs() {
        return us;
    }
    public void setUs(Usuario us) {
        this.us = us;
    }
    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public List<DetalleVenta> getListaDetalle() {
        return listaDetalle;
    }

    public void setListaDetalle(List<DetalleVenta> listaDetalle) {
        this.listaDetalle = listaDetalle;
    }

}
