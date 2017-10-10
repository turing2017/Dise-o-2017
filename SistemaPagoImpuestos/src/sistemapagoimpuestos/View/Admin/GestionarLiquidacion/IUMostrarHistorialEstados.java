/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.View.Admin.GestionarLiquidacion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import sistemapagoimpuestos.Controller.ControladorGestionarLiquidacion;
import sistemapagoimpuestos.Dto.DTOLiquidacionEstado;

/**
 *
 * @author vande
 */
public class IUMostrarHistorialEstados extends javax.swing.JFrame {

    /**
     * Creates new form IUMostrarHistorialEstados
     */
    public IUMostrarHistorialEstados(String numeroLiquidacion,String fechaLiquidacion) {
        initComponents();
        jLabelNumeroLiquidacion.setText(numeroLiquidacion);
        jLabelFechaLiquidacion.setText(fechaLiquidacion);
        ControladorGestionarLiquidacion controlador = new ControladorGestionarLiquidacion();
        List<DTOLiquidacionEstado> estados = controlador.buscarLiquidacionEstado(numeroLiquidacion);
        DefaultTableModel model = (DefaultTableModel)jTableEstados.getModel();
        
        for (int i = 0; i < estados.size(); i++) {
            model.addRow(new Object[]{});
            jTableEstados.setValueAt(estados.get(i).getEstadoLiquidacion(), i, 0);
            jTableEstados.setValueAt(estados.get(i).getFechaHoraDesdeLiquidacionEstado().toString(), i, 1);
            jTableEstados.setValueAt(estados.get(i).getFechaHoraHastaLiquidacionEstado(), i, 2);
        }

         
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableEstados = new javax.swing.JTable();
        jButtonCancelar = new javax.swing.JButton();
        jButtonDetalleOperacion = new javax.swing.JButton();
        jLabelNumeroLiquidacion = new javax.swing.JLabel();
        jLabelFechaLiquidacion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Numero Liquidacion");

        jLabel2.setText("FechaLiquidacion");

        jTableEstados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre Estado", "Fecha Desde", "Fecha Hasta"
            }
        ));
        jScrollPane1.setViewportView(jTableEstados);

        jButtonCancelar.setText("Cancelar");

        jButtonDetalleOperacion.setText("Detalle Operacion");
        jButtonDetalleOperacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDetalleOperacionActionPerformed(evt);
            }
        });

        jLabelNumeroLiquidacion.setText("jLabel3");

        jLabelFechaLiquidacion.setText("jLabel4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 65, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(41, 41, 41)
                        .addComponent(jLabelNumeroLiquidacion))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelFechaLiquidacion)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(jButtonCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonDetalleOperacion)
                .addGap(115, 115, 115))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabelNumeroLiquidacion))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabelFechaLiquidacion))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonDetalleOperacion))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonDetalleOperacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDetalleOperacionActionPerformed
     String nliquidacion = jLabelNumeroLiquidacion.getText();
    int f = jTableEstados.getSelectedRow();
    String fechaDesdeS = jTableEstados.getValueAt(f, 1).toString();
    
    String dateString = fechaDesdeS;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date fechaDesde = null;
        try {
            fechaDesde = sdf.parse(dateString);
        } catch (ParseException ex) {
            Logger.getLogger(IUMostrarHistorialEstados.class.getName()).log(Level.SEVERE, null, ex);
        }
    String fechaHastaS = jTableEstados.getValueAt(f, 2).toString();
    
    String dateString1 = fechaHastaS;
    
    Date fechaHasta = null;
        try {
            fechaHasta = sdf.parse(dateString1);
        } catch (ParseException ex) {
            Logger.getLogger(IUMostrarHistorialEstados.class.getName()).log(Level.SEVERE, null, ex);
        }
        IUMostrar mostrar = new IUMostrar(nliquidacion,fechaDesde,fechaHasta);
        mostrar.setVisible(true);
        mostrar.setLocation(300, 200);
        
    
    
     //   IUMostrar mostrar = new IUMostrar(nliquidacion);
        
        
    }//GEN-LAST:event_jButtonDetalleOperacionActionPerformed

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
            java.util.logging.Logger.getLogger(IUMostrarHistorialEstados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IUMostrarHistorialEstados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IUMostrarHistorialEstados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IUMostrarHistorialEstados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IUMostrarHistorialEstados("","").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonDetalleOperacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelFechaLiquidacion;
    private javax.swing.JLabel jLabelNumeroLiquidacion;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableEstados;
    // End of variables declaration//GEN-END:variables
}
