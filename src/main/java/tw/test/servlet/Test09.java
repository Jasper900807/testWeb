package tw.test.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;


@WebServlet("/Test09")
@MultipartConfig(location = "C:\\Users\\User\\eclipse-workspace\\testWeb\\src\\main\\webapp\\uplaod")	// 檔案上傳處理
public class Test09 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String urip = request.getRemoteAddr();
		Part part = request.getPart("upload");
		
	 	String type = part.getContentType();
	 	long len = part.getSize();
	 	String fileName = part.getSubmittedFileName();
	 	System.out.println(type);
	 	System.out.println(len);
	 	System.out.println(fileName);

	 	part.write(urip + "_" + fileName);
	}

}
