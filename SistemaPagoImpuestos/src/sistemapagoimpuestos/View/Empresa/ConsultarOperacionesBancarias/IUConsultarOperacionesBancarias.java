/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.View.Empresa.ConsultarOperacionesBancarias;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import sistemapagoimpuestos.Dto.DTOTipoImpuesto;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import sistemapagoimpuestos.Controller.ControladorConsultarOperacionesBancarias;

import sistemapagoimpuestos.Dto.DTOOperacionConsultarOperacionesBancarias;
import sistemapagoimpuestos.Globals.GlobalVars;

/**
 *
 * @author vande
 */
public class IUConsultarOperacionesBancarias extends javax.swing.JFrame {
 
    public IUConsultarOperacionesBancarias() {
        initComponents();
        ControladorConsultarOperacionesBancarias controlador = new ControladorConsultarOperacionesBancarias();
        List<DTOTipoImpuesto> listDTOEmpresaTipoImpuesto = controlador.obtenerTipoImpuestos();
        jTextFieldNombreEmpresa.setText( GlobalVars.userActive.getEmpresa().getNombreEmpresa());
        jTextFieldNombreEmpresa.setEnabled(false);
        jComboBoxTipoImpuesto.addItem("Todos");
        for (DTOTipoImpuesto dtoEmpresaTI : listDTOEmpresaTipoImpuesto ){
            jComboBoxTipoImpuesto.addItem(dtoEmpresaTI.getNombreDTOTipoImpuesto());
            jComboBoxTipoImpuesto.isEditable();
        } 
        this.setVisible(true);
        
      
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        dateChooserCombodesde = new datechooser.beans.DateChooserCombo();
        dateChooserCombohasta = new datechooser.beans.DateChooserCombo();
        jButtonConsultarOperacionesBancarias = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jComboBoxTipoImpuesto = new javax.swing.JComboBox<>();
        jButtonMostrar = new javax.swing.JButton();
        jTextFieldNombreEmpresa = new javax.swing.JTextField();
        jTextFieldMontoTotal = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Liquidaciones");
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLabel1.setText("Tipo Impuesto");

        jLabel2.setText("Empresa");

        jLabel3.setText("Fecha desde Liquidacion");

        jLabel4.setText("Fecha hasta Liquidacion");

        dateChooserCombodesde.setCalendarPreferredSize(new java.awt.Dimension(400, 300));

        dateChooserCombohasta.setCalendarPreferredSize(new java.awt.Dimension(400, 300));

        jButtonConsultarOperacionesBancarias.setText("Consultar Operaciones");
        jButtonConsultarOperacionesBancarias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultarOperacionesBancariasActionPerformed(evt);
            }
        });

        jTable2 = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;   //Disallow the editing of any cell
            }
        };
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha Operacion", "Numero Operacion", "Codigo Pago Electronico", "NroComprobante", "Tipo Impuesto", "Importe Pagado"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jComboBoxTipoImpuesto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxTipoImpuestoItemStateChanged(evt);
            }
        });
        jComboBoxTipoImpuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTipoImpuestoActionPerformed(evt);
            }
        });

        jButtonMostrar.setText("Mostrar");
        jButtonMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMostrarActionPerformed(evt);
            }
        });

        jTextFieldNombreEmpresa.setText("Nombre Empresa");
        jTextFieldNombreEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreEmpresaActionPerformed(evt);
            }
        });

        jLabel5.setText("Importe Pagado Total");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(99, 99, 99)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dateChooserCombohasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonConsultarOperacionesBancarias, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(dateChooserCombodesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jComboBoxTipoImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldNombreEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 928, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(307, 307, 307)
                        .addComponent(jButtonMostrar)))
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldNombreEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxTipoImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(dateChooserCombodesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(dateChooserCombohasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jButtonConsultarOperacionesBancarias)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonMostrar)
                .addContainerGap(127, Short.MAX_VALUE))
        );

        jComboBoxTipoImpuesto.getAccessibleContext().setAccessibleName("");
        jComboBoxTipoImpuesto.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonConsultarOperacionesBancariasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultarOperacionesBancariasActionPerformed

    DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            while (model.getRowCount()>0) {
            model.removeRow(0);
        }
     //manda a buscar con los parametros
       ControladorConsultarOperacionesBancarias controlador = new ControladorConsultarOperacionesBancarias();
       Date fechadesde = dateChooserCombodesde.getCurrent().getTime();
       Date fechahasta = dateChooserCombohasta.getCurrent().getTime();
       List <DTOOperacionConsultarOperacionesBancarias> listDtoOperacion = controlador.buscarOperacionesConFiltro(jComboBoxTipoImpuesto.getItemAt(jComboBoxTipoImpuesto.getSelectedIndex()), jTextFieldNombreEmpresa.getText(),fechadesde,fechahasta);
        double montoTotal=0;
