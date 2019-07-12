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
<h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;菜品的修改操作</h2>
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
<h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请输入要修改的信息</h3>
<form action="cpUpdateServlet" method="post">
	编号:<input type="text" name="id" /><br/>
	菜名:<input  type="text" name="name"/><br />
	单价:<input  type="text" name="price"/><br />
	库存量:<input  type="text" name="stock"/><br />
	类别:<input  type="text" name="clss"/><br />
	图片:<input  type="text" name="picture"/><br />
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="修改">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="重置">
</form>
</center>

</body>
</html>