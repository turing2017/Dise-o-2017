package sistemapagoimpuestos.View.Admin;

import exceptions.Excepciones;
import java.util.Arrays;
import sistemapagoimpuestos.Controller.ControladorGestionarTipoImpuesto;

/**
 *
 * @author lunamarcos
 */
public class IUGestionarTipoImpuestoAlta extends javax.swing.JFrame {

    /**
     * Creates new form IUGestionarTipoImpuestoAlta
     */
    public IUGestionarTipoImpuestoAlta() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_nombre = new javax.swing.JLabel();
        label_codigo = new javax.swing.JLabel();
        label_esEditable = new javax.swing.JLabel();
        textField_nombre = new javax.swing.JTextField();
        textfield_codigo = new javax.swing.JTextField();
        checkbox_esEditable = new javax.swing.JCheckBox();
        button_crear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label_nombre.setText("Nombre Tipo Impuesto");

        label_codigo.setText("Código Tipo Impuesto");

        label_esEditable.setText("Es editable");

        textField_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField_nombreActionPerformed(evt);
            }
        });

        button_crear.setText("Crear");
        button_crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_crearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label_codigo, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_nombre)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label_esEditable)
                        .addGap(72, 72, 72)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkbox_esEditable)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(button_crear)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textfield_codigo, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                            .addComponent(textField_nombre))))
                .addGap(54, 54, 54))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_nombre)
                    .addComponent(textField_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_codigo)
                    .addComponent(textfield_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_esEditable)
                    .addComponent(checkbox_esEditable))
                .addGap(63, 63, 63)
                .addComponent(button_crear)
                .addGap(58, 58, 58))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void button_crearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_crearActionPerformed
        // Obtengo los valores
        try{
            int codigoTipoImpuesto = Integer.parseInt(textfield_codigo.getText());
            String nombreTipoImpuesto = textField_nombre.getText();
            boolean esMontoEditable = checkbox_esEditable.isSelected();

            ControladorGestionarTipoImpuesto.getInstance().nuevoTipoImpuesto(codigoTipoImpuesto, nombreTipoImpuesto, esMontoEditable);
        }catch(java.lang.NumberFormatException e){
            Excepciones.getInstance().camposRequerido(Arrays.asList("Codigo", "Nombre"));
        }
    }//GEN-LAST:event_button_crearActionPerformed

    private void textField_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_nombreActionPerformed

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
            java.util.logging.Logger.getLogger(IUGestionarTipoImpuestoAlta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IUGestionarTipoImpuestoAlta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IUGestionarTipoImpuestoAlta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IUGestionarTipoImpuestoAlta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IUGestionarTipoImpuestoAlta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_crear;
    private javax.swing.JCheckBox checkbox_esEditable;
    private javax.swing.JLabel label_codigo;
    private javax.swing.JLabel label_esEditable;
    private javax.swing.JLabel label_nombre;
    private javax.swing.JTextField textField_nombre;
    private javax.swing.JTextField textfield_codigo;
    // End of variables declaration//GEN-END:variables
}
