<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp"/>
<title>Richie M's | Registration</title>

<%--<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>--%>
<%--<script>--%>
<%--    $( document ).ready(function() {--%>
<%--        console.log( "ready!" );--%>
<%--    });--%>
<%--</script>--%>

<div class="container">

    <c:if test="${empty form.id}">
    <h1>Sign Up</h1>
    </c:if>

    <c:if test="${not empty form.id}">
    <h1>Edit User</h1>
    </c:if>

    <form class="wrapper" action="/user/registerSubmit", method="get">
        <div class="row"><!--registration fields row-->
            <input type="hidden" name="id" value="${form.id}">

            <div class="form-floating mb-3">
                <input type="text" class="form-control" name="firstName" id="firstNameId" value="${form.firstName}">
                <label for="firstNameId">First Name</label>
                <c:forEach items='${bindingResult.getFieldErrors("firstName")}' var="error">
                    <div style="color:red;">${error.getDefaultMessage()}</div>
                </c:forEach>
            </div> <!--form-floating mb-3-->

            <div class="form-floating mb-3">
                <input type="text" class="form-control" name="lastName" id="lastNameId" value="${form.lastName}">
                <label for="lastNameId">Last Name</label>
                <c:forEach items='${bindingResult.getFieldErrors("lastName")}' var="error">
                    <div style="color:red;">${error.getDefaultMessage()}</div>
                </c:forEach>
            </div> <!--form-floating mb-3-->

            <div class="form-floating mb-3">
                <input type="email" class="form-control" name="email" id="emailId" value="${form.email}">
                <label for="emailId">Email Address</label>
                <c:forEach items='${bindingResult.getFieldErrors("email")}' var="error">
                    <div style="color:red;">${error.getDefaultMessage()}</div>
                </c:forEach>
            </div> <!--form-floating mb-3-->

            <div class="form-floating mb-3">
                <input type="password" class="form-control" name="password" id="passwordId" value="${form.password}">
                <label for="passwordId">Password</label>
                <c:forEach items='${bindingResult.getFieldErrors("password")}' var="error">
                    <div style="color:red;">${error.getDefaultMessage()}</div>
                </c:forEach>
            </div> <!--form-floating mb-3-->

            <div class="form-floating">
                <input type="password" class="form-control" name="confirmPassword" id="confirmPasswordId" value="${form.password}">
                <label for="confirmPasswordId">Confirm Password</label>
                <c:forEach items='${bindingResult.getFieldErrors("confirmPassword")}' var="error">
                    <div style="color:red;">${error.getDefaultMessage()}</div>
                </c:forEach>
            </div> <!--form-floating-->

            <button type="submit" class="btn btn-info"
                    style="margin-top: 20px; margin-left: 8px; width: 84px; height: 45px; font-size:14px;
          font-weight:700">
                Submit</button>
            <!-- <pre><p>Not a Member? Click <a href="./registration.html">here</a> to register for Richie M's Restaurant Menu App.</p></pre> -->
        </div><!--registration fields row-->
    </form>

<jsp:include page="../include/footer.jsp"/>