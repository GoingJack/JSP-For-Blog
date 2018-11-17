<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'visitor_beginshow.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
    	<%
		if(session.getAttribute("userid")!=null)
		{
			// 用户已登陆
		%>
			<h2>登陆成功</h2>
			<h2>欢迎<font color="red" size="12">
				<%=session.getAttribute("userid")%>
			</font>光临admin博客</h2>
		<%
		}
		else
		{
			// 用户未登陆，提示用户登陆，并跳转
			response.setHeader("refresh","2;URL=visitor_login.jsp") ;
		%>
			您还未登陆，请先登陆！！！<br>
			两秒后自动跳转到登陆窗口！！！<br>
			如果没有跳转，请按<a href="visitor_login.jsp">这里</a>！！！<br>
		<%
			}
		%>
  <body>
    This is visitor_beginshow page. <br>
  </body>
</html>
