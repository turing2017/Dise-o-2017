/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.View.Admin.ConsultarOperacionesBancarias;

import java.awt.Component;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import sistemapagoimpuestos.Controller.ControladorConsultarOperacionesBancarias;
import sistemapagoimpuestos.Dto.DTOOperacion;
import sistemapagoimpuestos.Dto.DTORangoFecha;



public class IUConsultarOperacionesBancariasArchivo extends javax.swing.JFrame {
    
    public IUConsultarOperacionesBancariasArchivo(DTORangoFecha dtoRF, ControladorConsultarOperacionesBancarias controlador, List<DTOOperacion> listDTOO) {
        initComponents();
 //       TextField_Empresa.setText(controlador.obtenerEmpresa().getNombreEmpresa());
        TextField_TipoImpuesto.setText(dtoRF.getNombreTipoImpuesto());
        TextField_FechaDesde.setText(dtoRF.getFechaDesde().toString());
        TextField_FechaHasta.setText(dtoRF.getFechaHasta().toString());
        
        Vector columnas = new Vector();
        columnas.addElement("Numero de Operacion");
        columnas.addElement("Fecha");
        columnas.addElement("Codigo Pago Electronico");
        columnas.addElement("Numero Comprobante Factura");
        columnas.addElement("Importe");
        columnas.addElement("Está liquidada");

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
                        return Integer.class;
                    case 1:
                        return Date.class;
                    case 2:
                        return String.class;
                    case 3:
                        return Integer.class;
                    case 4:
                        return Double.class;
                    case 5:
                        return Boolean.class;
                    default:
                        return null;
                }
            }
            
            

        };
        
        for (DTOOperacion dtoO : listDTOO) {
            Vector<Object> vect = new Vector<>();
            vect.add(dtoO.getNumeroOperacion());
            vect.add(dtoO.getFechaHoraOperacion());
            vect.add(dtoO.getCodigoPagoElectronicoOperacion());
            vect.add(dtoO.getNroComprobanteFactura());
            vect.add(dtoO.getImportePagadoOperacion());
            vect.add(dtoO.isLiquidadaOperacion());
            
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
        Tabla_Operacion.setModel(dtm);
        Tabla_Operacion.getColumnModel().getColumn(0).setCellRenderer(r);
        Tabla_Operacion.getColumnModel().getColumn(1).setCellRenderer(r);
        
        
        
        
        double importeTotal = 0;
        for(int i = 0; i < Tabla_Operacion.getRowCount(); i++){
        importeTotal= importeTotal + (double) Tabla_Operacion.getValueAt(i, 4);
        
       }
    }

    public IUConsultarOperacionesBancariasArchivo() {
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        TextField_Empresa = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TextField_FechaDesde = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TextField_TipoImpuesto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        TextField_FechaHasta = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_Operacion = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        Button_Descargar = new javax.swing.JButton();
        Button_Cerrar = new javax.swing.JButton();
        TextField_Total = new javax.swing.JTextField();
        Button_VerDetalle = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Empresa");

        TextField_Empresa.setEditable(false);

        jLabel2.setText("Fecha Desde");

        TextField_FechaDesde.setEditable(false);

        jLabel3.setText("Tipo de Impuesto");

        TextField_TipoImpuesto.setEditable(false);

        jLabel4.setText("Fecha Hasta");

        TextField_FechaHasta.setEditable(false);

        Tabla_Operacion.setAutoCreateRowSorter(true);
        Tabla_Operacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Numero Operacion", "Fecha Operacion", "Codigo Pago Electronico", "Nro Comprobante factura", "Importe", "Liquidada"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Tabla_Operacion);

        jLabel5.setText("Total importe Operaciones ");

        Button_Descargar.setText("Descargar");
        Button_Descargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_DescargarActionPerformed(evt);
            }
        });

        Button_Cerrar.setText("Cerrar");

        TextField_Total.setEditable(false);
        TextField_Total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextField_TotalActionPerformed(evt);
            }
        });

        Button_VerDetalle.setText("Ver Detalle");
        Button_VerDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_VerDetalleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TextField_Empresa)
                    .addComponent(TextField_FechaDesde, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
                .addGap(196, 196, 196)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TextField_TipoImpuesto, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                    .addComponent(TextField_FechaHasta))
                .addContainerGap(88, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextField_Total, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Button_Descargar)
                        .addGap(75, 75, 75)
                        .addComponent(Button_Cerrar)
                        .addGap(92, 92, 92))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(Button_VerDetalle)
                        .addGap(32, 32, 32))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(TextField_Empresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(TextField_TipoImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(TextField_FechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(TextField_FechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(Button_VerDetalle)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_Cerrar)
                    .addComponent(Button_Descargar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(TextField_Total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button_DescargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_DescargarActionPerformed
                                                    
        if (this.Tabla_Operacion.getRowCount()==0) {
            JOptionPane.showMessageDialog (null, "No hay datos en la tabla para exportar.","BCO",
                JOptionPane.INFORMATION_MESSAGE);
            //this.cmbConsorcio.grabFocus();
            return;
        }
       /* JFileChooser chooser=new JFileChooser();
        FileNameExtensionFilter filter=new FileNameExtensionFilter("Archivos de excel","xls");
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("Guardar archivo");
        chooser.setMultiSelectionEnabled(false);
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showSaveDialog(null)==JFileChooser.APPROVE_OPTION){
            List<JTable> tb=new ArrayList<>();
            List<String>nom=new ArrayList<>();
            tb.add(Tabla_Operacion);
            nom.add("Detalle de Gastos");
            String file=chooser.getSelectedFile().toString().concat(".xls");
            try {
                ExporterExcel e=new ExporterExcel(new File(file),tb, nom);
                if (e.export()) {
                    JOptionPane.showMessageDialog(null, "Los datos fueron exportados a excel.","BCO",
                        JOptionPane.INFORMATION_MESSAGE);

                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"Hubo un error"+ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        */
    }//GEN-LAST:event_Button_DescargarActionPerformed

    private void Button_VerDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_VerDetalleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Button_VerDetalleActionPerformed

    private void TextField_TotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextField_TotalActionPerformed

       
    }//GEN-LAST:event_TextField_TotalActionPerformed

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
            java.util.logging.Logger.getLogger(IUConsultarOperacionesBancariasArchivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IUConsultarOperacionesBancariasArchivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IUConsultarOperacionesBancariasArchivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IUConsultarOperacionesBancariasArchivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IUConsultarOperacionesBancariasArchivo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Cerrar;
    private javax.swing.JButton Button_Descargar;
    private javax.swing.JButton Button_VerDetalle;
    private javax.swing.JTable Tabla_Operacion;
    private javax.swing.JTextField TextField_Empresa;
    private javax.swing.JTextField TextField_FechaDesde;
    private javax.swing.JTextField TextField_FechaHasta;
    private javax.swing.JTextField TextField_TipoImpuesto;
    private javax.swing.JTextField TextField_Total;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
