package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbcon.sqlConnection;


import user.UserInfomation;
import user.visitorlogin;
import user.visitorreg;

@WebServlet(name="visitorServlet",urlPatterns="/VisitorServlet")
public class VisitorServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public VisitorServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//设置编码
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		//表单提交值
		String visitorid = request.getParameter("visitorid");
		String visitorpwd = request.getParameter("visitorpwd");
		
		PrintWriter out = response.getWriter();
		//登录验证
		if(visitorid == null || "".equals(visitorid)){    
			out.println("<script>alert('用户id不能为空')</script>");
			out.println("<a href='visitor_login.jsp'>点击此处返回登陆界面</a>");
		}
		else if(visitorpwd == null || "".equals(visitorpwd)){
			out.println("<script>alert('密码不能为空')</script>");
			out.println("<a href='visitor_login.jsp'>点击此处返回登陆界面</a>");
		}
		else {
		//用户名密码验证通过
		UserInfomation visitor = new UserInfomation();      
		visitor.setUserid(visitorid);      //设置userid
		visitor.setUserpwd(visitorpwd);  //设置userpass
		
		//连接数据库
		
		try{
		Connection conn=null;
		conn=sqlConnection.getCon();
		String sql = "select * from Root_admin";
		PreparedStatement ps=conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			request.getSession().setAttribute("rootid", rs.getString("Username"));
		}
		}catch(Exception e){
			e.printStackTrace();
			}
		try {
			boolean flag = visitorlogin.getinstance().checkVisitor(visitor);
			System.out.println(flag);
			if(flag){ //验证通过  
		        request.getSession().setAttribute("userid", visitor.getUserid());//向会话对象写入数据
		        response.sendRedirect("IndexServlet"); //跳转
			}else{
				System.out.println(flag);
				out.print("<script type='text/javascript'>alert('用户名或者密码错误！');</script>");
				System.out.println(flag);
				out.println("<p>俩秒后返回登陆界面</p>");
				//response.sendRedirect("visitor_login.jsp");
				response.setHeader("refresh", "2;URL=visitor_login.jsp");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			out.flush();
			out.close();
		}
		}
	}


	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置编码
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		//表单提交值
		String visitorid = request.getParameter("visitorid");
		String visitorpwd = request.getParameter("visitorpwd");
		String visitorname = request.getParameter("visitorname");
		String revisitorpwd=request.getParameter("revisitorpasswd");
		
		//将获取的表单值封装到用户信息对象中
		
		UserInfomation visitor = new UserInfomation();
		visitor.setUserid(visitorid);
		visitor.setUserpwd(visitorpwd);
		visitor.setUsername(visitorname);
		PrintWriter out = response.getWriter();
		boolean flag1 = visitorreg.getinstance().isSameidVisitor(visitor);   
		
		
		
		
		//注册结果
		if(flag1==true)
		{
			out.println("<script>alert('你要申请的id已经存在请重新填写！')</script>");
			response.setHeader("refresh","2;URL=visitor_reg.jsp") ;
			out.println("两秒后自动跳转到游客注册界面！！！");
		}
		else if(visitorid==null||"".equals(visitorid))
		{
			out.println("<script>alert('用户id不能为空')</script>");
			response.setHeader("refresh","2;URL=visitor_reg.jsp") ;
			out.println("两秒后自动跳转到游客注册界面！！！");
		}
		else if (visitorpwd==null||"".equals(visitorpwd))
		{
			out.println("<script>alert('用户密码不能为空')</script>");
			response.setHeader("refresh","2;URL=visitor_reg.jsp") ;
			out.println("两秒后自动跳转到游客注册界面！！！");
		}
		else if (!visitorpwd.equals(revisitorpwd))
		{
			out.println("<script>alert('俩次输入的密码不一致请重新输入')</script>");
			response.setHeader("refresh","2;URL=visitor_reg.jsp") ;
			out.println("两秒后自动跳转到游客注册界面！！！");
		}
		else
		{
			boolean flag=visitorreg.getinstance().saveVisitor(visitor);//将游客注册信息保存到数据库
			 if(flag){
				out.println("注册成功");
				response.setHeader("refresh","2;URL=visitor_login.jsp") ;
				out.println("两秒后自动跳转到游客登录界面！！！");
			}
			else{
				out.println("注册失败，游客信息未写入数据库");
				response.setHeader("refresh","2;URL=index.jsp") ;
				out.println("两秒后自动跳转到首页！！！");
			}
		}
		out.flush();
		out.close();
	}
		

}
