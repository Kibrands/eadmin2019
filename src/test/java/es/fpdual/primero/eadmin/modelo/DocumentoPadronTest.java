package es.fpdual.primero.eadmin.modelo;

import static org.junit.Assert.*;

import java.time.*;

import org.junit.*;

public class DocumentoPadronTest {
	@Test
	public void deberiaDevolverTrueSiSonIguales() {
		final Usuario usuario = new Usuario(1, "Julio", "Desarrollador");
		final DocumentoPadron documentoPadron = new DocumentoPadron(1, "Contable", usuario, LocalDate.now(), "Sevilla");
		final DocumentoPadron documentoPadron2 = new DocumentoPadron(1, "Contable 2", usuario, LocalDate.now(),
				"Madrid");
		final boolean resultado = documentoPadron.equals(documentoPadron2);

		assertTrue(resultado);
	}

	@Test
	public void deberiaDevolverFalseSiSonDiferentes() {
		final Usuario usuario = new Usuario(1, "Julio", "Desarrollador");
		final DocumentoPadron documentoPadron = new DocumentoPadron(1, "Contable", usuario, LocalDate.now(), "Sevilla");
		final Documento documento = new Documento(1, "Contable 2", usuario, LocalDate.now(),
				TipoDocumento.DOCUMENTO_CONTABLE);
		final boolean resultado = documentoPadron.equals(documento);

		assertFalse(resultado);
	}
}
