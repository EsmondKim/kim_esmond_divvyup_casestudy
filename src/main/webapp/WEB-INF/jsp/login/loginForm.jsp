<jsp:include page="../include/header.jsp"/>
<title>Richie M's | Login</title>


<body>

<div class="container">
    <h1>Login Page.</h1>

    <div class="col-row-12">
        <form class="wrapper" action="/login/loginSubmit" method="POST">
            <div class="form-floating mb-3">
                <input type="hidden" name="id" value="${form.id}">
                Username : <input type="text" name="username">
            </div> <!--form-floating mb-3-->
            <br>
            <div class="form-floating mb-3">
                Password : <input type="text" name="password">
                <br>
            </div> <!--form-floating mb-3-->
            <button type="submit">Submit</button>
        </form>
    </div> <!--col-row-12-->

<jsp:include page="../include/footer.jsp"/>