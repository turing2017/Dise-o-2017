package sistemapagoimpuestos.View.Admin;

import sistemapagoimpuestos.Controller.ControladorGestionarTipoImpuesto;
import sistemapagoimpuestos.Dto.DTOTipoImpuesto;

/**
 *
 * @author lunamarcos
 */
public class IUGestionarTipoImpuestoModificar extends javax.swing.JFrame {

    /**
     * Creates new form IUGestionarTipoImpuestoModificar
     */
    public IUGestionarTipoImpuestoModificar() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_nombre = new javax.swing.JLabel();
        label_deshabilitar = new javax.swing.JLabel();
        label_esEditable = new javax.swing.JLabel();
        textfield_nombre = new javax.swing.JTextField();
        checkbox_deshabilitar = new javax.swing.JCheckBox();
        checkbox_esEditable = new javax.swing.JCheckBox();
        button_modificar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label_nombre.setText("Nuevo nombre");
        label_nombre.setToolTipText("");

        label_deshabilitar.setText("Deshabilitar");

        label_esEditable.setText("Es editable");

        textfield_nombre.setToolTipText("");
        textfield_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textfield_nombreActionPerformed(evt);
            }
        });

        button_modificar.setText("Modificar");
        button_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_modificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(button_modificar)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_nombre)
                            .addComponent(label_deshabilitar)
                            .addComponent(label_esEditable))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkbox_esEditable)
                            .addComponent(checkbox_deshabilitar)
                            .addComponent(textfield_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_nombre)
                    .addComponent(textfield_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_deshabilitar)
                    .addComponent(checkbox_deshabilitar))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_esEditable)
                    .addComponent(checkbox_esEditable))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(button_modificar)
                .addGap(52, 52, 52))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void button_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_modificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button_modificarActionPerformed

    private void textfield_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textfield_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textfield_nombreActionPerformed

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
            java.util.logging.Logger.getLogger(IUGestionarTipoImpuestoModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IUGestionarTipoImpuestoModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IUGestionarTipoImpuestoModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IUGestionarTipoImpuestoModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // Asociacion con el controlador
                ControladorGestionarTipoImpuesto controlador = new ControladorGestionarTipoImpuesto();
                IUGestionarTipoImpuestoModificar pantallaModificar = new IUGestionarTipoImpuestoModificar();
                // Obtengo el DTOTipoImpuesto
                DTOTipoImpuesto dto = new DTOTipoImpuesto();
                dto = controlador.obtenerTipoImpuesto();
               // setear(dto, );
                
            }
        });
    }
    
    // Seteo lo que viene del DTO
    public static void setear(DTOTipoImpuesto dto, javax.swing.JTextField textfieldNombre){  
        textfieldNombre.setText("Test");
    }
    
    // Getters
    public javax.swing.JTextField getTextfield_nombre() {
        return this.textfield_nombre;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_modificar;
    private javax.swing.JCheckBox checkbox_deshabilitar;
    private javax.swing.JCheckBox checkbox_esEditable;
    private javax.swing.JLabel label_deshabilitar;
    private javax.swing.JLabel label_esEditable;
    private javax.swing.JLabel label_nombre;
    private javax.swing.JTextField textfield_nombre;
    // End of variables declaration//GEN-END:variables
}