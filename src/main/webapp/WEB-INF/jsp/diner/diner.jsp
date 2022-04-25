<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>
<title>Richie M's | Add Diners</title>

<body id="menu-body">

<div class="container">

    <h1>Add Diner</h1>

    <div class="col-row-12">
        <form class="wrapper" action="/diner/submit" method="post">
            <div class="row"><!--registration fields row-->
                <div class="form-floating mb-3">
                    <input type="text" class="form-control" name="dinerNickname" id="dinerNicknameId" placeholder="Diner Nickname">
                    <label for="dinerNicknameId">Diner Nickname</label>
                    <c:forEach items='${bindingResult.getFieldErrors("dinerNickname")}' var="error">
                        <div style="color:red;">${error.getDefaultMessage()}</div>
                    </c:forEach>
                </div> <!--form-floating mb-3-->
                <div class="form-floating mb-3">
                    <input type="number" class="form-control" name="seatNumber" id="seatNumberId" placeholder="Seat Number" value=${form.seatNumber}>
                    <label for="seatNumberId">Seat Number</label>
                    <c:forEach items='${bindingResult.getFieldErrors("seatNumber")}' var="error">
                        <div style="color:red;">${error.getDefaultMessage()}</div>
                    </c:forEach>
                </div> <!--form-floating mb-3-->
                <button type="submit">Submit</button>
            </div><!--diners fields row-->
        </form>
    </div> <!--col-row-12-->

<jsp:include page="../include/footer.jsp"/>