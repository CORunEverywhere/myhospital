package org.hospital.dao;

import org.hospital.entity.DepotKeeper;
import org.hospital.entity.drug;
import org.hospital.entity.record;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class drugDao {
	private static final String DBDRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DBURL = "jdbc:mysql://175.24.98.177:3306/hospital?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8";
	private static final String DBUSER = "root";
	private static final String DBPASSWORD = "322322322";
	
	//
	public boolean isExist(String sno) {
		return queryDrugBySno(sno)==null?false:true;
	}
	//����ҩƷ��ͬʱ������ҩƷ����Ϣ���м�¼
	public boolean addDrug(drug ddrug,DepotKeeper keeper) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName(DBDRIVER);
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);

			String sql1 = "insert into drug(sno,sname,sfactory,sunit,snumber,sprice) values(?,?,?,?,?,?);";
			String sql2 = "insert into record(drugSno,drugSname,personSno,personSname,snumber,stime) values(?,?,?,?,?,?);";
			pstmt = conn.prepareStatement(sql1);
			pstmt.setString(1, ddrug.getSno());
			pstmt.setString(2, ddrug.getName());
			pstmt.setString(3, ddrug.getFactory());
			pstmt.setString(4, ddrug.getUnit());
			pstmt.setInt(5, ddrug.getNumber());
			pstmt.setString(6, ddrug.getPrice());
			int count1 = pstmt.executeUpdate();
			pstmt = conn.prepareStatement(sql2);
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			String ddate = (String)formatter.format(date);
			pstmt.setString(1, ddrug.getSno());
			pstmt.setString(2, ddrug.getName());
			pstmt.setInt(3, keeper.getId());
			pstmt.setString(4, keeper.getName());
			pstmt.setInt(5, ddrug.getNumber());
			pstmt.setString(6, ddate);

			int count2 = pstmt.executeUpdate();
			if(count1 + count2>1)
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

	//ͨ����Ŷ�ҩƷ�������и���,��д���¼֮��
	public boolean updateDrugNumberBySno(String sno,drug ddrug,DepotKeeper keeper) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(DBDRIVER);
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
			String sql1 = "update drug set snumber=snumber+? where sno = ?;";
			String sql2 =  "insert into record(drugSno,drugSname,personSno,personSname,snumber,stime) values(?,?,?,?,?,?);";
			pstmt = conn.prepareStatement(sql1 );
			pstmt.setInt(1, ddrug.getNumber());
			pstmt.setString(2, ddrug.getSno());
			int count1 = pstmt.executeUpdate();
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			String ddate = (String)formatter.format(date);
			System.out.println(ddate);
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, ddrug.getSno());
			pstmt.setString(2, ddrug.getName());
			pstmt.setInt(3, keeper.getId());
			pstmt.setString(4, keeper.getName());
			pstmt.setInt(5, ddrug.getNumber());
			pstmt.setString(6, ddate);
			int count2 = pstmt.executeUpdate();
			if(count1 + count2 > 1)
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
	//ͨ����Ÿ���ҩƷ�Ļ�����Ϣ
	public boolean updateDrugBySno(String sno,drug ddrug) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(DBDRIVER);
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);

			String sql = "update drug set sname=?,sfactory=?,sunit=?,sprice=? where sno=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ddrug.getName());
			pstmt.setString(2, ddrug.getFactory());
			pstmt.setString(3, ddrug.getUnit());
			pstmt.setString(4, ddrug.getPrice());
			pstmt.setString(5, ddrug.getSno());
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

	//ͨ�����ɾ��ҩƷ
	public boolean deleteDrugBySno(String sno) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(DBDRIVER);
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);

			String sql = "delete from drug where sno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sno);
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

	//ͨ����Ų��ҵ�ҩƷ
	public drug queryDrugBySno(String sno) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		drug ddrug = null;

		try {
			Class.forName(DBDRIVER);
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);

			String sql = "select* from drug where sno=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sno);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String no = rs.getString("sno");
				String name = rs.getString("sname");
				String factory = rs.getString("sfactory");
				int number = rs.getInt("snumber");
				String unit = rs.getString("sunit");
				String price = rs.getString("sprice");
				ddrug= new drug(no,name,factory,unit,number,price);
			}
			return ddrug;
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
	

	//ͨ�����Ʋ��ҵ�ҩƷ
	public List<drug> queryDrugByName(String sname) {
		List<drug> drugs = new ArrayList();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		drug ddrug = null;

		try {
			Class.forName(DBDRIVER);
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);

			String sql = "select* from drug where sname like '%"+sname+"%'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String no = rs.getString("sno");
				String name = rs.getString("sname");
				String factory = rs.getString("sfactory");
				int number = rs.getInt("snumber");
				String unit = rs.getString("sunit");
				String price = rs.getString("sprice");
				ddrug= new drug(no,name,factory,unit,number,price);
				drugs.add(ddrug);
			}
			return drugs;
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

	//��ҳչʾҩƷ��Ϣ
	public List<drug> queryDrugsByPage(int currentPage,int pageSize) {
		List<drug> drugs = new ArrayList();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		drug ddrug = null;

		try {
			Class.forName(DBDRIVER);
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
		int n=currentPage*pageSize;
		String sql = "select * from drug limit "+
		n+","+pageSize+";";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String no = rs.getString("sno");
				String name = rs.getString("sname");
				String factory = rs.getString("sfactory");
				int number = rs.getInt("snumber");
				String unit = rs.getString("sunit");
				String price = rs.getString("sprice");
				ddrug= new drug(no,name,factory,unit,number,price);
				drugs.add(ddrug);
			}
			return drugs;
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
	//��ѯ������ҩƷ�����¼
	public List<record> queryAllRecord() {
		List<record> records = new ArrayList();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		record rrecord = null;

		try {
			Class.forName(DBDRIVER);
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
			String sql = "select * from record;";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int no = rs.getInt("sno");
				String sno = rs.getString("drugSno");
				String sname = rs.getString("drugSname");
				int number = rs.getInt("snumber");
				int pson = rs.getInt("personSno");
				String psname = rs.getString("personSname");
				String time = rs.getString("stime");
				rrecord= new record(no,sno,sname,pson,psname,number,time);
				records.add(rrecord);
			}
			return records;
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
	//���ҩƷ����
	public int getTotalCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = -1;
		try {
			Class.forName(DBDRIVER);
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);

			String sql = "select count(*) from drug";
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
