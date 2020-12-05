package org.hospital.dao;

import org.hospital.entity.form;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class formDao {
	private static final String DBDRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DBURL = "jdbc:mysql://175.24.98.177:3306/hospital?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8";
	private static final String DBUSER = "root";
	private static final String DBPASSWORD = "322322322";
    
    //���ӹҺŵ�
    public boolean addfform(form fform) {
    	Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    
	    try {
			Class.forName(DBDRIVER);
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
			         
			String sql = "insert into form(pid,pname,did,dname,time,state) values(?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fform.getPid());
			pstmt.setString(2, fform.getPname());
			pstmt.setInt(3, fform.getDid());
			pstmt.setString(4, fform.getDname());
			
			Date date = new Date(); 
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			String ddate = (String)formatter.format(date);
			pstmt.setString(5, ddate);
			pstmt.setInt(6, fform.getState());
			
			
			int count = pstmt.executeUpdate();
			if(count>0)
				return true;
			else
				return false;
			
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
					if(rs!=null) rs.close();
			        if(pstmt!=null) pstmt.close();
			        if(conn!=null) conn.close();
			    }catch(Exception e) {
			       e.printStackTrace();
			       }
			}
    }
    
    //���¹Һŵ���״̬��������0���Ѵ���1
    public boolean updateformState(int id) {
    	Connection conn = null;
	    PreparedStatement pstmt = null;
	    
	    try {
			Class.forName(DBDRIVER);
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
				String sql = "update form set state=? where id=?;";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, 1);
				pstmt.setInt(2, id);
			int count = pstmt.executeUpdate();
			if(count>0)
				return true;
			else
				return false;
			
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
    
    //ͨ��ҽ����id���ҹҺŵ�
	public List<form> queryFormByDid(int did) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		form fform = null;
		List<form> forms = new ArrayList();

		try {
			Class.forName(DBDRIVER);
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);

			String sql = "select* from form where did=? and state=0";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, did);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String dname = rs.getString("dname");
				int pid = rs.getInt("pid");
				String pname = rs.getString("pname");
				String time = rs.getString("time");
				int state = 0;
				fform = new form(id,pid,pname,did,dname,time,state);
				forms.add(fform);
			}
			return forms;
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

}
