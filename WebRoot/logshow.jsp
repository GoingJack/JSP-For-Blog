<%@ page language="java" import="java.util.*" import="com.log.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'logshow.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <center>
		<%
		if(request.getSession().getAttribute("userid")==null){		
			// 用户未登陆，提示用户登陆，并跳转
			response.setHeader("refresh","2;URL=login.jsp") ;
		%>
			您还未登陆，请先登陆！！！<br>
			两秒后自动跳转到登陆窗口！！！<br>
			如果没有跳转，请按<a href="login.jsp">这里</a>！！！<br>
	<%
		}
	%>
	<%// 接收参数
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			String title = null;
			String log_details=null;
			List reviews=null;
			try{
				title = request.getParameter("title") ;
			}catch(Exception e){
				}
			logInfo log = null ;
			try{
				log_behavior log_b=new log_behavior();
				log_details = log_b.getBytitle(title);
				reviews=log_b.queryreview(title);
			}catch(Exception e){
				e.printStackTrace();
				} %>
	<form action="logshow.jsp" method="post">
		<table  style="width: 700px; ">
		<tr>
			<td align="center" border=3 colspan="2"><h3><%=title%></h3></td>
		</tr>
		<tr>
			<td align="center" colspan="2"><%=log_details %></td>
		</tr>
		<tr>
			<td align="center" border=3 colspan="2"><h4>评论列表</h4></td>
		</tr>
		<tr>
			<td align="left" width="70%">
			<%
				for(int i=0;i<reviews.size();i++){
				log_review log_r = (log_review)reviews.get(i);
				// 进行循环打印，打印出所有的内容，以表格形式
				// 从数据库中取出内容
				String details = log_r.getdetails() ;
			%>
				<%=details %>
				</td>
				<td width="30%" align="right"><%String id = log_r.getid();%><%=id %></td>
				<%}%>
		</tr>
		</table>
	</form>
	</center>
  </body>
</html>
