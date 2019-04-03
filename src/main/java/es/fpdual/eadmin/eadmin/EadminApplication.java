package es.fpdual.eadmin.eadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import es.fpdual.eadmin.eadmin.modelo.DocumentoContable;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

@SpringBootApplication
public class EadminApplication {
	private static final Logger logger1 = LogManager.getLogger(EadminApplication.class);

	public static void main(String[] args) {

		// Logger.info Iniciando
		logger1.info("Iniciando Servicio");
		// Logger.trace
		logger1.trace("Mensaje Trace");
		// Logger Documento_Contable
		DocumentoContable documento = new DocumentoContable(0, null, null, null, null);
		// Logger warn
		logger1.warn("Mensaje warn");
		// Logger error
		logger1.error("Mensaje error");

		SpringApplication.run(EadminApplication.class, args);

		// Logger.info Finalizando
		logger1.info("Finalizando Servicio");
	}

}
 