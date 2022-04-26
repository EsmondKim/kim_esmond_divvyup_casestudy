<jsp:include page="../include/header.jsp"/>

<link rel="stylesheet" href="../../../public/css/styles_login.css">
<title>Richie M's | Login</title>

<body id="signin-body">

<div class="container">
    <h1>Login</h1>

    <form class="wrapper" action="/login/loginSubmit" method="POST">
        <div class="col-row-12">
            <div class="form-floating mb-3">
                <input type="hidden" name="id" value="${form.id}">
                <input type="email" class="form-control" id="signInEmail" name="username" placeholder="name@example.com">
                <label for="signInEmail">Email address</label>
            </div> <!--form-floating mb-3-->
            <br>
            <div class="form-floating">
                <input type="password" class="form-control" id="signInPassword" name="password" placeholder="password" value="${form.password}">
                <label for="signInPassword">Password</label>
            <br>
            </div> <!--form-floating mb-3-->
            <button class="btn btn-success" type="submit">Submit</button>
        </div> <!--col-row-12-->
    </form>


<jsp:include page="../include/footer.jsp"/>