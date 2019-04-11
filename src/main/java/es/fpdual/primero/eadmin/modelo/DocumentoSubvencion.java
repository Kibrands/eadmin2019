package es.fpdual.primero.eadmin.modelo;

import java.time.*;

public class DocumentoSubvencion extends Documento {
	private final double importeSubvencion;

	public DocumentoSubvencion(int id, String nombre, Usuario usuario, LocalDate fechaCreacion,
			double importeSubvencion) {
		super(id, nombre, usuario, fechaCreacion, TipoDocumento.DOCUMENTO_SUBVENCION);
		this.importeSubvencion = importeSubvencion;
	}

	public double getImporteSubvencion() {
		return importeSubvencion;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof DocumentoSubvencion) {
			final DocumentoSubvencion documentoSubvencion = (DocumentoSubvencion) obj;
			return documentoSubvencion.getId() == this.getId();
		}
		return false;
	}
}
