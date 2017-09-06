package sistemapagoimpuestos.View.Admin.GestionarTipoImpuesto;

import java.awt.Component;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import exceptions.Excepciones;
import javafx.scene.control.ComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import sistemapagoimpuestos.Controller.ControladorGestionarTipoImpuesto;
import sistemapagoimpuestos.Dto.DTOEmpresa;
import sistemapagoimpuestos.Dto.DTOEmpresaTipImpItem;
import sistemapagoimpuestos.Dto.DTOEmpresaTipoImpuestoItems;
import sistemapagoimpuestos.Dto.DTOItem;
import sistemapagoimpuestos.Dto.DTOTipoEmpresa;
import sistemapagoimpuestos.Dto.DtoItemOrden;
import sistemapagoimpuestos.Entity.Item;

public class IUGestionarTipoImpuestoItems extends javax.swing.JFrame {
    
    private List<DTOEmpresaTipImpItem> dTOEmpresaTipImpItemList;

    public List<DTOEmpresaTipImpItem> getdTOEmpresaTipImpItemList() {
        return dTOEmpresaTipImpItemList;
    }

    public void setdTOEmpresaTipImpItemList(List<DTOEmpresaTipImpItem> dTOEmpresaTipImpItemList) {
        this.dTOEmpresaTipImpItemList = dTOEmpresaTipImpItemList;
    }

   
    public  void addDtoetiisModf(DTOEmpresaTipImpItem dTOEmpresaTipImpItem){
         if(dTOEmpresaTipImpItemList==null){
            dTOEmpresaTipImpItemList = new ArrayList<>();
        }
        dTOEmpresaTipImpItemList.add(dTOEmpresaTipImpItem);
    }
    public  void removeDtoetiisModf(int index){
       dTOEmpresaTipImpItemList.remove(index);
    }    
    
    
    
    
    public IUGestionarTipoImpuestoItems() {
        initComponents();
        List<DTOEmpresa> listEmpresa = ControladorGestionarTipoImpuesto.getInstance().buscarEmpresas();
        llenarComboEmpresa(listEmpresa);
        List<DTOTipoEmpresa> listTipoEmpresa = ControladorGestionarTipoImpuesto.getInstance().buscarTipoEmpresa();
        llenarComboTipoEmpresa(listTipoEmpresa);
        
        List<DTOItem> items = ControladorGestionarTipoImpuesto.getInstance().buscarItems();
        llenarTabla(items);
    }
    private void llenarComboEmpresa(List<DTOEmpresa> list){
        for (int i = 0; i < list.size(); i++) {
            DTOEmpresa dtoEmpresa = (DTOEmpresa) list.get(i);
            comboBox_Empresa.addItem(dtoEmpresa.getNombreEmpresa());
        }
    }
    private void llenarComboTipoEmpresa(List<DTOTipoEmpresa> list){
        for (int i = 0; i < list.size(); i++) {
            DTOTipoEmpresa dTOTipoEmpresa = (DTOTipoEmpresa) list.get(i);
            comboBox_Tipo_Empresa.addItem(dTOTipoEmpresa.getNombreTipoEmpresa());
        }
    }
    private void llenarTabla(List<DTOItem> list){
        String[] columnas = {"Item", "Orden","Seleccion"};
        DefaultTableModel dtm = new DefaultTableModel(null, columnas) {
            public Class<?> getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return String.class;
                    case 1:
                        return Integer.class;
                    case 2:
                        return Boolean.class;
                    default:
                        return null;
                }
            }
            
