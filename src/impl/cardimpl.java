package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dbc.DBUtils;
import vo.Card;

public class cardimpl {
  private Connection conn = null;
  private PreparedStatement pstmt = null;

  public cardimpl(Connection conn) {
    this.conn = conn;
  }

  public static boolean Insertcd(Card card) {
    boolean flag = false;
    Connection conn = null;
    PreparedStatement pstmt = null;
    try {
      conn = DBUtils.getConnection();
      pstmt = conn.prepareStatement("{call dbo.增加会员(?,?,?,?,?,?,?)}");
      pstmt.setString(1, card.getCard_id());
      pstmt.setInt(2, card.getCus_id());
      pstmt.setInt(3, card.getLevel());
      pstmt.setFloat(4, card.getDiscount());
      pstmt.setInt(5, card.getPoint());
      pstmt.setFloat(6, card.getMoney());
      pstmt.setInt(7, card.getY_id());
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

  public static List<Card> Selectcard() {
    List<Card> list = new ArrayList<Card>();
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    try {
      connection = DBUtils.getConnection();
      preparedStatement = connection.prepareStatement("{call dbo.查询所有会员()}");
      ResultSet rSet = null;
      rSet = preparedStatement.executeQuery();
      while (rSet.next()) {
        Card card = new Card();
        card.setCard_id(rSet.getString("card_id"));
        card.setCus_id(rSet.getInt("cus_id"));
        card.setDiscount(rSet.getFloat("discount"));
        card.setLevel(rSet.getInt("level"));
        card.setMoney(rSet.getFloat("money"));
        card.setPoint(rSet.getInt("point"));
        card.setY_id(rSet.getInt("y_id"));

        list.add(card);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    DBUtils.close(connection);
    DBUtils.close(preparedStatement);
    return list;

  }

  public static List<Card> Selectcardsingle(Card card) {
    List<Card> list = new ArrayList<Card>();
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    try {
      connection = DBUtils.getConnection();
      preparedStatement = connection.prepareStatement("{call dbo.查询单个会员(?)}");
      preparedStatement.setString(1, card.getCard_id());
      ResultSet rSet = null;
      rSet = preparedStatement.executeQuery();
      while (rSet.next()) {
        Card card1 = new Card();
        card1.setCard_id(rSet.getString("card_id"));
        card1.setCus_id(rSet.getInt("cus_id"));
        card1.setDiscount(rSet.getFloat("discount"));
        card1.setLevel(rSet.getInt("level"));
        card1.setMoney(rSet.getFloat("money"));
        card1.setPoint(rSet.getInt("point"));
        card1.setY_id(rSet.getInt("y_id"));

        list.add(card1);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    DBUtils.close(connection);
    DBUtils.close(preparedStatement);
    return list;
  }

  public static boolean Deletecard(String card_id) {
    // TODO Auto-generated method stub
    boolean flag = false;
    Connection conn = null; // 声明Connectin对象
    PreparedStatement pstmt = null; // 声明PreparedStatement对象
    try {
      conn = DBUtils.getConnection();
      pstmt = conn.prepareStatement("{call dbo.删除会员(?)}");
      pstmt.setString(1, card_id);
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

}
