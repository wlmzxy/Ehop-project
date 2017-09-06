<%@page import="org.lanqiao.entity.Goods"%>
<%@page import="org.lanqiao.entity.PageInfo"%>
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
    	PageInfo<Goods> pageInfo=(PageInfo<Goods>)request.getAttribute("pageInfo");
   		List<Goods> list= pageInfo.getDatas();
    	String cname=(String)request.getAttribute("cname");
  %>
        <table width="100%" border="0" cellspacing="0">
            <tr>
                <td>
                    <div style="text-align: right; margin: 5px 10px 5px 0px">
                        <a href="indexservlet">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;<%=cname%></div>
                    <table cellspacing="0" class="infocontent">
                        <tr>
                            <td>
                                <table width="100%" border="0" cellspacing="0">
                                    <tr>
                                        <td style="padding: 10px">
                                            以下 <strong><%=pageInfo.getTotalNumber() %></strong> 条结果按 <strong>商品ID</strong> 排列 每页显示<strong><%=pageInfo.getDatas().size() %></strong>条<hr />
								<%
									for(int m=0;m<list.size();m++){
								%>
                                            <table border="0" cellspacing="0" class="searchtable">
                                                <tr>
                                                    <td width="20%" rowspan="2">
                                                        <div class="divbookpic">
                                                            <p>
                                                                <a href="goodsservlet?type=goodsdetail&gid=<%=list.get(m).getGid()%>&cid=<%=list.get(m).getCid()%>&pageIndex=<%=pageInfo.getPageIndex()%>">
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
                                                        <a href="gouwucheservlet?cid=<%=list.get(m).getCid() %>&pageIndex=<%=pageInfo.getPageIndex()%>&gid=<%=list.get(m).getGid()%>">
                                                            <img src="images/buy.gif" width="91" height="27" border="0" style="margin-bottom: -8px" /></a>
                                                    </td>
                                                </tr>
                                            </table>
                                           <%} %>
                                           
                                            <div class="pagination">
                                                <ul>
                                                <li id="pageIndex" style="display: none;"><%=pageInfo.getPageIndex() %> </li>
                                                <%if(pageInfo.getPageIndex()==1||list.size()==0){ %>
                                                    <li class="disablepage"><< 上一页 </li>
                                                    <%if(list.size()==0){ %>
                                                  	 <li class="currentpage">1</li>
                                                  	 <%}%>
                                                    <%}else{ %>
                                                     <li class="disablepage"><a href="goodsservlet?type=goods&cid=<%=list.get(0).getCid()%>&pageIndex=<%=pageInfo.getPageIndex()-1%>"><< 上一页</a></li>
                                                     <%}%>
                                                     
                                                     <%if(pageInfo.getTotalPages()>10){
                                                    	 if(1<=pageInfo.getPageIndex()&&pageInfo.getPageIndex()<=10){
                                                     	for(int k1=1;k1<=10;k1++){
                                                     		if(k1==pageInfo.getPageIndex()){%>
                                                     		<li class="currentpage"><%=k1 %></li>
                                                     	<%}else{ %>
                                                   		 	<li><a href="goodsservlet?type=goods&cid=<%=list.get(0).getCid()%>&pageIndex=<%=k1%>"><%=k1 %></a></li>
                                                   		 <%}}}
                                                     	if(11<=pageInfo.getPageIndex()&&pageInfo.getPageIndex()<=pageInfo.getTotalPages()){
                                                     		for(int k2=11;k2<=pageInfo.getTotalPages();k2++){
                                                     		if(k2==pageInfo.getPageIndex()){%>
                                                     			<li class="currentpage"><%=k2 %></li>
                                                     	<%}else{ %>
                                              					 <li><a href="goodsservlet?type=goods&cid=<%=list.get(0).getCid()%>&pageIndex=<%=k2%>"><%=k2 %></a></li>
                                       
                                                     	<%}}}}else{
                                                    	 for(int k=1;k<=pageInfo.getTotalPages();k++){ 
                                                    	 	if(k==pageInfo.getPageIndex()){%>
                                                     		<li class="currentpage"><%=k %></li>
                                                     	<%}else{ %>
                                                   		 <li><a href="goodsservlet?type=goods&cid=<%=list.get(0).getCid()%>&pageIndex=<%=k%>"><%=k %></a></li>
                                                   		 <%}}} %>
                                              		<%if(pageInfo.getPageIndex()==pageInfo.getTotalPages()||list.size()==0){ %>
                                                    <li class="disablepage">下一页  >></li>
                                                    <%}else{ %>
                                                     <li class="nextpage"><a href="goodsservlet?type=goods&cid=<%=list.get(1).getCid()%>&pageIndex=<%=pageInfo.getPageIndex()+1%>">下一页 >></a></li>
                                                     <%} %>
                                                     
                                                </ul>
                                            </div>
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