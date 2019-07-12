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

public class gukeSelectServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String path = "gukeSelect.jsp";
    List<String> info = new ArrayList<String>(); // 收集错误信息
    List<Customer> result = new ArrayList<Customer>(); // 保存结果ֵ
    if (info.size() == 0) { // 没有任何错误的信息
      try {
        result = customerimpl.Selectguke();
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
