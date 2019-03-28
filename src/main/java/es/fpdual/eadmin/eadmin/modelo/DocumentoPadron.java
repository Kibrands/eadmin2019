package es.fpdual.eadmin.eadmin.modelo;

import java.util.Date;

public class DocumentoPadron extends Documento{
	private final String localidad;

	public DocumentoPadron(int id, String nombre, Usuario usuario, Date fechaCreacion, String localidad) {
		super(id, nombre, usuario, fechaCreacion, TipoDocumento.DOCUMENTO_PADRON);
		this.localidad = localidad;
	}

	public String getLocalidad() {
		return localidad;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof DocumentoPadron) {
			final DocumentoPadron documentoPadron = (DocumentoPadron) obj;
			return documentoPadron.getId() == this.getId();
		}
		return false;
	}
}
