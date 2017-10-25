package sistemapagoimpuestos.View.Admin.GestionarTipoImpuesto;

import exceptions.Excepciones;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JLabel;
import sistemapagoimpuestos.Controller.ControladorGestionarTipoImpuesto;
import sistemapagoimpuestos.Dto.DTOEmpresaTipImpItem;

/**
 *
 * @author lunamarcos
 */
public class IUGestionarTipoImpuestoModificarTipoImpuesto extends javax.swing.JFrame {

    ControladorGestionarTipoImpuesto controlador = new ControladorGestionarTipoImpuesto();
    private static List<DTOEmpresaTipImpItem> dTOEmpresaTipImpItemList = new ArrayList<>();

    public static List<DTOEmpresaTipImpItem> getdTOEmpresaTipImpItemList() {
        return dTOEmpresaTipImpItemList;
    }

    public static void setdTOEmpresaTipImpItemList(List<DTOEmpresaTipImpItem> dTOEmpresaTipImpItemList) {
        IUGestionarTipoImpuestoModificarTipoImpuesto.dTOEmpresaTipImpItemList = dTOEmpresaTipImpItemList;
    }

    public String getNombre_actual() {
        return nombre_actual.getText();
    }

    public void setNombre_actual(String nombre_actual) {
        this.nombre_actual.setText(nombre_actual);
    }


    
    public static  void adddTOEmpresaTipImpItemList(DTOEmpresaTipImpItem dTOEmpresaTipImpItem){
         if(dTOEmpresaTipImpItemList==null){
            dTOEmpresaTipImpItemList = new ArrayList<>();
        }
        dTOEmpresaTipImpItemList.add(dTOEmpresaTipImpItem);
    }
    public static void removedTOEmpresaTipImpItemList(int index){
       dTOEmpresaTipImpItemList.remove(index);
    }    
    
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    String cuitEmpresa= null;
    public IUGestionarTipoImpuestoModificarTipoImpuesto( String cuitEmpresa) {
            this.cuitEmpresa = cuitEmpresa;
            initComponents();
    }
 
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
        cancel_button = new javax.swing.JButton();
        label_fecha = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label_nombre.setText("Nombre");
        label_nombre.setToolTipText("");

        label_deshabilitar.setText("Habilitado");

        label_esEditable.setText("Es editable");

        textfield_nombre.setToolTipText("");
        textfield_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textfield_nombreActionPerformed(evt);
            }
        });

        checkbox_habilitado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkbox_habilitadoActionPerformed(evt);
            }
        });

        checkbox_esEditable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkbox_esEditableActionPerformed(evt);
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

        cancel_button.setText("Cancelar");
        cancel_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(310, 310, 310)
                .addComponent(nombre_actual, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_deshabilitar)
                    .addComponent(label_nombre)
                    .addComponent(label_esEditable))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(textfield_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_fecha))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cancel_button)
                        .addGap(77, 77, 77)
                        .addComponent(button_modificar))
                    .addComponent(checkbox_habilitado, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkbox_esEditable))
                .addGap(55, 55, 55))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_nombre, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(textfield_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nombre_actual, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(label_fecha)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(checkbox_habilitado)
                    .addComponent(label_deshabilitar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_esEditable, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkbox_esEditable))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancel_button)
                    .addComponent(button_modificar))
                .addGap(31, 31, 31))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void button_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_modificarActionPerformed
        // TODO add your handling code here:
        if(cuitEmpresa==null){
            try{
            if(textfield_nombre.getText().equals("")){
                textfield_nombre.setText(null);
                throw new java.lang.NumberFormatException();
            }
            controlador.modificarTipoImpuesto(textfield_nombre.getText(), nombre_actual.getText(), checkbox_esEditable.isSelected(), checkbox_habilitado.isSelected());
            this.dispose();
            controlador.iniciar();
        }catch(java.lang.NumberFormatException e){
            Excepciones.getInstance().camposRequerido(Arrays.asList("Nombre"));
        }
        }else{
        try{
            if(textfield_nombre.getText().equals("")){
                textfield_nombre.setText(null);
                throw new java.lang.NumberFormatException();
            }
            controlador.modificarTipoImpuesto(textfield_nombre.getText(), nombre_actual.getText(), checkbox_esEditable.isSelected(), checkbox_habilitado.isSelected());
            this.dispose();
            controlador.iniciar(cuitEmpresa);
        }catch(java.lang.NumberFormatException e){
            Excepciones.getInstance().camposRequerido(Arrays.asList("Nombre"));
        }
        }
    }//GEN-LAST:event_button_modificarActionPerformed

    private void textfield_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textfield_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textfield_nombreActionPerformed

    private void cancel_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_buttonActionPerformed
        this.dispose();
        controlador.iniciar();
    }//GEN-LAST:event_cancel_buttonActionPerformed

    private void checkbox_habilitadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkbox_habilitadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkbox_habilitadoActionPerformed

    private void checkbox_esEditableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkbox_esEditableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkbox_esEditableActionPerformed
    
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
            java.util.logging.Logger.getLogger(IUGestionarTipoImpuestoModificarTipoImpuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IUGestionarTipoImpuestoModificarTipoImpuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IUGestionarTipoImpuestoModificarTipoImpuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IUGestionarTipoImpuestoModificarTipoImpuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // Asociacion con el controlador
           //     IUGestionarTipoImpuestoModificarEmpresa pantallaModificar = new IUGestionarTipoImpuestoModificarEmpresa(cuitEmpresa);

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

    public JLabel getLabel_fecha() {
        return label_fecha;
    }

    public void setLabel_fecha(JLabel label_fecha) {
        this.label_fecha = label_fecha;
    }

    public String getLabel_nombre() {
        return label_nombre.getText();
    }

    public void setLabel_nombre(String nombre) {
        this.label_nombre.setText(nombre);
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_modificar;
    private javax.swing.JButton cancel_button;
    private javax.swing.JCheckBox checkbox_esEditable;
    private javax.swing.JCheckBox checkbox_habilitado;
    private javax.swing.JLabel label_deshabilitar;
    private javax.swing.JLabel label_esEditable;
    private javax.swing.JLabel label_fecha;
    private javax.swing.JLabel label_nombre;
    private javax.swing.JLabel nombre_actual;
    private javax.swing.JTextField textfield_nombre;
    // End of variables declaration//GEN-END:variables
}
