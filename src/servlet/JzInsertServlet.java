package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import impl.jzimpl;
import vo.Jiezhang;

public class JzInsertServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String path = "jiezhangInsert.jsp";
    String cus_id = new String(req.getParameter("cus_id").getBytes("iso-8859-1"), "UTF-8");
    String y_id = new String(req.getParameter("y_id").getBytes("iso-8859-1"), "UTF-8");
    List<String> info = new ArrayList<String>();// 收集错误信息
    Jiezhang jiezhang = new Jiezhang();
    if (cus_id == null || "".equals(cus_id)) {
      info.add("顾客编号不能为空");

    }
    if (y_id == null || "".equals(y_id)) {
      info.add("员工编号不能为空");

    }

    if (info.size() == 0) {// 没有错误信息

      jiezhang.setCus_id(Integer.parseInt(cus_id));
      jiezhang.setY_id(Integer.parseInt(y_id));

    }
    try {

      if (jzimpl.Insertjz(jiezhang)) {
        info.add("添加成功");
      } else {
        info.add("添加失败，检查添加信息是否出错");
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
