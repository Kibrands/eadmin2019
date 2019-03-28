package es.fpdual.eadmin.eadmin.modelo;

import java.util.Date;

public class DocumentoNomina extends Documento {
	private final String dni;

	public DocumentoNomina(int id, String nombre, Usuario usuario, Date fechaCreacion, String dni) {
		super(id, nombre, usuario, fechaCreacion, TipoDocumento.DOCUMENTO_NOMINA);
		this.dni = dni;
	}

	public String getDni() {
		return dni;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof DocumentoNomina) {
			final DocumentoNomina documentoNomina = (DocumentoNomina) obj;
			return documentoNomina.getId() == this.getId();
		}
		return false;
	}
}
