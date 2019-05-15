package es.fpdual.primero.eadmin.modelo;

import java.time.*;

import org.apache.log4j.*;

import lombok.*;

@EqualsAndHashCode(callSuper = false)
public class DocumentoNomina extends Documento {
	private final String dni;
	private static final Logger logger = LogManager.getLogger(DocumentoNomina.class);

	public DocumentoNomina(int id, String nombre, Usuario usuario, LocalDate fechaCreacion, String dni) {
		super(id, nombre, usuario, fechaCreacion, TipoDocumento.DOCUMENTO_NOMINA);
		this.dni = dni;
		logger.error("Documento Nomina creado");
	}

	public String getDni() {
		return dni;
	}

}
