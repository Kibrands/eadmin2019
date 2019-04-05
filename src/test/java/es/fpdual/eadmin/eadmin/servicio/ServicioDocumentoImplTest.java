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
import es.fpdual.eadmin.eadmin.servicio.ServicioDocumentoImpl;

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

	@Test
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
