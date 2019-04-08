package ferreteria.modelos;

import entidades.CategoriaProducto;
import entidades.Producto;
import entidades.Proveedor;
import entidades.UnidadMedida;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class ModeloComboProducto extends AbstractListModel
        implements ComboBoxModel {

    private Producto seleccionado;
    private List<Producto> listaProductos;

    public Producto getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Producto seleccionado) {
        this.seleccionado = seleccionado;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    @Override
    public int getSize() {
        int cantidad = 0;
        if (this.listaProductos != null) {
            cantidad = this.listaProductos.size();
        }
        return cantidad;
    }

    @Override
    public Object getElementAt(int i) {
        Object dato = null;
        if (this.listaProductos != null) {
            dato = this.listaProductos.get(i).nombreCompleto();
        }
        return dato;
    }

    @Override
    public void setSelectedItem(Object o) {
        this.seleccionado = null;
        if (o != null && this.listaProductos != null) {
            for (Producto u : listaProductos) {
                if (u.nombreCompleto().equals(o.toString()) == true) {
                    this.seleccionado = u;
                    return;
                }
            }
        }
    }

    @Override
    public Object getSelectedItem() {
        String valor = "";
        if (this.seleccionado != null) {
            valor = this.seleccionado.nombreCompleto();
        }
        return valor;
    }

// Este Codigo se AGrega Adicionalmente al de lo modelos
    // El cual devolvera el boton modificar
    public void setProducto(Producto producto) {
        this.seleccionado = null;
        if (producto != null && this.listaProductos != null) {
            for (Producto c : this.listaProductos) {
                if (c.nombreCompleto().equals(producto.nombreCompleto())) {
                    this.seleccionado = c;
                    return;
                }
            }
        }
    }

    public void setProductoCodigo(Producto producto) {
        this.seleccionado = null;
        if (producto != null && this.listaProductos != null) {
            for (Producto c : this.listaProductos) {
                if (c.getCodigo()== producto.getCodigo()) {
                    this.seleccionado = c;
                    return;
                }
            }
        }
    }
}
