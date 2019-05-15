package es.fpdual.primero.eadmin.modelo;

import java.time.*;

import org.apache.log4j.*;

import lombok.*;

@EqualsAndHashCode(callSuper = false)
public class DocumentoFactura extends Documento {
	private final double importeFactura;
	private static final Logger logger = LogManager.getLogger(DocumentoFactura.class);

	public DocumentoFactura(int id, String nombre, Usuario usuario, LocalDate fechaCreacion, double importeFactura) {
		super(id, nombre, usuario, fechaCreacion, TipoDocumento.DOCUMENTO_FACTURA);
		this.importeFactura = importeFactura;

		logger.warn("Documento Factura creado");
	}

	public double getImporteFactura() {
		return importeFactura;
	}

}
