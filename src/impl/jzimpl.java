package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import dbc.DBUtils;
import vo.Jiezhang;

public class jzimpl {
  private Connection conn = null;
  private PreparedStatement pstmt = null;

  public jzimpl(Connection conn) {
    this.conn = conn;
  }

  public static boolean Insertjz(Jiezhang jiezhang) {
    boolean flag = false;
    Connection conn = null;
    PreparedStatement pstmt = null;
    try {
      conn = DBUtils.getConnection();
      pstmt = conn.prepareStatement("{call dbo.增加结账(?,?)}");
      pstmt.setInt(1, jiezhang.getCus_id());
      pstmt.setInt(2, jiezhang.getY_id());

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
