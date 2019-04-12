package es.fpdual.primero.eadmin.mapper;

import org.apache.ibatis.annotations.*;

import es.fpdual.primero.eadmin.modelo.*;

public interface DocumentoMapper {

	Integer insertarDocumento(@Param("documento") Documento documento);

	Documento getDocumento(@Param("id") int id);

	Integer actualizarDocumento(@Param("documento") Documento documento);

}
