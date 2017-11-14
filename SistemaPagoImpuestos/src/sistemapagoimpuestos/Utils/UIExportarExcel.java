/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.NumberFormat;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import sistemapagoimpuestos.Dto.DTOExportar;


/**
 *
 * @author Gabriel
 */
public class UIExportarExcel implements UIExportar {

    @Override
    public void exportar(DTOExportar dto) {
       
        String path = System.getProperty("user.home") + "/Desktop/";
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(3);
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Reporte Sistema Pago de Impuestos");
        sheet = workbook.getSheetAt(0);

        for (int i = 0; i < 20; i++) {
            HSSFRow row = sheet.createRow(i);
            for (int y = 0; y < 10; y++) {
                row.createCell(y);
            }

        }
        sheet.getRow(0).getCell(0).setCellValue("Empresa");
        sheet.getRow(1).getCell(0).setCellValue("Tipo Impuesto");
        sheet.getRow(2).getCell(0).setCellValue("Fecha Desde");
        sheet.getRow(3).getCell(0).setCellValue("Fecha Hasta");
    
        sheet.getRow(0).getCell(1).setCellValue(dto.getEmpresa());
        sheet.getRow(1).getCell(1).setCellValue(dto.getTipoImpuesto());
        sheet.getRow(2).getCell(1).setCellValue(dto.getFechaDesde());
        sheet.getRow(3).getCell(1).setCellValue(dto.getFechaHasta());
   

        sheet.getRow(7).getCell(0).setCellValue("Fecha Operacion");
        sheet.getRow(7).getCell(1).setCellValue("Nro Operacion");
        sheet.getRow(7).getCell(2).setCellValue("Codigo Pago Electronico");
        sheet.getRow(7).getCell(3).setCellValue("Nro Comprobante");
        sheet.getRow(7).getCell(4).setCellValue("Tipo Impuesto");
        sheet.getRow(7).getCell(5).setCellValue("Importe Pagado");
        sheet.getRow(7).getCell(6).setCellValue("Importe Total Pagado");

        for (int i = 0; i < dto.getListDtoOperaciones().size(); i++) {

            sheet.getRow(8 + i).getCell(0).setCellValue(String.valueOf(dto.getListDtoOperaciones().get(i).getFechaOperacion()));
            sheet.getRow(8 + i).getCell(1).setCellValue(String.valueOf(dto.getListDtoOperaciones().get(i).getNumeroOperacion()));
            sheet.getRow(8 + i).getCell(2).setCellValue(String.valueOf(dto.getListDtoOperaciones().get(i).getCodigoPagoElectronico()));
            sheet.getRow(8 + i).getCell(3).setCellValue(String.valueOf(dto.getListDtoOperaciones().get(i).getNroComprobante()));
            sheet.getRow(8 + i).getCell(4).setCellValue(String.valueOf(dto.getListDtoOperaciones().get(i).getTipoImpuesto()));
            sheet.getRow(8 + i).getCell(5).setCellValue(String.valueOf(dto.getListDtoOperaciones().get(i).getImportePagado()));
            if (i == dto.getListDtoOperaciones().size() - 1) {
                sheet.getRow(8 + i +1).getCell(6).setCellValue(String.valueOf(dto.getImporteTotalPagado()));
            }
        }
        try {
            FileOutputStream out
                    = new FileOutputStream(path+"exportOperaciones-xls.xls");
            workbook.write(out);
            out.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(
                null,
                "Exportado correctamente en: " + path,
                "Sistema Pago Impuestos",
                JOptionPane.INFORMATION_MESSAGE);
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
