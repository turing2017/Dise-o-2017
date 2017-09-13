package sistemapagoimpuestos.View.Admin.Principal;

import sistemapagoimpuestos.Controller.ControladorGestionarTipoImpuesto;
import sistemapagoimpuestos.Controller.ControladorGestionarTipoUsuario;
import sistemapagoimpuestos.Controller.ControladorGestionarUsuario;
import sistemapagoimpuestos.Utils.MetodosPantalla;

public class IUAdminPantallaPrincipal extends javax.swing.JFrame {

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(button_gestionarTipoUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button_gestionarTipoImpuesto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button_gestionarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(330, Short.MAX_VALUE))
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
                .addContainerGap(331, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_gestionarTipoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_gestionarTipoUsuarioActionPerformed
        ControladorGestionarTipoUsuario.getInstance().iniciar();
        //this.dispose();


    }//GEN-LAST:event_button_gestionarTipoUsuarioActionPerformed

    private void button_gestionarTipoImpuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_gestionarTipoImpuestoActionPerformed
        ControladorGestionarTipoImpuesto.getInstance().iniciar();
        this.dispose();
    }//GEN-LAST:event_button_gestionarTipoImpuestoActionPerformed

    private void button_gestionarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_gestionarUsuarioActionPerformed
        ControladorGestionarUsuario.getInstance().iniciar();
        this.dispose();
    }//GEN-LAST:event_button_gestionarUsuarioActionPerformed

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
    private javax.swing.JButton button_gestionarTipoImpuesto;
    private javax.swing.JButton button_gestionarTipoUsuario;
    private javax.swing.JButton button_gestionarUsuario;
    private javax.swing.JLabel label_fecha;
    private javax.swing.JLabel label_nombre;
    // End of variables declaration//GEN-END:variables
}
