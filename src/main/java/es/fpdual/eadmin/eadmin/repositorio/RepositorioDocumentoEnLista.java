package es.fpdual.eadmin.eadmin.repositorio;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import es.fpdual.eadmin.eadmin.EadminApplication;
import es.fpdual.eadmin.eadmin.modelo.AdministracionElectronicaException;
import es.fpdual.eadmin.eadmin.modelo.Documento;

@Repository
public class RepositorioDocumentoEnLista implements RepositorioDocumento {

	private final List<Documento> documentos = new ArrayList<>();
	private static final Logger logger = LogManager.getLogger(EadminApplication.class);

	@Override
	public void altaDocumento(Documento documento) {

		if (documentos.contains(documento)) {
			throw new AdministracionElectronicaException("El documento ya existe");
		}
		documentos.add(documento);
		logger.info("\n**************************************************\n" + "Documento almacenado correctamente\n"
				+ "Id: " + documento.getId() + "\nNombre: " + documento.getNombre() + "\nUsuario: "
				+ documento.getUsuario().getNombre() + "\nFecha Creación: " + documento.getFechaCreacion()
				+ "\nTipo Documento: " + documento.getTipoDocumento()
				+ "\n**************************************************");
	}

	@Override
	public void modificarDocumento(Documento documento) {

		if (!documentos.contains(documento)) {
			throw new AdministracionElectronicaException("El documento no existe");
		}

		documentos.set(documentos.indexOf(documento), documento);

	}

	@Override
	public void eliminarDocumento(int id) {

		final Documento documentoAEliminar = new Documento(id, null, null, null, null);
		final int indice = documentos.indexOf(documentoAEliminar);
		if (indice >= 0) {
			documentos.remove(indice);
			logger.info("Documento con id " + id + " eliminado correctamente");
		}
	}

	@Override
	public List<Documento> obtenerTodosDocumentos() {
		return this.documentos.stream().collect(Collectors.toList());
	}

	@Override
	public int getSiguienteId() {
		if (documentos.isEmpty()) {
			return 1;
		}
		return documentos.get(documentos.size() - 1).getId() + 1;
	}

	@Override
	public Documento obtenerDocumentoPorId(int codigoDocumento) {
		return documentos.stream().filter(d -> d.getId() == codigoDocumento).findFirst().orElse(null);
	}

}
