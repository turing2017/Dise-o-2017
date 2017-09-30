/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.View.User;

import java.awt.Component;
import java.util.List;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import sistemapagoimpuestos.Dto.DTOSaldo;
/**
 *
 * @author Maximiliano
 */
public class IUPagarImpuestoCuentas extends javax.swing.JFrame {

    public IUPagarImpuestoCuentas() {
        initComponents();
        //cargarTablaCuentas(listadoDTOSaldo);
        
    }

    public void cargarTablaCuentas(List<DTOSaldo> listaCuentaBancaria){
        
        // Muestro los datos en la tabla
        String[] columnas = {"CBU Cuenta", "Tipo Cuenta"};
        
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
                        return null;
                }
            }

        };
        
        for (DTOSaldo dtoSaldo : listaCuentaBancaria) {
            Vector<Object> vect = new Vector<>();
            vect.add(dtoSaldo.getCbuCuentaBancaria());
            vect.add(dtoSaldo.getTipoCuenta().getNombreTipoCuenta());
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_cuentas = new javax.swing.JTable();
        button_Pagar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Cuentas disponibles");

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

        button_Pagar.setText("Pagar");
        button_Pagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_PagarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(button_Pagar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addComponent(button_Pagar)
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_PagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_PagarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button_PagarActionPerformed

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
            java.util.logging.Logger.getLogger(IUPagarImpuestoCuentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IUPagarImpuestoCuentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IUPagarImpuestoCuentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IUPagarImpuestoCuentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IUPagarImpuestoCuentas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_Pagar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabla_cuentas;
    // End of variables declaration//GEN-END:variables
}
