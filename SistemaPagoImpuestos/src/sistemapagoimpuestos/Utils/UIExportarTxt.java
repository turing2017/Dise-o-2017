/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Utils;

import java.io.File;
import java.io.FileWriter;
import javax.swing.JOptionPane;
import sistemapagoimpuestos.Dto.DTOExportar;
/**
 *
 * @author Gabriel
 */
public class UIExportarTxt implements UIExportar{

    @Override
    public void exportar(DTOExportar dto) {
      
        String path = System.getProperty("user.home") + "/Desktop/";

        try {
           File archivo = new File(path+"exportOperaciones-txt.txt");
            FileWriter file = new FileWriter(archivo, true);
            //Escribimos en el archivo con el metodo write 
            file.write("Empresa = " + dto.getEmpresa() + ";\r\n");
            file.write("Tipo Impuesto = " + dto.getTipoImpuesto() + ";\r\n");
            file.write("Fecha Desde = " + dto.getFechaDesde() + ";\r\n");
            file.write("Fecha Hasta = " + dto.getFechaHasta() + ";\r\n");
            for (int i = 0; i < dto.getListDtoOperaciones().size(); i++) {
                file.write("Operacion" + i + "\r\n");
                file.write("Fecha Operacion: " + dto.getListDtoOperaciones().get(i).getFechaOperacion());
                file.write("Nro Operacion: " +  dto.getListDtoOperaciones().get(i).getNumeroOperacion() + "; ");
                file.write("Codigo Pago Electronico: " +  dto.getListDtoOperaciones().get(i).getCodigoPagoElectronico() + "; ");
                file.write("Nro Comprobante: " + dto.getListDtoOperaciones().get(i).getNroComprobante() + ";");
                file.write("Tipo Impuesto: " + dto.getListDtoOperaciones().get(i).getTipoImpuesto() + ";");
                file.write("Importe Pagado: " +  dto.getListDtoOperaciones().get(i).getImportePagado() + ";");
                if (i == dto.getListDtoOperaciones().size() - 1) {
                    file.write("Importe Pagado Total: " + dto.getImporteTotalPagado() + ";\r\n");
                }
            }
            file.close();
        } catch (Exception e) {
            System.out.println("Error al guardar el archivo txt");
        }
                JOptionPane.showMessageDialog(
                null,
                "Exportado correctamente en: " + path,
                "Sistema Pago Impuestos",
                JOptionPane.INFORMATION_MESSAGE);
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
