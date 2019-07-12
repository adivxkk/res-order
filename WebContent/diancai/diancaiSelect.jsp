<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="vo.caiping"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
<style type="text/css">  
            /* div{  
                width: 300px;  
                height: 300px;  
                border: #000 solid 1px;  
                margin: 50px auto;  
                overflow: hidden;  
            }   */
            img{  
                cursor: pointer;  
                transition: all 0.6s;  
            }  
            img:hover{  
                transform: scale(2.5);  
            }  
</style>
</head>
<body>
<center>
<h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;餐厅菜单信息查询</h2>
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
<form action="DiancaiSelectServlet" method="post">
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="查询">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="重置">
</form>
<h3>查询结果如下：</h3>
<table border="1" width="80%">
<tr>
    <td >菜品编号</td>
    <td >菜名</td>
    <td >单价</td>
    <td >类别</td>
    <td >图片</td>
  </tr>
<% 
List<caiping> result=(List<caiping>)request.getAttribute("result");
if(result!=null){
	Iterator<caiping> customer=result.iterator();
	caiping customer2=new caiping();
	while(customer.hasNext()){
%>
	<%customer2=customer.next();%>
	<tr>
    <td><%=customer2.getC_id()%></td>
    <td><%=customer2.getC_name()%></td>
    <td><%=customer2.getPrice()%></td>
    <td><%=customer2.getClss()%></td>
  <td><img src="../image/<%=customer2.getPicture() %>" width="20" height="20"/></td>
     </tr>
<%	
	}
}
%>
</table>
</center>

</body>
</html>