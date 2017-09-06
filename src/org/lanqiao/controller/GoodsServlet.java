package org.lanqiao.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.Category;
import org.lanqiao.entity.Goods;
import org.lanqiao.entity.PageInfo;
import org.lanqiao.service.CategoryService;
import org.lanqiao.service.GoodsService;
import org.lanqiao.service.impl.CategoryServiceImpl;
import org.lanqiao.service.impl.GoodsServiceImpl;
@WebServlet("/goodsservlet")
public class GoodsServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		String type=req.getParameter("type");
		String cid=req.getParameter("cid");
		String pageIndex=req.getParameter("pageIndex");
		int pageSize=5;
		if(cid==null){
			cid="1";
		}
		if(pageIndex==null){
			
			pageIndex="1";
		}
		if (type!=null&&type.equals("goods")) {
			GoodsService gs=new GoodsServiceImpl();
			CategoryService cs=new CategoryServiceImpl();
			String cname=cs.getCategory(cid).getCname();
			PageInfo<Goods> pageInfo=gs.list(cid, pageSize, Integer.parseInt(pageIndex));
			req.setAttribute("cname", cname);
			req.setAttribute("pageInfo", pageInfo);
			req.getRequestDispatcher("/WEB-INF/list.jsp").forward(req, resp);
		}else {
			String gid=req.getParameter("gid");
			if(type!=null&&gid!=null&&type.equals("goodsdetail")){
				GoodsService gs=new GoodsServiceImpl();
				CategoryService cs=new CategoryServiceImpl();
				Goods goods=gs.getGoods(gid);
				Category category=cs.getCategory(cid);
				req.setAttribute("goods", goods);
				req.setAttribute("category", category);
				req.setAttribute("pageIndex", pageIndex);
				req.getRequestDispatcher("/WEB-INF/goodsdetail.jsp").forward(req, resp);
				
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
