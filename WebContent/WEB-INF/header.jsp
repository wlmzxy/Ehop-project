<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="org.lanqiao.entity.Category"%>
<%@page import="org.lanqiao.service.impl.CategoryServiceImpl"%>
<%@page import="org.lanqiao.service.CategoryService"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- Logo -->
<div id="divhead">
  <table cellspacing="0" class="headtable">
    <tr>
      <td><a href="index.jsp"><img src="${pageContext.request.contextPath}/images/logo.gif" width="95" height="30" border="0" /></a></td>
      <td style="text-align:right"><img src="${pageContext.request.contextPath}/images/cart.gif" width="26" height="23" style="margin-bottom:-4px"/>&nbsp;<a href="gouwucheservlet">购物车</a>　|　<a href="#">帮助中心</a>　|　<a href="yzloginservlet">我的帐户</a>　|　<a href="newuserservlet?type=newuser">新用户注册</a></td>
    </tr>
  </table>
</div>
<!-- Logo end -->
<!-- menu -->
<div id="divmenu">
	<%
			CategoryService cs=new CategoryServiceImpl();
			List<Category> list1 =cs.list();
			for(int j=0;j<list1.size();j++){
	%>
	 <a href="goodsservlet?type=goods&cid=<%=list1.get(j).getCid()%>"><%=list1.get(j).getCname() %></a>　　　
   <%} %>
   　<a href="product_list.html" style="color:#FFFF00">全部商品目录</a>
</div>
<!-- menu end -->
<!-- search -->
<div id="divsearch"><table width="100%" border="0" cellspacing="0">
  <tr>
    <td style="text-align:right; padding-right:220px;">
    <form action="searchservlet" method="post">
    Search
  <input type="text" name="keyword" class="inputtable" list="ds" id="search"/>
  <datalist id="ds"></datalist>
  <input type="image" src="${pageContext.request.contextPath}/images/serchbutton.gif" border="0" style="margin-bottom:-4px"/></form></td>
  </tr>
  <script type="text/javascript">
  document.getElementById("search").oninput=function(){
		//1、创建XMLHttpRequest;
		var xmlhttp = new XMLHttpRequest();
		//2、创建一个http请求 ；
		var keyword = document.querySelector('#search').value;
		var url ="searchajax" ;
		xmlhttp.open("post", url, true);
		//3、发送请求
		var data="keyword="+keyword;
		//设置http请求头;
		xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
		xmlhttp.send(data);
		//4、取数据;
		xmlhttp.onreadystatechange=function (){
			if(xmlhttp.readyState==4 && xmlhttp.status==200){
			var text = xmlhttp.responseText; //拿到的就String;
			if(text==!null){
			//将String转成JSON对象
			var json = JSON.parse(text);//[]
			alert(json);
			var options="";
			for(var i=0;i<json.length;i++){
				options+="<option value='"+ json[i].key +"'/>";
			}
			var ds = document.querySelector('#ds');
			ds.innerHTML=options;
			}
			}
		}
	}
  </script >
</table>

</div>

<!-- search end -->