package ferreteria.modelos;

import entidades.Compra;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Omar Guevara
 */

public class ModeloTablaListaCompras extends AbstractTableModel {

    private List<Compra> listaCompra;

    public List<Compra> getListaCompra() {
        return listaCompra;
    }

    public void setListaCompra(List<Compra> listaCompra) {
        this.listaCompra = listaCompra;
        this.fireTableDataChanged();
    }

    

    @Override
    public String getColumnName(int columna) {
        String nombreColumna = "";
        switch (columna) {
            case 0:
                nombreColumna = "Numero de Serie";
                break;
            case 1:
                nombreColumna = "Numero Factura/Boleta";
                break;
            case 2:
                nombreColumna = "Tipo";
                break;

        }
        return nombreColumna;
    }

    @Override
    public int getRowCount() {
        int filas = 0;

        if (this.listaCompra != null) {
            filas = this.listaCompra.size();
        }
        return filas;
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Compra compra;
        Object valor = "";
        if (this.listaCompra != null) {
            compra = this.listaCompra.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    valor = compra.getSerie();
                    break;
                case 1:
                    valor = compra.getNumeroFactura();
                    break;
                case 2:
                    valor = compra.getTipoCompra().getNombre();
                    break;
            }
            
        }
        return valor;
    }
}
