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

public class cpDeleteServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String path = "caipingDelete.jsp";
    String c_id = new String(req.getParameter("id").getBytes("iso-8859-1"), "UTF-8");
    // String ygNo=new
    // String(req.getParameter("yuangongNo").getBytes("iso-8859-1"),"UTF-8");
    List<String> info = new ArrayList<String>(); // 收集信息
    if (c_id == null || "".equals(c_id)) {
      info.add("菜品编号不能为空");
    }
    if (info.size() == 0) { // 无错误信息
      caiping cp = new caiping();
      cp.setC_id(Integer.parseInt(c_id));
      try {
        if (cpimpl.Deletecp(cp)) {
          info.add("删除成功");
        } else {
          info.add("删除失败，请检查输入是否正确可删");
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
