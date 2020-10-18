<%@ page import="classes.Football" %><%--
  Created by IntelliJ IDEA.
  User: w2
  Date: 18.10.2020
  Time: 12:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% Football football = new Football(); %>
<table cellspacing="2" cellpadding="2" border="1">
    <tr>
        <th>Option</th>
        <th>Id</th>
        <th>Item_name</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Total</th>
    </tr>
    <c:forEach items="${sessionScope.cart}" var="p">
        <tr>
            <td align="center">DELETE</td>
            <td>${p.id}</td>
            <td>${p.item_name}</td>
            <td>${p.price}}</td>
            <td>${p.quantity}</td>
            <td>${p.quantity*p.football.price}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
