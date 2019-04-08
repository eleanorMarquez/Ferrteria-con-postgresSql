package ferreteria.modelos;

import entidades.Producto;
import entidades.Proveedor;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModeloTablaProveedor extends AbstractTableModel {

    private List<Proveedor> listaProveedores;

    public List<Proveedor> getListaProveedores() {
        return listaProveedores;
    }

    public void setListaProveedores(List<Proveedor> listaProveedores) {
        this.listaProveedores = listaProveedores;
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
                nombreColumna = "Ruc";
                break;
            case 2:
                nombreColumna = "Direccion";
                break;
        }
        return nombreColumna;
    }

    @Override
    public int getRowCount() {
        int filas = 0;

        if (this.listaProveedores != null) {
            filas = this.listaProveedores.size();
        }
        return filas;
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Proveedor pro;
        Object valor = "";
        if (this.listaProveedores != null) {
            pro = this.listaProveedores.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    valor = pro.getNombre();
                    break;
                case 1:
                    valor = pro.getRuc();
                    break;
                case 2:
                    valor = pro.getDireccion();
                    break;
            }
        }
        return valor;
    }
}
