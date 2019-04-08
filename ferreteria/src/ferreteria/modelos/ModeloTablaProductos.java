package ferreteria.modelos;

import entidades.Producto;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModeloTablaProductos extends AbstractTableModel {

    private List<Producto> listaProductos;

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
        this.fireTableDataChanged();
    }

    @Override
    public String getColumnName(int columna) {
        String nombreColumna = "";
        switch (columna) {
            case 0:
                nombreColumna = "NOMBRE";
                break;
            case 1:
                nombreColumna = "CATEGORIA";
                break;
            case 2:
                nombreColumna = "COLOR";
                break;
            case 3:
                nombreColumna = "UNIDAD MEDIDA";
                break;
            case 4:
                nombreColumna = "DESCRIPCION";
                break;
        }
        return nombreColumna;
    }

    @Override
    public int getRowCount() {
        int filas = 0;

        if (this.listaProductos != null) {
            filas = this.listaProductos.size();
        }
        return filas;
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Producto pre;
        Object valor = "";
        if (this.listaProductos != null) {
            pre = this.listaProductos.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    valor = pre.getNombre();
                    break;
                case 1:
                    valor = pre.getCatProd().getNombreCategoria();
                    break;
                case 2:
                    valor = pre.getColor();
                    break;
                case 3:
                    valor = pre.getUnidaMedida().getNombre();
                    break;
                case 4:
                    valor = pre.getDescripcion();
                    break;
            }
        }
        return valor;
    }
}
