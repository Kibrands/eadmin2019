package es.fpdual.primero.eadmin.modelo;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.time.*;

import org.junit.*;

public class DocumentoContableTest {

	@Test
	public void deberiaDevolverTrueSiSonIguales() {
		final Usuario usuario = new Usuario(1, "Julio", "Desarrollador");
		final DocumentoContable documentoContable = new DocumentoContable(1, "Contable", usuario, LocalDate.now(),
				"555335511136");
		final DocumentoContable documentoContable2 = new DocumentoContable(1, "Contable", usuario, LocalDate.now(),
				"555335511136");
		final boolean resultado = documentoContable.equals(documentoContable2);

		assertThat(resultado, is(true));
	}

	@Test
	public void deberiaDevolverFalseSiSonDiferentes() {
		final Usuario usuario = new Usuario(1, "Julio", "Desarrollador");
		final DocumentoContable documentoContable = new DocumentoContable(1, "Contable", usuario, LocalDate.now(),
				"555335511136");
		final Documento documento = new Documento(2, "Contable 2", usuario, LocalDate.now(),
				TipoDocumento.DOCUMENTO_CONTABLE);
		final boolean resultado = documento.equals(documentoContable);

		assertThat(resultado, is(false));
	}
}
