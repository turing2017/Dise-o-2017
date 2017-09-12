package sistemapagoimpuestos.View.Admin.GestionarUsuario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JTextField;
import sistemapagoimpuestos.Controller.ControladorGestionarUsuario;
import sistemapagoimpuestos.Dto.DTOEmpresa;
import sistemapagoimpuestos.Dto.DTOTipoUsuario;
import sistemapagoimpuestos.View.Admin.GestionarUsuario.IUGestionarUsuario;
/**
 *
 * @author Rodri
 */
public class IUGestionarUsuarioModificar extends javax.swing.JFrame {
    
    String nombreUsuario;
    String contraseñaNueva;
    boolean esHabilitado;
    String tipoUsuarioSelec;
    String empresaSelec;
    
    
    public IUGestionarUsuarioModificar() {
        initComponents();
        setearComboTipoUsuario();
        setearComboEmpresa();
        label_Empresa.setVisible(false);
        combo_Empresa.setVisible(false);
        combo_TipoUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!combo_TipoUsuario.getSelectedItem().toString().equals("Responsable")) {
                    label_Empresa.setVisible(true);
                    combo_Empresa.setVisible(true);
                }
                else{
                    label_Empresa.setVisible(false);
                    combo_Empresa.setVisible(false);
                }
            }
        });
    }
    
    private void setearComboTipoUsuario(){
        List<DTOTipoUsuario> listado = ControladorGestionarUsuario.getInstance().setearComboTipoUsuario();
        for (int i = 0; i < listado.size(); i++) {
            combo_TipoUsuario.addItem(listado.get(i).getNombreDTOTipoUsuario());
        }
    }
    
    private void setearComboEmpresa() {
        List<DTOEmpresa> listado = ControladorGestionarUsuario.getInstance().setearComboEmpresa();
        for (int i = 0; i < listado.size(); i++) {
            combo_Empresa.addItem(listado.get(i).getNombreDTOEmpresa());
    }
    }
    
    public void setearNombreUsuario(String nombreUsuario){
        text_nombreUsuario.setText(nombreUsuario);
        this.nombreUsuario = nombreUsuario;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        text_nombreUsuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        checkbox_habilitado = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        label_Empresa = new javax.swing.JLabel();
        combo_TipoUsuario = new javax.swing.JComboBox<>();
        combo_Empresa = new javax.swing.JComboBox<>();
        button_Aceptar = new javax.swing.JButton();
        button_Cancelar = new javax.swing.JButton();
        passwordField1 = new javax.swing.JPasswordField();
        passwordField2 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Modificar Usuario");

        jLabel5.setText("Nombre Usuario:");

        jLabel1.setText("Contraseña nueva:");

        jLabel2.setText("Repetir contraseña:");

        text_nombreUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        text_nombreUsuario.setEnabled(false);
        text_nombreUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_nombreUsuarioActionPerformed(evt);
            }
        });

        jLabel3.setText("Habilitado");

        checkbox_habilitado.setSelected(true);
        checkbox_habilitado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkbox_habilitadoActionPerformed(evt);
            }
        });

        jLabel6.setText("Tipo Usuario:");

        label_Empresa.setText("Empresa Asociada:");

        button_Aceptar.setText("Aceptar");
        button_Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_AceptarActionPerformed(evt);
            }
        });

        button_Cancelar.setText("Cancelar");
        button_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_CancelarActionPerformed(evt);
            }
        });

        passwordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(text_nombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(button_Aceptar)
                                        .addComponent(label_Empresa)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(checkbox_habilitado)
                                            .addComponent(combo_TipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(combo_Empresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(button_Cancelar))
                                        .addGap(119, 119, 119))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(113, 113, 113)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(passwordField1)
                                            .addComponent(passwordField2))))))
                        .addGap(44, 44, 44))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(181, 181, 181)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(text_nombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(passwordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(passwordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(checkbox_habilitado))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(combo_TipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_Empresa)
                    .addComponent(combo_Empresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_Aceptar)
                    .addComponent(button_Cancelar))
                .addContainerGap(73, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkbox_habilitadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkbox_habilitadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkbox_habilitadoActionPerformed

    private void button_AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_AceptarActionPerformed
        if(passwordField1.equals(passwordField2)){
            char[] pass = passwordField1.getPassword();
            String passwordIngres = new String(pass);
            contraseñaNueva = passwordIngres;
        }
        esHabilitado = checkbox_habilitado.isSelected();
        tipoUsuarioSelec = combo_TipoUsuario.getSelectedItem().toString();
        empresaSelec = combo_Empresa.getSelectedItem().toString();
        
        ControladorGestionarUsuario.getInstance().modificarDatosUsuario(nombreUsuario, contraseñaNueva, esHabilitado, tipoUsuarioSelec, empresaSelec);
        this.dispose();
    }//GEN-LAST:event_button_AceptarActionPerformed

    private void button_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_CancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button_CancelarActionPerformed

    private void text_nombreUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_nombreUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_nombreUsuarioActionPerformed

    private void passwordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordField1ActionPerformed

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
            java.util.logging.Logger.getLogger(IUGestionarUsuarioModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IUGestionarUsuarioModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IUGestionarUsuarioModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IUGestionarUsuarioModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IUGestionarUsuarioModificar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_Aceptar;
    private javax.swing.JButton button_Cancelar;
    private javax.swing.JCheckBox checkbox_habilitado;
    private javax.swing.JComboBox<String> combo_Empresa;
    private javax.swing.JComboBox<String> combo_TipoUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel label_Empresa;
    private javax.swing.JPasswordField passwordField1;
    private javax.swing.JPasswordField passwordField2;
    private javax.swing.JTextField text_nombreUsuario;
    // End of variables declaration//GEN-END:variables
}
