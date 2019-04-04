package es.fpdual.eadmin.eadmin.modelo;

import java.util.Date;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Documento extends AdministracionElectronicaBase {

	private final TipoDocumento tipoDocumento;
	private static final Logger logger = LogManager.getLogger(Documento.class);

	public Documento(int id, String nombre, Usuario usuario, Date fechaCreacion, TipoDocumento tipoDocumento) {
		this.id = id;
		this.nombre = nombre;
		this.usuario = usuario;
		this.fechaCreacion = fechaCreacion;
		this.tipoDocumento = tipoDocumento;
		// if (tipoDocumento != TipoDocumento.DOCUMENTO_CONTABLE & tipoDocumento !=
		// TipoDocumento.DOCUMENTO_FACTURA
		// & tipoDocumento != TipoDocumento.DOCUMENTO_NOMINA) {
		// logger.debug("**************************************************");
		// logger.debug("Documento almacenado correctamente");
		// logger.debug("Id: " + id);
		// logger.debug("Nombre: " + nombre);
		// logger.debug("Usuario: " + usuario.getNombre());
		// logger.debug("Fecha Creación: " + fechaCreacion);
		// logger.debug("Tipo Documento: " + tipoDocumento);
		// logger.debug("**************************************************");
		// }
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	@Override
	public int hashCode() {
		return this.getId();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Documento) {
			final Documento documento = (Documento) obj;
			return documento.getId() == this.getId();
		}
		return false;
	}

	@Override
	public String toString() {
		return "Documento: " + id + " - Nombre: " + nombre;
	}

}
