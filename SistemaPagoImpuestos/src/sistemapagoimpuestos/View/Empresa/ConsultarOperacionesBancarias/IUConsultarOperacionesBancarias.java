/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.View.Empresa.ConsultarOperacionesBancarias;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import sistemapagoimpuestos.Dto.DTOTipoImpuesto;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import sistemapagoimpuestos.Controller.ControladorConsultarOperacionesBancarias;
import sistemapagoimpuestos.Dto.DTOExportar;
import sistemapagoimpuestos.Dto.DTOExporteOperacion;

import sistemapagoimpuestos.Dto.DTOOperacionConsultarOperacionesBancarias;
import sistemapagoimpuestos.Globals.GlobalVars;
import sistemapagoimpuestos.View.Empresa.Principal.IUPantallaEmpresa;

/**
 *
 * @author vande
 */
public class IUConsultarOperacionesBancarias extends javax.swing.JFrame {
 static int sizeTable;
    public IUConsultarOperacionesBancarias() {
        initComponents();
        ControladorConsultarOperacionesBancarias controlador = new ControladorConsultarOperacionesBancarias();
        List<DTOTipoImpuesto> listDTOEmpresaTipoImpuesto = controlador.obtenerTipoImpuestos();
        jTextFieldNombreEmpresa.setText( GlobalVars.userActive.getEmpresa().getNombreEmpresa());
        jTextFieldNombreEmpresa.setEnabled(false);
        jComboBoxTipoImpuesto.addItem("Todos");
        jButtonExportarOperacionesTxt.setVisible(true);
        for (DTOTipoImpuesto dtoEmpresaTI : listDTOEmpresaTipoImpuesto ){
            jComboBoxTipoImpuesto.addItem(dtoEmpresaTI.getNombreDTOTipoImpuesto());
            jComboBoxTipoImpuesto.isEditable();
        } 
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        
      
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
        jTableOperaciones = new javax.swing.JTable();
        jComboBoxTipoImpuesto = new javax.swing.JComboBox<>();
        jTextFieldNombreEmpresa = new javax.swing.JTextField();
        jTextFieldMontoTotal = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButtonExportarOperacionesTxt = new javax.swing.JButton();
        jButtonVolver = new javax.swing.JButton();
        jButtonExportarOperacionesExcel = new javax.swing.JButton();

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

        jLabel1.setText("Tipo de Impuesto:");

        jLabel2.setText("Empresa:");

        jLabel3.setText("Fecha desde:");

        jLabel4.setText("Fecha hasta:");

        dateChooserCombodesde.setCalendarPreferredSize(new java.awt.Dimension(400, 300));

        dateChooserCombohasta.setCalendarPreferredSize(new java.awt.Dimension(400, 300));

        jButtonConsultarOperacionesBancarias.setText("Consultar Operaciones");
        jButtonConsultarOperacionesBancarias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultarOperacionesBancariasActionPerformed(evt);
            }
        });

        jTableOperaciones = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;   //Disallow the editing of any cell
            }
        };
        jTableOperaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha Operacion", "Numero Operacion", "Codigo Pago Electronico", "NroComprobante", "Tipo Impuesto", "Importe Pagado"
            }
        ));
        jScrollPane2.setViewportView(jTableOperaciones);

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

        jTextFieldNombreEmpresa.setText("Nombre Empresa");
        jTextFieldNombreEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreEmpresaActionPerformed(evt);
            }
        });

        jLabel5.setText("Importe Pagado Total");

        jButtonExportarOperacionesTxt.setText("Exportar Operaciones Txt");
        jButtonExportarOperacionesTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExportarOperacionesTxtActionPerformed(evt);
            }
        });

        jButtonVolver.setText("Volver");
        jButtonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverActionPerformed(evt);
            }
        });

        jButtonExportarOperacionesExcel.setText("Exportar Operaciones Excel");
        jButtonExportarOperacionesExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExportarOperacionesExcelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jTextFieldMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonExportarOperacionesExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(175, 175, 175)
                        .addComponent(jButtonExportarOperacionesTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(232, 232, 232))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(99, 99, 99)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dateChooserCombohasta, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonConsultarOperacionesBancarias, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(dateChooserCombodesde, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jComboBoxTipoImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldNombreEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 928, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(387, 387, 387)
                        .addComponent(jButtonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNombreEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxTipoImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateChooserCombodesde, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateChooserCombohasta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jButtonConsultarOperacionesBancarias, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonExportarOperacionesTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonExportarOperacionesExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jComboBoxTipoImpuesto.getAccessibleContext().setAccessibleName("");
        jComboBoxTipoImpuesto.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonConsultarOperacionesBancariasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultarOperacionesBancariasActionPerformed

    DefaultTableModel model = (DefaultTableModel) jTableOperaciones.getModel();
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
            jTableOperaciones.isCellEditable(i, 0);
            jTableOperaciones.isCellEditable(i, 1);
            jTableOperaciones.isCellEditable(i, 2);
            jTableOperaciones.isCellEditable(i, 3);
            jTableOperaciones.isCellEditable(i, 4);
            jTableOperaciones.isCellEditable(i, 5);
            jTableOperaciones.isCellEditable(i, 6);
            
             jTableOperaciones.setValueAt(listDtoOperacion.get(i).getFechaHoraOperacion(), i, 0);
             jTableOperaciones.setValueAt(listDtoOperacion.get(i).getNumeroOperacion(), i, 1);
            jTableOperaciones.setValueAt(listDtoOperacion.get(i).getCodigoPagoElectronicoOperacion(), i, 2);
            jTableOperaciones.setValueAt(listDtoOperacion.get(i).getNroComprobanteFacturaOperacion(), i, 3);
            jTableOperaciones.setValueAt(listDtoOperacion.get(i).getTipoImpuesto(), i, 4);
            jTableOperaciones.setValueAt(listDtoOperacion.get(i).getImportePagadoOperacion(), i, 5);
            
            montoTotal+=listDtoOperacion.get(i).getImportePagadoOperacion();
            NumberFormat nf = NumberFormat.getInstance();
            nf.setMaximumFractionDigits(3);
    
        }
        jTextFieldMontoTotal.setText(""+montoTotal);
        jTextFieldMontoTotal.setEditable(false);
        
        for (int i = 0; i < (model.getRowCount()*(model.getRowCount()-1)); i++) {
          
            for (int j = 0; j <  model.getRowCount()-1; j++) {
                String d = jTableOperaciones.getValueAt(j, 0).toString();
                String d2 =jTableOperaciones.getValueAt(j+1, 0).toString();
                System.out.println(d);
                System.out.println(d2);
                 System.out.println("<"+d.compareTo(d2));
                if (d.compareTo(d2)>0){ //d>d2
                model.moveRow(j, j, j+1);
                }
                
            }
        }
        sizeTable = listDtoOperacion.size();
        jButtonExportarOperacionesTxt.setVisible(true);
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

    private void jTextFieldNombreEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreEmpresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreEmpresaActionPerformed

    private void jButtonExportarOperacionesTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExportarOperacionesTxtActionPerformed
       
       DTOExportar dtoExportacion = new DTOExportar();
       dtoExportacion.setEmpresa(jTextFieldNombreEmpresa.getText());
       dtoExportacion.setTipoImpuesto(jComboBoxTipoImpuesto.getItemAt(0));
       dtoExportacion.setFechaDesde(dateChooserCombodesde.getText());
       dtoExportacion.setFechaHasta(dateChooserCombohasta.getText());
       dtoExportacion.setImporteTotalPagado(Double.valueOf(jTextFieldMontoTotal.getText()));
       
       ArrayList<DTOExporteOperacion> dtoExporteOperaciones = new ArrayList<DTOExporteOperacion>();
        for (int i = 0; i < jTableOperaciones.getRowCount(); i++) {
            DTOExporteOperacion dto = new DTOExporteOperacion();
            dto.setFechaOperacion(jTableOperaciones.getValueAt(i, 0).toString());
            dto.setNumeroOperacion(Integer.getInteger(jTableOperaciones.getValueAt(i, 1).toString()));
            dto.setCodigoPagoElectronico(jTableOperaciones.getValueAt(i, 2).toString());
            dto.setNroComprobante(Integer.getInteger(jTableOperaciones.getValueAt(i, 3).toString()));
            dto.setTipoImpuesto(jTableOperaciones.getValueAt(i, 4).toString());
            dto.setImportePagado(Double.valueOf(jTableOperaciones.getValueAt(i, 5).toString()));
            dtoExporteOperaciones.add(dto);
        }
        
        
        dtoExportacion.setListDtoOperaciones(dtoExporteOperaciones);
        
        ControladorConsultarOperacionesBancarias controlador = new ControladorConsultarOperacionesBancarias();
        controlador.exportar(dtoExportacion, "Txt");
    }//GEN-LAST:event_jButtonExportarOperacionesTxtActionPerformed

    private void jButtonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverActionPerformed
        this.setVisible(false);
        new IUPantallaEmpresa().mostrarPantallaPrincipal();

    }//GEN-LAST:event_jButtonVolverActionPerformed

    private void jButtonExportarOperacionesExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExportarOperacionesExcelActionPerformed
  
       DTOExportar dtoExportacion = new DTOExportar();
       dtoExportacion.setEmpresa(jTextFieldNombreEmpresa.getText());
       dtoExportacion.setTipoImpuesto(jComboBoxTipoImpuesto.getItemAt(0));
       dtoExportacion.setFechaDesde(dateChooserCombodesde.getText());
       dtoExportacion.setFechaHasta(dateChooserCombohasta.getText());
       dtoExportacion.setImporteTotalPagado(Double.valueOf(jTextFieldMontoTotal.getText()));
       
       ArrayList<DTOExporteOperacion> dtoExporteOperaciones = new ArrayList<DTOExporteOperacion>();
        for (int i = 0; i < jTableOperaciones.getRowCount(); i++) {
            DTOExporteOperacion dto = new DTOExporteOperacion();
            dto.setFechaOperacion(jTableOperaciones.getValueAt(i, 0).toString());
            dto.setNumeroOperacion(Integer.getInteger(jTableOperaciones.getValueAt(i, 1).toString()));
            dto.setCodigoPagoElectronico(jTableOperaciones.getValueAt(i, 2).toString());
            dto.setNroComprobante(Integer.getInteger(jTableOperaciones.getValueAt(i, 3).toString()));
            dto.setTipoImpuesto(jTableOperaciones.getValueAt(i, 4).toString());
            dto.setImportePagado(Double.valueOf(jTableOperaciones.getValueAt(i, 5).toString()));
            dtoExporteOperaciones.add(dto);
        }

        dtoExportacion.setListDtoOperaciones(dtoExporteOperaciones);
        
        ControladorConsultarOperacionesBancarias controlador = new ControladorConsultarOperacionesBancarias();
        controlador.exportar(dtoExportacion, "Excel");
    }//GEN-LAST:event_jButtonExportarOperacionesExcelActionPerformed
    
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
    private javax.swing.JButton jButtonExportarOperacionesExcel;
    private javax.swing.JButton jButtonExportarOperacionesTxt;
    private javax.swing.JButton jButtonVolver;
    private javax.swing.JComboBox<String> jComboBoxTipoImpuesto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableOperaciones;
    private javax.swing.JTextField jTextFieldMontoTotal;
    private javax.swing.JTextField jTextFieldNombreEmpresa;
    // End of variables declaration//GEN-END:variables
}
