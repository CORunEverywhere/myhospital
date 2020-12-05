package org.hospital.dao;

import org.hospital.entity.admin;

import java.sql.*;

public class AdminDao {
	private static final String DBDRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DBURL = "jdbc:mysql://175.24.98.177:3306/hospital?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8";
	private static final String DBUSER = "root";
	private static final String DBPASSWORD = "322322322";
	//mysql���ݿ�����
    
    public admin queryAdminBySname(String sname) {//ͨ���û������ҹ���Ա
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
		admin aadmin = null;
		try {
		Class.forName(DBDRIVER);
		conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
		String sql = "select* from ad where sname=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, sname);
		rs = pstmt.executeQuery();
		if(rs.next()) {
		    String name = rs.getString("sname");
		    String password = rs.getString("spassword");
		    aadmin = new admin(name,password); 
		 }
		return aadmin;
		 } catch(ClassNotFoundException e) {
			 e.printStackTrace();
		     return null;
		 }catch (SQLException e) {
				e.printStackTrace();
			    return null;
		 }catch (Exception e) {
			    e.printStackTrace();
			    return null;
		}
		finally {
			try {
				if(rs!=null) rs.close();
		        if(pstmt!=null) pstmt.close();
		        if(conn!=null) conn.close();
		    }catch(Exception e) {
		       e.printStackTrace();
		       }
		}
	}
    
    public boolean updateAdminBySname(String newpassword,String sname) {//ͨ���û����޸Ĺ���Ա����
	    Connection conn = null;
	    PreparedStatement pstmt = null;
		try {
		Class.forName(DBDRIVER);
		conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
		String sql = "update ad set spassword=? where sname=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, newpassword);
		pstmt.setString(2, sname);
		int rs = pstmt.executeUpdate();
		return true;
		 } catch(ClassNotFoundException e) {
			 e.printStackTrace();
		     return false;
		 }catch (SQLException e) {
				e.printStackTrace();
			    return false;
		 }catch (Exception e) {
			    e.printStackTrace();
			    return false;
		}
		finally {
			try {
		        if(pstmt!=null) pstmt.close();
		        if(conn!=null) conn.close();
		    }catch(Exception e) {
		       e.printStackTrace();
		       }
		}
	}
}
