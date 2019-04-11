package es.fpdual.primero.eadmin.controlador;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import es.fpdual.primero.eadmin.modelo.*;
import es.fpdual.primero.eadmin.pdf.*;
import es.fpdual.primero.eadmin.servicio.*;

@RestController
public class ControladorDocumento {
	ServicioDocumento servicioDocumento;

	@Autowired
	public ControladorDocumento(ServicioDocumento servicioDocumento) {
		this.servicioDocumento = servicioDocumento;
	}

	@PostMapping("/documentos")
	public Documento altaDocumento(@RequestBody DocumentoRequest documentoRequest) {
		final Documento documentoAInsertar = DocumentoRequestMapper.toDocumento(documentoRequest);
		return this.servicioDocumento.altaDocumento(documentoAInsertar);
	}

	@GetMapping("/documentos")
	public List<Documento> obtenerTodosLosDocumentos() {
		return this.servicioDocumento.obtenerTodosDocumentos();
	}

	@DeleteMapping("/documentos/{id}")
	public void eliminarDocumento(@PathVariable("id") int id) {
		this.servicioDocumento.eliminarDocumento(id);
		Pdf.convertirLogPDF();
	}

	@PutMapping("/documentos/{id}")
	public void modificarDocumento(@RequestBody DocumentoRequest documentoRequest, @PathVariable("id") int id) {
		final Documento documento = this.servicioDocumento.obtenerDocumentoPorId(id);
		final Documento documentoAModificar = DocumentoRequestMapper.toDocumentoCompleto(documentoRequest,
				documento.getId(), documento.getFechaCreacion());
		this.servicioDocumento.modificarDocumento(documentoAModificar);
		Pdf.convertirLogPDF();
	}

	@GetMapping("/documentos/{id}")
	public Documento obtenerDocumentoPorId(@PathVariable("id") int id) {
		return this.servicioDocumento.obtenerDocumentoPorId(id);
	}
}
