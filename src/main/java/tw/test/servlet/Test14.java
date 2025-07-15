package tw.test.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tw.test.apis.Bike;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Test14
 */
@WebServlet("/Test14")
public class Test14 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Object objX = request.getAttribute("x");
		int x = (int)objX;
		Object objY = request.getAttribute("y");
		int y = (int)objY;
		
		Bike bike = (Bike)request.getAttribute("bike");
		
		String name = request.getParameter("name");
		
		PrintWriter out = response.getWriter();
		out.printf("x = %d; y = %d;<br>", x, y);
		out.printf("Bike = %f<br>", bike.getSpeed());
		out.printf("Name = %s<br>", name);
	}

}
