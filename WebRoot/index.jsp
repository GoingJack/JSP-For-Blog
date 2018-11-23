<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html >
  <head>
    <base href="<%=basePath%>">
    
    <title>欢迎访问</title>
	<meta http-equiv="pragma" content="no-cache"><!--把 content 属性关联到 HTTP 头部。-->
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  <style type="text/css">    
     body{    
        background-image: url(src/bkground.jpg);    
        background-size:cover;  
     }    
 </style> 
  <body>		
    <center><h2>欢迎访问我的个人博客</h2><br></center>
    <center>
    <br>
    <br>
    <table cellpadding="30" >
		<tr>
		<td ><h3><a href="root_login.jsp"><font size=5>博主登录     </font></a></h3></td>
		<td > <h3><a href="visitor_login.jsp"><font size=5>游客登录     </font></a></h3></td>
		<td ><h3><a href="visitor_reg.jsp"><font size=5>游客注册</font></a></h3></td>
		</tr>
</table></center>
  </body>
</html>