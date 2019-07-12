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

public class CdInsertServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String path = "cardInsert.jsp";
    String card_id = new String(req.getParameter("card_id").getBytes("iso-8859-1"), "UTF-8");
    String cus_id = new String(req.getParameter("cus_id").getBytes("iso-8859-1"), "UTF-8");
    String level = new String(req.getParameter("level").getBytes("iso-8859-1"), "UTF-8");
    String discount = new String(req.getParameter("discount").getBytes("iso-8859-1"), "UTF-8");
    String point = new String(req.getParameter("point").getBytes("iso-8859-1"), "UTF-8");
    String money = new String(req.getParameter("money").getBytes("iso-8859-1"), "UTF-8");
    String y_id = new String(req.getParameter("y_id").getBytes("iso-8859-1"), "UTF-8");
    List<String> info = new ArrayList<String>();// 收集错误信息
    if (card_id == null || "".equals(card_id)) {
      info.add("卡号不能为空");
    }
    if (cus_id == null || "".equals(cus_id)) {
      info.add("顾客编号不能为空");
    }
    if (level == null || "".equals(level)) {
      info.add("等级不能为空");
    }
    if (discount == null || "".equals(discount)) {
      info.add("折扣不能为空");
    }

    if (point == null || "".equals(point)) {
      info.add("积分不能为空");
    }
    if (money == null || "".equals(money)) {
      info.add("金额不能为空");
    }

    if (y_id == null || "".equals(y_id)) {
      info.add("员工编号不能为空");
    }
    if (info.size() == 0) {// 里面没有记录任何错误
      Card card = new Card();
      card.setCard_id(card_id);
      card.setCus_id(Integer.parseInt(cus_id));
      card.setDiscount(Float.parseFloat(discount));
      card.setLevel(Integer.parseInt(level));
      card.setMoney(Float.parseFloat(money));
      card.setPoint(Integer.parseInt(point));
      card.setY_id(Integer.parseInt(y_id));
      try {
        if (cardimpl.Insertcd(card)) {
          info.add("会员添加成功");
        } else {
          info.add("添加失败，请检查添加的信息是否正确");

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
