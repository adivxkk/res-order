<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="java.util.*,vo.Yuangong" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>员工信息查询</title>
</head>
<body>
<center>
<h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;员工业绩排行</h2>
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
<form action="yjSelectServlet" method="post">
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="查询">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="重置">
</form>
<h3>查询结果如下：</h3>
<table border="1" width="80%">
<tr>
    <td >编号</td>
    <td >姓名</td>
    <td >业绩</td>
  </tr>
<% 
List<Yuangong> result=(List<Yuangong>)request.getAttribute("result");
if(result!=null){
	Iterator<Yuangong> yg=result.iterator();
	Yuangong yg1=new Yuangong();
	while(yg.hasNext()){
%>
	<%yg1=yg.next();%>
	<tr>
    <td><%=yg1.getY_id()%></td>
    <td><%=yg1.getY_name()%></td>
    <td><%=yg1.getPerformance()%></td>
    </tr>
<%	
	}
}
%>
</table>
</center>

</body>
</html>