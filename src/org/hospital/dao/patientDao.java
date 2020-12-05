package org.hospital.dao;

import org.hospital.entity.patient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class patientDao {
	private static final String DBDRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DBURL = "jdbc:mysql://175.24.98.177:3306/hospital?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8";
	private static final String DBUSER = "root";
	private static final String DBPASSWORD = "322322322";
    
    //
    public boolean isExist(String username) {
    	return queryPatientByUsername(username)==null?true:false;
    }
    //增加患者
    public boolean addPatient(patient ppatient) {
    	Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    
	    try {
			Class.forName(DBDRIVER);
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
			         
			String sql = "insert into patient(name,sex,year,phone,password,username) values(?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setString(1, ppatient.getName());
			pstmt.setString(2, ppatient.getSex());
			pstmt.setInt(3, ppatient.getYear());
			pstmt.setString(4, ppatient.getPhone());
			pstmt.setString(5, ppatient.getPassword());
			pstmt.setString(6, ppatient.getUsername());
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
    
    //更新患者信息
    public boolean updatePatientBySno(int sno,patient ppatient) {
    	Connection conn = null;
	    PreparedStatement pstmt = null;
	    
	    try {
			Class.forName(DBDRIVER);
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
			         
			String sql = "update patient set name = ?,sex=?,year=?,phone=?,password=? where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ppatient.getName());
			pstmt.setString(2, ppatient.getSex());
			pstmt.setInt(3, ppatient.getYear());
			pstmt.setString(4, ppatient.getPhone());
			pstmt.setString(5, ppatient.getPassword());
			
			pstmt.setInt(6, sno);
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
    
    //删除患者
    public boolean deletePatientBySno(int sno) {
    	Connection conn = null;
	    PreparedStatement pstmt = null;
	    
	    try {
			Class.forName(DBDRIVER);
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
			         
			String sql = "delete from patient where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sno);
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
    
    //通过编号查询患者信息
	public patient queryPatientBySno(int sno) {
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
		patient ppatient = null;
		
		try {
		Class.forName(DBDRIVER);
		conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
		         
		String sql = "select* from patient where id=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, sno);
		rs = pstmt.executeQuery();
		if(rs.next()) {
			int id = rs.getInt("id");
			String username = rs.getString("username");
		    String name = rs.getString("name");
		    String sex = rs.getString("sex");
		    int year = rs.getInt("year");
		    String password = rs.getString("password");
		    String phone = rs.getString("phone");
		    ppatient = new patient(id,username,name,sex,year,phone,password); 
		 }
		return ppatient;
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
	 //通过用户名查询患者信息
		public patient queryPatientByUsername(String sno) {
		    Connection conn = null;
		    PreparedStatement pstmt = null;
		    ResultSet rs = null;
			patient ppatient = null;
			
			try {
			Class.forName(DBDRIVER);
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
			         
			String sql = "select* from patient where username=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sno);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int id = rs.getInt("id");
				String username = rs.getString("username");
			    String name = rs.getString("name");
			    String sex = rs.getString("sex");
			    int year = rs.getInt("year");
			    String password = rs.getString("password");
			    String phone = rs.getString("phone");
			    ppatient = new patient(id,username,name,sex,year,phone,password); 
			 }
			return ppatient;
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
	//查询所有患者
	public List<patient> queryAllPatient() {
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
		patient ppatient = null;
		List<patient> patients = new ArrayList();
		
		try {
		Class.forName(DBDRIVER);
		conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
		         
		String sql = "select* from patient";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			int id = rs.getInt("id");
		    String name = rs.getString("name");
		    String username = rs.getString("username");
		    String sex = rs.getString("sex");
		    int year = rs.getInt("year");
		    String password = rs.getString("password");
		    String phone = rs.getString("phone");
		    ppatient = new patient(id,username,name,sex,year,phone,password); 
		    patients.add(ppatient);
		 }
		return patients;
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
	//通过姓名查询患者
		public List<patient> queryPatientByName(String sname) {
		    Connection conn = null;
		    PreparedStatement pstmt = null;
		    ResultSet rs = null;
			patient ppatient = null;
			List<patient> patients = new ArrayList();
			
			try {
			Class.forName(DBDRIVER);
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
			         
			String sql = "select* from patient where name like '%"+sname+"%'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String username = rs.getString("username");
			    String name = rs.getString("name");
			    String sex = rs.getString("sex");
			    int year = rs.getInt("year");
			    String password = rs.getString("password");
			    String phone = rs.getString("phone");
			    ppatient = new patient(id,username,name,sex,year,phone,password); 
			    patients.add(ppatient);
			 }
			return patients;
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
	//鏌ヨ鎬绘暟
	public int getTotalCount() {
		 Connection conn = null;
		    PreparedStatement pstmt = null;
		    ResultSet rs = null;
			int count = -1;
			try {//鍔犺浇椹卞姩绋嬪簭
			Class.forName(DBDRIVER);
			//杩炴帴鏁版嵁搴�
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
			         
			String sql = "select count(*) from patient";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1); 
			 }
			
			 } catch(ClassNotFoundException e) {
				 e.printStackTrace();
			 }catch (SQLException e) {
					e.printStackTrace();
			 }catch (Exception e) {
				    e.printStackTrace();
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
			return count;
	}

}
