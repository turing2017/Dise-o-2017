package sistemapagoimpuestos.View.Admin.GestionarItem;

import exceptions.ExcepcionGenerica;
import exceptions.Excepciones;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import sistemapagoimpuestos.Controller.ControladorGestionarItem;
import sistemapagoimpuestos.Dto.DTOItem;
import sistemapagoimpuestos.Dto.DTOTipoDatoItem;

/**
 *
 * @author lunamarcos
 */
public class IUGestionarItemModificar extends javax.swing.JFrame {

    ControladorGestionarItem controlador = new ControladorGestionarItem();
    
    public IUGestionarItemModificar() {
        initComponents();
    }
    public IUGestionarItemModificar(DTOItem dtoItem, List<DTOTipoDatoItem> list, String nombreItemActual) {
        initComponents();
                            
                    setTextfield_nombre(dtoItem.getNombreItem());
                    setTextfield_longitud(dtoItem.getLongitudItem());
                    setCheckbox_requerido(dtoItem.isRequeridoItem());
                    if (dtoItem.getFechaHoraInhabilitacionItem() == null) {
                        setCheckbox_habilitado(true);
                    } else {
                        setCheckbox_habilitado(false);
                    }

                    llenarCombo(list, nombreItemActual);
                    setNombreActual(dtoItem.getNombreItem());
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_nombre = new javax.swing.JLabel();
        label_longitud = new javax.swing.JLabel();
        label_requerido = new javax.swing.JLabel();
        label_habilitado = new javax.swing.JLabel();
        label_tipoDato = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        comboBox_tipoDato = new javax.swing.JComboBox<>();
        checkbox_habilitado = new javax.swing.JCheckBox();
        checkbox_requerido = new javax.swing.JCheckBox();
        textfield_longitud = new javax.swing.JTextField();
        textfield_nombre = new javax.swing.JTextField();
        button_modificar = new javax.swing.JButton();
        button_atras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label_nombre.setText("Nombre");

        label_longitud.setText("Longitud");

        label_requerido.setText("Requerido");

        label_habilitado.setText("Habilitado");

        label_tipoDato.setText("Tipo de Dato");

        jLabel1.setText("MODIFICAR ITEM");

        button_modificar.setText("Modificar");
        button_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_modificarActionPerformed(evt);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_tipoDato)
                            .addComponent(label_habilitado)
                            .addComponent(label_requerido)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(label_longitud)
                                .addComponent(label_nombre)))
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(checkbox_requerido)
                            .addComponent(checkbox_habilitado)
                            .addComponent(textfield_nombre)
                            .addComponent(textfield_longitud)
                            .addComponent(comboBox_tipoDato, 0, 110, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(227, 227, 227)
                        .addComponent(jLabel1)))
                .addContainerGap(204, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(button_atras, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 226, Short.MAX_VALUE)
                .addComponent(button_modificar)
                .addGap(67, 67, 67))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_nombre)
                    .addComponent(textfield_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_longitud)
                    .addComponent(textfield_longitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_requerido)
                    .addComponent(checkbox_requerido))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_habilitado)
                    .addComponent(checkbox_habilitado))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_tipoDato)
                    .addComponent(comboBox_tipoDato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_modificar)
                    .addComponent(button_atras))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void button_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_modificarActionPerformed
        // TODO add your handling code here:
        try{
            if(textfield_nombre.getText().isEmpty()||textfield_longitud.getText().isEmpty()){
                throw new ExcepcionGenerica("Los campos Nombre y Longitud Item son requeridos");
            }
            if(textfield_nombre.getText().equals("")){
                textfield_nombre.setText(null);
                throw new java.lang.NumberFormatException();
            }
            controlador.modificarItem(getNombreActual(), textfield_nombre.getText(), Integer.parseInt(textfield_longitud.getText()), checkbox_requerido.isSelected(), checkbox_habilitado.isSelected(), comboBox_tipoDato.getSelectedItem().toString());
            this.dispose();
            controlador.validadarUsuario();
        } catch (java.lang.NumberFormatException e) {
            Excepciones.getInstance().errorGenerico("Error de formato", "El formato ingresado no es valido");
        } catch (ExcepcionGenerica e) {
            Excepciones.getInstance().errorGenerico("Error de formato", e.getMessage());
        }
    }//GEN-LAST:event_button_modificarActionPerformed

    private void button_atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_atrasActionPerformed
        // TODO add your handling code here:
        this.dispose();
        controlador.validadarUsuario();
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
            java.util.logging.Logger.getLogger(IUGestionarItemModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IUGestionarItemModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IUGestionarItemModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IUGestionarItemModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IUGestionarItemModificar().setVisible(true);
            }
        });
    }
    
    // Setters y Getters
    
    public void setCheckbox_habilitado(boolean habilitado) {
        this.checkbox_habilitado.setSelected(habilitado);
    }

    public void setCheckbox_requerido(boolean requerido) {
        this.checkbox_requerido.setSelected(requerido);
    }

    public void setTextfield_longitud(int longitud) {
        this.textfield_longitud.setText(Integer.toString(longitud));
    }

    public void setTextfield_nombre(String nombre) {
        this.textfield_nombre.setText(nombre);
    }

    public boolean getCheckbox_habilitado() {
        return checkbox_habilitado.isSelected();
    }

    public boolean getCheckbox_requerido() {
        return checkbox_requerido.isSelected();
    }

    public int getTextfield_longitud() {
        return Integer.parseInt(textfield_longitud.getText());
    }

    public String getTextfield_nombre() {
        return textfield_nombre.getText();
    }
    
    public void setComboBoxTipoDato(String nombreTipoDato){
        comboBox_tipoDato.addItem(nombreTipoDato);
    }

    public void setNombreActual(String nombreActual) {
        this.nombreActual = nombreActual;
    }

    public String getNombreActual() {
        return nombreActual;
    }

    public void setControlador(ControladorGestionarItem controlador) {
        this.controlador = controlador;
    }
    
    //Método para llenar el comboBox, evitando repetidos
    public void llenarCombo(List<DTOTipoDatoItem> list, String nombreActual){
    // ArrayList donde almaceno los nombres a mostrar
    ArrayList<String> nombresTipoDato = new ArrayList<String>();
    nombresTipoDato.add(nombreActual);
    comboBox_tipoDato.addItem(nombreActual);
    for (int i = 0; i < list.size(); i++) {
        DTOTipoDatoItem dtoTipoDatoItem = (DTOTipoDatoItem) list.get(i);
        String nombreTipoDato = dtoTipoDatoItem.getNombreTipoDatoItem();
        if (!nombresTipoDato.contains(nombreTipoDato)) {
            comboBox_tipoDato.addItem(nombreTipoDato);
        }
    }
}
    
    // Variable para permitir búsqueda por nombre
    private String nombreActual;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_atras;
    private javax.swing.JButton button_modificar;
    private javax.swing.JCheckBox checkbox_habilitado;
    private javax.swing.JCheckBox checkbox_requerido;
    private javax.swing.JComboBox<String> comboBox_tipoDato;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel label_habilitado;
    private javax.swing.JLabel label_longitud;
    private javax.swing.JLabel label_nombre;
    private javax.swing.JLabel label_requerido;
    private javax.swing.JLabel label_tipoDato;
    private javax.swing.JTextField textfield_longitud;
    private javax.swing.JTextField textfield_nombre;
    // End of variables declaration//GEN-END:variables
}
