<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>

<h1>Search</h1>

<form action="/menu/search" method="get">
    <input type="text" name="item" id="itemId" value="${item}" placeholder="Search For A Menu Item">
    <button type="submit">Submit</button>
</form>

<table class="table">
    <tr scope="row">
        <th>Item</th>
        <th>Description</th>
        <th>Price</th>
    <c:forEach items="${items}" var="item" varStatus="loop">
    <tr scope="row">
            <td><c:out value="${items[loop.index].item}"/></td>
            <td><c:out value="${items[loop.index].description}"/></td>
            <td><c:out value="${items[loop.index].price}"/></td>
    </tr>
    </c:forEach>
</table>