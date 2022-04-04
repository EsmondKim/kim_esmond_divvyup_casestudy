<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="../../../public/css/styles.css">
    <title>Richie M's | Registration</title>
</head>

<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script>
    $( document ).ready(function() {
        console.log( "ready!" );
    });
</script>

<body id="registration-body">
<ul class="nav nav-tabs"><!--Bootstrap Nav-->
    <li class="nav-item">
        <a class="nav-link active" aria-current="page" href="../index.jsp">Sign In</a>
    </li>
    <li class="nav-item">
        <a class="nav-link nav-text" href="registration.jsp">Registration</a>
    </li>
    <li class="nav-item">
        <a class="nav-link nav-text" href="./menu.html">Menu</a>
    </li>
</ul><!--Bootstrap Nav-->

<div class="container">

    <form class="wrapper">
        <div class="row"><!--registration fields row-->
            <div class="form-floating mb-3">
                <input type="email" class="form-control" id="firstName" placeholder="First Name">
                <label for="firstName">First Name</label>
            </div> <!--form-floating mb-3-->
            <div class="form-floating mb-3">
                <input type="password" class="form-control" id="lastName" placeholder="Last Name">
                <label for="lastName">Last Name</label>
            </div> <!--form-floating mb-3-->
            <div class="form-floating mb-3">
                <input type="password" class="form-control" id="registrationEmail" placeholder="name@example.com">
                <label for="registrationEmail">Email Address</label>
            </div> <!--form-floating mb-3-->
            <div class="form-floating mb-3">
                <input type="password" class="form-control" id="registrationPassword" placeholder="Password">
                <label for="registrationPassword">Password</label>
            </div> <!--form-floating mb-3-->
            <div class="form-floating">
                <input type="password" class="form-control" id="registrationConfirmPass" placeholder="Confirm Password">
                <label for="registrationConfirmPass">Confirm Password</label>
            </div> <!--form-floating-->
            <button type="button" class="btn btn-info"
                    style="margin-top: 20px; margin-left: 8px; width: 84px; height: 45px; font-size:14px;
          font-weight:700">
                Submit</button>
            <!-- <pre><p>Not a Member? Click <a href="./registration.html">here</a> to register for Richie M's Restaurant Menu App.</p></pre> -->
        </div><!--registration fields row-->
    </form>

</div><!--div class="container" (for bootstrap)-->

<script>
    $( "button" ).on( "click", function() {
        console.log("clicked!")
        window.location.href = "./menu.html";
    });
</script>
</body>
</html>