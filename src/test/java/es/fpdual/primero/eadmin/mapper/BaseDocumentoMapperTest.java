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
		when(usuario.getId()).thenReturn(1);
		Documento modificado = Documento.builder().clone(this.documento).withNombre("Documento de prueba").build();
		// ENTRENAMIENTO
		this.mapper.insertarDocumento(this.documento);
		// PRUEBA
		Integer resultado = this.mapper.actualizarDocumento(modificado);
		// COMPROBACION
		assertThat(resultado, is(1));
		Documento documentoActualizado = this.mapper.getDocumento(1);
		assertThat(documentoActualizado, is(notNullValue()));
		assertThat(documentoActualizado.getNombre(), is("Documento de prueba"));
	}
}
