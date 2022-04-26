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
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Fjalla+One&display=swap" rel="stylesheet">
</head>

<ul class="nav nav-tabs"><!--Bootstrap Nav-->
    <li class="nav-item">
        <a class="nav-link active" aria-current="page" href="/index">Richie M's Restaurant</a>
    </li>
    <li class="nav-item">
        <a class="nav-link nav-text" href="/user/registration" style="color:red" onMouseOver="this.style.color='green'"  onMouseOut="this.style.color='red'">Registration</a>
    </li>
    <sec:authorize access = "hasAuthority('ADMIN')">
    <li class="nav-item">
        <a class="nav-link nav-text" href="/user/users" style="color:red" onMouseOver="this.style.color='green'"  onMouseOut="this.style.color='red'">Users</a>
    </li>
    </sec:authorize>
    <li class="nav-item">
        <a class="nav-link nav-text" href="/diner/diner" style="color:red" onMouseOver="this.style.color='green'"  onMouseOut="this.style.color='red'">Add Diners</a>
    </li>
    <li class="nav-item">
        <a class="nav-link nav-text" href="/menu/menu" style="color:red" onMouseOver="this.style.color='green'"  onMouseOut="this.style.color='red'">Menu</a>
    </li>
    <li class="nav-item">
        <a class="nav-link nav-text" href="/tab/tab" style="color:red" onMouseOver="this.style.color='green'"  onMouseOut="this.style.color='red'">The Tab</a>
    </li>
    <li class="nav-item">
        <a class="nav-link nav-text" href="/divvyup/divvyup" style="color:red" onMouseOver="this.style.color='green'"  onMouseOut="this.style.color='red'">The DivvyUp</a>
    </li>
    <li class="nav-item">
        <a class="nav-link nav-text" href="/personofthehour/personofthehour" style="color:red" onMouseOver="this.style.color='green'"  onMouseOut="this.style.color='red'">Person of the Hour</a>
    </li>
    <li class="nav-item">
        <a class="nav-link nav-text" href="/menusearch/menusearch" style="color:red" onMouseOver="this.style.color='green'"  onMouseOut="this.style.color='red'">Menu Search</a>
    </li>

    <sec:authorize access = "hasAuthority('ADMIN')">
    <li class="nav-item">
        <a class="nav-link nav-text" href="/additem/additem" style="color:red" onMouseOver="this.style.color='green'"  onMouseOut="this.style.color='red'">Add Item To Menu</a>
    </li>
    </sec:authorize>

    <sec:authorize access="!isAuthenticated()">
    <li class="nav-item">
        <a class="nav-link nav-text" href="/login/login" style="color:red" onMouseOver="this.style.color='green'"  onMouseOut="this.style.color='red'">Login</a>
    </li>
    </sec:authorize>

    <sec:authorize access="isAuthenticated()">
    <li class="nav-item">
        <a class="nav-link nav-text" href="/login/logout" style="color:red" onMouseOver="this.style.color='green'"  onMouseOut="this.style.color='red'">Logout</a>
    </li>
    <sec:authentication property="principal.username" />
    </sec:authorize>
</ul><!--Bootstrap Nav-->