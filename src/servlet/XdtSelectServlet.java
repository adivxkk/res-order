package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import impl.xdtimpl;
import vo.Xiadantotal;

public class XdtSelectServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String path = "xiadantotalSelect.jsp";
    String id = new String(req.getParameter("id").getBytes("iso-8859-1"), "UTF-8");
    String cus_id = new String(req.getParameter("cus_id").getBytes("iso-8859-1"), "UTF-8");
    List<String> info = new ArrayList<String>();
    float totalmoney = 0;
    if (id == null || "".equals(id)) {
      info.add("餐桌编号不能为空");
    }
    if (cus_id == null || "".equals(cus_id)) {
      info.add("顾客编号不能为空");
    }
    if (info.size() == 0) {
      Xiadantotal xiadantotal = new Xiadantotal();
      xiadantotal.setId(Integer.parseInt(id));
      xiadantotal.setCus_id(Integer.parseInt(cus_id));
      try {
        totalmoney = xdtimpl.Selectxdt(xiadantotal);
        if ((totalmoney < 0)) {
          info.add("查询失败");
        } else {
          info.add("查询成功");
        }

      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    req.setAttribute("info", info);
    req.setAttribute("totalmoney", totalmoney);
    req.getRequestDispatcher(path).forward(req, resp);

  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(req, resp);
  }

}
