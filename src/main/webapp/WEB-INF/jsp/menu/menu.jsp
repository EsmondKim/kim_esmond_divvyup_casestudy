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
                    <input type="number" class="form-control" name="itemId" id="itemId_Id" placeholder="Item Number">
                    <label for="itemId_Id">Item Id</label>
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
                    <td>${menu.id}</td>
                    <td>${menu.item}</td>
                    <td>${menu.description}</td>
                    <td>${menu.price}</td>
                </tr>
            </c:forEach>
        </table>
    </div> <!--col-row-12-->

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

<jsp:include page="../include/footer.jsp"/>