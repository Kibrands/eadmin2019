package es.fpdual.eadmin.eadmin.controlador;

import java.util.Date;

public class DocumentoRequest {
	private final String tipoDocumento;
	private final int id;
	private final String nombre;
	private final String usuario;
	private final Date fechaCreacion;

	public DocumentoRequest(int id, String nombre, String usuario, Date fechaCreacion, String tipoDocumento) {
		this.id = id;
		this.nombre = nombre;
		this.usuario = usuario;
		this.fechaCreacion = fechaCreacion;
		this.tipoDocumento = tipoDocumento;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getUsuario() {
		return usuario;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	@Override
	public String toString() {
		return "Documento: " + id + " - Nombre: " + nombre;
	}

}
