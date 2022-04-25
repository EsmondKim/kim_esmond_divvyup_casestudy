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
                <th>Total</th>
                <th>Diner</th>
            </tr>

            <c:forEach items="${divvyUpRows}" var="divvyUpRow">
            <tr scope="row">
                <td>${divvyUpRow.item}</td>
                <td>${divvyUpRow.quantity}</td>
                <td>${divvyUpRow.price}</td>
                <td>${divvyUpRow.total}</td>
                <td>${divvyUpRow.diner_nickname}</td>
            </tr>
            </c:forEach>
        </table>
    </div>

    <div class="col-row-12">
        <table class="table">
            <tr scope="row">
                <th>Diner</th>
                <th>Diner's Subtotal</th>
                <th>Diner's Salestax</th>
                <th>Diner's Total</th>
            </tr>

            <c:forEach items="${divvyUpTaxAndTotalRows}" var="divvyUpTaxAndTotalRow">
                <tr scope="row">
                    <td>${divvyUpTaxAndTotalRow.diner_nickname}</td>
                    <td>${divvyUpTaxAndTotalRow.subtotal}</td>
                    <td>${divvyUpTaxAndTotalRow.salestax}</td>
                    <td>${divvyUpTaxAndTotalRow.total}</td>
                </tr>
            </c:forEach>
        </table>
    </div>

<jsp:include page="../include/footer.jsp"/>