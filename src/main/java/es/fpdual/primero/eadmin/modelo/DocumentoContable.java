package es.fpdual.primero.eadmin.modelo;

import java.time.*;

import org.apache.log4j.*;

import lombok.*;

@Data
@EqualsAndHashCode(callSuper = false)
public class DocumentoContable extends Documento {
	private final String numeroOperacionContable;
	private static final Logger logger = LogManager.getLogger(DocumentoContable.class);

	public DocumentoContable(int id, String nombre, Usuario usuario, LocalDate fechaCreacion,
			String numeroOperacionContable) {
		super(id, nombre, usuario, fechaCreacion, TipoDocumento.DOCUMENTO_CONTABLE);
		this.numeroOperacionContable = numeroOperacionContable;
		logger.trace("Documento Contable creado");
	}

}
