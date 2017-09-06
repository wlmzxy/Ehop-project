<%@page import="org.lanqiao.entity.Goods"%>
<%@page import="org.lanqiao.dao.impl.GoodsDaoImpl"%>
<%@page import="org.lanqiao.dao.GoodsDao"%>
<%@page import="org.lanqiao.entity.OrderDetail"%>
<%@page import="org.lanqiao.entity.Order"%>
<%@page import="com.google.gson.reflect.TypeToken"%>
<%@page import="com.google.gson.Gson"%>
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
  <table width="100%" border="0" cellspacing="0">
    <tr>
      <td width="25%">

		<% 
			String li=request.getSession().getAttribute("orderlist").toString();
			Gson gson=new Gson();
			TypeToken<List<OrderDetail>> listToken=new TypeToken<List<OrderDetail>>(){};
			List<OrderDetail> list=gson.fromJson(li, listToken.getType());
			
		%>
      </td>
      <td><div style="text-align:right; margin:5px 10px 5px 0px"><a href="indexservlet">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;<a href="myuserservlet">&nbsp;我的帐户</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;<a href="orderdetailservlet">订单查询</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;订单详情</div>
        
		 <table cellspacing="0" class="infocontent">
        <tr><td>
 			<table width="100%" border="0" cellspacing="0" class="tableopen">
              <tr>
                <td bgcolor="#A3E6DF" class="tableopentd01">ID</td>
                <td bgcolor="#A3E2E6" class="tableopentd01">商品名称</td>
                <td bgcolor="#A3D7E6" class="tableopentd01">价格</td>
                <td bgcolor="#A3CCE6" class="tableopentd01">数量</td>
                <td bgcolor="#A3B6E6" class="tableopentd01">订单编号</td>
              </tr>
              <%for(int m=0;m<list.size();m++){ 
            	  GoodsDao dao=new GoodsDaoImpl();
            	  Goods goods=dao.getGoodsByGtitle(list.get(m).getGtitle());
              %>
              <tr>
                <td class="tableopentd02"><%=list.get(m).getOrderdetailid() %></td>
                <td class="tableopentd02"> <a href="detailservlet?gid=<%=goods.getGid()%>"><%=list.get(m).getGtitle() %></a></td>
                <td class="tableopentd02"><%=list.get(m).getGsalprice()%></td>
                <td class="tableopentd02"><%=list.get(m).getGnumber()%></td>
                <td class="tableopentd03"><%=list.get(m).getOrderid() %></td>
              </tr>
              <%} %>
            </table></td>
        </tr>
      </table>
	  
	  
	  </td>
    </tr>
  </table>
</div>



<%@include file="footer.jsp" %>


</body>
</html>