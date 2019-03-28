package es.fpdual.eadmin.eadmin.servicios;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioDocumento;

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
		final Date fechaActual = new Date();

		Documento documentoModificado = new Documento(siguienteId, documento.getNombre(), documento.getUsuario(),fechaActual, documento.getTipoDocumento());

		 repositorioDocumento.altaDocumento(documento);
		return null;
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

}
