package es.fpdual.eadmin.eadmin.modelo;

import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;

public class DocumentoContable extends Documento {
	private final String numeroOperacionContable;
	private static final Logger logger = LogManager.getLogger(DocumentoContable.class);

	public DocumentoContable(int id, String nombre, Usuario usuario, Date fechaCreacion,
			String numeroOperacionContable) {
		super(id, nombre, usuario, fechaCreacion, TipoDocumento.DOCUMENTO_CONTABLE);
		this.numeroOperacionContable = numeroOperacionContable;
		logger.debug("Documento Contable creado");
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
