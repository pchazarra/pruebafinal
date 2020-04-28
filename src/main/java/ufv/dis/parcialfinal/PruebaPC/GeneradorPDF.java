package ufv.dis.parcialfinal.PruebaPC;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class GeneradorPDF {

	public void pdf() throws FileNotFoundException, DocumentException{
		String filename = "/pdfs/hola.pdf";
		
		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream(filename ));
		document.open();
		document.add(new Paragraph("Hello World!"));
		document.close();
	}
}
