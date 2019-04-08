package ferreteria;

import javax.swing.JOptionPane;

public class JFPrincipal extends javax.swing.JFrame {

    public JFPrincipal() {
        initComponents();
        this.lblUsuario.setText("Usuario: " + Ferreteria.us.getNombreUsuario());
//        setIconImage(new ImageIcon(getClass().getResource("ferreteria/recursos/icono_sistema.ico")).getImage());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        jFrame1 = new javax.swing.JFrame();
        jRadioButtonMenuItem2 = new javax.swing.JRadioButtonMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        dateUtils1 = new org.jdesktop.swingx.calendar.DateUtils();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu6 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu9 = new javax.swing.JMenu();
        jMenu10 = new javax.swing.JMenu();
        jMenuBar4 = new javax.swing.JMenuBar();
        jMenu11 = new javax.swing.JMenu();
        jMenu12 = new javax.swing.JMenu();
        panel1 = new org.edisoncor.gui.panel.Panel();
        wDate1 = new suavena.WDate();
        buttonTask1 = new org.edisoncor.gui.button.ButtonTask();
        jToolBar1 = new javax.swing.JToolBar();
        lblUsuario = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        MIniciar = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        JMTrabajador = new javax.swing.JMenu();
        MSInfoProgramado = new javax.swing.JMenuItem();
        MSInfoProgramado10 = new javax.swing.JMenuItem();
        MSInfoProgramado12 = new javax.swing.JMenuItem();
        MSInfoProgramado13 = new javax.swing.JMenuItem();
        MSInfoProgramado16 = new javax.swing.JMenuItem();
        MSInfoProgramado14 = new javax.swing.JMenuItem();
        JMRegistro = new javax.swing.JMenu();
        MSInfoProgramado7 = new javax.swing.JMenuItem();
        MSInfoProgramado8 = new javax.swing.JMenuItem();
        MSInfoProgramado11 = new javax.swing.JMenuItem();
        MSInfoProgramado9 = new javax.swing.JMenuItem();
        JMReporte = new javax.swing.JMenu();
        MSInfoProgramado5 = new javax.swing.JMenuItem();
        JMRegistro3 = new javax.swing.JMenu();
        MSInfoProgramado21 = new javax.swing.JMenuItem();
        MSInfoProgramado24 = new javax.swing.JMenuItem();
        MSInfoProgramado26 = new javax.swing.JMenuItem();
        JMRegistro2 = new javax.swing.JMenu();
        MSInfoProgramado15 = new javax.swing.JMenuItem();
        MSInfoProgramado22 = new javax.swing.JMenuItem();
        MSInfoProgramado23 = new javax.swing.JMenuItem();
        JMSeguridad = new javax.swing.JMenu();
        MSInfoProgramado19 = new javax.swing.JMenuItem();
        MSInfoProgramado20 = new javax.swing.JMenuItem();

        jMenu3.setText("jMenu3");

        jMenu4.setText("jMenu4");

        jMenu5.setText("jMenu5");

        jMenuItem1.setText("jMenuItem1");

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jRadioButtonMenuItem2.setSelected(true);
        jRadioButtonMenuItem2.setText("jRadioButtonMenuItem2");

        jMenuItem12.setText("jMenuItem12");

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu6.setText("File");
        jMenuBar2.add(jMenu6);

        jMenu7.setText("Edit");
        jMenuBar2.add(jMenu7);

        jMenu8.setText("jMenu8");

        jMenu9.setText("File");
        jMenuBar3.add(jMenu9);

        jMenu10.setText("Edit");
        jMenuBar3.add(jMenu10);

        jMenu11.setText("File");
        jMenuBar4.add(jMenu11);

        jMenu12.setText("Edit");
        jMenuBar4.add(jMenu12);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("VidSoniaSoft");

        panel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ferreteria.jpg"))); // NOI18N

        buttonTask1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/exit48x48.png"))); // NOI18N
        buttonTask1.setText("Salir");
        buttonTask1.setDescription(" ");
        buttonTask1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTask1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addComponent(buttonTask1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addComponent(wDate1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonTask1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                .addComponent(wDate1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        lblUsuario.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblUsuario.setText("Usuario:");
        jToolBar1.add(lblUsuario);

        menuBar.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        MIniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iniciooo.png"))); // NOI18N
        MIniciar.setMnemonic('f');
        MIniciar.setText("Inicio");
        MIniciar.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N

        jMenuItem2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jMenuItem2.setText("Salir");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        MIniciar.add(jMenuItem2);

        menuBar.add(MIniciar);

        JMTrabajador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/admin.png"))); // NOI18N
        JMTrabajador.setText(" Administracion ");
        JMTrabajador.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N

        MSInfoProgramado.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        MSInfoProgramado.setText("Gestion Unidades Medida");
        MSInfoProgramado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MSInfoProgramadoActionPerformed(evt);
            }
        });
        JMTrabajador.add(MSInfoProgramado);

        MSInfoProgramado10.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        MSInfoProgramado10.setText("Gestion de Presentaciones");
        MSInfoProgramado10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MSInfoProgramado10ActionPerformed(evt);
            }
        });
        JMTrabajador.add(MSInfoProgramado10);

        MSInfoProgramado12.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        MSInfoProgramado12.setText("Gestion de Productos");
        MSInfoProgramado12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MSInfoProgramado12ActionPerformed(evt);
            }
        });
        JMTrabajador.add(MSInfoProgramado12);

        MSInfoProgramado13.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        MSInfoProgramado13.setText("Gestion de Categorias");
        MSInfoProgramado13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MSInfoProgramado13ActionPerformed(evt);
            }
        });
        JMTrabajador.add(MSInfoProgramado13);

        MSInfoProgramado16.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        MSInfoProgramado16.setText("Gestion de Proveedores");
        MSInfoProgramado16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MSInfoProgramado16ActionPerformed(evt);
            }
        });
        JMTrabajador.add(MSInfoProgramado16);

        MSInfoProgramado14.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        MSInfoProgramado14.setText("Registro Presentacion");
        MSInfoProgramado14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MSInfoProgramado14ActionPerformed(evt);
            }
        });
        JMTrabajador.add(MSInfoProgramado14);

        menuBar.add(JMTrabajador);

        JMRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/procesos.png"))); // NOI18N
        JMRegistro.setText("Procesos");
        JMRegistro.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N

        MSInfoProgramado7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        MSInfoProgramado7.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        MSInfoProgramado7.setText("Venta");
        MSInfoProgramado7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MSInfoProgramado7ActionPerformed(evt);
            }
        });
        JMRegistro.add(MSInfoProgramado7);

        MSInfoProgramado8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        MSInfoProgramado8.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        MSInfoProgramado8.setText("Gestion Venta");
        MSInfoProgramado8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MSInfoProgramado8ActionPerformed(evt);
            }
        });
        JMRegistro.add(MSInfoProgramado8);

        MSInfoProgramado11.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        MSInfoProgramado11.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        MSInfoProgramado11.setText("Compra");
        MSInfoProgramado11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MSInfoProgramado11ActionPerformed(evt);
            }
        });
        JMRegistro.add(MSInfoProgramado11);

        MSInfoProgramado9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        MSInfoProgramado9.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        MSInfoProgramado9.setText("Gestion Compra");
        MSInfoProgramado9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MSInfoProgramado9ActionPerformed(evt);
            }
        });
        JMRegistro.add(MSInfoProgramado9);

        menuBar.add(JMRegistro);

        JMReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/reportes.png"))); // NOI18N
        JMReporte.setText(" Reporte ");
        JMReporte.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N

        MSInfoProgramado5.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        MSInfoProgramado5.setText("Lista Productos");
        MSInfoProgramado5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MSInfoProgramado5ActionPerformed(evt);
            }
        });
        JMReporte.add(MSInfoProgramado5);

        JMRegistro3.setText("Reportes Ventas");
        JMRegistro3.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N

        MSInfoProgramado21.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        MSInfoProgramado21.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        MSInfoProgramado21.setText("Reporte Diario");
        MSInfoProgramado21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MSInfoProgramado21ActionPerformed(evt);
            }
        });
        JMRegistro3.add(MSInfoProgramado21);

        MSInfoProgramado24.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        MSInfoProgramado24.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        MSInfoProgramado24.setText("Reporte Mensual");
        MSInfoProgramado24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MSInfoProgramado24ActionPerformed(evt);
            }
        });
        JMRegistro3.add(MSInfoProgramado24);

        MSInfoProgramado26.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        MSInfoProgramado26.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        MSInfoProgramado26.setText("Reporte Mensual Fecha Venta");
        MSInfoProgramado26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MSInfoProgramado26ActionPerformed(evt);
            }
        });
        JMRegistro3.add(MSInfoProgramado26);

        JMReporte.add(JMRegistro3);

        JMRegistro2.setText("Reportes Compras");
        JMRegistro2.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N

        MSInfoProgramado15.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        MSInfoProgramado15.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        MSInfoProgramado15.setText("Reporte Diario");
        MSInfoProgramado15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MSInfoProgramado15ActionPerformed(evt);
            }
        });
        JMRegistro2.add(MSInfoProgramado15);

        MSInfoProgramado22.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        MSInfoProgramado22.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        MSInfoProgramado22.setText("Reporte Mensual");
        MSInfoProgramado22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MSInfoProgramado22ActionPerformed(evt);
            }
        });
        JMRegistro2.add(MSInfoProgramado22);

        MSInfoProgramado23.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        MSInfoProgramado23.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        MSInfoProgramado23.setText("Reporte Mensual Fecha Compra");
        MSInfoProgramado23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MSInfoProgramado23ActionPerformed(evt);
            }
        });
        JMRegistro2.add(MSInfoProgramado23);

        JMReporte.add(JMRegistro2);

        menuBar.add(JMReporte);

        JMSeguridad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/seguridad.png"))); // NOI18N
        JMSeguridad.setText(" Seguridad ");
        JMSeguridad.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N

        MSInfoProgramado19.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        MSInfoProgramado19.setText("Cambio de Contraseña");
        MSInfoProgramado19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MSInfoProgramado19ActionPerformed(evt);
            }
        });
        JMSeguridad.add(MSInfoProgramado19);

        MSInfoProgramado20.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        MSInfoProgramado20.setText("Informacion Desarrollador");
        MSInfoProgramado20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MSInfoProgramado20ActionPerformed(evt);
            }
        });
        JMSeguridad.add(MSInfoProgramado20);

        menuBar.add(JMSeguridad);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 921, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 171, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void iconoSistema() {

    }


    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        this.dispose();
        System.exit(0);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void MSInfoProgramadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MSInfoProgramadoActionPerformed
        try {
            JFUnidadMedida unidadMedida = new JFUnidadMedida();
            unidadMedida.setVisible(true);
            unidadMedida.setLocationRelativeTo(null);
        } catch (Exception e) {
            MetodosFunciones.mensajeError(Ferreteria.mensajeError, Ferreteria.mensajeTitulo);
        }
    }//GEN-LAST:event_MSInfoProgramadoActionPerformed

    private void MSInfoProgramado5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MSInfoProgramado5ActionPerformed
        try {
            JFReporteListaProductos r = new JFReporteListaProductos();
            r.setLocationRelativeTo(null);
            r.setVisible(true);
        } catch (Exception e) {
            MetodosFunciones.mensajeError(Ferreteria.mensajeError + "/n" + e.getMessage(), Ferreteria.mensajeTitulo);
        }
    }//GEN-LAST:event_MSInfoProgramado5ActionPerformed


    private void MSInfoProgramado7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MSInfoProgramado7ActionPerformed

        try {

            JFVenta venta = new JFVenta();
            venta.setLocationRelativeTo(null);
            venta.setVisible(true);
        } catch (Exception e) {
            MetodosFunciones.mensajeError(Ferreteria.mensajeError, Ferreteria.mensajeTitulo);
        }


    }//GEN-LAST:event_MSInfoProgramado7ActionPerformed

    private void MSInfoProgramado10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MSInfoProgramado10ActionPerformed
        try {

            JFPrecentacion pre = new JFPrecentacion();
            pre.setVisible(true);
            pre.setLocationRelativeTo(null);
        } catch (Exception e) {
            MetodosFunciones.mensajeError(Ferreteria.mensajeError, Ferreteria.mensajeTitulo);
        }
    }//GEN-LAST:event_MSInfoProgramado10ActionPerformed

    private void MSInfoProgramado19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MSInfoProgramado19ActionPerformed
        try {
            JFCambioContraseña c = new JFCambioContraseña();
            c.setLocationRelativeTo(null);
            c.setVisible(true);
        } catch (Exception e) {
            MetodosFunciones.mensajeError(Ferreteria.mensajeError + "\n" + e.getMessage(), Ferreteria.mensajeTitulo);
        }
    }//GEN-LAST:event_MSInfoProgramado19ActionPerformed

    private void MSInfoProgramado11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MSInfoProgramado11ActionPerformed
        // TODO add your handling code here:

        try {

            JFCompras compra = new JFCompras();
            compra.setLocationRelativeTo(null);
            compra.setVisible(true);
        } catch (Exception e) {
            MetodosFunciones.mensajeError(Ferreteria.mensajeError + "\n" + e.getMessage(), Ferreteria.mensajeTitulo);
        }

    }//GEN-LAST:event_MSInfoProgramado11ActionPerformed

    private void MSInfoProgramado12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MSInfoProgramado12ActionPerformed
        try {

            JFProducto pro = new JFProducto();
            pro.setVisible(true);
            pro.setLocationRelativeTo(null);

        } catch (Exception e) {
            MetodosFunciones.mensajeError(Ferreteria.mensajeError, Ferreteria.mensajeTitulo);
        }

    }//GEN-LAST:event_MSInfoProgramado12ActionPerformed

    private void buttonTask1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTask1ActionPerformed

        int op = JOptionPane.showConfirmDialog(this, Ferreteria.mensajeSalirSistema, Ferreteria.mensajeTitulo, JOptionPane.YES_OPTION);
        if (op == JOptionPane.YES_OPTION) {
            this.dispose();
            System.exit(EXIT_ON_CLOSE);
        }
    }//GEN-LAST:event_buttonTask1ActionPerformed

    private void MSInfoProgramado13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MSInfoProgramado13ActionPerformed
        try {

            JFCategoriaProducto cat = new JFCategoriaProducto();
            cat.setVisible(true);
            cat.setLocationRelativeTo(null);

        } catch (Exception e) {
            MetodosFunciones.mensajeError(Ferreteria.mensajeError, Ferreteria.mensajeTitulo);
        }
    }//GEN-LAST:event_MSInfoProgramado13ActionPerformed

    private void MSInfoProgramado14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MSInfoProgramado14ActionPerformed
        // TODO add your handling code here:
        try {
            JFProductoPresentacion proPre = new JFProductoPresentacion();
            proPre.setVisible(true);
            proPre.setLocationRelativeTo(null);
        } catch (Exception e) {
            MetodosFunciones.mensajeError(Ferreteria.mensajeError, Ferreteria.mensajeTitulo);
        }


    }//GEN-LAST:event_MSInfoProgramado14ActionPerformed

    private void MSInfoProgramado15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MSInfoProgramado15ActionPerformed

        try {

            JFIngresoDiario r = new JFIngresoDiario();
            r.setLocationRelativeTo(null);
            r.setVisible(true);
        } catch (Exception e) {
            MetodosFunciones.mensajeError(Ferreteria.mensajeErrorReporte, Ferreteria.mensajeTitulo);
            this.dispose();
        }


    }//GEN-LAST:event_MSInfoProgramado15ActionPerformed

    private void MSInfoProgramado22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MSInfoProgramado22ActionPerformed

        try {
            JFIngresoMensual r = new JFIngresoMensual();
            r.setLocationRelativeTo(null);
            r.setVisible(true);
        } catch (Exception e) {
            MetodosFunciones.mensajeError(Ferreteria.mensajeErrorReporte, Ferreteria.mensajeTitulo);
            this.dispose();
        }

    }//GEN-LAST:event_MSInfoProgramado22ActionPerformed

    private void MSInfoProgramado21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MSInfoProgramado21ActionPerformed
        try {
            JFSalidaDiaria r = new JFSalidaDiaria();
            r.setLocationRelativeTo(null);
            r.setVisible(true);
        } catch (Exception e) {
            MetodosFunciones.mensajeError(Ferreteria.mensajeErrorReporte, Ferreteria.mensajeTitulo);
            this.dispose();
        }

    }//GEN-LAST:event_MSInfoProgramado21ActionPerformed

    private void MSInfoProgramado24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MSInfoProgramado24ActionPerformed
        try {
            JFVentasMensuales r = new JFVentasMensuales();
            r.setLocationRelativeTo(null);
            r.setVisible(true);
        } catch (Exception e) {
            MetodosFunciones.mensajeError(Ferreteria.mensajeErrorReporte, Ferreteria.mensajeTitulo);
            this.dispose();
        }
    }//GEN-LAST:event_MSInfoProgramado24ActionPerformed

    private void MSInfoProgramado20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MSInfoProgramado20ActionPerformed

        JFInformacionDesarrollador info = new JFInformacionDesarrollador();
        info.setLocationRelativeTo(null);
        info.setVisible(true);

    }//GEN-LAST:event_MSInfoProgramado20ActionPerformed

    private void MSInfoProgramado8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MSInfoProgramado8ActionPerformed

        try {
            JFListaVentasGestion g = new JFListaVentasGestion();
            g.setLocationRelativeTo(null);
            g.setVisible(true);
        } catch (Exception e) {
            MetodosFunciones.mensajeError(Ferreteria.mensajeError + "\n " + e.getMessage(), Ferreteria.mensajeTitulo);
        }

