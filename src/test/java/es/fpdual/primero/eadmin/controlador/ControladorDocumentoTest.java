package es.fpdual.primero.eadmin.controlador;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.*;

import es.fpdual.primero.eadmin.modelo.*;
import es.fpdual.primero.eadmin.servicio.*;

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

	@Ignore("mock equals")
	public void deberiaObtenerDocumentoPorId() {
		DocumentoRequest documentoRequest = mock(DocumentoRequest.class);
		when(documentoRequest.getUsuario()).thenReturn("20");
		when(documentoRequest.getTipoDocumento()).thenReturn("DOCUMENTO_CONTABLE");
		this.controladorDocumento.altaDocumento(documentoRequest);

		final Documento resultado = this.controladorDocumento.obtenerDocumentoPorId(1);

		assertSame(resultado, documentoRequest);
	}
}
