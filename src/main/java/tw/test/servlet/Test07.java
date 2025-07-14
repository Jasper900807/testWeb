package tw.test.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/Test07")
public class Test07 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("doPost");
		String account = request.getParameter("account");
		String passwd = request.getParameter("passwd");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String[] interests = request.getParameterValues("interest");
		System.out.printf("%s : %s : %s : %s\n", account, passwd, name, gender);
		if (interests != null) {
			for (String interest : interests) {
				System.out.println(interest);
			}
		} else {
			System.out.println("No interests selected");
		}
	}

}
