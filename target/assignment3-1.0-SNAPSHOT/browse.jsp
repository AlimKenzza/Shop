<%--
  Created by IntelliJ IDEA.
  User: w2
  Date: 17.10.2020
  Time: 23:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Click on the product to add product to your cart:</h1>
<c:forEach items="${requestScope.electronics}" var="electronic">

    <a href="<c:url value="/ElectronicsServlet">
        <c:param name="action" value="addToCart"/>
        <c:param name="electronicId" value="${electronic.key}"/>
        </c:url>">${electronic.value}</a>
    <br/>
</c:forEach>
</body>
</html>
