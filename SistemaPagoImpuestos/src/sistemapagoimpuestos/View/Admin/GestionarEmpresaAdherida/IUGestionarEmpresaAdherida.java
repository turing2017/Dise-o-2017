/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.View.Admin.GestionarEmpresaAdherida;
import exceptions.Excepciones;
import java.awt.Component;

import java.util.List;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import sistemapagoimpuestos.Dto.DTOEmpresaTipoImpuesto;
import sistemapagoimpuestos.Controller.ControladorGestionarEmpresaAdherida;
import sistemapagoimpuestos.Entity.Empresa;
import sistemapagoimpuestos.Entity.EmpresaTipoImpuesto;
import sistemapagoimpuestos.Utils.MetodosPantalla;
import sistemapagoimpuestos.View.Admin.GestionarTipoImpuesto.IUGestionarTipoImpuestoItems;

public class IUGestionarEmpresaAdherida extends javax.swing.JFrame {

    ControladorGestionarEmpresaAdherida controlador = new ControladorGestionarEmpresaAdherida();
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

        Button_Filtrar = new javax.swing.JButton();
        Button_Crear = new javax.swing.JButton();
        Button_Modificar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_empresa = new javax.swing.JTable();
        TextField_Filtrar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        Button_Actualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestionar Empresa Adherida");

        Button_Filtrar.setText("Filtrar");
        Button_Filtrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_FiltrarActionPerformed(evt);
            }
        });

        Button_Crear.setText("Crear");
        Button_Crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_CrearActionPerformed(evt);
            }
        });

        Button_Modificar.setText("Modificar");
        Button_Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_ModificarActionPerformed(evt);
            }
        });

        tabla_empresa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Cuit", "Nombre", "Tipo de Impuesto", "Tipo de Empresa", "Frecuencia de Liquidación", "Dirección", "Deshabilitada el dia"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Button_Crear, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(Button_Modificar)
                        .addGap(34, 34, 34)
                        .addComponent(Button_Actualizar)
                        .addGap(42, 42, 42))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(TextField_Filtrar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Button_Filtrar)
                        .addGap(363, 363, 363))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(290, 290, 290)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextField_Filtrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button_Filtrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_Modificar)
                    .addComponent(Button_Crear)
                    .addComponent(Button_Actualizar))
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button_FiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_FiltrarActionPerformed
        // TODO add your handling code here:
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(((DefaultTableModel) tabla_empresa.getModel())); 
            sorter.setRowFilter(RowFilter.regexFilter(TextField_Filtrar.getText()));
            tabla_empresa.setRowSorter(sorter);
    }//GEN-LAST:event_Button_FiltrarActionPerformed

    private void Button_CrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_CrearActionPerformed
        // TODO add your handling code here:
        controlador.crearEmpresa(evt, controlador);
    }//GEN-LAST:event_Button_CrearActionPerformed

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
            vct.add(tabla_empresa.getValueAt(rowSelected, 5));
            vct.add(tabla_empresa.getValueAt(rowSelected, 6));
            controlador.modificarEmpresa(vct, controlador);
            
            
            
        } catch (ArrayIndexOutOfBoundsException e) {
            //Excepciones.getInstance().camposRequerido(Arrays.asList("Codigo"));
            Excepciones.getInstance().objetoNoSeleccionado();
        }
    }//GEN-LAST:event_Button_ModificarActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IUGestionarEmpresaAdherida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IUGestionarEmpresaAdherida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IUGestionarEmpresaAdherida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IUGestionarEmpresaAdherida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IUGestionarEmpresaAdherida().setVisible(true);
            }
        });
    }
        public void iniciar() {
          controlador.iniciar();
    }
        
        
        public void obtenerEmpresas(){
            
            List<DTOEmpresaTipoImpuesto> listDtoEmpresaTipoImpuesto = controlador.consultarEmpresas();
            
            String[] columnas = {"Cuit", "Nombre","Tipo de Impuesto","Tipo de Empresa","Frecuencia de Liquidacion", "Direccion",  "Deshabilitada el dia"};
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
                        return String.class;
                    case 4:
                        return Integer.class;
                    case 5:
                        return String.class;
                    case 6:
                        return String.class;
                    default:
                        return null;
                }
            }

        };
             
           for (DTOEmpresaTipoImpuesto dtoEmpresaTipoImpuesto : listDtoEmpresaTipoImpuesto) {
            Vector<Object> vect = new Vector<>();
            vect.add(dtoEmpresaTipoImpuesto.getEmpresa().getCuitEmpresa());
            vect.add(dtoEmpresaTipoImpuesto.getEmpresa().getNombreEmpresa());
            vect.add(dtoEmpresaTipoImpuesto.getTipoImpuesto().getNombreTipoImpuesto());
            vect.add(dtoEmpresaTipoImpuesto.getTipoEmpresa().getNombreTipoEmpresa());
            vect.add(dtoEmpresaTipoImpuesto.getFrecuenciaLiquidacionDTOEmpresaExistente());
            vect.add(dtoEmpresaTipoImpuesto.getEmpresa().getDireccionEmpresa());
        
               SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
            if (dtoEmpresaTipoImpuesto.getEmpresa().getFechaHoraInhabilitacionEmpresa() != null) {
                vect.add(sdf.format(dtoEmpresaTipoImpuesto.getEmpresa().getFechaHoraInhabilitacionEmpresa()));
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
           
        tabla_empresa.setAutoCreateRowSorter(true);
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