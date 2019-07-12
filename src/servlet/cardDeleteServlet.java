package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import impl.cardimpl;

public class cardDeleteServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String path = "cardDelete.jsp";
    String card_id = new String(req.getParameter("card_id").getBytes("iso-8859-1"), "UTF-8");
    List<String> info = new ArrayList<String>();
    if (card_id == null || "".equals(card_id)) {
      info.add("卡号不能为空");
    }
    if (info.size() == 0) {
      try {
        if (cardimpl.Deletecard(card_id)) {
          info.add("删除成功");
        } else {
          info.add("删除失败");
        }
      } catch (Exception e) {
        // TODO: handle exception
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
