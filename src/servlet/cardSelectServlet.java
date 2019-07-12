package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import impl.cardimpl;
import vo.Card;

public class cardSelectServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String path = "cardSelect.jsp";
    List<String> info = new ArrayList<String>();
    List<Card> result = new ArrayList<Card>();
    if (info.size() == 0) {
      try {
        result = cardimpl.Selectcard();
        if (result.size() > 0 && result != null) {
          info.add("查询成功");
        } else {
          info.add("查询失败");
        }
      } catch (Exception e) {
        // TODO: handle exception
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
