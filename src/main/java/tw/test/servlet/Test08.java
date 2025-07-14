package tw.test.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/Test08")
public class Test08 extends HttpServlet {
	public Test08() {
		System.out.println("Test08()");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init(ServletConfig)");
		super.init(config);
	}

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		System.out.println("service(ServletRequest,ServletResponse)");
		if (request instanceof HttpServletRequest) {
			System.out.println("Y");
		}else {
			System.out.println("N");
		}
		super.service(request, response);
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service(HttpServletRequest,HttpServletResponse)");
		//super.service(arg0, arg1);
		
		String method =  request.getMethod();
		System.out.println(method);
		
	}

	@Override
	public void init() throws ServletException {
		System.out.println("init()");
		super.init();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet()");
	}

}
