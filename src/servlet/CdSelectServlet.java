package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import impl.cdimpl;
import vo.Caidan;

public class CdSelectServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String path = "caidanSelect.jsp";
    String id = new String(req.getParameter("id").getBytes("iso-8859-1"), "UTF-8");
    String cus_id = new String(req.getParameter("cus_id").getBytes("iso-8859-1"), "UTF-8");
    List<String> info = new ArrayList<String>();
    List<Caidan> result = new ArrayList<Caidan>();
    if (id == null || "".equals(id)) {
      info.add("餐桌编号不能为空");
    }
    if (cus_id == null || "".equals(cus_id)) {
      info.add("顾客编号不能为空");
    }
    if (info.size() == 0) {

      Caidan caidan = new Caidan();
      caidan.setId(Integer.parseInt(id));
      caidan.setCus_id(Integer.parseInt(cus_id));
      try {
        result = cdimpl.Selectcd(caidan);
        if (result.size() > 0 && result != null) {
          info.add("查询成功");

        } else {
          info.add("查询失败");
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    req.setAttribute("info", info);
    req.setAttribute("result", result);
    req.getRequestDispatcher(path).forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(req, resp);
  }

}
