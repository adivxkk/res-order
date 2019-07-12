<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工信息修改</title>
<style type="text/css">
 input{
    margin-bottom:10px;
}
</style>
</head>
<body>
<center>
<h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;员工的修改操作</h2>
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
<form action="ygUpdateServlet" method="post">
          员工编号：<input type="text" name="y_id" ><br>
           姓名：<input type="text" name="y_name" ><br>       
	性别：<input type="text" name="sex" ><br>
	年龄：<input type="text" name="age"><br>
	电话：<input type="text" name="phone" ><br>
	住址：<input type="text" name="address" ><br>
	职务：<input type="text" name="duty" ><br>
	业绩：<input type="text" name="performance" ><br>
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="修改">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="重置">
</form>
</center>
</body>
</html>