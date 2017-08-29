package sistemapagoimpuestos.View.Admin.GestionarEmpresaTipoImpuesto;

import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import sistemapagoimpuestos.Controller.ControladorGestionarEmpresaTipoImpuesto;
import sistemapagoimpuestos.Dto.DTOEmpresa;
import sistemapagoimpuestos.Dto.DTOTipoImpuesto;


public class IUGestionarEmpresaTipoImpuesto extends javax.swing.JFrame {
    
    IUGestionarEmpresaTipoImpuestoTrifurcacion pantallaTrifurcacion;
    
    public IUGestionarEmpresaTipoImpuesto() {
        initComponents();
        List<DTOTipoImpuesto> listadoTipoImpuestos = ControladorGestionarEmpresaTipoImpuesto.getInstance().iniciar();
        llenarComboTipoImpuesto(listadoTipoImpuestos);
        List<DTOEmpresa> listadoEmpresas = ControladorGestionarEmpresaTipoImpuesto.getInstance().buscarEmpresas();
        llenarComboEmpresa(listadoEmpresas); 
    }

    private void llenarComboEmpresa(List<DTOEmpresa> listado){
        for (int i = 0; i < listado.size(); i++) {
            DTOEmpresa elemento = (DTOEmpresa) listado.get(i);
            combo_Empresa.addItem(elemento.getNombreDTOEmpresa());
        }
    }
    private void llenarComboTipoImpuesto(List<DTOTipoImpuesto> listado){
        for (int i = 0; i < listado.size(); i++) {
            DTOTipoImpuesto elemento = (DTOTipoImpuesto) listado.get(i);
            combo_TipoImpuesto.addItem(elemento.getNombreDTOTipoImpuesto());
        }
    }
    public JComboBox<String> getCombo_Empresa() {
        return combo_Empresa;
    }

    public JComboBox<String> getCombo_TipoImpuesto() {
        return combo_TipoImpuesto;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        button_Salir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        combo_TipoImpuesto = new javax.swing.JComboBox<>();
        combo_Empresa = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        button_Continuar = new javax.swing.JButton();

        jFormattedTextField1.setText("jFormattedTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        button_Salir.setText("Salir");
        button_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_SalirActionPerformed(evt);
            }
        });

        jLabel1.setText("Tipo de Impuesto");

        combo_TipoImpuesto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Seleccionar Tipo de Impuesto-" }));
        combo_TipoImpuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_TipoImpuestoActionPerformed(evt);
            }
        });

        combo_Empresa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Seleccionar Empresa-" }));

        jLabel2.setText("Empresa");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Gestionar Empresa Tipo Impuesto");

        button_Continuar.setText("Continuar");
        button_Continuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_ContinuarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(button_Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button_Continuar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(combo_Empresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(100, 100, 100)
                        .addComponent(combo_TipoImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(14, 14, 14)))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(combo_TipoImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_Empresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(87, 87, 87)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_Salir)
                    .addComponent(button_Continuar))
                .addGap(28, 28, 28))
        );

        button_Salir.getAccessibleContext().setAccessibleName("button_salir");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_SalirActionPerformed
        // Cierra la ventana
        System.exit(0);
    }//GEN-LAST:event_button_SalirActionPerformed

    private void combo_TipoImpuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_TipoImpuestoActionPerformed
        
    }//GEN-LAST:event_combo_TipoImpuestoActionPerformed

    private void button_ContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_ContinuarActionPerformed
        String nombreTipoImpuesto = (String) combo_TipoImpuesto.getSelectedItem();
        String nombreEmpresa = (String) combo_Empresa.getSelectedItem();
        ControladorGestionarEmpresaTipoImpuesto.getInstance().ingresarDatosETI(nombreTipoImpuesto, nombreEmpresa);
    }//GEN-LAST:event_button_ContinuarActionPerformed

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
            java.util.logging.Logger.getLogger(IUGestionarEmpresaTipoImpuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IUGestionarEmpresaTipoImpuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IUGestionarEmpresaTipoImpuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IUGestionarEmpresaTipoImpuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IUGestionarEmpresaTipoImpuesto().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_Continuar;
    private javax.swing.JButton button_Salir;
    private javax.swing.JComboBox<String> combo_Empresa;
    private javax.swing.JComboBox<String> combo_TipoImpuesto;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
