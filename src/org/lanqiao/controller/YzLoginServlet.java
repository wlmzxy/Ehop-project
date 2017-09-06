package org.lanqiao.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.lanqiao.entity.User;
import org.lanqiao.service.UserService;
import org.lanqiao.service.impl.UserServiceImpl;
@WebServlet("/yzloginservlet")
public class YzLoginServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	// TODO Auto-generated method stub
	req.setCharacterEncoding("utf-8");
	resp.setContentType("text/html;charset=utf-8");
	
	Cookie[] cookies=req.getCookies();
	Cookie cookie1=null;
	Cookie cookie2=null;
	for(Cookie c:cookies){
		if(c.getName().equals("uloginid")){
			cookie1=c;}
		if(c.getName().equals("upassword")){
			cookie2=c;}
		if(cookie1!=null&&cookie2!=null){
			UserService us=new UserServiceImpl();
			User user =us.getUserByLoginid(cookie1.getValue());
				HttpSession session=req.getSession();
				session.setAttribute("user", user);
				}
		}
	req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
	
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
