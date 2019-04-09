package es.fpdual.eadmin.eadmin.repositorio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import es.fpdual.eadmin.eadmin.EadminApplication;
import es.fpdual.eadmin.eadmin.codigoqr.CodigoQR;
import es.fpdual.eadmin.eadmin.excel.Excel;
import es.fpdual.eadmin.eadmin.modelo.AdministracionElectronicaException;
import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.pdf.CodigoQRPDF;
import es.fpdual.eadmin.eadmin.pdf.Pdf;

@Repository
public class RepositorioDocumentoEnLista implements RepositorioDocumento {

	private final List<Documento> documentos = new ArrayList<>();
	private static final Logger logger = LogManager.getLogger(EadminApplication.class);
	private CodigoQR codigoQR = new CodigoQR();

	@Override
	public void altaDocumento(Documento documento) {

		if (documentos.contains(documento)) {
			throw new AdministracionElectronicaException("El documento ya existe");
		}
		documentos.add(documento);

		try {
			String nombreDocumento = documento.getNombre() + "-" + documento.getTipoDocumento() + ".txt";
			String ruta = "documentos/" + nombreDocumento;
			File dir = new File(ruta);
			if (dir.exists()) {
				logger.error("Fichero ya existente");
			} else {
				logger.debug("Fichero " + nombreDocumento + " no existe, creando fichero...");
				FileWriter writer = new FileWriter(ruta, true);
				PrintWriter pw = new PrintWriter(writer);

				pw.println("Id: " + documento.getId());
				pw.println("Nombre: " + documento.getNombre());
				pw.println("Fecha Creación: " + documento.getFechaCreacion());
				pw.println("Tipo Documento: " + documento.getTipoDocumento());
				pw.println("Usuario: " + documento.getUsuario().getNombre());

				pw.close();

				logger.debug("**************************************************");
				logger.debug("Documento almacenado correctamente");
				logger.debug("Id: " + documento.getId());
				logger.debug("Nombre: " + documento.getNombre());
				logger.debug("Usuario: " + documento.getUsuario().getNombre());
				logger.debug("Fecha Creación: " + documento.getFechaCreacion());
				logger.debug("Tipo Documento: " + documento.getTipoDocumento());
				logger.debug("**************************************************");

				codigoQR.crearCodigoQR(documento);
				CodigoQRPDF.exportarQRAPdf(documento);
				Pdf.exportarDocumetoPDF(documento);
				Pdf.convertirLogPDF();

			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void modificarDocumento(Documento documento) {

		if (!documentos.contains(documento)) {
			throw new AdministracionElectronicaException("El documento no existe");
		}

		documentos.set(documentos.indexOf(documento), documento);

		Pdf.convertirLogPDF();

	}

	@Override
	public void eliminarDocumento(int id) {

		final Documento documentoAEliminar = new Documento(id, null, null, null, null);
		final int indice = documentos.indexOf(documentoAEliminar);
		if (indice >= 0) {
			documentos.remove(indice);
			logger.info("Documento con id " + id + " eliminado correctamente");
			Pdf.convertirLogPDF();
		}
	}

	@Override
	public List<Documento> obtenerTodosDocumentos() {
		final String nombre = "ListaDocumentos.txt";
		try {
			FileWriter writer = new FileWriter(nombre);
			PrintWriter pw = new PrintWriter(writer);
			for (Documento documento : this.documentos) {
				pw.println("------------------------------------");
				pw.println("ID: " + documento.getId());
				pw.println("Nombre: " + documento.getNombre());
				pw.println("Fecha Creación: " + documento.getFechaCreacion());
				pw.println("Usuario: " + documento.getUsuario().getNombre());
				pw.println("Tipo Documento: " + documento.getTipoDocumento());
				pw.println("------------------------------------");
			}
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Excel.exportarDocumentos(this.documentos.stream().collect(Collectors.toList()));
		return this.documentos.stream().collect(Collectors.toList());
	}

	@Override
	public int getSiguienteId() {
		if (documentos.isEmpty()) {
			return 1;
		}
		return documentos.get(documentos.size() - 1).getId() + 1;
	}

	@Override
	public Documento obtenerDocumentoPorId(int codigoDocumento) {
		return documentos.stream().filter(d -> d.getId() == codigoDocumento).findFirst().orElse(null);
	}

}
