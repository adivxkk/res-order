package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dbc.DBUtils;
import vo.Caidan;
import vo.caiping;

public class cdimpl {
  private Connection connection = null;

  public cdimpl(Connection connection) {
    this.connection = connection;
  }

  public static List<Caidan> Selectcd(Caidan caidan) {
    List<Caidan> list = new ArrayList<Caidan>();
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    try {
      connection = DBUtils.getConnection();
      preparedStatement = connection.prepareStatement("{call dbo.查询所点菜单(?,?)}");
      preparedStatement.setInt(1, caidan.getId());
      preparedStatement.setInt(2, caidan.getCus_id());
      ResultSet rSet = null;
      rSet = preparedStatement.executeQuery();
      while (rSet.next()) {
        Caidan caidan2 = new Caidan();
        caidan2.setC_name(rSet.getString("c_name"));
        caidan2.setPrice(rSet.getFloat("price"));
        caidan2.setQuantity(rSet.getInt("quantity"));
        caidan2.setMoney(rSet.getFloat("money"));
        caidan2.setClss(rSet.getString("class"));
        caidan2.setPicture(rSet.getString("picture"));
        list.add(caidan2);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    DBUtils.close(connection);
    DBUtils.close(preparedStatement);
    return list;
  }

  public static List<caiping> Selectdiancai() {
    List<caiping> list = new ArrayList<caiping>();
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    try {
      connection = DBUtils.getConnection();
      preparedStatement = connection.prepareStatement("{call dbo.查询所有菜品()}");
      ResultSet rSet = null;
      rSet = preparedStatement.executeQuery();
      while (rSet.next()) {
        caiping caidan2 = new caiping();
        caidan2.setC_id(rSet.getInt("c_id"));
        caidan2.setC_name(rSet.getString("c_name"));
        caidan2.setPrice(rSet.getFloat("price"));
        caidan2.setClss(rSet.getString("class"));
        caidan2.setPicture(rSet.getString("picture"));
        list.add(caidan2);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    DBUtils.close(connection);
    DBUtils.close(preparedStatement);
    return list;

  }

}