// TODO add your handling code here:
    }//GEN-LAST:event_MSInfoProgramado8ActionPerformed

    private void MSInfoProgramado9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MSInfoProgramado9ActionPerformed
        try {
            JFListaComprasVentas g = new JFListaComprasVentas();
            g.setLocationRelativeTo(null);
            g.setVisible(true);
        } catch (Exception e) {
            MetodosFunciones.mensajeError(Ferreteria.mensajeError + "\n " + e.getMessage(), Ferreteria.mensajeTitulo);
        }
    }//GEN-LAST:event_MSInfoProgramado9ActionPerformed

    private void MSInfoProgramado16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MSInfoProgramado16ActionPerformed

        try {
            JFProveedor g = new JFProveedor();
            g.setLocationRelativeTo(null);
            g.setVisible(true);
        } catch (Exception e) {
            MetodosFunciones.mensajeError(Ferreteria.mensajeError + "\n " + e.getMessage(), Ferreteria.mensajeTitulo);
        }

    }//GEN-LAST:event_MSInfoProgramado16ActionPerformed

    private void MSInfoProgramado23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MSInfoProgramado23ActionPerformed

        try {
            JFIngresoMensualFechaCompra r = new JFIngresoMensualFechaCompra();
            r.setLocationRelativeTo(null);
            r.setVisible(true);
        } catch (Exception e) {
            MetodosFunciones.mensajeError(Ferreteria.mensajeErrorReporte, Ferreteria.mensajeTitulo);
            this.dispose();
        }
        
    }//GEN-LAST:event_MSInfoProgramado23ActionPerformed

    private void MSInfoProgramado26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MSInfoProgramado26ActionPerformed
        // TODO add your handling code here:
        
        try {
            JFVentasMensualesFechaVenta r = new JFVentasMensualesFechaVenta();
            r.setLocationRelativeTo(null);
            r.setVisible(true);
        } catch (Exception e) {
            MetodosFunciones.mensajeError(Ferreteria.mensajeErrorReporte, Ferreteria.mensajeTitulo);
            this.dispose();
        }
        
        
    }//GEN-LAST:event_MSInfoProgramado26ActionPerformed

    
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
            java.util.logging.Logger.getLogger(JFPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFPrincipal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu JMRegistro;
    private javax.swing.JMenu JMRegistro2;
    private javax.swing.JMenu JMRegistro3;
    private javax.swing.JMenu JMReporte;
    private javax.swing.JMenu JMSeguridad;
    private javax.swing.JMenu JMTrabajador;
    private javax.swing.JMenu MIniciar;
    private javax.swing.JMenuItem MSInfoProgramado;
    private javax.swing.JMenuItem MSInfoProgramado10;
    private javax.swing.JMenuItem MSInfoProgramado11;
    private javax.swing.JMenuItem MSInfoProgramado12;
    private javax.swing.JMenuItem MSInfoProgramado13;
    private javax.swing.JMenuItem MSInfoProgramado14;
    private javax.swing.JMenuItem MSInfoProgramado15;
    private javax.swing.JMenuItem MSInfoProgramado16;
    private javax.swing.JMenuItem MSInfoProgramado19;
    private javax.swing.JMenuItem MSInfoProgramado20;
    private javax.swing.JMenuItem MSInfoProgramado21;
    private javax.swing.JMenuItem MSInfoProgramado22;
    private javax.swing.JMenuItem MSInfoProgramado23;
    private javax.swing.JMenuItem MSInfoProgramado24;
    private javax.swing.JMenuItem MSInfoProgramado26;
    private javax.swing.JMenuItem MSInfoProgramado5;
    private javax.swing.JMenuItem MSInfoProgramado7;
    private javax.swing.JMenuItem MSInfoProgramado8;
    private javax.swing.JMenuItem MSInfoProgramado9;
    private org.edisoncor.gui.button.ButtonTask buttonTask1;
    private org.jdesktop.swingx.calendar.DateUtils dateUtils1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuBar jMenuBar4;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JMenuBar menuBar;
    private org.edisoncor.gui.panel.Panel panel1;
    private suavena.WDate wDate1;
    // End of variables declaration//GEN-END:variables

}
