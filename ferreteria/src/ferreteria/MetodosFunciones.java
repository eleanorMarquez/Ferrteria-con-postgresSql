package ferreteria;

//import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDateChooser;
import java.awt.AWTKeyStroke;
import java.awt.Component;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat.Field;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.HashSet;
import java.util.Set;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;
import javax.swing.text.MaskFormatter;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author OmarGuevara
 * @version 1.1 primera vercion de metodo para validaciones
 */
public class MetodosFunciones {

//     
    /**
     * Para la siguiente vercion se puede hacer unas validaciones usando como
     * parametro la clases y con class
     *
     * @author Darwin Omar Guevara Diaz
     * @version 1.1
     *
     * @param componetes
     * @param estado
     */
    private String mascara = "";

    public static void activarControles(JComponent componetes, boolean estado) {
        Component[] contenedor = componetes.getComponents();
        for (int i = 0; i < contenedor.length; i++) {
            if (contenedor[i] instanceof JTextField
                    || contenedor[i] instanceof JLabel
                    || contenedor[i] instanceof JButton
                    || contenedor[i] instanceof JTable
                    || contenedor[i] instanceof JCheckBox
                    || contenedor[i] instanceof JTextComponent
                    || contenedor[i] instanceof JSpinner
                    || contenedor[i] instanceof JDateChooser
                    || contenedor[i] instanceof JComboBox) {
                contenedor[i].setEnabled(estado);
            }
        }
    }

    public static void activarLimpiarControles(JComponent componetes, boolean estado) {
        Component[] contenedor = componetes.getComponents();
        Component aux;
        for (int i = 0; i < contenedor.length; i++) {
            if (contenedor[i] instanceof JTextField
                    || contenedor[i] instanceof JLabel
                    || contenedor[i] instanceof JButton
                    || contenedor[i] instanceof JCheckBox
                    || contenedor[i] instanceof JRadioButton
                    || contenedor[i] instanceof JSpinner
                    || contenedor[i] instanceof JDateChooser
                    || contenedor[i] instanceof JTextComponent
                    || contenedor[i] instanceof JComboBox) {

                contenedor[i].setEnabled(estado);

                if (contenedor[i] instanceof JTextField) {
                    aux = contenedor[i];
                    ((JTextField) aux).setText("");
                }
                if (contenedor[i] instanceof JComboBox) {
                    aux = contenedor[i];
                    ((JComboBox) aux).setSelectedIndex(-1);
                }
                if (contenedor[i] instanceof JCheckBox) {
                    aux = contenedor[i];
                    ((JCheckBox) aux).setSelected(false);
                }
                if (contenedor[i] instanceof JRadioButton) {
                    aux = contenedor[i];
                    ((JRadioButton) aux).setSelected(false);
                }
                if (contenedor[i] instanceof JDateChooser) {
                    aux = contenedor[i];
                    ((JDateChooser) aux).setDate(null);
                }
            }
        }
    }

