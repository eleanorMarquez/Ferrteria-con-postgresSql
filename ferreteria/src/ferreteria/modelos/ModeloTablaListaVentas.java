package ferreteria.modelos;

import entidades.Venta;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Omar Guevara
 */

public class ModeloTablaListaVentas extends AbstractTableModel {

    private List<Venta> listaVentas;

    public List<Venta> getListaVentas() {
        return listaVentas;
    }

    public void setListaVentas(List<Venta> listaVentas) {
        this.listaVentas = listaVentas;
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

        if (this.listaVentas != null) {
            filas = this.listaVentas.size();
        }
        return filas;
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Venta venta;
        Object valor = "";
        if (this.listaVentas != null) {
            venta = this.listaVentas.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    valor = venta.getSerie();
                    break;
                case 1:
                    valor = venta.getNumero();
                    break;
                case 2:
                    valor = venta.getTipoVenta().getNombre();
                    break;
            }
            
        }
        return valor;
    }
}
