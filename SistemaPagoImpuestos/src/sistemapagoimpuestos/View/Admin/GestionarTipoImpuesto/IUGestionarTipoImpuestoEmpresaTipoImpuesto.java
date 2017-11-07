/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.View.Admin.GestionarTipoImpuesto;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import sistemapagoimpuestos.Controller.ControladorGestionarTipoImpuesto;
import sistemapagoimpuestos.Dto.DTOEmpresa;
import sistemapagoimpuestos.Dto.DTOTipoEmpresa;
import sistemapagoimpuestos.Dto.DTOTipoImpuesto;

public class IUGestionarTipoImpuestoEmpresaTipoImpuesto extends javax.swing.JFrame {



    public IUGestionarTipoImpuestoEmpresaTipoImpuesto() {
    }
    
   ControladorGestionarTipoImpuesto controlador = new ControladorGestionarTipoImpuesto();
    public IUGestionarTipoImpuestoEmpresaTipoImpuesto(String cuitEmpresa) {
        initComponents();
        this.setLocationRelativeTo(null);
        DTOEmpresa dtoEmpresa = controlador.buscarEmpresa(cuitEmpresa);
        TextField_Cuit.setText(cuitEmpresa);
        TextField_Nombre.setText(dtoEmpresa.getNombreEmpresa());
       
         
        
        SpinnerNumberModel sf = new SpinnerNumberModel();
        sf.setMinimum(0);
        spinner_Frecuencia.setModel(sf);
        
        
        //TextField_frec.setText(dtoEe.);
        List<DTOTipoEmpresa> listTipoEmpresa = controlador.buscarTipoEmpresa();
        llenarComboTipoEmpresa(listTipoEmpresa);
        List<DTOTipoImpuesto> listTipoImpuesto = controlador.buscarTipoImpuesto();
        llenarComboTipoImpuesto(listTipoImpuesto);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        TextField_Nombre = new javax.swing.JTextField();
        Button_Guardar = new javax.swing.JButton();
        Button_Cancelar = new javax.swing.JButton();
        TextField_Cuit = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        comboBoxTipoImpuesto = new javax.swing.JComboBox<>();
        comboBoxTipoEmpresa = new javax.swing.JComboBox<>();
        label_frec = new javax.swing.JLabel();
        spinner_Frecuencia = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setText("Nombre");

        jLabel1.setText("Cuit");

        TextField_Nombre.setEditable(false);
        TextField_Nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextField_NombreActionPerformed(evt);
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

        jLabel5.setText("Tipo de Impuesto");

        jLabel6.setText("Tipo de Empresa");

        comboBoxTipoImpuesto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Tipo de Impuesto" }));
        comboBoxTipoImpuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxTipoImpuestoActionPerformed(evt);
            }
        });

        comboBoxTipoEmpresa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Tipo de Empresa" }));

        label_frec.setText("Frecuencia Liquidacion en días");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(label_frec))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(comboBoxTipoEmpresa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(comboBoxTipoImpuesto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TextField_Nombre)
                                .addComponent(TextField_Cuit, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(spinner_Frecuencia, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addComponent(Button_Cancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Button_Guardar)
                        .addGap(51, 51, 51))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel2)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TextField_Cuit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(TextField_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(comboBoxTipoImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(comboBoxTipoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spinner_Frecuencia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_frec, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_Cancelar)
                    .addComponent(Button_Guardar))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//Con esto llena el combo del TipoEmpresa
  public void llenarComboTipoEmpresa(List<DTOTipoEmpresa> list){
      comboBoxTipoEmpresa.setSelectedItem("Seleccione Tipo de Empresa");
      for (int i = 0; i < list.size(); i++) { 
           
            DTOTipoEmpresa dTOTipoEmpresa = (DTOTipoEmpresa) list.get(i);
            comboBoxTipoEmpresa.addItem(dTOTipoEmpresa.getNombreTipoEmpresa());
       
           
        }
   
  }
  
  //Con esto llena el combo TipoImpuesto
    public void llenarComboTipoImpuesto(List<DTOTipoImpuesto> list){
        comboBoxTipoImpuesto.setSelectedItem("Seleccione Tipo de Impuesto");
        for (int i = 0; i < list.size(); i++) {
       
            DTOTipoImpuesto dTOTipoImpuesto = (DTOTipoImpuesto) list.get(i);
            comboBoxTipoImpuesto.addItem(dTOTipoImpuesto.getNombreDTOTipoImpuesto());
        }
    }
   
    private void Button_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_GuardarActionPerformed
    
        String cuit= TextField_Cuit.getText();
        String nombre = TextField_Nombre.getText();
        String nuevoTipoImpuesto = comboBoxTipoImpuesto.getSelectedItem().toString();
        String nuevoTipoEmpresa = comboBoxTipoEmpresa.getSelectedItem().toString();
        int frecuenciaLiquidacion = (int) spinner_Frecuencia.getValue();

        controlador.guardarEmpresaTipoImpuesto(cuit, nombre, nuevoTipoImpuesto, nuevoTipoEmpresa, frecuenciaLiquidacion );
        controlador.asociarEmpresa(cuit);
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

    private void comboBoxTipoImpuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxTipoImpuestoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxTipoImpuestoActionPerformed

   



    public JTextField getTextField_Cuit() {
        return TextField_Cuit;
    }

    public void setTextField_Cuit(JTextField TextField_Cuit) {
        this.TextField_Cuit = TextField_Cuit;
    }


    public JTextField getTextField_Nombre() {
        return TextField_Nombre;
    }

    public void setTextField_Nombre(JTextField TextField_Nombre) {
        this.TextField_Nombre = TextField_Nombre;
    }

    public JComboBox<String> getComboBoxTipoEmpresa() {
        return comboBoxTipoEmpresa;
    }

    public void setComboBoxTipoEmpresa(JComboBox<String> ComboBoxTipoEmpresa) {
        this.comboBoxTipoEmpresa = ComboBoxTipoEmpresa;
    }

    public JComboBox<String> getComboBoxTipoImpuesto() {
        return comboBoxTipoImpuesto;
    }

    public void setComboBoxTipoImpuesto(JComboBox<String> ComboBoxTipoImpuesto) {
        this.comboBoxTipoImpuesto = ComboBoxTipoImpuesto;
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
    private javax.swing.JTextField TextField_Cuit;
    private javax.swing.JTextField TextField_Nombre;
    private javax.swing.JComboBox<String> comboBoxTipoEmpresa;
    private javax.swing.JComboBox<String> comboBoxTipoImpuesto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel label_frec;
    private javax.swing.JSpinner spinner_Frecuencia;
    // End of variables declaration//GEN-END:variables
}
