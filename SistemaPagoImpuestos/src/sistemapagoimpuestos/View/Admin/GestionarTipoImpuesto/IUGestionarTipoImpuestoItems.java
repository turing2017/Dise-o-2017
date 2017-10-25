package sistemapagoimpuestos.View.Admin.GestionarTipoImpuesto;

import exceptions.Excepciones;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import sistemapagoimpuestos.Controller.ControladorGestionarEmpresaTipoImpuesto;
import sistemapagoimpuestos.Controller.ControladorGestionarTipoImpuesto;
import sistemapagoimpuestos.Dto.DTOItem;
import sistemapagoimpuestos.Dto.DtoItemOrden;

/**
 *
 * @author lunamarcos
 */
public class IUGestionarTipoImpuestoItems extends javax.swing.JFrame {
    ControladorGestionarEmpresaTipoImpuesto controladorETI = new ControladorGestionarEmpresaTipoImpuesto();
    ControladorGestionarTipoImpuesto controlador = new ControladorGestionarTipoImpuesto();
    String cuitEmpresa;
    String nombreTipoEmpresa;
    int codigoTipoImpuesto;
    /**
     * Creates new form IUGestionarTipoImpuestoItem
     */
    public IUGestionarTipoImpuestoItems() {
        initComponents();
        
    }
    
    public IUGestionarTipoImpuestoItems(String cuitEmpresa, int codigoTipoImpuesto, String nombreTE){
        initComponents();
        this.setLocationRelativeTo(null);
        this.cuitEmpresa = cuitEmpresa;
        this.codigoTipoImpuesto = codigoTipoImpuesto;
        this.nombreTipoEmpresa = nombreTE;
        llenarComboItem(obtenerTodosItems());
        obtenerItems(cuitEmpresa, codigoTipoImpuesto, nombreTE);
        SpinnerNumberModel sf = new SpinnerNumberModel();
        sf.setMinimum(1);
        sf.setValue(1);
        jSpinnerOrden.setModel(sf);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_items = new javax.swing.JTable();
        comboBox_items = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        button_agregar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        ButtonModificarItem = new javax.swing.JButton();
        jButton_cancelar = new javax.swing.JButton();
        jButton_EliminarItem = new javax.swing.JButton();
        jSpinnerOrden = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(tabla_items);

        jLabel1.setText("Agregar Item:");

        button_agregar.setText("Agregar");
        button_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_agregarActionPerformed(evt);
            }
        });

        jLabel2.setText("Orden:");

        ButtonModificarItem.setText("Modificar Item");
        ButtonModificarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonModificarItemActionPerformed(evt);
            }
        });

        jButton_cancelar.setText("Cancelar");
        jButton_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_cancelarActionPerformed(evt);
            }
        });

        jButton_EliminarItem.setText("Eliminar Item");
        jButton_EliminarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_EliminarItemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(comboBox_items, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jSpinnerOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button_agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ButtonModificarItem, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jButton_EliminarItem, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBox_items, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(button_agregar)
                    .addComponent(jLabel2)
                    .addComponent(jSpinnerOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonModificarItem)
                    .addComponent(jButton_cancelar)
                    .addComponent(jButton_EliminarItem))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_agregarActionPerformed
        if(jSpinnerOrden.getValue()==  null){
            Excepciones.getInstance().camposVacios();
        }else{
        String nombreItem = comboBox_items.getSelectedItem().toString();
        int orden = (int) jSpinnerOrden.getValue();
        controladorETI.agregarItem(nombreItem, cuitEmpresa, codigoTipoImpuesto, nombreTipoEmpresa,orden);
        this.dispose();
      
        }
    }//GEN-LAST:event_button_agregarActionPerformed

    private void ButtonModificarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonModificarItemActionPerformed
        try{
        int columnCode = 0;
        int rowSelected = tabla_items.getSelectedRow();
        String nombreItem = tabla_items.getModel().getValueAt(rowSelected, columnCode).toString();
        int ordenItem = (int) tabla_items.getModel().getValueAt(rowSelected, 1);
        controlador.modificarItem(nombreItem,  cuitEmpresa, codigoTipoImpuesto, nombreTipoEmpresa, ordenItem);
        this.dispose();
        }catch (ArrayIndexOutOfBoundsException e) {
            //Excepciones.getInstance().camposRequerido(Arrays.asList("Codigo"));
            Excepciones.getInstance().objetoNoSeleccionado();
        
        }
    }//GEN-LAST:event_ButtonModificarItemActionPerformed

    private void jButton_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_cancelarActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_cancelarActionPerformed

    private void jButton_EliminarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_EliminarItemActionPerformed
        int columnCode = 0;
        int rowSelected = tabla_items.getSelectedRow();
        String nombreItem = tabla_items.getModel().getValueAt(rowSelected, columnCode).toString();
        int ordenItem = (int) tabla_items.getModel().getValueAt(rowSelected, 1);
        controlador.eliminarItem(nombreItem,  cuitEmpresa, codigoTipoImpuesto, nombreTipoEmpresa, ordenItem);
        this.dispose();
    }//GEN-LAST:event_jButton_EliminarItemActionPerformed

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
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IUGestionarTipoImpuestoItems().setVisible(true);
            }
        });
    }
    
        public void obtenerItems(String cuitEmpresa, int codigoTipoImpuesto, String nombreTE) {
        // Muestro pantalla de Consultar
        ArrayList<DtoItemOrden> listDTOIETI = controladorETI.obtenerItems(cuitEmpresa, codigoTipoImpuesto, nombreTE);

        String[] columnas = {"Nombre","Orden"};
        DefaultTableModel dtm = new DefaultTableModel(null, columnas) {

            // Sobreescribo el método para no permitir editar la 
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }

            public Class<?> getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return String.class;
                    case 1:
                        return Integer.class;
                    default:
                        return null;
                }
            }

        };

        for (DtoItemOrden dtoItem : listDTOIETI) {
            Vector<Object> vect = new Vector<>();
            vect.add(dtoItem.getNombreItem());
            vect.add(dtoItem.getOrden());
            dtm.addRow(vect);
        }

        DefaultTableCellRenderer r = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                setHorizontalAlignment(JLabel.CENTER);
                return this;
            }
        };
        tabla_items.setModel(dtm);
        tabla_items.getColumnModel().getColumn(0).setCellRenderer(r);
    }
        
    //Método para llenar el comboBox
    public void llenarComboItem(List<DTOItem> listaDTOItem){
        for (int i = 0; i < listaDTOItem.size(); i++) {
            DTOItem dtoItem = (DTOItem) listaDTOItem.get(i);
            String nombreItem = dtoItem.getNombreItem();
            comboBox_items.addItem(nombreItem);
        }
    }
    
    public List<DTOItem> obtenerTodosItems() {
        return controladorETI.obtenerTodosItems();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonModificarItem;
    private javax.swing.JButton button_agregar;
    private javax.swing.JComboBox<String> comboBox_items;
    private javax.swing.JButton jButton_EliminarItem;
    private javax.swing.JButton jButton_cancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinnerOrden;
    private javax.swing.JTable tabla_items;
    // End of variables declaration//GEN-END:variables
}
