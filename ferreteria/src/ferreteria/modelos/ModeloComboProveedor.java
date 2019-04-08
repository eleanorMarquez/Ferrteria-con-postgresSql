package ferreteria.modelos;

import entidades.CategoriaProducto;
import entidades.Proveedor;
import entidades.UnidadMedida;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class ModeloComboProveedor extends AbstractListModel
        implements ComboBoxModel {

    private Proveedor seleccionado;
    private List<Proveedor> listaProveedores;

    public Proveedor getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Proveedor seleccionado) {
        this.seleccionado = seleccionado;
    }

    public List<Proveedor> getListaProveedores() {
        return listaProveedores;
    }

    public void setListaProveedores(List<Proveedor> listaProveedores) {
        this.listaProveedores = listaProveedores;
    }



    
    @Override
    public int getSize() {
        int cantidad = 0;
        if (this.listaProveedores != null) {
            cantidad = this.listaProveedores.size();
        }
        return cantidad;
    }

    @Override
    public Object getElementAt(int i) {
        Object dato = null;
        if (this.listaProveedores != null) {
            dato = this.listaProveedores.get(i).getNombre();
        }
        return dato;
    }

    @Override
    public void setSelectedItem(Object o) {
        this.seleccionado = null;
        if (o != null && this.listaProveedores != null) {
            for (Proveedor u : listaProveedores) {
                if (u.getNombre().equals(o.toString()) == true) {
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
            valor = this.seleccionado.getNombre();
        }
        return valor;
    }

// Este Codigo se AGrega Adicionalmente al de lo modelos
    // El cual devolvera el boton modificar
    public void setProveedor(Proveedor proveedor) {
        this.seleccionado = null;
        if (proveedor != null && this.listaProveedores != null) {
            for (Proveedor c : this.listaProveedores) {
                if (c.getNombre().equals(proveedor.getNombre())) {
                    this.seleccionado = c;
                    return;
                }
            }
        }
    }

    public void setUnidadMedidaCodigo(Proveedor proveedor) {
        this.seleccionado = null;
        if (proveedor != null && this.listaProveedores != null) {
            for (Proveedor c : this.listaProveedores) {
                if (c.getCodigo()== proveedor.getCodigo()) {
                    this.seleccionado = c;
                    return;
                }
            }
        }
    }
}
