<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>
<title>Richie M's | Menu</title>

<body id="menu-body">

<div class="container">
    <div class="col-row-12">
        <form class="wrapper" action="/diner/submit" method="post">
            <div class="row"><!--registration fields row-->
                <div class="form-floating mb-3">
                    <input type="text" class="form-control" name="diner_nickname" id="dinerNicknameId" placeholder="Diner Nickname">
                    <label for="dinerNicknameId">Diner Nickname</label>
                </div> <!--form-floating mb-3-->
                <div class="form-floating mb-3">
                    <input type="text" class="form-control" name="seat_number" id="seatNumberId" placeholder="Seat Number">
                    <label for="seatNumberId">Seat Number</label>
                </div> <!--form-floating mb-3-->
                <div class="form-floating mb-3">
                    <input type="text" class="form-control" name="credit_card" id="creditCardId" placeholder="Credit Card">
                    <label for="creditCardId">Credit Card</label>
                </div> <!--form-floating mb-3-->
                <button type="submit">Submit</button>
            </div><!--diners fields row-->
        </form>
    </div> <!--col-row-12-->

    <div class="col-row-12">
        <table class="table">
            <tr scope="row">
                <th>Dish</th>
                <th>Description</th>
                <th>Price</th>
            </tr>

            <c:forEach items="${menuValue}" var="menu">
                <tr scope="row">
                    <td>${menu.item}</td>
                    <td>${menu.description}</td>
                    <td>${menu.price}</td>
                </tr>
            </c:forEach>
        </table>
    </div> <!--col-row-12-->

<jsp:include page="../include/footer.jsp"/>