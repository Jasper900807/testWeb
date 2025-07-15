package tw.test.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tw.test.apis.Testutils;

import java.io.IOException;

/**
 * Servlet implementation class Test18
 */
@WebServlet("/Test18")
public class Test18 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String x = (String)request.getAttribute("x");
		String y = (String)request.getAttribute("y");
		String result = (String)request.getAttribute("result");
		
		String webContent = Testutils.loadView();
		response.getWriter().print(String.format(webContent, x, y, result));
		response.flushBuffer();
	}
}
