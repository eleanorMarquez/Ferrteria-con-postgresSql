/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteria;

import dao.DAOCompra;
import dao.DAOProducto;
import dao.DAOProductoPresentacion;
import dao.DAOProveedor;
import dao.DAOTipoVenta;
import dao.DAOVenta;
import entidades.DetalleProductoPresentaciones;
import entidades.DetalleVenta;
import entidades.Presentacion;
import entidades.Producto;
import entidades.TipoVentaCompra;
import entidades.Venta;
import ferreteria.modelos.ModeloComboPresentacion;
import ferreteria.modelos.ModeloComboProducto;
import ferreteria.modelos.ModeloComboProveedor;
import ferreteria.modelos.ModeloTablaDetalleVenta;
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
public class JFVenta extends javax.swing.JFrame {

    ModeloComboProveedor mcp = new ModeloComboProveedor();
    ModeloComboProducto mcpr = new ModeloComboProducto();
    ModeloComboPresentacion mcpre = new ModeloComboPresentacion();
    ModeloTablaDetalleVenta mtde = new ModeloTablaDetalleVenta();
    DAOProducto daoProducto = new DAOProducto();
    List<DetalleProductoPresentaciones> listaDetalle = new ArrayList<>();
    List<DetalleVenta> listaDetalleVetnta = new ArrayList<>();
    DAOTipoVenta daotv = new DAOTipoVenta();

    public JFVenta() {
        initComponents();
        cargarCombos();
        validarControles();
    }

    private void validarControles() {
        MetodosFunciones.soloNumeros(this.txtSerie, 5);
        MetodosFunciones.soloNumeros(this.txtNumero, 10);
        MetodosFunciones.soloNumerosDecimales(this.txtCantidad, 10);
        MetodosFunciones.soloNumerosDecimales(this.txtPrecio, 10);
        MetodosFunciones.soloLetras(this.txtCliente, 30);

    }

