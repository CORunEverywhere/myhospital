package org.hospital.dao;

import org.hospital.entity.DepotKeeper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepotKeeperDao {
    private static final String DBDRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://175.24.98.177:3306/hospital?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8";   
    private static final String DBUSER = "root";
    private static final String DBPASSWORD = "322322322";

    //通过编号判断是否存在
    public boolean isExist(int sno) {
        return queryDepotKeeperBySno(sno)==null?false:true;
    }
    //增加仓库管理员
    public boolean addDepotKeeper(DepotKeeper depotKeeper) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            Class.forName(DBDRIVER);
            conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);

            String sql = "insert into depot_keeper(sname,gender,tel,birthday,password,address) values(?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(4, depotKeeper.getBirthYear());
            pstmt.setString(1, depotKeeper.getName());
            pstmt.setString(2, depotKeeper.getSex());
            pstmt.setString(6, depotKeeper.getAddress());
            pstmt.setString(3, depotKeeper.getPhonenumber());
            pstmt.setString(5, depotKeeper.getPassword());
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

    //更新仓库管理员信息
    public boolean updateDepotKeeperBySno(int sno,DepotKeeper depotKeeper) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            Class.forName(DBDRIVER);
            conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);

            String sql = "update depot_keeper set sname = ?,gender=?,tel=?,birthday=?,password=?,address=? where id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(4, depotKeeper.getBirthYear());
            pstmt.setString(1, depotKeeper.getName());
            pstmt.setString(5, depotKeeper.getPassword());
            pstmt.setString(2, depotKeeper.getSex());
            pstmt.setString(6, depotKeeper.getAddress());
            pstmt.setString(3, depotKeeper.getPhonenumber());

            pstmt.setInt(7, sno);
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

    //删除仓库管理员
    public boolean deleteDepotKeeperBySno(int sno) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {//鍔犺浇椹卞姩绋嬪簭
            Class.forName(DBDRIVER);
            //杩炴帴鏁版嵁搴�
            conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);

            String sql = "delete from depot_keeper where id = ?";
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

    //通过编号查询仓库管理员
    public DepotKeeper queryDepotKeeperBySno(int sno) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        DepotKeeper depotKeeper = null;

        try {
            Class.forName(DBDRIVER);
            conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);

            String sql = "select* from depot_keeper where id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, sno);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("sname");
                String sex = rs.getString("gender");
                String birthyear = rs.getString("birthday");
                String password = rs.getString("password");
                String address = rs.getString("address");
                String phonenumber = rs.getString("tel");
                depotKeeper = new DepotKeeper(id,name,sex,birthyear,password,address,phonenumber);
            }
            return depotKeeper;
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
    //通过姓名查看仓库管理员
    public List<DepotKeeper> queryDepotKeeperBySname(String sname) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        DepotKeeper depotKeeper = null;
        List<DepotKeeper> depotKeepers = new ArrayList();

        try {
            Class.forName(DBDRIVER);
            conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);

            String sql = "select* from depot_keeper where sname like '%"+sname+"%'";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("sname");
                String sex = rs.getString("gender");
                String birthyear = rs.getString("birthday");
                String password = rs.getString("password");
                String address = rs.getString("address");
                String phonenumber = rs.getString("tel");
                depotKeeper = new DepotKeeper(id,name,sex,birthyear,password,address,phonenumber);
                depotKeepers.add(depotKeeper);
            }
            return depotKeepers;
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
    //仓库管理员分页查询
    public List<DepotKeeper> queryDepotKeepersByPage(int currentPage,int pageSize) {
        List<DepotKeeper> depotKeepers = new ArrayList();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        DepotKeeper depotKeeper = null;

        try {
            Class.forName(DBDRIVER);
            conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
            int n=currentPage*pageSize;
            String sql = "select * from depot_keeper limit "+
                    n+","+pageSize+";";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("sname");
                String sex = rs.getString("gender");
                String birthyear = rs.getString("birthday");
                String password = rs.getString("password");
                String address = rs.getString("address");
                String phonenumber = rs.getString("tel");
                depotKeeper = new DepotKeeper(id,name,sex,birthyear,password,address,phonenumber);
                depotKeepers.add(depotKeeper);
            }
            return depotKeepers;
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

    //获得仓库管理员总数
    public int getTotalCount() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int count = -1;
        try {
            Class.forName(DBDRIVER);
            conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);

            String sql = "select count(*) from depot_keeper";
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
