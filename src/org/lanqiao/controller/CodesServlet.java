package org.lanqiao.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/codesservlet")
public class CodesServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	// TODO Auto-generated method stub
	//生成验证字符
	req.setCharacterEncoding("utf-8");
	resp.setContentType("text/html;charset=utf-8");
	
	String chars="QWERTYUIOPLKJHGFDSAZXCVBNMzxcvbnmlkjhgfdsaqwertyuiop0123456789";
	Random random=new Random();
	String codes=null;
	StringBuilder sb=new StringBuilder();
	for(int i=0;i<4;i++){
		int j=random.nextInt(61);
		sb.append(chars.charAt(j));
		}
	codes=sb.toString();
	//添加到session，使其能够跨页面访问，以便验证
	req.getSession().setAttribute("codes", codes);
	//生成一张指定大小的空白图片（宽度，高度，....）
	BufferedImage bImage=new BufferedImage(140,40, BufferedImage.TYPE_INT_RGB);
	//获取画笔4
	Graphics g=bImage.getGraphics();
	//设置画笔的颜色
	g.setColor(Color.lightGray);
	//填充背景颜色
	g.fillRect(0, 0, 140, 40);
	g.setColor(Color.WHITE);
	//添加边框
	g.drawRect(1, 1, 140, 40);
	g.setColor(Color.GREEN);
	//生成干扰线
    for (int i = 0; i < 20; i++) {  
        int x = random.nextInt(40);  
        int y = random.nextInt(40);  
        int xl = random.nextInt(140);  
        int yl = random.nextInt(140);  
        g.drawLine(x,y,xl,yl);  
    }  
	g.setColor(Color.BLUE);
	//设置字体、大小
	g.setFont(new Font("宋体", Font.BOLD, 35));
	//设置验证字符的位置,并写入验证字符
	g.drawString(codes, 30, 35);
	//设置图片的格式
	resp.setContentType("image/jpeg");
	//输出图片
	ImageIO.write(bImage, "jpg", resp.getOutputStream());
	//设置刷新
	resp.getOutputStream().flush();
	
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
