package tw.test.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.util.Collection;


@MultipartConfig(location = "C:\\Users\\User\\eclipse-workspace\\testWeb\\src\\main\\webapp\\uplaod")
@WebServlet("/Test10")
public class Test10 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String account = request.getParameter("account");
		Collection<Part> parts = request.getParts();
		int i = 1;
		for (Part part:parts) {
			String name = part.getName();
			String type = part.getContentType();
			long len = part.getSize();
			System.out.printf("%s, %s, %d\n", name, type, len);
			
			if (name.equals("upload") && len > 0) {
				part.write(String.format("%s_%d_%s", account, i++, part.getSubmittedFileName()));
			}
		}
	}

}
