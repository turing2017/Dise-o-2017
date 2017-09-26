package sistemapagoimpuestos.View.Admin.GestionarEmpresaAdherida;

import sistemapagoimpuestos.View.Admin.GestionarTipoImpuesto.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import exceptions.Excepciones;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import sistemapagoimpuestos.Controller.ControladorGestionarTipoImpuesto;
import sistemapagoimpuestos.Dto.DTOEmpresa;
import sistemapagoimpuestos.Dto.DTOEmpresaTipImpItem;
import sistemapagoimpuestos.Dto.DTOItem;
import sistemapagoimpuestos.Dto.DTOTipoEmpresa;
import sistemapagoimpuestos.Dto.DtoItemOrden;

public class IUGestionarEmpresaAdheridaItems extends javax.swing.JFrame {
    ControladorGestionarTipoImpuesto controlador = new ControladorGestionarTipoImpuesto();
    private List<DTOEmpresaTipImpItem> dTOEmpresaTipImpItemList;

    public List<DTOEmpresaTipImpItem> getdTOEmpresaTipImpItemList() {
        return dTOEmpresaTipImpItemList;
    }

    public void setdTOEmpresaTipImpItemList(List<DTOEmpresaTipImpItem> dTOEmpresaTipImpItemList) {
        this.dTOEmpresaTipImpItemList = dTOEmpresaTipImpItemList;
    }

    public void addDtoetiisModf(DTOEmpresaTipImpItem dTOEmpresaTipImpItem) {
        if (dTOEmpresaTipImpItemList == null) {
            dTOEmpresaTipImpItemList = new ArrayList<>();
        }
        dTOEmpresaTipImpItemList.add(dTOEmpresaTipImpItem);
    }

    public void removeDtoetiisModf(int index) {
        dTOEmpresaTipImpItemList.remove(index);
    }

    public IUGestionarEmpresaAdheridaItems() {
        initComponents();
        List<DTOEmpresa> listEmpresa = controlador.buscarEmpresas();
        //llenarComboEmpresa(listEmpresa);
        List<DTOTipoEmpresa> listTipoEmpresa = controlador.buscarTipoEmpresa();
        //llenarComboTipoEmpresa(listTipoEmpresa);
        List<DTOItem> items = controlador.buscarItems();
        llenarTabla(items);
    }

    private void llenarTabla(List<DTOItem> list) {
        String[] columnas = {"Item", "Orden", "Seleccion"};
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

            public boolean isCellEditable(int row, int column) {
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

    public static boolean nuevoTipoImpuesto;
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table_Item = new javax.swing.JTable();
        button_Aceptar = new javax.swing.JButton();
        button_Cancelar = new javax.swing.JToggleButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Gestionar Items");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(button_Aceptar)
                        .addGap(104, 104, 104)
                        .addComponent(button_Cancelar)))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_Aceptar)
                    .addComponent(button_Cancelar))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_CancelarActionPerformed
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_button_CancelarActionPerformed

    private void button_AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_AceptarActionPerformed

        try {
            DTOEmpresaTipImpItem dTOEmpresaTipImpItem = new DTOEmpresaTipImpItem();
            List<DtoItemOrden> dtoItemOrdenList = new ArrayList<>();
            
            for (int i = 0; i < table_Item.getRowCount(); i++) {
                if ((Boolean) (table_Item.getValueAt(i, 2))) {
                    DtoItemOrden dtoItemOrden = new DtoItemOrden();
                    dtoItemOrden.setNombreItem(table_Item.getValueAt(i, 0).toString());
                    dtoItemOrden.setOrden(Integer.parseInt(table_Item.getValueAt(i, 1).toString()));
                    dtoItemOrdenList.add(dtoItemOrden);
                }
            }
            dTOEmpresaTipImpItem.setDtoItemOrdenList(dtoItemOrdenList);
            if (! (dTOEmpresaTipImpItem.getDtoItemOrdenList().size() < 1)) {
                if (getNuevoTipoImpuesto()) {
                    IUGestionarTipoImpuestoAlta.setDtoetiisModfAlta(getdTOEmpresaTipImpItemList());
                    IUGestionarTipoImpuestoAlta.addDtoetiisModfAlta(dTOEmpresaTipImpItem);
                    IUGestionarTipoImpuestoAlta IUGestionarTipoImpuestoAlta = new IUGestionarTipoImpuestoAlta();
                    IUGestionarTipoImpuestoAlta.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); // Evito que se cierre al presionar x
                    IUGestionarTipoImpuestoAlta.setVisible(true); // La hago visible
                    // Modifico la operación de cierre para volver a la pantalla principal
                    IUGestionarTipoImpuestoAlta.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                    IUGestionarTipoImpuestoAlta.addWindowListener(new WindowAdapter() {
                        public void windowClosing(WindowEvent ev) {
                            controlador.iniciar();
                        }
                    });
                    IUGestionarTipoImpuestoAlta.RecuperarEmpresaItems();
                    IUGestionarTipoImpuestoAlta.setTextfield_codigo(getCodigoTemp());
                    IUGestionarTipoImpuestoAlta.setTextField_nombre(getNombreTemp());
                    IUGestionarTipoImpuestoAlta.setCheckbox_esEditable(isEditTemp());
                } else {
                    IUGestionarTipoImpuestoModificar.setdTOEmpresaTipImpItemList(getdTOEmpresaTipImpItemList());
                    IUGestionarTipoImpuestoModificar.adddTOEmpresaTipImpItemList(dTOEmpresaTipImpItem);
                    IUGestionarTipoImpuestoModificar pantallaModificar = new IUGestionarTipoImpuestoModificar();
                    pantallaModificar.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); // Evito que se cierre al presionar x
                    pantallaModificar.setVisible(true); // La hago visible
                    // Modifico la operación de cierre para volver a la pantalla principal
                    pantallaModificar.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

                    pantallaModificar.RecuperarEmpresaItems();
                    pantallaModificar.setLabel_nombre(getCodigoTemp());
                    pantallaModificar.setTextfield_nombre(getNombreTemp());
                    pantallaModificar.setCheckbox_Habilitar(isEditTemp());
                    pantallaModificar.setCheckbox_esEditable(isStatusTemp());
                }

                this.dispose();
            } else {
                List<String> stringList = new ArrayList<>();
                stringList.add("Empresa");
                stringList.add("Tipo Empresa");
                stringList.add("Frec. Liquidación");
                stringList.add("Item");
                Excepciones.getInstance().camposRequerido(stringList);
            }
        } catch (Exception e) {

        }

    }//GEN-LAST:event_button_AceptarActionPerformed


    public static void setNuevoTipoImpuesto(boolean valor) {
        nuevoTipoImpuesto = valor;
    }

    public static boolean getNuevoTipoImpuesto() {
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
            java.util.logging.Logger.getLogger(IUGestionarEmpresaAdheridaItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IUGestionarEmpresaAdheridaItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IUGestionarEmpresaAdheridaItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IUGestionarEmpresaAdheridaItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IUGestionarEmpresaAdheridaItems().setVisible(true);
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_Item;
    // End of variables declaration//GEN-END:variables
}
