package sistemapagoimpuestos.View.User;

import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
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
        btn_cerrar = new javax.swing.JButton();
        btn_Selec_Cuenta = new javax.swing.JButton();
        title_cuenta_select = new javax.swing.JLabel();
        text_cbu = new javax.swing.JLabel();
        txt_tipo_cuenta = new javax.swing.JLabel();
        lbl_out_tipo_Cuenta = new javax.swing.JLabel();
        lbl_out_cbu = new javax.swing.JLabel();
        btn_continuar = new javax.swing.JButton();

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

        btn_cerrar.setText("Cerrar");

        btn_Selec_Cuenta.setText("Seleccionar Cuenta");
        btn_Selec_Cuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Selec_CuentaActionPerformed(evt);
            }
        });

        title_cuenta_select.setText("Cuenta Seleccionada");

        text_cbu.setText("CBU:");

        txt_tipo_cuenta.setText("Tipo de Cuenta:");

        lbl_out_tipo_Cuenta.setText("jLabel5");

        lbl_out_cbu.setText("jLabel6");

        btn_continuar.setText("Continuar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(label_TipoImpuesto)
                            .addComponent(label_Empresa)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(171, 171, 171)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label_TipoImpuestoSelec)
                                    .addComponent(label_EmpresaSelec)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(41, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(text_cbu)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbl_out_cbu))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txt_tipo_cuenta)
                                    .addGap(113, 113, 113)
                                    .addComponent(lbl_out_tipo_Cuenta)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addComponent(title_cuenta_select)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_Selec_Cuenta)
                        .addGap(58, 58, 58))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_cerrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_continuar)
                        .addGap(86, 86, 86))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(title_cuenta_select)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_tipo_cuenta)
                            .addComponent(lbl_out_tipo_Cuenta)))
                    .addComponent(btn_Selec_Cuenta))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text_cbu)
                    .addComponent(lbl_out_cbu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cerrar)
                    .addComponent(btn_continuar))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_Selec_CuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Selec_CuentaActionPerformed
        List<DTOCuentaBancaria> listaDTOCuentas = controlador.obtenerCuentas("10000");
        
    }//GEN-LAST:event_btn_Selec_CuentaActionPerformed

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
        ArrayList<String> columnList = new ArrayList<>();          
        columnList.add("Codigo");
        columnList.add("Monto Total");
        columnList.add("Vencimiento");
        
        for(DTOItem item : listaComprobantes.get(0).getAtributosAdicionalesDTOComprobante()){
            columnList.add(item.getNombreItem());
        }      
        Object[] columnas =  columnList.toArray();
        
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
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        
        for (DTOComprobante dtoComprobante : listaComprobantes) {
            Vector<Object> vect = new Vector<>();
            vect.add(dtoComprobante.getCodigoDTOComprobante());
            vect.add(dtoComprobante.getMontoTotalDTOComprobante());
            vect.add(format.format(dtoComprobante.getFechaHoraVencimientoDTOComprobante()));
            
            String atribAdic = "";
            List<DTOItem> listadoItems = dtoComprobante.getAtributosAdicionalesDTOComprobante();
            for(DTOItem item : listadoItems){
                vect.add(item.getItemVal());
            }
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Selec_Cuenta;
    private javax.swing.JButton btn_cerrar;
    private javax.swing.JButton btn_continuar;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_Empresa;
    private javax.swing.JLabel label_EmpresaSelec;
    private javax.swing.JLabel label_TipoImpuesto;
    private javax.swing.JLabel label_TipoImpuestoSelec;
    private javax.swing.JLabel lbl_out_cbu;
    private javax.swing.JLabel lbl_out_tipo_Cuenta;
    private javax.swing.JTable tabla_comprobantes;
    private javax.swing.JLabel text_cbu;
    private javax.swing.JLabel title_cuenta_select;
    private javax.swing.JLabel txt_tipo_cuenta;
    // End of variables declaration//GEN-END:variables
}
