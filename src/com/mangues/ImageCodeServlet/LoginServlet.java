package com.mangues.ImageCodeServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String piccode=(String)request.getSession().getAttribute("piccode");
		String code=request.getParameter("code").toUpperCase();
		if(piccode.equals(code))
		      out.println("<script>alert("+"输入正确"+")</script>");
		else
			 out.println("<script>alert("+"'输入错误'"+")</script>");
		out.flush();
		out.close();
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
             doGet(request,response);
	}

}
