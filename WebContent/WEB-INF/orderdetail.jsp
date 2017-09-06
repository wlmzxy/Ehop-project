<%@page import="java.util.ArrayList"%>
<%@page import="org.lanqiao.dao.impl.OrderDaoImpl"%>
<%@page import="org.lanqiao.dao.OrderDao"%>
<%@page import="org.lanqiao.service.impl.GoodsServiceImpl"%>
<%@page import="org.lanqiao.service.GoodsService"%>
<%@page import="org.lanqiao.service.impl.UserServiceImpl"%>
<%@page import="org.lanqiao.service.UserService"%>
<%@page import="org.lanqiao.entity.Order"%>
<%@page import="java.util.List"%>
<%@page import="org.lanqiao.service.impl.OrderServiceImpl"%>
<%@page import="org.lanqiao.service.OrderService"%>
<%@page import="org.lanqiao.entity.User"%>
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
<%@include file="islogin.jsp" %>
<%@include file="header.jsp" %>


<div id="divpagecontent">
  <table width="100%" border="0" cellspacing="0">
    <tr>
      <td width="25%"><table width="100%" border="0" cellspacing="0" style="margin-top:30px">
        <tr>
          <td class="listtitle">我的帐户</td>
        </tr>
        <tr>
          <td class="listtd"><img src="images/miniicon.gif" width="9" height="6" />&nbsp;&nbsp;&nbsp;&nbsp;
		  <a href="updateuserservlet">用户信息修改</a></td>
        </tr>
		
<tr>
          <td class="listtd"><img src="images/miniicon.gif" width="9" height="6" />&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="orderdetailservlet">订单查询</a></td>
        </tr>
<tr>
          <td class="listtd"><img src="images/miniicon.gif" width="9" height="6" />&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="news.html">帐户余额</a></td>
        </tr>
<tr>
          <td class="listtd"><img src="images/miniicon.gif" width="9" height="6" />&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="news.html">我的收藏</a></td>
        </tr>

		<% 
			User user1=(User)request.getSession().getAttribute("user");
			OrderService os=new OrderServiceImpl();
			UserService us=new UserServiceImpl();
			GoodsService gs=new GoodsServiceImpl();
			List<Order> list=os.getOrderByUserid(user1.getUserid());
			List<String> list3=new ArrayList<String>();
			for(int k=0;k<list.size();k++){
				if(list3.size()==0){
					list3.add(list.get(k).getOrderid());
				}
				String string=null; 
				for(int j=0;j<list3.size();j++){
					if(list3.get(j).equals(list.get(k).getOrderid())){
					string=list.get(k).getOrderid();
				}
			}
				if(string==null){
					list3.add(list.get(k).getOrderid());
				}
		}
			
			
		%>
      </table></td>
      <td><div style="text-align:right; margin:5px 10px 5px 0px"><a href="indexservlet">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;<a href="myuserservlet">&nbsp;我的帐户</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;订单查询</div>
        
		 <table cellspacing="0" class="infocontent">
        <tr>
          <td style="padding:20px"><p>欢迎<%=user1.getUloginid() %>光临Eshop商城！</p>
            <p>您已经成交了0笔交易，有<font style="color:#FF0000"><%=list3.size() %></font>项交易正在处理中...</p>
            <table width="100%" border="0" cellspacing="0" class="tableopen">
              <tr>
                <td bgcolor="#A3E6DF" class="tableopentd01">订单号</td>
                <td bgcolor="#A3E2E6" class="tableopentd01">订单内容</td>
                <td bgcolor="#A3D7E6" class="tableopentd01">收件人</td>
                <td bgcolor="#A3CCE6" class="tableopentd01">订单时间</td>
                <td bgcolor="#A3B6E6" class="tableopentd01">状态</td>
              </tr>
              <%for(int m=0;m<list3.size();m++){ 
            	  OrderDao dao=new OrderDaoImpl();
            	  List<Order> list2=dao.getOrderByOrderid(list3.get(m));
              %>
              <tr>
                <td class="tableopentd02"><a href="shopservlet?orderid=<%=list3.get(m)%>"><%=list3.get(m)%></a></td>
                <td class="tableopentd02">
                <%for(int i=0;i<list2.size();i++){ %>
                <a href="detailservlet?gid=<%=list2.get(i).getGid() %>"><%=gs.getGoods(list2.get(i).getGid()).getGtitle() %></a>
              	<%if(i<list2.size()-1){ %><font color="red"><b>、</b></font><%} %>
              	<%} %>
                </td>
                <td class="tableopentd02"><%=us.getUserByUserid(list2.get(0).getUserid()).getUloginid() %></td>
                <td class="tableopentd02"><%=list.get(m).getOrderdate() %></td>
                <td class="tableopentd03">已发货</td>
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
