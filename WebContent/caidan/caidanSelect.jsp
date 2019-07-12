<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*,vo.Caidan" %>
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
<h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;顾客菜单信息查询</h2>
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
<form action="CdSelectServlet" method="post">
          餐桌编号：<input type="text" name="id" ><br>
           顾客编号：<input type="text" name="cus_id" ><br>
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="查询">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="重置">
</form>
<h3>查询结果如下：</h3>
<table border="1" width="80%">
<tr>
    <td >菜名</td>
    <td >单价</td>
    <td >数量</td>
    <td >金额</td>
    <td >类别</td>
    <td >图片</td>
  </tr>
<% 
List<Caidan> result=(List<Caidan>)request.getAttribute("result");
if(result!=null){
	Iterator<Caidan> cd=result.iterator();
	Caidan cd1=new Caidan();
	while(cd.hasNext()){
%>
	<%cd1=cd.next();%>
	<tr>
    <td><%=cd1.getC_name()%></td>
    <td><%=cd1.getPrice()%></td>
    <td><%=cd1.getQuantity()%></td>
    <td><%=cd1.getMoney()%></td>
    <td><%=cd1.getClss()%></td>
    <td><img src="../image/<%=cd1.getPicture() %>" width="20" height="20"/></td>
    </tr>
<%	
	}
}
%>
</table>
</center>

</body>
</html>