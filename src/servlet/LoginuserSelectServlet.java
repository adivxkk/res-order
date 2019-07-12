package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import impl.lgimpl;
import vo.User;

public class LoginuserSelectServlet extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    /*
     * String path1 = "gukeindex.jsp"; String path = "loginuserSelect.jsp";
     */
    String account = new String(req.getParameter("account").getBytes("iso-8859-1"), "UTF-8");
    String role = new String(req.getParameter("select").getBytes("iso-8859-1"), "UTF-8");
    String password = new String(req.getParameter("password").getBytes("iso-8859-1"), "UTF-8");
    List<User> result = new ArrayList<User>();
    List<String> info = new ArrayList<String>();
    if (account == null || "".equals(account)) {
      info.add("账号不能为空");
    }
    if (password == null || "".equals(password.trim())) {
      info.add("密码不能为空");
    }
    if (role == null || "".equals(role)) {
      info.add("权限不能为空 ");
    }
    if (info.size() == 0) {// 没有错误信息
      try {
        result = lgimpl.Selectlg(account);
        if (result.size() > 0 && result != null) {
          User user = new User();
          user = result.get(1);
          if (user.getPassword() != password) {
            info.add("密码错误！");
            req.getSession().setAttribute("info", info);
            resp.sendRedirect("http://localhost:8080/jiadiankucun/cardDeleteServlet");

          } else if (user.getRole() != role) {
            info.add("角色权限选择错误");
            req.getSession().setAttribute("info", info);
            resp.sendRedirect("http://localhost:8080/jiadiankucun/cardDeleteServlet");

          } else {
            req.getSession().setAttribute("account", account);
            resp.sendRedirect("http://localhost:8080/jiadiankucun/cardDeleteServlet");

          }
        }
      } catch (Exception e) {
        // TODO: handle exception
        e.printStackTrace();
      }
    }

  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // TODO Auto-generated method stub
    doPost(req, resp);
  }

}
