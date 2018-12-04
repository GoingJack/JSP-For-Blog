<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>个人信息修改</title>
<script src=./src/isRight.js></script>
</head>
<style type="text/css">    
     body{    
        background-image: url(src/bkground.jpg);    
        background-size:cover;  
     }    
 </style> 
<body>
<a href="index.jsp">返回首页</a>
<center><h1>游客修改个人信息</h1></center>
    <form action="changeInformation" method="post" onsubmit="return checkAll()">
    	<table align="center" width="500">
    		<tr>
    			<td align="right" width="30%">用户名</td>
    			<td><input type="text" class="box" name="rc_visitorid" readOnly="readonly" value=<%=request.getSession().getAttribute("userid") %>></td>
    		</tr>
    		<tr>
    			<td align="right" width="30%">密码</td>
    			<td><input type="password" class="box" name="rc_visitorpwd" id="password" onblur=checkPasswd()></td>
    			<td ><p id="passwdspan"></p></td>
    		</tr>
    		<tr>
    			<td align="right" width="30%">确认密码</td>
    			<td><input type="password" class="box" name="rc_revisitorpwd" id="repassword" onblur=checkSame()></td>
    			<td ><p id="repasswdspan"></p></td>
    		</tr>
    		<tr>
    			<td colspan="2" align="center">
    				<input type="submit" value="修改" onclick="isNull">
    				<input type="reset" value="重置">
  				</td>
  			</tr>
  		</table>
  	</form>  
</body>
</html>