    /**
     * Es JOptionPane.showMessageDialog que muestra el mensaje de informacion
     *
     * @param mensaje mensaje a mostrar
     * @param titulo el titulo del mensaje
     */
    public static void mensajeInformacion(String mensaje, String titulo) {
        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Es JOptionPane.showMessageDialog que muestra el mensaje de error
     *
     * @param mensaje mensaje a mostrar
     * @param titulo el titulo del mensaje
     */
    public static void mensajeError(String mensaje, String titulo) {
        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Es JOptionPane.showMessageDialog que muestra el mensaje de advertencia
     *
     * @param mensaje mensaje a mostrar
     * @param titulo el titulo del mensaje
     */
    public static void mensajeAdvertencia(String mensaje, String titulo) {
        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.WARNING_MESSAGE);
    }

    /**
     * Es JOptionPane.showMessageDialog que muestra el mensaje de confirmacion
     *
     * @param mensaje mensaje a mostrar
     * @param titulo el titulo del mensaje
     * @return me retonra un valor entero segun la opcion que se marque
     */
    public static int mensajeConfirmacion(String mensaje, String titulo) {
        return JOptionPane.showConfirmDialog(null, mensaje, titulo, JOptionPane.QUESTION_MESSAGE);
    }

    /**
     * Este metodo permito ingresar solo numero, segun el tamaño que se le
     * especifique
     *
     * @param txt este el el objeto (la caja de texto),
     * @param numeroCaracteres este el numeor maximo caracteres que tendra la
     */
    public static void soloNumeros(JTextField txt, int numeroCaracteres) {
        txt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                char car = evt.getKeyChar();
                if (car < '0' || car > '9') { // numero que estan entre  0-9
                    evt.consume();
                }

                if (numeroCaracteres > 0) {
                    if (txt.getText().length() == numeroCaracteres) {
                        evt.consume();
                    }
                }
            }
        });
    }

    /**
     * Este metodo solo acepta numero con decimales y al mismo tiempo limita el
     * tamaño de caracteres, este metodo solo presenta un problema de validacion
     * la cual es la siguiente: si introducimos el numero .0123 en ese caso solo
     * en ese caso me saldria un error, dado que no cuenta con un numero antes
     * del punto, pero para esto lo valido ya desde el formulario
     *
     * @param txt este el el objeto (la caja de texto),
     * @param numeroCaracteres este el numeor maximo caracteres que tendra la
     */
    public static void soloNumerosDecimales(JTextField txt, int numeroCaracteres) {

        txt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                char c = evt.getKeyChar();
                if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != '.')) {
                    evt.consume();
                }
                if (c == '.' && txt.getText().contains(".")) {
                    evt.consume();
                }

                if (numeroCaracteres > 0) {
                    if (txt.getText().length() == numeroCaracteres) {
                        evt.consume();
                    }
                }
            }
        });
    }

    /**
     * Este metodo permite ingresar solo letras y numeros, segun el tamaño que
     * se le especifique
     *
     * @param txt este el el objeto (la caja de texto),
     * @param numeroCaracteres este el numeor maximo caracteres que tendra la
     */
    public static void soloLetrasNumeros(JTextField txt, int numeroCaracteres) {
        txt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ((c < 'a' || c > 'z')
                        && (c < 'A' || c > 'Z')
                        && (c < '0' || c > '9')
                        && c != 'á' //Minúsculas
                        && c != 'é'
                        && c != 'í'
                        && c != 'ó'
                        && c != 'ú'
                        && c != 'Á' //Mayúsculas
                        && c != 'É'
                        && c != 'Í'
                        && c != 'Ó'
                        && c != 'Ú'
                        && (c != (char) e.VK_SPACE)) {
                    e.consume(); //evita que se escriba el caracter
                }
                if (numeroCaracteres > 0) {
                    if (txt.getText().length() == numeroCaracteres) {
                        e.consume();
                    }
                }
            }
        });
    }

    /**
     * Este metodo permite ingresar solo letras, segun el tamaño que se le
     * especifique
     *
     * @param txt este el el objeto (la caja de texto),
     * @param numeroCaracteres este el numeor maximo caracteres que tendra la
     */
    public static void soloLetras(JTextField txt, int numeroCaracteres) {
        txt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ((c < 'a' || c > 'z')
                        && (c < 'A' || c > 'Z')
                        && c != 'á' //Minúsculas
                        && c != 'é'
                        && c != 'í'
                        && c != 'ó'
                        && c != 'ú'
                        && c != 'Á' //Mayúsculas
                        && c != 'É'
                        && c != 'Í'
                        && c != 'Ó'
                        && c != 'Ú'
                        && (c != (char) e.VK_SPACE)) {
                    e.consume(); //evita que se escriba el caracter
                }
                if (numeroCaracteres > 0) {
                    if (txt.getText().length() == numeroCaracteres) {
                        e.consume();
                    }
                }
            }
        });
    }

