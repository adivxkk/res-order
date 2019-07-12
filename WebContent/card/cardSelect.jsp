<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="vo.Card"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*,vo.Card" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
<center>
<h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;会员信息查询</h2>
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
<form action="cardSelectServlet" method="post">
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="查询">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="重置">
</form>
<h3>查询结果如下：</h3>
<table border="1" width="80%">
<tr>
    <td >卡号</td>
    <td >顾客编号</td>
    <td >等级</td>
    <td >折扣</td>
    <td >积分</td>
    <td >金额</td>
    <td >员工编号</td>
  </tr>
<% 
List<Card> result=(List<Card>)request.getAttribute("result");
if(result!=null){
	Iterator<Card> card=result.iterator();
	Card card1=new Card();
	while(card.hasNext()){
%>
	<%card1=card.next();%>
	<tr>
    <td><%=card1.getCard_id()%></td>
    <td><%=card1.getCus_id()%></td>
    <td><%=card1.getLevel()%></td>
    <td><%=card1.getDiscount()%></td>
    <td><%=card1.getPoint()%></td>
    <td><%=card1.getMoney() %></td>
    <td><%=card1.getY_id() %></td>
    </tr>
<%	
	}
}
%>
</table>
</center>

</body>
</html>