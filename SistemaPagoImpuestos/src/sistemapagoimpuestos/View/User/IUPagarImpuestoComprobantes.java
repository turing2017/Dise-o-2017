package sistemapagoimpuestos.View.User;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import sistemapagoimpuestos.Controller.ControladorPagarImpuestos;
import sistemapagoimpuestos.Dto.DTOComprobantePantalla;
import sistemapagoimpuestos.Dto.DTOCuentaBancaria;
import sistemapagoimpuestos.Dto.DTOItemComprobantePantalla;
import sistemapagoimpuestos.Dto.DTOOperacionActual;
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

    public IUPagarImpuestoComprobantes(List<DTOComprobantePantalla> listadoDTOComprobantePantalla, boolean esEditable) {
        initComponents();

        cargarTablaComprobantes(listadoDTOComprobantePantalla);
        List<DTOCuentaBancaria> listadoDTOCuentas = controlador.obtenerCuentas(GlobalVars.userActive.getCliente().getCuilCuitCliente());
        cargarTablaCuentas(listadoDTOCuentas);

        // Action Listener para tabla de cuentas
        tabla_cuentas.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (tabla_cuentas.getSelectedRow() > -1) {
                    String cbuCuentaSelec = tabla_cuentas.getValueAt(tabla_cuentas.getSelectedRow(), 0).toString();
                    // Busco el DTO correspondiente al CBU
                    for (DTOCuentaBancaria dtoCuenta : listadoDTOCuentas) {
                        if (dtoCuenta.getCbuCuentaBancaria().equals(cbuCuentaSelec)) {
                            lbl_out_cbu.setText(dtoCuenta.getCbuCuentaBancaria());
                            lbl_out_tipo_Cuenta.setText(dtoCuenta.getNombreTipoCuenta());
                            lbl_out_saldo.setText(String.valueOf(dtoCuenta.getSaldoRecuperado()));
                        }
                    }
                }
            }
        });

        // Action Listener para tabla de comprobantes
        tabla_comprobantes.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (tabla_comprobantes.getSelectedRow() > -1) {
                    int posicionMontoTotal = 2;
                    textfield_monto_a_pagar.setText(tabla_comprobantes.getModel().getValueAt(tabla_comprobantes.getSelectedRow(), posicionMontoTotal).toString());
                    int columnNroFac = 0;
                    String nroFactura = tabla_comprobantes.getModel().getValueAt(tabla_comprobantes.getSelectedRow(), columnNroFac).toString();
                    // Busco el DTO correspondiente al nroFactura
                    for (DTOComprobantePantalla dtoComprobantePantalla : listadoDTOComprobantePantalla) {
                        if (Integer.toString(dtoComprobantePantalla.getNumeroFactura()).equals(nroFactura)) {
                            List<DTOComprobantePantalla> comprobanteSelec = new ArrayList<>();
                            comprobanteSelec.add(dtoComprobantePantalla);
                            cargarAtribAdic(comprobanteSelec);
                            break;
                        }
                    }
                }
            }
        });

        // Comportamiento si es editable
        textfield_monto_a_pagar.setEnabled(esEditable);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_comprobantes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btn_cerrar = new javax.swing.JButton();
        title_cuenta_select = new javax.swing.JLabel();
        text_cbu = new javax.swing.JLabel();
        txt_tipo_cuenta = new javax.swing.JLabel();
        lbl_out_tipo_Cuenta = new javax.swing.JLabel();
        lbl_out_cbu = new javax.swing.JLabel();
        button_pagar = new javax.swing.JButton();
        text_monto_a_pagar = new javax.swing.JLabel();
        textfield_monto_a_pagar = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_cuentas = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbl_out_saldo = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla_atrib_adic = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();

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

        tabla_cuentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tabla_cuentas);

        jLabel2.setText("Datos adicionales del comprobante seleccionado:");

        jLabel3.setText("Saldo");

        lbl_out_saldo.setText("-Seleccionar Cuenta-");

        tabla_atrib_adic.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tabla_atrib_adic);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Cuentas Disponibles");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(title_cuenta_select)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_tipo_cuenta)
                                    .addComponent(text_cbu)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_out_saldo)
                                    .addComponent(lbl_out_cbu)
                                    .addComponent(lbl_out_tipo_Cuenta))))
                        .addGap(71, 71, 71)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btn_cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(text_monto_a_pagar)
                            .addGap(18, 18, 18)
                            .addComponent(textfield_monto_a_pagar, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(button_pagar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(title_cuenta_select)
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_tipo_cuenta)
                            .addComponent(lbl_out_tipo_Cuenta))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(text_cbu)
                            .addComponent(lbl_out_cbu))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(lbl_out_saldo))
                        .addGap(154, 154, 154)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(button_pagar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textfield_monto_a_pagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(text_monto_a_pagar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(10, 10, 10))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void button_pagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_pagarActionPerformed
        try {
            // Obtengo el código del elemento seleccionado
            int columnNroFac = 0;
            int columnCode = 1;
            int rowSelected = tabla_comprobantes.getSelectedRow();
            String nroFactura = tabla_comprobantes.getModel().getValueAt(rowSelected, columnNroFac).toString();
            String CodigoFactura = tabla_comprobantes.getModel().getValueAt(rowSelected, columnCode).toString();
            // Agregar validacion si es editable.....

            if (textfield_monto_a_pagar.isEnabled()) {
                int posicionPagoMinimo = 0;

                for (int i = 0; i < tabla_atrib_adic.getRowCount(); i++) {
                    if (tabla_atrib_adic.getValueAt(i, 0).equals("Monto Minimo")) {                        
                        posicionPagoMinimo = i;
                    }
                }

                if (Double.parseDouble(textfield_monto_a_pagar.getText()) < Double.parseDouble(tabla_atrib_adic.getModel().getValueAt(posicionPagoMinimo, 1).toString())) {
                    JOptionPane msg = new JOptionPane("No puede abonar el monto seleccionado", JOptionPane.PLAIN_MESSAGE);
                    JDialog dlg = msg.createDialog("Error");
                    dlg.setVisible(true);
                    return;
                }
            }
            int posicionSaldoCuenta = 2;
            if (Double.parseDouble(textfield_monto_a_pagar.getText()) > Double.parseDouble(tabla_cuentas.getModel().getValueAt(0, posicionSaldoCuenta).toString())) {
                JOptionPane msg = new JOptionPane("No puede abonar el monto seleccionado, saldo insuficiente", JOptionPane.PLAIN_MESSAGE);
                JDialog dlg = msg.createDialog("Error");
                dlg.setVisible(true);
                return;
            }
            if (lbl_out_cbu.getText().toString().equals("-Seleccionar Cuenta-")) {
                JOptionPane msg = new JOptionPane("Debe seleccionar una cuenta", JOptionPane.PLAIN_MESSAGE);
                JDialog dlg = msg.createDialog("Error");
                dlg.setVisible(true);
                return;
            }
            DTOOperacionActual dtoOperacion = controlador.pagarImpuesto(lbl_out_cbu.getText(),
                    Double.parseDouble(textfield_monto_a_pagar.getText()),
                    nroFactura,
                    CodigoFactura);
            this.dispose();
            IUPagarImpuestoOperacion iuOperacion = new IUPagarImpuestoOperacion(dtoOperacion);
            iuOperacion.setVisible(true);
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane msg = new JOptionPane("Debe seleccionar un comprobante", JOptionPane.PLAIN_MESSAGE);
            JDialog dlg = msg.createDialog("Error");
            dlg.setVisible(true);
            return;
        } catch (java.lang.NumberFormatException e) {
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
            vect.add(dtoComprobante.getCodigoComprobante());
            vect.add(dtoComprobante.getMontoTotalComprobante());
            vect.add(format.format(dtoComprobante.getFechaHoraVencimientoComprobante()));
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

    // Método para cargar los atributos adicionales en la tabla
    public void cargarAtribAdic(List<DTOComprobantePantalla> listaComprobantesPantalla) {

        String[] columnas = {"Nombre Atributo", "Valor"};

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
                        return String.class;
                }
            }
        };
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        List<DTOItemComprobantePantalla> atributosAdicionales =listaComprobantesPantalla.get(0).getAtributosAdicionalesComprobante();
        Collections.sort(atributosAdicionales);
        
        for (DTOItemComprobantePantalla item : atributosAdicionales) {
            Vector<Object> vect = new Vector<>();
            vect.add(item.getNombreItem());
            vect.add(item.getItemVal());
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
        tabla_atrib_adic.setModel(dtm);
        tabla_atrib_adic.getColumnModel().getColumn(0).setCellRenderer(r);
        tabla_atrib_adic.getColumnModel().getColumn(1).setCellRenderer(r);

    }

    // Método para cargar los cuentas en la tabla
    public void cargarTablaCuentas(List<DTOCuentaBancaria> ListaCuentaBancaria) {

        // Muestro los datos en la tabla
        String[] columnas = {"CBU", "Tipo de Cuenta", "Saldo"};

        // Creo el modelo
        DefaultTableModel dtm = new DefaultTableModel(null, columnas) {

            // Sobreescribo el método para no permitir editar la tabla
            @Override
            public boolean isCellEditable(int row, int column) {
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
                    default:
                        return null;
                }
            }

        };

        for (DTOCuentaBancaria dtoCuenta : ListaCuentaBancaria) {
            Vector<Object> vect = new Vector<>();
            vect.add(dtoCuenta.getCbuCuentaBancaria());
            vect.add(dtoCuenta.getNombreTipoCuenta());
            vect.add(dtoCuenta.getSaldoRecuperado());
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
    private javax.swing.JButton btn_cerrar;
    private javax.swing.JButton button_pagar;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lbl_out_cbu;
    private javax.swing.JLabel lbl_out_saldo;
    private javax.swing.JLabel lbl_out_tipo_Cuenta;
    private javax.swing.JTable tabla_atrib_adic;
    private javax.swing.JTable tabla_comprobantes;
    private javax.swing.JTable tabla_cuentas;
    private javax.swing.JLabel text_cbu;
    private javax.swing.JLabel text_monto_a_pagar;
    private javax.swing.JTextField textfield_monto_a_pagar;
    private javax.swing.JLabel title_cuenta_select;
    private javax.swing.JLabel txt_tipo_cuenta;
    // End of variables declaration//GEN-END:variables
}
