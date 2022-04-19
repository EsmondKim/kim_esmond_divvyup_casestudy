<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Richie M's | The DivvyUp</title>
<jsp:include page="../include/header.jsp"/>

<script src="../../../public/scripts/divvyupscript.js"></script>

<div class="container">
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
        </table>
    </div>

    <div>
        <table class="table col-row-6">
            <thead>
            <tr>
                <th scope="col">Diner Name</th>
            </tr>
            </thead>
            <tbody id="tbody-names">
            </tbody>
        </table>

        <table class="table col-row-6">
            <thead>
            <tr>
                <th scope="col">Diner Subtotal</th>
                <th scope="col">Diner Salestax</th>
                <th scope="col">Diner Total</th>
            </tr>
            </thead>
            <tbody id="tbody-prices">

            </tbody>
        </table>
    </div>

<jsp:include page="../include/footer.jsp"/>