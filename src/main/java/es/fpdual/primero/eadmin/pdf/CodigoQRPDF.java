package es.fpdual.primero.eadmin.pdf;

import com.itextpdf.io.image.*;
import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.*;
import com.itextpdf.layout.element.*;

import es.fpdual.primero.eadmin.modelo.*;

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
