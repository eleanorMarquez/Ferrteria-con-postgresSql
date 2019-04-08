package ferreteria;

import dao.DAOPresentacion;
import dao.DAOUnidadMedida;
import entidades.Presentacion;
import ferreteria.modelos.ModeloComboUnidadMedida;
import ferreteria.modelos.ModeloTablaPresentacion;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

public class JFPrecentacion extends javax.swing.JFrame {

    private ModeloTablaPresentacion mtp = new ModeloTablaPresentacion();
    private ModeloComboUnidadMedida mcum = new ModeloComboUnidadMedida();

    private DAOPresentacion daoPre;
    private DAOUnidadMedida daoUnidad;
    private Presentacion presentacion;

    public JFPrecentacion() {
        initComponents();
        cargarComboUnidades();
        actualizarTablaPresentacion();
        validarControles();
        this.btnNuevo.requestFocusInWindow(); 
    }

    private void validarControles() {
        try {
            MetodosFunciones.soloNumerosDecimales(txtCantidad, 10);
            MetodosFunciones.soloLetrasNumeros(txtNombre, 100);
            MetodosFunciones.soloLetrasNumeros(txtDescriocon, 100);
        } catch (Exception e) {
            MetodosFunciones.mensajeError("Error de actualizacion", "Error");
        }
    }

    public void cargarComboUnidades() {
//        daoPre = new DAOPresentacion()
        daoUnidad = new DAOUnidadMedida();
        try {
            this.mcum.setListaUnidadMedida(daoUnidad.listaUnidaMedida(true));
        } catch (Exception e) {
            MetodosFunciones.mensajeError("Error de actualizacion", "Error");
        }
    }

