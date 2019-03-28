package es.fpdual.eadmin.eadmin.modelo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

public class DocumentoPadronTest {
	@Test
	public void deberiaDevolverTrueSiSonIguales() {
		final Usuario usuario = new Usuario(1, "Julio", "Desarrollador");
		final DocumentoPadron documentoPadron = new DocumentoPadron(1, "Contable", usuario, new Date(), "Sevilla");
		final DocumentoPadron documentoPadron2 = new DocumentoPadron(1, "Contable 2", usuario, new Date(), "Madrid");
		final boolean resultado = documentoPadron.equals(documentoPadron2);

		assertTrue(resultado);
	}

	@Test
	public void deberiaDevolverFalseSiSonDiferentes() {
		final Usuario usuario = new Usuario(1, "Julio", "Desarrollador");
		final DocumentoPadron documentoPadron = new DocumentoPadron(1, "Contable", usuario, new Date(), "Sevilla");
		final Documento documento = new Documento(1, "Contable 2", usuario, new Date(),
				TipoDocumento.DOCUMENTO_CONTABLE);
		final boolean resultado = documentoPadron.equals(documento);

		assertFalse(resultado);
	}
}
