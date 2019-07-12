<%@page import="vo.Yuangong"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*,vo.Yuangong"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工信息查询</title>
<style type="text/css">
 input{
    margin-bottom:10px;
}
</style>
</head>
<body>
<center>
<h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;员工信息查询</h2>
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
<form action="ygSelectServlet" method="post">
           输入员工编号：<input type="text" name="y_id" ><br>
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="查询">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="重置">
</form>
<h3>查询结果如下：</h3>
<table border="1" width="80%">
<tr>
    <td >编号</td>
    <td >姓名</td>
    <td >性别</td>
    <td >年龄</td>
    <td >电话</td>
    <td >地址</td>
    <td >职务</td>
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
    <td><%=yg1.getSex()%></td>
    <td><%=yg1.getAge()%></td>
    <td><%=yg1.getPhone()%></td>
    <td><%=yg1.getAddress()%></td>
    <td><%=yg1.getDuty()%></td>
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