//LLena la tabla
        for (int i = 0; i < listDtoOperacion.size(); i++) {

            model.addRow(new Object[]{});
            jTable2.isCellEditable(i, 0);
            jTable2.isCellEditable(i, 1);
            jTable2.isCellEditable(i, 2);
            jTable2.isCellEditable(i, 3);
            jTable2.isCellEditable(i, 4);
            jTable2.isCellEditable(i, 5);
            jTable2.isCellEditable(i, 6);
            
             jTable2.setValueAt(listDtoOperacion.get(i).getFechaHoraOperacion(), i, 0);
              jTable2.setValueAt(listDtoOperacion.get(i).getNumeroOperacion(), i, 1);
            jTable2.setValueAt(listDtoOperacion.get(i).getCodigoPagoElectronicoOperacion(), i, 2);
            jTable2.setValueAt(listDtoOperacion.get(i).getNroComprobanteFacturaOperacion(), i, 3);
            jTable2.setValueAt(listDtoOperacion.get(i).getTipoImpuesto(), i, 4);
            jTable2.setValueAt(listDtoOperacion.get(i).getImportePagadoOperacion(), i, 5);
            
            montoTotal+=listDtoOperacion.get(i).getImportePagadoOperacion();
            NumberFormat nf = NumberFormat.getInstance();
            nf.setMaximumFractionDigits(3);
            
            
            
        }
        jTextFieldMontoTotal.setText(""+montoTotal);
        jTextFieldMontoTotal.setEditable(false);
    }//GEN-LAST:event_jButtonConsultarOperacionesBancariasActionPerformed

    private void jComboBoxTipoImpuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTipoImpuestoActionPerformed
     /*   jComboBoxEmpresa.removeAllItems();
        jComboBoxEmpresa.addItem("Todos");
         List<DTOEmpresa> listDtoDTOEmpresa = controlador.obtenerEmpresarelacionadaATipoImpuesto(jComboBoxTipoImpuesto.getItemAt(jComboBoxTipoImpuesto.getSelectedIndex()));
       for(DTOEmpresa obj : listDtoDTOEmpresa){
            jComboBoxEmpresa.addItem(obj.getNombreEmpresa());}     */
    }//GEN-LAST:event_jComboBoxTipoImpuestoActionPerformed

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited

    }//GEN-LAST:event_formMouseExited
//delete THIS
    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
    
    }//GEN-LAST:event_formWindowActivated

    private void jComboBoxTipoImpuestoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxTipoImpuestoItemStateChanged
        
    /*   ArrayList<DTOEmpresa> listDtoDTOEmpresa = ControladorGestionarLiquidacion.getInstance().obtenerEmpresarelacionadaATipoImpuesto();
         for(DTOEmpresa obj : listDtoDTOEmpresa){
             jComboBoxTipoImpuesto.addItem(obj.getNombreEmpresa()); }   */
    }//GEN-LAST:event_jComboBoxTipoImpuestoItemStateChanged

    private void jButtonMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMostrarActionPerformed
ControladorConsultarOperacionesBancarias controlador = new ControladorConsultarOperacionesBancarias();
        double montoTotal = 0.0;
        String nliquidacion = jTable2.getValueAt(jTable2.getSelectedRow(), 1).toString();
       
       controlador.mostrar(nliquidacion);
       
    
        //LLena los labels
    //     IUMostrar mostrar = new IUMostrar(nliquidacion,fechaliquidacion);
     /*   IUMostrar.jLabelEmpresa.setText(empresa);
        IUMostrar.jLabelTipoImpuesto.setText(tipoImpuesto);
        IUMostrar.jLabelFechaLiquidacion.setText(fechaliquidacion);
        IUMostrar.jLabelNrodeLiquidacion.setText(nliquidacion);
        IUMostrar.jLabelPeriodo.setText(fechaDesde);
        IUMostrar.jLabelPeriodo2.setText(fechaHasta);
        List<DTOOperacion> listDTOoperacion = controlador.mostrar(nliquidacion, fechaliquidacion, tipoImpuesto, empresa);

        for (int i = 0; i < listDTOoperacion.size(); i++) {

            // AGREGAR UNA FILA CADA VEZ QUE CREO OTRA OPERACION
            DefaultTableModel model = (DefaultTableModel) IUMostrar.jTableOperacion.getModel();
            model.addRow(new Object[]{});
            IUMostrar.jTableOperacion.isCellEditable(i, 0);
            IUMostrar.jTableOperacion.isCellEditable(i, 1);
            IUMostrar.jTableOperacion.isCellEditable(i, 2);
            IUMostrar.jTableOperacion.isCellEditable(i, 3);
            IUMostrar.jTableOperacion.setValueAt(listDTOoperacion.get(i).getNumeroOperacion(), i, 0);
            IUMostrar.jTableOperacion.setValueAt(listDTOoperacion.get(i).getNroComprobanteFactura(), i, 1);
            IUMostrar.jTableOperacion.setValueAt(listDTOoperacion.get(i).getValorComisionOperacion(), i, 2);
            IUMostrar.jTableOperacion.setValueAt(listDTOoperacion.get(i).getImportePagadoOperacion(), i, 3);
            montoTotal = montoTotal + listDTOoperacion.get(i).getValorComisionOperacion();
        }
        IUMostrar.jTextFieldMontoTotal.setText("" + montoTotal);*/
    }//GEN-LAST:event_jButtonMostrarActionPerformed

    private void jTextFieldNombreEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreEmpresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreEmpresaActionPerformed
    
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
            java.util.logging.Logger.getLogger(IUConsultarOperacionesBancarias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IUConsultarOperacionesBancarias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IUConsultarOperacionesBancarias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IUConsultarOperacionesBancarias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                IUConsultarOperacionesBancarias pantallaPrincipal = new IUConsultarOperacionesBancarias();
                pantallaPrincipal.setVisible(true);
               // new IUGestionarLiquidacion().setVisible(true);
             
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private datechooser.beans.DateChooserCombo dateChooserCombodesde;
    private datechooser.beans.DateChooserCombo dateChooserCombohasta;
    private javax.swing.JButton jButtonConsultarOperacionesBancarias;
    private javax.swing.JButton jButtonMostrar;
    private javax.swing.JComboBox<String> jComboBoxTipoImpuesto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextFieldMontoTotal;
    private javax.swing.JTextField jTextFieldNombreEmpresa;
    // End of variables declaration//GEN-END:variables
}
