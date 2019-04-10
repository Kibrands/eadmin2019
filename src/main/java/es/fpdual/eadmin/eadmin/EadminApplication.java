package es.fpdual.eadmin.eadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import es.fpdual.eadmin.eadmin.pdf.Pdf;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Aplicación para Administración de documentos. Esta será usada con sentencias
 * Post/Get/etc.
 * 
 * Librerias externas: poi, poi-ooxml, poi-ooxml-schemas, xmlbeans, apache
 * log4j, commons-collections, commons-compress
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

		Pdf.convertirLogPDF();
	}
}
