<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp"/>
<title>Richie M's | Users</title>


<h1>Employee and User Roster</h1>

<div class="container">

    <div class="col-row-12">
        <table class="table">
            <tr scope="row">
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Employee ID</th>
            </tr>
            <c:forEach items="${users}" var="user" varStatus="loop">
            <tr scope="row">
                <td>${user.getFirstName()}</td>
                <td>${user.getLastName()}</td>
                <td>${user.getEmail()}</td>
                <td id="user-sql-id_${loop.index}">${user.getId()}</td>
                <td><button type="button" class="btn btn-warning" id="delete-btn_${loop.index}">Delete</button></td>
            </tr>
            </c:forEach>
        </table>
        <script type="text/javascript">
            let buttons = document.getElementsByClassName('btn btn-warning');

            for (let i=0; i<buttons.length; i++) {
                buttons[i].addEventListener("click", clickHandler);
            }

                function clickHandler(e) {
                let buttonId = e.target.getAttribute('id');
                let rowId = buttonId.split("_")[1];
                let sqlId = document.querySelector(`#user-sql-id_\${rowId}`).textContent;

                $.ajax({
                    url: "/user/deleteuser",
                    data: {id: sqlId },
                    success: setTimeout(function(){
                        window.location.reload();
                    }, 2000)
                })
            }
        </script>
    </div>

<jsp:include page="../include/footer.jsp"/>
