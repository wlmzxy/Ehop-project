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
<link rel="shortcut icon" href="favicon.ico"/>
<link rel="stylesheet" rev="stylesheet" href="css/style.css" type="text/css" media="all" />
<script type="text/javascript" src="jquery-3.2.1/jquery-3.2.1.js"></script>
<script type="text/javascript" src="js/newuser.js">
</script>
</head>
<body class="main">

<%@include file="header.jsp" %>
<div id="divcontent">
<form action="newuserservlet?type=adduser" method="post">
<table width="850px" border="0" cellspacing="0">
  <tr>
    <td style="padding:30px"><h1>新会员注册</h1>
<table width="70%" border="0" cellspacing="2" class="upline">
  <tr>
    <td style="text-align:right; width:20%">会员邮箱：</td>
    <td style="width:40%"><input type="text" class="textinput" name="newuseremail" id="email"/>&nbsp;&nbsp;<span id="checkemail"></span></td>
  </tr>
  <tr>
    <td style="text-align:right">会员名：</td>
    <td><input type="text" class="textinput" name="newusername" id="loginid"/>&nbsp;&nbsp;<span id="checkloginid"></span></td>
  </tr>
  <tr>
    <td style="text-align:right">密码：</td>
    <td><input type="password" class="textinput" name="newuserpassword1" id="newuserpassword1"/>&nbsp;&nbsp;<span id="checkpassword1"></span></td>
  </tr>
  <tr>
    <td style="text-align:right">重复密码：</td>
    <td><input type="password" class="textinput" name="newuserpassword2" id="newuserpassword2"/>&nbsp;&nbsp;<span id="checkpassword2"></span></td>
  </tr>
  <tr>
    <td style="text-align:right">性别：</td>
    <td>&nbsp;&nbsp;<input type="radio" name="newusersex" value="男" id="sex"/>
      男
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="newusersex" value="女" id="sex" />
女&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id="checksex"></span></td>
    </tr>
  <tr>
    <td style="text-align:right">联系方式：</td>
    <td><input name="newusertel" type="text" class="textinput" id="tel"/>&nbsp;&nbsp;<span id="checktel"></span></td>
  </tr>
  <tr>
    <td style="text-align:right">发货地址：</td>
    <td><input name="newuseraddress" type="text" class="textinput" id="address" style="width:350px"/>&nbsp;&nbsp;<span id="checkaddress"></span></td>
    </tr>
  <tr>
    <td style="text-align:right">&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
</table>

<h1>密码保护信息 (以下信息用于取回密码以及处理其他帐户问题，请您慎重填写并牢记)</h1>
<table width="70%" border="0" cellspacing="2" class="upline">
  <tr>
    <td width="16%" style="text-align:right; width:20%">密码保护问题：</td>
    <td width="47%" style="width:50%"><select name="passwordprotect" id="passwordprotect" class="textinput" style="width:230px; height:20px">
<option value="">- 选择一个问题 -</option>
<option value="您的宠物的名字？" >您的宠物的名字？</option>
<option value="您就读的第一所学校的名称？" >您就读的第一所学校的名称？</option>
<option value="少年时代心目中的英雄是谁？" >少年时代心目中的英雄是谁？</option>
<option value="您最喜欢的休闲运动是什么？" >您最喜欢的休闲运动是什么？</option>
<option value="您最喜欢哪支运动队？" >您最喜欢哪支运动队？</option>
<option value="您最喜欢的运动员是谁？" >您最喜欢的运动员是谁？</option>
<option value="您的第一辆汽车或自行车是什么牌子的？" >您的第一辆汽车或自行车是什么牌子的？</option>
    </select>&nbsp;&nbsp;<span id="checkpasswordprotect"></span>    </td>
  </tr>
  <tr>
    <td style="text-align:right">答案：</td>
    <td><input type="text" class="textinput" name="answer" id="answer"/>&nbsp;&nbsp;<span id="checkanswer"></span></td>
    </tr>
    <tr>
    <td style="text-align:right">备用邮箱：</td>
    <td><input type="text" class="textinput" name="backupemail" id="backupemail"/>&nbsp;&nbsp;<span id="checkbackupemail"></span></td>
  </tr>
  <tr>
    <td style="text-align:right">&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
</table>

<h1>注册校验</h1>
<table width="80%" border="0" cellspacing="2" class="upline">
  <tr>
    <td style="text-align:right; width:20%">输入校验码：</td>
    <td style="width:50%"><input type="text" class="textinput" name="yanzhengma" id="yzm"/></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
  	<td> &nbsp;</td>
  	<td>&nbsp;</td>
  	<td><img alt="" src="codesservlet"id="img"></td>
  </tr>
  <tr>
  	<%if(request.getSession().getAttribute("codes")!=null){ %>
    <td><span style="display: none;" id="codes"><%=request.getSession().getAttribute("codes").toString() %></span> </td>
    <%}else{ %>
    <td><span style="display: none;" id="codes"></span></td>
    <%} %>
   <td id="checkyzm"></td>
    <td>看不清？点击图片换一张</td>
  </tr>
</table>

<h1>服务条款</h1>
<table width="70%" border="0" cellspacing="0">
  <tr>
    <td><textarea name="textarea" class="textarea"></textarea></td>
  </tr>
</table>

<table width="70%" border="0" cellspacing="0">
  <tr>
    <td style="padding-top:20px; text-align:center;"><input type="image" src="images/signup.gif"/></td>
  </tr>
</table></td>
    </tr>
</table>
 </form>
</div>


<%@include file="footer.jsp" %>


</body>
</html>
