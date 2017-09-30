package sistemapagoimpuestos.View.User;

import java.awt.Component;
import java.util.List;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import sistemapagoimpuestos.Controller.ControladorPagarImpuestos;
import sistemapagoimpuestos.Dto.DTOComprobante;
import sistemapagoimpuestos.Dto.DTOCuentaBancaria;
import sistemapagoimpuestos.Dto.DTOItem;

public class IUPagarImpuestoComprobantes extends javax.swing.JFrame {
    
    ControladorPagarImpuestos controlador = new ControladorPagarImpuestos();

    public IUPagarImpuestoComprobantes() {
        initComponents();
    }
    
    public IUPagarImpuestoComprobantes(List<DTOComprobante> listadoDTOComprobante){
        initComponents();
        cargarTablaComprobantes(listadoDTOComprobante);
        //cargarTablaCuentas(controlador.obtenerCuentas("10000000"));
        //controlador.obtenerCuentas("10000000");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_comprobantes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        label_TipoImpuesto = new javax.swing.JLabel();
        label_Empresa = new javax.swing.JLabel();
        label_TipoImpuestoSelec = new javax.swing.JLabel();
        label_EmpresaSelec = new javax.swing.JLabel();
        button_Continuar = new javax.swing.JButton();
        button_Cancelar = new javax.swing.JButton();

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabla_comprobantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla_comprobantes);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Comprobantes Pendientes de Pago");

        label_TipoImpuesto.setText("Tipo de Impuesto:");

        label_Empresa.setText("Empresa:");

        label_TipoImpuestoSelec.setText("(Tipo de Impuesto Seleccionado por usuario)");

        label_EmpresaSelec.setText("(Empresa seleccionada por usuario)");

        button_Continuar.setText("Continuar");
        button_Continuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_ContinuarActionPerformed(evt);
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
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(button_Cancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button_Continuar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(label_TipoImpuesto)
                        .addComponent(label_Empresa)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(171, 171, 171)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(label_TipoImpuestoSelec)
                                .addComponent(label_EmpresaSelec)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(113, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_TipoImpuesto)
                    .addComponent(label_TipoImpuestoSelec))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_Empresa)
                    .addComponent(label_EmpresaSelec))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_Continuar)
                    .addComponent(button_Cancelar))
                .addGap(46, 46, 46))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_ContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_ContinuarActionPerformed
        int fila = tabla_comprobantes.getSelectedRow();
        String numeroComprobanteIngres = tabla_comprobantes.getValueAt(fila, 0).toString();
        //Insertar codigo que permite recuperar los comprobantes pendientes de pago
        //controlador.mostrarCuentas();
        this.dispose();
    }//GEN-LAST:event_button_ContinuarActionPerformed

    private void button_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_CancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_button_CancelarActionPerformed

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
            java.util.logging.Logger.getLogger(IUPagarImpuestoComprobantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IUPagarImpuestoComprobantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IUPagarImpuestoComprobantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IUPagarImpuestoComprobantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IUPagarImpuestoComprobantes().setVisible(true);
            }
        });
    }
    
    // Método para cargar los comprobantes en la tabla
    public void cargarTablaComprobantes(List<DTOComprobante> listaComprobantes){
        
        // Muestro los datos en la tabla
        String[] columnas = {"Codigo", "Monto Total", "Vencimiento", "Atributos adicionales"};
        
        // Creo el modelo
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
                        return double.class;
                    case 2:
                        return String.class;
                    default:
                        return String.class;
                }
            }

        };
        
        for (DTOComprobante dtoComprobante : listaComprobantes) {
            Vector<Object> vect = new Vector<>();
            vect.add(dtoComprobante.getCodigoDTOComprobante());
            vect.add(dtoComprobante.getMontoTotalDTOComprobante());
            
            String atribAdic = "";
            List<DTOItem> listadoItems = dtoComprobante.getAtributosAdicionalesDTOComprobante();
            for(DTOItem item : listadoItems){
                atribAdic = atribAdic.concat(item.getNombreItem()).concat(" ");
            }
            vect.add(atribAdic);
            dtm.addRow(vect);
            
        }

        DefaultTableCellRenderer r = new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(
                        table, value, isSelected, hasFocus, row, column);
                setHorizontalAlignment(JLabel.CENTER);
                return this;
            }
        };
        tabla_comprobantes.setModel(dtm);
        tabla_comprobantes.getColumnModel().getColumn(0).setCellRenderer(r);
        tabla_comprobantes.getColumnModel().getColumn(1).setCellRenderer(r);
    }
    
        // Método para cargar las cuentas bancarias en la tabla
    /*public void cargarTablaCuentas(List<DTOCuentaBancaria> listaCuentaBancaria){
        
        // Muestro los datos en la tabla
        String[] columnas = {"CBU Cuenta", "Tipo Cuenta"};
        
        // Creo el modelo
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
                        return String.class;
                    default:
                        return null;
                }
            }

        };
        
        for (DTOCuentaBancaria dtoCuentaBancaria : listaCuentaBancaria) {
            Vector<Object> vect = new Vector<>();
            vect.add(dtoCuentaBancaria.getCbuCuentaBancaria());
            vect.add(dtoCuentaBancaria.getTipoCuenta().getNombreTipoCuenta());
            dtm.addRow(vect);
            
        }

        DefaultTableCellRenderer r = new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(
                        table, value, isSelected, hasFocus, row, column);
                setHorizontalAlignment(JLabel.CENTER);
                return this;
            }
        };
        tabla_cuentas.setModel(dtm);
        tabla_cuentas.getColumnModel().getColumn(0).setCellRenderer(r);
        tabla_cuentas.getColumnModel().getColumn(1).setCellRenderer(r);
    }
*/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_Cancelar;
    private javax.swing.JButton button_Continuar;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_Empresa;
    private javax.swing.JLabel label_EmpresaSelec;
    private javax.swing.JLabel label_TipoImpuesto;
    private javax.swing.JLabel label_TipoImpuestoSelec;
    private javax.swing.JTable tabla_comprobantes;
    // End of variables declaration//GEN-END:variables
}
