<%@page import="org.lanqiao.entity.News"%>
<%@page import="org.lanqiao.service.impl.NewsServiceImpl"%>
<%@page import="org.lanqiao.service.NewsService"%>
<%@page import="org.lanqiao.dao.NewsDao"%>
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
      <td width="25%"><table width="100%" border="0" cellspacing="0" style="margin-top:30px">
        <tr>
          <td class="listtitle">配送方式、时间及费用</td>
        </tr>
        <tr>
          <td class="listtd"><img src="images/miniicon.gif" width="9" height="6" />&nbsp;&nbsp;&nbsp;&nbsp;<a href="news.html">普通快递送货上门</a></td>
        </tr>
        <tr>
          <td class="listtd"><img src="images/miniicon.gif" width="9" height="6" />&nbsp;&nbsp;&nbsp;&nbsp; <a href="news.html">特快专递送货上门(EMS)</a></td>
        </tr>
        <tr>
          <td class="listtd"><img src="images/miniicon.gif" width="9" height="6" />&nbsp;&nbsp;&nbsp;&nbsp; <a href="news.html">申通快递送货上门</a></td>
        </tr>
        <tr>
          <td class="listtd"><img src="images/miniicon.gif" width="9" height="6" />&nbsp;&nbsp;&nbsp;&nbsp; <a href="news.html">普通邮寄</a></td>
        </tr>
      </table></td>
      <%
      				NewsService ns=new NewsServiceImpl();
                	String tid=request.getParameter("tid");
                	News news=ns.getNews(tid);
        %>
      <td><div style="text-align:right; margin:5px 10px 5px 0px"><a href="indexservlet">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;公告新闻&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;<%=news.getTitle() %></div>
        
		
		
		
		
        <table cellspacing="0" class="infocontent">
          <tr>
            <td><img src="ad/page_ad.jpg" width="652" height="86" />
              <table width="100%" border="0" cellspacing="0">
                <tr>
                  <td style="padding:10px"><h1><%=news.getTitle() %></h1>&nbsp;&nbsp;&nbsp;&nbsp;<font style="font-size:8px"><%=news.getTpubdate() %></font>
				  <hr style="color:#006600"/>
				  <p>　　《大勇和小花的欧洲日记》串起了欧洲文明的溯源之旅。从屹立在近现代艺术之巅的巴黎拾级而下，依次是蓬皮杜博物馆（现代艺术）、奥塞博物馆（印象派艺术）、卢浮宫博物馆（古典主义）。在这里，蒙娜丽莎向文艺复兴的故乡微笔，那是意大利的佛罗伦萨。达芬奇、米开朗琪罗、拉菲尔等巨匠们开创了文艺复兴运动，他们心中的圣地是希腊，似乎已到了起源。然而，这并未到头，与这源头对接的还有遥远的希腊神话，其中有大西洲的传说。在希腊小岛圣托里尼，你看见Atlantica酒店吗？那是人们为大西洲刻下的念想。在一片一片蓝色和白色延展出去的地方，还有一抹咖啡色的火山岛，那可能是导致大西洲灰飞烟灭的峥嵘。伊亚（OIA）小渔村的白房子高低错落，在爱琴海边上的悬崖峭壁顶上，尽染落日余晖，一片宁静，在黑压压的山崖下，海静波平，邮轮驶过画出一弯弧线，遥远的传说在此时定格。</p>
				  </td>
                </tr>
               
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