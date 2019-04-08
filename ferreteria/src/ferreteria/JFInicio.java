package ferreteria;

import dao.DAOUsuario;
import entidades.Usuario;
import static java.awt.Frame.MAXIMIZED_BOTH;
import javax.swing.JOptionPane;

public class JFInicio extends javax.swing.JFrame {

    private Usuario us;
    private DAOUsuario daoUs;

    public JFInicio() {
        initComponents();
        fondo();
    }

    private void fondo() {
        this.setTitle("Inicio");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
//        setIconImage(new ImageIcon(getClass().getResource("../recursos/iconosistema.png")).getImage());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelHeader1 = new org.edisoncor.gui.label.LabelHeader();
        labelRect1 = new org.edisoncor.gui.label.LabelRect();
        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        txtUsuario = new org.peru.tbox.CajaTextImagLimp();
        txtClave = new org.peru.tbox.CajaPassImagLimp();
        buttonTask1 = new org.edisoncor.gui.button.ButtonTask();

        labelHeader1.setText("labelHeader1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        labelRect1.setBackground(new java.awt.Color(153, 0, 255));
        labelRect1.setText("INGRESO AL SISTEMA");
        labelRect1.setColorDeBorde(new java.awt.Color(204, 0, 255));
        labelRect1.setColorDeSegundoBorde(new java.awt.Color(153, 0, 255));
        labelRect1.setColorDeSombra(new java.awt.Color(204, 0, 255));
        labelRect1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N

        panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/INICIO IMAGEN.png"))); // NOI18N

        txtUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/1412358032_add-group.png"))); // NOI18N
        txtUsuario.setNextFocusableComponent(txtClave);
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyReleased(evt);
            }
        });

        txtClave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/inicio.png"))); // NOI18N
        txtClave.setNextFocusableComponent(buttonTask1);
        txtClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelImage1Layout = new javax.swing.GroupLayout(panelImage1);
        panelImage1.setLayout(panelImage1Layout);
        panelImage1Layout.setHorizontalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelImage1Layout.createSequentialGroup()
                .addContainerGap(83, Short.MAX_VALUE)
                .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(81, 81, 81))
        );
        panelImage1Layout.setVerticalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImage1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        buttonTask1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/entrarr.png"))); // NOI18N
        buttonTask1.setText("Entrar");
        buttonTask1.setDescription(" ");
        buttonTask1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTask1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelRect1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(buttonTask1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(labelRect1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonTask1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClaveActionPerformed

    private void buttonTask1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTask1ActionPerformed
        try {
            String claveAux = new String(this.txtClave.getPassword());
            daoUs = new DAOUsuario();
            us = new Usuario();
            us.setNombreUsuario(this.txtUsuario.getText().trim());
            us.setContraseña(claveAux);
            us = daoUs.usuarioValidar(us);
            if (us != null) {
                Ferreteria.us = us;
                this.dispose();
                JFPrincipal principal = new JFPrincipal();
                principal.setExtendedState(MAXIMIZED_BOTH);
                principal.setVisible(true);
            } else {
                MetodosFunciones.mensajeError("Error al ingresar los datos", "Mensaje Error");
                this.txtUsuario.requestFocusInWindow();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error de Conexion: " + e.getMessage());
            System.exit(EXIT_ON_CLOSE);
        } finally {
            us = null;
            daoUs = null;
        }

    }//GEN-LAST:event_buttonTask1ActionPerformed

    private void txtUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyReleased
        this.txtUsuario.setText(this.txtUsuario.getText().toUpperCase());
    }//GEN-LAST:event_txtUsuarioKeyReleased

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
            java.util.logging.Logger.getLogger(JFInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFInicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonTask buttonTask1;
    private org.edisoncor.gui.label.LabelHeader labelHeader1;
    private org.edisoncor.gui.label.LabelRect labelRect1;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    private org.peru.tbox.CajaPassImagLimp txtClave;
    private org.peru.tbox.CajaTextImagLimp txtUsuario;
    // End of variables declaration//GEN-END:variables
}
