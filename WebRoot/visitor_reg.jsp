<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>游客注册</title>
    <script src=./src/isRight.js>
    </script>
    
	<meta http-equiv="pragma" content="no-cache">
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
   
  <a href="index.jsp">返回首页</a>
    <center><h1>游客注册</h1></center>
    <form action="VisitorServlet" method="post" onsubmit="return checkAll()">
    	<table  align="center" width="500">
    		<tr>
    			<td align="right" width="30%">用户名</td>
    			<td><input type="text" class="box" name="visitorid" id="visitorid" onblur=checkName()></td>
    			<td ><p id="namespan"></p></td>
    		</tr>
    		<tr>
    			<td align="right" width="30%">密码</td>
    			<td><input type="password" class="box" name="visitorpwd" id="password" onblur=checkPasswd()></td>
    			<td ><p id="passwdspan"></p></td>
    		</tr>
    		<tr>
    			<td align="right" width="30%">确认密码</td>
    			<td><input type="password" class="box" name="revisitorpwd" id="repassword" onblur=checkSame()></td>
    			<td ><p id="repasswdspan"></p></td>
    		</tr>
    		<tr>
    			<td align="right" width="30%">昵称</td>
    			<td><input type="text" class="box" name="visitorname" id="Nicheng" onblur=checkNicheng()></td>
    			<td ><p id="Nichengspan"></p></td>
    		</tr>
    		<tr>
    			<td colspan="2" align="center">
    				<input type="submit" value="注册" onclick="isNull">
    				<input type="reset" value="重置">
  				</td>
  			</tr>
  		</table>
  	</form>  
  </body>
</html>
