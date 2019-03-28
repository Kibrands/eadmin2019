package es.fpdual.eadmin.eadmin.modelo;

import java.util.Date;

public class DocumentoContable extends Documento {
	private final String numeroOperacionContable;

	public DocumentoContable(int id, String nombre, Usuario usuario, Date fechaCreacion,
			String numeroOperacionContable) {
		super(id, nombre, usuario, fechaCreacion, TipoDocumento.DOCUMENTO_CONTABLE);
		this.numeroOperacionContable = numeroOperacionContable;
	}

	public String getNumeroOperacionContable() {
		return numeroOperacionContable;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof DocumentoContable) {
			final DocumentoContable documentoContable = (DocumentoContable) obj;
			return documentoContable.getId() == this.getId();
		}
		return false;
	}
}
