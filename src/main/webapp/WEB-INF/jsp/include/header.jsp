<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://code.jquery.com/jquery-3.6.0.js"
            integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="../../../public/css/styles.css">
</head>

<ul class="nav nav-tabs"><!--Bootstrap Nav-->
    <li class="nav-item">
        <a class="nav-link active" aria-current="page" href="/index">Richie M's Restaurant</a>
    </li>
    <li class="nav-item">
        <a class="nav-link nav-text" href="/user/registration">Registration</a>
    </li>
    <li class="nav-item">
        <a class="nav-link nav-text" href="/diner/diner">Add Diners</a>
    </li>
    <li class="nav-item">
        <a class="nav-link nav-text" href="/menu/menu">Menu</a>
    </li>
    <li class="nav-item">
        <a class="nav-link nav-text" href="/tab/tab">The Tab</a>
    </li>
    <li class="nav-item">
        <a class="nav-link nav-text" href="/divvyup/divvyup">The DivvyUp</a>
    </li>
    <li class="nav-item">
        <a class="nav-link nav-text" href="/personofthehour/personofthehour">Person of the Hour</a>
    </li>

    <sec:authorize access = "hasAuthority('ADMIN')">
    <li class="nav-item">
        <a class="nav-link nav-text" href="/additem/additem">Add Item To Menu</a>
    </li>
    </sec:authorize>

    <sec:authorize access="!isAuthenticated()">
    <li class="nav-item">
        <a class="nav-link nav-text" href="/login/login">Login</a>
    </li>
    </sec:authorize>

    <sec:authorize access="isAuthenticated()">
    <li class="nav-item">
        <a class="nav-link nav-text" href="/login/logout">Logout</a>
    </li>
    <sec:authentication property="principal.username" />
    </sec:authorize>
</ul><!--Bootstrap Nav-->