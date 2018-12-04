package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbcon.sqlConnection;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class changeVisitorInformation
 */
public class changeInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changeInformation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//设置编码
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		//表单提交值
		String c_visitorid=request.getParameter("c_visitorid");
		String c_visitorpwd=request.getParameter("c_visitorpwd");
		String c_revisitorpwd=request.getParameter("c_revisitorpwd");
		String c_visitorname=request.getParameter("c_visitorname");
		PrintWriter out = response.getWriter();
		//修改验证
//		if(c_visitorpwd==null||"".equals(c_visitorpwd)) {
//			out.println("<script>alert('修改密码不能为空')</script>");
//			out.println("<a href='vi_change.jsp'>点击此处返回修改界面</a>");
//		}
//		else if(!c_visitorpwd.equals(c_revisitorpwd))
//		{
//			out.println("<script>alert('俩次输入的密码不一致请重新输入')</script>");
//			out.println("<a href='vi_change.jsp'>点击此处返回修改界面</a>");
//		}
//		else if(c_visitorname==null||"".equals(c_visitorname))
//		{
//			out.println("<script>alert('修改昵称不能为空')</script>");
//			out.println("<a href='vi_change.jsp'>点击此处返回修改界面</a>");
//		}
		//连接数据库
		try {
			Connection conn=null;
			conn=sqlConnection.getCon();
			//String sql="UPDATE Visitor_Information SET VisitorPasswd=?, VisitorName=? WHERE VisitorId=?";
			String sql="UPDATE Visitor_Information SET VisitorPasswd='"+c_visitorpwd+"', VisitorName='" +c_visitorname+"' WHERE VisitorId='"+c_visitorid+"'";
			PreparedStatement ps=conn.prepareStatement(sql);
			//ps.setString(1, c_visitorpwd);
			//ps.setString(2, c_visitorname);
			//ps.setString(3, c_visitorid);
			int flag=ps.executeUpdate();
			if(flag==1)
			{
				out.println("<script>alert('修改成功')</script>");
				out.println("<a href='visitor_login.jsp'>点击此处返回登陆界面</a>");
			}
			else
			{
				out.println("<script>alert('修改失败')</script>");
			}
				
			}
		catch(Exception e){
			e.printStackTrace();
			}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//设置编码
				response.setContentType("text/html");
				request.setCharacterEncoding("utf-8");
				response.setCharacterEncoding("utf-8");
				
				//表单提交值
				String rc_visitorid=request.getParameter("rc_visitorid");
				String rc_visitorpwd=request.getParameter("rc_visitorpwd");
				String rc_revisitorpwd=request.getParameter("rc_revisitorpwd");
				PrintWriter out = response.getWriter();
				//修改验证
//				if(rc_visitorpwd==null||"".equals(rc_visitorpwd)) {
//					out.println("<script>alert('修改密码不能为空')</script>");
//					out.println("<a href='vi_change.jsp'>点击此处返回修改界面</a>");
//				}
//				else if(!rc_visitorpwd.equals(rc_revisitorpwd))
//				{
//					out.println("<script>alert('俩次输入的密码不一致请重新输入')</script>");
//					out.println("<a href='vi_change.jsp'>点击此处返回修改界面</a>");
//				}
				//连接数据库
				try {
					Connection conn=null;
					conn=sqlConnection.getCon();
					//String sql="UPDATE Visitor_Information SET VisitorPasswd=?, VisitorName=? WHERE VisitorId=?";
					String sql="UPDATE Root_admin SET Password='"+rc_visitorpwd+"' WHERE Username='"+rc_visitorid+"'";
					PreparedStatement ps=conn.prepareStatement(sql);
					//ps.setString(1, c_visitorpwd);
					//ps.setString(2, c_visitorname);
					//ps.setString(3, c_visitorid);
					int flag=ps.executeUpdate();
					if(flag==1)
					{
						out.println("<script>alert('修改成功')</script>");
						out.println("<a href='root_login.jsp'>点击此处返回登陆界面</a>");
					}
					else
					{
						out.println("<script>alert('修改失败')</script>");
					}
						
					}
				catch(Exception e){
					e.printStackTrace();
					}
		
	}

}