//    public static String formatearNumero(double numero) {
//        DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
//        simbolos.setDecimalSeparator('.');
//        simbolos.setGroupingSeparator(',');
//        DecimalFormat formato = new DecimalFormat("###,###.00", simbolos);
//        return formato.format(numero);
//    }

    public static String formatearNumero2(double numero) {
        DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
        simbolos.setDecimalSeparator('.');
//        simbolos.setGroupingSeparator(',');
        DecimalFormat formato = new DecimalFormat("########.00", simbolos);
        return formato.format(numero);
    }

    /**
     * Este metodo permieto validar la entrada de cajas de texto de tamaños
     * fijos como por ejemplos: ruc,telefono, celular, dni
     *
     * @param op op 1: ruc op 2: fechas op 3: telefono fijo op 4: Celular op 5:
     * Dni
     * @return mascara que se definina, segun como se quiera trabajar
     * setPlaceholderCharacter este pone al - como de fondo hasta que se escriba
     * algo se instanciara de esta manera
     * this.formateedTextFiel.setFormatterFactory(new
     * DefaultFormatterFactory(Formateador.validarNumeros())); desde el
     * formulario (constructor del frm) # Un número ? Una letra A Una letra o un
     * número Cualquier cosa U Una letra que será pasada a mayúscula L Unaletra
     * que será pasada a minúscula H Un dígito hexadecimal (A-F, a-f, 0-9) '
     * Carácter de escape para otro caràcter de máscara
     */
    public static MaskFormatter validarEntradas(int op) {
        MaskFormatter mascara = null;
        try {
            switch (op) {
                case 1:
//                    ruc
                    mascara = new MaskFormatter("###########");
                    break;
                case 2:
//                    Fechas
                    mascara = new MaskFormatter("##/##/####");
                    break;
                case 3:
//                    Telefono Fijo
                    mascara = new MaskFormatter("(##) ## ## ##");
//                    mascara.setValidCharacters("0123456789");
                    break;
                case 4:
//                    Celular 
                    mascara = new MaskFormatter("### ### ###");
                    break;
                case 5:
//                    Dni
                    mascara = new MaskFormatter("########");
                    break;
            }
        } catch (ParseException erro) {
        }
        return mascara;
    }

//        public static void soloNumerosDecimal(KeyEvent evt, JTextField objTexto, int numeroCaracteres){
//        char car = evt.getKeyChar();
//        if((car<'0' || car>'9') && car!='.') evt.consume();
//        
//        if (numeroCaracteres > 0){
//            if(objTexto.getText() .length()==numeroCaracteres) evt.consume();
//        }
//        
//    }
    /**
     * Con este metodo podre utilizar las fechas para poder navegar libremente
     * sobre los txtx
     *
     * @param objContenedor el contenedo (panel donde se encuentran los txt)
     *
     */
    public static void navegar(Container objContenedor) {

        Set<AWTKeyStroke> teclas = new HashSet<AWTKeyStroke>();
        Set<AWTKeyStroke> teclas2 = new HashSet<AWTKeyStroke>();

        teclas.add(AWTKeyStroke.getAWTKeyStroke(
                java.awt.event.KeyEvent.VK_ENTER, 0));

        teclas.add(AWTKeyStroke.getAWTKeyStroke(
                java.awt.event.KeyEvent.VK_TAB, 0));

        teclas.add(AWTKeyStroke.getAWTKeyStroke(
                java.awt.event.KeyEvent.VK_DOWN, 0));

        teclas2.add(AWTKeyStroke.getAWTKeyStroke(
                java.awt.event.KeyEvent.VK_UP, 0));

        // Se pasa el conjunto de teclas al panel principal
        objContenedor.setFocusTraversalKeys(
                KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS,
                teclas);

        objContenedor.setFocusTraversalKeys(
                KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS,
                teclas2);

    }

