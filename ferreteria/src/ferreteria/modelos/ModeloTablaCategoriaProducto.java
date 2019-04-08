package ferreteria.modelos;

import entidades.CategoriaProducto;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Omar Guevara
 */
public class ModeloTablaCategoriaProducto extends AbstractTableModel {

    private List<CategoriaProducto> listaCategoriasPro;

    public List<CategoriaProducto> getListaCategoriasPro() {
        return listaCategoriasPro;
    }

    public void setListaCategoriasPro(List<CategoriaProducto> listaCategoriasPro) {
        this.listaCategoriasPro = listaCategoriasPro;
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

        if (this.listaCategoriasPro != null) {
            filas = this.listaCategoriasPro.size();
        }
        return filas;
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        CategoriaProducto catPro;
        Object valor = "";
        if (this.listaCategoriasPro != null) {
            catPro = this.listaCategoriasPro.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    valor = catPro.getNombreCategoria();
                    break;
                case 1:
                    valor = catPro.getDescripcion();
                    break;
            }
        }
        return valor;
    }
}
