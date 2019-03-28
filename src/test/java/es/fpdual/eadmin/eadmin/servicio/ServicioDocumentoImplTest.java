package es.fpdual.eadmin.eadmin.servicio;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioDocumento;

public class ServicioDocumentoImplTest {

	RepositorioDocumento repositorioDocumento;
	ServicioDocumentoImpl servicioDocumentoImpl;

	@Before
	public void inicializarAntesDeCadaTest() {
		this.repositorioDocumento = mock(RepositorioDocumento.class);
		this.servicioDocumentoImpl = mock(ServicioDocumentoImpl.class);
	}

	@Test
	public void deberiaObtenerTodosLosDocumentos() {
		List<Documento> listaDevueltaPorElRepositorio = new ArrayList<>();
		when(repositorioDocumento.obtenerTodosDocumentos()).thenReturn(listaDevueltaPorElRepositorio);

		final List<Documento> resultado = servicioDocumentoImpl.obtenerTodosDocumentos();

		assertEquals(listaDevueltaPorElRepositorio, resultado);
	}

	@Test
	public void deberiaModificarUnDocumento() {
		Documento documento = mock(Documento.class);
		Documento documentoDevueltoPorElRepositorio = mock(Documento.class);
		when(repositorioDocumento.modificarDocumento(documento)).thenReturn(documentoDevueltoPorElRepositorio);

		final Documento resultado = servicioDocumentoImpl.modificarDocumento(documento);

		assertEquals(documentoDevueltoPorElRepositorio, resultado);
	}

	@Test
	public void deberiaEliminarDocumnetoConCodigoFacilitado() {

		this.servicioDocumentoImpl.eliminarDocumento(20);

		verify(this.repositorioDocumento).eliminarDocumento(20);

	}
}
