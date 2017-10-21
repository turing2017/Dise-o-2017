package sistemapagoimpuestos.View.Admin.GestionarTipoUsuario;

import exceptions.Excepciones;
import java.awt.Component;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import sistemapagoimpuestos.Controller.ControladorGestionarTipoUsuario;
import sistemapagoimpuestos.Dto.DTOTipoUsuario;
import sistemapagoimpuestos.Utils.MetodosPantalla;
import sistemapagoimpuestos.View.Admin.Principal.IUAdminPantallaPrincipal;
import sistemapagoimpuestos.View.Login.IULogin;

public class IUGestionarTipoUsuario extends javax.swing.JFrame {
    
    ControladorGestionarTipoUsuario controlador = new ControladorGestionarTipoUsuario();
    public IUGestionarTipoUsuario() {
        initComponents();
        obtenerTipoUsuario();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev) {
                dispose();
                IULogin iULogin = new IULogin();
                iULogin.setVisible(true);
            }
        });
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
        btn_cerrar = new javax.swing.JButton();

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

        btn_cerrar.setText("Cerrar");
        btn_cerrar.setToolTipText("");
        btn_cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(53, 53, 53)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(button_filtrar))))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(216, 216, 216)
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(btn_cerrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button_habilitar_deshabilitar)
                        .addGap(18, 18, 18)
                        .addComponent(button_nuevo)))
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
                    .addComponent(button_habilitar_deshabilitar)
                    .addComponent(btn_cerrar))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_nuevoActionPerformed
        //Le paso al controlador la operacion seleccionada
        IUGestionarTipoUsuarioAlta pantallaAlta = new IUGestionarTipoUsuarioAlta();
        MetodosPantalla.getInstance().setearPantalla(pantallaAlta);
        this.dispose();

    }//GEN-LAST:event_button_nuevoActionPerformed

    private void button_filtrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_filtrarActionPerformed
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(((DefaultTableModel) tabla_tipo_usuario.getModel()));
        sorter.setRowFilter(RowFilter.regexFilter(jTextField1.getText()));
        tabla_tipo_usuario.setRowSorter(sorter);
    }//GEN-LAST:event_button_filtrarActionPerformed

    private void button_habilitar_deshabilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_habilitar_deshabilitarActionPerformed
        // Le paso al controlador la opción seleccionada.
        try {
            // Obtento el código del elemento seleccionado
            int columnCode = 0;
            int rowSelected = tabla_tipo_usuario.getSelectedRow();
            String codigo = tabla_tipo_usuario.getModel().getValueAt(rowSelected, columnCode).toString();

            controlador.modificarTipoUsuario(codigo);
            this.dispose();
            IUGestionarTipoUsuario pantallaPrincipal = new IUGestionarTipoUsuario();
            MetodosPantalla.getInstance().setearPantalla(pantallaPrincipal);
            this.dispose();
            
        } catch (ArrayIndexOutOfBoundsException e) {
            //Excepciones.getInstance().camposRequerido(Arrays.asList("Codigo"));
            Excepciones.getInstance().objetoNoSeleccionado();
        }
    }//GEN-LAST:event_button_habilitar_deshabilitarActionPerformed

    private void btn_cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerrarActionPerformed
        this.dispose();
        IUAdminPantallaPrincipal iUAdminPantallaPrincipal = new IUAdminPantallaPrincipal();
        iUAdminPantallaPrincipal.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_btn_cerrarActionPerformed

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
        controlador.validadarUsuario();
    }

    public void obtenerTipoUsuario() {

        ArrayList<DTOTipoUsuario> listDtoTipoUsuario = controlador.obtenerTipoUsuario();

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cerrar;
    private javax.swing.JButton button_filtrar;
    private javax.swing.JButton button_habilitar_deshabilitar;
    private javax.swing.JButton button_nuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tabla_tipo_usuario;
    // End of variables declaration//GEN-END:variables
}
