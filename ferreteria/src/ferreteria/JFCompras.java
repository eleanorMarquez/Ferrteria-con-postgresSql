package ferreteria;

import dao.DAOCompra;
import dao.DAOProducto;
import dao.DAOProductoPresentacion;
import dao.DAOProveedor;
import dao.DAOTipoVenta;
import entidades.Compra;
import entidades.DetalleProductoPresentaciones;
import entidades.Presentacion;
import entidades.Producto;
import entidades.TipoVentaCompra;
import ferreteria.modelos.ModeloComboPresentacion;
import ferreteria.modelos.ModeloComboProducto;
import ferreteria.modelos.ModeloComboProveedor;
import ferreteria.modelos.ModeloTablaDetalleCompra;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author OmarGuevara
 */
public class JFCompras extends javax.swing.JFrame {

    ModeloComboProveedor mcp = new ModeloComboProveedor();
    ModeloComboProducto mcpr = new ModeloComboProducto();
    ModeloComboPresentacion mcpre = new ModeloComboPresentacion();
    ModeloTablaDetalleCompra mtde = new ModeloTablaDetalleCompra();
    DAOProveedor daoPro = new DAOProveedor();
    DAOProducto daoProducto = new DAOProducto();
    List<DetalleProductoPresentaciones> listaDetalle = new ArrayList<>();
    List<Presentacion> listaPresentacion = new ArrayList<>();
    DAOTipoVenta daoTipoCompra = new DAOTipoVenta();

    public JFCompras() {
        initComponents();
        cargarProveedor();
        validarControles();
        cargarTipoVenta();
    }

    private void cargarTipoVenta() {
        try {
            this.cbTipoCompra.setModel(new DefaultComboBoxModel(daoTipoCompra.listaTipoVenta(true).toArray()));
//            this.cbTipoCompra.setSelectedIndex(-1);
        } catch (Exception e) {
            MetodosFunciones.mensajeError(Ferreteria.mensajeError + "\n" + e.getMessage(), Ferreteria.mensajeTitulo);
        }
    }

    private void validarControles() {
        MetodosFunciones.soloNumeros(this.txtSerie, 5);
        MetodosFunciones.soloNumeros(this.txtNumero, 10);
        MetodosFunciones.soloNumerosDecimales(this.txtCantidad, 10);
        MetodosFunciones.soloNumerosDecimales(this.txtPrecio, 10);
    }

    private void cargarProveedor() {
        try {
            this.mcp.setListaProveedores(daoPro.listaProveedores(true));
            this.mcpr.setListaProductos(daoProducto.listaProductoss(true));
            AutoCompleteDecorator.decorate(this.cbProveedor);
            AutoCompleteDecorator.decorate(this.cbProducto);
            this.jdFecha.setDate(Calendar.getInstance().getTime());
        } catch (Exception e) {
            MetodosFunciones.mensajeError(Ferreteria.mensajeError + "" + e.getMessage(), Ferreteria.mensajeTitulo);
        }
    }

    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooserDialog1 = new datechooser.beans.DateChooserDialog();
        pnlDatos = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jdFecha = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        txtSerie = new javax.swing.JTextField();
        labelTask1 = new org.edisoncor.gui.label.LabelTask();
        txtNumero = new javax.swing.JTextField();
        cbProveedor = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        cbTipoCompra = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        pnlDatos1 = new javax.swing.JPanel();
        cbProducto = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        txtCantidad = new javax.swing.JTextField();
        cbPresentacion = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        txtSubTotal = new javax.swing.JTextField();
        txtIgv = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        pnlDatos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel2.setText("PROVEEDOR");

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel6.setText("FECHA");

