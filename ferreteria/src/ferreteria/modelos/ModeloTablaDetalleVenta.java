package ferreteria.modelos;

import entidades.DetalleProductoPresentaciones;
import entidades.DetalleVenta;
import entidades.Producto;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModeloTablaDetalleVenta extends AbstractTableModel {

    private List<DetalleVenta> listaDetalle;

    public List<DetalleVenta> getListaDetalle() {
        return listaDetalle;
    }

    public void setListaDetalle(List<DetalleVenta> listaDetalle) {
        this.listaDetalle = listaDetalle;
        this.fireTableDataChanged();
    }

    @Override
    public String getColumnName(int columna) {
        String nombreColumna = "";
        switch (columna) {
            case 0:
                nombreColumna = "Nombre Producto";
                break;
            case 1:
                nombreColumna = "Presentacion";
                break;
            case 2:
                nombreColumna = "Cantidad";
                break;
            case 3:
                nombreColumna = "Precio Unitario";
                break;
            case 4:
                nombreColumna = "Precio Total";
                break;

        }
        return nombreColumna;
    }

    @Override
    public int getRowCount() {
        int filas = 0;

        if (this.listaDetalle != null) {
            filas = this.listaDetalle.size();
        }
        return filas;
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        DetalleVenta de;
        Object valor = "";
        if (this.listaDetalle != null) {
            de = this.listaDetalle.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    valor = de.getProducto().getNombre() + " " + de.getProducto().getColor();
                    break;
                case 1:
                    valor = de.getPresentacion().getPresentacion();
                    break;
                case 2:
                    valor = de.getCantidad();
                    break;

                case 3:
                    valor = de.getPrecio();
                    break;

                case 4:
                    valor = de.getPrecioTotal();
                    break;
            }
        }
        return valor;
    }
}
