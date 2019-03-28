package es.fpdual.eadmin.eadmin;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import es.fpdual.eadmin.eadmin.modelo.*;

@SpringBootApplication
public class EadminApplication {

	public static void main(String[] args) {
		final Usuario usuario = new Usuario(4, "bob", "chef");
		final Date fecha = new Date();
		
		final DocumentoContable documentoContable = new DocumentoContable(1, "operacion contable", usuario, fecha,
				"00001254684686");
		final Documento documento = new DocumentoContable(2, "certificado empadronamiento", usuario, fecha,
				"999999999456312");
		
		Documento documentoNuevo;
		documentoNuevo = documentoContable;
		documentoNuevo = documento;
		
		Documento documentoContable2;
		documentoContable2 = documentoContable;
		documentoContable2 = (DocumentoContable) documento;

		SpringApplication.run(EadminApplication.class, args);
	}

}
