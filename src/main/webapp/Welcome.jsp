<%@ page import="classes.Football" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"   %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/navbar.css">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<%
    if(session.getAttribute("username") == null) {
        response.sendRedirect("index.jsp");
    }
%>
<nav class="navbar navbar-icon-top navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="#">AllShop</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="#">
                    <i class="fa fa-home"></i>
                    Home
                    <span class="sr-only">(current)</span>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">
                    <i class="fa fa-envelope-o">
                        <span class="badge badge-danger">11</span>
                    </i>
                    Link
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link disabled" href="#">
                    <i class="fa fa-envelope-o">
                        <span class="badge badge-warning">11</span>
                    </i>
                    Disabled
                </a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <i class="fa fa-envelope-o">
                        <span class="badge badge-primary">11</span>
                    </i>
                    Dropdown
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="#">Action</a>
                    <a class="dropdown-item" href="#">Another action</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#">Something else here</a>
                </div>
            </li>
        </ul>
        <ul class="navbar-nav ">
            <li class="nav-item">
                <a class="nav-link" href="#">
                    <i class="fa fa-bell">
                        <span class="badge badge-info">11</span>
                    </i>
                    Test
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">
                    <i class="fa fa-globe">
                        <span class="badge badge-success">11</span>
                    </i>
                    Test
                </a>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>

<!-- Page Content -->

    <h1 class="mt-4">In our shop you can find all you need!</h1>
    <p>Select items from gadgets or sport equipment.</p>

<h1><c:out value="Welcome ${username}" /></h1>
<form action="/servlets.LogoutServlet">
    <input type="submit" name="submit" value="Logout">
</form>
<form action="/servlets.InfoServlet" method="post">
    <input type="submit" name="submit" value="pay">
</form>
<%--<c:forEach items="${products}" var="footballs">--%>
<%--        ${footballs} <a href="/CartServlet">Add to cart</a><br/>--%>
<%--</c:forEach>--%>
<a href="/ElectronicsServlet">Electronics</a>
<table cellpadding="2"cellspacing="2" border="1">
    <tr>
        <th>Id</th>
        <th>Item_name</th>
        <th>Price</th>
        <th>Add to cart</th>
    </tr>
<%--    take data from getAllFootballs function--%>
<% Football football = new Football();
ArrayList<Football> list = football.getAllFootballs();
 request.setAttribute("products", list);
%>
<%--    user jstl foreach in order to show them--%>
    <c:forEach items="${products}" var="list">
        <tr>
            <td><c:out value="${list.id}"></c:out></td>
            <td><c:out value="${list.item_name}"></c:out></td>
            <td><c:out value="${list.price} "></c:out></td>
            <td align="center"><a href="ShoppingCartServlet?id=<c:out value="${list.id}"/>&action=ordernow">OrderNow</a></td>
        </tr>
    </c:forEach></table>
<hr>
<h1>Please enter your personal information here</h1>
<%--form to set cookies --%>
<form action="cookie.jsp" method="get">
    Email: <input type="email" name="email">
    PhoneNumber: <input type="text" name="phone">
    Country: <input type="text" name="country">
    <input type="submit" value="submit">
</form>
<hr>

<h1>List of Cities where you can find us</h1>
<%--use jstl foreach in order to access all cities and show them--%>
<c:forEach items="${states}" var="cities">
    ${cities} <br/>

</c:forEach>

</body>
</html>
