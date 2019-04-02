package es.fpdual.eadmin.eadmin.controlador;

import java.util.Date;

public class DocumentoRequest {
	private String tipoDocumento;
	private int id;
	private String nombre;
	private String usuario;
	private Date fechaCreacion;

	public DocumentoRequest(String nombre, String usuario, String tipoDocumento) {
		this.nombre = nombre;
		this.usuario = usuario;
		this.tipoDocumento = tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
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
