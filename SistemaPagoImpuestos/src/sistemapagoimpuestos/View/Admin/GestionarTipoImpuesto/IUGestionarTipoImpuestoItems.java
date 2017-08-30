package sistemapagoimpuestos.View.Admin.GestionarTipoImpuesto;

import java.awt.Component;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javafx.scene.control.ComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import sistemapagoimpuestos.Controller.ControladorGestionarTipoImpuesto;
import sistemapagoimpuestos.Dto.DTOEmpresa;
import sistemapagoimpuestos.Dto.DTOItem;
import sistemapagoimpuestos.Entity.Item;

public class IUGestionarTipoImpuestoItems extends javax.swing.JFrame {
    
    public IUGestionarTipoImpuestoItems() {
        initComponents();
        List<DTOEmpresa> list = ControladorGestionarTipoImpuesto.getInstance().buscarEmpresas();
        llenarCombo(list);
        List<DTOItem> items = ControladorGestionarTipoImpuesto.getInstance().buscarItems();
        llenarTabla(items);
    }
    private void llenarCombo(List<DTOEmpresa> list){
        for (int i = 0; i < list.size(); i++) {
            DTOEmpresa dtoEmpresa = (DTOEmpresa) list.get(i);
            comboBox_Empresa.addItem(dtoEmpresa.getNombreDTOEmpresa());
        }
    }
    private void llenarTabla(List<DTOItem> list){
        String[] columnas = {"Item","Seleccion"};
        DefaultTableModel dtm = new DefaultTableModel(null, columnas) {
            public Class<?> getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return String.class;
                    case 1:
                        return Boolean.class;
                    default:
                        return null;
                }
            }
        };
        for (int i = 0; i < list.size(); i++) {
            Vector<Object> agregarFila = new Vector<Object>();
            DTOItem item = (DTOItem) list.get(i);
            agregarFila.add(item.getNombreDTOItem());
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(41, 41, 41)
                .addComponent(comboBox_Empresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(139, 139, 139))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(button_Aceptar)
                        .addGap(109, 109, 109)
                        .addComponent(button_Cancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBox_Empresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(45, 45, 45)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
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
        String empresaSelec = (String) comboBox_Empresa.getSelectedItem();
        System.out.println("Para la empresa "+empresaSelec+", se agregaran los siguientes items:");
        for (int i = 0; i < table_Item.getRowCount(); i++) {
            if((Boolean)(table_Item.getValueAt(i, 1)) == true){
                System.out.println("--> "+table_Item.getValueAt(i, 0));
            }
        }
        System.exit(0);
    }//GEN-LAST:event_button_AceptarActionPerformed

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
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_Aceptar;
    private javax.swing.JToggleButton button_Cancelar;
    private javax.swing.JComboBox<String> comboBox_Empresa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_Item;
    // End of variables declaration//GEN-END:variables
}