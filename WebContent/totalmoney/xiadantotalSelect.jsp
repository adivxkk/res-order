<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="vo.Xiadantotal"%>
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
<h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;顾客下单总金额信息查询</h2>
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
<form action="XdtSelectServlet" method="post">
          餐桌编号：<input type="text" name="id" ><br>
           顾客编号：<input type="text" name="cus_id" ><br>
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="查询">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="重置">
</form>
<h3>查询结果如下：</h3>
<table border="1" width="80%">
<tr>
    <td >餐桌编号</td>
    <td >顾客编号</td>
    <td >下单总金额</td>
</tr>
	<tr>
    <td><%=request.getParameter("id")%></td>
    <td><%=request.getParameter("cus_id")%></td>
    <td><%=request.getAttribute("totalmoney")%></td>
    </tr>
</table>
</center>
</body>
</html>