package tw.test.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/Test06")
public class Test06 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String x = "", y = "", result = "", op = "";
			
		try {
			x = request.getParameter("x");
			op = request.getParameter("op");
			y = request.getParameter("y");
			switch (op) {
			case "1": result = Integer.parseInt(x) + Integer.parseInt(y) + ""; break;
			case "2": result = Integer.parseInt(x) - Integer.parseInt(y) + ""; break;
			case "3": result = Integer.parseInt(x) * Integer.parseInt(y) + ""; break;
			case "4": result = Integer.parseInt(x) / Integer.parseInt(y) + "..." + Integer.parseInt(x) % Integer.parseInt(y); break;
			}
		} 
		catch (Exception e) {
			System.out.println(e);
			x = y = "";
		}
		
		
		
		// ------
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.printf("<!DOCTYPE html>\n")
			.printf("<html>\n")
			.printf("<head>\n")
			.printf("<meta charset='UTF-8'>\n")
			.printf("<title>Insert title here</title>\n")
			.printf("</head>\n")
			.printf("<body>\n")
			.printf("<form action='Test06'>\n")
			.printf("<input name='x' value='%s' />\n", x)
			.printf("<select name='op'>\n")
			.printf("<option value='1' %s>+</option>\n", op.equals("1")?"selected":"")
			.printf("<option value='2' %s>-</option>\n", op.equals("2")?"selected":"")
			.printf("<option value='3' %s>*</option>\n", op.equals("3")?"selected":"")
			.printf("<option value='4' %s>/</option>\n", op.equals("4")?"selected":"")
			.printf("<input name='y' value='%s' />\n", y)
			.printf("<input type='submit' value='=' />\n")
			.printf("<span>%s</span>\n", result)
			.printf("</form>\n")
			.printf("</body>\n")
			.printf("</html>\n");
		response.flushBuffer();
		
	}

}
