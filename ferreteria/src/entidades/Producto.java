package entidades;

public class Producto {

    private int codigo;
    private String nombre;
    private CategoriaProducto catProd;
    private Presentacion pre;
    private String color;
    private String descripcion;
    private UnidadMedida unidaMedida;
    private boolean estado;

    
    public UnidadMedida getUnidaMedida() {
        return unidaMedida;
    }

    public void setUnidaMedida(UnidadMedida unidaMedida) {
        this.unidaMedida = unidaMedida;
    }

    
    public String nombreCompleto() {
        return nombre + " " + color;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public CategoriaProducto getCatProd() {
        return catProd;
    }

    public void setCatProd(CategoriaProducto catProd) {
        this.catProd = catProd;
    }

    public Presentacion getPre() {
        return pre;
    }

    public void setPre(Presentacion pre) {
        this.pre = pre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
