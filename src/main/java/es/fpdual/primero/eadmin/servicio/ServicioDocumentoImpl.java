package es.fpdual.primero.eadmin.servicio;

import java.time.*;
import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import es.fpdual.primero.eadmin.modelo.*;
import es.fpdual.primero.eadmin.repositorio.*;

@Service
public class ServicioDocumentoImpl implements ServicioDocumento {

	private final RepositorioDocumento repositorioDocumento;

	@Autowired
	public ServicioDocumentoImpl(RepositorioDocumento repositorioDocumento) {
		this.repositorioDocumento = repositorioDocumento;
	}

	@Override
	public Documento altaDocumento(Documento documento) {

		final int siguienteId = repositorioDocumento.getSiguienteId();
		final LocalDate fechaAtual = LocalDate.now();

		Documento documentoModificado = new Documento(siguienteId, documento.getNombre(), documento.getUsuario(),
				fechaAtual, documento.getTipoDocumento());

		repositorioDocumento.altaDocumento(documentoModificado);
		return documentoModificado;

	}

	@Override
	public void modificarDocumento(Documento documento) {
		repositorioDocumento.modificarDocumento(documento);
	}

	@Override
	public void eliminarDocumento(int codigoDocumento) {

		repositorioDocumento.eliminarDocumento(codigoDocumento);

	}

	@Override
	public List<Documento> obtenerTodosDocumentos() {
		return repositorioDocumento.obtenerTodosDocumentos();
	}

	@Override
	public Documento obtenerDocumentoPorId(int codigoDocumento) {
		return this.repositorioDocumento.obtenerDocumentoPorId(codigoDocumento);
	}

}
