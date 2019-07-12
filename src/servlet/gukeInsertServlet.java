package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import impl.customerimpl;
import vo.Customer;

public class gukeInsertServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String path = "gukeInsert.jsp";
    String cus_id = new String(req.getParameter("cus_id").getBytes("iso-8859-1"), "UTF-8");
    String card_id = new String(req.getParameter("card_id").getBytes("iso-8859-1"), "UTF-8");
    String cus_name = new String(req.getParameter("cus_name").getBytes("iso-8859-1"), "UTF-8");
    String cus_phone = new String(req.getParameter("cus_phone").getBytes("iso-8859-1"), "UTF-8");
    List<String> info = new ArrayList<String>();// 收集错误信息
    if (cus_id == null || "".equals(cus_id)) {
      info.add("顾客编号不能为空");
    }
    /*
     * if (card_id == null || "".equals(card_id)) { info.add("号不能为空"); }
     */
    if (cus_name == null || "".equals(cus_name)) {
      info.add("顾客姓名不能为空");
    }
    if (cus_phone == null || "".equals(cus_phone)) {
      info.add("顾客电话不能为空");
    }
    if (info.size() == 0) {// 没有错误信息
      Customer customer = new Customer();
      customer.setCus_id(Integer.parseInt(cus_id));
      customer.setCard_id(card_id);
      customer.setCus_name(cus_name);
      customer.setCus_phone(cus_phone);

      try {
        if (customerimpl.Insertguke(customer)) {
          info.add("添加成功");
        } else {
          info.add("添加失败，检查添加信息是否正确");
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
