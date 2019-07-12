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

public class cardsingleSelectServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String path = "cardsingleSelect.jsp";
    String card_id = new String(req.getParameter("card_id").getBytes("iso-8859-1"), "UTF-8");
    List<String> info = new ArrayList<String>();
    List<Card> result = new ArrayList<Card>();
    if (card_id == null || "".equals(card_id)) {
      info.add("卡号不能为空");
    }
    if (info.size() == 0) {
      Card card = new Card();
      card.setCard_id(card_id);
      try {
        result = cardimpl.Selectcardsingle(card);
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
