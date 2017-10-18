package sistemapagoimpuestos.View.Admin.GestionarTipoImpuesto;

import exceptions.Excepciones;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import sistemapagoimpuestos.Controller.ControladorGestionarEmpresaTipoImpuesto;
import sistemapagoimpuestos.Controller.ControladorGestionarTipoImpuesto;
import sistemapagoimpuestos.Dto.DTOEmpresa;
import sistemapagoimpuestos.Dto.DTOEmpresaTipoImpuesto;
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
        this.cuitEmpresa = cuitEmpresa;
        initComponents();
        obtenerEmpresaTipoImpuesto(cuitEmpresa);
        
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
        jButtonVerItemAsociado = new javax.swing.JButton();
        nombreEmpresa = new javax.swing.JLabel();
        jButton_asociar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonModificarVinculo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        button_modificar.setText("Modificar Tipo de Impuesto");
        button_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_modificarActionPerformed(evt);
            }
        });

        button_nuevo.setText("Crear Tipo de Impuesto");
        button_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_nuevoActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(tabla_tipo_impuesto);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("TIPOS DE IMPUESTOS");

        button_filtrar.setText("Filtrar");
        button_filtrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_filtrarActionPerformed(evt);
            }
        });

        jButtonVerItemAsociado.setText("Ver items Asociados");
        jButtonVerItemAsociado.setEnabled(false);
        jButtonVerItemAsociado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerItemAsociadoActionPerformed(evt);
            }
        });

        jButton_asociar.setText("Vincular Tipo de Impuesto y Tipo de Empresa");
        jButton_asociar.setEnabled(false);
        jButton_asociar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_asociarActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonModificarVinculo.setText("Modificar Vinculo");
        jButtonModificarVinculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarVinculoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(textfield_filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(button_filtrar))
                    .addComponent(nombreEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(227, 227, 227)
                        .addComponent(jLabel1)
                        .addGap(210, 210, 210))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButtonCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(button_nuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(button_modificar, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE))
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton_asociar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonVerItemAsociado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonModificarVinculo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap(24, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_filtrar)
                    .addComponent(textfield_filtro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(nombreEmpresa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonVerItemAsociado)
                    .addComponent(button_modificar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_nuevo)
                    .addComponent(jButton_asociar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonModificarVinculo))
                .addGap(10, 10, 10))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void button_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_nuevoActionPerformed
        controlador.mostrarPantallaAlta(cuitEmpresa);
        this.dispose();
    }//GEN-LAST:event_button_nuevoActionPerformed

    private void button_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_modificarActionPerformed

