<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>餐厅点餐管理系统</title>
</head>
<body>
<center>
<h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;登录餐厅点餐系统</h3>
<% 
request.setCharacterEncoding("GBK");
%>
<%
List<String> info=(List<String>)request.getAttribute("info");
if(info!=null){
	Iterator<String> iter=info.iterator();
	while(iter.hasNext()){
%>
    <h4><%=iter.next()%></h4>
<%
   }
  }
%>
<form action="logincheck.jsp" method="post">
          账号：<input type="text" name="account" /><br>
          密码：<input type="password" name="password" /><br>
          <!--这个地方使用什么标签呢，先放着吧，最后在写  -->
 	  权限：<select name="select">
          <option value="顾客">顾客</option>
          <option value="服务员">服务员</option>
          <option value="经理">经理</option>
          </select> </br></br>    
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="登录" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="重置" />
</form>
</center>
</body>
</html>