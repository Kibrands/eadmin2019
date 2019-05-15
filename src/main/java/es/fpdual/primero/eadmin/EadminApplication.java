package es.fpdual.primero.eadmin;

import org.apache.log4j.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;

/**
 * Aplicación para Administración de documentos. Esta será usada con sentencias
 * Post/Get/etc.
 * 
 * Dependencias: poi, poi-ooxml, poi-ooxml-schemas, xmlbeans, apache log4j,
 * commons-collections, commons-compress
 * 
 * @author Julio de la Matta Cadenas
 *
 */
@SpringBootApplication
public class EadminApplication {

	private static final Logger logger1 = LogManager.getLogger(EadminApplication.class);

	public static void main(String[] args) {

		logger1.info("Iniciando Servicio");

		SpringApplication.run(EadminApplication.class, args);

		logger1.info("Finalizando Servicio");

		// Pdf.convertirLogPDF();
	}
}
