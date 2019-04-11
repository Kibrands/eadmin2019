package es.fpdual.primero.eadmin.excel;

import java.io.*;
import java.util.*;

import org.apache.log4j.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import es.fpdual.primero.eadmin.modelo.*;

/**
 *
 * @author david
 */
public class Excel {

	private static final org.apache.log4j.Logger logger = LogManager.getLogger(Excel.class);

	public static void exportarDocumentos(List<Documento> listaDocumentos) {
		// Creamos el archivo donde almacenaremos la hoja
		// de calculo, recuerde usar la extension correcta,
		// en este caso .xlsx
		File archivo = new File("listaDocumentos.xlsx");

		// Creamos el libro de trabajo de Excel formato OOXML
		Workbook workbook = new XSSFWorkbook();

		// La hoja donde pondremos los datos
		Sheet pagina = workbook.createSheet("Reporte de productos");

		// Creamos el estilo paga las celdas del encabezado
		CellStyle style = workbook.createCellStyle();
		// Indicamos que tendra un fondo azul aqua
		// con patron solido del color indicado
		style.setFillForegroundColor(IndexedColors.BLUE.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		String[] titulos = { "ID", "Nombre", "Usuario", "Fecha Creacion", "Tipo Documento" };

		// Creamos una fila en la hoja en la posicion 0
		Row fila = pagina.createRow(0);

		// Creamos el encabezado
		for (int i = 0; i < titulos.length; i++) {
			// Creamos una celda en esa fila, en la posicion
			// indicada por el contador del ciclo
			Cell celda = fila.createCell(i);

			// Indicamos el estilo que deseamos
			// usar en la celda, en este caso el unico
			// que hemos creado
			celda.setCellStyle(style);
			celda.setCellValue(titulos[i]);
		}

		// CREAMOS FILAS Y CELDAS
		for (int i = 1; i <= listaDocumentos.size(); i++) {
			fila = pagina.createRow(i);

			// Y colocamos los datos en esa fila
			fila.createCell(0).setCellValue(listaDocumentos.get(i - 1).getId());
			fila.createCell(1).setCellValue(listaDocumentos.get(i - 1).getNombre());
			fila.createCell(2).setCellValue(listaDocumentos.get(i - 1).getUsuario().getNombre());
			fila.createCell(3).setCellValue(listaDocumentos.get(i - 1).getFechaCreacion().toString());
			fila.createCell(4).setCellValue(listaDocumentos.get(i - 1).getTipoDocumento().toString());

		}
		// Ahora guardaremos el archivo
		try {
			// Creamos el flujo de salida de datos,
			// apuntando al archivo donde queremos
			// almacenar el libro de Excel
			FileOutputStream salida = new FileOutputStream(archivo);

			// Almacenamos el libro de
			// Excel via ese
			// flujo de datos
			workbook.write(salida);

			// Cerramos el libro para concluir operaciones
			workbook.close();

			logger.info("Archivo creado existosamente");

		} catch (FileNotFoundException ex) {
			logger.error("Archivo no localizable en sistema de archivos");
		} catch (IOException ex) {
			logger.error("Error de entrada/salida");
		}
	}

}
