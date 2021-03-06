package es.fpdual.primero.eadmin.controlador;

import java.time.*;

import es.fpdual.primero.eadmin.modelo.*;

public class DocumentoRequestMapper {

	private DocumentoRequestMapper() {
		// sonar
	}

	public static Documento toDocumento(DocumentoRequest documentoRequest) {
		return new Documento(0, documentoRequest.getNombre(), construyeUsuario(documentoRequest), null,
				construyeTipoDocumento(documentoRequest.getTipoDocumento()));
	}

	public static Documento toDocumentoCompleto(DocumentoRequest documentoRequest, int id, LocalDate fecha) {
		return new Documento(id, documentoRequest.getNombre(), construyeUsuario(documentoRequest), fecha,
				construyeTipoDocumento(documentoRequest.getTipoDocumento()));
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
		return new Usuario(Integer.parseInt(documentoRequest.getUsuario()), "usuario " + documentoRequest.getUsuario(),
				"cargo" + documentoRequest.getUsuario());
	}
}
