package sistemapagoimpuestos.View.Admin.Principal;

import sistemapagoimpuestos.Controller.ControladorGestionarEmpresaAdherida;
import sistemapagoimpuestos.Controller.ControladorGestionarItem;
import sistemapagoimpuestos.Controller.ControladorGestionarParametrosCalculoComision;
import sistemapagoimpuestos.Controller.ControladorGestionarTipoImpuesto;
import sistemapagoimpuestos.Controller.ControladorGestionarTipoUsuario;
import sistemapagoimpuestos.Controller.ControladorGestionarUsuario;
import sistemapagoimpuestos.Utils.MetodosPantalla;

public class IUAdminPantallaPrincipal extends javax.swing.JFrame {

    ControladorGestionarTipoImpuesto controladorGestTipoImpu = new ControladorGestionarTipoImpuesto();
    ControladorGestionarTipoUsuario controladorGestTipoUsu = new ControladorGestionarTipoUsuario();
    ControladorGestionarUsuario controladorGestUsu = new ControladorGestionarUsuario();
    ControladorGestionarItem gestionarItem = new ControladorGestionarItem();
    ControladorGestionarParametrosCalculoComision calculoComision = new ControladorGestionarParametrosCalculoComision();
    ControladorGestionarEmpresaAdherida gestionarEmpresaAdherida = new ControladorGestionarEmpresaAdherida();
    ControladorGestionarTipoImpuesto controladorGestTipoImp = new ControladorGestionarTipoImpuesto();
        
    public IUAdminPantallaPrincipal() {
        initComponents();
    }
    
    public void mostrarPantallaPrincipal(String nombreUsuarioLogeado, String ultimoAccesoUsuario){
        IUAdminPantallaPrincipal pp = new IUAdminPantallaPrincipal();
        pp.label_nombre.setText("Nombre Usuario: " + nombreUsuarioLogeado );
        pp.label_fecha.setText("Ultimo acceso " + ultimoAccesoUsuario );
        MetodosPantalla.getInstance().setearPantalla(pp);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        button_gestionarTipoUsuario = new javax.swing.JButton();
        button_gestionarTipoImpuesto = new javax.swing.JButton();
        button_gestionarUsuario = new javax.swing.JButton();
        label_nombre = new javax.swing.JLabel();
        label_fecha = new javax.swing.JLabel();
        button_gestionarItem = new javax.swing.JButton();
        button_gestionar_cal_params = new javax.swing.JButton();
        button_gestionarEmpresaAdherida = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        button_gestionarTipoUsuario.setText("Gestionar Tipo Usuario");
        button_gestionarTipoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_gestionarTipoUsuarioActionPerformed(evt);
            }
        });

        button_gestionarTipoImpuesto.setText("Gestionar Tipo Impuesto");
        button_gestionarTipoImpuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_gestionarTipoImpuestoActionPerformed(evt);
            }
        });

        button_gestionarUsuario.setText("Gestionar Usuario");
        button_gestionarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_gestionarUsuarioActionPerformed(evt);
            }
        });

        label_nombre.setText("jLabel1");

        label_fecha.setText("jLabel2");

        button_gestionarItem.setText("Gestionar Item");
        button_gestionarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_gestionarItemActionPerformed(evt);
            }
        });

        button_gestionar_cal_params.setText("Gestionar Calculo Parametros");
        button_gestionar_cal_params.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_gestionar_cal_paramsActionPerformed(evt);
            }
        });

        button_gestionarEmpresaAdherida.setText("Gestionar Empresa Adherida");
        button_gestionarEmpresaAdherida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_gestionarEmpresaAdheridaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(button_gestionarTipoUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button_gestionarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button_gestionarTipoImpuesto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button_gestionarItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button_gestionar_cal_params, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                    .addComponent(button_gestionarEmpresaAdherida, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(286, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_fecha)
                    .addComponent(label_nombre))
                .addGap(90, 90, 90))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(label_nombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(label_fecha)
                .addGap(14, 14, 14)
                .addComponent(button_gestionarTipoUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button_gestionarUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button_gestionarTipoImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button_gestionarItem, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button_gestionar_cal_params)
                .addGap(10, 10, 10)
                .addComponent(button_gestionarEmpresaAdherida)
                .addContainerGap(219, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_gestionarTipoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_gestionarTipoUsuarioActionPerformed
        controladorGestTipoImpu.iniciar();
        this.dispose();
    }//GEN-LAST:event_button_gestionarTipoUsuarioActionPerformed

    private void button_gestionarTipoImpuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_gestionarTipoImpuestoActionPerformed
        controladorGestTipoImp.iniciar();
        this.dispose();
    }//GEN-LAST:event_button_gestionarTipoImpuestoActionPerformed

    private void button_gestionarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_gestionarUsuarioActionPerformed
        controladorGestUsu.iniciar();
        this.dispose();
    }//GEN-LAST:event_button_gestionarUsuarioActionPerformed

    private void button_gestionarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_gestionarItemActionPerformed
        gestionarItem.iniciar();
        this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_button_gestionarItemActionPerformed

    private void button_gestionar_cal_paramsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_gestionar_cal_paramsActionPerformed
        calculoComision.iniciar();
        this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_button_gestionar_cal_paramsActionPerformed

    private void button_gestionarEmpresaAdheridaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_gestionarEmpresaAdheridaActionPerformed
        gestionarEmpresaAdherida.iniciar();
        this.dispose();
    }//GEN-LAST:event_button_gestionarEmpresaAdheridaActionPerformed

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
            java.util.logging.Logger.getLogger(IUAdminPantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IUAdminPantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IUAdminPantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IUAdminPantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IUAdminPantallaPrincipal().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_gestionarEmpresaAdherida;
    private javax.swing.JButton button_gestionarItem;
    private javax.swing.JButton button_gestionarTipoImpuesto;
    private javax.swing.JButton button_gestionarTipoUsuario;
    private javax.swing.JButton button_gestionarUsuario;
    private javax.swing.JButton button_gestionar_cal_params;
    private javax.swing.JLabel label_fecha;
    private javax.swing.JLabel label_nombre;
    // End of variables declaration//GEN-END:variables
}
