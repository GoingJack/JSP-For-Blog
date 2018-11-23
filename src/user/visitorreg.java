package user;
import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException; 
import dbcon.sqlConnection; 
import user.UserInfomation;

public class visitorreg {
	private static visitorreg instance=null;

	//获取实例化对象
	public static visitorreg getinstance(){
		if(instance==null)
			instance = new visitorreg();
	return instance;
	}
	
	//保存游客注册信息
	public boolean saveVisitor(UserInfomation user){
		Connection conn=null;
		try{
			conn = sqlConnection.getCon();
			String sql="insert into Visitor_Information(VisitorId,VisitorPasswd,VisitorName)"+"values(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUserid());
			ps.setString(2, user.getUserpwd());
			ps.setString(3, user.getUsername());
			ps.executeUpdate();
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
	return false;
	}
	public boolean isSameidVisitor(UserInfomation user){
		Connection conn=null;
		boolean flag=false;
		try{
			conn = sqlConnection.getCon();
			if(conn==null)
				return false;
			String sql="select * from Visitor_Information where VisitorId=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, user.getUserid());
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				if((user.getUserid().equals(rs.getString("VisitorId"))))
				{
					flag = true;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	return flag;
	}
	public boolean changeVipassword(UserInfomation user){
		Connection conn=null;
		try{
			conn = sqlConnection.getCon();
			String sql="insert into Visitor_Information(VisitorPasswd)"+"values(?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(2, user.getUserpwd());
			ps.executeUpdate();
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
	return false;
	}
}
