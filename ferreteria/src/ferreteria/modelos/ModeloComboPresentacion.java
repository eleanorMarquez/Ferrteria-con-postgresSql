package ferreteria.modelos;

import entidades.CategoriaProducto;
import entidades.Presentacion;
import entidades.UnidadMedida;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class ModeloComboPresentacion extends AbstractListModel
        implements ComboBoxModel {

    private Presentacion seleccionado;
    private List<Presentacion> listaPresentaciones;

    public Presentacion getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Presentacion seleccionado) {
        this.seleccionado = seleccionado;
    }

    public List<Presentacion> getListaPresentaciones() {
        return listaPresentaciones;
    }

    public void setListaPresentaciones(List<Presentacion> listaPresentaciones) {
        this.listaPresentaciones = listaPresentaciones;
    }

 

    
    @Override
    public int getSize() {
        int cantidad = 0;
        if (this.listaPresentaciones != null) {
            cantidad = this.listaPresentaciones.size();
        }
        return cantidad;
    }

    @Override
    public Object getElementAt(int i) {
        Object dato = null;
        if (this.listaPresentaciones != null) {
            dato = this.listaPresentaciones.get(i).getNombreComple();
        }
        return dato;
    }

    @Override
    public void setSelectedItem(Object o) {
        this.seleccionado = null;
        if (o != null && this.listaPresentaciones != null) {
            for (Presentacion u : listaPresentaciones) {
                if (u.getNombreComple().equals(o.toString()) == true) {
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
            valor = this.seleccionado.getNombreComple();
        }
        return valor;
    }

// Este Codigo se AGrega Adicionalmente al de lo modelos
    // El cual devolvera el boton modificar
    public void setPresentacion(Presentacion pre) {
        this.seleccionado = null;
        if (pre != null && this.listaPresentaciones != null) {
            for (Presentacion c : this.listaPresentaciones) {
                if (c.getNombreComple().equals(pre.getNombreComple())) {
                    this.seleccionado = c;
                    return;
                }
            }
        }
    }

    public void setPresentacionCodigo(Presentacion pre) {
        this.seleccionado = null;
        if (pre != null && this.listaPresentaciones != null) {
            for (Presentacion c : this.listaPresentaciones) {
                if (c.getCodigo()== pre.getCodigo()) {
                    this.seleccionado = c;
                    return;
                }
            }
        }
    }
}
