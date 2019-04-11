package es.fpdual.primero.eadmin.mapper;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.time.*;

import org.junit.*;

import es.fpdual.primero.eadmin.modelo.*;

public abstract class BaseDocumentoMapperTest implements DocumentoMapper {

	DocumentoMapper mapper;

	@Test
	public void deberiaInsertarUnDocumento() throws Exception {
		LocalDate fechaActual = LocalDate.now();
		Usuario usuario = new Usuario(1, "Julio", "Desarrollador");
		Documento documento = new Documento(1, "Prueba", usuario, fechaActual, TipoDocumento.DOCUMENTO_PADRON);
		Integer resultado = this.mapper.insertarDocumento(documento);
		assertThat(resultado, is(1));
	}

}
