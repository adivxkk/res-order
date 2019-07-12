package impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dbc.DBUtils;
import vo.Yuangong;

public class ygimpl {
  private Connection conn = null;
  private PreparedStatement pstmt = null;

  public ygimpl(Connection conn) {
    this.conn = conn;
  }

  public static boolean Insertyg(Yuangong yg) {
    boolean flag = false;
    Connection conn = null;
    PreparedStatement pstmt = null;
    try {
      conn = DBUtils.getConnection();
      pstmt = conn.prepareStatement("{call dbo.增加员工(?,?,?,?,?,?,?,?)}");
      pstmt.setInt(1, yg.getY_id());
      pstmt.setString(2, yg.getY_name());
      pstmt.setString(3, yg.getSex());
      pstmt.setInt(4, yg.getAge());
      pstmt.setString(5, yg.getPhone());
      pstmt.setString(6, yg.getAddress());
      pstmt.setString(7, yg.getDuty());
      pstmt.setFloat(8, yg.getPerformance());
      // pstmt.executeUpdate();
      if (pstmt.executeUpdate() > 0) {
        flag = true;
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
    DBUtils.close(conn);
    DBUtils.close(pstmt);
    return flag;
  }

  public static List<Yuangong> Selectyg(Yuangong yg) throws Exception {
    // TODO Auto-generated method stub
    List<Yuangong> info = new ArrayList<Yuangong>();
    Connection conn = null;
    CallableStatement pstmt = null;
    try {
      conn = DBUtils.getConnection();
      pstmt = conn.prepareCall("{call dbo.查询员工(?)}");
      pstmt.setInt(1, yg.getY_id());
      ResultSet rs = null;
      rs = pstmt.executeQuery();
      while (rs.next()) {
        yg.setY_id(rs.getInt("y_id"));
        yg.setY_name(rs.getString("y_name"));
        yg.setAge(rs.getInt("age"));
        yg.setSex(rs.getString("sex"));
        yg.setPhone(rs.getString("phone"));
        yg.setAddress(rs.getString("address"));
        yg.setDuty(rs.getString("duty"));
        yg.setPerformance(rs.getFloat("performance"));
        info.add(yg);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
    DBUtils.close(conn);
    DBUtils.close(pstmt);
    return info;
  }

  public static boolean Updateyg(Yuangong yg) {
    boolean flag = false;
    Connection conn = null;
    PreparedStatement pstmt = null;
    try {
      conn = DBUtils.getConnection();
      pstmt = conn.prepareStatement("{call dbo.yuangongUpdate(?,?,?,?,?)}");
      pstmt.setInt(1, yg.getY_id());
      pstmt.setString(2, yg.getY_name());
      pstmt.setString(3, yg.getSex());
      pstmt.setInt(4, yg.getAge());
      pstmt.setString(5, yg.getPhone());
      pstmt.setString(6, yg.getAddress());
      pstmt.setString(5, yg.getDuty());
      pstmt.setFloat(6, yg.getPerformance());
      if (pstmt.executeUpdate() > 0) {
        flag = true;
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
    DBUtils.close(conn);
    DBUtils.close(pstmt);
    return flag;
  }

  public static boolean Deleteyg(Yuangong yg) {
    boolean flag = false;
    Connection conn = null;
    PreparedStatement pstmt = null;
    try {
      conn = DBUtils.getConnection();
      pstmt = conn.prepareStatement("{call dbo.删除员工(?)}");
      pstmt.setInt(1, yg.getY_id());
      if (pstmt.executeUpdate() > 0) {
        flag = true;
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
    DBUtils.close(conn);
    DBUtils.close(pstmt);
    return flag;
  }

  public static List<Yuangong> Selectyj() {
    List<Yuangong> info = new ArrayList<Yuangong>();
    Connection conn = null;
    CallableStatement pstmt = null;

    try {
      conn = DBUtils.getConnection();
      pstmt = conn.prepareCall("{call dbo.员工业绩排名()}");

      ResultSet rs = null;
      rs = pstmt.executeQuery();
      while (rs.next()) {
        Yuangong yg = new Yuangong();
        yg.setY_id(rs.getInt("y_id"));
        yg.setY_name(rs.getString("y_name"));

        yg.setPerformance(rs.getFloat("performance"));
        info.add(yg);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
    DBUtils.close(conn);
    DBUtils.close(pstmt);
    return info;

  }

}
