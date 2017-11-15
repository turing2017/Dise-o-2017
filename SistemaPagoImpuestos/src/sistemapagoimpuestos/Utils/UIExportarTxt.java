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
import sistemapagoimpuestos.Dto.DTOExporteLiquidacion;

/**
 *
 * @author Gabriel
 */
public class UIExportarTxt implements UIExportar {

    @Override
    public void exportarOperaciones(DTOExportar dto) {

        String path = System.getProperty("user.home") + "/Desktop/";

        try {
            File archivo = new File(path + "exportOperaciones-txt.txt");
            FileWriter file = new FileWriter(archivo, true);
            //Escribimos en el archivo con el metodo write 
            file.write("Empresa = " + dto.getEmpresa() + ";\r\n");
            file.write("Tipo Impuesto = " + dto.getTipoImpuesto() + ";\r\n");
            file.write("Fecha Desde = " + dto.getFechaDesde() + ";\r\n");
            file.write("Fecha Hasta = " + dto.getFechaHasta() + ";\r\n");
            for (int i = 0; i < dto.getListDtoOperaciones().size(); i++) {
                file.write("Operacion" + i + "\r\n");
                file.write("Fecha Operacion: " + dto.getListDtoOperaciones().get(i).getFechaOperacion());
                file.write("Nro Operacion: " + dto.getListDtoOperaciones().get(i).getNumeroOperacion()+ "; ");
                file.write("Codigo Pago Electronico: " + dto.getListDtoOperaciones().get(i).getCodigoPagoElectronico() + "; ");
                file.write("Nro Comprobante: " + dto.getListDtoOperaciones().get(i).getNroComprobante() + ";");
                file.write("Tipo Impuesto: " + dto.getListDtoOperaciones().get(i).getTipoImpuesto() + ";");
                file.write("Importe Pagado: " + dto.getListDtoOperaciones().get(i).getImportePagado() + ";");
                if (i == dto.getListDtoOperaciones().size() - 1) {
                    file.write( "\r\n"+ "Importe Pagado Total: " + dto.getImporteTotalPagado());
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

    }

    @Override
    public void exportarLiquidacion(DTOExporteLiquidacion dto) {
        String path = System.getProperty("user.home") + "/Desktop/";
        try {
            File archivo = new File(System.getProperty("user.home") + "/Desktop/export.txt");
            FileWriter file = new FileWriter(archivo, true);
            //Escribimos en el archivo con el metodo write 
            file.write("Empresa = " + dto.getEmpresa() + ";\r\n");
            file.write("Tipo Impuesto = " + dto.getTipoImpuesto() + ";\r\n");
            file.write("Numero Liquidacion = " + dto.getNumeroLiquidacion() + ";\r\n");
            file.write("Fecha Liquidacion = " + dto.getFechaLiquidacion() + ";\r\n");
            file.write("Periodo = " + dto.getPeriodo() + ";\r\n");
            for (int i = 0; i < dto.getListDetallesExporte().size(); i++) {
                file.write("Operacion" + i + "\r\n");
                file.write("Numero Operacion: " + String.valueOf(dto.getListDetallesExporte().get(i).getNumeroOperacion()) + "; ");
                file.write("Fecha Operacion: " + String.valueOf(dto.getListDetallesExporte().get(i).getFechaOperacion()) + "; ");
                file.write("Numero Comprobante: " + String.valueOf(dto.getListDetallesExporte().get(i).getNumeroComprobante()) + "; ");
                file.write("Importe Pagado: " + String.valueOf(dto.getListDetallesExporte().get(i).getImportePagado()) + "; ");
                file.write("Monto de comision correspondiente: " + String.valueOf(dto.getListDetallesExporte().get(i).getMontoComision()) + ";\r\n");
                if (i == dto.getListDetallesExporte().size() - 1) {
                    file.write("Monto de Comision Total: " + dto.getMontoTotalComision() + ";");
                }
            }
            file.close();
        } catch (Exception e) {
            System.out.println("Error al guardar el archivo");

        }
        JOptionPane.showMessageDialog(
                null,
                "Exportado correctamente en: " + path,
                "Sistema Pago Impuestos",
                JOptionPane.INFORMATION_MESSAGE);
    }

}
