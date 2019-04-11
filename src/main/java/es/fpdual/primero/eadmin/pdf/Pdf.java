package es.fpdual.primero.eadmin.pdf;

import java.io.*;

import org.apache.log4j.*;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import es.fpdual.primero.eadmin.modelo.*;

public class Pdf {

	private static final Logger logger = LogManager.getLogger(Pdf.class);

	public static void exportarDocumetoPDF(Documento documento) {
		try {

			Document document = new Document();
			PdfWriter.getInstance(document,
					new FileOutputStream(documento.getNombre() + "-" + documento.getTipoDocumento() + ".pdf"));

			document.open();
			Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
			Chunk chunk = new Chunk(documento.getNombre() + " - " + documento.getTipoDocumento(), font);

			document.add(chunk);
			document.close();
		} catch (FileNotFoundException e) {
			logger.error(e);
		} catch (DocumentException e) {
			logger.error(e);
		}
	}

	public static void convertirLogPDF() {
		try {
			String cadena;
			FileReader log = new FileReader("salida.log");
			BufferedReader br = new BufferedReader(log);
			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream("log.pdf"));

			document.open();
			Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
			Chunk chunk = new Chunk("Log EadminApplication", font);
			Paragraph parrafo = new Paragraph();
			try {
				while ((cadena = br.readLine()) != null) {
					parrafo.add(cadena + "\n");
				}
			} catch (IOException e) {
				logger.error(e);
			}
			document.add(chunk);
			document.add(parrafo);
			document.close();
		} catch (FileNotFoundException e) {
			logger.error(e);
		} catch (DocumentException e) {
			logger.error(e);
		}
	}

}
