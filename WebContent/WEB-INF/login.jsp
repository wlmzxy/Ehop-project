<%@page import="org.lanqiao.service.impl.UserServiceImpl"%>
<%@page import="org.lanqiao.service.UserService"%>
<%@page import="org.lanqiao.entity.User"%>
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
<script type="text/javascript" src="jquery-3.2.1.js"></script>
<script type="text/javascript">
$(function(){
	var value=$("#loginvalue").text();
	if(value=="-1"){
		alert('用户名不存在！');
	}else if(value=="0"){
		alert('此用户未激活！');
	}else if(value=="1"){
		alert('用户名或密码错误！');
	}else if(value=="2"){
		alert('密码已修改，请重新登录！');
}else if(value=="-3"){
	alert('密码不能为空！');
}
})
	</script>
</head>

<body class="main">

<%@include file="header.jsp" %>

<div id="divcontent">

<%
	Cookie[] cookies=request.getCookies();
	Cookie cookie1=null;
	Cookie cookie2=null;
	Cookie cookie3=null;
	User user=null;
	String password=null;
	for(Cookie c:cookies){
		if(c.getName().equals("uloginid")){
			cookie1=c;}
		if(c.getName().equals("upassword")){
			cookie2=c;}
		if(c.getName().equals("loginvalue")){
			cookie3=c;}
}
	if(cookie1!=null){
		UserService us=new UserServiceImpl();
		user=us.getUserByLoginid(cookie1.getValue());
		if(user!=null){
		password=user.getUpassword();
		}
	}
	if(cookie3!=null){ 
%>
<span id="loginvalue" style="display: none;"><%=cookie3.getValue() %></span>
<%}else{ %>
<span id="loginvalue" style="display: none;">5</span>
<%} %>
<table width="900px" border="0" cellspacing="0">
  <tr>
    <td style="padding:30px"><div style="height:470px"><b>&nbsp;&nbsp;<a href="indexservlet">首页</a>&nbsp;&raquo;&nbsp;个人用户登录</b>
          <div>
            <table width="85%" border="0" cellspacing="0">
              <tr>
                <td><div id="logindiv">
 
                <%
                if(cookie1==null||cookie2==null||user==null||password==null||cookie2.getValue().equals(password)==false){%>
                <form action="loginservlet" method="post">
                	<table width="100%" border="0" cellspacing="0">
                      <tr>
                        <td style="text-align:center; padding-top:20px"><img src="images/logintitle.gif" width="150" height="30" /></td>
                      </tr>
                      <tr>
                        <td style="text-align:center"><table width="80%" border="0" cellspacing="0" style="margin-top:15px ;margin-left:auto; margin-right:auto">
                            <tr>
                              <td style="text-align:right; padding-top:5px; width:25%">用户名：</td>
                              <td style="text-align:left"><input name="uloginid" type="text" class="textinput"/></td>
                            </tr>
                            <tr>
                              <td style="text-align:right; padding-top:5px">密&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
                              <td style="text-align:left"><input name="upassword" type="text" class="textinput"/></td>
                            </tr>
                            <tr>
                              <td colspan="2" style="text-align:center"><input type="checkbox" name="checkbox" value="checkbox" />
                                &nbsp;&nbsp;记住我的登录状态<font size="-1"color="red">(七天内有效)</font></td>
                            </tr>
                            <tr>
                              <td colspan="2" style="padding-top:10px; text-align:center"><input type="image" src="images/loginbutton.gif" width="83" height="22"/></td>
                            </tr>
                            <tr>
                              <td colspan="2" style="padding-top:10px; text-align:center">登录帮助&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;帮助中心&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;忘记密码</td>
                            </tr>
                            <tr>
                              <td colspan="2" style="padding-top:10px"><img src="images/loginline.gif" width="241" height="10" /></td>
                            </tr>
                            <tr>
                              <td colspan="2" style="padding-top:10px; text-align:center"><a href="newuserservlet?type=newuser"><img src="images/signupbutton.gif" width="135" height="33"/></a></td>
                            </tr>
                        </table></td>
                      </tr>
                    </table></form>
                    <%}else{ %>
                    	<div style="text-align: center;padding:auto;"><span style="padding:100px auto;">欢迎<a href="myuserservlet"><%= user.getUloginid() %></a>登录,点击用户名进入</span></div>
                    <%} %>
                </div></td>
                <td style="text-align:left; padding-top:30px; width:60%"><h1>您还没有注册？</h1>
                    <p>注册新会员，享受更优惠价格!</p>
                  <p>千种图书，供你挑选！注册即享受丰富折扣和优惠，便宜有好货！超过万本图书任您选。</p>
                  <p>超人气社区！精彩活动每一天。买卖更安心！支付宝交易超安全。</p>
                  <p style="text-align:right">
                  <a href="newuserservlet?type=newuser"><img alt="" src="images/signupbutton.gif" width="135" height="33"/></a>
                  </p></td>
              </tr>
            </table>
          </div>
    </div></td>
  </tr>
</table>
</div>



<%@include file="footer.jsp" %>


</body>
</html>
