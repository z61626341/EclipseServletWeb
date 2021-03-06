package com.jimmy.ServletWeb;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InitParamServlet")
public class InitParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InitParamServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding(getInitParameter("encoding"));
		request.setCharacterEncoding(getInitParameter("encoding"));
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE HTML PUBLIC \"-W3C//DTD HTML 4.01 Transitional//EN\">");
		
		out.println("<HTML>");
		out.println("<HEAD><TITLE>請登入檢視 Notice 檔案</TITLE></HEAD>");
		out.println("<style>body, td, div{font-size:12px; }</style>");
		out.println("<BODY>");
		
		out.println(" <form action='" + request.getRequestURI() + "' method='post'> ");
		out.println("帳號: <input type='text' name='username' style='width:200px; '><br/>");
		out.println("密碼: <input type='password' name='password' style='width:200px; '><br/>");
		out.println("<input type='submit' value='		登入		'>");
		out.println("</form>");
		
		out.println("</BODY>");
		out.println("</HTML>");
		
		out.flush();
		out.close();
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Enumeration<?> params = this.getInitParameterNames();
		
		while (params.hasMoreElements()) {
			String usernameParam = (String)params.nextElement();
			
			String passnameParam = getInitParameter(usernameParam);
			
			if (usernameParam.equalsIgnoreCase(username) && passnameParam.equals(password)) {
				request.getRequestDispatcher("/WEB-INF/identity.html").forward(request, response);
				return;
			}
		}
		this.doGet(request, response);
	}

}
