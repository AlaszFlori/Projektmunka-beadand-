package com.example.phonebook;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.collections.ObservableList;

import java.io.FileOutputStream;

public class PDFGen {

    public void pdfGeneration(String fileName, ObservableList<Person> text){
        Document pdf = new Document();
        try{
            PdfWriter.getInstance(pdf, new FileOutputStream(fileName + ".pdf"));
            pdf.open();

            float[] columnWidths = {1, 3, 3, 4};
            PdfPTable table = new PdfPTable(columnWidths);
            table.setWidthPercentage(100);
            PdfPCell cell = new PdfPCell(new Phrase("Contacts"));
            cell.setBackgroundColor(GrayColor.GRAYWHITE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setColspan(4);
            table.addCell(cell);

            table.getDefaultCell().setBackgroundColor(new GrayColor(0.75f));
            table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell("ID");
            table.addCell("Name");
            table.addCell("Phone");
            table.addCell("Email");
            table.setHeaderRows(1);

            table.getDefaultCell().setBackgroundColor(GrayColor.GRAYWHITE);
            table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);

            for(int i = 0; i < text.size(); i++){
                int act = i + 1;
                table.addCell("" + act);
                table.addCell(text.get(i).getName());
                table.addCell(text.get(i).getPhone());
                table.addCell(text.get(i).getEmail());
            }

            pdf.add(table);
        }catch(Exception e){
            e.printStackTrace();
        }
        pdf.close();
    }
}
