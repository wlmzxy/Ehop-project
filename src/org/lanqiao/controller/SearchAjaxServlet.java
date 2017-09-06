package org.lanqiao.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.Goods;
import org.lanqiao.service.GoodsService;
import org.lanqiao.service.impl.GoodsServiceImpl;

import com.google.gson.Gson;
@WebServlet("/searchajax")
public class SearchAjaxServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	// TODO Auto-generated method stub
	req.setCharacterEncoding("utf-8");
	resp.setContentType("text/html;charset=utf-8");
	String keyword=req.getParameter("keyword");
	if(keyword!=null){
		GoodsService gs=new GoodsServiceImpl();
		List<String > list=gs.getListByKeyword(keyword);
		System.out.println(list);
		List<String > list2=new ArrayList<String>();
		Gson gson=new Gson();
		String key=null;
		if(list.size()!=0&&list.size()<=5){
			for(int i=0;i<list.size();i++){
				list2.add(list.get(i));
			}
			key=gson.toJson(list2);
		}else if(list.size()!=0&&list.size()>5){
			for(int i=0;i<=5;i++){
				list2.add(list.get(i));
			}
			key=gson.toJson(list2);
		}
		resp.getWriter().write(key);
	}
	
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