//    public static void imprimirNombreAtributos(Trabajador trab) {
//        java.lang.reflect.Field[] fields = Trabajador.class.getDeclaredFields();
//        //Recorrer cada uno de los Campos en el Array
//        //e imprimir su Nombre
//        for (java.lang.reflect.Field f : fields) {
//            System.out.println(f.getName());
//        }
//    }
    public static BigDecimal redondearNumero(double numero, int numeroDecimales) {
        BigDecimal big = new BigDecimal(numero);
        big = big.setScale(numeroDecimales, RoundingMode.HALF_UP);
        return big;
    }

    public static double redondearNumeros(float numero, int numeroDecimales) {
        int aux = 10;
        try {

            if (numeroDecimales >= 1) {
                switch (numeroDecimales) {
                    case 1:
                        aux = 10;
                        return Math.rint(numero * aux) / aux;
                    case 2:
                        aux = 100;
                        return Math.rint(numero * aux) / aux;
                    case 3:
                        aux = 1000;
                        return Math.rint(numero * aux) / aux;
                    case 4:
                        aux = 10000;
                        return Math.rint(numero * aux) / aux;
                    default:
                        return Math.rint(numero * aux) / aux;
                }
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
        return Math.rint(numero * aux) / aux;
    }

    public static void autoCompletarNumeros(JTextField txtObjeto, int longitud) {
        String formato = "000000000000000000000000000";
        String nroAutoCompletar = formato + txtObjeto.getText();
        nroAutoCompletar = nroAutoCompletar.substring(nroAutoCompletar.length() - longitud);
        txtObjeto.setText(nroAutoCompletar);
    }

//  private void fonfoImagen() {
//        ((JPanel) getContentPane()).setOpaque(fal­se);
//        ImageIcon uno = new ImageIcon(this.getClass().getResource("../recursos/fondoinicio.jpg"));
//        JLabel fondo = new JLabel();
//        fondo.setIcon(uno);
//        getLayeredPane().add(fondo, JLayeredPane.FRAME_CONTENT_LAYER);
//        fondo.setBounds(0, 0, uno.getIconWidth(), u­no.getIconHeight());
//    }

}

//esto para la base de datos en postgres
//SELECT  current_date
//SELECT  current_time
//SELECT  now()
//SELECT  now()::date
//SELECT  now()::time
//  private void esxportarExcel() throws Exception{
//           try {
//
//            /*La ruta donde se creará el archivo*/
//            String rutaArchivo = System.getProperty("user.home") + "/ejemploExcelJava.xls";
//            /*Se crea el objeto de tipo File con la ruta del archivo*/
//            File archivoXLS = new File(rutaArchivo);
//            /*Si el archivo existe se elimina*/
//            if (archivoXLS.exists()) {
//                archivoXLS.delete();
//            }
//            /*Se crea el archivo*/
//            archivoXLS.createNewFile();
//
//            /*Se crea el libro de excel usando el objeto de tipo Workbook*/
//            Workbook libro = new HSSFWorkbook();
//            /*Se inicializa el flujo de datos con el archivo xls*/
//            FileOutputStream archivo = new FileOutputStream(archivoXLS);
//
//            /*Utilizamos la clase Sheet para crear una nueva hoja de trabajo dentro del libro que creamos anteriormente*/
//            Sheet hoja = libro.createSheet("Mi hoja de trabajo 1");
//
//            /*Hacemos un ciclo para inicializar los valores de 10 filas de celdas*/
//            for (int f = 0; f < 10; f++) {
//                /*La clase Row nos permitirá crear las filas*/
//                Row fila = hoja.createRow(f);
//
//                /*Cada fila tendrá 5 celdas de datos*/
//                for (int c = 0; c < 5; c++) {
//                    /*Creamos la celda a partir de la fila actual*/
//                    Cell celda = fila.createCell(c);
//
//                    /*Si la fila es la número 0, estableceremos los encabezados*/
//                    if (f == 0) {
//                        celda.setCellValue("Encabezado #" + c);
//                    } else {
//                        /*Si no es la primera fila establecemos un valor*/
//                        celda.setCellValue("Valor celda " + c + "," + f);
////                        celda.setCellValue(t.getC);
//                        
//                    }
//                }
//            }
//
//            /*Escribimos en el libro*/
//            libro.write(archivo);
//            /*Cerramos el flujo de datos*/
//            archivo.close();
//            /*Y abrimos el archivo con la clase Desktop*/
//            Desktop.getDesktop().open(archivoXLS);
//        } catch (Exception e) {
//            throw e; 
//        }
//    }
//    
//    

