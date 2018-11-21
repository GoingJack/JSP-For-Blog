package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbcon.sqlConnection;

public class visitorlogin {
	private static visitorlogin instance=null;

	//获取实例化对象
	public static visitorlogin getinstance(){
		if(instance==null)
			instance = new visitorlogin();
	return instance;
	}
	
	//保存游客登录信息
	public boolean checkVisitor(UserInfomation user){
		Connection conn=null;
		boolean flag=false;
		try{
			conn = sqlConnection.getCon();
			if(conn==null)
				return false;
			String sql="select * from Visitor_Information where VisitorId=? and VisitorPasswd=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, user.getUserid());
			ps.setString(2, user.getUserpwd());
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				if((user.getUserid().equals(rs.getString("VisitorId")))&&(user.getUserpwd().equals(rs.getString("VisitorPasswd"))))
				{
					flag = true;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	return flag;
	}
}
