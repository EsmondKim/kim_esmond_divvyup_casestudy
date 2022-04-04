<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        h2{
            position: absolute;
            left: 550px;
            top: 100px;
        }
    </style>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="../../public/css/styles.css">
    <title>Richie M's | Sign On</title>
</head>

<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script>
    $( document ).ready(function() {
        console.log( "ready!" );
    });

    function validate(e) {
        let signInPassword = document.getElementById("signInPassword");
        let signInPasswordValue = signInPassword.value;

        if ( !/[a-z]/i.test(signInPasswordValue) ) {
            alert("Please include a lowercase letter in password.");
        }

        if ( !/[0-9]/.test(signInPasswordValue) ) {
            alert("Please include a number in password.");
        }

        if ( /[a-z]/i.test(signInPasswordValue) && /[0-9]/.test(signInPasswordValue) ) {
            sendToMenu()
            return;
        }

        location.reload();
    }

    function sendToMenu() { window.location.href = "./menu.html"} ;
</script>

<body id="signin-body">
<ul class="nav nav-tabs"><!--Bootstrap Nav-->
    <li class="nav-item">
        <a class="nav-link active" aria-current="page" href="/index">Sign In</a>
    </li>
    <li class="nav-item">
        <a class="nav-link nav-text" href="/user/registration">Registration</a>
    </li>
    <li class="nav-item">
        <a class="nav-link nav-text" href="./menu.html">Menu</a>
    </li>
</ul><!--Bootstrap Nav-->

<div class="container">

    <form class="wrapper">
        <div class="row"><!--sign on fields row-->
            <div class="form-floating mb-3">
                <input type="email" class="form-control" id="signInEmail" placeholder="name@example.com">
                <label for="signInEmail">Email address</label>
            </div> <!--form-floating mb-3-->
            <div class="form-floating">
                <input type="text" class="form-control" id="signInPassword" placeholder="password">
                <label for="signInPassword">Password</label>
            </div> <!--form-floating-->
            <button type="button" class="btn btn-info"
                    style="margin-top: 20px; margin-left: 8px; width: 84px; height: 45px; font-size:14px;
                font-weight:700">
                Submit</button>
            <a href="/user/registration"><p>Not a Member?  Click here to register for Richie M's Restaurant Menu App.</p></a>
        </div><!--sign on fields row-->
    </form>

</div><!--div class="container" (for bootstrap)-->

<script>
    $( "button" ).on( "click", function() {
        validate();
    });
</script>
</body>
</html>