<%@page import="java.util.Date"%>
<%@page import="org.lanqiao.entity.Goods"%>
<%@page import="org.lanqiao.service.impl.GoodsServiceImpl"%>
<%@page import="org.lanqiao.service.GoodsService"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="org.lanqiao.entity.Che"%>
<%@page import="com.google.gson.reflect.TypeToken"%>
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
          <td class="listtitle">配送方式、时间及费用</td>
        </tr>
        <tr>
          <td class="listtd"><img src="images/miniicon.gif" width="9" height="6" />&nbsp;&nbsp;&nbsp;&nbsp;<a href="news.html">普通快递送货上门</a></td>
        </tr>
		
<tr>
          <td class="listtd"><img src="images/miniicon.gif" width="9" height="6" />&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="news.html">特快专递送货上门(EMS)</a></td>
        </tr>
<tr>
          <td class="listtd"><img src="images/miniicon.gif" width="9" height="6" />&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="news.html">申通快递送货上门</a></td>
        </tr>
<tr>
          <td class="listtd"><img src="images/miniicon.gif" width="9" height="6" />&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="news.html">普通邮寄</a></td>
        </tr>

		<% 
			User us=(User)request.getSession().getAttribute("user");
		 	TypeToken<List<Che>> listType = new TypeToken<List<Che>>() { };
     		Gson gson=new Gson();
			int sum=0;
			Cookie[] cookies=request.getCookies();
			Cookie cookie=null;
			for(Cookie c:cookies){
				if(c.getName().equals("che")){
					cookie=c;
				}
			}
		%>
      </table></td>
      <td><div style="text-align:right; margin:5px 10px 5px 0px"><a href="indexservlet">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;<a href="gouwucheservlet">&nbsp;购物车</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;订单</div>
        
		
		
		
		
        <table cellspacing="0" class="infocontent">
        <tr>
          <td><table width="100%" border="0" cellspacing="0">
              <tr>
                <td><img src="images/buy2.gif" width="635" height="38" />
                  <p>早上好：<%=user.getUloginid() %><%if(user.getUsex().equals("男")){ %>先生<%}else{ %>女士<%} %>！欢迎您来到商城结算中心</p></td>
              </tr>
              <tr>
                <td><table cellspacing="1" class="carttable">
                  <tr>
                    <td width="10%">序号</td>
                    <td width="40%">商品名称</td>
                    <td width="10%">市场价</td>
                    <td width="10%">优惠价</td>
                    <td width="10%">数量</td>
                    <td width="10%">小计</td>
                 </tr>
                </table>
                <%if(cookie!=null){
                	List<Che> list=gson.fromJson(cookie.getValue(),listType.getType());
                	for(int j=0;j<list.size();j++){
                		Che che=list.get(j);
                		String gid=che.getGid();
                		GoodsService gs=new GoodsServiceImpl();
                		Goods goods=gs.getGoods(gid);
                	%>
                  <table width="100%" border="0" cellspacing="0">
                    <tr>
                     <td width="10%"><%=goods.getGid() %></td>
                      <td width="40%"><%=goods.getGtitle() %></td>
                      <td width="10%">￥<%=goods.getGsaleprice() %>.00</td>
                      <td width="10%">￥<%=goods.getGinprice() %>.00</td>
                      <td width="10%"><input name="text" type="text" value="<%=che.getNumber() %>" style="width:20px"/></td>
                      <td width="10%">￥<%=goods.getGinprice()*che.getNumber() %></td>
                      </tr>
                  </table>
                   <span style="display: none;"><%=sum=sum+goods.getGinprice()*che.getNumber() %></span>
                  <%}} %>
				   <table cellspacing="1" class="carttable">
                     <tr>
                       <td style="text-align:right; padding-right:40px;"><font style="color:#FF0000">合计：&nbsp;&nbsp;￥<%=sum %>.00元</font></td>
                      </tr>
                   </table>	   	   
				   
				   <p>收货地址：<input name="text" type="text" value="<%=user.getUaddress() %>" style="width:350px"/>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">【确认】</a><br/>
				   收货人：&nbsp;&nbsp;&nbsp;&nbsp;<input name="text" type="text" value="<%=user.getUloginid() %>" style="width:150px"/>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">【确认】</a><br/>
				   联系方式：<input name="text" type="text" value="<%=user.getUtel() %>" style="width:150px"/>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">【确认】</a>
				   
				   </p>
				  <hr/> 
				   <p style="text-align:right"><%if(cookie!=null){ %><a href="ordersubmitservlet"><img src="images/gif53_029.gif" width="204" height="51" border="0" /></a><%}else{%><img src="images/gif53_029.gif" width="204" height="51" border="0" onclick="alert('订单为空,不能提交!')"/><%} %></p></td>
              </tr>
            </table></td>
        </tr>
      </table></td>
    </tr>
  </table>
</div>



<%@include file="footer.jsp"%>


</body>
</html>