            public boolean isCellEditable(int row,int column) 
            {
               switch (column) {
                    case 0:
                        return false;
                    case 1:
                        return true;
                    case 2:
                        return true;
                    default:
                        return false;
                }
            }
        };
        for (int i = 0; i < list.size(); i++) {
            Vector<Object> agregarFila = new Vector<Object>();
            DTOItem item = (DTOItem) list.get(i);
            agregarFila.add(item.getNombreItem());
            agregarFila.add(0);
            agregarFila.add(false);
            
            dtm.addRow(agregarFila);
        }
        table_Item.setModel(dtm);
    }
    
    private void recover(){
        
    }
    
        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comboBox_Empresa = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_Item = new javax.swing.JTable();
        button_Aceptar = new javax.swing.JButton();
        button_Cancelar = new javax.swing.JToggleButton();
        label_tipo_empresa = new javax.swing.JLabel();
        comboBox_Tipo_Empresa = new javax.swing.JComboBox<>();
        label_frecuencia = new javax.swing.JLabel();
        text_frecuencia = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        comboBox_Empresa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Seleccionar Empresa-" }));
        comboBox_Empresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBox_EmpresaActionPerformed(evt);
            }
        });

        jLabel1.setText("Empresa:");

        table_Item.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table_Item.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(table_Item);
        table_Item.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label_frecuencia)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(label_tipo_empresa))
                                        .addGap(54, 54, 54)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboBox_Tipo_Empresa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(comboBox_Empresa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(text_frecuencia)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_Aceptar)
                    .addComponent(button_Cancelar))
                .addGap(55, 55, 55))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboBox_EmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBox_EmpresaActionPerformed
        
    }//GEN-LAST:event_comboBox_EmpresaActionPerformed

    private void button_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_CancelarActionPerformed
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_button_CancelarActionPerformed

    private void button_AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_AceptarActionPerformed

        try {
            DTOEmpresaTipImpItem dTOEmpresaTipImpItem = new DTOEmpresaTipImpItem();
            List<DtoItemOrden> dtoItemOrdenList = new ArrayList<>();

            dTOEmpresaTipImpItem.setNombreEmpresa((String) comboBox_Empresa.getSelectedItem());
            dTOEmpresaTipImpItem.setNombreTipoEmpresa((String) comboBox_Tipo_Empresa.getSelectedItem());
            dTOEmpresaTipImpItem.setFrecuenciaSincronizacion(Integer.parseInt(text_frecuencia.getText()));
            for (int i = 0; i < table_Item.getRowCount(); i++) {
                if((Boolean)(table_Item.getValueAt(i, 2))){
                    DtoItemOrden dtoItemOrden = new DtoItemOrden();
                    dtoItemOrden.setNombreItem(table_Item.getValueAt(i, 0).toString()); 
                    dtoItemOrden.setOrden(Integer.parseInt(table_Item.getValueAt(i, 1).toString())); 
                    dtoItemOrdenList.add(dtoItemOrden);
                }
            }
            dTOEmpresaTipImpItem.setDtoItemOrdenList(dtoItemOrdenList);
            if(!(dTOEmpresaTipImpItem.getNombreEmpresa().equals("-Seleccionar Empresa-")
                    &&dTOEmpresaTipImpItem.getDtoItemOrdenList().size()<1)
                    &&dTOEmpresaTipImpItem.getFrecuenciaSincronizacion()>0
                    &&!dTOEmpresaTipImpItem.getNombreTipoEmpresa().equals("-Seleccionar Tipo Empresa-")){

                if(getNuevoTipoImpuesto()){
                    IUGestionarTipoImpuestoAlta.setDtoetiisModfAlta(getdTOEmpresaTipImpItemList());
                    IUGestionarTipoImpuestoAlta.addDtoetiisModfAlta(dTOEmpresaTipImpItem);
                    IUGestionarTipoImpuestoAlta IUGestionarTipoImpuestoAlta = new IUGestionarTipoImpuestoAlta();
                    IUGestionarTipoImpuestoAlta.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); // Evito que se cierre al presionar x
                    IUGestionarTipoImpuestoAlta.setVisible(true); // La hago visible
                    // Modifico la operación de cierre para volver a la pantalla principal
                    IUGestionarTipoImpuestoAlta.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                    IUGestionarTipoImpuestoAlta.addWindowListener(new WindowAdapter() {
                        public void windowClosing(WindowEvent ev) {
                            IUGestionarTipoImpuestoAlta.dispose();
                            ControladorGestionarTipoImpuesto.getInstance().iniciar();
                        }
                    });
                    IUGestionarTipoImpuestoAlta.RecuperarEmpresaItems();
                    IUGestionarTipoImpuestoAlta.setTextfield_codigo(getCodigoTemp());
                    IUGestionarTipoImpuestoAlta.setTextField_nombre(getNombreTemp());
                    IUGestionarTipoImpuestoAlta.setCheckbox_esEditable(isEditTemp());
                }else{
                    IUGestionarTipoImpuestoModificar pantallaModificar = new IUGestionarTipoImpuestoModificar();
                    pantallaModificar.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); // Evito que se cierre al presionar x
                    pantallaModificar.setVisible(true); // La hago visible
                    // Modifico la operación de cierre para volver a la pantalla principal
                    pantallaModificar.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                    pantallaModificar.addWindowListener(new WindowAdapter() {
                        public void windowClosing(WindowEvent ev) {
                            pantallaModificar.dispose();
                            ControladorGestionarTipoImpuesto.getInstance().iniciar();
                        }
                    });
                    pantallaModificar.RecuperarEmpresaItems();
                    pantallaModificar.setNombre_actual(getCodigoTemp());
                    pantallaModificar.setTextfield_nombre(getNombreTemp());
                    pantallaModificar.setCheckbox_Habilitar(isEditTemp());
                    pantallaModificar.setCheckbox_esEditable(isStatusTemp());
                }

                this.dispose();
            }else{
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
            java.util.logging.Logger.getLogger(IUGestionarTipoImpuestoItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IUGestionarTipoImpuestoItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IUGestionarTipoImpuestoItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IUGestionarTipoImpuestoItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IUGestionarTipoImpuestoItems().setVisible(true);
            }
        });
    }
    
    private String codigoTemp;
    private String nombreTemp;
    private boolean editTemp;
    private boolean statusTemp;

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
    private javax.swing.JComboBox<String> comboBox_Empresa;
    private javax.swing.JComboBox<String> comboBox_Tipo_Empresa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_frecuencia;
    private javax.swing.JLabel label_tipo_empresa;
    private javax.swing.JTable table_Item;
    private javax.swing.JTextField text_frecuencia;
    // End of variables declaration//GEN-END:variables
}