/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.View.Empresa.Principal;

import sistemapagoimpuestos.Controller.ControladorConsultarLiquidacion;
import sistemapagoimpuestos.Dto.DTOUsuario;
import sistemapagoimpuestos.Globals.GlobalVars;
import sistemapagoimpuestos.Utils.MetodosPantalla;
import sistemapagoimpuestos.View.Admin.Principal.IUAdminPantallaPrincipal;

/**
 *
 * @author Gabriel
 */
public class IUPantallaEmpresa extends javax.swing.JFrame {
    ControladorConsultarLiquidacion controladorConsultarLiq = new ControladorConsultarLiquidacion();

    public IUPantallaEmpresa() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        buttonConsultarLiquidacion = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        label_fecha1 = new javax.swing.JLabel();
        label_nombre1 = new javax.swing.JLabel();

        jToggleButton1.setText("Pagar Impuestos");

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Bienvenido a Sistema de Pago de Impuestos");

        buttonConsultarLiquidacion.setSelected(true);
        buttonConsultarLiquidacion.setText("Consultar Liquidacion");
        buttonConsultarLiquidacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonConsultarLiquidacionActionPerformed(evt);
            }
        });

        jToggleButton3.setText("Consultar Operaciones Bancarias");

        label_fecha1.setText("jLabel3");

        label_nombre1.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jToggleButton3)
                            .addComponent(jLabel1))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonConsultarLiquidacion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 236, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_nombre1)
                            .addComponent(label_fecha1))
                        .addGap(109, 109, 109))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(buttonConsultarLiquidacion)
                        .addGap(18, 18, 18)
                        .addComponent(jToggleButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(label_nombre1)
                        .addGap(18, 18, 18)
                        .addComponent(label_fecha1)))
                .addContainerGap(239, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonConsultarLiquidacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonConsultarLiquidacionActionPerformed
        controladorConsultarLiq.validarUsuario();
        this.dispose();
    }//GEN-LAST:event_buttonConsultarLiquidacionActionPerformed

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
            java.util.logging.Logger.getLogger(IUPantallaEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IUPantallaEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IUPantallaEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IUPantallaEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IUPantallaEmpresa().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton buttonConsultarLiquidacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JLabel label_fecha1;
    private javax.swing.JLabel label_nombre1;
    // End of variables declaration//GEN-END:variables

    public void mostrarPantallaPrincipal() {
        IUPantallaEmpresa pe = new IUPantallaEmpresa();
        String fechaHoraInhabilitacionUsuarioEncontrada = (GlobalVars.userActive.getFechaHoraUltimoIngresoSistemaUsuario() == null)?"Sin último acceso":GlobalVars.userActive.getFechaHoraUltimoIngresoSistemaUsuario().toString();        
        pe.label_nombre1.setText("Nombre Usuario: " + GlobalVars.userActive.getNombreUsuario());
        pe.label_fecha1.setText("Ultimo acceso " + fechaHoraInhabilitacionUsuarioEncontrada );
        MetodosPantalla.getInstance().setearPantalla(this);
    }
}