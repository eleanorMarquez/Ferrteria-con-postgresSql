package entidades;

public class Presentacion {

    private int codigo;
    private String presentacion;
    private UnidadMedida unidadMedida;
    private double cantidad;
    private String descripcion;
    private boolean estado;

    @Override
    public String toString() {
        return presentacion + " " + cantidad + " " + unidadMedida.getNombre();
    }

    public String getNombreComple() {
        return presentacion + " " + cantidad + " " + unidadMedida.getNombre();
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double convercion(double num) {
        double aux = 0;
        aux = num / cantidad;
        return aux;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public UnidadMedida getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(UnidadMedida unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

}
