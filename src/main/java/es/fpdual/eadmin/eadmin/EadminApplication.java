package es.fpdual.eadmin.eadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

@SpringBootApplication
public class EadminApplication {
	private static final Logger logger1 = LogManager.getLogger(EadminApplication.class);

	public static void main(String[] args) {

		logger1.info("Iniciando Servicio");

		SpringApplication.run(EadminApplication.class, args);

		logger1.info("Finalizando Servicio");
	}

}
