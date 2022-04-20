<jsp:include page="../include/header.jsp"/>
<title>Richie M's | Login</title>

<body>

<div class="container">
    <h1>Login Page.</h1>

    <form class="wrapper" action="/login/loginSubmit" method="POST">
        <div class="col-row-12">
            <div class="form-floating mb-3">
                <input type="hidden" name="id" value="${form.id}">
                Username : <input type="email" class="form-control" id="signInEmail" name="username" placeholder="name@example.com">
                <label for="signInEmail">Email address</label>
            </div> <!--form-floating mb-3-->
            <br>
            <div class="form-floating">
                Password : <input type="password" class="form-control" id="signInPassword" name="password" placeholder="password">
                <label for="signInPassword">Password</label>
            <br>
            </div> <!--form-floating mb-3-->
            <button type="submit">Submit</button>
        </div> <!--col-row-12-->
    </form>


<jsp:include page="../include/footer.jsp"/>