if(listDtoEmpresaTipoImpuesto.equals(null)){       // Le paso al controlador la opción seleccionada.
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
}else{
 try {
            // Obtento el código del elemento seleccionado
            int columnCode = 0;
            int rowSelected = tabla_tipo_impuesto.getSelectedRow();
            String codigo = tabla_tipo_impuesto.getModel().getValueAt(rowSelected, columnCode).toString();
            controlador.mostrarPantallaModificacionEmpresa(Integer.parseInt(codigo),cuitEmpresa);
        } catch (ArrayIndexOutOfBoundsException e) {
            //Excepciones.getInstance().camposRequerido(Arrays.asList("Codigo"));
            Excepciones.getInstance().objetoNoSeleccionado();
        }
        this.dispose();


}

    }//GEN-LAST:event_button_modificarActionPerformed

    private void button_filtrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_filtrarActionPerformed
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(((DefaultTableModel) tabla_tipo_impuesto.getModel()));
        sorter.setRowFilter(RowFilter.regexFilter(textfield_filtro.getText()));
        tabla_tipo_impuesto.setRowSorter(sorter);
    }//GEN-LAST:event_button_filtrarActionPerformed
    
    public void asociarETI(String cuitEmpresa){
    
        
        
    }
    
    
    
    private void jButtonVerItemAsociadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerItemAsociadoActionPerformed
        try{
            // Obtento el código del elemento seleccionado
            int columnCode = 0;
            int rowSelected = tabla_tipo_impuesto.getSelectedRow();
            String codigoTI = tabla_tipo_impuesto.getModel().getValueAt(rowSelected, columnCode).toString();
            String nombreTE = tabla_tipo_impuesto.getModel().getValueAt(rowSelected, 4).toString();
            controlador.mostrarItems(cuitEmpresa, Integer.parseInt(codigoTI),nombreTE);
    }catch (ArrayIndexOutOfBoundsException e) {
            Excepciones.getInstance().objetoNoSeleccionado();
    }
    }//GEN-LAST:event_jButtonVerItemAsociadoActionPerformed

    private void jButton_asociarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_asociarActionPerformed
        controlador.asociarETI(cuitEmpresa);
        this.dispose();
    }//GEN-LAST:event_jButton_asociarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonModificarVinculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarVinculoActionPerformed
        
        int rowSelected = tabla_tipo_impuesto.getSelectedRow();
        String nombreTI = tabla_tipo_impuesto.getModel().getValueAt(rowSelected, 1).toString();
        boolean montoEditable = (boolean) tabla_tipo_impuesto.getModel().getValueAt(rowSelected, 2);
        boolean estadoETI = (boolean) tabla_tipo_impuesto.getModel().getValueAt(rowSelected, 3);
        String nombreTE = tabla_tipo_impuesto.getModel().getValueAt(rowSelected, 4).toString();
        controlador.modificarETI(cuitEmpresa, nombreTI, nombreTE, estadoETI, montoEditable);
        this.dispose();
    }//GEN-LAST:event_jButtonModificarVinculoActionPerformed


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
    ArrayList<DTOEmpresaTipoImpuesto> listDtoEmpresaTipoImpuesto = null;
    public void obtenerEmpresaTipoImpuesto(String cuitEmpresa) {
        // Muestro pantalla de Consultar
        listDtoEmpresaTipoImpuesto = controlador.obtenerEmpresaTipoImpuesto(cuitEmpresa);
        DTOEmpresa dtoEmpresa = controlador.buscarEmpresa(cuitEmpresa);
        nombreEmpresa.setText(dtoEmpresa.getNombreEmpresa());
        jButton_asociar.setEnabled(true);
        jButtonVerItemAsociado.setEnabled(true);
        String[] columnas = {"Codigo Tipo Impuesto", "Nombre Tipo Impuesto", "Monto Editable", "Estado", "Nombre TipoEmpresa"};
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

        for (DTOEmpresaTipoImpuesto dtoEmpresaTipoImpuesto : listDtoEmpresaTipoImpuesto) {
            Vector<Object> vect = new Vector<>();
            vect.add(dtoEmpresaTipoImpuesto.getTipoImpuesto().getCodigoTipoImpuesto());
            vect.add(dtoEmpresaTipoImpuesto.getTipoImpuesto().getNombreTipoImpuesto());
            vect.add(dtoEmpresaTipoImpuesto.getTipoImpuesto().isEsMontoEditableTipoImpuesto());

            if (dtoEmpresaTipoImpuesto.getTipoImpuesto().getFechaHoraInhabilitacionTipoImpuesto() != null) {
                vect.add(false);
            } else {
                vect.add(true);
            }
            vect.add(dtoEmpresaTipoImpuesto.getTipoEmpresa().getNombreTipoEmpresa());
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

    public ControladorGestionarTipoImpuesto getControlador() {
        return controlador;
    }

    public void setControlador(ControladorGestionarTipoImpuesto controlador) {
        this.controlador = controlador;
    }

    public ControladorGestionarEmpresaTipoImpuesto getControladorETI() {
        return controladorETI;
    }

    public void setControladorETI(ControladorGestionarEmpresaTipoImpuesto controladorETI) {
        this.controladorETI = controladorETI;
    }

    public String getCuitEmpresa() {
        return cuitEmpresa;
    }

    public void setCuitEmpresa(String cuitEmpresa) {
        this.cuitEmpresa = cuitEmpresa;
    }

    public JButton getButton_filtrar() {
        return button_filtrar;
    }

    public void setButton_filtrar(JButton button_filtrar) {
        this.button_filtrar = button_filtrar;
    }

    public JButton getButton_modificar() {
        return button_modificar;
    }

    public void setButton_modificar(JButton button_modificar) {
        this.button_modificar = button_modificar;
    }

    public JButton getButton_nuevo() {
        return button_nuevo;
    }

    public void setButton_nuevo(JButton button_nuevo) {
        this.button_nuevo = button_nuevo;
    }

    public JButton getjButton1() {
        return jButtonVerItemAsociado;
    }

    public void setjButton1(JButton jButton1) {
        this.jButtonVerItemAsociado = jButton1;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JLabel getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(JLabel nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public JTable getTabla_tipo_impuesto() {
        return tabla_tipo_impuesto;
    }

    public void setTabla_tipo_impuesto(JTable tabla_tipo_impuesto) {
        this.tabla_tipo_impuesto = tabla_tipo_impuesto;
    }

    public JTextField getTextfield_filtro() {
        return textfield_filtro;
    }

    public void setTextfield_filtro(JTextField textfield_filtro) {
        this.textfield_filtro = textfield_filtro;
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_filtrar;
    private javax.swing.JButton button_modificar;
    private javax.swing.JButton button_nuevo;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonModificarVinculo;
    private javax.swing.JButton jButtonVerItemAsociado;
    private javax.swing.JButton jButton_asociar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nombreEmpresa;
    private javax.swing.JTable tabla_tipo_impuesto;
    private javax.swing.JTextField textfield_filtro;
    // End of variables declaration//GEN-END:variables
}
