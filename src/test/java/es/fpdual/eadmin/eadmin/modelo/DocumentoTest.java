package es.fpdual.eadmin.eadmin.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class DocumentoTest {
	@Test
	public void deberiaCalcularHashCode() {
		final Usuario usuario = new Usuario(1, "Julio", "Desarrollador");
		final Documento documento = new Documento(1, "Contable", usuario, null, TipoDocumento.DOCUMENTO_CONTABLE);

		assertEquals(1, documento.hashCode());
	}

	@Test
	public void deberiaDevolverTrueSiSonIguales() {
		final Usuario usuario = new Usuario(1, "Julio", "Desarrollador");
		final Documento documento = new Documento(1, "Contable", usuario, null, TipoDocumento.DOCUMENTO_CONTABLE);
		final Documento documento2 = new Documento(1, "Contable", usuario, null, TipoDocumento.DOCUMENTO_CONTABLE);
		final boolean resultado = documento.equals(documento2);

		assertTrue(resultado);
	}

	@Test
	public void deberiaDevolverFalseSiSonDiferentes() {
		final Usuario usuario = new Usuario(1, "Julio", "Desarrollador");
		final Documento documento = new Documento(1, "Contable", usuario, null, TipoDocumento.DOCUMENTO_CONTABLE);
		final Documento documento2 = new Documento(3, "Contable", usuario, null, TipoDocumento.DOCUMENTO_FACTURA);
		final boolean resultado = documento.equals(documento2);

		assertFalse(resultado);
	}
}
