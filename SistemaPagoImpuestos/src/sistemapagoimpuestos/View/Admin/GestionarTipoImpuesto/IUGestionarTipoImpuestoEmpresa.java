package sistemapagoimpuestos.View.Admin.GestionarTipoImpuesto;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import exceptions.Excepciones;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import sistemapagoimpuestos.Controller.ControladorGestionarTipoImpuesto;
import sistemapagoimpuestos.Dto.DTOEmpresa;
import sistemapagoimpuestos.Dto.DTOEmpresaTipImpItem;
import sistemapagoimpuestos.Dto.DTOTipoEmpresa;
import sistemapagoimpuestos.Dto.DtoItemOrden;
import sistemapagoimpuestos.Utils.MetodosPantalla;

public class IUGestionarTipoImpuestoEmpresa extends javax.swing.JFrame {
    
    private static String codigoTemp;
    private static String nombreTemp;
    private static boolean editTemp;
    private static boolean statusTemp;
    ControladorGestionarTipoImpuesto controlador = new ControladorGestionarTipoImpuesto();
    
    public IUGestionarTipoImpuestoEmpresa(String codigoIngresado, String nombreIngresado, boolean editableIngresado) {
        initComponents();
        codigoTemp = codigoIngresado;
        nombreTemp = nombreIngresado;
        editTemp = editableIngresado;
        List<DTOEmpresa> listEmpresa = controlador.buscarEmpresas();
        llenarComboEmpresa(listEmpresa);
        List<DTOTipoEmpresa> listTipoEmpresa = controlador.buscarTipoEmpresa();
        llenarComboTipoEmpresa(listTipoEmpresa);
    }
    public void llenarComboEmpresa(List<DTOEmpresa> list){
        for (int i = 0; i < list.size(); i++) {
            DTOEmpresa dtoEmpresa = (DTOEmpresa) list.get(i);
            comboBox_Empresa.addItem(dtoEmpresa.getNombreEmpresa());
        }
    }
    public void llenarComboTipoEmpresa(List<DTOTipoEmpresa> list){
        for (int i = 0; i < list.size(); i++) {
            DTOTipoEmpresa dTOTipoEmpresa = (DTOTipoEmpresa) list.get(i);
            comboBox_Tipo_Empresa.addItem(dTOTipoEmpresa.getNombreTipoEmpresa());
        }
    }    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comboBox_Empresa = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        button_Aceptar = new javax.swing.JButton();
        button_Cancelar = new javax.swing.JToggleButton();
        label_tipo_empresa = new javax.swing.JLabel();
        comboBox_Tipo_Empresa = new javax.swing.JComboBox<>();
        label_frecuencia = new javax.swing.JLabel();
        text_frecuencia = new javax.swing.JTextField();
        button_gestionar_items = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        comboBox_Empresa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Seleccionar Empresa-" }));
        comboBox_Empresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBox_EmpresaActionPerformed(evt);
            }
        });

        jLabel1.setText("Empresa:");

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

        label_tipo_empresa.setText("Tipo de Empresa:");

        comboBox_Tipo_Empresa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Seleccionar Tipo Empresa-" }));
        comboBox_Tipo_Empresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBox_Tipo_EmpresaActionPerformed(evt);
            }
        });

        label_frecuencia.setText("Frecuencia de Sincronizacion:");

        text_frecuencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_frecuenciaActionPerformed(evt);
            }
        });

        button_gestionar_items.setText("Gestionar Items");
        button_gestionar_items.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_gestionar_itemsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(button_Aceptar)
                        .addGap(109, 109, 109)
                        .addComponent(button_Cancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_frecuencia)
                            .addComponent(jLabel1)
                            .addComponent(label_tipo_empresa))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboBox_Tipo_Empresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboBox_Empresa, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(text_frecuencia, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(button_gestionar_items)))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBox_Empresa, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_tipo_empresa)
                    .addComponent(comboBox_Tipo_Empresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_frecuencia)
                    .addComponent(text_frecuencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(button_gestionar_items)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_Aceptar)
                    .addComponent(button_Cancelar))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboBox_EmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBox_EmpresaActionPerformed
        
    }//GEN-LAST:event_comboBox_EmpresaActionPerformed

    private void button_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_CancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_button_CancelarActionPerformed

    private void button_AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_AceptarActionPerformed

        try {
            DTOEmpresaTipImpItem dTOEmpresaTipImpItem = new DTOEmpresaTipImpItem();
//            List<DtoItemOrden> dtoItemOrdenList = new ArrayList<>();

            dTOEmpresaTipImpItem.setNombreEmpresa((String) comboBox_Empresa.getSelectedItem());
            dTOEmpresaTipImpItem.setNombreTipoEmpresa((String) comboBox_Tipo_Empresa.getSelectedItem());
            dTOEmpresaTipImpItem.setFrecuenciaSincronizacion(Integer.parseInt(text_frecuencia.getText()));
//            for (int i = 0; i < table_Item.getRowCount(); i++) {
//                if((Boolean)(table_Item.getValueAt(i, 2))){
//                    DtoItemOrden dtoItemOrden = new DtoItemOrden();
//                    dtoItemOrden.setNombreItem(table_Item.getValueAt(i, 0).toString()); 
//                    dtoItemOrden.setOrden(Integer.parseInt(table_Item.getValueAt(i, 1).toString())); 
//                    dtoItemOrdenList.add(dtoItemOrden);
//                }
//            }
//            dTOEmpresaTipImpItem.setDtoItemOrdenList(dtoItemOrdenList);
            if(!(dTOEmpresaTipImpItem.getNombreEmpresa().equals("-Seleccionar Empresa-"))
                    &&dTOEmpresaTipImpItem.getFrecuenciaSincronizacion()>0
                    &&!dTOEmpresaTipImpItem.getNombreTipoEmpresa().equals("-Seleccionar Tipo Empresa-")){

                if(getNuevoTipoImpuesto()){
//                    IUGestionarTipoImpuestoAlta.setDtoetiisModfAlta(getdTOEmpresaTipImpItemList());
                    IUGestionarTipoImpuestoAlta.addDtoetiisModfAlta(dTOEmpresaTipImpItem);
                    IUGestionarTipoImpuestoAlta IUGestionarTipoImpuestoAlta = new IUGestionarTipoImpuestoAlta();
                    IUGestionarTipoImpuestoAlta.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); // Evito que se cierre al presionar x
                    IUGestionarTipoImpuestoAlta.setVisible(true); // La hago visible
                    // Modifico la operación de cierre para volver a la pantalla principal
                    IUGestionarTipoImpuestoAlta.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                    IUGestionarTipoImpuestoAlta.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosing(WindowEvent ev) {
                            controlador.iniciar();
                        }
                    });
                    IUGestionarTipoImpuestoAlta.RecuperarEmpresaItems();
                    IUGestionarTipoImpuestoAlta.setTextfield_codigo(getCodigoTemp());
                    IUGestionarTipoImpuestoAlta.setTextField_nombre(getNombreTemp());
                    IUGestionarTipoImpuestoAlta.setCheckbox_esEditable(isEditTemp());
                }else{
//                    IUGestionarTipoImpuestoModificar.setdTOEmpresaTipImpItemList(getdTOEmpresaTipImpItemList());
                    IUGestionarTipoImpuestoModificar.adddTOEmpresaTipImpItemList(dTOEmpresaTipImpItem);
                    IUGestionarTipoImpuestoModificar pantallaModificar = new IUGestionarTipoImpuestoModificar();
                    pantallaModificar.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); // Evito que se cierre al presionar x
                    pantallaModificar.setVisible(true); // La hago visible
                    // Modifico la operación de cierre para volver a la pantalla principal
                    pantallaModificar.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

                    pantallaModificar.RecuperarEmpresaItems();
                    pantallaModificar.setLabel_nombre(getCodigoTemp());
                    pantallaModificar.setTextfield_nombre(getNombreTemp());
                    pantallaModificar.setCheckbox_Habilitar(isEditTemp());
                    pantallaModificar.setCheckbox_esEditable(isStatusTemp());
                }
                this.dispose();
            } else{
                List<String> stringList = new ArrayList<>();
                stringList.add("Empresa");
                stringList.add("Tipo Empresa");
                stringList.add("Frec. Liquidación");
                stringList.add("Item");
                Excepciones.getInstance().camposRequerido(stringList);
            }
        }catch (Exception e){

        }
    }//GEN-LAST:event_button_AceptarActionPerformed

    private void comboBox_Tipo_EmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBox_Tipo_EmpresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBox_Tipo_EmpresaActionPerformed

    private void text_frecuenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_frecuenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_frecuenciaActionPerformed

    private void button_gestionar_itemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_gestionar_itemsActionPerformed
        IUGestionarTipoImpuestoItems pantallaItems = new IUGestionarTipoImpuestoItems();
        MetodosPantalla.getInstance().setearPantalla(pantallaItems);
        pantallaItems.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_button_gestionar_itemsActionPerformed

    public static boolean nuevoTipoImpuesto;
    
    public static void setNuevoTipoImpuesto(boolean valor){
        nuevoTipoImpuesto = valor;
    }
    
    public static boolean getNuevoTipoImpuesto(){
        return nuevoTipoImpuesto;
    }
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
            java.util.logging.Logger.getLogger(IUGestionarTipoImpuestoEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IUGestionarTipoImpuestoEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IUGestionarTipoImpuestoEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IUGestionarTipoImpuestoEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new IUGestionarTipoImpuestoEmpresa(codigoTemp, nombreTemp, editTemp).setVisible(true);
            }
        });
    }
    


    public String getCodigoTemp() {
        return codigoTemp;
    }

    public void setCodigoTemp(String codigoTemp) {
        this.codigoTemp = codigoTemp;
    }

    public String getNombreTemp() {
        return nombreTemp;
    }

    public void setNombreTemp(String nombreTemp) {
        this.nombreTemp = nombreTemp;
    }

    public boolean isEditTemp() {
        return editTemp;
    }

    public void setEditTemp(boolean editTemp) {
        this.editTemp = editTemp;
    }


    public boolean isStatusTemp() {
        return statusTemp;
    }

    public void setStatusTemp(boolean statusTemp) {
        this.statusTemp = statusTemp;
    }
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_Aceptar;
    private javax.swing.JToggleButton button_Cancelar;
    private javax.swing.JButton button_gestionar_items;
    private javax.swing.JComboBox<String> comboBox_Empresa;
    private javax.swing.JComboBox<String> comboBox_Tipo_Empresa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel label_frecuencia;
    private javax.swing.JLabel label_tipo_empresa;
    private javax.swing.JTextField text_frecuencia;
    // End of variables declaration//GEN-END:variables
}