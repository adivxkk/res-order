package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import impl.dcimpl;
import vo.Diancai;

public class DcDeleteServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String path = "diancaiDelete.jsp";
    String id = new String(req.getParameter("id").getBytes("iso-8859-1"), "UTF-8");
    String c_id = new String(req.getParameter("c_id").getBytes("iso-8859-1"), "UTF-8");
    String ordertime = new String(req.getParameter("ordertime").getBytes("iso-8859-1"), "UTF-8");
    List<String> info = new ArrayList<String>();
    if (id == null || "".equals(id)) {
      info.add("餐桌编号不能为空");
    }
    if (c_id == null || "".equals(c_id)) {
      info.add("菜品编号不能为空");
    }
    if (ordertime == null || "".equals(ordertime)) {
      info.add("点菜时间不能为空");
    }
    if (info.size() == 0) {
      Diancai diancai = new Diancai();
      diancai.setId(Integer.parseInt(id));
      diancai.setC_id(Integer.parseInt(c_id));
      diancai.setOrdertime(ordertime);
      try {
        if (dcimpl.Deletedc(diancai)) {
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
