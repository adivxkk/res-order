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

public class cpSelectServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String path = "caipingSelect.jsp";
    String id = new String(req.getParameter("caipingNO").getBytes("iso-8859-1"), "UTF-8");
    List<String> info = new ArrayList<String>(); // 收集信息
    List<caiping> result = new ArrayList<caiping>(); // 获得返回值ֵ
    if (id == null || "".equals(id)) {
      info.add("菜品编号不能为空");
    }
    if (info.size() == 0) { // 里面没有记录任何错误信息
      caiping cp = new caiping();
      // yg.seteNo(Integer.parseInt(ygNo));
      cp.setC_id(Integer.parseInt(id));
      try {
        result = cpimpl.Selectcp(cp);
        if (result.size() > 0 && result != null) {
          info.add("查询成功");
        } else {
          info.add("查询失败，请检查输入的编号是否正确");
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
