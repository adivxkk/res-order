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

public class DcInsertServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String path = "diancaiInsert.jsp";
    String id = new String(req.getParameter("id").getBytes("iso-8859-1"), "UTF-8");
    String c_id = new String(req.getParameter("c_id").getBytes("iso-8859-1"), "UTF-8");
    String quantity = new String(req.getParameter("quantity").getBytes("iso-8859-1"), "UTF-8");
    List<String> info = new ArrayList<String>();// 收集错误信息
    Diancai diancai = new Diancai();
    if (id == null || "".equals(id)) {
      info.add("餐桌号不能为空");

    }
    if (c_id == null || "".equals(c_id)) {
      info.add("菜品编号不能为空");

    }
    if (quantity == null || "".equals(quantity)) {
      info.add("菜品数量不能为空");
    }
    if (info.size() == 0) {// 没有错误信息

      diancai.setId(Integer.parseInt(id));
      diancai.setC_id(Integer.parseInt(c_id));
      diancai.setQuantity(Integer.parseInt(quantity));
    }
    try {

      if (dcimpl.Insertdc(diancai)) {
        info.add("点菜成功");
      } else {
        info.add("点菜失败，检查添加信息是否出错");
      }
    } catch (Exception e) {
      e.printStackTrace();
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
