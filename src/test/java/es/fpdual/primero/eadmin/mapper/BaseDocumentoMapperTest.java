package es.fpdual.primero.eadmin.mapper;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.time.*;

import org.junit.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.transaction.annotation.*;

import es.fpdual.primero.eadmin.modelo.*;

@Transactional("eadminTransactionManager")
public abstract class BaseDocumentoMapperTest {

	LocalDate fechaActual;
	Usuario usuario;
	Documento documento;

	@Autowired
	DocumentoMapper mapper;

	@Before
	public void inicializarEnCadaTest() {
		// DECLARACION
		fechaActual = LocalDate.now();
		usuario = mock(Usuario.class);
		documento = new Documento(1, "Prueba", usuario, fechaActual, TipoDocumento.DOCUMENTO_PADRON);
	}

	@Test
	public void deberiaInsertarUnDocumento() throws Exception {
		// DECLARACION
		when(usuario.getId()).thenReturn(1);
		// PRUEBA
		Integer resultado = this.mapper.insertarDocumento(documento);
		// COMPROBACION
		assertThat(resultado, is(1));
	}

	@Test
	public void deberiaRescatarElDocumento() throws Exception {
		// ENTRENAMIENTO
		when(usuario.getId()).thenReturn(1);
		this.mapper.insertarDocumento(documento);
		// PRUEBA
		Documento resultado = this.mapper.getDocumento(1);
		// COMPROBACION
		assertThat(resultado, is(documento));
	}

	@Test
	public void deberiaModificarElDocumento() throws Exception {
		// DECLARACIÓN
		Documento documentoPrueba = mock(Documento.class);
		// ENTRENAMIENTO
		when(usuario.getId()).thenReturn(1);
		when(documentoPrueba.getId()).thenReturn(1);
		when(documentoPrueba.getNombre()).thenReturn("DocumentoPrueba");
		when(documentoPrueba.getUsuario()).thenReturn(usuario);
		when(documentoPrueba.getFechaCreacion()).thenReturn(LocalDate.now());
		when(documentoPrueba.getTipoDocumento()).thenReturn(TipoDocumento.DOCUMENTO_PADRON);
		this.mapper.insertarDocumento(documentoPrueba);
		when(documentoPrueba.getNombre()).thenReturn("nombre actualizado");
		// PRUEBA
		Integer resultado = this.mapper.actualizarDocumento(documentoPrueba);
		// COMPROBACION
		assertThat(resultado, is(1));
		Documento documentoActualizado = this.mapper.getDocumento(1);
		assertThat(documentoActualizado, is(notNullValue()));
		assertThat(documentoActualizado.getNombre(), is("nombre actualizado"));
	}
}
