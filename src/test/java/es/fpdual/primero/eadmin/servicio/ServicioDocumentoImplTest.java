package es.fpdual.primero.eadmin.servicio;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.*;

import org.junit.*;

import es.fpdual.primero.eadmin.modelo.*;
import es.fpdual.primero.eadmin.repositorio.*;

public class ServicioDocumentoImplTest {

	RepositorioDocumento repositorioDocumento;
	ServicioDocumentoImpl servicioDocumento;
	Documento documento;

	@Before
	public void InicializarAntesDeCadaTest() {
		this.repositorioDocumento = mock(RepositorioDocumento.class);
		this.documento = mock(Documento.class);
		this.servicioDocumento = new ServicioDocumentoImpl(repositorioDocumento);
	}

	@Test
	public void deberiaObtenerTodosLosDocumentos() {

		RepositorioDocumento repositorioDocumento = mock(RepositorioDocumento.class);
		final ServicioDocumentoImpl servicioDocumentoImpl = new ServicioDocumentoImpl(repositorioDocumento);
		final List<Documento> resultado = servicioDocumentoImpl.obtenerTodosDocumentos();

		List<Documento> listaDevueltaPorElRepositorio = new ArrayList<>();

		when(repositorioDocumento.obtenerTodosDocumentos()).thenReturn(listaDevueltaPorElRepositorio);

		assertEquals(listaDevueltaPorElRepositorio, resultado);

	}

	@Ignore("mock equals")
	public void deberiaModificarElDocumento() {
		Documento documento = mock(Documento.class);

		RepositorioDocumento repositorioDocumento = mock(RepositorioDocumento.class);

		repositorioDocumento.modificarDocumento(documento);

		verify(this.repositorioDocumento).modificarDocumento(documento);

	}

	@Test
	public void deberiaEliminarDocumentoConCodigoFacilitado() {

		this.servicioDocumento.eliminarDocumento(20);

		verify(this.repositorioDocumento).eliminarDocumento(20);

	}

	@Test
	public void deberiaDarAltaDocumento() {

		when(this.repositorioDocumento.getSiguienteId()).thenReturn(22);

		@SuppressWarnings("unused")
		final Documento resultado = this.servicioDocumento.altaDocumento(documento);

	}

}
