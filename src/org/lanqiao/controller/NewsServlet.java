package org.lanqiao.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/newsservlet")
public class NewsServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	// TODO Auto-generated method stub
	req.setCharacterEncoding("utf-8");
	resp.setContentType("text/html;charset=utf-8");
	
	String type=req.getParameter("type");
	String tid=req.getParameter("tid");
	if (type!=null&&tid!=null&&type.equals("News")) {
		req.setAttribute("tid", tid);
		req.getRequestDispatcher("/WEB-INF/news.jsp").forward(req, resp);
	}
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
