package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import impl.cpimpl;
import vo.caiping;

public class cpUpdateServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String path = "cpUpdate.jsp";
    String c_id = new String(req.getParameter("id").getBytes("iso-8859-1"), "UTF-8");
    String c_name = new String(req.getParameter("name").getBytes("iso-8859-1"), "UTF-8");
    String price = new String(req.getParameter("price").getBytes("iso-8859-1"), "UTF-8");
    String stock = new String(req.getParameter("stock").getBytes("iso-8859-1"), "UTF-8");
    String clss = new String(req.getParameter("clss").getBytes("iso-8859-1"), "UTF-8");
    String picture = new String(req.getParameter("picture").getBytes("iso-8859-1"), "UTF-8");
    List<String> info = new ArrayList<String>();// 收集错误信息
    if (c_id == null || "".equals(c_id)) {
      info.add("菜品编号不能为空");
    }
    if (c_name == null || "".equals(c_name)) {
      info.add("菜名不能为空");
    }
    if (price == null || "".equals(price)) {
      info.add("菜品单价不能为空");
    }
    if (stock == null || "".equals(stock)) {
      info.add("菜品库存量不能为空");
    }

    if (picture == null || "".equals(picture)) {
      info.add("菜品图片不能为空");
    }
    if (info.size() == 0) {// 里面没有记录任何错误
      caiping cp = new caiping();
      cp.setC_id(Integer.parseInt(c_id));
      cp.setC_name(c_name);
      cp.setClss(clss);
      cp.setPicture(picture);
      cp.setPrice(Float.parseFloat(price));
      cp.setStock(stock);
      try {
        if (cpimpl.Updatecp(cp)) {
          info.add("菜品修改成功");
        } else {
          info.add("修改失败，请检查修改的信息是否正确");

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
