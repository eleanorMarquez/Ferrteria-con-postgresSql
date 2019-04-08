package ferreteria.modelos;

import entidades.CategoriaProducto;
import entidades.UnidadMedida;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class ModeloComboCategoria extends AbstractListModel
        implements ComboBoxModel {

    private CategoriaProducto seleccionado;
    private List<CategoriaProducto> listaCategorias;

    public CategoriaProducto getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(CategoriaProducto seleccionado) {
        this.seleccionado = seleccionado;
    }

    public List<CategoriaProducto> getListaCategorias() {
        return listaCategorias;
    }

    public void setListaCategorias(List<CategoriaProducto> listaCategorias) {
        this.listaCategorias = listaCategorias;
    }

    
    @Override
    public int getSize() {
        int cantidad = 0;
        if (this.listaCategorias != null) {
            cantidad = this.listaCategorias.size();
        }
        return cantidad;
    }

    @Override
    public Object getElementAt(int i) {
        Object dato = null;
        if (this.listaCategorias != null) {
            dato = this.listaCategorias.get(i).getNombreCategoria();
        }
        return dato;
    }

    @Override
    public void setSelectedItem(Object o) {
        this.seleccionado = null;
        if (o != null && this.listaCategorias != null) {
            for (CategoriaProducto u : listaCategorias) {
                if (u.getNombreCategoria().equals(o.toString()) == true) {
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
            valor = this.seleccionado.getNombreCategoria();
        }
        return valor;
    }

// Este Codigo se AGrega Adicionalmente al de lo modelos
    // El cual devolvera el boton modificar
    public void setUnidadMedida(UnidadMedida unidadMedida) {
        this.seleccionado = null;
        if (unidadMedida != null && this.listaCategorias != null) {
            for (CategoriaProducto c : this.listaCategorias) {
                if (c.getNombreCategoria().equals(unidadMedida.getNombre())) {
                    this.seleccionado = c;
                    return;
                }
            }
        }
    }

    public void setUnidadMedidaCodigo(CategoriaProducto cat) {
        this.seleccionado = null;
        if (cat != null && this.listaCategorias != null) {
            for (CategoriaProducto c : this.listaCategorias) {
                if (c.getCodigo()== cat.getCodigo()) {
                    this.seleccionado = c;
                    return;
                }
            }
        }
    }
}
