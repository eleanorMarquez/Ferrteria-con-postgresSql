package ferreteria.modelos;

import entidades.CategoriaProducto;
import entidades.UnidadMedida;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class ModeloComboUnidadMedida extends AbstractListModel
        implements ComboBoxModel {

    private UnidadMedida seleccionado;
    private List<UnidadMedida> listaUnidadMedida;

    public UnidadMedida getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(UnidadMedida seleccionado) {
        this.seleccionado = seleccionado;
    }

    public List<UnidadMedida> getListaUnidadMedida() {
        return listaUnidadMedida;
    }

    public void setListaUnidadMedida(List<UnidadMedida> listaUnidadMedida) {
        this.listaUnidadMedida = listaUnidadMedida;
    }


    
    @Override
    public int getSize() {
        int cantidad = 0;
        if (this.listaUnidadMedida != null) {
            cantidad = this.listaUnidadMedida.size();
        }
        return cantidad;
    }

    @Override
    public Object getElementAt(int i) {
        Object dato = null;
        if (this.listaUnidadMedida != null) {
            dato = this.listaUnidadMedida.get(i).getNombre();
        }
        return dato;
    }

    @Override
    public void setSelectedItem(Object o) {
        this.seleccionado = null;
        if (o != null && this.listaUnidadMedida != null) {
            for (UnidadMedida u : listaUnidadMedida) {
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
    public void setUnidadMedida(UnidadMedida unidadMedida) {
        this.seleccionado = null;
        if (unidadMedida != null && this.listaUnidadMedida != null) {
            for (UnidadMedida c : this.listaUnidadMedida) {
                if (c.getNombre().equals(unidadMedida.getNombre())) {
                    this.seleccionado = c;
                    return;
                }
            }
        }
    }

    public void setUnidadMedidaCodigo(UnidadMedida unidadMedida) {
        this.seleccionado = null;
        if (unidadMedida != null && this.listaUnidadMedida != null) {
            for (UnidadMedida c : this.listaUnidadMedida) {
                if (c.getCodigo()== unidadMedida.getCodigo()) {
                    this.seleccionado = c;
                    return;
                }
            }
        }
    }
}
