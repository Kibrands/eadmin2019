package es.fpdual.primero.eadmin.modelo;

import java.time.*;

import lombok.*;

@EqualsAndHashCode(callSuper = false)
public class DocumentoPadron extends Documento {
	private final String localidad;

	public DocumentoPadron(int id, String nombre, Usuario usuario, LocalDate fechaCreacion, String localidad) {
		super(id, nombre, usuario, fechaCreacion, TipoDocumento.DOCUMENTO_PADRON);
		this.localidad = localidad;
	}

	public String getLocalidad() {
		return localidad;
	}

}
