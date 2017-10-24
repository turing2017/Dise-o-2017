/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.View.Admin.GestionarEmpresaAdherida;

import exceptions.Excepciones;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import sistemapagoimpuestos.Controller.ControladorGestionarEmpresaAdherida;
import sistemapagoimpuestos.Dto.DTOEmpresaExistente;


public class IUGestionarEmpresaAdheridaModificacion extends javax.swing.JFrame {

    DTOEmpresaExistente dtoEe = new DTOEmpresaExistente();
    String nombreAntiguo;
   ControladorGestionarEmpresaAdherida controlador = new ControladorGestionarEmpresaAdherida();
    public IUGestionarEmpresaAdheridaModificacion(DTOEmpresaExistente dtoEe) {
        initComponents();
        this.setLocationRelativeTo(null);
        nombreAntiguo = dtoEe.getNombreDTOEmpresaExistente();
        TextField_Cuit.setText(dtoEe.getCuitDTOEmpresaExistente());
        TextField_Nombre.setText(dtoEe.getNombreDTOEmpresaExistente());
        TextField_Direccion.setText(dtoEe.getDireccionDTOEmpresaExistente());
        CheckBox_Habilitada.setText(dtoEe.getHabilitadaDTOEmpresaExistente());
        }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        CheckBox_Habilitada = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TextField_Nombre = new javax.swing.JTextField();
        TextField_Direccion = new javax.swing.JTextField();
        Button_Guardar = new javax.swing.JButton();
        Button_Cancelar = new javax.swing.JButton();
        TextField_Cuit = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel3.setText("Direccion");

        jLabel2.setText("Nombre");

        CheckBox_Habilitada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckBox_HabilitadaActionPerformed(evt);
            }
        });

        jLabel1.setText("Cuit");

        jLabel4.setText("Habilitada ");

        TextField_Nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextField_NombreActionPerformed(evt);
            }
        });

        TextField_Direccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextField_DireccionActionPerformed(evt);
            }
        });

        Button_Guardar.setText("Guardar");
        Button_Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_GuardarActionPerformed(evt);
            }
        });

        Button_Cancelar.setText("Cancelar");
        Button_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_CancelarActionPerformed(evt);
            }
        });

        TextField_Cuit.setEditable(false);
        TextField_Cuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextField_CuitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addComponent(Button_Cancelar)
                        .addGap(19, 19, 19)
                        .addComponent(Button_Guardar)
                        .addContainerGap(65, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addGap(98, 98, 98)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TextField_Direccion)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(CheckBox_Habilitada)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(18, 112, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TextField_Nombre, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                                    .addComponent(TextField_Cuit))))
                        .addGap(30, 30, 30))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TextField_Cuit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TextField_Nombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TextField_Direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(CheckBox_Habilitada))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_Cancelar)
                    .addComponent(Button_Guardar))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    private void Button_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_GuardarActionPerformed
   
        String cuit= TextField_Cuit.getText().trim();
        String nombre = TextField_Nombre.getText().trim();
        String direccion = TextField_Direccion.getText().trim();
        boolean habilitada =  CheckBox_Habilitada.isSelected();
        controlador.modificarEmpresa(cuit, nombre, nombreAntiguo, direccion, habilitada);
        this.dispose();
    
    
    }//GEN-LAST:event_Button_GuardarActionPerformed

    private void Button_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_CancelarActionPerformed
         this.dispose();
    }//GEN-LAST:event_Button_CancelarActionPerformed

    private void TextField_CuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextField_CuitActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_TextField_CuitActionPerformed

    private void TextField_NombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextField_NombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextField_NombreActionPerformed

    private void TextField_DireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextField_DireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextField_DireccionActionPerformed

    private void CheckBox_HabilitadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckBox_HabilitadaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckBox_HabilitadaActionPerformed

   

    public JCheckBox getCheckBox_Habilitada() {
        return CheckBox_Habilitada;
    }

    public void setCheckBox_Habilitada(JCheckBox CheckBox_Habilitada) {
        this.CheckBox_Habilitada = CheckBox_Habilitada;
    }

    public JTextField getTextField_Cuit() {
        return TextField_Cuit;
    }

    public void setTextField_Cuit(JTextField TextField_Cuit) {
        this.TextField_Cuit = TextField_Cuit;
    }

    public JTextField getTextField_Direccion() {
        return TextField_Direccion;
    }

    public void setTextField_Direccion(JTextField TextField_Direccion) {
        this.TextField_Direccion = TextField_Direccion;
    }

    public JTextField getTextField_Nombre() {
        return TextField_Nombre;
    }

    public void setTextField_Nombre(JTextField TextField_Nombre) {
        this.TextField_Nombre = TextField_Nombre;
    }



    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Cancelar;
    private javax.swing.JButton Button_Guardar;
    private javax.swing.JCheckBox CheckBox_Habilitada;
    private javax.swing.JTextField TextField_Cuit;
    private javax.swing.JTextField TextField_Direccion;
    private javax.swing.JTextField TextField_Nombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
