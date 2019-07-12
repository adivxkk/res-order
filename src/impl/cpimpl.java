package impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dbc.DBUtils;
import vo.caiping;

public class cpimpl {
  private Connection conn = null;
  private PreparedStatement pstmt = null;

  public cpimpl(Connection conn) {
    this.conn = conn;
  }

  public static List<caiping> Selectcp(caiping cp) throws Exception {
    // TODO Auto-generated method stub
    List<caiping> info = new ArrayList<caiping>();
    Connection conn = null;
    CallableStatement pstmt = null;
    try {
      conn = DBUtils.getConnection();
      pstmt = conn.prepareCall("{call dbo.查询菜品(?)}");
      pstmt.setInt(1, cp.getC_id());
      ResultSet rs = null;
      rs = pstmt.executeQuery();
      if (rs.next()) {
        cp.setC_id(rs.getInt("c_id"));
        cp.setC_name(rs.getString("c_name"));
        cp.setClss(rs.getString("class"));
        cp.setPicture(rs.getString("picture"));
        cp.setPrice(rs.getFloat("price"));
        cp.setStock(rs.getString("stock"));
        info.add(cp);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
    DBUtils.close(conn);
    DBUtils.close(pstmt);
    return info;
  }

  public static boolean Deletecp(caiping cp) {
    boolean flag = false;
    Connection conn = null; // 声明Connectin对象
    PreparedStatement pstmt = null; // 声明PreparedStatement对象
    try {
      conn = DBUtils.getConnection();
      pstmt = conn.prepareStatement("{call dbo.删除菜品(?)}");
      pstmt.setInt(1, cp.getC_id());
      if (pstmt.executeUpdate() > 0) { // 数据库中行受影响大于0
        flag = true;
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
    DBUtils.close(conn);
    DBUtils.close(pstmt);
    return flag;
  }

  public static boolean Insertcp(caiping cp) {
    boolean flag = false;
    Connection conn = null;
    PreparedStatement pstmt = null;
    try {
      conn = DBUtils.getConnection();
      pstmt = conn.prepareStatement("{call dbo.增加菜品(?,?,?,?,?,?)}");
      pstmt.setInt(1, cp.getC_id());
      pstmt.setString(2, cp.getC_name());
      pstmt.setFloat(3, cp.getPrice());
      pstmt.setString(4, cp.getStock());
      pstmt.setString(5, cp.getClss());
      pstmt.setString(6, cp.getPicture());
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

  public static boolean Updatecp(caiping cp) {
    boolean flag = false;
    Connection conn = null;
    PreparedStatement pstmt = null;
    try {
      conn = DBUtils.getConnection();
      pstmt = conn.prepareStatement("{call dbo.修改菜品(?,?,?,?,?,?)}");
      pstmt.setInt(1, cp.getC_id());
      pstmt.setString(2, cp.getC_name());
      pstmt.setFloat(3, cp.getPrice());
      pstmt.setString(4, cp.getStock());
      pstmt.setString(5, cp.getClss());
      pstmt.setString(6, cp.getPicture());
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

}
