package es.fpdual.primero.eadmin.repositorio;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.time.*;

import org.junit.*;

import es.fpdual.primero.eadmin.modelo.*;

public class RepositorioDocumentoEnListaTest {

	private RepositorioDocumentoEnLista repositorioDocumento;
	private Documento documento;

	@Before
	public void inicializarEnCadaTet() {
		this.repositorioDocumento = new RepositorioDocumentoEnLista();
		this.documento = mock(Documento.class);
	}

	@Ignore("mock equals")
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
		Documento documentoModificado = new Documento(20, "Doc2", new Usuario(1, "Julio", "D"), LocalDate.now(),
				TipoDocumento.DOCUMENTO_CONTABLE);
		Documento documento = new Documento(20, "Doc1", new Usuario(1, "Julio", "D"), LocalDate.now(),
				TipoDocumento.DOCUMENTO_CONTABLE);

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
	public void deberiaDevolver1SiLaListaEstaVacia() {
		assertEquals(1, this.repositorioDocumento.getSiguienteId());
	}

	@Test
	public void deberiaDevolverElSiguienteId() {
		when(documento.getId()).thenReturn(5);
		this.repositorioDocumento.altaDocumento(documento);

		assertEquals(6, this.repositorioDocumento.getSiguienteId());
	}
}
