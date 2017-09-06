<%@page import="java.util.ArrayList"%>
<%@page import="com.google.gson.reflect.TypeToken"%>
<%@page import="org.lanqiao.entity.Goods"%>
<%@page import="org.lanqiao.service.impl.GoodsServiceImpl"%>
<%@page import="org.lanqiao.service.GoodsService"%>
<%@page import="org.lanqiao.entity.Che"%>
<%@page import="com.google.gson.Gson"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<meta content="all" name="robots"/>
<meta name="author" content="Fisher" />
<meta name="Copyright" content="Copyright 2007-2008, 版权所有 www.reefdesign.cn" />
<meta name="description" content="reefdesign" />
<meta name="keywords" content="reefdesign" />
<title>电子书城</title>
<link rel="shortcut icon" href="favicon.ico" >
<link rel="stylesheet" rev="stylesheet" href="css/style.css" type="text/css" media="all" />
<script type="text/javascript">
window.onload=function(){
	
}
</script>
</head>

<body class="main">

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

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
      </table></td>
      <td><div style="text-align:right; margin:5px 10px 5px 0px"><a href="indexservlet">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;购物车</div>
        <% 
        TypeToken<List<Che>> listType = new TypeToken<List<Che>>() { };
        	Gson gson=new Gson();
        	String cid=request.getAttribute("cid").toString();
			String pageIndex=request.getAttribute("pageIndex").toString();
			int sum=0;
			Cookie[] cookies=request.getCookies();
			Cookie cookie=null;
			for(Cookie c:cookies){
				if(c.getName().equals("che")){
					cookie=c;
				}
			}
		
        %>
        <table cellspacing="0" class="infocontent">
        <tr>
          <td><img src="ad/page_ad.jpg" width="666" height="89" />
            <table width="100%" border="0" cellspacing="0">
              <tr>
                <td><img src="images/buy1.gif" width="635" height="38" /></td>
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
             
                    <td width="10%"><a href="#">取消</a></td>
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
                      
                      <td width="10%"><a href="gouwucheservlet?type=remove&gid=<%=goods.getGid() %>" style="color:#FF0000; font-weight:bold">X</a></td>
                    </tr>
                  </table>
                  <span style="display: none;"><%=sum=sum+goods.getGinprice()*che.getNumber() %></span>
                  <%}} %>
				  
				   <table cellspacing="1" class="carttable">
                     <tr>
                       <td style="text-align:right; padding-right:40px;"><font style="color:#FF6600; font-weight:bold">合计：&nbsp;&nbsp;￥<%=sum %>.00元</font></td>
                      </tr>
                   </table>
				   <div style="text-align:right; margin-top:10px"><a href="goodsservlet?type=goods&cid=<%=cid %>&pageIndex=<%=pageIndex%>"><img src="images/gwc_jx.gif" border="0" /></a>&nbsp;&nbsp;&nbsp;&nbsp;<%if(cookie!=null){ %><a href="orderservlet"><img src="images/gwc_buy.gif" border="0" /></a><%}else{%><img src="images/gwc_buy.gif" border="0" onclick="alert('请先选择要购买的商品,至少一件')"/> <%}%></div>
				  
				  </td>
              </tr>
            </table></td>
        </tr>
      </table></td>
    </tr>
  </table>
</div>



<%@include file="footer.jsp" %>


</body>
</html>
