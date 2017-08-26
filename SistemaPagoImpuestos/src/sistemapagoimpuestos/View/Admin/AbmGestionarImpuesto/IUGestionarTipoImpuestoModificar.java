package sistemapagoimpuestos.View.Admin.AbmGestionarImpuesto;

import exceptions.Excepciones;
import java.util.Arrays;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
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
        checkbox_habilitado = new javax.swing.JCheckBox();
        checkbox_esEditable = new javax.swing.JCheckBox();
        button_modificar = new javax.swing.JButton();
        nombre_actual = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label_nombre.setText("Nuevo nombre");
        label_nombre.setToolTipText("");

        label_deshabilitar.setText("Habilitado");

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

        nombre_actual.setForeground(new java.awt.Color(240, 240, 240));
        nombre_actual.setText("nombreActual");

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
                            .addComponent(checkbox_habilitado)
                            .addComponent(textfield_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nombre_actual)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_nombre)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textfield_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nombre_actual)))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_deshabilitar)
                    .addComponent(checkbox_habilitado))
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
        try{
            if(textfield_nombre.getText().equals("")){
                textfield_nombre.setText(null);
                throw new java.lang.NumberFormatException();
            }
            ControladorGestionarTipoImpuesto.getInstance().modificarTipoImpuesto(textfield_nombre.getText(), nombre_actual.getText(), checkbox_esEditable.isSelected(), checkbox_habilitado.isSelected());
            this.dispose();
            ControladorGestionarTipoImpuesto.getInstance().iniciar();
        }catch(java.lang.NumberFormatException e){
            Excepciones.getInstance().camposRequerido(Arrays.asList("Nombre"));
        }
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
                dto = controlador.obtenerTipoImpuesto(1);
               // setear(dto, );

            }
        });
    }
    // Getters

    public String getTextfield_nombre() {
        return textfield_nombre.getText();
    }

    public void setTextfield_nombre(String text) {
        this.textfield_nombre.setText(text);
    }


    public boolean getCheckbox_deshabilitar() {
        return checkbox_habilitado.isSelected();
    }

    public void setCheckbox_Habilitar(boolean habilitado) {
        this.checkbox_habilitado.setSelected(habilitado);
    }

    public boolean getCheckbox_esEditable() {
        return checkbox_esEditable.isSelected();
    }

    public void setCheckbox_esEditable(boolean editable) {
        this.checkbox_esEditable.setSelected(editable);
    }

    public String getNombre_actual() {
        return nombre_actual.getText();
    }

    public void setNombre_actual(String nombreActual) {
        this.nombre_actual.setText(nombreActual);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_modificar;
    private javax.swing.JCheckBox checkbox_esEditable;
    private javax.swing.JCheckBox checkbox_habilitado;
    private javax.swing.JLabel label_deshabilitar;
    private javax.swing.JLabel label_esEditable;
    private javax.swing.JLabel label_nombre;
    private javax.swing.JLabel nombre_actual;
    private javax.swing.JTextField textfield_nombre;
    // End of variables declaration//GEN-END:variables
}