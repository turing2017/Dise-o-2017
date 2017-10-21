package sistemapagoimpuestos.View.User;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.WindowConstants;
import sistemapagoimpuestos.Controller.ControladorPagarImpuestos;
import sistemapagoimpuestos.Dto.DTOComprobantePantalla;
import sistemapagoimpuestos.Dto.DTOEmpresa;
import sistemapagoimpuestos.Dto.DTOTipoImpuesto;
import sistemapagoimpuestos.View.Login.IULogin;

/**
 *
 * @author lunamarcos
 */
public class IUPagarImpuesto extends javax.swing.JFrame {

    ControladorPagarImpuestos controlador = new ControladorPagarImpuestos();

    /**
     * Creates new form IUPagarImpuesto
     */
    public IUPagarImpuesto() {
        initComponents();
        // Busco todos los tipoimpuestos
        llenarComboTipoImpuesto(buscarTipoImpuestos());
        // Agrego action listener para que se ejecute cuando cambie el valor seleccionado de TI
        comboBox_tipoImpuesto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Al seleccionar un TI debe buscar las empresas
                if (!comboBox_tipoImpuesto.getSelectedItem().toString().equals("Seleccione Tipo de Impuesto")) {
                    llenarComboEmpresa(buscarEmpresas(comboBox_tipoImpuesto.getSelectedItem().toString()));
                } else {
                    comboBox_empresa.removeAllItems();
                    comboBox_empresa.setEnabled(false);
                    // Limpio el formulario
                    textfield_codigo.setText("");
                    button_buscar.setEnabled(false);
                }
            }
        });
        textfield_codigo.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                if (!(ke.getKeyChar() == 27 || ke.getKeyChar() == 65535)) //Esta sección se ejecuta cuando el usuario edita el campo
                {
                    if (comboBox_empresa.getSelectedItem() != null && comboBox_empresa.toString() != ""
                            && !comboBox_empresa.getSelectedItem().toString().equals("No se encontró Empresa")
                            && textfield_codigo.getText() != null && textfield_codigo.getText().toString() != ""
                            && textfield_codigo.getText().toString().length() > 1) {
                        button_buscar.setEnabled(true);
                    } else {
                        button_buscar.setEnabled(false);
                    }
                }
            }
        });

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev) {
                dispose();
                IULogin iULogin = new IULogin();
                iULogin.setVisible(true);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_pagarImpuesto = new javax.swing.JLabel();
        label_tipoImpuesto = new javax.swing.JLabel();
        comboBox_tipoImpuesto = new javax.swing.JComboBox<>();
        label_empresa = new javax.swing.JLabel();
        comboBox_empresa = new javax.swing.JComboBox<>();
        label_codigo = new javax.swing.JLabel();
        textfield_codigo = new javax.swing.JTextField();
        button_buscar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label_pagarImpuesto.setText("PAGAR IMPUESTO");

        label_tipoImpuesto.setText("Tipo de Impuesto");

        comboBox_tipoImpuesto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Tipo de Impuesto" }));
        comboBox_tipoImpuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBox_tipoImpuestoActionPerformed(evt);
            }
        });

        label_empresa.setText("Empresa");
        label_empresa.setToolTipText("");

        comboBox_empresa.setEnabled(false);

        label_codigo.setText("Codigo pago electrónico");

        button_buscar.setText("Buscar");
        button_buscar.setEnabled(false);
        button_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_buscarActionPerformed(evt);
            }
        });

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label_pagarImpuesto)
                .addGap(257, 257, 257))
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(250, 250, 250)
                        .addComponent(button_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_tipoImpuesto)
                            .addComponent(label_empresa)
                            .addComponent(label_codigo))
                        .addGap(91, 91, 91)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboBox_tipoImpuesto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboBox_empresa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textfield_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(label_pagarImpuesto)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_tipoImpuesto)
                    .addComponent(comboBox_tipoImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_empresa)
                    .addComponent(comboBox_empresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_codigo)
                    .addComponent(textfield_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_buscar)
                    .addComponent(jButton1))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void comboBox_tipoImpuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBox_tipoImpuestoActionPerformed

    }//GEN-LAST:event_comboBox_tipoImpuestoActionPerformed

    private void button_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_buscarActionPerformed
        List<DTOComprobantePantalla> listadoComprobantePantalla = controlador.seleccionarEmpresa(comboBox_empresa.getSelectedItem().toString(), textfield_codigo.getText().toString());
        if (listadoComprobantePantalla != null) {
            boolean esEditable = controlador.isMontoEditable();
            controlador.mostrarPantallaComprobantes(listadoComprobantePantalla, esEditable);
            this.dispose();
        }
    }//GEN-LAST:event_button_buscarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        IULogin iULogin = new IULogin();
        iULogin.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(IUPagarImpuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IUPagarImpuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IUPagarImpuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IUPagarImpuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IUPagarImpuesto().setVisible(true);
            }
        });
    }

    // Método para recuperar los TipoImpuesto
    public List<DTOTipoImpuesto> buscarTipoImpuestos() {
        return controlador.buscarTipoImpuestos();
    }

    //Método para llenar el comboBox
    public void llenarComboTipoImpuesto(List<DTOTipoImpuesto> listaDTOTipoImpuesto) {
        for (int i = 0; i < listaDTOTipoImpuesto.size(); i++) {
            DTOTipoImpuesto dtoTipoImpuesto = (DTOTipoImpuesto) listaDTOTipoImpuesto.get(i);
            String nombreTipoImpuesto = dtoTipoImpuesto.getNombreDTOTipoImpuesto();
            comboBox_tipoImpuesto.addItem(nombreTipoImpuesto);
        }
    }

    // Método para recuperar las Empresas
    public List<DTOEmpresa> buscarEmpresas(String nombreTipoImpuesto) {
        return controlador.buscarEmpresas(nombreTipoImpuesto);
    }

    // Método para llenar el combo de Empresa
    public void llenarComboEmpresa(List<DTOEmpresa> listaDTOEmpresa) {
        // Limpio el combo
        comboBox_empresa.removeAllItems();
        comboBox_empresa.setEnabled(false);
        if (listaDTOEmpresa.size() > 0) {
            comboBox_empresa.setEnabled(true);
            for (int i = 0; i < listaDTOEmpresa.size(); i++) {
                DTOEmpresa dtoEmpresa = (DTOEmpresa) listaDTOEmpresa.get(i);
                String nombreEmpresa = dtoEmpresa.getNombreEmpresa();
                comboBox_empresa.addItem(nombreEmpresa);
            }
        } else {
            comboBox_empresa.addItem("No se encontró Empresa");
        }
        // Limpio el formulario
        textfield_codigo.setText("");
        button_buscar.setEnabled(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_buscar;
    private javax.swing.JComboBox<String> comboBox_empresa;
    private javax.swing.JComboBox<String> comboBox_tipoImpuesto;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel label_codigo;
    private javax.swing.JLabel label_empresa;
    private javax.swing.JLabel label_pagarImpuesto;
    private javax.swing.JLabel label_tipoImpuesto;
    private javax.swing.JTextField textfield_codigo;
    // End of variables declaration//GEN-END:variables
}