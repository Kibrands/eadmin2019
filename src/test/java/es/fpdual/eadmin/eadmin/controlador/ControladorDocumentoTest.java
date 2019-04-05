package es.fpdual.eadmin.eadmin.controlador;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.*;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.servicio.ServicioDocumento;

public class ControladorDocumentoTest {
	private ControladorDocumento controladorDocumento;
	private ServicioDocumento servicioDocumento;

	@Before
	public void inicializarEnCadaTest() {
		this.servicioDocumento = mock(ServicioDocumento.class);
		this.controladorDocumento = new ControladorDocumento(servicioDocumento);
	}

	@Test
	public void deberiaAlmacenarDocumento() {
		DocumentoRequest documentoRequest = mock(DocumentoRequest.class);
		Documento documentoInsertado = mock(Documento.class);

		when(this.servicioDocumento.altaDocumento(any())).thenReturn(documentoInsertado);
		when(documentoRequest.getUsuario()).thenReturn("20");
		when(documentoRequest.getTipoDocumento()).thenReturn("DOCUMENTO_CONTABLE");

		final Documento resultado = this.controladorDocumento.altaDocumento(documentoRequest);

		assertSame(documentoInsertado, resultado);
	}

	@Test
	public void deberiaObtenerDocumentoPorId() {
		DocumentoRequest documentoRequest = mock(DocumentoRequest.class);
		when(documentoRequest.getUsuario()).thenReturn("20");
		when(documentoRequest.getTipoDocumento()).thenReturn("DOCUMENTO_CONTABLE");
		this.controladorDocumento.altaDocumento(documentoRequest);

		final Documento resultado = this.controladorDocumento.obtenerDocumentoPorId(1);

		assertSame(resultado, documentoRequest);
	}
}
