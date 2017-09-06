package org.lanqiao.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.Goods;
import org.lanqiao.service.GoodsService;
import org.lanqiao.service.impl.GoodsServiceImpl;
@WebServlet("/searchservlet")
public class SearchServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	// TODO Auto-generated method stub
	req.setCharacterEncoding("utf-8");
	resp.setContentType("text/html;charset=utf-8");
	
	String type=req.getParameter("type");
	if(type==null){
		String keyword=req.getParameter("keyword");
		if(keyword==null){
		req.getRequestDispatcher("indexservlet").forward(req, resp);
		}else{
		req.setAttribute("keyword", keyword);
		req.getRequestDispatcher("/WEB-INF/search.jsp").forward(req, resp);
		}
	}else if(type!=null&&(type.equals("search"))){
		String gid=req.getParameter("gid");
		String keyword=req.getParameter("keyword");
		GoodsService gs=new GoodsServiceImpl();
		Goods goods=gs.getGoods(gid);
		req.setAttribute("goods", goods);
		req.setAttribute("keyword", keyword);
		req.getRequestDispatcher("/WEB-INF/searchdetail.jsp").forward(req, resp);
	}
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
