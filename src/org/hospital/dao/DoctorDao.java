package org.hospital.dao;

import org.hospital.entity.Doctor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDao {
	private static final String DBDRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://175.24.98.177:3306/hospital?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8";
    private static final String DBUSER = "root";
    private static final String DBPASSWORD = "322322322";
    //连接数据库
    
    //判断医生是否存在
    public boolean isExist(int sno) {
    	return queryDoctorBySno(sno)==null?false:true;
    }
    //增加医生
    public boolean addDoctor(Doctor ddoctor) {
    	Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    
	    try {
			Class.forName(DBDRIVER);
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
			         
			String sql = "insert into doctor(sname,ssex,sbirthyear,saddress,sphonenumber,spassword,sdepartment,stitle) values(?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(3, ddoctor.getBirthYear());
			pstmt.setString(1, ddoctor.getName());
			pstmt.setString(2, ddoctor.getSex());
			pstmt.setString(4, ddoctor.getAddress());
			pstmt.setString(5, ddoctor.getPhonenumber());
			pstmt.setString(6, ddoctor.getPassword());
			pstmt.setString(7, ddoctor.getDepartment());
			pstmt.setString(8, ddoctor.getTitle());
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
    
    //通过编号对医生信息进行更新
    public boolean updateDoctorBySno(int sno, Doctor ddoctor) {
    	Connection conn = null;
	    PreparedStatement pstmt = null;
	    
	    try {
			Class.forName(DBDRIVER);
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
			         
			String sql = "update doctor set sname = ?,ssex=?,sbirthyear=?,saddress=?,sphonenumber=?,sdepartment=?,stitle=? where s_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(3, ddoctor.getBirthYear());
			pstmt.setString(1, ddoctor.getName());
			pstmt.setString(2, ddoctor.getSex());
			pstmt.setString(4, ddoctor.getAddress());
			pstmt.setString(5, ddoctor.getPhonenumber());
			//pstmt.setString(6, ddoctor.getPassword());
			pstmt.setString(6, ddoctor.getDepartment());
			pstmt.setString(7, ddoctor.getTitle());
			
			pstmt.setInt(8, sno);
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
    
    //通过编号对医生进行删除
    public boolean deleteDoctorBySno(int sno) {
    	Connection conn = null;
	    PreparedStatement pstmt = null;
	    
	    try {//鍔犺浇椹卞姩绋嬪簭
			Class.forName(DBDRIVER);
			//杩炴帴鏁版嵁搴�
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
			         
			String sql = "delete from doctor where s_id = ?";
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
    //鐧诲綍
	public Doctor doctor_login(String sname){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Doctor doctor = null;
		try {
			Class.forName(DBDRIVER);
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
			String sql = "select* from doctor where sname=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sname);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int id = rs.getInt("s_id");
				String name = rs.getString("sname");
				String sex = rs.getString("ssex");
				int birthyear = rs.getInt("sbirthyear");
				String title = rs.getString("stitle");
				String department = rs.getString("sdepartment");
				String password = rs.getString("spassword");
				String address = rs.getString("saddress");
				String phonenumber = rs.getString("sphonenumber");
				doctor = new Doctor(id,name,sex,birthyear,title,department,password,address,phonenumber);
			}
			return doctor;
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
	//通过编号对医生进行查询
	public Doctor queryDoctorBySno(int sno) {
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
		Doctor ddoctor = null;
		
		try {
		Class.forName(DBDRIVER);
		conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
		         
		String sql = "select* from doctor where s_id=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, sno);
		rs = pstmt.executeQuery();
		if(rs.next()) {
			int id = rs.getInt("s_id");
		    String name = rs.getString("sname");
		    String sex = rs.getString("ssex");
		    int birthyear = rs.getInt("sbirthyear");
		    String title = rs.getString("stitle");
		    String department = rs.getString("sdepartment");
		    String password = rs.getString("spassword");
		    String address = rs.getString("saddress");
		    String phonenumber = rs.getString("sphonenumber");
		    ddoctor = new Doctor(id,name,sex,birthyear,title,department,password,address,phonenumber);
		 }
		return ddoctor;
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
	//通过姓名对医生进行模糊查询
	public List<Doctor> queryDoctorBySname(String sname) {
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
		Doctor ddoctor = null;
		List<Doctor> doctors = new ArrayList();
		
		try {
		Class.forName(DBDRIVER);
		conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
		         
		String sql = "select* from doctor where sname like '%"+sname+"%'";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			int id = rs.getInt("s_id");
		    String name = rs.getString("sname");
		    String sex = rs.getString("ssex");
		    int birthyear = rs.getInt("sbirthyear");
		    String title = rs.getString("stitle");
		    String department = rs.getString("sdepartment");
		    String password = rs.getString("spassword");
		    String address = rs.getString("saddress");
		    String phonenumber = rs.getString("sphonenumber");
		    ddoctor = new Doctor(id,name,sex,birthyear,title,department,password,address,phonenumber);
		    doctors.add(ddoctor);
		 }
		return doctors;
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
	//分页查询医生信息
	public List<Doctor> queryDoctorsByPage(int currentPage, int pageSize) {
		List<Doctor> doctors = new ArrayList();
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
		Doctor ddoctor = null;
		
		try {
		Class.forName(DBDRIVER);
		conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
		//select * from student limit 页数*页面大小,页面大小，mysql查询方法
		int n=currentPage*pageSize;
		String sql = "select * from doctor limit "+n+","+pageSize+";";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			int id = rs.getInt("s_id");
		    String name = rs.getString("sname");
		    String sex = rs.getString("ssex");
		    int birthyear = rs.getInt("sbirthyear");
		    String title = rs.getString("stitle");
		    String department = rs.getString("sdepartment");
		    String password = rs.getString("spassword");
		    String address = rs.getString("saddress");
		    String phonenumber = rs.getString("sphonenumber");
		    ddoctor = new Doctor(id,name,sex,birthyear,title,department,password,address,phonenumber);
		    doctors.add(ddoctor);
		 }
		return doctors;
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
			         
			String sql = "select count(*) from doctor";
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
	//对医生按照部门查询，方便患者挂号
	public List<Doctor> queryDoctorByDepart(String sdepart) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Doctor ddoctor = null;
		List<Doctor> doctors = new ArrayList();

		try {
			Class.forName(DBDRIVER);
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);

			String sql = "select* from doctor where sdepartment=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sdepart);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("s_id");
				String name = rs.getString("sname");
				String sex = rs.getString("ssex");
				int birthyear = rs.getInt("sbirthyear");
				String title = rs.getString("stitle");
				String department = rs.getString("sdepartment");
				String password = rs.getString("spassword");
				String address = rs.getString("saddress");
				String phonenumber = rs.getString("sphonenumber");
				ddoctor = new Doctor(id,name,sex,birthyear,title,department,password,address,phonenumber);
				doctors.add(ddoctor);
			}
			return doctors;
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
