package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import dbc.DBUtils;
import vo.Dingzhuo;

public class dzimpl {
  private Connection connection = null;
  private PreparedStatement preparedStatement = null;

  public dzimpl(Connection connection) {
    this.connection = connection;
  }

  public static boolean Insertdz(Dingzhuo dingzhuo) {
    boolean flag = false;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    try {
      connection = DBUtils.getConnection();
      preparedStatement = connection.prepareStatement("{call dbo.增加定桌(?,?)}");
      preparedStatement.setInt(1, dingzhuo.getCus_id());
      preparedStatement.setInt(2, dingzhuo.getId());
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
