<%@page import="org.lanqiao.entity.Publisher"%>
<%@page import="org.lanqiao.entity.Goods"%>
<%@page import="org.lanqiao.service.impl.PublisherServiceImpl"%>
<%@page import="org.lanqiao.service.PublisherService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta content="all" name="robots"/>
<meta name="author" content="Fisher" />
<meta name="Copyright" content="Copyright 2007-2008, 版权所有 www.reefdesign.cn" />
<meta name="description" content="reefdesign" />
<meta name="keywords" content="reefdesign" />
<title>电子书城</title>
<link rel="shortcut icon" href="favicon.ico" >
<link rel="stylesheet" rev="stylesheet" href="css/style.css" type="text/css" media="all" />
</head>

<body class="main">

<%@include file="header.jsp" %>

<div id="divpagecontent">
<%	PublisherService ps=new PublisherServiceImpl();
	Goods goods=(Goods)request.getAttribute("goods");
	System.out.print(request.getAttribute("keyword").toString());
	String keyword=request.getAttribute("keyword").toString();
	System.out.print(keyword);
	String pid=goods.getPid();
	Publisher publisher=ps.getPublisher(pid);
%>
  
      <div style="text-align:right; margin:5px 10px 5px 0px"><a href="indexservlet">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;<%=goods.getGtitle() %></div>
        <table cellspacing="0" class="infocontent">
        <tr>
          <td><img src="ad/page_ad.jpg" width="645" height="84" />
		  
		    <table width="100%%" border="0" cellspacing="0">
              <tr>
                <td width="30%">
				
				<div class="divbookcover"><p><img src="bookcover/<%=goods.getGimg() %>.jpg" /></p></div>
				
				<div style="text-align:center;width:40%;height:20px; margin:10px auto;border:red solid 1px;"><a href="searchservlet?keyword=<%=keyword%>"><font size="+1"color="blue"><b>返&nbsp;&nbsp;&nbsp;&nbsp;回</b></font></a></div>
				</td>
                <td style="padding:20px 5px 5px 5px"><img src="images/miniicon3.gif" width="16" height="13" /><font class="bookname">&nbsp;&nbsp;<%=goods.getGtitle() %></font><hr/>作者：<%=goods.getGauthor() %> 著<hr/>售价：<font color="#FF0000">￥<%=goods.getGsaleprice() %>.00</font>&nbsp;&nbsp;&nbsp;&nbsp;原价：<s>￥<%=goods.getGinprice() %>.00</s><hr/>出版社：<%=publisher.getPname() %>
<hr/><p><b>内容简介：</b></p>　<%=goods.getGdesc() %>
</td>
              </tr>
            </table>		  </td>
        </tr>
      </table>
</div>



<%@include file="footer.jsp" %>


</body>
</html>
</body>
</html>