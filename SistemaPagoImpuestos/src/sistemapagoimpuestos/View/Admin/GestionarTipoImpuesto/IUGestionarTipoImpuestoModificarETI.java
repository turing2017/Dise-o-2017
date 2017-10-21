package sistemapagoimpuestos.View.Admin.GestionarTipoImpuesto;

import exceptions.Excepciones;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import sistemapagoimpuestos.Controller.ControladorGestionarEmpresaTipoImpuesto;
import sistemapagoimpuestos.Controller.ControladorGestionarTipoImpuesto;
import sistemapagoimpuestos.Dto.DTOEmpresaTipImpItem;
import sistemapagoimpuestos.Dto.DTOTipoEmpresa;
import sistemapagoimpuestos.Dto.DTOTipoImpuesto;
import sistemapagoimpuestos.Utils.MetodosPantalla;

/**
 *
 * @author lunamarcos
 */
public class IUGestionarTipoImpuestoModificarETI extends javax.swing.JFrame {

    ControladorGestionarTipoImpuesto controlador = new ControladorGestionarTipoImpuesto();
    ControladorGestionarEmpresaTipoImpuesto controladorETI = new ControladorGestionarEmpresaTipoImpuesto();
    public String cuitEmpresa;
    
    
    public IUGestionarTipoImpuestoModificarETI() {
        initComponents();
    }
    String cuit;
    String nombreTI;
    String nombreTE;
    public IUGestionarTipoImpuestoModificarETI(String cuitEmpresa,  String nombreTI, String nombreTE, boolean estadoETI, boolean montoEditable){
        initComponents();
        cuit = cuitEmpresa;
        this.nombreTI = nombreTI;
        this.nombreTE = nombreTE;
        llenarComboTipoEmpresa(obtenerTipoImpuesto());
        llenarComboTipoImpuesto(obtenerTipoEmpresas());
        comboBox_tipoEmpresa.setSelectedItem(nombreTE);
        jComboBoxTipoImpuesto.setSelectedItem(nombreTI);
        jCheckBoxEstado.setSelected(estadoETI);
        textfield_frecuencia.setText(nombreTE);
        int frec = setearFrecuencia(nombreTI, cuitEmpresa, nombreTE);
        String g= ("" + frec);
        textfield_frecuencia.setText(g);
        this.cuitEmpresa = cuitEmpresa;
    }
    public static List<DTOEmpresaTipImpItem> dTOEmpresaTipImpItemAltaList;

    public static List<DTOEmpresaTipImpItem> getDtoetiisModfAlta() {
        return dTOEmpresaTipImpItemAltaList;
    }
    public int setearFrecuencia(String nombreTipoImpuesto, String cuitEmpresa, String nombreTipoEmpresa){
        return controlador.setearFrecuencia(nombreTipoImpuesto, cuitEmpresa, nombreTipoEmpresa);
    }
    
    public static void setDtoetiisModfAlta(List<DTOEmpresaTipImpItem> dTOEmpresaTipImpItem) {
        dTOEmpresaTipImpItem = dTOEmpresaTipImpItem;
    }

    public ControladorGestionarTipoImpuesto getControlador() {
        return controlador;
    }
    
    public void setControlador(ControladorGestionarTipoImpuesto controlador) {
        this.controlador = controlador;
    }

    public JComboBox<String> getComboBox_tipoEmpresa() {
        return comboBox_tipoEmpresa;
    }

    public void setComboBox_tipoEmpresa(JComboBox<String> comboBox_tipoEmpresa) {
        this.comboBox_tipoEmpresa = comboBox_tipoEmpresa;
    }

    public JCheckBox getjCheckBox1() {
        return jCheckBoxEstado;
    }

    public void setjCheckBox1(JCheckBox jCheckBox1) {
        this.jCheckBoxEstado = jCheckBox1;
    }

    public JComboBox<String> getjComboBoxTipoImpuesto() {
        return jComboBoxTipoImpuesto;
    }

    public void setjComboBoxTipoImpuesto(JComboBox<String> jComboBoxTipoImpuesto) {
        this.jComboBoxTipoImpuesto = jComboBoxTipoImpuesto;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }


    public JLabel getLabel_frecuencia() {
        return label_frecuencia;
    }

    public void setLabel_frecuencia(JLabel label_frecuencia) {
        this.label_frecuencia = label_frecuencia;
    }

    public JLabel getLabel_nombre() {
        return label_nombre;
    }

    public void setLabel_nombre(JLabel label_nombre) {
        this.label_nombre = label_nombre;
    }

    public JTextField getTextfield_frecuencia() {
        return textfield_frecuencia;
    }

    public void setTextfield_frecuencia(JTextField textfield_frecuencia) {
        this.textfield_frecuencia = textfield_frecuencia;
    }

    public static void addDtoetiisModfAlta(DTOEmpresaTipImpItem dTOEmpresaTipImpItem) {
        if (dTOEmpresaTipImpItemAltaList == null) {
            dTOEmpresaTipImpItemAltaList = new ArrayList<>();
        }
        dTOEmpresaTipImpItemAltaList.add(dTOEmpresaTipImpItem);
    }

