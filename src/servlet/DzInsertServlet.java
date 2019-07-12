package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import impl.dzimpl;
import vo.Dingzhuo;

public class DzInsertServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String path = "dingzhuoInsert.jsp";
    String cus_id = new String(req.getParameter("cus_id").getBytes("iso-8859-1"), "UTF-8");
    String id = new String(req.getParameter("id").getBytes("iso-8859-1"), "UTF-8");
    List<String> info = new ArrayList<String>();// 收集错误信息
    if (cus_id == null || "".equals(cus_id)) {
      info.add("顾客编号不能为空");
    }
    if (id == null || "".equals(id)) {
      info.add("餐桌编号不能为空");
    }
    if (info.size() == 0) {// 没有错误信息
      Dingzhuo dingzhuo = new Dingzhuo();
      dingzhuo.setCus_id(Integer.parseInt(cus_id));
      dingzhuo.setId(Integer.parseInt(id));
      try {
        if (dzimpl.Insertdz(dingzhuo)) {
          info.add("定桌成功");
        } else {
          info.add("定桌失败，检查添加信息是否正确");
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
