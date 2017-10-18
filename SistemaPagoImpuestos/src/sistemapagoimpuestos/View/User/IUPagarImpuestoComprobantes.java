package sistemapagoimpuestos.View.User;

import exceptions.Excepciones;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.Timer;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import sistemapagoimpuestos.Controller.ControladorPagarImpuestos;
import sistemapagoimpuestos.Dto.DTOComprobante;
import sistemapagoimpuestos.Dto.DTOComprobantePantalla;
import sistemapagoimpuestos.Dto.DTOCuentaBancaria;
import sistemapagoimpuestos.Dto.DTOItem;
import sistemapagoimpuestos.Dto.DTOOperacion;
import sistemapagoimpuestos.Globals.GlobalVars;

public class IUPagarImpuestoComprobantes extends javax.swing.JFrame {

    ControladorPagarImpuestos controlador = new ControladorPagarImpuestos();
    String codigoPagoElectronico;

    public IUPagarImpuestoComprobantes() {
        initComponents();
        button_pagar.setEnabled(false);
        textfield_monto_a_pagar.setEnabled(false);
        button_pagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (lbl_out_tipo_Cuenta.getText() != "-Seleccionar Cuenta-") {
                    button_pagar.setEnabled(true);
                }
            }
        });
    }

    public IUPagarImpuestoComprobantes(List<DTOComprobantePantalla> listadoDTOComprobantePantalla) {
        initComponents();
        cargarTablaComprobantes(listadoDTOComprobantePantalla);
        try {
            // Verifico si es monto editable
            textfield_monto_a_pagar.setEditable(controlador.isMontoEditable());
            if(controlador.isMontoEditable()){
                textfield_monto_a_pagar.setEditable(true);
            } else {
                textfield_monto_a_pagar.setEditable(false);
                tabla_comprobantes.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                    @Override
                    public void valueChanged(ListSelectionEvent event) {
                        if (tabla_comprobantes.getSelectedRow() > -1) {
                            textfield_monto_a_pagar.setText(tabla_comprobantes.getValueAt(tabla_comprobantes.getSelectedRow(), 2).toString());
                        }
                    }
                });
            }
        } catch (Exception ex) {
            Logger.getLogger(IUPagarImpuestoComprobantes.class.getName()).log(Level.SEVERE, null, ex);
        }
        btn_Selec_Cuenta.setEnabled(false);
        ListSelectionModel listSelectionModel = tabla_comprobantes.getSelectionModel();
        listSelectionModel.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                ListSelectionModel lsm = (ListSelectionModel) e.getSource();
                btn_Selec_Cuenta.setEnabled(!lsm.isSelectionEmpty());
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_comprobantes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btn_cerrar = new javax.swing.JButton();
        btn_Selec_Cuenta = new javax.swing.JButton();
        title_cuenta_select = new javax.swing.JLabel();
        text_cbu = new javax.swing.JLabel();
        txt_tipo_cuenta = new javax.swing.JLabel();
        lbl_out_tipo_Cuenta = new javax.swing.JLabel();
        lbl_out_cbu = new javax.swing.JLabel();
        button_pagar = new javax.swing.JButton();
        text_monto_a_pagar = new javax.swing.JLabel();
        textfield_monto_a_pagar = new javax.swing.JTextField();

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

        btn_cerrar.setText("Cerrar");
        btn_cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cerrarActionPerformed(evt);
            }
        });

        btn_Selec_Cuenta.setText("Seleccionar Cuenta");
        btn_Selec_Cuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Selec_CuentaActionPerformed(evt);
            }
        });

        title_cuenta_select.setText("Datos de la cuenta seleccionada:");

        text_cbu.setText("CBU:");

        txt_tipo_cuenta.setText("Tipo de Cuenta:");

        lbl_out_tipo_Cuenta.setText("-Seleccionar Cuenta-");

        lbl_out_cbu.setText("-Seleccionar Cuenta-");

        button_pagar.setText("Pagar");
        button_pagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_pagarActionPerformed(evt);
            }
        });

        text_monto_a_pagar.setText("Monto a pagar:");

        textfield_monto_a_pagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textfield_monto_a_pagarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(text_cbu)
                            .addComponent(text_monto_a_pagar)
                            .addComponent(txt_tipo_cuenta))
                        .addGap(82, 82, 82)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_out_cbu)
                            .addComponent(lbl_out_tipo_Cuenta)
                            .addComponent(textfield_monto_a_pagar, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btn_Selec_Cuenta)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(272, 272, 272))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btn_cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button_pagar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 719, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(title_cuenta_select))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_Selec_Cuenta)
                .addGap(16, 16, 16)
                .addComponent(title_cuenta_select)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_tipo_cuenta)
                    .addComponent(lbl_out_tipo_Cuenta))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text_cbu)
                    .addComponent(lbl_out_cbu))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text_monto_a_pagar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textfield_monto_a_pagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(button_pagar, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(btn_cerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_Selec_CuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Selec_CuentaActionPerformed
        controlador.obtenerCuentas(GlobalVars.userActive.getCliente().getCuilCuitCliente(), this);
    }//GEN-LAST:event_btn_Selec_CuentaActionPerformed

    private void button_pagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_pagarActionPerformed
        try {
            // Obtengo el código del elemento seleccionado
            int columnNroFac = 0;
            int columnCode = 1;
            int rowSelected = tabla_comprobantes.getSelectedRow();
            String nroFactura = tabla_comprobantes.getModel().getValueAt(rowSelected, columnNroFac).toString();
            String CodigoFactura = tabla_comprobantes.getModel().getValueAt(rowSelected, columnCode).toString();
            if(textfield_monto_a_pagar.isEditable()){
                if(Double.parseDouble(textfield_monto_a_pagar.getText()) < Double.parseDouble(tabla_comprobantes.getModel().getValueAt(rowSelected, 7).toString())){
                    JOptionPane msg = new JOptionPane("No puede abonar el monto seleccionado", JOptionPane.PLAIN_MESSAGE);
                    JDialog dlg = msg.createDialog("Error");
                    dlg.setVisible(true);
                    return;
                }
            }
            
            if(lbl_out_cbu.getText().toString().equals("-Seleccionar Cuenta-")){
                JOptionPane msg = new JOptionPane("Debe seleccionar una cuenta", JOptionPane.PLAIN_MESSAGE);
                JDialog dlg = msg.createDialog("Error");
                dlg.setVisible(true);
                return;
            }
            DTOOperacion dtoOperacion = controlador.pagarImpuesto(lbl_out_cbu.getText(), 
                    Double.parseDouble(textfield_monto_a_pagar.getText()),
                    nroFactura,
                    CodigoFactura);
            this.dispose();
            IUPagarImpuestoOperacion iuOperacion = new IUPagarImpuestoOperacion(dtoOperacion);
            iuOperacion.setVisible(true);
        } catch (ArrayIndexOutOfBoundsException e){
            JOptionPane msg = new JOptionPane("Debe seleccionar un comprobante", JOptionPane.PLAIN_MESSAGE);
            JDialog dlg = msg.createDialog("Error");
            dlg.setVisible(true);
            return;
        } catch (java.lang.NumberFormatException e){
            JOptionPane msg = new JOptionPane("Debe ingresar importe válido", JOptionPane.PLAIN_MESSAGE);
            JDialog dlg = msg.createDialog("Error");
            dlg.setVisible(true);
            return;
        }
    }//GEN-LAST:event_button_pagarActionPerformed

    private void textfield_monto_a_pagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textfield_monto_a_pagarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textfield_monto_a_pagarActionPerformed

    private void btn_cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerrarActionPerformed
        this.dispose();
        ControladorPagarImpuestos cpi = new ControladorPagarImpuestos();
        cpi.validadarUsuario();
    }//GEN-LAST:event_btn_cerrarActionPerformed

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
    public void cargarTablaComprobantes(List<DTOComprobantePantalla> listaComprobantesPantalla) {

        // Muestro los datos en la tabla
        ArrayList<String> columnList = new ArrayList<>();
        columnList.add("Numero Factura");
        columnList.add("Codigo Comprobante");
        columnList.add("Monto Total");
        columnList.add("Vencimiento");

        for (DTOItem item : listaComprobantesPantalla.get(0).getAtributosAdicionalesDTOComprobante()) {
            columnList.add(item.getNombreItem());
        }
        Object[] columnas = columnList.toArray();

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
                    case 2:
                        return double.class;
                    case 3:
                        return String.class;
                    default:
                        return String.class;
                }
            }

        };
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        for (DTOComprobantePantalla dtoComprobante : listaComprobantesPantalla) {
            Vector<Object> vect = new Vector<>();
            vect.add(dtoComprobante.getNumeroFactura());
            vect.add(dtoComprobante.getCodigoDTOComprobante());
            vect.add(dtoComprobante.getMontoTotalDTOComprobante());
            vect.add(format.format(dtoComprobante.getFechaHoraVencimientoDTOComprobante()));

            String atribAdic = "";
            List<DTOItem> listadoItems = dtoComprobante.getAtributosAdicionalesDTOComprobante();
            for (DTOItem item : listadoItems) {
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

    public void setLbl_out_cbu(String cbu) {
        this.lbl_out_cbu.setText(cbu);
    }

    public void setLbl_out_tipo_Cuenta(String nombreTipoCuenta) {
        this.lbl_out_tipo_Cuenta.setText(nombreTipoCuenta);
    }

    // Metodo para modificar la pantalla si el TI es editable
    public void setearEditable() {
        System.out.println("es editable");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Selec_Cuenta;
    private javax.swing.JButton btn_cerrar;
    private javax.swing.JButton button_pagar;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_out_cbu;
    private javax.swing.JLabel lbl_out_tipo_Cuenta;
    private javax.swing.JTable tabla_comprobantes;
    private javax.swing.JLabel text_cbu;
    private javax.swing.JLabel text_monto_a_pagar;
    private javax.swing.JTextField textfield_monto_a_pagar;
    private javax.swing.JLabel title_cuenta_select;
    private javax.swing.JLabel txt_tipo_cuenta;
    // End of variables declaration//GEN-END:variables
}
