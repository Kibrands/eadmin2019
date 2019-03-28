package es.fpdual.eadmin.eadmin.modelo;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class DocumentoContableTest {

	@Test
	public void deberiaDevolverTrueSiSonIguales() {
		final Usuario usuario = new Usuario(1, "Julio", "Desarrollador");
		final DocumentoContable documentoContable = new DocumentoContable(1, "Contable", usuario, new Date(),
				"555335511136");
		final DocumentoContable documentoContable2 = new DocumentoContable(1, "Contable 2", usuario, new Date(),
				"999996240249");
		final boolean resultado = documentoContable.equals(documentoContable2);

		assertTrue(resultado);
	}

	@Test
	public void deberiaDevolverFalseSiSonDiferentes() {
		final Usuario usuario = new Usuario(1, "Julio", "Desarrollador");
		final DocumentoContable documentoContable = new DocumentoContable(1, "Contable", usuario, new Date(),
				"555335511136");
		final Documento documento = new Documento(1, "Contable 2", usuario, new Date(),
				TipoDocumento.DOCUMENTO_CONTABLE);
		final boolean resultado = documentoContable.equals(documento);

		assertFalse(resultado);
	}
}
