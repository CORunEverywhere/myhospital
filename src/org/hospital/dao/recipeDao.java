package org.hospital.dao;

import org.hospital.entity.recipe;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class recipeDao {
	private static final String DBDRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DBURL = "jdbc:mysql://175.24.98.177:3306/hospital?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8";
	private static final String DBUSER = "root";
	private static final String DBPASSWORD = "322322322";
    
    //����ҩ��
    public boolean addRecipe(recipe rrecipe) {
    	Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    
	    try {
			Class.forName(DBDRIVER);
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
			         
			String sql = "insert into recipe(pid,pname,did,dname,amount,price,state) values(?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rrecipe.getPid());
			pstmt.setString(2, rrecipe.getPname());
			pstmt.setInt(3, rrecipe.getDid());
			pstmt.setString(4, rrecipe.getDname());
			pstmt.setInt(5, rrecipe.getAmount());
			pstmt.setInt(6, rrecipe.getPrice());
			pstmt.setInt(7, rrecipe.getState());
			
			
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
    
    //����ҩ��״̬��֧��/δ֧��
    public boolean updateRecipeState(int id) {
    	Connection conn = null;
	    PreparedStatement pstmt = null;
	    
	    try {
			Class.forName(DBDRIVER);
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
				String sql = "update recipe set state=? where pid=?;";
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
  //ͨ��ҩ��id����ѯ������ҩ������
    public boolean updateRecipeAmonut(int id,int amount) {
    	Connection conn = null;
	    PreparedStatement pstmt = null;
	    
	    try {
			Class.forName(DBDRIVER);
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
				String sql = "update recipe set amount=amount+? where id=?;";
//				String sql = "update recipe set amount=? where id=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, amount);
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
    //ͨ����Ŷ�ҩ������ɾ��
    public boolean deleteRecipeBySno(int sno) {
    	Connection conn = null;
	    PreparedStatement pstmt = null;
	    
	    try {
			Class.forName(DBDRIVER);
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
			         
			String sql = "delete from recipe where id = ?";
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
    //ͨ�����߱�Ų�ѯҩ��
 	public List<recipe> queryRecipeByPid(int pid) {
 		Connection conn = null;
 		PreparedStatement pstmt = null;
 		ResultSet rs = null;
 		recipe rrecipe = null;
 		List<recipe> recipes = new ArrayList();

 		try {
 			Class.forName(DBDRIVER);
 			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);

 			String sql = "select* from recipe where pid=? and state=0";
 			pstmt = conn.prepareStatement(sql);
 			pstmt.setInt(1, pid);
 			rs = pstmt.executeQuery();
 			while(rs.next()) {
 				int id = rs.getInt("id");
 				String dname = rs.getString("dname");
 				int did = rs.getInt("did");
 				String pname = rs.getString("pname");
 				int amount = rs.getInt("amount");
 				int price = rs.getInt("price");
 				int state = 0;
 				rrecipe = new recipe(id,pid,pname,did,dname,amount,price,state);
 				recipes.add(rrecipe);
 			}
 			return recipes;
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
 	 //ͨ����Ų�ѯҩ��
 	public recipe queryRecipeById(int id) {
 		Connection conn = null;
 		PreparedStatement pstmt = null;
 		ResultSet rs = null;
 		recipe rrecipe = null;

 		try {
 			Class.forName(DBDRIVER);
 			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);

 			String sql = "select* from recipe where id=? and state=0";
 			pstmt = conn.prepareStatement(sql);
 			pstmt.setInt(1, id);
 			rs = pstmt.executeQuery();
 			if(rs.next()) {
 				int pid = rs.getInt("pid");
 				String dname = rs.getString("dname");
 				int did = rs.getInt("did");
 				String pname = rs.getString("pname");
 				int amount = rs.getInt("amount");
 				int price = rs.getInt("price");
 				int state = 0;
 				rrecipe = new recipe(id,pid,pname,did,dname,amount,price,state);
 			}
 			return rrecipe;
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
 	//ͨ�����߱��ҩƷ��ţ��Լ�����״̬��ѯҩ���Ƿ����
 	 	public boolean isExsit(int pid, int did) {
 	 		Connection conn = null;
 	 		PreparedStatement pstmt = null;
 	 		ResultSet rs = null;
 	 		recipe rrecipe = null;
 	 		List<recipe> recipes = new ArrayList();

 	 		try {
 	 			Class.forName(DBDRIVER);
 	 			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);

 	 			String sql = "select* from recipe where pid=? and state=0 and did=?";
 	 			pstmt = conn.prepareStatement(sql);
 	 			pstmt.setInt(1, pid);
 	 			pstmt.setInt(2, did);
 	 			rs = pstmt.executeQuery();
 	 			if(rs.next()) {
 	 				return false;
 	 			}else {
 	 				return true;
 	 			}
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
}
