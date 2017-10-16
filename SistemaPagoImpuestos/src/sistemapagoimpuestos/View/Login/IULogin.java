package sistemapagoimpuestos.View.Login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import sistemapagoimpuestos.Controller.ControladorLoguearUsuario;

/**
 *
 * @author Rodri
 */
public class IULogin extends javax.swing.JFrame {

    ControladorLoguearUsuario controlador = new ControladorLoguearUsuario();
    
    public IULogin() {
        initComponents();
        textfield_password.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    nombreUsuarioIngres = textfield_usuario.getText();
                    passwordUsuarioIngres = textfield_password.getText();
                    controlador.buscarUsuario(nombreUsuarioIngres, passwordUsuarioIngres);
                    dispose();
        } catch(IndexOutOfBoundsException e1){
            exceptions.Excepciones.getInstance().usuarioNoValido();
        }
            }});
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        label_usuario = new javax.swing.JLabel();
        label_password = new javax.swing.JLabel();
        textfield_usuario = new javax.swing.JTextField();
        button_entrar = new javax.swing.JButton();
        textfield_password = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLabel1.setText("Acceso Sistema Pago de Impuestos");

        label_usuario.setText("Usuario");

        label_password.setText("Contraseña");

        textfield_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textfield_usuarioActionPerformed(evt);
            }
        });

        button_entrar.setText("Entrar");
        button_entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_entrarActionPerformed(evt);
            }
        });

        textfield_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textfield_passwordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_password)
                            .addComponent(label_usuario))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textfield_usuario, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                            .addComponent(textfield_password))))
                .addContainerGap(111, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(button_entrar)
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_usuario)
                    .addComponent(textfield_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_password)
                    .addComponent(textfield_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addComponent(button_entrar)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private static String nombreUsuarioIngres;
    private String passwordUsuarioIngres;

    public String getNombreUsuarioIngres() {
        return nombreUsuarioIngres;
    }

    public static void setNombreUsuarioIngres(String nombreUsuarioIngres) {
        IULogin.nombreUsuarioIngres = nombreUsuarioIngres;
    }
    
    public IULogin(String nombreUsuarioIngres){
        IULogin.nombreUsuarioIngres = nombreUsuarioIngres;
    } 

    private void button_entrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_entrarActionPerformed

        try{
            nombreUsuarioIngres = textfield_usuario.getText();
            passwordUsuarioIngres = textfield_password.getText();
            controlador.buscarUsuario(nombreUsuarioIngres, passwordUsuarioIngres);
            this.dispose();
        } catch(IndexOutOfBoundsException e){
            exceptions.Excepciones.getInstance().usuarioNoValido();
        }
    }//GEN-LAST:event_button_entrarActionPerformed

    private void textfield_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textfield_usuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textfield_usuarioActionPerformed

    private void textfield_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textfield_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textfield_passwordActionPerformed

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
            java.util.logging.Logger.getLogger(IULogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IULogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IULogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IULogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IULogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_entrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel label_password;
    private javax.swing.JLabel label_usuario;
    private javax.swing.JPasswordField textfield_password;
    private javax.swing.JTextField textfield_usuario;
    // End of variables declaration//GEN-END:variables
}
