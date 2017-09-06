package org.lanqiao.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.User;
import org.lanqiao.service.UserService;
import org.lanqiao.service.impl.UserRoleServiceImpl;
import org.lanqiao.service.impl.UserServiceImpl;
@WebServlet("/checkservlet")
public class CheckServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	// TODO Auto-generated method stub
	PrintWriter out=resp.getWriter();
	UserService us=new UserServiceImpl();
	User user=null;
	String type=req.getParameter("type");
	if(type.equals("email")){
		String email=req.getParameter("email");
		user=us.getUserByEmail(email);
		if(user==null){
			out.write("1");
		}else{
			out.write("0");
		}
		
		
	}else if(type.equals("loginid")){
		String loginid=req.getParameter("loginid");
		user=us.getUserByLoginid(loginid);
		if(user==null){
			out.write("1");
		}else{
			out.write("0");
		}
	}
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
