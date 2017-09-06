<%@page import="org.lanqiao.entity.Goods"%>
<%@page import="org.lanqiao.service.impl.GoodsServiceImpl"%>
<%@page import="org.lanqiao.service.GoodsService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta content="all" name="robots" />
    <meta name="author" content="Fisher" />
    <meta name="Copyright" content="Copyright 2007-2008, 版权所有 www.reefdesign.cn" />
    <meta name="description" content="reefdesign" />
    <meta name="keywords" content="reefdesign" />
    <title>电子书城</title>
    <link rel="shortcut icon" href="favicon.ico">
    <link rel="stylesheet" rev="stylesheet" href="css/style.css" type="text/css" media="all" />
    <style type="text/css">
    a{
    	width: 100%;
    	height: 100%;
    	
    }
    </style>
</head>
<body class="main">
    <%@include file="header.jsp" %>
    
    <div id="divpagecontent">
    <%
    	String keyword=request.getAttribute("keyword").toString();
   		 GoodsService gs=new GoodsServiceImpl();
   		 List<Goods> list=gs.getGoodsByKeyword(keyword);
    
  %>
        <table width="100%" border="0" cellspacing="0">
            <tr>
                <td>
                    <div style="text-align: right; margin: 5px 10px 5px 0px">
                        <a href="indexservlet">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;<%=keyword%></div>
                    <table cellspacing="0" class="infocontent">
                        <tr>
                            <td>
                                <table width="100%" border="0" cellspacing="0">
                                    <tr>
                                        <td style="padding: 10px">
                                        <% if(list.size()==0){ %>
                                           	 以下 <strong>0</strong> 条结果<hr/>
								
								<span style="text-align: center;margin: 30px auto;">没有找到您要的商品！</span>
								<%}else{ %>
								 以下 <strong><%=list.size() %></strong> 条结果<hr/>						
								<%
									for(int m=0;m<list.size();m++){
								%>
                                            <table border="0" cellspacing="0" class="searchtable">
                                                <tr>
                                                    <td width="20%" rowspan="2">
                                                        <div class="divbookpic">
                                                            <p>
                                                                <a href="searchservlet?type=search&gid=<%=list.get(m).getGid()%>&keyword=<%=keyword%>">
                                                                    <img src="bookcover/<%=list.get(m).getGimg() %>.jpg" width="115" height="129" border="0" /></a></p>
                                                        </div>
                                                    </td>
                                                    <td colspan="2">
                                                        <font class="bookname"><%=list.get(m).getGtitle() %></font><br />
                                                        作者：<%=list.get(m).getGauthor() %> 著<br />
                                                      <%=list.get(m).getGdesc() %>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        售价：<font color="#FF0000">￥<%=list.get(m).getGsaleprice() %>.00</font>&nbsp;&nbsp;&nbsp;&nbsp;原价：<s>￥<%=list.get(m).getGinprice() %>.00</s>
                                                    </td>
                                                    <td style="text-align: right">
                                                        <a href="gouwucheservlet?type=searchbuy&gid=<%=list.get(m).getGid()%>">
                                                            <img src="images/buy.gif" width="91" height="27" border="0" style="margin-bottom: -8px" /></a>
                                                    </td>
                                                </tr>
                                            </table>
                                           <%}} %>
                                           
                        
                                        </td>
                                    </tr>
                                </table>
                       
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
    </div>
    
    
   <%@include file="footer.jsp" %>
</body>
</html>