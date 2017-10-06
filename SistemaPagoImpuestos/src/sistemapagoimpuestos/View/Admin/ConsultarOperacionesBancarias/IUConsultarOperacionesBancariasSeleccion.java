/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.View.Admin.ConsultarOperacionesBancarias;

import java.awt.event.ItemEvent;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import sistemapagoimpuestos.Controller.ControladorConsultarOperacionesBancarias;
import sistemapagoimpuestos.Dto.DTOEmpresa;
import sistemapagoimpuestos.Dto.DTOEmpresaTipoImpuesto;
import sistemapagoimpuestos.Dto.DTOOperacion;
import sistemapagoimpuestos.Dto.DTORangoFecha;
import sistemapagoimpuestos.Dto.DTOTipoImpuesto;

/**
 *
 * @author Tongas
 */
public class IUConsultarOperacionesBancariasSeleccion extends javax.swing.JFrame {
    
    ControladorConsultarOperacionesBancarias controlador;
    
    public IUConsultarOperacionesBancariasSeleccion() {
    }
    DTOEmpresa empresa=null;
    ArrayList<DTOEmpresaTipoImpuesto> listDTOETI = null;
    public IUConsultarOperacionesBancariasSeleccion(DTOEmpresa dtoEmpresa,ControladorConsultarOperacionesBancarias controlador) {
        initComponents();
        this.controlador = controlador;
        empresa = dtoEmpresa;
        TextField_Empresa.setText(dtoEmpresa.getNombreEmpresa());
        listDTOETI =  controlador.obtenerTipoImpuestosAsociados();
        for (int i = 0; i < listDTOETI.size(); i++) {
            DTOEmpresaTipoImpuesto dTOETI = (DTOEmpresaTipoImpuesto) listDTOETI.get(i);
            ComboBox_TipoImpuesto.addItem(dTOETI.getdTOtipoImpuesto().getNombreDTOTipoImpuesto());
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        TextField_Empresa = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        ComboBox_TipoImpuesto = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Button_Aceptar = new javax.swing.JButton();
        DateChooser_FechaDesde = new com.toedter.calendar.JDateChooser();
        DateChooser_FechaHasta = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        ComboBox_TipoEmpresa = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Empresa");

        TextField_Empresa.setEditable(false);

        jLabel2.setText("Tipo de Impuesto");

        ComboBox_TipoImpuesto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar Tipo de Impuesto" }));
        ComboBox_TipoImpuesto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboBox_TipoImpuestoItemStateChanged(evt);
            }
        });
        ComboBox_TipoImpuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBox_TipoImpuestoActionPerformed(evt);
            }
        });

        jLabel3.setText("Fecha desde");

        jLabel4.setText("Fecha hasta");

        Button_Aceptar.setText("Aceptar");
        Button_Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_AceptarActionPerformed(evt);
            }
        });

        jLabel5.setText("Tipo de Empresa");

        ComboBox_TipoEmpresa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar Tipo de Empresa" }));
        ComboBox_TipoEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBox_TipoEmpresaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Button_Aceptar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(DateChooser_FechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(122, 122, 122)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(DateChooser_FechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5))
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TextField_Empresa, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(ComboBox_TipoImpuesto, 0, 207, Short.MAX_VALUE)
                                    .addComponent(ComboBox_TipoEmpresa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 61, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TextField_Empresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(ComboBox_TipoImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(ComboBox_TipoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DateChooser_FechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DateChooser_FechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(Button_Aceptar)
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button_AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_AceptarActionPerformed
        DTORangoFecha dtoRF = new DTORangoFecha();
        dtoRF.setNombreEmpresa(TextField_Empresa.toString());
        dtoRF.setNombreTipoImpuesto((String) ComboBox_TipoImpuesto.getSelectedItem().toString());
        dtoRF.setNombreTipoEmpresa(ComboBox_TipoEmpresa.getSelectedItem().toString());
        dtoRF.setFechaDesde(DateChooser_FechaDesde.getDate());
        dtoRF.setFechaHasta(DateChooser_FechaHasta.getDate());
        dtoRF.setCuitEmpresa(empresa.getCuitEmpresa());
        
        List<DTOOperacion> dtoOperacion = controlador.consultarOperaciones(dtoRF);
        
        controlador.consultarOperacionesBancariasArchivo(dtoRF, controlador, dtoOperacion);
        
        
    }//GEN-LAST:event_Button_AceptarActionPerformed

    private void ComboBox_TipoImpuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBox_TipoImpuestoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBox_TipoImpuestoActionPerformed

    private void ComboBox_TipoEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBox_TipoEmpresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBox_TipoEmpresaActionPerformed

    private void ComboBox_TipoImpuestoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboBox_TipoImpuestoItemStateChanged
        if (evt.getStateChange()== ItemEvent.SELECTED) {
            if(this.ComboBox_TipoImpuesto.getSelectedIndex()>0){
                for (int i = 0; i < listDTOETI.size(); i++) {
                DTOEmpresaTipoImpuesto dTOETI = (DTOEmpresaTipoImpuesto) listDTOETI.get(i);
                    if(dTOETI.getdTOtipoImpuesto().getNombreDTOTipoImpuesto()== ComboBox_TipoImpuesto.getSelectedItem().toString()){

                        this.ComboBox_TipoEmpresa.addItem(dTOETI.getdTOtipoEmpresa().getNombreTipoEmpresa());

                    }
            }
            
            
            
            }
            
        }
    }//GEN-LAST:event_ComboBox_TipoImpuestoItemStateChanged

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
            java.util.logging.Logger.getLogger(IUConsultarOperacionesBancariasSeleccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IUConsultarOperacionesBancariasSeleccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IUConsultarOperacionesBancariasSeleccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IUConsultarOperacionesBancariasSeleccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IUConsultarOperacionesBancariasSeleccion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Aceptar;
    private javax.swing.JComboBox<String> ComboBox_TipoEmpresa;
    private javax.swing.JComboBox<String> ComboBox_TipoImpuesto;
    private com.toedter.calendar.JDateChooser DateChooser_FechaDesde;
    private com.toedter.calendar.JDateChooser DateChooser_FechaHasta;
    private javax.swing.JTextField TextField_Empresa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
