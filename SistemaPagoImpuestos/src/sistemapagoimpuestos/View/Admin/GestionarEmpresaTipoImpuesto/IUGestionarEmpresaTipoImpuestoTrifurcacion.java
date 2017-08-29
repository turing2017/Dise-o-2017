package sistemapagoimpuestos.View.Admin.GestionarEmpresaTipoImpuesto;

import sistemapagoimpuestos.Controller.ControladorGestionarEmpresaTipoImpuesto;

public class IUGestionarEmpresaTipoImpuestoTrifurcacion extends javax.swing.JFrame {

    IUGestionarEmpresaTipoImpuesto pantallaPrincipal;
    IUGestionarEmpresaTipoImpuestoAlta pantallaAlta;
    String nombreTipoImpuesto = pantallaPrincipal.getCombo_TipoImpuesto().getSelectedItem().toString();
    String nombreEmpresa = pantallaPrincipal.getCombo_Empresa().getSelectedItem().toString();
    
    public IUGestionarEmpresaTipoImpuestoTrifurcacion() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        button_Alta = new javax.swing.JButton();
        button_modificar = new javax.swing.JButton();
        button_baja = new javax.swing.JButton();
        button_Atras = new javax.swing.JButton();
        button_Cerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Gestionar Empresa Tipo Impuesto");

        button_Alta.setText("Alta datos");
        button_Alta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_AltaActionPerformed(evt);
            }
        });

        button_modificar.setText("Modificar datos");
        button_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_modificarActionPerformed(evt);
            }
        });

        button_baja.setText("Baja de datos");

        button_Atras.setText("Atras");

        button_Cerrar.setText("Cerrar");
        button_Cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_CerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(button_Atras)
                        .addGap(73, 73, 73)
                        .addComponent(button_Cerrar))
                    .addComponent(button_baja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button_Alta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button_modificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button_Alta)
                .addGap(41, 41, 41)
                .addComponent(button_modificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(button_baja)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_Atras)
                    .addComponent(button_Cerrar))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_AltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_AltaActionPerformed
        if (ControladorGestionarEmpresaTipoImpuesto.getInstance().altaDatos(nombreTipoImpuesto, nombreEmpresa) == null){
            pantallaAlta = new IUGestionarEmpresaTipoImpuestoAlta();
            pantallaAlta.setVisible(true);
        }
    }//GEN-LAST:event_button_AltaActionPerformed

    private void button_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_modificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button_modificarActionPerformed

    private void button_CerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_CerrarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_button_CerrarActionPerformed

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
            java.util.logging.Logger.getLogger(IUGestionarEmpresaTipoImpuestoTrifurcacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IUGestionarEmpresaTipoImpuestoTrifurcacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IUGestionarEmpresaTipoImpuestoTrifurcacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IUGestionarEmpresaTipoImpuestoTrifurcacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new IUGestionarEmpresaTipoImpuestoTrifurcacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_Alta;
    private javax.swing.JButton button_Atras;
    private javax.swing.JButton button_Cerrar;
    private javax.swing.JButton button_baja;
    private javax.swing.JButton button_modificar;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
