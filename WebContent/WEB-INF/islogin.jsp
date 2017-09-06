<%@page import="org.lanqiao.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
User user=(User)request.getSession().getAttribute("user");
if(user==null){
%>
<jsp:forward page="yzloginservlet">
<jsp:param value="请先登录账号后，再购买商品" name="islogin"/>
</jsp:forward>
<%}%>