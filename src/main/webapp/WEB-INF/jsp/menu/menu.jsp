<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>
<title>Richie M's | Menu</title>

<body id="menu-body">

<div class="container">

    <h1>Current Diners</h1>
    <div class="col-row-12">
        <table class="table">
            <tr scope="row">
                <th>Diner Nickname</th>
                <th>Seat Number</th>
            </tr>
            <c:forEach items="${dinerValue}" var="diner">
                <tr scope="row">
                    <td>${diner.dinerNickname}</td>
                    <td>${diner.seatNumber}</td>
                </tr>
            </c:forEach>
        </table>
    </div> <!--col-row-12-->

    <h1>Add Dish To Diner's Order</h1>
    <div class="col-row-12">
        <form class="wrapper" action="/menu/menuSubmit" method="post">
            <div class="row"><!--registration fields row-->
                <div class="form-floating mb-3">
                    <input type="text" class="form-control" name="seatNumberId" id="seatNumberId_Id" placeholder="Diner Seat Number">
                    <label for="seatNumberId_Id">Diner Seat Number</label>
                </div> <!--form-floating mb-3-->
                <div class="form-floating mb-3">
                    <label for="itemId_Id">Choose a menu item:</label>
                    <select type="number" name="itemId" id="itemId_Id">
                        <c:forEach items="${menuValue}" var="menu">
                            <option value=${menu.id}>${menu.item}</option>
                        </c:forEach>
                    </select>
                </div> <!--form-floating mb-3-->
                <div class="form-floating mb-3">
                    <input type="text" class="form-control" name="quantity" id="quantityId" placeholder="quantity">
                    <label for="quantityId">Quantity</label>
                </div> <!--form-floating mb-3-->
                <button type="submit">Submit</button>
            </div><!--diners fields row-->
        </form>
    </div> <!--col-row-12-->

    <h1>Menu</h1>
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