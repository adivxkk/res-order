package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import dbc.DBUtils;
import vo.Diancai;

public class dcimpl {
  private Connection connection = null;

  public dcimpl(Connection connection) {
    this.connection = connection;
  }

  public static boolean Insertdc(Diancai diancai) {
    boolean flag = false;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    try {
      connection = DBUtils.getConnection();
      preparedStatement = connection.prepareStatement("{call dbo.增加点菜(?,?,?)}");
      preparedStatement.setInt(1, diancai.getId());
      preparedStatement.setInt(2, diancai.getC_id());
      preparedStatement.setInt(3, diancai.getQuantity());
      if (preparedStatement.executeUpdate() > 0) {
        flag = true;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    DBUtils.close(connection);
    DBUtils.close(preparedStatement);
    return flag;

  }

  public static boolean Deletedc(Diancai diancai) {
    boolean flag = false;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    try {
      connection = DBUtils.getConnection();
      preparedStatement = connection.prepareStatement("{call dbo.删除点菜(?,?,?)}");
      preparedStatement.setInt(1, diancai.getId());
      preparedStatement.setInt(2, diancai.getC_id());
      preparedStatement.setString(3, diancai.getOrdertime());
      if (preparedStatement.executeUpdate() > 0) {
        flag = true;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    DBUtils.close(connection);
    DBUtils.close(preparedStatement);
    return flag;
  }

}
