package dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {

  public static Connection getConnection() {
    String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=餐厅点餐数据库;user=sa;password=5485";// 数据库地址
    Connection con = null;
    try {
      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
      con = DriverManager.getConnection(url);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return con;
  }

  public static void close(Connection con) {
    if (con != null)
      try {
        con.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
  }

  public static void close(Statement stmt) {
    try {
      if (stmt != null) {
        stmt.close();
      }
    } catch (SQLException e) {
      System.out.println("ajax.DBUtils: Cannot close statement.");
    }

  }

  public static void close(ResultSet rs) {
    try {
      if (rs != null) {
        rs.close();
      }
    } catch (SQLException e) {
      System.out.println("ajax.DBUtils: Cannot close resultset.");
    }
  }

}
