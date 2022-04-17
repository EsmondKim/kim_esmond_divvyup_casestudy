<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Richie M's | The Tab</title>
<jsp:include page="../include/header.jsp"/>
<h1>The Tab</h1>
<div class="col-row-12">
    <table class="table">
        <tr scope="row">
            <th>Item</th>
            <th>Quantity</th>
            <th>Price</th>
        </tr>

        <c:forEach items="${dinerMenu}" var="dinerMenu">
        <tr scope="row">
            <td>${dinerMenu.getMenu().getItem()}</td>
            <td>${dinerMenu.getQuantity()}</td>
            <td>${dinerMenu.getMenu().getPrice()}</td>
        </tr>
        </c:forEach>
    </table>

    <div class="col-row-12">
        <table class="table">
            <tr scope="row">
                <td>Subtotal: </td>
                <td>${subtotal}</td>
            </tr>
            <tr scope="row">
                <td>Salestax: </td>
                <td>${salesTax}</td>
            </tr>
            <tr scope="row">
                <td>Total: </td>
                <td>${tabTotal}</td>
            </tr>
        </table>

<jsp:include page="../include/footer.jsp"/>