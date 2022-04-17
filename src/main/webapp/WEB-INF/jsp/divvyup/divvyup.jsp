<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Richie M's | The DivvyUp</title>
<jsp:include page="../include/header.jsp"/>
<h1>The DivvyUp</h1>
<div class="col-row-12">
    <table class="table">
        <tr scope="row">
            <th>Item</th>
            <th>Quantity</th>
            <th>Price</th>
            <th>Seat ID</th>
            <th>Diner</th>
        </tr>

        <c:forEach items="${dinerMenu}" var="dinerMenu">
        <tr scope="row">
            <td>${dinerMenu.getMenu().getItem()}</td>
            <td>${dinerMenu.getQuantity()}</td>
            <td>${dinerMenu.getMenu().getPrice()}</td>
            <td>${dinerMenu.getDiner().getSeatNumber()}</td>
            <td>${dinerMenu.getDiner().getDinerNickname()}</td>
        </tr>
        </c:forEach>

<jsp:include page="../include/footer.jsp"/>