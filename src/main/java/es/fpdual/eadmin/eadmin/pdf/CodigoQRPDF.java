package es.fpdual.eadmin.eadmin.pdf;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;

import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;

import es.fpdual.eadmin.eadmin.modelo.Documento;

public class CodigoQRPDF {
	public static void exportarQRAPdf(Documento documento) throws Exception {

		// Creating a PdfWriter
		String dest = documento.getNombre() + ".pdf";
		PdfWriter writer = new PdfWriter(dest);

		// Creating a PdfDocument
		PdfDocument pdf = new PdfDocument(writer);

		// Creating a Document
		Document document = new Document(pdf);

		// Creating an ImageData object
		String imFile = documento.getNombre() + ".png";
		ImageData data = ImageDataFactory.create(imFile);

		// Creating an Image object
		Image image = new Image(data);
		Paragraph parrafo = new Paragraph(documento.getNombre() + " - " + documento.getTipoDocumento());
		// Adding image to the document
		document.add(parrafo);
		document.add(image);
		// Closing the document
		document.close();
	}
}
