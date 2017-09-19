package sistemapagoimpuestos.View.Admin.GestionarItem;

import exceptions.Excepciones;
import java.awt.Component;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
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
import sistemapagoimpuestos.Controller.ControladorGestionarItem;
import sistemapagoimpuestos.Dto.DTOItem;
import sistemapagoimpuestos.Dto.DTOTipoDatoItem;


/**
 *
 * @author lunamarcos
 */
public class IUGestionarItem extends javax.swing.JFrame {
    
    ControladorGestionarItem controlador = new ControladorGestionarItem();
    public IUGestionarItem() {
        initComponents();
        obtenerItems();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_item = new javax.swing.JTable();
        button_modificar = new javax.swing.JButton();
        button_nuevo = new javax.swing.JButton();
        textfield_filtro = new javax.swing.JTextField();
        button_filtrar = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("ITEMS");

        jScrollPane1.setViewportView(tabla_item);

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
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(button_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(button_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(274, 274, 274))))
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(textfield_filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(button_filtrar)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel1)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textfield_filtro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_filtrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_modificar)
                    .addComponent(button_nuevo))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void button_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_nuevoActionPerformed
        // TODO add your handling code here:
        controlador.seleccionarOpcion("Alta", null);
        this.dispose();
    }//GEN-LAST:event_button_nuevoActionPerformed

    private void button_filtrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_filtrarActionPerformed
        // TODO add your handling code here:
                // TODO add your handling code here:
            TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(((DefaultTableModel) tabla_item.getModel())); 
            sorter.setRowFilter(RowFilter.regexFilter(textfield_filtro.getText()));
            tabla_item.setRowSorter(sorter);
    }//GEN-LAST:event_button_filtrarActionPerformed

    private void button_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_modificarActionPerformed
        // TODO add your handling code here:
        // Le paso al controlador la opción seleccionada.
        try {
            // Obtento el código del elemento seleccionado
            int columnCode = 0;
            int rowSelected = tabla_item.getSelectedRow();
            String codigo = tabla_item.getModel().getValueAt(rowSelected, columnCode).toString();
            
            controlador.seleccionarOpcion("Modificar", codigo);
            this.dispose();
        } catch (ArrayIndexOutOfBoundsException e) {
            //Excepciones.getInstance().camposRequerido(Arrays.asList("Codigo"));
            Excepciones.getInstance().objetoNoSeleccionado();
        }
    }//GEN-LAST:event_button_modificarActionPerformed

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
            java.util.logging.Logger.getLogger(IUGestionarItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IUGestionarItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IUGestionarItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IUGestionarItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IUGestionarItem().setVisible(true);
            }
        });
    }
    
    // Metodo iniciar
    public void iniciar() {
        controlador.iniciar();
    }
    
    // Método para obtener todos los items y llenar en la tabla
    public void obtenerItems(){
        ArrayList<DTOItem> listDtoItem = controlador.obtenerItems();
        
        // Muestro los datos en la tabla
        String[] columnas = {"Codigo", "Nombre", "Requerido", "Estado", "Tipo"};
        
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
                        return Integer.class;
                    case 1:
                        return String.class;
                    case 2:
                        return Boolean.class;
                    case 3:
                        return Boolean.class;
                    case 4:
                        return String.class;
                    default:
                        return null;
                }
            }

        };

        for (DTOItem dtoItem : listDtoItem) {
            Vector<Object> vect = new Vector<>();
            vect.add(dtoItem.getCodigoItem());
            vect.add(dtoItem.getNombreItem());
            vect.add(dtoItem.isRequeridoItem());
            DTOTipoDatoItem dtoTipo = dtoItem.getDtoTipoDatoItem();
            

            if (dtoItem.getFechaHoraInhabilitacionItem() != null) {
                vect.add(false);
            } else {
                vect.add(true);
            }
            vect.add(dtoTipo.getNombreTipoDatoItem());
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
        tabla_item.setModel(dtm);
        tabla_item.getColumnModel().getColumn(0).setCellRenderer(r);
        tabla_item.getColumnModel().getColumn(1).setCellRenderer(r);
    }

    public void setControlador(ControladorGestionarItem controlador) {
        this.controlador = controlador;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_filtrar;
    private javax.swing.JButton button_modificar;
    private javax.swing.JButton button_nuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tabla_item;
    private javax.swing.JTextField textfield_filtro;
    // End of variables declaration//GEN-END:variables
}