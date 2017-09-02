package sistemapagoimpuestos.View.Admin.GestionarTipoUsuario;

import exceptions.Excepciones;
import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import sistemapagoimpuestos.Controller.ControladorGestionarTipoUsuario;
import sistemapagoimpuestos.Dto.DTOTipoUsuario;
import sistemapagoimpuestos.Utils.MetodosPantalla;

public class IUGestionarTipoUsuario extends javax.swing.JFrame {

    public IUGestionarTipoUsuario() {
        initComponents();
        obtenerTipoUsuario();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_tipo_usuario = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        button_nuevo = new javax.swing.JButton();
        button_habilitar_deshabilitar = new javax.swing.JButton();
        button_filtrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("TIPO USUARIO");

        tabla_tipo_usuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabla_tipo_usuario);

        button_nuevo.setText("Nuevo");
        button_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_nuevoActionPerformed(evt);
            }
        });

        button_habilitar_deshabilitar.setText("Habilitar/Deshabilitar");
        button_habilitar_deshabilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_habilitar_deshabilitarActionPerformed(evt);
            }
        });

        button_filtrar.setText("Filtrar");
        button_filtrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_filtrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(button_habilitar_deshabilitar)
                                .addGap(18, 18, 18)
                                .addComponent(button_nuevo))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(button_filtrar)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(216, 216, 216)
                        .addComponent(jLabel1)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_filtrar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_nuevo)
                    .addComponent(button_habilitar_deshabilitar))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_nuevoActionPerformed
        //Le paso al controlador la operacion seleccionada
        opcionSeleccionada("Alta", null);

    }//GEN-LAST:event_button_nuevoActionPerformed

    private void button_filtrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_filtrarActionPerformed
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(((DefaultTableModel) tabla_tipo_usuario.getModel()));
        sorter.setRowFilter(RowFilter.regexFilter(jTextField1.getText()));
        tabla_tipo_usuario.setRowSorter(sorter);
    }//GEN-LAST:event_button_filtrarActionPerformed

    private void button_habilitar_deshabilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_habilitar_deshabilitarActionPerformed
        // TODO add your handling code here:
        // Le paso al controlador la opción seleccionada.
        try {
            // Obtento el código del elemento seleccionado
            int columnCode = 0;
            int rowSelected = tabla_tipo_usuario.getSelectedRow();
            String codigo = tabla_tipo_usuario.getModel().getValueAt(rowSelected, columnCode).toString();

            opcionSeleccionada("Habilitar_Deshabilitar", codigo);
            this.dispose();
        } catch (ArrayIndexOutOfBoundsException e) {
            //Excepciones.getInstance().camposRequerido(Arrays.asList("Codigo"));
            Excepciones.getInstance().objetoNoSeleccionado();
        }
    }//GEN-LAST:event_button_habilitar_deshabilitarActionPerformed

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
            java.util.logging.Logger.getLogger(IUGestionarTipoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IUGestionarTipoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IUGestionarTipoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IUGestionarTipoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                IUGestionarTipoUsuario pantallaPrincipal = new IUGestionarTipoUsuario();
                pantallaPrincipal.setVisible(true);

            }
        });
    }

    public void inciar() {
        ControladorGestionarTipoUsuario.getInstance().iniciar();
    }

    public void obtenerTipoUsuario() {

        ArrayList<DTOTipoUsuario> listDtoTipoUsuario = ControladorGestionarTipoUsuario.getInstance().obtenerTipoUsuario();

        String[] columnas = {"Nombre Tipo Usuario", "Fecha Inhabilitación"};
        DefaultTableModel dtm = new DefaultTableModel(null, columnas) {

            @Override
            public boolean isCellEditable(int row, int column) {
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
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (DTOTipoUsuario dtoTipoUsuario : listDtoTipoUsuario) {
            Vector<Object> vect = new Vector<>();
            vect.add(dtoTipoUsuario.getNombreDTOTipoUsuario());
            String fecha = "";
            if (dtoTipoUsuario.getFechaHoraInhabilitacionDTOTipoUsuario() != null) {
                fecha = sdf.format(dtoTipoUsuario.getFechaHoraInhabilitacionDTOTipoUsuario()).toString();
            }

            vect.add(fecha);
            dtm.addRow(vect);
        }
        DefaultTableCellRenderer r = new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                setHorizontalAlignment(JLabel.CENTER);
                return this;
            }
        };

        tabla_tipo_usuario.setModel(dtm);
        tabla_tipo_usuario.getColumnModel().getColumn(0).setCellRenderer(r);
        tabla_tipo_usuario.getColumnModel().getColumn(1).setCellRenderer(r);

    }

    public void opcionSeleccionada(String opcion, Object object) {

        switch (opcion) {
            case "Alta":
                //Muestro pantalla alta
                IUGestionarTipoUsuarioAlta pantallaAlta = new IUGestionarTipoUsuarioAlta();
                MetodosPantalla.getInstance().setearPantalla(pantallaAlta);
                break;
            case "Habilitar_Deshabilitar":
                ControladorGestionarTipoUsuario.getInstance().modificarTipoUsuario((String) object);
                this.dispose();
                IUGestionarTipoUsuario pantallaPrincipal = new IUGestionarTipoUsuario();
                MetodosPantalla.getInstance().setearPantalla(pantallaPrincipal);

                break;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_filtrar;
    private javax.swing.JButton button_habilitar_deshabilitar;
    private javax.swing.JButton button_nuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tabla_tipo_usuario;
    // End of variables declaration//GEN-END:variables
}
