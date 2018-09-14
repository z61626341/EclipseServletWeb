package com.jimmy.ServletWeb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
        super();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: Jimmy's ").append(request.getContextPath());
		excute(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		excute(request, response);
	}

	public long getLastModified(HttpServletRequest request, HttpServletResponse response) {
		this.log("執行 getLastModified 方法 ... ");
		return -1;
		
	}
	
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String requestURI = request.getRequestURI();
		String method = request.getMethod();
		String param = request.getParameter("param");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("<HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("<BODY>");
		out.println(" 以 " + method + " 方式存取該頁面。取到的param 參數為: " + param + "</br>");
		out.println(" <form action='" + requestURI + "' method='get'> <input type='submit' name='param' value='param string'><input type='submit' value='以GET方式查詢頁面 " + requestURI + "'></form>");
		out.println(" <form action='" + requestURI + "' method='post'> <input type='submit' name='param' value='param string'><input type='submit' value='以POST方式查詢頁面 " + requestURI + "'></form>");
		out.println("<script>document.write('本頁面最後更新時間: ' + document.lastModified);</script>");
		out.println("</BODY>");
		out.println("</HTML>");
		
		out.flush();
		out.close();
		
	}
	

}
