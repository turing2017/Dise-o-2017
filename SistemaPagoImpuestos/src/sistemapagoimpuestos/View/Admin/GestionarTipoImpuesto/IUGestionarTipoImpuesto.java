package sistemapagoimpuestos.View.Admin.GestionarTipoImpuesto;

import exceptions.Excepciones;
import java.awt.Component;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import sistemapagoimpuestos.Controller.ControladorGestionarEmpresaTipoImpuesto;
import sistemapagoimpuestos.Controller.ControladorGestionarTipoImpuesto;
import sistemapagoimpuestos.Dto.DTOEmpresaTipImpItem;
import sistemapagoimpuestos.Dto.DTOTipoImpuesto;

public class IUGestionarTipoImpuesto extends javax.swing.JFrame {
    
    ControladorGestionarTipoImpuesto controlador = new ControladorGestionarTipoImpuesto();
    ControladorGestionarEmpresaTipoImpuesto controladorETI = new ControladorGestionarEmpresaTipoImpuesto();
    String cuitEmpresa;
    
    public IUGestionarTipoImpuesto() {
        initComponents();
        // Esto hay que quitarlo, cuando se llame a esta pantalla se debe llamar al metodo siguiente pasando el cuitEmpresa
        this.cuitEmpresa = "123434343";
        obtenerTipoImpuestos("123434343");
        
    }
    public IUGestionarTipoImpuesto(String cuitEmpresa) {
        initComponents();
        // Esto hay que quitarlo, cuando se llame a esta pantalla se debe llamar al metodo siguiente pasando el cuitEmpresa
        // this.cuitEmpresa = cuitEmpresa;
        
        obtenerTipoImpuestos(cuitEmpresa);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        button_modificar = new javax.swing.JButton();
        button_nuevo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_tipo_impuesto = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        textfield_filtro = new javax.swing.JTextField();
        button_filtrar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        button_modificar.setText("Modificar");
        button_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_modificarActionPerformed(evt);
            }
        });

        button_nuevo.setText("Nuevo");
        button_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_nuevoActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(tabla_tipo_impuesto);

        jLabel1.setText("TIPOS DE IMPUESTOS");

        button_filtrar.setText("Filtrar");
        button_filtrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_filtrarActionPerformed(evt);
            }
        });

        jButton1.setText("Ver items");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Agregar Item");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(226, 226, 226))
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(textfield_filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(button_filtrar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(button_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(300, 300, 300)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_filtrar)
                    .addComponent(textfield_filtro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button_nuevo)
                    .addComponent(button_modificar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void button_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_nuevoActionPerformed
        controlador.mostrarPantallaAlta(cuitEmpresa);
        this.dispose();
    }//GEN-LAST:event_button_nuevoActionPerformed

    private void button_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_modificarActionPerformed
        // Le paso al controlador la opción seleccionada.
        try {
            // Obtento el código del elemento seleccionado
            int columnCode = 0;
            int rowSelected = tabla_tipo_impuesto.getSelectedRow();
            String codigo = tabla_tipo_impuesto.getModel().getValueAt(rowSelected, columnCode).toString();
            controlador.mostrarPantallaModificacion(Integer.parseInt(codigo));
        } catch (ArrayIndexOutOfBoundsException e) {
            //Excepciones.getInstance().camposRequerido(Arrays.asList("Codigo"));
            Excepciones.getInstance().objetoNoSeleccionado();
        }
        this.dispose();
    }//GEN-LAST:event_button_modificarActionPerformed

    private void button_filtrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_filtrarActionPerformed
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(((DefaultTableModel) tabla_tipo_impuesto.getModel()));
        sorter.setRowFilter(RowFilter.regexFilter(textfield_filtro.getText()));
        tabla_tipo_impuesto.setRowSorter(sorter);
    }//GEN-LAST:event_button_filtrarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
            // Obtento el código del elemento seleccionado
            int columnCode = 0;
            int rowSelected = tabla_tipo_impuesto.getSelectedRow();
            String codigo = tabla_tipo_impuesto.getModel().getValueAt(rowSelected, columnCode).toString();
            controlador.mostrarItems(cuitEmpresa, Integer.parseInt(codigo));
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            // Obtento el código del elemento seleccionado
            int columnCode = 0;
            int rowSelected = tabla_tipo_impuesto.getSelectedRow();
            String codigo = tabla_tipo_impuesto.getModel().getValueAt(rowSelected, columnCode).toString();
            controlador.agregarItem(cuitEmpresa, Integer.parseInt(codigo));
        } catch (ArrayIndexOutOfBoundsException e) {
            //Excepciones.getInstance().camposRequerido(Arrays.asList("Codigo"));
            Excepciones.getInstance().objetoNoSeleccionado();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(IUGestionarTipoImpuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IUGestionarTipoImpuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IUGestionarTipoImpuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IUGestionarTipoImpuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                IUGestionarTipoImpuesto pantallaPrincipal = new IUGestionarTipoImpuesto();
                pantallaPrincipal.setVisible(true);
            }
        });
    }

    public void iniciar() {
        controlador.iniciar();
    }

    public void obtenerTipoImpuestos(String cuitEmpresa) {
        // Muestro pantalla de Consultar
        ArrayList<DTOTipoImpuesto> listDtoTipoImpuesto = controlador.obtenerTipoImpuestosEmpresa(cuitEmpresa);

        String[] columnas = {"Codigo", "Nombre", "Monto Editable", "Estado"};
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
                        return Integer.class;
                    case 1:
                        return String.class;
                    case 2:
                        return Boolean.class;
                    case 3:
                        return Boolean.class;
                    default:
                        return null;
                }
            }

        };

        for (DTOTipoImpuesto dtoTipoImpuesto : listDtoTipoImpuesto) {
            Vector<Object> vect = new Vector<>();
            vect.add(dtoTipoImpuesto.getCodigoDTOTipoImpuesto());
            vect.add(dtoTipoImpuesto.getNombreDTOTipoImpuesto());
            vect.add(dtoTipoImpuesto.isEsMontoEditableDTOTipoImpuesto());

            if (dtoTipoImpuesto.getFechaHoraInhabilitacionDTOTipoImpuesto() != null) {
                vect.add(false);
            } else {
                vect.add(true);
            }
            dtm.addRow(vect);
        }

        DefaultTableCellRenderer r = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                setHorizontalAlignment(JLabel.CENTER);
                return this;
            }
        };
        tabla_tipo_impuesto.setModel(dtm);
        tabla_tipo_impuesto.getColumnModel().getColumn(0).setCellRenderer(r);
        tabla_tipo_impuesto.getColumnModel().getColumn(1).setCellRenderer(r);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_filtrar;
    private javax.swing.JButton button_modificar;
    private javax.swing.JButton button_nuevo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_tipo_impuesto;
    private javax.swing.JTextField textfield_filtro;
    // End of variables declaration//GEN-END:variables
}
