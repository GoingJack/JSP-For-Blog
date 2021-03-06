package com.log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import dbcon.sqlConnection;
public class log_behavior {
	//将查询结果集存到logInfo中
	private List<logInfo> getqueryAll_loglist(ResultSet rs)  throws SQLException {
	     List<logInfo> list = new ArrayList<logInfo>();
	     while(rs.next()){
	    	  logInfo log = new logInfo();
	    	  log.setlogid(rs.getInt("Text_Id"));
	          log.settitle(rs.getString("Text_Title"));
	          log.setdetails(rs.getString("Text_Content"));
	          list.add(log);
	     }
	     return list;
	}
	public List<logInfo> queryAll() throws Exception
	{
		Connection conn = null;
		conn=sqlConnection.getCon();
		String sql="select * from Text";
		PreparedStatement ps=conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		
		List<logInfo> list =getqueryAll_loglist(rs);
		conn.close();
		return list;
	}
		
	public List<log_review> queryreview(int logid) throws Exception{
		Connection conn=null;
		conn=sqlConnection.getCon();
		String sql="select * from Comment where Text_Id=? order by Comment_Time";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, logid);
		ResultSet rs=ps.executeQuery();
		if(rs==null)
			System.out.println("log_behavior.java评论查找失败");
		else
			System.out.println("log_behavior.java评论查找成功");
		List<log_review> list=getqueryreviewList(rs);
		conn.close();
		return list;
	}
	private List<log_review> getqueryreviewList(ResultSet rs) throws Exception{
		// TODO Auto-generated method stub
	     List<log_review> list_r = new ArrayList<log_review>();
	     while(rs.next()){
	    	  log_review log_r = new log_review();
	          log_r.setlogid(rs.getInt("Text_Id"));
	          log_r.setreview_id(rs.getString("Comment_Id"));
	          log_r.setreview_details(rs.getString("Comment_Content"));
	          log_r.setreview_time(rs.getTimestamp("Comment_Time"));
	          list_r.add(log_r);
	     }
	     return list_r;
	}
	public logInfo getBylogid(int logid) throws Exception{
		Connection conn=sqlConnection.getCon();
		String sql="select * from Text where Text_Id=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, logid);
		ResultSet rs=ps.executeQuery();
		logInfo log = new logInfo();
		if(rs.next()){
			log.setlogid(logid);
			log.setdetails(rs.getString("Text_Content"));
			log.settitle(rs.getString("Text_Title"));
		}
		return log;
	}
}
