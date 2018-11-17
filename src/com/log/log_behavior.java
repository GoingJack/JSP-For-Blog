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
	          log.settitle(rs.getString("logtitle"));
	          log.setdetails(rs.getString("rootlog"));
	          list.add(log);
	     }
	     return list;
	}
	public List<logInfo> queryAll() throws Exception
	{
		Connection conn = null;
		conn=sqlConnection.getCon();
		String sql="select * from bk_log";
		PreparedStatement ps=conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		
		List<logInfo> list =getqueryAll_loglist(rs);
		conn.close();
		return list;
	}
		
	public List<log_review> queryreview(String title) throws Exception{
		Connection conn=null;
		conn=sqlConnection.getCon();
		String sql="select * from bk_lm where logtitle=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, title);
		ResultSet rs=ps.executeQuery();
		if(rs==null)
			System.out.println("查找失败");
		else
			System.out.println("查找成功");
		List<log_review> list=getqueryreviewList(rs);
		conn.close();
		return list;
	}
	private List<log_review> getqueryreviewList(ResultSet rs) throws Exception{
		// TODO Auto-generated method stub
	     List<log_review> list_r = new ArrayList<log_review>();
	     while(rs.next()){
	    	  log_review log_r = new log_review();
	          log_r.setid(rs.getString(1));
	          System.out.println(rs.getString(1));
	          log_r.setdetails(rs.getString(2));
	          System.out.println(rs.getString(2));
	          log_r.settitle(rs.getString(3));
	          System.out.println(rs.getString(3));
	          list_r.add(log_r);
	     }
	     return list_r;
	}
	public String getBytitle(String title) throws Exception{
		Connection conn=sqlConnection.getCon();
		String sql="select * from bk_log where logtitle=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, title);
		ResultSet rs=ps.executeQuery();
		String details=null;
		if(rs.next()){
			details =rs.getString("rootlog");
		}
		return details;
	}
}
