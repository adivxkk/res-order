package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dbc.DBUtils;
import vo.Customer;

public class customerimpl {
  private Connection conn = null;
  private PreparedStatement pstmt = null;

  public customerimpl(Connection conn) {
    this.conn = conn;
  }

  public static boolean Insertguke(Customer customer) {
    boolean flag = false;
    Connection conn = null;
    PreparedStatement pstmt = null;
    try {
      conn = DBUtils.getConnection();
      pstmt = conn.prepareStatement("{call dbo.增加顾客(?,?,?,?)}");
      pstmt.setInt(1, customer.getCus_id());
      pstmt.setString(2, customer.getCard_id());
      pstmt.setString(3, customer.getCus_name());
      pstmt.setString(4, customer.getCus_phone());

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

  public static List<Customer> Selectguke() {
    List<Customer> list = new ArrayList<Customer>();
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    try {
      connection = DBUtils.getConnection();
      preparedStatement = connection.prepareStatement("{call dbo.查询所有顾客()}");
      ResultSet rSet = null;
      rSet = preparedStatement.executeQuery();
      while (rSet.next()) {
        Customer customer = new Customer();
        customer.setCus_id(rSet.getInt("cus_id"));
        customer.setCard_id(rSet.getString("card_id"));
        customer.setCus_name(rSet.getString("cus_name"));
        customer.setCus_phone(rSet.getString("cus_phone"));
        list.add(customer);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    DBUtils.close(connection);
    DBUtils.close(preparedStatement);
    return list;
  }

  public static boolean Deletegk(int cus_id) {
    boolean flag = false;
    Connection conn = null; // 声明Connectin对象
    PreparedStatement pstmt = null; // 声明PreparedStatement对象
    try {
      conn = DBUtils.getConnection();
      pstmt = conn.prepareStatement("{call dbo.删除顾客(?)}");
      pstmt.setInt(1, cus_id);
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

  public static boolean Updateguke(Customer customer) {
    boolean flag = false;
    Connection conn = null;
    PreparedStatement pstmt = null;
    try {
      conn = DBUtils.getConnection();
      pstmt = conn.prepareStatement("{call dbo.修改顾客(?,?,?,?)}");
      pstmt.setInt(1, customer.getCus_id());
      pstmt.setString(2, customer.getCard_id());
      pstmt.setString(3, customer.getCus_name());
      pstmt.setString(4, customer.getCus_phone());
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
