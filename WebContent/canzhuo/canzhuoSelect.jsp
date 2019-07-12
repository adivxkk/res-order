<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="vo.Canzhuo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.*,vo.Canzhuo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
<center>
<h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;空闲餐桌信息查询</h2>
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
<form action="CzSelectServlet" method="post">
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="查询">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="重置">
</form>
<h3>查询结果如下：</h3>
<table border="1" width="80%">
<tr>
    <td >餐桌编号</td>
    <td >容纳人数</td>
    <td >状态</td>
    <td >位置</td>
  </tr>
<% 
List<Canzhuo> result=(List<Canzhuo>)request.getAttribute("result");
if(result!=null){
	Iterator<Canzhuo> cz=result.iterator();
	Canzhuo cz1=new Canzhuo();
	while(cz.hasNext()){
%>
	<%cz1=cz.next();%>
	<tr>
    <td><%=cz1.getId()%></td>
    <td><%=cz1.getNumber()%></td>
    <td><%=cz1.getStatus() %></td>
    <td><%=cz1.getLocation() %></td>
    </tr>
<%	
	}
}
%>
</table>
</center>

</body>
</html>