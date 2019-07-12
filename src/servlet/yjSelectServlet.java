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

public class yjSelectServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String path = "yejiSelect.jsp";
    List<String> info = new ArrayList<String>();
    List<Yuangong> result = new ArrayList<Yuangong>();// ֵ
    if (info.size() == 0) {
      try {
        result = ygimpl.Selectyj();
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

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(req, resp);
  }

}
