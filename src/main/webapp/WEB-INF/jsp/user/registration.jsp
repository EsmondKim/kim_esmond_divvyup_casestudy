<jsp:include page="../include/header.jsp"/>
<title>Richie M's | Registration</title>

<%--<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>--%>
<%--<script>--%>
<%--    $( document ).ready(function() {--%>
<%--        console.log( "ready!" );--%>
<%--    });--%>
<%--</script>--%>

<div class="container">

    <form class="wrapper" action="/user/registerSubmit", method="post">
        <div class="row"><!--registration fields row-->
            <input type="hidden" name="id" value="${form.id}">

            <div class="form-floating mb-3">
                <input type="text" class="form-control" name="firstName" id="firstNameId" value="${form.firstName}" placeholder="First Name">
                <label for="firstNameId">First Name</label>
            </div> <!--form-floating mb-3-->

            <div class="form-floating mb-3">
                <input type="text" class="form-control" name="lastName" id="lastNameId" value="${form.lastName}" placeholder="Last Name">
                <label for="lastNameId">Last Name</label>
            </div> <!--form-floating mb-3-->

            <div class="form-floating mb-3">
                <input type="email" class="form-control" name="email" id="emailId" value="${form.email}" placeholder="name@example.com">
                <label for="emailId">Email Address</label>
            </div> <!--form-floating mb-3-->

            <div class="form-floating mb-3">
                <input type="password" class="form-control" name="password" id="passwordId" value="${form.password}" placeholder="Password">
                <label for="passwordId">Password</label>
            </div> <!--form-floating mb-3-->

            <div class="form-floating">
                <input type="password" class="form-control" name="confirmPassword" id="confirmPasswordId" value="${form.password}" placeholder="Confirm Password">
                <label for="confirmPasswordId">Confirm Password</label>
            </div> <!--form-floating-->

            <button type="submit" class="btn btn-info"
                    style="margin-top: 20px; margin-left: 8px; width: 84px; height: 45px; font-size:14px;
          font-weight:700">
                Submit</button>
            <!-- <pre><p>Not a Member? Click <a href="./registration.html">here</a> to register for Richie M's Restaurant Menu App.</p></pre> -->
        </div><!--registration fields row-->
    </form>



<%--<script>--%>
<%--    $( "button" ).on( "click", function() {--%>
<%--        console.log("clicked!")--%>
<%--        window.location.href = "./menu.html";--%>
<%--    });--%>
<%--</script>--%>

<jsp:include page="../include/footer.jsp"/>