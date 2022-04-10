<title>Richie M's | Sign On</title>

<jsp:include page="./include/header.jsp"/>

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

<script>
    $( "button" ).on( "click", function() {
        validate();
    });
</script>

<jsp:include page="./include/footer.jsp"/>