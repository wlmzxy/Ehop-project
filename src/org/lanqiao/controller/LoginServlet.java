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
import org.lanqiao.entity.UserState;
import org.lanqiao.service.UserService;
import org.lanqiao.service.UserStateService;
import org.lanqiao.service.impl.UserServiceImpl;
import org.lanqiao.service.impl.UserStateServiceImpl;
import org.lanqiao.util.Md5Util;
@WebServlet("/loginservlet")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		String uloginid=req.getParameter("uloginid");
		UserService us=new UserServiceImpl();
		User user=us.getUserByLoginid(uloginid);
		if(user==null){
			Cookie cookie=new Cookie("loginvalue","-1");
			cookie.setMaxAge(60*60*24*365*99999);
			resp.addCookie(cookie);
			req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
			return;
		}
		if(user!=null){
		String upassword=req.getParameter("upassword");
		if(upassword==null){
			Cookie cookie=new Cookie("loginvalue","-3");
			cookie.setMaxAge(60*60*24*365*99999);
			resp.addCookie(cookie);
			req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
			return;
		}
		if(upassword!=null&&Md5Util.md5(upassword).equals(user.getUpassword())){
			String ustateid=user.getUstateid();
			UserStateService uss=new UserStateServiceImpl();
			UserState state=uss.getUserStateByUstateid(ustateid);
			String ustatename=state.getUsatename();
			String ch=req.getParameter("checkbox");
			if(ustatename.equals("无效")){
				Cookie cookie=new Cookie("loginvalue","0");
				cookie.setMaxAge(60*60*24*365*99999);
				resp.addCookie(cookie);
				req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
				return;
			}else if(ustatename.equals("有效")){
						if(ch!=null){
							Cookie cookie1=new Cookie("uloginid", uloginid);
							cookie1.setMaxAge(60*60*24*7);
							resp.addCookie(cookie1);
							Cookie cookie2=new Cookie("upassword", Md5Util.md5(upassword));
							cookie2.setMaxAge(60*60*24*7);
							resp.addCookie(cookie2);
						}
						Cookie cookie=new Cookie("loginvalue","5");
						cookie.setMaxAge(60*60*24*365*99999);
						resp.addCookie(cookie);
						HttpSession session=req.getSession();
						session.setAttribute("user", user);
						resp.sendRedirect("myuserservlet");
						return;
					}
				}else if(upassword!=null&&!Md5Util.md5(upassword).equals(user.getUpassword())){
					Cookie cookie=new Cookie("loginvalue","1");
					cookie.setMaxAge(60*60*24*365*99999);
					resp.addCookie(cookie);
					req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
					return;
				}
		req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
		return;
			}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
