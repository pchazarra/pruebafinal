package ufv.dis.parcialfinal.PruebaPC;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class GeneradorPDF {

	public static void pdf(Usuario u) throws FileNotFoundException, DocumentException{
		String filename = "pdfs/hola.pdf";
		
		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream(filename ));
		document.open();
		document.add(new Paragraph("Nombre:" + u.getNombre()));
		document.add(new Paragraph("Apellido:" + u.getApellido()));
		document.add(new Paragraph("Edad:" + u.getEdad()));
		document.add(new Paragraph("Mayoria de edad:" + u.isAdult(u)));
		document.add(new Paragraph("PDF a fecha de:" + new Date()));
		document.close();
	}
}
