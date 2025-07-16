package tw.test.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tw.test.apis.MemberDB;

import java.io.IOException;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private MemberDB memberDB;
	
	public Register() {
		try {
			memberDB = new MemberDB();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String account = request.getParameter("account");
		String passwd = request.getParameter("passwd");
		String name = request.getParameter("name");
		
		if (!memberDB.isAccountExist(account)) {
			if (memberDB.addMember(account, passwd, name)) {
				response.sendRedirect("test25.jsp");
			}
			else {
				response.sendRedirect("test24.jsp?errType=1");
			}
		}
		else {
			response.sendRedirect("test24.jsp?errType=2");
		}
	}
}
