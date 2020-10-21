<%--
  Created by IntelliJ IDEA.
  User: w2
  Date: 18.10.2020
  Time: 18:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
h1>You have these items in your cart:</h1>
<c:forEach items="${requestScope.cartt}" var="carttItem">
    ${carttItem.key}  - ${carttItem.value}
    <br/>
</c:forEach>
<a href="<c:url value="/ElectronicsServlet"><c:param name="action" value="browse" /></c:url>">Back to Browse</a>
<a href="<c:url value="/ElectronicsServlet"><c:param name="action" value="empty" /></c:url>">Empty cart</a>
</body>
</html>
