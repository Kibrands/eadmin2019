package es.fpdual.eadmin.eadmin.repositorio;

import java.util.List;

import es.fpdual.eadmin.eadmin.modelo.Documento;

public interface RepositorioDocumento {

	public void altaDocumento(Documento documento);

	public void modificarDocumento(Documento documento);

	public void eliminarDocumento(int codigoDocumento);

	public List<Documento> obtenerTodosDocumentos();

	public int getSiguienteId();

	public Documento obtenerDocumentoPorId(int codigoDocumento);

}
