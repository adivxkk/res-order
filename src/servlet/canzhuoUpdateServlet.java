package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import impl.czimpl;
import vo.Canzhuo;

public class canzhuoUpdateServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String path = "canzhuoUpdate.jsp";
    String id = new String(req.getParameter("id").getBytes("iso-8859-1"), "UTF-8");
    String number = new String(req.getParameter("number").getBytes("iso-8859-1"), "UTF-8");
    String status = new String(req.getParameter("status").getBytes("iso-8859-1"), "UTF-8");
    String location = new String(req.getParameter("location").getBytes("iso-8859-1"), "UTF-8");
    List<String> info = new ArrayList<String>();// 收集错误信息
    if (id == null || "".equals(id)) {
      info.add("餐桌编号不能为空");
    }
    if (number == null || "".equals(number)) {
      info.add("容纳人数不能为空");
    }
    if (status == null || "".equals(status)) {
      info.add("状态不能为空");
    }
    if (location == null || "".equals(location)) {
      info.add("位置不能为空");
    }
    if (info.size() == 0) {// 里面没有记录任何错误
      Canzhuo canzhuo = new Canzhuo();
      canzhuo.setId(Integer.parseInt(id));
      canzhuo.setNumber(Integer.parseInt(number));
      canzhuo.setStatus(status);
      canzhuo.setLocation(location);
      try {
        if (czimpl.Updatecanzhuo(canzhuo)) {
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
