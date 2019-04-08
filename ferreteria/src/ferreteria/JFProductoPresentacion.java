/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteria;

import dao.DAOPresentacion;
import dao.DAOProducto;
import dao.DAOProductoPresentacion;
import entidades.DetalleProductoPresentaciones;
import entidades.Presentacion;
import entidades.Producto;
import entidades.ProductoPresentacion;
import ferreteria.modelos.ModeloComboPresentacion;
import ferreteria.modelos.ModeloComboProducto;
import ferreteria.modelos.ModeloTablaPresentacion;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class JFProductoPresentacion extends javax.swing.JFrame {

    ModeloComboProducto mcp = new ModeloComboProducto();
    ModeloComboPresentacion mcpr = new ModeloComboPresentacion();
    ModeloTablaPresentacion mtpr = new ModeloTablaPresentacion();
    List<Presentacion> listaPresentacion = new ArrayList<>();
    ProductoPresentacion productoPresentacion;
    List<DetalleProductoPresentaciones> listaDetalle = new ArrayList<>();

    public JFProductoPresentacion() {
        initComponents();
        cargarCombos();
    }

    private void cargarCombos() {
        DAOProducto daoProducto;
        DAOPresentacion daoPresentacion;
        try {
            daoPresentacion = new DAOPresentacion();
            daoProducto = new DAOProducto();
            this.mcp.setListaProductos(daoProducto.listaProductoss(true));
            this.mcpr.setListaPresentaciones(daoPresentacion.listaPresentacion(true));
            AutoCompleteDecorator.decorate(this.cbProducto);
//            AutoCompleteDecorator.decorate(this.cbPresentacion);
        } catch (Exception e) {
            MetodosFunciones.mensajeError(Ferreteria.mensajeError + "\n" + e.getMessage(), Ferreteria.mensajeTitulo);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlDatos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        labelTask1 = new org.edisoncor.gui.label.LabelTask();
        cbProducto = new javax.swing.JComboBox();
        jButton5 = new javax.swing.JButton();
        pnlDatos1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        cbPresentacion = new javax.swing.JComboBox();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        pnlDatos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel1.setText("Producto");

        labelTask1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/presentacion.png"))); // NOI18N
        labelTask1.setText("GESTION DE PRESENTACIONES DE PRODUCTOS");
        labelTask1.setDescription(" ");

        cbProducto.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        cbProducto.setModel(this.mcp);
        cbProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDatosLayout = new javax.swing.GroupLayout(pnlDatos);
        pnlDatos.setLayout(pnlDatosLayout);
        pnlDatosLayout.setHorizontalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelTask1, javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbProducto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlDatosLayout.setVerticalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addComponent(labelTask1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton5.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/salir ventana.png"))); // NOI18N
        jButton5.setText("Salir");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        pnlDatos1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jTable2.setModel(this.mtpr);
        jScrollPane2.setViewportView(jTable2);

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel8.setText("Presentacion");

        cbPresentacion.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        cbPresentacion.setModel(this.mcpr);

        jButton4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton4.setText("+");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/eliminar.png"))); // NOI18N
        jButton6.setText("Eliminar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDatos1Layout = new javax.swing.GroupLayout(pnlDatos1);
        pnlDatos1.setLayout(pnlDatos1Layout);
        pnlDatos1Layout.setHorizontalGroup(
            pnlDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatos1Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(pnlDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDatos1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbPresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4))
                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addComponent(jScrollPane2)
        );
        pnlDatos1Layout.setVerticalGroup(
            pnlDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatos1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlDatos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbPresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton5)
                    .addComponent(pnlDatos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlDatos1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlDatos1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int indice = this.cbPresentacion.getSelectedIndex();
        int indiceProd = this.cbProducto.getSelectedIndex();
        Presentacion pre;
        Producto pro;
        DAOProductoPresentacion daoProPre;
        try {
            if (indice >= 0 && indiceProd >= 0) {
                pre = this.mcpr.getSeleccionado();
                pro = this.mcp.getSeleccionado();
                if (validarListaDetalle(listaPresentacion, pre, pro) == true) {
                    daoProPre = new DAOProductoPresentacion();
                    daoProPre.registrarPresentacionesDeProducto(pro, pre);
                    this.mtpr.setListaPresentaciones(daoProPre.listaPresentacionDetallePresentacion(pro.getCodigo()));
                    listaPresentacion = this.mtpr.getListaPresentaciones();
                    this.cbPresentacion.setSelectedIndex(-1);
                    this.cbPresentacion.requestFocusInWindow();
                }
            } else {
                MetodosFunciones.mensajeAdvertencia(Ferreteria.mensajeAdvertencia, Ferreteria.mensajeTitulo);
            }
        } catch (Exception e) {
            MetodosFunciones.mensajeError(Ferreteria.mensajeError + "\n" + e.getMessage(), Ferreteria.mensajeTitulo);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private boolean validarListaDetalle(List<Presentacion> lista, Presentacion pr, Producto producto) {
        boolean estado = true;
        String mensaje = "";
        JComponent aux = null;

        for (Presentacion pre : lista) {
            if (pr.getCodigo() == pre.getCodigo()) {
                estado = false;
                mensaje += "Elemento ya existe en la lista";
                aux = this.cbPresentacion;
            }
        }

        if (producto.getUnidaMedida().getCodigo() == pr.getUnidadMedida().getCodigo()) {
            System.out.println("Coddido igaul");
        } else {
            estado = false;
            mensaje += "INGRESE UNA PRESENTACION \n CON LA MISMA UNIDAD DE MEDIDA \n";
            aux = this.cbPresentacion;
        }

        if (mensaje.length() >= 1) {
             MetodosFunciones.mensajeAdvertencia(mensaje, Ferreteria.mensajeTitulo);
            aux.requestFocusInWindow();
        }
        return estado;
    }


    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        int indice = this.jTable2.getSelectedRow();
        int indiceProducto = this.cbProducto.getSelectedIndex();
//        int indiceTable = this.jTable2.getSelectedRow(); 
        Presentacion pre;
        Producto pro;
        DAOProductoPresentacion daoProPre;
        try {
            if (indice >= 0 && indiceProducto >= 0) {
                int op = JOptionPane.showConfirmDialog(this, Ferreteria.mensajeEliminar, Ferreteria.mensajeTitulo, JOptionPane.OK_OPTION);
                if (op == JOptionPane.OK_OPTION) {
                    pre = this.mtpr.getListaPresentaciones().get(indice);
                    pro = this.mcp.getSeleccionado();
                    daoProPre = new DAOProductoPresentacion();
                    daoProPre.eliminarDetallePresentacion(pro, pre);
                    this.mtpr.setListaPresentaciones(daoProPre.listaPresentacionDetallePresentacion(pro.getCodigo()));
                    listaPresentacion = this.mtpr.getListaPresentaciones();
                }
            } else {
                MetodosFunciones.mensajeAdvertencia(Ferreteria.mensajeAdvertencia, Ferreteria.mensajeTitulo);
            }
        } catch (Exception e) {
            MetodosFunciones.mensajeError(Ferreteria.mensajeError + e.getMessage(), Ferreteria.mensajeTitulo);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void cbProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbProductoActionPerformed

        int indice = this.cbProducto.getSelectedIndex();
        DAOProductoPresentacion dao;
        Producto pr;
        try {
            if (indice >= 0) {
                dao = new DAOProductoPresentacion();
                pr = this.mcp.getSeleccionado();
                this.mtpr.setListaPresentaciones(dao.listaPresentacionDetallePresentacion(pr.getCodigo()));
                listaPresentacion = this.mtpr.getListaPresentaciones();
            }
        } catch (Exception e) {
            MetodosFunciones.mensajeError(Ferreteria.mensajeError, Ferreteria.mensajeTitulo);
        }
    }//GEN-LAST:event_cbProductoActionPerformed

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
            java.util.logging.Logger.getLogger(JFProductoPresentacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFProductoPresentacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFProductoPresentacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFProductoPresentacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFProductoPresentacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbPresentacion;
    private javax.swing.JComboBox cbProducto;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private org.edisoncor.gui.label.LabelTask labelTask1;
    private javax.swing.JPanel pnlDatos;
    private javax.swing.JPanel pnlDatos1;
    // End of variables declaration//GEN-END:variables
}
