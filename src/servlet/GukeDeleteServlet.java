package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import impl.customerimpl;

public class GukeDeleteServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String path = "gukeDelete.jsp";
    String cus_id = new String(req.getParameter("cus_id").getBytes("iso-8859-1"), "UTF-8");
    List<String> info = new ArrayList<String>();
    if (cus_id == null || "".equals(cus_id)) {
      info.add("顾客编号不能为空");
    }
    if (info.size() == 0) {

      try {
        if (customerimpl.Deletegk(Integer.parseInt(cus_id))) {
          info.add("删除成功");
        } else {
          info.add("删除失败，请检查输入是否有错");
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    req.setAttribute("info", info);
    req.getRequestDispatcher(path).forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(req, resp);
  }

}
