package impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dbc.DBUtils;
import vo.User;

public class lgimpl {
  private Connection connection = null;

  public lgimpl(Connection connection) {
    this.connection = connection;
  }

  public static List<User> Selectlg(String account) {
    List<User> info = new ArrayList<User>();
    Connection conn = null; // ����Connection����
    CallableStatement pstmt = null; // ����PreparedStatement����
    try {
      conn = DBUtils.getConnection();
      pstmt = conn.prepareCall("{call dbo.查询登入用户(?)}");
      pstmt.setString(1, account);
      ResultSet rs = null; // �����
      rs = pstmt.executeQuery();
      if (rs.next()) {
        User user = new User();
        user.setPassword(rs.getString("admin_password"));
        user.setRole(rs.getString("admin_user"));
        info.add(1, user);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
    DBUtils.close(conn);
    DBUtils.close(pstmt);
    return info;
  }

}
