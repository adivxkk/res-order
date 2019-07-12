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

public class ygSelectServlet extends HttpServlet {
  public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String path = "yuangongSelect.jsp";
    String y_id = new String(req.getParameter("y_id").getBytes("iso-8859-1"), "UTF-8");
    List<String> info = new ArrayList<String>();
    List<Yuangong> result = new ArrayList<Yuangong>();// ֵ
    if (y_id == null || "".equals(y_id)) {
      info.add("员工编号不能为空");
    }
    if (info.size() == 0) {
      Yuangong yg = new Yuangong();
      yg.setY_id(Integer.parseInt(y_id));
      try {
        result = ygimpl.Selectyg(yg);
        if (result.size() > 0 && result != null) {
          info.add("查询成功");
        } else {
          info.add("查询失败,请检查查询的编号是否正确");
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    req.setAttribute("info", info);
    req.setAttribute("result", result);
    req.getRequestDispatcher(path).forward(req, resp);
  }

  public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    this.doGet(req, resp);
  }

}
