package es.fpdual.eadmin.eadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import es.fpdual.eadmin.eadmin.modelo.*;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

@SpringBootApplication
public class EadminApplication {
	private static final Logger logger1 = LogManager.getLogger(EadminApplication.class);

	public static void main(String[] args) {

		// Logger.info Iniciando
		logger1.info("Iniciando Servicio");
		// Logger Documento_Contable
		DocumentoContable documentoContable = new DocumentoContable(0, null, null, null, null);
		DocumentoFactura documentoFactura = new DocumentoFactura(0, null, null, null, 0);
		DocumentoNomina documentoNomina = new DocumentoNomina(0, null, null, null, null);
		Documento documento = new Documento(0, null, new Usuario(0, null, null), null, null);

		SpringApplication.run(EadminApplication.class, args);

		// Logger.info Finalizando
		logger1.info("Finalizando Servicio");
	}

}
