/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.View.Admin;

import exceptions.Excepciones;
import java.awt.Component;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;
import java.util.List;
import java.lang.String;
import java.text.SimpleDateFormat;
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
import sistemapagoimpuestos.Controller.ControladorGestionarEmpresaAdherida;
import sistemapagoimpuestos.Dto.DTOEmpresa;
import sistemapagoimpuestos.Dto.DTOEmpresaExistente;
import sistemapagoimpuestos.Entity.TipoEmpresa;
import sistemapagoimpuestos.Controller.ControladorGestionarEmpresaAdherida;

/**
 *
 * @author Tongas
 */
public class IUGestionarEmpresaAdherida extends javax.swing.JFrame {
   
    ControladorGestionarEmpresaAdherida controlador = new ControladorGestionarEmpresaAdherida();
            
    /**
     * Creates new form IUGestionarEmpresaAdherida
     */
    public IUGestionarEmpresaAdherida() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        obtenerEmpresas();
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Button_Modificar = new javax.swing.JButton();
        Button_Crear = new javax.swing.JButton();
        Button_Filtrar = new javax.swing.JButton();
        TextField_Filtrar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_empresa = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        Button_Actualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestionar Empresa Adherida");

        Button_Modificar.setText("Modificar");
        Button_Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_ModificarActionPerformed(evt);
            }
        });

        Button_Crear.setText("Crear");
        Button_Crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_CrearActionPerformed(evt);
            }
        });

        Button_Filtrar.setText("Filtrar");
        Button_Filtrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_FiltrarActionPerformed(evt);
            }
        });

        tabla_empresa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Cuit", "Nombre", "Direccion", "Tipo de impuesto", "Habilitada"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla_empresa);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("EMPRESAS");

        Button_Actualizar.setText("Actualizar");
        Button_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_ActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Button_Crear, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(Button_Modificar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(TextField_Filtrar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(Button_Filtrar))))
                .addGap(18, 18, 18)
                .addComponent(Button_Actualizar)
                .addGap(22, 22, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(246, 246, 246))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextField_Filtrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button_Filtrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button_Actualizar))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_Modificar)
                    .addComponent(Button_Crear))
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button_ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_ModificarActionPerformed
      
        try {
            // Obtento el código del elemento seleccionado
            int columnCode = 0;
            int rowSelected = tabla_empresa.getSelectedRow();
            String codigo = tabla_empresa.getModel().getValueAt(rowSelected, columnCode).toString();
            Vector vct = new Vector();
            vct.add(tabla_empresa.getValueAt(rowSelected, 0));
            vct.add(tabla_empresa.getValueAt(rowSelected, 1));
            vct.add(tabla_empresa.getValueAt(rowSelected, 2));
            vct.add(tabla_empresa.getValueAt(rowSelected, 3));
            vct.add(tabla_empresa.getValueAt(rowSelected, 4));
            controlador.seleccionarOpcion("Modificar", vct, controlador);
            
            
            
        } catch (ArrayIndexOutOfBoundsException e) {
            //Excepciones.getInstance().camposRequerido(Arrays.asList("Codigo"));
            Excepciones.getInstance().objetoNoSeleccionado();
        }
    }//GEN-LAST:event_Button_ModificarActionPerformed

    private void Button_CrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_CrearActionPerformed
        // TODO add your handling code here:
        controlador.seleccionarOpcion("NuevaEmpresa", evt, controlador);
    }//GEN-LAST:event_Button_CrearActionPerformed

    private void Button_FiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_FiltrarActionPerformed
        // TODO add your handling code here:
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(((DefaultTableModel) tabla_empresa.getModel())); 
            sorter.setRowFilter(RowFilter.regexFilter(TextField_Filtrar.getText()));
            tabla_empresa.setRowSorter(sorter);
    }//GEN-LAST:event_Button_FiltrarActionPerformed

    private void Button_ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_ActualizarActionPerformed
        this.obtenerEmpresas();
    }//GEN-LAST:event_Button_ActualizarActionPerformed

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
        } catch(Exception e){
            System.out.println("error");
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IUGestionarEmpresaAdherida().setVisible(true);
            }
        });
    }
    //Mostrar la pantalla correspondiente a la opcion seleccionada
    
        public void iniciar() {
          controlador.iniciar();
    }
        
        
        public void obtenerEmpresas(){
            
            List<DTOEmpresa> listDtoEmpresa = controlador.consultarEmpresas();
            
            String[] columnas = {"Cuit", "Nombre", "Direccion", "Tipo de Empresa", "Habilitada"};
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
                    case 2:
                        return String.class;
                    case 3:
                        return TipoEmpresa.class;
                    case 4:
                        return String.class;
                    default:
                        return null;
                }
            }

        };
            
            
           for (DTOEmpresa dtoEmpresa : listDtoEmpresa) {
            Vector<Object> vect = new Vector<>();
            vect.add(dtoEmpresa.getCuitEmpresa());
            vect.add(dtoEmpresa.getNombreEmpresa());
            vect.add(dtoEmpresa.getDireccionEmpresa());
            vect.add(dtoEmpresa.getFechaHoraInhabilitacionEmpresa());
               SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
            if (dtoEmpresa.getFechaHoraInhabilitacionEmpresa()!= null) {
                vect.add(sdf.format(dtoEmpresa.getFechaHoraInhabilitacionEmpresa()));
            } else {
                vect.add("");
            }
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
           
       
        tabla_empresa.setModel(dtm);
        tabla_empresa.getColumnModel().getColumn(0).setCellRenderer(r);
        tabla_empresa.getColumnModel().getColumn(1).setCellRenderer(r);
           
        }
        
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Actualizar;
    private javax.swing.JButton Button_Crear;
    private javax.swing.JButton Button_Filtrar;
    private javax.swing.JButton Button_Modificar;
    private javax.swing.JTextField TextField_Filtrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_empresa;
    // End of variables declaration//GEN-END:variables
}