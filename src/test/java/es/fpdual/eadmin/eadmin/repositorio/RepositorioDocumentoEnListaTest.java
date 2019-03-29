package es.fpdual.eadmin.eadmin.repositorio;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import es.fpdual.eadmin.eadmin.modelo.AdministracionElectronicaException;
import es.fpdual.eadmin.eadmin.modelo.Documento;

public class RepositorioDocumentoEnListaTest {

	private RepositorioDocumentoEnLista repositorioDocumento;
	private Documento documento;

	@Before
	public void inicializarEnCadaTet() {
		this.repositorioDocumento = new RepositorioDocumentoEnLista();
		this.documento = mock(Documento.class);
	}

	@Test
	public void deberiaAlmacenarDocumento() {
		when(documento.getNombre()).thenReturn("documento_1");
		when(documento.getId()).thenReturn(5);

		this.repositorioDocumento.altaDocumento(documento);

		assertTrue(this.repositorioDocumento.obtenerTodosDocumentos().contains(documento));
	}

	@Test(expected = AdministracionElectronicaException.class)
	public void deberiaLanzarExcepcionAlAlmacenarDocumentoYaExistente() {
		when(documento.getNombre()).thenReturn("documento_1");
		when(documento.getId()).thenReturn(5);

		this.repositorioDocumento.altaDocumento(documento);
		this.repositorioDocumento.altaDocumento(documento);
	}

	@Test
	public void deberiaModificarUnDocumento() {
		Documento documentoModificado = new Documento(20, "Doc2", null, null, null);
		Documento documento = new Documento(20, "Doc1", null, null, null);

		this.repositorioDocumento.altaDocumento(documento);
		this.repositorioDocumento.modificarDocumento(documentoModificado);

		assertEquals("Doc2", repositorioDocumento.obtenerTodosDocumentos().get(0).getNombre());
	}

	@Test(expected = AdministracionElectronicaException.class)
	public void deberiaLanzarExcepcionAlModificarDolcumentoNoExistente() {
		this.repositorioDocumento.modificarDocumento(documento);
	}

	@Test
	public void deberiaEliminarUnDocumento() {
		when(documento.getId()).thenReturn(5);

		this.repositorioDocumento.altaDocumento(documento);
		this.repositorioDocumento.eliminarDocumento(documento.getId());

		assertFalse(this.repositorioDocumento.obtenerTodosDocumentos().contains(documento));
	}

	@Test
	public void deberiaNoHacerNadaSiElDocumentoAEliminarNoExiste() {
		this.repositorioDocumento.eliminarDocumento(20);
	}

	@Test
	public void deberiaDevolverSiguienteIdConLaListaVacia() {
		assertEquals(1, this.repositorioDocumento.getSiguienteId());
	}

	@Test
	public void deberiaDevolverSiguienteId() {
		when(documento.getId()).thenReturn(5);
		this.repositorioDocumento.altaDocumento(documento);

		assertEquals(6, this.repositorioDocumento.getSiguienteId());
	}
}
