<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*,vo.caiping" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
<center>
<h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;菜品信息查询</h2>
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
<form action="cpSelectServlet" method="post">
           输入编号：<input type="text" name="caipingNO" ><br>
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="查询">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="重置">
</form>
<h3>查询结果如下：</h3>
<table border="1" width="80%">
<tr>
    <td >编号</td>
    <td >菜品</td>
    <td >单价</td>
    <td >库存量</td>
    <td >类别</td>
    <td >图片</td>
  </tr>
<% 
List<caiping> result=(List<caiping>)request.getAttribute("result");
if(result!=null){
	Iterator<caiping> cp=result.iterator();
	caiping cp1=new caiping();
	while(cp.hasNext()){
%>
	<%cp1=cp.next();%>
	<tr>
    <td><%=cp1.getC_id()%></td>
    <td><%=cp1.getC_name()%></td>
    <td><%=cp1.getPrice()%></td>
    <td><%=cp1.getStock()%></td>
    <td><%=cp1.getClss()%></td>
    <td><img src="../image/<%=cp1.getPicture() %>" width="20" height="20"/></td>
    </tr>
<%	
	}
}
%>
</table>
</center>
</body>
</html>