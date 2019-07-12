<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*,vo.Customer" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
<center>
<h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;顾客所有信息查询</h2>
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
<form action="gukeSelectServlet" method="post">
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="查询">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="重置">
</form>
<h3>查询结果如下：</h3>
<table border="1" width="80%">
<tr>
    <td >顾客编号</td>
    <td >卡号</td>
    <td >姓名</td>
    <td >电话</td>
  </tr>
<% 
List<Customer> result=(List<Customer>)request.getAttribute("result");
if(result!=null){
	Iterator<Customer> customer=result.iterator();
	Customer customer2=new Customer();
	while(customer.hasNext()){
%>
	<%customer2=customer.next();%>
	<tr>
    <td><%=customer2.getCus_id()%></td>
    <td><%=customer2.getCard_id()%></td>
    <td><%=customer2.getCus_name()%></td>
    <td><%=customer2.getCus_phone()%></td>
     </tr>
<%	
	}
}
%>
</table>
</center>

</body>
</html>