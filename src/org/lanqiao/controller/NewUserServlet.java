package org.lanqiao.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.PasswordAnswer;
import org.lanqiao.entity.User;
import org.lanqiao.service.PasswordAnswerService;
import org.lanqiao.service.UserService;
import org.lanqiao.service.impl.PasswordAnswerServiceImpl;
import org.lanqiao.service.impl.UserServiceImpl;
import org.lanqiao.util.MailUtil;
import org.lanqiao.util.Md5Util;
@WebServlet("/newuserservlet")
public class NewUserServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	// TODO Auto-generated method stub
	req.setCharacterEncoding("utf-8");
	resp.setCharacterEncoding("utf-8");
	resp.setContentType("text/html;charset=utf-8");
	
	String type=req.getParameter("type");
	if (type==null){
		String userid=req.getParameter("userid");
		String ustateid="B5868B7A06E54DAEB19658343D3A2B28";
		if(userid!=null){
			UserService us=new UserServiceImpl();
			us.updateUser(userid, ustateid);
			resp.addHeader("refresh", "5;url=indexservlet");
			req.getRequestDispatcher("/WEB-INF/newusersuccess.jsp").forward(req, resp);
		}
	}else if(type!=null&&type.equals("newuser")){
		req.getRequestDispatcher("/WEB-INF/newuser.jsp").forward(req, resp);
	
		}else if(type!=null&&type.equals("adduser")){
					String userid=UUID.randomUUID().toString();
					String uemail=req.getParameter("newuseremail");
					String uloginid=req.getParameter("newusername");
					String upassword=req.getParameter("newuserpassword1");
					String usex=req.getParameter("newusersex");
					String uaddress=req.getParameter("newuseraddress");
					String utel=req.getParameter("newusertel");
					String ustateid="36D0F394FC6A45829385E0BE11208263";
					String uroleid="116F9526C319462780B9CA72F6BB9B41";
					User user=new User(userid, uemail, uloginid, Md5Util.md5(upassword), usex, uaddress, utel, ustateid, uroleid);
					UserService us=new UserServiceImpl();
					us.addUser(user);
					String answerid=UUID.randomUUID().toString();
					String aquestion=req.getParameter("passwordprotect");
					String answer=req.getParameter("answer");
					String backupemail=req.getParameter("backupemail");
					PasswordAnswerService ps=new PasswordAnswerServiceImpl();
					PasswordAnswer pn=new PasswordAnswer(answerid, aquestion, answer, backupemail, userid);
					ps.addPasswordAnswer(pn);
					MailUtil.sendMail(uemail, "E-shop","点击此链接以激活账号：http://localhost:8080/Eshop_Project/newuserservlet?userid="+userid);
					req.getRequestDispatcher("/WEB-INF/zhucetishi.jsp").forward(req, resp);
			}
		}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
