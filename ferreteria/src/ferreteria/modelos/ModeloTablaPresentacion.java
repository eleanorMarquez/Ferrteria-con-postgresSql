package ferreteria.modelos;

import entidades.Presentacion;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Omar Guevara
 */
public class ModeloTablaPresentacion extends AbstractTableModel {

    private List<Presentacion> listaPresentaciones;

    public List<Presentacion> getListaPresentaciones() {
        return listaPresentaciones;
    }

    public void setListaPresentaciones(List<Presentacion> listaPresentaciones) {
        this.listaPresentaciones = listaPresentaciones;
        this.fireTableDataChanged();
    }

    @Override
    public String getColumnName(int columna) {
        String nombreColumna = "";
        switch (columna) {
            case 0:
                nombreColumna = "Nombre";
                break;
            case 1:
                nombreColumna = "Cantidad";
                break;
            case 2:
                nombreColumna = "Unidad Medida";
                break;
            case 3:
                nombreColumna = "Descripcion";
                break;
        }
        return nombreColumna;
    }

    @Override
    public int getRowCount() {
        int filas = 0;

        if (this.listaPresentaciones != null) {
            filas = this.listaPresentaciones.size();
        }
        return filas;
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Presentacion presentacion;
        Object valor = "";
        if (this.listaPresentaciones != null) {
            presentacion = this.listaPresentaciones.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    valor = presentacion.getPresentacion();
                    break;
                case 1:
                    valor = presentacion.getCantidad();
                    break;
                case 2:
                    valor = presentacion.getUnidadMedida().getNombre();
                    break;
                case 3:
                    valor = presentacion.getDescripcion();
                    break;
            }
            
        }
        return valor;
    }
}
