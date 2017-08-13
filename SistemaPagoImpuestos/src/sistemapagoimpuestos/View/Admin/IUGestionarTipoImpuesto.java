package sistemapagoimpuestos.View.Admin;

import javax.swing.JFrame;
import sistemapagoimpuestos.Controller.ControladorGestionarTipoImpuesto;

/**
 *
 * @author lunamarcos
 */
public class IUGestionarTipoImpuesto extends javax.swing.JFrame {

    /**
     * Creates new form IUGestionarTipoImpuesto
     */
    public IUGestionarTipoImpuesto() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_codigo = new javax.swing.JLabel();
        textfield_codigo = new javax.swing.JTextField();
        button_consultar = new javax.swing.JButton();
        button_continuar = new javax.swing.JButton();
        button_nuevo = new javax.swing.JButton();
        separator_horizontal = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label_codigo.setText("Código Tipo de Impuesto");

        button_consultar.setText("Consultar");
        button_consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_consultarActionPerformed(evt);
            }
        });

        button_continuar.setText("Continuar");
        button_continuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_continuarActionPerformed(evt);
            }
        });

        button_nuevo.setText("Nuevo");
        button_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_nuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(button_consultar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(button_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
            .addGroup(layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(button_continuar)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label_codigo)
                        .addGap(58, 58, 58)
                        .addComponent(textfield_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(126, Short.MAX_VALUE))
            .addComponent(separator_horizontal)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_codigo)
                    .addComponent(textfield_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(button_continuar)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(separator_horizontal, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(button_consultar)
                            .addComponent(button_nuevo))
                        .addGap(41, 41, 41))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void button_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_nuevoActionPerformed
        // TODO add your handling code here:
        // Le paso al controlador la opción seleccionada
        controlador.opcionSeleccionada("Alta");
        
    }//GEN-LAST:event_button_nuevoActionPerformed

    private void button_continuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_continuarActionPerformed
        // TODO add your handling code here:
        // Le paso al controlador la opción seleccionada
        controlador.opcionSeleccionada("Modificar");
    }//GEN-LAST:event_button_continuarActionPerformed

    private void button_consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_consultarActionPerformed
        // TODO add your handling code here:
        // Le paso al controlador la opción seleccionada
        controlador.opcionSeleccionada("Consultar");
    }//GEN-LAST:event_button_consultarActionPerformed

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
            java.util.logging.Logger.getLogger(IUGestionarTipoImpuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IUGestionarTipoImpuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IUGestionarTipoImpuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IUGestionarTipoImpuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                IUGestionarTipoImpuesto pantallaPrincipal = new IUGestionarTipoImpuesto();
                pantallaPrincipal.setVisible(true);
            }
        });
    }
    
    ControladorGestionarTipoImpuesto controlador = new ControladorGestionarTipoImpuesto();
    
    // Metodo iniciar
    public void iniciar(){
        //ControladorGestionarTipoImpuesto controlador = new ControladorGestionarTipoImpuesto();
        controlador.iniciar();
    }
    
    // Metodo nuevoTipoImpuesto (crea un tipoImpuesto)
    public void nuevoTipoImpuesto(int codigoTipoImpuestoIngres, String nombreTipoImpuestoIngres, boolean esMontoEditableIngres){
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_consultar;
    private javax.swing.JButton button_continuar;
    private javax.swing.JButton button_nuevo;
    private javax.swing.JLabel label_codigo;
    private javax.swing.JSeparator separator_horizontal;
    private javax.swing.JTextField textfield_codigo;
    // End of variables declaration//GEN-END:variables
}