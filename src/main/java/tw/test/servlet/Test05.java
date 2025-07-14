package tw.test.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/Test05")
public class Test05 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String x = request.getParameter("x");
		String y = request.getParameter("y");
		
		int result = Integer.parseInt(x) + Integer.parseInt(y);
		
		// ----------------
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.printf("%s + %s = %d", x, y, result);
		response.flushBuffer();
	}

}
