package es.fpdual.primero.eadmin.controlador;

public class DocumentoRequest {
	private String tipoDocumento;
	private String nombre;
	private String usuario;

	public DocumentoRequest(String nombre, String usuario, String tipoDocumento) {
		this.nombre = nombre;
		this.usuario = usuario;
		this.tipoDocumento = tipoDocumento;
	}

	public DocumentoRequest() {

	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public String getNombre() {
		return nombre;
	}

	public String getUsuario() {
		return usuario;
	}

	@Override
	public String toString() {
		return "Documento: " + nombre;
	}

}
