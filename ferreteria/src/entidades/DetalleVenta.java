package entidades;

import ferreteria.MetodosFunciones;

public class DetalleVenta {

    private Producto producto;
    private Compra compra;
    private double precio;
    private double cantidad;
    private double cantidadAuxiliar; // Esta variable se utiliza para realizar una consulta a la base de dattos ques es la cantidad total qde la venta 
    private Presentacion presentacion;
    private double precioTotal;

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

    public Presentacion getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(Presentacion presentacion) {
        this.presentacion = presentacion;
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

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

}
