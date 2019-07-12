package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dbc.DBUtils;
import vo.Canzhuo;

public class czimpl {
  private Connection conn = null;
  private PreparedStatement pstmt = null;

  public czimpl(Connection conn) {
    this.conn = conn;
  }

  public static List<Canzhuo> Selectcz() {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    List<Canzhuo> list = new ArrayList<Canzhuo>();
    try {
      connection = DBUtils.getConnection();
      preparedStatement = connection.prepareStatement("{call dbo.查询空闲餐桌()}");
      ResultSet rSet = null;
      rSet = preparedStatement.executeQuery();
      while (rSet.next()) {
        Canzhuo canzhuo = new Canzhuo();
        canzhuo.setId(rSet.getInt("id"));
        canzhuo.setNumber(rSet.getInt("number"));
        canzhuo.setStatus(rSet.getString("status"));
        canzhuo.setLocation(rSet.getString("location"));
        list.add(canzhuo);
      }
    } catch (Exception e) {
      e.printStackTrace();

    }
    DBUtils.close(connection);
    DBUtils.close(preparedStatement);
    return list;
  }

  public static boolean Insertcz(Canzhuo canzhuo) {
    boolean flag = false;
    Connection conn = null;
    PreparedStatement pstmt = null;
    try {
      conn = DBUtils.getConnection();
      pstmt = conn.prepareStatement("{call dbo.增加餐桌(?,?,?,?)}");
      pstmt.setInt(1, canzhuo.getId());
      pstmt.setInt(2, canzhuo.getNumber());
      pstmt.setString(3, canzhuo.getStatus());
      pstmt.setString(4, canzhuo.getLocation());

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

  public static List<Canzhuo> AllSelect() {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    List<Canzhuo> list = new ArrayList<Canzhuo>();
    try {
      connection = DBUtils.getConnection();
      preparedStatement = connection.prepareStatement("{call dbo.查询所有餐桌()}");
      ResultSet rSet = null;
      rSet = preparedStatement.executeQuery();
      while (rSet.next()) {
        Canzhuo canzhuo = new Canzhuo();
        canzhuo.setId(rSet.getInt("id"));
        canzhuo.setNumber(rSet.getInt("number"));
        canzhuo.setStatus(rSet.getString("status"));
        canzhuo.setLocation(rSet.getString("location"));
        list.add(canzhuo);
      }
    } catch (Exception e) {
      e.printStackTrace();

    }
    DBUtils.close(connection);
    DBUtils.close(preparedStatement);
    return list;
  }

  public static boolean Deletecz(String id) {
    boolean flag = false;
    Connection conn = null; // 声明Connectin对象
    PreparedStatement pstmt = null; // 声明PreparedStatement对象
    try {
      conn = DBUtils.getConnection();
      pstmt = conn.prepareStatement("{call dbo.删除餐桌(?)}");
      pstmt.setInt(1, Integer.parseInt(id));
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

  public static boolean Updatecanzhuo(Canzhuo canzhuo) {
    boolean flag = false;
    Connection conn = null;
    PreparedStatement pstmt = null;
    try {
      conn = DBUtils.getConnection();
      pstmt = conn.prepareStatement("{call dbo.修改餐桌(?,?,?,?)}");
      pstmt.setInt(1, canzhuo.getId());
      pstmt.setInt(2, canzhuo.getNumber());
      pstmt.setString(3, canzhuo.getStatus());
      pstmt.setString(4, canzhuo.getLocation());
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
