package org.lanqiao.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.Che;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@WebServlet("/gouwucheservlet")
public class GouwucheServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	// TODO Auto-generated method stub
	req.setCharacterEncoding("utf-8");
	resp.setContentType("text/html;charset=utf-8");
	
	String cid=req.getParameter("cid");
	String pageIndex=req.getParameter("pageIndex");
	String gid=req.getParameter("gid");
	if(cid==null){cid="1";}
	if(pageIndex==null){pageIndex="1";}
	req.setAttribute("cid", cid);
	req.setAttribute("pageIndex", pageIndex);
	
	String type=req.getParameter("type");
	TypeToken<List<Che>> listType = new TypeToken<List<Che>>() { };
	Gson gson=new Gson();
	Cookie[] cookies=req.getCookies();
	Cookie cookie=null;
	for(Cookie c:cookies){
		if(c.getName().equals("che")){
			cookie=c;
		}
	}
	//删除
	if(gid!=null&&type!=null&&type.equals("remove")){
		if(cookie==null){
			resp.sendRedirect("gouwucheservlet");
			return;
		}else{
			List<Che> list=gson.fromJson(cookie.getValue(),listType.getType());
			Che che5=null;
			for(int i=0;i<list.size();i++){
				if(list.get(i).getGid().equals(gid)){
					che5=list.remove(i);
					String b=gson.toJson(list);
					Cookie cookie2=new Cookie("che", b);
					cookie2.setMaxAge(60*60*24*365);
					resp.addCookie(cookie2);
					resp.sendRedirect("gouwucheservlet");
					return;
				}
			}
			if(che5==null){
				resp.sendRedirect("gouwucheservlet");
			return;
			}
			
		}
		
	
	//添加
	}else if(gid!=null){
		if(cookie==null){
			Che che=new Che(gid, 1);
			List<Che> list=new ArrayList<Che>();
			list.add(che);
			String c=gson.toJson(list);
			Cookie checookie=new Cookie("che", c);
			checookie.setMaxAge(60*60*24*365);
			resp.addCookie(checookie);
			resp.sendRedirect("gouwucheservlet");
			return;
		}else{
			List<Che> list=gson.fromJson(cookie.getValue(),listType.getType());
			Che che1=null;
			for(int i=0;i<list.size();i++){
				if(list.get(i).getGid().equals(gid)){
					che1=list.get(i);
					Che che2=new Che(gid, che1.getNumber()+1);
					list.add(che2);
					list.remove(i);
					String b=gson.toJson(list);
					Cookie cookie2=new Cookie("che", b);
					cookie2.setMaxAge(60*60*24*365);
					resp.addCookie(cookie2);
					resp.sendRedirect("gouwucheservlet");
					return;
				}
			}
			if(che1==null){
				Che che3=new Che(gid, 1);
				list.add(che3);
				String c=gson.toJson(list);
				Cookie cookie3=new Cookie("che", c);
				cookie3.setMaxAge(60*60*24*365);
				resp.addCookie(cookie3);
				resp.sendRedirect("gouwucheservlet");
				return;
			}
			
		}
	}else{
	//查看购物车
	req.getRequestDispatcher("/WEB-INF/gouwuche.jsp").forward(req, resp);
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
