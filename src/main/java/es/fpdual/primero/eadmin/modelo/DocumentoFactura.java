package es.fpdual.primero.eadmin.modelo;

import java.time.*;

import org.apache.log4j.*;

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

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof DocumentoFactura) {
			final DocumentoFactura documentoFactura = (DocumentoFactura) obj;
			return documentoFactura.getId() == this.getId();
		}
		return false;
	}
}