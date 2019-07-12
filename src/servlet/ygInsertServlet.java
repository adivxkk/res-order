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

public class ygInsertServlet extends HttpServlet {
  public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String path = "yuangongInsert.jsp";
    String y_id = new String(req.getParameter("y_id").getBytes("iso-8859-1"), "UTF-8");
    String y_name = new String(req.getParameter("y_name").getBytes("iso-8859-1"), "UTF-8");
    String sex = new String(req.getParameter("sex").getBytes("iso-8859-1"), "UTF-8");
    String age = new String(req.getParameter("age").getBytes("iso-8859-1"), "UTF-8");
    String phone = new String(req.getParameter("phone").getBytes("iso-8859-1"), "UTF-8");
    String address = new String(req.getParameter("address").getBytes("iso-8859-1"), "UTF-8");
    String duty = new String(req.getParameter("duty").getBytes("iso-8859-1"), "UTF-8");
    String performance = new String(req.getParameter("performance").getBytes("iso-8859-1"), "UTF-8");
    List<String> info = new ArrayList<String>();
    if (y_id == null || "".equals(y_id)) {
      info.add("员工编号不能为空");
    }
    if (y_name == null || "".equals(y_name)) {
      info.add("员工姓名不能为空");
    }
    if (sex == null || "".equals(sex)) {
      info.add("性别不能为空");
    }
    if (age == null || "".equals(age)) {
      info.add("年龄不能为空");
    }
    if (phone == null || "".equals(phone)) {
      info.add("电话不能为空");
    }
    if (address == null || "".equals(address)) {
      info.add("地址不能为空");
    }
    if (duty == null || "".equals(duty)) {
      info.add("职务不能为空");
    }
    if (performance == null || "".equals(performance)) {
      info.add("业绩不能为空");
    }
    if (info.size() == 0) { // ����û�м�¼�κεĴ���
      Yuangong yg = new Yuangong();
      yg.setY_id(Integer.parseInt(y_id));
      yg.setY_name(y_name);
      yg.setSex(sex);
      yg.setAge(Integer.parseInt(age));
      yg.setPhone(phone);
      yg.setAddress(address);
      yg.setDuty(duty);
      yg.setPerformance(Float.parseFloat(performance));

      try {
        if (ygimpl.Insertyg(yg)) {
          info.add("添加成功");

        } else {
          info.add("添加失败，请检查添加信息是否正确");
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    req.setAttribute("info", info);
    req.getRequestDispatcher(path).forward(req, resp);
  }

  public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    this.doGet(req, resp);
  }

}
