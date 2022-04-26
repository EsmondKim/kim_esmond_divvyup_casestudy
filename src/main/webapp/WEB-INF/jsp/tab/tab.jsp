<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>

<link rel="stylesheet" href="../../../public/css/styles_navbar_and_tables.css">
<title>Richie M's | The Tab</title>

<h1>The Tab</h1>
<div class="col-row-12">
    <table class="table">
        <tr scope="row">
            <th>Item</th>
            <th>Quantity</th>
            <th>Price</th>
            <th>Total</th>
        </tr>

        <c:forEach items="${tabRows}" var="tabRow">
        <tr scope="row">
            <td>${tabRow.item}</td>
            <td>${tabRow.quantity}</td>
            <td>${tabRow.price}</td>
            <td>${tabRow.total}</td>
        </tr>
        </c:forEach>
    </table>
</div>

<div class="col-row-12">
    <table class="table">
        <tr scope="row">
            <th>Subtotal</th>
            <th>Salestax</th>
            <th>Total</th>
        </tr>

        <c:forEach items="${taxAndTotalRows}" var="taxAndTotalRow">
            <tr scope="row">
                <td>${taxAndTotalRow.subtotal}</td>
                <td>${taxAndTotalRow.salestax}</td>
                <td>${taxAndTotalRow.total}</td>
            </tr>
        </c:forEach>
    </table>
</div>

<jsp:include page="../include/footer.jsp"/>