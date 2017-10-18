/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Utils;
import java.io.FileOutputStream;
import java.text.DecimalFormat;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriel
 */
public class PrinterPDF {



 /*public static void main(String[] args) {

  String pdfFilename = "";
  PrintReport printReport = new PrintReport();
  if (args.length < 1)
  {
   System.err.println("Usage: java "+ printReport.getClass().getName()+
   " PDF_Filename");
   System.exit(1);
  }

  pdfFilename = args[0].trim();
  printReport.createPDF(pdfFilename);

 }
*/
 public void createPDF (String pdfFilename){

  Document doc = new Document();
  PdfWriter docWriter = null;

  DecimalFormat df = new DecimalFormat("0.00");

  try {
   
   //special font sizes
   Font bfBold12 = new Font(FontFamily.TIMES_ROMAN, 12, Font.BOLD, new BaseColor(0, 0, 0)); 
   Font bf12 = new Font(FontFamily.TIMES_ROMAN, 12); 

   //file path
   String path = pdfFilename;
      try {
          docWriter = PdfWriter.getInstance(doc , new FileOutputStream(path));
      } catch (FileNotFoundException ex) {
          Logger.getLogger(PrinterPDF.class.getName()).log(Level.SEVERE, null, ex);
      }
   
   //document header attributes
 //  doc.addAuthor("betterThanZero");
   doc.addCreationDate();
   doc.addProducer();
   doc.addCreator("Sistema Pago Impuestos");
   doc.addTitle("Report with Column Headings");
   doc.setPageSize(PageSize.A4);
  
   //open document
   doc.open();

   //create a paragraph
   Paragraph paragraph = new Paragraph("iText ® is a library that allows you to create and " +
     "manipulate PDF documents. It enables developers looking to enhance web and other " +
     "applications with dynamic PDF document generation and/or manipulation.");
   
   
   //specify column widths
   float[] columnWidths = {1.5f, 2f, 5f, 2f};
   //create PDF table with the given widths
   PdfPTable table = new PdfPTable(columnWidths);
   // set table width a percentage of the page width
   table.setWidthPercentage(90f);

   //insert column headings
   insertCell(table, "Order No", Element.ALIGN_RIGHT, 1, bfBold12);
   insertCell(table, "Account No", Element.ALIGN_LEFT, 1, bfBold12);
   insertCell(table, "Account Name", Element.ALIGN_LEFT, 1, bfBold12);
   insertCell(table, "Order Total", Element.ALIGN_RIGHT, 1, bfBold12);
   table.setHeaderRows(1);

   //insert an empty row
   insertCell(table, "", Element.ALIGN_LEFT, 4, bfBold12);
   //create section heading by cell merging
   insertCell(table, "New York Orders ...", Element.ALIGN_LEFT, 4, bfBold12);
   double orderTotal, total = 0;
   
   //just some random data to fill 
   for(int x=1; x<5; x++){
    
    insertCell(table, "10010" + x, Element.ALIGN_RIGHT, 1, bf12);
    insertCell(table, "ABC00" + x, Element.ALIGN_LEFT, 1, bf12);
    insertCell(table, "This is Customer Number ABC00" + x, Element.ALIGN_LEFT, 1, bf12);
    
    orderTotal = Double.valueOf(df.format(Math.random() * 1000));
    total = total + orderTotal;
    insertCell(table, df.format(orderTotal), Element.ALIGN_RIGHT, 1, bf12);
    
   }
   //merge the cells to create a footer for that section
   insertCell(table, "New York Total...", Element.ALIGN_RIGHT, 3, bfBold12);
   insertCell(table, df.format(total), Element.ALIGN_RIGHT, 1, bfBold12);
   
   //repeat the same as above to display another location
   insertCell(table, "", Element.ALIGN_LEFT, 4, bfBold12);
   insertCell(table, "California Orders ...", Element.ALIGN_LEFT, 4, bfBold12);
   orderTotal = 0;
   
   for(int x=1; x<7; x++){
    
    insertCell(table, "20020" + x, Element.ALIGN_RIGHT, 1, bf12);
    insertCell(table, "XYZ00" + x, Element.ALIGN_LEFT, 1, bf12);
    insertCell(table, "This is Customer Number XYZ00" + x, Element.ALIGN_LEFT, 1, bf12);
    
    orderTotal = Double.valueOf(df.format(Math.random() * 1000));
    total = total + orderTotal;
    insertCell(table, df.format(orderTotal), Element.ALIGN_RIGHT, 1, bf12);
    
   }
   insertCell(table, "California Total...", Element.ALIGN_RIGHT, 3, bfBold12);
   insertCell(table, df.format(total), Element.ALIGN_RIGHT, 1, bfBold12);
   
   //add the PDF table to the paragraph 
   paragraph.add(table);
   // add the paragraph to the document
   doc.add(paragraph);

  }
  catch (DocumentException dex)
  {
   dex.printStackTrace();
  }
  finally
  {
   if (doc != null){
    //close the document
    doc.close();
   }
   if (docWriter != null){
    //close the writer
    docWriter.close();
   }
  }
 }
 
 private void insertCell(PdfPTable table, String text, int align, int colspan, Font font){
  
  //create a new cell with the specified Text and Font
  PdfPCell cell = new PdfPCell(new Phrase(text.trim(), font));
  //set the cell alignment
  cell.setHorizontalAlignment(align);
  //set the cell column span in case you want to merge two or more cells
  cell.setColspan(colspan);
  //in case there is no text and you wan to create an empty row
  if(text.trim().equalsIgnoreCase("")){
   cell.setMinimumHeight(10f);
  }
  //add the call to the table
  table.addCell(cell);
  
 }

}

