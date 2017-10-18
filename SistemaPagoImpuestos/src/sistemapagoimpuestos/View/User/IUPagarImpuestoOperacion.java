package sistemapagoimpuestos.View.User;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import sistemapagoimpuestos.Controller.ControladorPagarImpuestos;
import sistemapagoimpuestos.Dto.DTOOperacion;

/**
 *
 * @author lunamarcos
 */
public class IUPagarImpuestoOperacion extends javax.swing.JFrame {

    /**
     * Creates new form IUPagarImpuestoOperacion
     */
    public IUPagarImpuestoOperacion() {
        initComponents();
    }
    
    public IUPagarImpuestoOperacion(DTOOperacion dtoOperacion) {
        initComponents();
        nombreImpuesto.setText(dtoOperacion.getTipoImpuesto().getNombreTipoImpuesto());
        nombreEmpresa.setText(dtoOperacion.getEmpresa().getNombreEmpresa());
        numeroOperacion.setText(Integer.toString(dtoOperacion.getNumeroOperacion()));
        // Modifico la operación de cierre para no finalizar al presionar X
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        // Modifico el Listener para el evento de la X
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev) {
                dispose();
                ControladorPagarImpuestos cpi = new ControladorPagarImpuestos();
                cpi.validadarUsuario();
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_titulo = new javax.swing.JLabel();
        lbl_subTitulo = new javax.swing.JLabel();
        lbl_nombreImpuesto = new javax.swing.JLabel();
        lbl_nombreEmpresa = new javax.swing.JLabel();
        lbl_numOperacion = new javax.swing.JLabel();
        button_aceptar = new javax.swing.JButton();
        button_imprimir = new javax.swing.JButton();
        nombreImpuesto = new javax.swing.JLabel();
        nombreEmpresa = new javax.swing.JLabel();
        numeroOperacion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbl_titulo.setText("OPERACIÓN EXITOSA");

        lbl_subTitulo.setText("Se ha efectuado el pago correctamente.");

        lbl_nombreImpuesto.setText("Impuesto:");

        lbl_nombreEmpresa.setText("Empresa:");

        lbl_numOperacion.setText("Número de operación:");

        button_aceptar.setText("Aceptar");
        button_aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_aceptarActionPerformed(evt);
            }
        });

        button_imprimir.setText("Imprimir");
        button_imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_imprimirActionPerformed(evt);
            }
        });

        nombreImpuesto.setText("Nombre Impuesto");

        nombreEmpresa.setText("Nombre Empresa");

        numeroOperacion.setText("Numero Op");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(lbl_titulo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl_subTitulo)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_numOperacion)
                                .addGap(18, 18, 18)
                                .addComponent(numeroOperacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_nombreEmpresa)
                                    .addComponent(lbl_nombreImpuesto))
                                .addGap(94, 94, 94)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(nombreImpuesto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(nombreEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(84, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(button_imprimir)
                .addGap(18, 18, 18)
                .addComponent(button_aceptar)
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(lbl_titulo)
                .addGap(18, 18, 18)
                .addComponent(lbl_subTitulo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_nombreImpuesto)
                    .addComponent(nombreImpuesto))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombreEmpresa, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_nombreEmpresa))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_numOperacion)
                            .addComponent(numeroOperacion))
                        .addGap(29, 80, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(button_imprimir)
                            .addComponent(button_aceptar))
                        .addGap(15, 15, 15))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void button_aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_aceptarActionPerformed
        // TODO add your handling code here:
        this.dispose();
        ControladorPagarImpuestos cpi = new ControladorPagarImpuestos();
        cpi.validadarUsuario();
    }//GEN-LAST:event_button_aceptarActionPerformed

    private void button_imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_imprimirActionPerformed
        // TODO add your handling code here:
        JOptionPane msg = new JOptionPane("Imprimiendo...", JOptionPane.PLAIN_MESSAGE);
        JDialog dlg = msg.createDialog("Imprimiendo");
        dlg.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        new Thread(new Runnable() {
        @Override
        public void run() {
        try {
          Thread.sleep(5000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        dlg.setVisible(false);
      }
    }).start();
    dlg.setVisible(true);
        System.out.println("imprimiendo...");
        this.dispose();
        ControladorPagarImpuestos cpi = new ControladorPagarImpuestos();
        cpi.validadarUsuario();
    }//GEN-LAST:event_button_imprimirActionPerformed

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
            java.util.logging.Logger.getLogger(IUPagarImpuestoOperacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IUPagarImpuestoOperacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IUPagarImpuestoOperacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IUPagarImpuestoOperacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IUPagarImpuestoOperacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_aceptar;
    private javax.swing.JButton button_imprimir;
    private javax.swing.JLabel lbl_nombreEmpresa;
    private javax.swing.JLabel lbl_nombreImpuesto;
    private javax.swing.JLabel lbl_numOperacion;
    private javax.swing.JLabel lbl_subTitulo;
    private javax.swing.JLabel lbl_titulo;
    private javax.swing.JLabel nombreEmpresa;
    private javax.swing.JLabel nombreImpuesto;
    private javax.swing.JLabel numeroOperacion;
    // End of variables declaration//GEN-END:variables
}
