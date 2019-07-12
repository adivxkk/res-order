package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dbc.DBUtils;
import vo.Xiadantotal;

public class xdtimpl {
  private Connection connection;

  public xdtimpl(Connection connection) {
    this.connection = connection;
  }

  public static float Selectxdt(Xiadantotal xiadantotal) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    float rs = 0;
    try {
      connection = DBUtils.getConnection();
      preparedStatement = connection.prepareStatement("{call dbo.本次消费总金额(?,?)}");
      preparedStatement.setInt(1, xiadantotal.getId());
      preparedStatement.setInt(2, xiadantotal.getCus_id());
      ResultSet rSet = preparedStatement.executeQuery();
      if (rSet.next()) {
        rs = rSet.getFloat("totalmoney");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    DBUtils.close(connection);
    DBUtils.close(preparedStatement);
    return rs;

  }

}
