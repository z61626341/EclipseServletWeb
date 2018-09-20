package com.jimmy.ServletWeb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ContextParamServlet")
public class ContextParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ContextParamServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		PrintWriter out = response.getWriter();
		ServletContext servletContext = getServletConfig().getServletContext();
		
		String uploadFolder = servletContext.getInitParameter("upload folder");
		String allowedFileType = servletContext.getInitParameter("allowed file type");


		response.setContentType("text/html");
		out.println("<!DOCTYPE HTML PUBLIC \"-W3C//DTD HTML 4.01 Transitional//EN\">");
		
		out.println("<HTML>");
		out.println("<HEAD><TITLE>讀取文件參數</TITLE></HEAD>");
		out.println("<link rel='stylesheet' type='text/css' href='../css/style.css'>");
		out.println("<BODY>");
		
		out.println("<div align=center><br/>");
		out.println("<fieldset style='width:90%'><legend></legend><br/>");
		
		out.println("<div class='line'>");
		out.println(" <div align=left  class='leftDiv'>上傳資料夾</div>");
		out.println(" <div align=left  class='rightDiv'>" + uploadFolder + "</div>");
		out.println("</div>");
		out.println("<div class='line'>");
		out.println(" <div align=left  class='leftDiv'>實際磁碟路徑</div>");
		out.println(" <div align=left  class='rightDiv'>" + servletContext.getRealPath(uploadFolder) + "</div>");
		out.println("</div>");
		out.println("<div class='line'>");
		out.println(" <div align=left  class='leftDiv'>允許上傳的類型</div>");
		out.println(" <div align=left  class='rightDiv'>" + allowedFileType + "</div>");
		out.println("</div>");
		
		out.println("</fieldset>");
		out.println("</div>");
		
		out.println("</BODY>");
		out.println("</HTML>");
		
		out.flush();
		out.close();
	}

}
