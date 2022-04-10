<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp"/>
<title>Richie M's | Menu</title>

<body id="menu-body">

<ul class="nav nav-tabs"><!--Bootstrap Nav-->
    <li class="nav-item">
        <a class="nav-link active" aria-current="page" href="/index">Sign In</a>
    </li>
    <li class="nav-item">
        <a class="nav-link nav-text" href="/user/registration">Registration</a>
    </li>
    <li class="nav-item">
        <a class="nav-link nav-text" href="./menu.html">Menu</a>
    </li>
</ul><!--Bootstrap Nav-->

<div class="container">

    <h1>Menu Page</h1>

    <table class="table">
        <tr scope="row">
            <th>Dish</th>
            <th>Description</th>
            <th>Price</th>
        </tr>

        <c:forEach items="${menuValue}" var="menu">
            <tr scope="row">
                <td>${menu.dish}</td>
                <td>${menu.description}</td>
                <td>${menu.price}</td>
            </tr>
        </c:forEach>

    </table>

<jsp:include page="../include/footer.jsp"/>