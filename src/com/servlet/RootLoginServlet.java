package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.UserInfomation;
import user.rootlogin;

@WebServlet(name="rootloginServlet",urlPatterns="/RootLoginServlet")
public class RootLoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public RootLoginServlet() {
		super();
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
		String rootid = request.getParameter("Username");
		String rootpwd = request.getParameter("PassWord");
		//登录验证
		PrintWriter out1 = response.getWriter();
		if(rootid == null || "".equals(rootid)){    
			out1.println("<script>alert('用户id不能为空')</script>");
			out1.println("<a href='root_login.jsp'>点击此处返回登陆界面</a>");
			
		}
		else if(rootpwd == null || "".equals(rootpwd)){
			out1.println("<script>alert('密码不能为空')</script>");
			out1.println("<a href='root_login.jsp'>点击此处返回登陆界面</a>");
			
		}
		else {
		//用户名密码验证通过
		UserInfomation root = new UserInfomation();      
		root.setUserid(rootid);      //设置userid
		root.setUserpwd(rootpwd);  //设置userpass
		//out1.println(root.getUserid());
		//out1.println(root.getUserpwd());
		boolean flag=false;
		flag = rootlogin.getinstance().checkroot(root);
		//out1.print(flag);
		try {
			if(flag){ //验证通过
				request.getSession().setAttribute("userid",root.getUserid());
				
				response.sendRedirect("IndexServlet"); //跳转
			}else{
				out1.print("<script>alert('登陆失败,用户名或者密码错误！！！')</script>");
				out1.println("<a href='root_login.jsp'>点击此处返回登陆界面</a>");
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			out1.flush();
			out1.close();
		}
		}
		}
}

