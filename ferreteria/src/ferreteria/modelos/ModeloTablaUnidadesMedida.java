package ferreteria.modelos;

import entidades.UnidadMedida;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Omar Guevara
 */
public class ModeloTablaUnidadesMedida extends AbstractTableModel {

    private List<UnidadMedida> listaUnidadesMedida;

    public List<UnidadMedida> getListaUnidadesMedida() {
        return listaUnidadesMedida;
    }

    public void setListaUnidadesMedida(List<UnidadMedida> listaUnidadesMedida) {
        this.listaUnidadesMedida = listaUnidadesMedida;
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
                nombreColumna = "Descripcion";
                break;
        }
        return nombreColumna;
    }

    @Override
    public int getRowCount() {
        int filas = 0;

        if (this.listaUnidadesMedida != null) {
            filas = this.listaUnidadesMedida.size();
        }
        return filas;
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        UnidadMedida unidadMedida;
        Object valor = "";
        if (this.listaUnidadesMedida != null) {
            unidadMedida = this.listaUnidadesMedida.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    valor = unidadMedida.getNombre();
                    break;
                case 1:
                    valor = unidadMedida.getDescripcion();
                    break;
            }
        }
        return valor;
    }
}
