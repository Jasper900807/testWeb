package tw.test.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Servlet implementation class Test12
 */
@WebServlet("/Test12.jpg")
public class Test12 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String source = "C:\\Users\\User\\eclipse-workspace\\testWeb\\src\\main\\webapp\\uplaod\\coffee.jpg";

		BufferedImage img = ImageIO.read(new File(source));
		Graphics2D g2d = img.createGraphics();
		
		Font font = new Font(null, Font.BOLD, 72);
		
		AffineTransform transform = new AffineTransform();
		transform.rotate(Math.toRadians(-15));
		Font font2 = font.deriveFont(transform);
		
		g2d.setColor(Color.YELLOW);
		g2d.setFont(font2);
		g2d.drawString("Hello, world", 200, 300);
		
		response.setContentType("image/jpeg");
		ImageIO.write(img, "JPEG", response.getOutputStream());
		response.flushBuffer();
	
		ImageIO.write(img, "JPEG", new File("C:\\Users\\User\\eclipse-workspace\\testJava\\dir1\\test.jpg"));
    }

}
