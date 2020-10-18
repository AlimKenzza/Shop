<%--
  Created by IntelliJ IDEA.
  User: w2
  Date: 18.10.2020
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Cookie email = new Cookie("email" , request.getParameter("email"));
    Cookie phone = new Cookie("phone", request.getParameter("phone"));
    Cookie country = new Cookie("country", request.getParameter("country"));
    email.setMaxAge(60*60*10);
    phone.setMaxAge(60*60*10);
    country.setMaxAge(60*60*10);
    response.addCookie(email);
    response.addCookie(phone);
    response.addCookie(country);
%>
<b>Email: </b>
<%= request.getParameter("email")%><br>
<b>PhoneNumber: </b>
<%= request.getParameter("phone")%><br>
<b>Country: </b>
<%=request.getParameter("country")%>
<hr>
</body>
</html>