    public void actualizarTablaPresentacion() {
//        daoPre = new DAOPresentacion()
        daoPre = new DAOPresentacion();
        try {
            this.mtp.setListaPresentaciones(daoPre.listaPresentacion(true));
        } catch (Exception e) {
            MetodosFunciones.mensajeError(Ferreteria.mensajeError + "\n" + e.getMessage(), Ferreteria.mensajeTitulo);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlDatos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cbUnidadMedida = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDescriocon = new javax.swing.JTextField();
        pnlLista = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        labelRect1 = new org.edisoncor.gui.label.LabelRect();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        pnlDatos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel1.setText("Nombre");
        jLabel1.setEnabled(false);

        jButton1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/aceptar.png"))); // NOI18N
        jButton1.setText("Aceptar");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtNombre.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        txtNombre.setEnabled(false);

        jButton2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/cancelar.png"))); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel2.setText("Unidad Medida");
        jLabel2.setEnabled(false);

        cbUnidadMedida.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        cbUnidadMedida.setModel(this.mcum);
        cbUnidadMedida.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel4.setText("Cantidad");
        jLabel4.setEnabled(false);

        txtCantidad.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        txtCantidad.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel5.setText("Descripcion");
        jLabel5.setEnabled(false);

        txtDescriocon.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        txtDescriocon.setEnabled(false);

        javax.swing.GroupLayout pnlDatosLayout = new javax.swing.GroupLayout(pnlDatos);
        pnlDatos.setLayout(pnlDatosLayout);
        pnlDatosLayout.setHorizontalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDescriocon)
                    .addComponent(txtCantidad)
                    .addComponent(txtNombre)
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addGap(0, 224, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addGap(4, 4, 4))
                    .addComponent(cbUnidadMedida, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlDatosLayout.setVerticalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbUnidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDescriocon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlLista.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        btnNuevo.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/nuevo.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        jTable1.setModel(this.mtp);
        jScrollPane1.setViewportView(jTable1);

        jButton5.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/eliminar.png"))); // NOI18N
        jButton5.setText("Eliminar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/modiicar.png"))); // NOI18N
        jButton6.setText("Modificar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlListaLayout = new javax.swing.GroupLayout(pnlLista);
        pnlLista.setLayout(pnlListaLayout);
        pnlListaLayout.setHorizontalGroup(
            pnlListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlListaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlListaLayout.createSequentialGroup()
                        .addComponent(btnNuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlListaLayout.setVerticalGroup(
            pnlListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlListaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addContainerGap())
        );

        jButton4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/salir ventana.png"))); // NOI18N
        jButton4.setText("Salir");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        labelRect1.setBackground(new java.awt.Color(153, 0, 255));
        labelRect1.setText("Gestion de Presentacion");
        labelRect1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(520, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addContainerGap())
            .addComponent(labelRect1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlDatos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlLista, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(labelRect1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        MetodosFunciones.activarControles(pnlDatos, true);
        MetodosFunciones.activarControles(pnlLista, false);
        this.txtNombre.requestFocusInWindow();
        presentacion = null; 
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        Presentacion pre;
        int indice = this.cbUnidadMedida.getSelectedIndex();
        try {
            if (validarEntradas() == true) {
                pre = new Presentacion();
                pre.setPresentacion(this.txtNombre.getText().toUpperCase());
                pre.setCantidad(Double.parseDouble(this.txtCantidad.getText()));
                pre.setUnidadMedida(this.mcum.getListaUnidadMedida().get(indice));
                pre.setDescripcion(this.txtDescriocon.getText().trim().isEmpty() == true ? "S/N" : this.txtDescriocon.getText().toUpperCase());
//                unidad.setDescripcion(this.txtDescripcion.getText().isEmpty() == true ? "S/N" : this.txtDescripcion.getText().toUpperCase());
                daoPre = new DAOPresentacion();
                if (presentacion == null) {
                    daoPre.registroPresentacion(pre);
                } else {
                    pre.setCodigo(presentacion.getCodigo());
                    daoPre.modificarPresentacion(pre);
                }
                actualizarTablaPresentacion();
                MetodosFunciones.activarLimpiarControles(pnlDatos, false);
                MetodosFunciones.activarLimpiarControles(pnlLista, true);
                this.btnNuevo.requestFocusInWindow(); 
            }
        } catch (Exception e) {
            if (e.getMessage().contains("llave duplicada viola restricción de unicidad «u_nombre_presentacion»") == true) {
                MetodosFunciones.mensajeAdvertencia(Ferreteria.mensajeElementoRepetido, Ferreteria.mensajeTitulo);
                this.txtNombre.requestFocusInWindow();
            } else {
                MetodosFunciones.mensajeError(Ferreteria.mensajeError + "\n" + e.getMessage(), Ferreteria.mensajeTitulo);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private boolean validarEntradas() {
        boolean estado = true;
        JComponent aux = null;
        String mensaje = "";
        try {
            this.txtNombre.setText(this.txtNombre.getText().trim());
            if (this.txtNombre.getText().isEmpty() == true) {
                mensaje += "INGRESE NOMBRE \n";
                aux = this.txtNombre;
                estado = false;
            }
            if (this.cbUnidadMedida.getSelectedIndex() == -1) {
                estado = false;
                aux = this.cbUnidadMedida;
                mensaje += "SELECCIONE UNIDAD DE MEDIDA \n";
            }

            this.txtCantidad.setText(this.txtCantidad.getText().trim());
            if (this.txtCantidad.getText().isEmpty() == true) {
                estado = false;
                aux = this.txtCantidad;
                mensaje += "INGRESE CANTIDAD \n";
            }

            try {
                double auxCantidad = Double.parseDouble(this.txtCantidad.getText().trim());
                if (auxCantidad == 0) {
                    mensaje += "INGRESE UNA CANTIDAD MAYOR A CERO";
                    estado = false;
                    aux = this.txtCantidad;
                }
            } catch (Exception e) {
                mensaje += "NUMERO INCORRECTO";
            }

            if (mensaje.length() >= 1) {
                MetodosFunciones.mensajeAdvertencia(mensaje, Ferreteria.mensajeTitulo);
                aux.requestFocusInWindow();
            }

        } catch (Exception e) {
            MetodosFunciones.mensajeError(Ferreteria.mensajeError + e.getMessage(), Ferreteria.mensajeTitulo);
            estado = false;
        }
        return estado;
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        // TODO add your handling code here:
        MetodosFunciones.activarLimpiarControles(pnlDatos, false);
        MetodosFunciones.activarLimpiarControles(pnlLista, true);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        int indice = this.jTable1.getSelectedRow();
        Presentacion pre;
        try {
            if (indice >= 0) {
                int valor = JOptionPane.showConfirmDialog(this, Ferreteria.mensajeEliminar, Ferreteria.mensajeTitulo, JOptionPane.OK_OPTION);
                if (valor == JOptionPane.OK_OPTION) {
                    pre = this.mtp.getListaPresentaciones().get(indice);
                    daoPre.darBajaDarAlta(pre);
                    actualizarTablaPresentacion();
                }
            } else {
                MetodosFunciones.mensajeAdvertencia(Ferreteria.mensajeAdvertencia, Ferreteria.mensajeTitulo);
            }
        } catch (Exception e) {
            MetodosFunciones.mensajeError(Ferreteria.mensajeError + "\n " + e.getMessage(), Ferreteria.mensajeTitulo);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        int indice = this.jTable1.getSelectedRow();
        try {
            if (indice >= 0) {
                presentacion = this.mtp.getListaPresentaciones().get(indice);
                mostrarDatos();
            }
        } catch (Exception e) {
            MetodosFunciones.mensajeError(Ferreteria.mensajeError + "\n " + e.getMessage(), Ferreteria.mensajeTitulo);
        }

    }//GEN-LAST:event_jButton6ActionPerformed

    private void mostrarDatos() {
        try {
            MetodosFunciones.activarControles(pnlDatos, true);
            MetodosFunciones.activarControles(pnlLista, false);
            this.txtNombre.setText(presentacion.getPresentacion());
            this.mcum.setSeleccionado(presentacion.getUnidadMedida());
            this.txtCantidad.setText(String.valueOf(presentacion.getCantidad()));
            this.txtDescriocon.setText(presentacion.getDescripcion());
        } catch (Exception e) {
            MetodosFunciones.mensajeError(Ferreteria.mensajeError + "\n " + e.getMessage(), Ferreteria.mensajeTitulo);
        }
    }

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
            java.util.logging.Logger.getLogger(JFPrecentacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFPrecentacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFPrecentacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFPrecentacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFPrecentacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox cbUnidadMedida;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private org.edisoncor.gui.label.LabelRect labelRect1;
    private javax.swing.JPanel pnlDatos;
    private javax.swing.JPanel pnlLista;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtDescriocon;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
