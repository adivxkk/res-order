package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import impl.ygimpl;
import vo.Yuangong;

public class ygDeleteServlet extends HttpServlet {
  public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String path = "yuangongDelete.jsp";
    String y_id = new String(req.getParameter("y_id").getBytes("iso-8859-1"), "UTF-8");
    List<String> info = new ArrayList<String>();
    if (y_id == null || "".equals(y_id)) {
      info.add("员工编号不能为空");
    }
    if (info.size() == 0) { //
      Yuangong yg = new Yuangong();
      yg.setY_id(Integer.parseInt(y_id));
      try {
        if (ygimpl.Deleteyg(yg)) {
          info.add("删除成功");
        } else {
          info.add("删除失败，请检查输入是否正确");
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    req.setAttribute("info", info);
    req.getRequestDispatcher(path).forward(req, resp);
  }

  public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    this.doGet(req, resp);
  }

}