    public static void removeDtoetiisModfAlta(int index) {
        dTOEmpresaTipImpItemAltaList.remove(index);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_nombre = new javax.swing.JLabel();
        Modificar = new javax.swing.JButton();
        cancel_button = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        comboBox_tipoEmpresa = new javax.swing.JComboBox<>();
        label_frecuencia = new javax.swing.JLabel();
        textfield_frecuencia = new javax.swing.JTextField();
        jComboBoxTipoImpuesto = new javax.swing.JComboBox<>();
        jCheckBoxEstado = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label_nombre.setText("Nombre Tipo Impuesto");

        Modificar.setText("Modificar");
        Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarActionPerformed(evt);
            }
        });

        cancel_button.setText("Cancelar");
        cancel_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_buttonActionPerformed(evt);
            }
        });

        jLabel1.setText("Tipo de Empresa");

        comboBox_tipoEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBox_tipoEmpresaActionPerformed(evt);
            }
        });

        label_frecuencia.setText("Frecuencia de Liquidación");

        textfield_frecuencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textfield_frecuenciaActionPerformed(evt);
            }
        });

        jComboBoxTipoImpuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTipoImpuestoActionPerformed(evt);
            }
        });

        jCheckBoxEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxEstadoActionPerformed(evt);
            }
        });

        jLabel2.setText("Estado");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 179, Short.MAX_VALUE)
                        .addComponent(cancel_button, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(label_nombre)
                            .addComponent(label_frecuencia)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBoxEstado)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(comboBox_tipoEmpresa, 0, 111, Short.MAX_VALUE)
                                .addComponent(textfield_frecuencia)
                                .addComponent(jComboBoxTipoImpuesto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label_nombre)
                    .addComponent(jComboBoxTipoImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel1))
                    .addComponent(comboBox_tipoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_frecuencia)
                    .addComponent(textfield_frecuencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jCheckBoxEstado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Modificar)
                    .addComponent(cancel_button))
                .addGap(26, 26, 26))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarActionPerformed
        String nuevoTE = (String) comboBox_tipoEmpresa.getSelectedItem();
        String nuevoTI = (String) jComboBoxTipoImpuesto.getSelectedItem();
        int frec = Integer.parseInt(textfield_frecuencia.getText());
        boolean habilitada = jCheckBoxEstado.isSelected();
        controlador.ModificarETI(nombreTE, nombreTI, cuit, nuevoTE, nuevoTI, frec, habilitada);
        controlador.iniciar(cuit);
        this.dispose();
    }//GEN-LAST:event_ModificarActionPerformed

  
    private void cancel_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_buttonActionPerformed
        this.dispose();
        controlador.iniciar(cuit);
    }//GEN-LAST:event_cancel_buttonActionPerformed

    private void comboBox_tipoEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBox_tipoEmpresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBox_tipoEmpresaActionPerformed

    private void textfield_frecuenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textfield_frecuenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textfield_frecuenciaActionPerformed

    private void jCheckBoxEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxEstadoActionPerformed

    private void jComboBoxTipoImpuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTipoImpuestoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxTipoImpuestoActionPerformed

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
            java.util.logging.Logger.getLogger(IUGestionarTipoImpuestoModificarETI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IUGestionarTipoImpuestoModificarETI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IUGestionarTipoImpuestoModificarETI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IUGestionarTipoImpuestoModificarETI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IUGestionarTipoImpuestoModificarETI().setVisible(true);
            }
        });
    }
    
        //Método para llenar el comboBox
    public void llenarComboTipoImpuesto(List<DTOTipoEmpresa> listaDTOTipoEmpresa){
        for (int i = 0; i < listaDTOTipoEmpresa.size(); i++) {
            DTOTipoEmpresa dtoTipoEmpresa = (DTOTipoEmpresa) listaDTOTipoEmpresa.get(i);
            String nombreTipoEmpresa = dtoTipoEmpresa.getNombreTipoEmpresa();
            comboBox_tipoEmpresa.addItem(nombreTipoEmpresa);
        }
    } 
    public void llenarComboTipoEmpresa(List<DTOTipoImpuesto> listaDTOTipoImpuesto){
        for (int i = 0; i < listaDTOTipoImpuesto.size(); i++) {
            DTOTipoImpuesto dtoTipoImpuesto = (DTOTipoImpuesto) listaDTOTipoImpuesto.get(i);
            String nombreTipoImpuesto = dtoTipoImpuesto.getNombreDTOTipoImpuesto();
            jComboBoxTipoImpuesto.addItem(nombreTipoImpuesto);
        }
    }
    
    public List<DTOTipoEmpresa> obtenerTipoEmpresas(){
        return controladorETI.obtenerTipoEmpresas();
    }    
    public List<DTOTipoImpuesto> obtenerTipoImpuesto(){
        return controladorETI.obtenerTipoImpuesto();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Modificar;
    private javax.swing.JButton cancel_button;
    private javax.swing.JComboBox<String> comboBox_tipoEmpresa;
    private javax.swing.JCheckBox jCheckBoxEstado;
    private javax.swing.JComboBox<String> jComboBoxTipoImpuesto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel label_frecuencia;
    private javax.swing.JLabel label_nombre;
    private javax.swing.JTextField textfield_frecuencia;
    // End of variables declaration//GEN-END:variables
}