    private void cargarCombos() {
        try {
            this.cbTipoVenta.setModel(new DefaultComboBoxModel(daotv.listaTipoVenta(true).toArray()));
            this.mcpr.setListaProductos(daoProducto.listaProductoss(true));
            AutoCompleteDecorator.decorate(this.cbProducto);
            this.jdFecha.setDate(Calendar.getInstance().getTime());
        } catch (Exception e) {
            MetodosFunciones.mensajeError(Ferreteria.mensajeError + "\n" + e.getMessage(), Ferreteria.mensajeTitulo);
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
        txtCliente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbTipoVenta = new javax.swing.JComboBox();
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
        txtPrecio = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtSubTotal = new javax.swing.JTextField();
        txtIgv = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        pnlDatos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel2.setText("CLIENTE");

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel6.setText("FECHA");

        jdFecha.setDate(Calendar.getInstance().getTime());
        jdFecha.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel4.setText("N° FACTURA");

        txtSerie.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        txtSerie.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSerieFocusLost(evt);
            }
        });

        labelTask1.setText("GESTION DE VENTAS - FERRETERIA SEÑOR DE LOS MILAGROS");
        labelTask1.setDescription("Telefono: 98456123 \nE-mail: livia@live.com\n\n");

        txtNumero.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        txtNumero.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNumeroFocusLost(evt);
            }
        });

        txtCliente.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        txtCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtClienteFocusLost(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel3.setText("TIPO VENTA");

        cbTipoVenta.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        cbTipoVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoVentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDatosLayout = new javax.swing.GroupLayout(pnlDatos);
        pnlDatos.setLayout(pnlDatosLayout);
        pnlDatosLayout.setHorizontalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlDatosLayout.createSequentialGroup()
                                .addComponent(txtSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtCliente))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbTipoVenta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jdFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 242, Short.MAX_VALUE))
                    .addComponent(labelTask1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlDatosLayout.setVerticalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDatosLayout.createSequentialGroup()
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addComponent(labelTask1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDatosLayout.createSequentialGroup()
                                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txtSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbTipoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jdFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

        txtPrecio.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        txtPrecio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPrecioFocusLost(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel11.setText("PRECENTACION");

        jLabel12.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel12.setText("CANTIDAD");

        jLabel13.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel13.setText("PRECIO");

        javax.swing.GroupLayout pnlDatos1Layout = new javax.swing.GroupLayout(pnlDatos1);
        pnlDatos1.setLayout(pnlDatos1Layout);
        pnlDatos1Layout.setHorizontalGroup(
            pnlDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatos1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(cbPresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAgregar)
                .addContainerGap(71, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        pnlDatos1Layout.setVerticalGroup(
            pnlDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatos1Layout.createSequentialGroup()
                .addGroup(pnlDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlDatos1Layout.createSequentialGroup()
                        .addGroup(pnlDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addGap(1, 1, 1)
                        .addGroup(pnlDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbPresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnAgregar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                .addContainerGap())
        );

        txtSubTotal.setEditable(false);
        txtSubTotal.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        txtSubTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSubTotal.setText("0");
        txtSubTotal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSubTotalFocusLost(evt);
            }
        });

        txtIgv.setEditable(false);
        txtIgv.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        txtIgv.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIgv.setText("0");
        txtIgv.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIgvFocusLost(evt);
            }
        });

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotal.setText("0");
        txtTotal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTotalFocusLost(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel7.setText("SUB-TOTAL");

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel9.setText("IGV");

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel10.setText("TOTAL");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addComponent(pnlDatos1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIgv, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(pnlDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(pnlDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlDatos1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIgv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Venta venta;
        DAOVenta daoVenta;
        try {
            if (validarEntradas() == true) {
                venta = new Venta();
                daoVenta = new DAOVenta();
                venta.setTipoVenta((TipoVentaCompra) this.cbTipoVenta.getSelectedItem());
                venta.setSerie(this.txtSerie.getText());
                venta.setNumero(this.txtNumero.getText());
                venta.setCliente(this.txtCliente.getText());
                venta.setFechaVenta(this.jdFecha.getDate());
                venta.setSubTotal(Double.parseDouble(this.txtSubTotal.getText()));
                venta.setTotal(Double.parseDouble(this.txtTotal.getText()));
                venta.setIgv(Double.parseDouble(this.txtIgv.getText()));
                venta.setListaDetalle(listaDetalleVetnta);
                venta.setUs(Ferreteria.us);
                venta.setSubTotal(Double.parseDouble(this.txtSubTotal.getText()));
                venta.setIgv(Double.parseDouble(this.txtIgv.getText()));
                venta.setTotal(Double.parseDouble(this.txtTotal.getText()));
                daoVenta.Registrar(venta);
                MetodosFunciones.mensajeInformacion(Ferreteria.mensajeCorrecto, Ferreteria.mensajeTitulo);
                limpiarControles();
                listaDetalleVetnta.clear();
                this.mtde.setListaDetalle(listaDetalleVetnta);
            }
        } catch (Exception e) {
            if (e.getMessage().indexOf("llave duplicada viola restricción de unicidad «fk_unico_venta»") >= 0) {
                JOptionPane.showMessageDialog(this, "FACTURA / BOLETA YA REGISTRADOS \n" + this.txtSerie.getText() + " " + this.txtNumero.getText());
                this.txtSerie.requestFocusInWindow();
            } else {
                MetodosFunciones.mensajeError(Ferreteria.mensajeError + e.getMessage(), Ferreteria.mensajeTitulo);
            }

        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void limpiarControles() {
        this.txtCantidad.setText("");
        this.txtPrecio.setText("");
        this.txtNumero.setText("");
        this.txtSerie.setText("");
        this.txtCliente.setText("");
//        this.cbTipoVenta.setSelectedIndex(-1);
        this.txtSubTotal.setText("0.00");
        this.txtIgv.setText("0.00");
        this.txtTotal.setText("0.00");
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
        } else {
            if (Double.parseDouble(this.txtSerie.getText()) == 0) {
                mensaje += "NUMERO DE SERIE INCORRECTO \n";
                estado = false;
                aux = this.txtSerie;
            }
        }
        if (this.txtNumero.getText().isEmpty() == true) {
            mensaje += "INGRESE NUMERO DE FACTURA \n";
            estado = false;
            aux = this.txtNumero;
        } else {
            if (Double.parseDouble(this.txtNumero.getText()) == 0) {
                mensaje += "NUMERO DE FACTURA INCORRECTO \n";
                estado = false;
                aux = this.txtNumero;
            }
        }

        if (this.cbTipoVenta.getSelectedIndex() == -1) {
            mensaje += "SELECCIONE TIPO DE VENTA \n";
            estado = false;
            aux = this.txtSerie;
        }

        if (this.txtCliente.getText().isEmpty() == true) {
            mensaje += "INGRESE CLIENTE \n";
            estado = false;
            aux = this.txtCliente;
        }
        if (this.jdFecha.getDate() == null) {
            mensaje += "SELECCIONE FECHA \n";
            estado = false;
            aux = this.jdFecha;
        }

        if (this.listaDetalleVetnta.size() == 0) {
            mensaje += "INGRESE PRODUCTOS";
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
        DetalleVenta de = null;
        TipoVentaCompra tipoVenta;
        try {
            if (validar() == true) {
                if (indice >= 0) {
                    de = new DetalleVenta();
                    de.setProducto(this.mcpr.getSeleccionado());
                    de.setCantidad(Double.parseDouble(this.txtCantidad.getText()));
                    de.setPrecio(Double.parseDouble(this.txtPrecio.getText()));
                    de.setPresentacion((Presentacion) this.cbPresentacion.getSelectedItem());
                    if (validarDetalles(listaDetalleVetnta, de.getProducto())) {
                        listaDetalleVetnta.add(de);
                        this.mtde.setListaDetalle(listaDetalleVetnta);
                        this.txtCantidad.setText("");
                        this.txtPrecio.setText("");
                        this.cbProducto.requestFocusInWindow();
                        tipoVenta = (TipoVentaCompra) this.cbTipoVenta.getSelectedItem();
                        if (tipoVenta.getNombre().equals("FACTURA")) {
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

    private void calculoTotalFactura(DetalleVenta de) {
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

    private void calculoBoletaOtros(DetalleVenta de) {
        double total = 0.00;
        double subTotal = 0.00;
        double igv = 0;
        total = Double.parseDouble(this.txtTotal.getText()) + de.getCantidad() * de.getPrecio();
        this.txtTotal.setText(String.valueOf(MetodosFunciones.formatearNumero2(total)));
        this.txtSubTotal.setText(String.valueOf(MetodosFunciones.formatearNumero2(subTotal)));
        this.txtIgv.setText(String.valueOf(MetodosFunciones.formatearNumero2(igv)));
    }

    private boolean validarDetalles(List<DetalleVenta> lista, Producto producto) {
        boolean estado = true;
        JComponent aux = null;
        for (DetalleVenta detalle : lista) {
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
                mensaje += "Cantidad Incorrecta \n";
                aux = this.txtCantidad;
            }
        }

        if (this.txtPrecio.getText().isEmpty() == true) {
            estado = false;
            mensaje += "Ingrese Precio \n";
            aux = this.txtCantidad;
        } else {
            if (Double.parseDouble(this.txtPrecio.getText()) == 0) {
                estado = false;
                mensaje += "El precio tiene que se mayor a cero \n";
                aux = this.txtPrecio;
            }
        }

        if (this.cbPresentacion.getSelectedIndex() == -1) {
            estado = false;
            mensaje += "Seleccion Presentacion \n";
            aux = this.cbPresentacion;
        }

        if (mensaje.length() > 1) {
            MetodosFunciones.mensajeAdvertencia(mensaje, Ferreteria.mensajeTitulo);
            aux.requestFocusInWindow();
        }

        return estado;
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

    private void txtClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtClienteFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClienteFocusLost

    private void txtSubTotalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSubTotalFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSubTotalFocusLost

    private void txtIgvFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIgvFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIgvFocusLost

    private void txtTotalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTotalFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalFocusLost

    private void cbTipoVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoVentaActionPerformed
        TipoVentaCompra tipoVenta = (TipoVentaCompra) this.cbTipoVenta.getSelectedItem();
        double total = 0;
        double subTotal = 0;
        double igv = 0;

        if (tipoVenta.getCodigo() == 1 || tipoVenta.getNombre().equals("FACTURA") == true) {
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
    }//GEN-LAST:event_cbTipoVentaActionPerformed

    private void txtPrecioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecioFocusLost
        if (this.txtPrecio.getText().isEmpty() != true && this.txtPrecio.getText().equals(".") == false) {
            this.txtPrecio.setText(MetodosFunciones.formatearNumero2(Double.parseDouble(this.txtPrecio.getText())));
        } else {
            this.txtPrecio.setText("0.00");
        }
        this.btnAgregar.requestFocusInWindow();
    }//GEN-LAST:event_txtPrecioFocusLost

    private void txtCantidadFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCantidadFocusLost
        if (this.txtCantidad.getText().isEmpty() != true && this.txtCantidad.getText().equals(".") == false) {
            this.txtCantidad.setText(MetodosFunciones.formatearNumero2(Double.parseDouble(this.txtCantidad.getText())));
        } else {
            this.txtCantidad.setText("0.00");
        }
    }//GEN-LAST:event_txtCantidadFocusLost

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
            java.util.logging.Logger.getLogger(JFVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFVenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JComboBox cbPresentacion;
    private javax.swing.JComboBox cbProducto;
    private javax.swing.JComboBox cbTipoVenta;
    private datechooser.beans.DateChooserDialog dateChooserDialog1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private com.toedter.calendar.JDateChooser jdFecha;
    private org.edisoncor.gui.label.LabelTask labelTask1;
    private javax.swing.JPanel pnlDatos;
    private javax.swing.JPanel pnlDatos1;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtIgv;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtSerie;
    private javax.swing.JTextField txtSubTotal;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
