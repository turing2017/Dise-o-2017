package sistemapagoimpuestos.View.Admin.GestionarItem;

import exceptions.Excepciones;
import java.util.Arrays;
import java.util.List;
import sistemapagoimpuestos.Controller.ControladorGestionarItem;
import sistemapagoimpuestos.Dto.DTOTipoDatoItem;
import sistemapagoimpuestos.Entity.TipoDatoItem;

/**
 *
 * @author lunamarcos
 */
public class IUGestionarItemAlta extends javax.swing.JFrame {
    
    ControladorGestionarItem controlador = new ControladorGestionarItem();
    
    public IUGestionarItemAlta() {
        initComponents();
        List<DTOTipoDatoItem> list = controlador.buscarTipoDatoItems();
        llenarCombo(list);
        
    }
    
    // Método para llenar el comboBox
    private void llenarCombo(List<DTOTipoDatoItem> list){
        for (int i = 0; i < list.size(); i++) {
            DTOTipoDatoItem dtoTipoDatoItem = (DTOTipoDatoItem) list.get(i);
            comboBox_tipoDato.addItem(dtoTipoDatoItem.getNombreTipoDatoItem());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_nombre = new javax.swing.JLabel();
        label_codigo = new javax.swing.JLabel();
        label_longitud = new javax.swing.JLabel();
        label_requerido = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        textfield_nombre = new javax.swing.JTextField();
        textfield_longitud = new javax.swing.JTextField();
        textfield_codigo = new javax.swing.JTextField();
        checkbox_requerido = new javax.swing.JCheckBox();
        comboBox_tipoDato = new javax.swing.JComboBox<>();
        button_crear = new javax.swing.JButton();
        button_atras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label_nombre.setText("Nombre Item");

        label_codigo.setText("Código Item");

        label_longitud.setText("Longitud Item");

        label_requerido.setText("Requrido");

        jLabel1.setText("Tipo Dato Item");

        comboBox_tipoDato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBox_tipoDatoActionPerformed(evt);
            }
        });

        button_crear.setText("Crear");
        button_crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_crearActionPerformed(evt);
            }
        });

        button_atras.setText("Atrás");
        button_atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_atrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_nombre)
                    .addComponent(label_codigo)
                    .addComponent(label_longitud)
                    .addComponent(label_requerido)
                    .addComponent(jLabel1))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(checkbox_requerido)
                    .addComponent(textfield_longitud, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addComponent(textfield_nombre)
                    .addComponent(textfield_codigo, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addComponent(comboBox_tipoDato, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(204, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(button_atras, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(button_crear, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_nombre)
                    .addComponent(textfield_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_codigo)
                    .addComponent(textfield_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_longitud)
                    .addComponent(textfield_longitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_requerido)
                    .addComponent(checkbox_requerido))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(comboBox_tipoDato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_crear)
                    .addComponent(button_atras))
                .addContainerGap(74, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void comboBox_tipoDatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBox_tipoDatoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBox_tipoDatoActionPerformed

    private void button_crearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_crearActionPerformed
        // TODO add your handling code here:
        try{
            String codigoItem = textfield_codigo.getText();
            String nombreItem = textfield_nombre.getText();
            int longitudItem = Integer.parseInt(textfield_longitud.getText());
            boolean esRequerido = checkbox_requerido.isSelected();
            
            // Aca debrria agregar para obtener del combo y validacion
//            for (int i = 0; i < tabla_empresa_item.getRowCount(); i++) {
//                if((Boolean)(tabla_empresa_item.getValueAt(i, 1)) == true){
//                    String dtoItem = tabla_empresa_item.getValueAt(i, 0).toString();
//                }
//        }
            String nombreTipoDatoItemSeleccionado = comboBox_tipoDato.getSelectedItem().toString();
            controlador.nuevoItem(codigoItem, nombreItem, longitudItem, esRequerido, nombreTipoDatoItemSeleccionado);
            this.dispose();
            controlador.iniciar();
        }catch(java.lang.NumberFormatException e){
            Excepciones.getInstance().camposRequerido(Arrays.asList("Codigo", "Nombre"));
        }
    }//GEN-LAST:event_button_crearActionPerformed

    private void button_atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_atrasActionPerformed
        // TODO add your handling code here:
        this.dispose();
        controlador.iniciar();
    }//GEN-LAST:event_button_atrasActionPerformed

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
            java.util.logging.Logger.getLogger(IUGestionarItemAlta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IUGestionarItemAlta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IUGestionarItemAlta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IUGestionarItemAlta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IUGestionarItemAlta().setVisible(true);
            }
        });
    }
    // Setter para el controlador
    public void setControlador(ControladorGestionarItem controlador) {
        this.controlador = controlador;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_atras;
    private javax.swing.JButton button_crear;
    private javax.swing.JCheckBox checkbox_requerido;
    private javax.swing.JComboBox<String> comboBox_tipoDato;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel label_codigo;
    private javax.swing.JLabel label_longitud;
    private javax.swing.JLabel label_nombre;
    private javax.swing.JLabel label_requerido;
    private javax.swing.JTextField textfield_codigo;
    private javax.swing.JTextField textfield_longitud;
    private javax.swing.JTextField textfield_nombre;
    // End of variables declaration//GEN-END:variables
}
