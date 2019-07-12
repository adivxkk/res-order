<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*,dbc.DBUtils" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>餐厅点餐管理系统</title>
</head>
<body>
<%
    request.setCharacterEncoding("UTF-8");
    String account=(String)request.getParameter("account");
    String password=(String)request.getParameter("password");//取出login.jsp的值
    String select=(String)request.getParameter("select");
    request.getSession().setAttribute("account",account);//登录成功显示登入对象账号
    //下面是数据库操作
    if(select.equals("顾客")){
    Connection conn = null;                 //声明Connection对象
	CallableStatement pstmt = null;         //声明PreparedStatement对象
	conn = DBUtils.getConnection();
	pstmt = conn.prepareCall("{call dbo.查询登入用户(?,?)}");
    pstmt.setString(1,account);
    pstmt.setString(2,select);
    ResultSet rs=null;   //结果集
    rs=pstmt.executeQuery();
    if(rs.next())
    {
        if(password.equals(rs.getString("admin_password"))){
            response.sendRedirect("jiemian/gukesuccess.jsp");
        }
        else{
            out.print("<script language='javaScript'> alert('密码错误');</script>");
            response.setHeader("refresh", "0;url=loginuserSelect.jsp");
        }
    }
    else 
    {
        out.print("<script language='javaScript'> alert('账号错误——else');</script>");
        response.setHeader("refresh", "0;url=loginuserSelect.jsp");
    }
  }
    else if(select.equals("服务员")){
        Connection conn = null;                 //声明Connection对象
    	CallableStatement pstmt = null;         //声明PreparedStatement对象
    	conn = DBUtils.getConnection();
    	pstmt = conn.prepareCall("{call dbo.查询登入用户(?,?)}");
        pstmt.setString(1,account);
        pstmt.setString(2,select);
        ResultSet rs=null;   //结果集
        rs=pstmt.executeQuery();
        if(rs.next())
        {
            if(password.equals(rs.getString(1))){
                response.sendRedirect("jiemian/fuwuyuansuccess.jsp");
            }
            else{
                out.print("<script language='javaScript'> alert('密码错误');</script>");
                response.setHeader("refresh", "0;url=loginuserSelect.jsp");
            }
        }
        else 
        {
            out.print("<script language='javaScript'> alert('账号错误——else');</script>");
            response.setHeader("refresh", "0;url=loginuserSelect.jsp");
        }
      }
    else{
      Connection conn = null;                 //声明Connection对象
  	CallableStatement pstmt = null;         //声明PreparedStatement对象
  	conn = DBUtils.getConnection();
  	pstmt = conn.prepareCall("{call dbo.查询登入用户(?,?)}");
      pstmt.setString(1,account);
      pstmt.setString(2,select);
      ResultSet rs=null;   //结果集
      rs=pstmt.executeQuery();
      if(rs.next())
      {
          if(password.equals(rs.getString(1))){
              response.sendRedirect("jiemian/jinglisuccess.jsp");
          }
          else{
              out.print("<script language='javaScript'> alert('密码错误');</script>");
              response.setHeader("refresh", "0;url=loginuserSelect.jsp");
          }
      }
      else 
      {
          out.print("<script language='javaScript'> alert('账号错误——else');</script>");
          response.setHeader("refresh", "0;url=loginuserSelect.jsp");
      }
    }
%>

</body>
</html>