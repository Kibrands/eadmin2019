package es.fpdual.primero.eadmin.modelo;

import static org.junit.Assert.*;

import java.time.*;
import java.util.*;
import java.util.stream.*;

import org.junit.*;

public class ExpedienteTest {
	@Test
	public void deberiaCalcularHashCode() {
		final Usuario usuario = new Usuario(1, "Julio", "Desarrollador");
		final Expediente expediente = new Expediente(1, "Expediente 1", usuario, null,
				TipoExpediente.EXPEDIENTE_SUBVENCIONES, null);

		assertEquals(1, expediente.hashCode());
	}

	@Test
	public void deberiaDevolverTrueSiSonIguales() {
		final Usuario usuario = new Usuario(1, "Julio", "Desarrollador");
		final Expediente expediente = new Expediente(1, "Expediente 1", usuario, null,
				TipoExpediente.EXPEDIENTE_SUBVENCIONES, null);
		final Expediente expediente2 = new Expediente(1, "Expediente 1", usuario, null,
				TipoExpediente.EXPEDIENTE_SUBVENCIONES, null);
		final boolean resultado = expediente.equals(expediente2);

		assertTrue(resultado);
	}

	@Test
	public void deberiaDevolverFalseSiSonDiferentes() {
		final Usuario usuario = new Usuario(1, "Julio", "Desarrollador");
		final Expediente expediente = new Expediente(1, "Expediente 1", usuario, null,
				TipoExpediente.EXPEDIENTE_SUBVENCIONES, null);
		final Expediente expediente2 = new Expediente(2, "Expediente 2", usuario, null,
				TipoExpediente.EXPEDIENTE_SUBVENCIONES, null);
		final boolean resultado = expediente.equals(expediente2);

		assertFalse(resultado);
	}

	@Test
	public void deberiaConstruirUnExpedienteConDocumentos() {
		final Usuario usuario = new Usuario(1, "Juan", "Alcalade");
		final DocumentoContable documentoContable = new DocumentoContable(1, "operacion contable", usuario,
				LocalDate.now(), "00001254684686");
		final DocumentoContable documentoContable2 = new DocumentoContable(2, "certificado contable", usuario,
				LocalDate.now(), "999999999456312");
		final DocumentoPadron documentoPadron = new DocumentoPadron(1, "certificado empadronamiento", usuario,
				LocalDate.now(), "SEVILLA");
		final List<Documento> documentos = new ArrayList<Documento>();
		@SuppressWarnings("unused")
		final List<Documento> documentosContables = documentos.stream().filter(this::esDocumentoContable)
				.collect(Collectors.toList());

		documentos.add(documentoContable);
		documentos.add(documentoContable2);
		documentos.add(documentoPadron);

		final Expediente expediente = new Expediente(1, "expediente 1", usuario, LocalDate.now(),
				TipoExpediente.EXPEDIENTE_NOMINAS, documentos);

		assertEquals(documentos, expediente.getDocumentos());
		assertEquals(3, documentos.size());
		assertTrue(expediente.getDocumentos().contains(documentoContable));

		// for (Documento documento : documentos) {
		// if (esDocumentoContable(documento)) {
		// System.out.println(documento);
		// }
		// }
		documentos.stream().filter(this::esDocumentoContable).forEach(System.out::println);

		documentos.stream().map(documentoActual -> documentoActual.getNombre())
				.forEach(documentoActual -> System.out.println(documentoActual));

		documentos.stream().map(Documento::getNombre).map(String::length).forEach(System.out::println);

		for (Documento documentoActual : documentos) {
			System.out.println(documentoActual.getNombre().length());
		}

	}

	public boolean esDocumentoContable(Documento documento) {
		return documento.getTipoDocumento().equals(TipoDocumento.DOCUMENTO_CONTABLE);
	}

	@Test
	public void deberiaObtenerLongitudMismoDocumento() {
		final Usuario usuario = new Usuario(1, "Juan", "Alcalade");
		final DocumentoContable documentoContable = new DocumentoContable(1, "operacion contable", usuario,
				LocalDate.now(), "00001254684686");
		final DocumentoContable documentoContable2 = new DocumentoContable(2, "certificado contable", usuario,
				LocalDate.now(), "999999999456312");
		final DocumentoPadron documentoPadron = new DocumentoPadron(1, "certificado empadronamiento", usuario,
				LocalDate.now(), "SEVILLA");
		final List<Documento> documentos = new ArrayList<Documento>();

		documentos.add(documentoContable);
		documentos.add(documentoContable2);
		documentos.add(documentoPadron);

	}
}