        jdFecha.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jdFecha.setNextFocusableComponent(cbProducto);
        jdFecha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jdFechaFocusLost(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel4.setText("N° FACTURA");

        txtSerie.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        txtSerie.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSerieFocusLost(evt);
            }
        });

        labelTask1.setText("GESTION DE COMPRAS - FERRETERIA SEÑOR DE LOS MILAGROS");
        labelTask1.setDescription("Telefono: 98456123 \nE-mail: livia@live.com\n\n");

        txtNumero.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        txtNumero.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNumeroFocusLost(evt);
            }
        });

        cbProveedor.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        cbProveedor.setModel(this.mcp);
        cbProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbProveedorActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel3.setText("TIPO");

        cbTipoCompra.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        cbTipoCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoCompraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDatosLayout = new javax.swing.GroupLayout(pnlDatos);
        pnlDatos.setLayout(pnlDatosLayout);
        pnlDatosLayout.setHorizontalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cbProveedor, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addComponent(txtSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(cbTipoCompra, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jdFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(138, 138, 138))
            .addComponent(labelTask1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlDatosLayout.setVerticalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDatosLayout.createSequentialGroup()
                .addComponent(labelTask1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDatosLayout.createSequentialGroup()
                        .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(cbTipoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cbProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDatosLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(4, 4, 4))
                    .addComponent(jdFecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jButton1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/aceptar.png"))); // NOI18N
        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/cancelar.png"))); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        pnlDatos1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        cbProducto.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        cbProducto.setModel(this.mcpr);
        cbProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbProductoActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel8.setText("PRODUCTO");

        jTable1.setModel(this.mtde);
        jScrollPane1.setViewportView(jTable1);

        btnAgregar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/nuevo.png"))); // NOI18N
        btnAgregar.setNextFocusableComponent(cbProducto);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        txtCantidad.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        txtCantidad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCantidadFocusLost(evt);
            }
        });

        cbPresentacion.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        cbPresentacion.setModel(this.mcpre);
        cbPresentacion.setEnabled(false);
        cbPresentacion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cbPresentacionFocusLost(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel9.setText("CANTIDAD");

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel10.setText("PRESENTACION");

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel11.setText("PRECIO");

        txtPrecio.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        txtPrecio.setNextFocusableComponent(btnAgregar);
        txtPrecio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPrecioFocusLost(evt);
            }
        });

        javax.swing.GroupLayout pnlDatos1Layout = new javax.swing.GroupLayout(pnlDatos1);
        pnlDatos1.setLayout(pnlDatos1Layout);
        pnlDatos1Layout.setHorizontalGroup(
            pnlDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDatos1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDatos1Layout.createSequentialGroup()
                        .addGroup(pnlDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(cbProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbPresentacion, 0, 313, Short.MAX_VALUE)
                            .addGroup(pnlDatos1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAgregar)
                        .addGap(71, 71, 71))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        pnlDatos1Layout.setVerticalGroup(
            pnlDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatos1Layout.createSequentialGroup()
                .addGroup(pnlDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDatos1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbPresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnAgregar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                .addContainerGap())
        );

        txtSubTotal.setEditable(false);
        txtSubTotal.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        txtSubTotal.setText("0.0");
        txtSubTotal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSubTotalFocusLost(evt);
            }
        });

        txtIgv.setEditable(false);
        txtIgv.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        txtIgv.setText("0.0");
        txtIgv.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIgvFocusLost(evt);
            }
        });
        txtIgv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIgvActionPerformed(evt);
            }
        });

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        txtTotal.setText("0.0");
        txtTotal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTotalFocusLost(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel12.setText("SUB-TOTAL");

        jLabel13.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel13.setText("IGV");

        jLabel14.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel14.setText("TOTAL");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlDatos1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlDatos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIgv, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(pnlDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlDatos1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIgv, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Compra compra;
        DAOCompra daoCompra;
        try {
            if (validarEntradas() == true) {
                compra = new Compra();
                daoCompra = new DAOCompra();
                compra.setSerie(this.txtSerie.getText());
                compra.setNumeroFactura(this.txtNumero.getText());
                compra.setProveedor(this.mcp.getSeleccionado());
                compra.setFechaCompra(this.jdFecha.getDate());
                compra.setListaDetalle(listaDetalle);
                compra.setUsuario(Ferreteria.us);
                compra.setSubTotal(Double.parseDouble(this.txtSubTotal.getText()));
                compra.setIgv(Double.parseDouble(this.txtIgv.getText()));
                compra.setTotal(Double.parseDouble(this.txtTotal.getText()));
                compra.setTipoCompra((TipoVentaCompra) this.cbTipoCompra.getSelectedItem());
                daoCompra.Registrar(compra);
                MetodosFunciones.mensajeInformacion(Ferreteria.mensajeCorrecto, Ferreteria.mensajeTitulo);
                limpiarControles();
                listaDetalle.clear();
                this.mtde.setListaDetalle(listaDetalle);
            }
        } catch (Exception e) {
            if (e.getMessage().indexOf("llave duplicada viola restricción de unicidad «fh_unico»") >= 0) {
                JOptionPane.showMessageDialog(this, "FACTURA / BOLETA YA REGISTRADOS \n" + this.txtSerie.getText() + " "+ this.txtNumero.getText());
                this.txtSerie.requestFocusInWindow();
            } else {
                MetodosFunciones.mensajeError(Ferreteria.mensajeError + e.getMessage(), Ferreteria.mensajeTitulo);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void limpiarControles() {
        this.txtCantidad.setText("");
        this.txtNumero.setText("");
        this.txtSerie.setText("");
        this.txtSubTotal.setText("0.0");
        this.txtIgv.setText("0.0");
        this.txtTotal.setText("0.0");

//        this.cbPresentacion.setSelectedIndex(-1);
//        this.cbProducto.setSelectedIndex(-1);
//        this.cbPresentacion.setSelectedIndex(-1);
        this.txtSerie.requestFocusInWindow();

    }

    private boolean validarEntradas() {
        JComponent aux = null;
        String mensaje = "";
        boolean estado = true;

        if (this.txtSerie.getText().isEmpty() == true) {
            mensaje += "INGRESE SERIE DE FACTURA \n";
            estado = false;
            aux = this.txtSerie;
        }
        if (this.txtNumero.getText().isEmpty() == true) {
            mensaje += "INGRESE NUMERO DE FACTURA \n";
            estado = false;
            aux = this.txtNumero;
        }

        if (this.cbProveedor.getSelectedIndex() == -1) {
            mensaje += "SELECCIONE PROVEEDOR \n";
            estado = false;
            aux = this.cbProveedor;
        }

        if (this.jdFecha.getDate() == null) {
            mensaje += "SELECCIONE FECHA \n";
            estado = false;
            aux = this.jdFecha;
        }

        if (this.listaDetalle.size() == 0) {
            mensaje += "INGRESE PRODUCTOS \n";
            estado = false;
            aux = this.cbProducto;
        }

        if (mensaje.length() >= 1) {
            MetodosFunciones.mensajeAdvertencia(mensaje, Ferreteria.mensajeTitulo);
            aux.requestFocusInWindow();
        }

        return estado;
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        this.dispose();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        int indice = this.cbProducto.getSelectedIndex();
        DetalleProductoPresentaciones de = null;
        TipoVentaCompra tipoComra = null;
        try {
            if (validar() == true) {
                if (indice >= 0) {
                    de = new DetalleProductoPresentaciones();
                    de.setProducto(this.mcpr.getSeleccionado());
                    de.setCantidad(Double.parseDouble(this.txtCantidad.getText()));
                    de.setPrecio(Double.parseDouble(this.txtPrecio.getText()));
//                    de.setPrecentacion(this.mcpre.getSeleccionado());
                    de.setPrecentacion((Presentacion) this.cbPresentacion.getSelectedItem());
                    if (validarDetalles(listaDetalle, de.getProducto())) {
                        listaDetalle.add(de);
                        this.mtde.setListaDetalle(listaDetalle);
                        this.txtCantidad.setText("");
                        this.txtPrecio.setText("");
                        this.cbProducto.requestFocusInWindow();
                        tipoComra = (TipoVentaCompra) this.cbTipoCompra.getSelectedItem();
                        if (tipoComra.getNombre().equals("FACTURA")) {
                            calculoTotalFactura(de);
                        } else {
                            calculoBoletaOtros(de);
                        }
                    }
                }
            }
        } catch (Exception e) {
            MetodosFunciones.mensajeError(Ferreteria.mensajeError + "\n" + e.getMessage(), Ferreteria.mensajeTitulo);
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void calculoTotalFactura(DetalleProductoPresentaciones de) {
        double total = 0;
        double subTotal = 0;
        double igv = 0;
        total = Double.parseDouble(this.txtTotal.getText()) + de.getCantidad() * de.getPrecio();
        igv = total * 0.18;
        subTotal = total - igv;
        this.txtTotal.setText(String.valueOf(MetodosFunciones.formatearNumero2(total)));
        this.txtSubTotal.setText(String.valueOf(MetodosFunciones.formatearNumero2(subTotal)));
        this.txtIgv.setText(String.valueOf(MetodosFunciones.formatearNumero2(igv)));
    }

    private void calculoBoletaOtros(DetalleProductoPresentaciones de) {
        double total = 0.00;
        double subTotal = 0.00;
        double igv = 0;
        total = Double.parseDouble(this.txtTotal.getText()) + de.getCantidad() * de.getPrecio();
        this.txtTotal.setText(String.valueOf(MetodosFunciones.formatearNumero2(total)));
        this.txtSubTotal.setText(String.valueOf(MetodosFunciones.formatearNumero2(subTotal)));
        this.txtIgv.setText(String.valueOf(MetodosFunciones.formatearNumero2(igv)));
    }

    private boolean validarDetalles(List<DetalleProductoPresentaciones> lista, Producto producto) {
        boolean estado = true;
        JComponent aux = null;

        for (DetalleProductoPresentaciones detalle : lista) {
            if (detalle.getProducto().getCodigo() == producto.getCodigo()) {
                estado = false;
                aux = this.cbProducto;
                MetodosFunciones.mensajeAdvertencia(Ferreteria.mensajeElementoRepetido, Ferreteria.mensajeTitulo);
                aux.requestFocusInWindow();
            }
        }
        return estado;
    }

    private boolean validar() {
        boolean estado = true;
        String mensaje = "";
        JComponent aux = null;

        if (this.cbProducto.getSelectedIndex() == -1) {
            estado = false;
            mensaje += "Seleccion Producto \n";
            aux = this.cbProducto;
        }

        if (this.txtCantidad.getText().isEmpty() == true) {
            estado = false;
            mensaje += "Ingrese Cantidad \n";
            aux = this.txtCantidad;
        } else {
            if (Double.parseDouble(this.txtCantidad.getText()) == 0) {
                estado = false;
                mensaje += "Ingrese cantidad correcta \n";
                aux = this.txtCantidad;
            }
        }

        if (this.txtCantidad.getText().equals(".") == true) {
            estado = false;
            mensaje += "ingrese un precio correcto \n";
            aux = this.txtCantidad;
        }
        if (this.txtPrecio.getText().isEmpty() == true) {
            estado = false;
            mensaje += "Ingrese precio \n";
            aux = this.txtPrecio;
        } else {
            if (Double.parseDouble(this.txtPrecio.getText()) == 0) {
                estado = false;
                mensaje += "Ingrese precio correcto \n";
                aux = this.txtPrecio;
            }
        }

        if (this.txtCantidad.getText().equals(".") == true) {
            estado = false;
            mensaje += "ingrese un cantidad correctar \n";
            aux = this.txtCantidad;
        }

        if (this.cbPresentacion.getSelectedIndex() == -1) {
            estado = false;
            mensaje += "Seleccion Presentacion \n";
            aux = this.cbPresentacion;
        }

        if (this.cbTipoCompra.getSelectedIndex() == -1) {
            estado = false;
            mensaje += "Seleccione Tipo de Compra \n";
            aux = this.cbPresentacion;
        }

        if (mensaje.length() > 1) {
            MetodosFunciones.mensajeAdvertencia(mensaje, Ferreteria.mensajeTitulo);
            aux.requestFocusInWindow();
        }

        return estado;
    }

    private void cbProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbProveedorActionPerformed

    private void cargarDatos() {

    }


    private void cbProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbProductoActionPerformed

        int p = this.cbProducto.getSelectedIndex();
        Producto pro = null;
        DAOProductoPresentacion dao = null;
        try {
            if (p >= 0) {
                dao = new DAOProductoPresentacion();
                pro = this.mcpr.getSeleccionado();
                this.cbPresentacion.setEnabled(true);
                this.cbPresentacion.setModel(new DefaultComboBoxModel(dao.listaPresentacionCodigoProd(pro.getCodigo()).toArray()));
            }
        } catch (Exception e) {
            MetodosFunciones.mensajeError(Ferreteria.mensajeError + "\n" + e.getMessage(), Ferreteria.mensajeTitulo);
        }

    }//GEN-LAST:event_cbProductoActionPerformed

    private void txtSerieFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSerieFocusLost
        // TODO add your handling code here:

        MetodosFunciones.autoCompletarNumeros(this.txtSerie, 5);

    }//GEN-LAST:event_txtSerieFocusLost

    private void txtNumeroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNumeroFocusLost

        MetodosFunciones.autoCompletarNumeros(this.txtNumero, 10);

// TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroFocusLost

    private void txtCantidadFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCantidadFocusLost

        if (this.txtCantidad.getText().isEmpty() != true && this.txtCantidad.getText().equals(".") == false) {
            this.txtCantidad.setText(MetodosFunciones.formatearNumero2(Double.parseDouble(this.txtCantidad.getText())));
        } else {
            this.txtCantidad.setText("0.0");
        }

    }//GEN-LAST:event_txtCantidadFocusLost

    private void cbPresentacionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbPresentacionFocusLost
        this.txtCantidad.requestFocusInWindow();
    }//GEN-LAST:event_cbPresentacionFocusLost

    private void cbTipoCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoCompraActionPerformed
        TipoVentaCompra tipoCompra = (TipoVentaCompra) this.cbTipoCompra.getSelectedItem();
        double total = 0;
        double subTotal = 0;
        double igv = 0;
        if (tipoCompra.getCodigo() == 1 || tipoCompra.getNombre().equals("FACTURA") == true) {
            this.txtIgv.setEnabled(true);
            this.txtIgv.setText("0.00");
            this.txtSubTotal.setEnabled(true);
            this.txtSubTotal.setText("0.00");
            total = Double.parseDouble(this.txtTotal.getText());
            igv = total * 0.18;
            subTotal = total - igv;
            this.txtIgv.setText(MetodosFunciones.formatearNumero2(igv));
            this.txtTotal.setText(MetodosFunciones.formatearNumero2(total));
            this.txtSubTotal.setText(String.valueOf(MetodosFunciones.formatearNumero2(subTotal)));
        } else {
            this.txtIgv.setEnabled(false);
            this.txtIgv.setText("0.00");
            this.txtSubTotal.setEnabled(false);
            this.txtSubTotal.setText("0.00");
        }
    }//GEN-LAST:event_cbTipoCompraActionPerformed

    private void txtSubTotalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSubTotalFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSubTotalFocusLost

    private void txtPrecioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecioFocusLost
        if (this.txtPrecio.getText().isEmpty() != true && this.txtPrecio.getText().equals(".") == false) {
            this.txtPrecio.setText(MetodosFunciones.formatearNumero2(Double.parseDouble(this.txtPrecio.getText())));
        } else {
            this.txtPrecio.setText("0.0");
        }
    }//GEN-LAST:event_txtPrecioFocusLost

    private void txtIgvFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIgvFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIgvFocusLost

    private void txtTotalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTotalFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalFocusLost

    private void txtIgvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIgvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIgvActionPerformed

    private void jdFechaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jdFechaFocusLost
        this.cbProducto.requestFocusInWindow();
    }//GEN-LAST:event_jdFechaFocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFCompras().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JComboBox cbPresentacion;
    private javax.swing.JComboBox cbProducto;
    private javax.swing.JComboBox cbProveedor;
    private javax.swing.JComboBox cbTipoCompra;
    private datechooser.beans.DateChooserDialog dateChooserDialog1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private com.toedter.calendar.JDateChooser jdFecha;
    private org.edisoncor.gui.label.LabelTask labelTask1;
    private javax.swing.JPanel pnlDatos;
    private javax.swing.JPanel pnlDatos1;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtIgv;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtSerie;
    private javax.swing.JTextField txtSubTotal;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables

}
