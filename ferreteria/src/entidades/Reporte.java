package entidades;

import dao.DAOPostgres;
import dao.Parametro;
import ferreteria.Ferreteria;
import ferreteria.MetodosFunciones;
import java.io.File;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Reporte {

    public void generarReporte(String nombreArchivo) {
        DAOPostgres dao = new DAOPostgres();
        Connection cn = dao.getConexionReporte();
        String ubicacionReporte;
        try {
            ubicacionReporte = System.getProperty("user.dir") + "/src/reportes/" + nombreArchivo;
            JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(ubicacionReporte);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, cn);
            JasperViewer view = new JasperViewer(jasperPrint, false);
            view.setVisible(true);
        } catch (Exception e) {
            MetodosFunciones.mensajeError(Ferreteria.mensajeErrorReporte + "\n" + e.getMessage(), Ferreteria.mensajeTitulo);
        }
    }

    /**
     * @param nombreArchivo hace referencia a archivos jasper
     * @param listaParametro es la lista de parametro que se van a ingresar, el
     * pimer lavlor es el nombre del archivo y el siguente valor es el valor que
     * se le enviara
     */
    public void generarReporteParametro(String nombreArchivo, List<Parametro> listaParametro) {
        DAOPostgres dao = new DAOPostgres();
        Connection cn = dao.getConexionReporte();
        String ubicacionReporte;
        File fichero = null;
        Map param;
        param = new HashMap();
        try {
            ubicacionReporte = System.getProperty("user.dir") + "/src/reportes/" + nombreArchivo;
            fichero = new File(ubicacionReporte); 
            if (fichero.exists()==true) {
                JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(ubicacionReporte);
                if (listaParametro != null) {
                    for (Parametro par : listaParametro) {
                        param.put(par.getNombre(), par.getValor());
                    }
                } else {
                    param = null;
                }
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, param, cn);
                JasperViewer view = new JasperViewer(jasperPrint, false);
                view.setVisible(true);
            } else {
                MetodosFunciones.mensajeAdvertencia(Ferreteria.mensajeErrorReporte + "\n" + " NO EXISTE EL ARCHIVO", Ferreteria.mensajeTitulo);
            }
        } catch (Exception e) {
            MetodosFunciones.mensajeError(Ferreteria.mensajeErrorReporte + "\n" + e.getMessage(), Ferreteria.mensajeTitulo);
        }
    }
}
