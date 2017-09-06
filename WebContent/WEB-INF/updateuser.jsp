<%@page import="org.lanqiao.entity.PasswordAnswer"%>
<%@page import="org.lanqiao.service.impl.PasswordAnswerServiceImpl"%>
<%@page import="org.lanqiao.service.PasswordAnswerService"%>
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
<script type="text/javascript">
window.onload=function(){
	document.getElementById("img").onclick=function(){
		this.src="codesservlet?id="+Math.random();
	}
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
          <td class="listtitle">我的帐户</td>
        </tr>
        <tr>
          <td class="listtd"><img src="images/miniicon.gif" width="9" height="6" />&nbsp;&nbsp;&nbsp;&nbsp;
		  <a href="updateuserservlet?type=update">用户信息修改</a></td>
        </tr>
		
<tr>
          <td class="listtd"><img src="images/miniicon.gif" width="9" height="6" />&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="orderlist.html">订单查询</a></td>
        </tr>
<tr>
          <td class="listtd"><img src="images/miniicon.gif" width="9" height="6" />&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="#">帐户余额</a></td>
        </tr>
<tr>
          <td class="listtd"><img src="images/miniicon.gif" width="9" height="6" />&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="#">我的收藏</a></td>
        </tr>

		
		
		
		
		
		
		
		
		
		
		
		<%
		  User user=(User)request.getSession().getAttribute("user");
		  PasswordAnswerService ps=new PasswordAnswerServiceImpl();
		  PasswordAnswer pa=ps.getPasswordAnswerByUserid(user.getUserid());
		  %>
		
		
		
      </table></td>
      <td><div style="text-align:right; margin:5px 10px 5px 0px"><a href="indexservlet">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;<%=user.getUloginid() %>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;用户信息修改</div>
        
		
		
		
		<form action="updateuserservlet"method="post">
        <table cellspacing="0" class="infocontent">
        <tr>
          <td>
		  <table width="100%" border="0" cellspacing="2" class="upline">
  <tr>
    <td style="text-align:right; width:20%">会员邮箱：</td>
    <td style="width:40%; padding-left:20px"><%=user.getUemail() %></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td style="text-align:right">会员名：</td>
    <td style="padding-left:20px"><%=user.getUloginid() %></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td style="text-align:right">修改密码：</td>
    <td><input type="password" class="textinput"value="<%=user.getUpassword() %>" name="password1" /></td>
    <td><font color="#999999">密码设置至少6位，请区分大小写</font></td>
  </tr>
  <tr>
    <td style="text-align:right">重复密码：</td>
    <td><input type="password" class="textinput"value="<%=user.getUemail() %>" name="password2"/></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td style="text-align:right">性别：</td>
    <%if(user.getUsex().equals("男")){ %>
    <td colspan="2">&nbsp;&nbsp;<input type="radio" name="sex" value="男" checked="checked"/>
      男
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="sex" value="女" />
女</td>
<%}else{ %>
 <td colspan="2">&nbsp;&nbsp;<input type="radio" name="sex" value="男" />
      男
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="sex" value="女" checked="checked"/>
女</td>
<%} %>
    </tr>
  <tr>
    <td style="text-align:right">联系方式：</td>
    <td colspan="2"><input name="tel" type="text" class="textinput"value="<%=user.getUtel() %>"/></td>
  </tr>
  <tr>
    <td style="text-align:right">发货地址：</td>
    <td colspan="2"><input name="address" type="text" class="textinput" style="width:350px"value="<%=user.getUaddress() %>"/></td>
    </tr>
  <tr>
    <td style="text-align:right">&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
</table>
		  
		  
		  
		  <table width="100%" border="0" cellspacing="2" class="upline">
		  <tr style="display: none;"><td colspan="3">
		  <input type="text"name="answerid" value="<%=pa.getAnswerid() %>"/>
		  </td></tr>
            <tr>
              <td width="16%" style="text-align:right; width:20%">密码保护问题：</td>
              <td width="47%" style="width:50%"><select name="passwordprotect" class="textinput" style="width:230px; height:20px">
                  <option value="<%=pa.getAquestion()%>"><%=pa.getAquestion() %></option>
                  <option value="您的宠物的名字？" >您的宠物的名字？</option>
                  <option value="您就读的第一所学校的名称？" >您就读的第一所学校的名称？</option>
                  <option value="少年时代心目中的英雄是谁？" >少年时代心目中的英雄是谁？</option>
                  <option value="您最喜欢的休闲运动是什么？" >您最喜欢的休闲运动是什么？</option>
                  <option value="您最喜欢哪支运动队？" >您最喜欢哪支运动队？</option>
                  <option value="您最喜欢的运动员是谁？" >您最喜欢的运动员是谁？</option>
                  <option value="您的第一辆汽车或自行车是什么牌子的？" >您的第一辆汽车或自行车是什么牌子的？</option>
                </select>
              </td>
              <td>&nbsp;</td>
            </tr>
            <tr>
              <td style="text-align:right">答案：</td>
              <td colspan="2"><input name="answer" type="text" class="textinput" value="<%=pa.getAnswer()%>"/>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <font color="#999999">不能少于4个字符，不区分大小写</font></td>
            </tr>
            <tr>
              <td style="text-align:right">备用邮箱：</td>
              <td><input name="backupemail" type="text" class="textinput" value="<%=pa.getEmail() %>"/></td>
              <td>&nbsp;</td>
            </tr>
            <tr>
              <td style="text-align:right">&nbsp;</td>
              <td>&nbsp;</td>
              <td>&nbsp;</td>
            </tr>
          </table>
		  <table width="100%" border="0" cellspacing="2" class="upline">
            <tr>
              <td style="text-align:right; width:20%">输入校验码：</td>
              <td style="width:50%"><input name="yzm" type="text" class="textinput"/></td>
              <td><img alt="" src="codesservlet"id="img"></td>
            </tr>
            <tr>
              <td style="text-align:right">&nbsp;</td>
              <td>&nbsp;</td>
              <td>看不清？点击图片换一张</td>
            </tr>
          </table>
		  
		  <p style="text-align:center"><input  type="image"src="images/botton_gif_025.gif" border="0" /></p>
		  <p style="text-align:center">&nbsp;</p></td>
        </tr>
      </table></form>
      </td>
    </tr>
  </table>
</div>



<%@include file="footer.jsp" %>


</body>
</html>