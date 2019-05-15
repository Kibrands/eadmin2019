package es.fpdual.primero.eadmin.modelo;

import java.time.*;

import lombok.*;

@Getter
@EqualsAndHashCode(callSuper = true)
@ToString
public class DocumentoSubvencion extends Documento {
	private final double importeSubvencion;

	public DocumentoSubvencion(int id, String nombre, Usuario usuario, LocalDate fechaCreacion,
			double importeSubvencion) {
		super(id, nombre, usuario, fechaCreacion, TipoDocumento.DOCUMENTO_SUBVENCION);
		this.importeSubvencion = importeSubvencion;
	}

}
