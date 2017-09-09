package sistemapagoimpuestos.View.Admin;

import java.sql.*;
import javax.swing.JOptionPane;

public class AdminMenu extends javax.swing.JFrame {
    
    Connection conexion;
    Statement st;    
    ResultSet rs;

    public AdminMenu() {
        
        initComponents();
        LlenarComboTipoImpuesto();
        String seleccionTipoImpuesto = combo_TipoImpuesto.getSelectedItem().toString();
        LlenarComboEmpresa();
        String seleccionEmpresa = combo_Empresa.getSelectedItem().toString();
        VerificarConexion(seleccionTipoImpuesto, seleccionEmpresa);
        
    }
    
    private void LlenarComboEmpresa(){
        //Realizar conexion con la base de datos y recuperar las empresas adheridas
        String query = "SELECT nombreEmpresa FROM empresas";
        
        try{
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pago_impuestos", "root", "root");
            st = conexion.createStatement();
            rs = st.executeQuery(query);
            while (rs.next())
                combo_Empresa.addItem(rs.getString("nombreEmpresa"));
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error en la conexion a base de datos");
        }
        finally{
            try{
            rs.close();
            st.close();
            conexion.close();
            
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error en el cierre de conexion");
        }
        }
            
    }
    
    private void LlenarComboTipoImpuesto(){
        String query = "SELECT nombreTipoImpuesto FROM tipo_impuestos";
        
        try{
        conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pago_impuestos", "root", "root");
        st = conexion.createStatement();
        rs = st.executeQuery(query);
        while (rs.next())
            combo_TipoImpuesto.addItem(rs.getString("nombreTipoImpuesto"));
        
        }catch(Exception e){
            System.out.println("Error en la conexion");
        }
        finally{
            try{
                rs.close();
                st.close();
                rs.close();
            }
            catch (Exception e){
                JOptionPane.showMessageDialog(null, "Error de cierre");
            }
        }
    }
    
    private void VerificarConexion(String seleccionTI, String seleccionE){
        String query = "SELECT urlConexionEmpresaTipoImpuesto FROM empresatipoimpuesto WHERE ";
    }
    /*    try{
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pago_impuestos", "root", "root");
            st = conexion.createStatement();
            rs = st.executeQuery(query);
    }
*/
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        button_Salir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        combo_TipoImpuesto = new javax.swing.JComboBox<>();
        combo_Empresa = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        URL_Text = new javax.swing.JTextField();
        button_Verificar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        button_Salir.setText("Salir");
        button_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_SalirActionPerformed(evt);
            }
        });

        jLabel1.setText("Tipo de Impuesto");

        combo_TipoImpuesto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Seleccionar Tipo de Impuesto-" }));
        combo_TipoImpuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_TipoImpuestoActionPerformed(evt);
            }
        });

        combo_Empresa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Seleccionar Empresa-" }));

        jLabel2.setText("Empresa");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Gestionar Empresa Tipo Impuesto");

        jLabel4.setText("Codigo de Pago Electronico");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel5.setText("URL Conexion");

        URL_Text.setEditable(false);
        URL_Text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                URL_TextActionPerformed(evt);
            }
        });

        button_Verificar.setText("Verificar Conexion");
        button_Verificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_VerificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(button_Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(combo_Empresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(100, 100, 100))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5))
                                    .addGap(53, 53, 53)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(URL_Text)
                                .addComponent(combo_TipoImpuesto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField1)))
                        .addComponent(button_Verificar)))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(combo_TipoImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_Empresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(32, 32, 32)
                .addComponent(button_Verificar)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(URL_Text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(42, 42, 42)
                .addComponent(button_Salir)
                .addGap(19, 19, 19))
        );

        button_Salir.getAccessibleContext().setAccessibleName("button_salir");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_SalirActionPerformed
        // Cierra la ventana
        dispose();
    }//GEN-LAST:event_button_SalirActionPerformed

    private void combo_TipoImpuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_TipoImpuestoActionPerformed

        
    }//GEN-LAST:event_combo_TipoImpuestoActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void URL_TextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_URL_TextActionPerformed
        
    }//GEN-LAST:event_URL_TextActionPerformed

    private void button_VerificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_VerificarActionPerformed
        
    }//GEN-LAST:event_button_VerificarActionPerformed

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
            java.util.logging.Logger.getLogger(AdminMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField URL_Text;
    private javax.swing.JButton button_Salir;
    private javax.swing.JButton button_Verificar;
    private javax.swing.JComboBox<String> combo_Empresa;
    private javax.swing.JComboBox<String> combo_TipoImpuesto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}