<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
<center>
<h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;点菜的删除操作</h2>
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
<h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请输入要删除的信息</h3>
<form action="DcDeleteServlet" method="post">
	餐桌编号:<input type="text" name="id" /><br/>
	菜品编号:<input  type="text" name="c_id"/><br />
	点菜时间:<input  type="text" name="ordertime"/><br />
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="删除菜品">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="重置">
</form>
</center>
</body>
</html>