package entidades;

import ferreteria.MetodosFunciones;

public class DetalleProductoPresentaciones {

    private Producto producto;
    private Presentacion precentacion;
    private double cantidad;
    private double precio;
    private double precioTotal;
    private double cantidadAuxiliar; // esta cantidad es unaxitliar que se utiliza para obtener la cantidad total, en una consulta 

    public double getCantidadAuxiliar() {
        return cantidadAuxiliar;
    }

    public void setCantidadAuxiliar(double cantidadAuxiliar) {
        this.cantidadAuxiliar = cantidadAuxiliar;
    }

    public double getPrecioTotal() {
        double aux = precio * cantidad;
        String aux2 = MetodosFunciones.formatearNumero2(aux);
        precioTotal = Double.parseDouble(aux2); 
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Presentacion getPrecentacion() {
        return precentacion;
    }

    public void setPrecentacion(Presentacion precentacion) {
        this.precentacion = precentacion;
    }
}
