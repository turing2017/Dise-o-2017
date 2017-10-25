/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Utils;

import java.io.FileOutputStream;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.text.SimpleDateFormat;
import sistemapagoimpuestos.Dto.DTOOperacionActual;

/**
 *
 * @author mviss
 */
public class ExportPdf {

    private static String FILE = System.getProperty("user.home") + "/Desktop/Comprobante_pago.pdf";
    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
            Font.BOLD);
    private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.NORMAL, BaseColor.RED);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
            Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.BOLD);

    public static void exportPdf(DTOOperacionActual dTOOperacionActual) {
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(FILE));
            document.open();
            addMetaDataOperacion(document);
            addTitlePageOperacion(document, dTOOperacionActual);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

     private static void addMetaDataOperacion(Document document) {
        document.addTitle("Comprobante de Pago");
        document.addSubject("Using iText");
        document.addKeywords("Java, PDF, iText");
        document.addAuthor("Turing");
        document.addCreator("Turing");
    }
    
       private static void addTitlePageOperacion(Document document, DTOOperacionActual dTOOperacionActual) throws DocumentException {
        Paragraph preface = new Paragraph();
        // We add one empty line
        addEmptyLine(document,preface, 4);
        // Lets write a big header
        document.add(new Paragraph("Operacion nro " +dTOOperacionActual.getNumeroOperacion(),
				FontFactory.getFont("arial",   // fuente
				22,                            // tamaño
				Font.ITALIC,                   // estilo
				BaseColor.BLACK)));
        addEmptyLine(document,preface, 2);
        document.add(crateTableOperation(document, dTOOperacionActual));
        
       }
       
    private static PdfPTable crateTableOperation(Document document, DTOOperacionActual dTOOperacion){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        PdfPTable table = new PdfPTable(2);
        PdfPCell cell;
        cell = new PdfPCell(new Phrase("Detalle de Operación"));
        cell.setColspan(2);
        table.addCell(cell);
        table.addCell("Nombre de Empresa");
        table.addCell(dTOOperacion.getNombreEmpresa());
        table.addCell("Numero de Operación");
        table.addCell(Integer.toString(dTOOperacion.getNumeroOperacion()));
        table.addCell("Codigo de Pago Electronico");
        table.addCell(dTOOperacion.getCodigoPagoElectronicoOperacion());
        table.addCell("Fecha de Operacion");
        table.addCell(sdf.format(dTOOperacion.getFechaHoraOperacion()));
        table.addCell("Importe Pagado");
        table.addCell(Double.toString(dTOOperacion.getImportePagadoOperacion()));
        table.addCell("Numero de factura");
        table.addCell(Long.toString(dTOOperacion.getNroComprobanteFactura()));
        return table;
    }
    private static void addEmptyLine(Document document, Paragraph paragraph, int number) throws DocumentException {
        for (int i = 0; i < number; i++) {
            document.add(new Paragraph(" "));
        }
    }
}
