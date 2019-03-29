package es.fpdual.eadmin.eadmin.controlador;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.TipoDocumento;
import es.fpdual.eadmin.eadmin.modelo.Usuario;

public class DocumentoRequestMapper {

	private DocumentoRequestMapper() {
		// sonar
	}

	public static Documento toDocumento(DocumentoRequest documentoRequest) {
		return new Documento(documentoRequest.getId(), documentoRequest.getNombre(), construyeUsuario(documentoRequest),
				documentoRequest.getFechaCreacion(), construyeTipoDocumento(documentoRequest.getTipoDocumento()));
	}

	private static TipoDocumento construyeTipoDocumento(String tipoDocumento) {
		TipoDocumento resultado;
		switch (tipoDocumento.toUpperCase()) {
		case "DOCUMENTO_CONTABLE":
			resultado = TipoDocumento.DOCUMENTO_CONTABLE;
			break;
		case "DOCUMENTO_FACTURA":
			resultado = TipoDocumento.DOCUMENTO_FACTURA;
			break;
		case "DOCUMENTO_NOMINA":
			resultado = TipoDocumento.DOCUMENTO_NOMINA;
			break;
		case "DOCUMENTO_PADRON":
			resultado = TipoDocumento.DOCUMENTO_PADRON;
			break;
		case "DOCUMENTO_SUBVENCION":
			resultado = TipoDocumento.DOCUMENTO_SUBVENCION;
			break;
		default:
			resultado = TipoDocumento.DOCUMENTO_CONTABLE;
		}
		return resultado;
	}

	private static Usuario construyeUsuario(DocumentoRequest documentoRequest) {
		return new Usuario(documentoRequest.getId(), "usuario " + documentoRequest.getId(),
				"cargo" + documentoRequest.getId());
	}
}
