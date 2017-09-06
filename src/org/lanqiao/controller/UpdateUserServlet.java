package org.lanqiao.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.PasswordAnswer;
import org.lanqiao.entity.User;
import org.lanqiao.service.PasswordAnswerService;
import org.lanqiao.service.UserService;
import org.lanqiao.service.impl.PasswordAnswerServiceImpl;
import org.lanqiao.service.impl.UserServiceImpl;
import org.lanqiao.util.Md5Util;
@WebServlet("/updateuserservlet")
public class UpdateUserServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	req.setCharacterEncoding("utf-8");
	resp.setContentType("text/html;charset=utf-8");
	
	String type=req.getParameter("type");
	if(type!=null&&type.equals("update")){
		req.getRequestDispatcher("/WEB-INF/updateuser.jsp").forward(req, resp);
	}else{
	User user=(User)req.getSession().getAttribute("user");
	String userid=user.getUserid();
	String uemail=user.getUemail();
	String uloginid=user.getUloginid();
	String password=null;
	if(user.getUpassword().equals(req.getParameter("password1"))){
		password=req.getParameter("password1");
	}else{
		password=Md5Util.md5(req.getParameter("password1"));
	}		
	String sex=req.getParameter("sex");
	String address=req.getParameter("address");
	String tel=req.getParameter("tel");
	String ustateid=user.getUstateid();
	String uroleid=user.getUroleid();
	User u=new User(userid, uemail, uloginid, password, sex, address, tel, ustateid, uroleid);
	UserService us=new UserServiceImpl();
	us.updateUser(u);
	
	String answerid=req.getParameter("answerid");
	String aquestion=req.getParameter("passwordprotect");
	String answer=req.getParameter("answer");
	String backupemail=req.getParameter("backupemail");
	PasswordAnswer pAnswer=new PasswordAnswer(answerid, aquestion, answer, backupemail, userid);
	PasswordAnswerService ps=new PasswordAnswerServiceImpl();
	ps.updatePasswordAnswer(pAnswer);
	
	req.getRequestDispatcher("updateusersuccessservlet").forward(req, resp);
	}
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
