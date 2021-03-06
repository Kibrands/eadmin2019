package es.fpdual.primero.eadmin.codigoqr;

import java.awt.*;
import java.awt.image.*;
import java.io.*;

import javax.imageio.*;

import org.apache.log4j.*;

import com.google.zxing.*;
import com.google.zxing.common.*;
import com.google.zxing.qrcode.*;

import es.fpdual.primero.eadmin.modelo.*;

public class CodigoQR {

	private static final Logger logger = LogManager.getLogger(CodigoQR.class);

	public void crearCodigoQR(Documento documento) {
		try {
			String content = documento.getNombre();
			String fileType = "png";
			int size = 125;
			QRCodeWriter qrcode = new QRCodeWriter();
			BitMatrix matrix = qrcode.encode(content, BarcodeFormat.QR_CODE, size, size);
			File qrFile = new File(content + "." + fileType);
			int matrixWidth = matrix.getWidth();
			BufferedImage image = new BufferedImage(matrixWidth, matrixWidth, BufferedImage.TYPE_INT_RGB);
			image.createGraphics();

			Graphics2D graphics = (Graphics2D) image.getGraphics();
			graphics.setColor(Color.WHITE);
			graphics.fillRect(0, 0, matrixWidth, matrixWidth);
			graphics.setColor(Color.BLACK);

			for (int b = 0; b < matrixWidth; b++) {
				for (int j = 0; j < matrixWidth; j++) {
					if (matrix.get(b, j)) {
						graphics.fillRect(b, j, 1, 1);
					}
				}
			}
			ImageIO.write(image, fileType, qrFile);
		} catch (WriterException ex) {
			logger.error(ex);
		} catch (IOException ex) {
			logger.error(ex);
		}
	}
}
