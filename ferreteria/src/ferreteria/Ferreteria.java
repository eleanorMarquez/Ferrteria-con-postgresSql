package ferreteria;

import entidades.Usuario;

public class Ferreteria {

    public static String mensajeError = "Error de conexion";
    public static String mensajeAdvertencia = "Seleccione un elemento";
    public static String mensajeEliminar = "¿Estas seguro de eliminar elemento?";
    public static String mensajeActualizar = "Actualizacion correcta";
    public static String mensajeTitulo = "Mensaje";
    public static String mensajeElementoRepetido = "Este elemento ya existe";
    public static String mensajeCorrecto = "REGISTRO EXITOSO";
    public static String mensajeErrorReporte = "ERROR AL CREAR EL REPORTE";
    public static String mensajeContraseña = "LAS CONTRASEÑAS NO SON LAS MISMAS";
    public static String mensajeSalirSistema = "¿ESTAS SEGURO DE SALIR DE SISTEMA?";

    public static Usuario us;

    public static void main(String[] args) {

        try {

            JFInicio inicio = new JFInicio();
            inicio.setVisible(true);
            inicio.setLocationRelativeTo(null);

            
            
            
        } catch (Exception e) {
            MetodosFunciones.mensajeError(Ferreteria.mensajeError + "\n" + e.getMessage(), Ferreteria.mensajeTitulo);
        }
    }

}
