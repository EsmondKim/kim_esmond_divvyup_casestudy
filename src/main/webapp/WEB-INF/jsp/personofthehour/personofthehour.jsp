<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Richie M's | Person of the Hour</title>
<jsp:include page="../include/header.jsp"/>

<h1>The Person Of The Hour</h1>

<div class="col-row-12">
    <table class="table">
        <tr scope="row">
            <th>Diner</th>
            <th>Diner's Subtotal</th>
            <th>Diner's Salestax</th>
            <th>Diner's Total</th>
            <th>Remove and Split Among Diners</th>
        </tr>


        <c:forEach items="${divvyUpTaxAndTotalRows}" var="divvyUpTaxAndTotalRow" varStatus="loop">
            <tr scope="row">
                <td>${divvyUpTaxAndTotalRow.diner_nickname}</td>
                <td>${divvyUpTaxAndTotalRow.subtotal}</td>
                <td>${divvyUpTaxAndTotalRow.salestax}</td>
                <td  class="diner-total" id="poth-total-id_${loop.index}">${divvyUpTaxAndTotalRow.total}</td>
                <td><button type="button" class="btn btn-warning" id="split-btn_${loop.index}">Split</button></td>
            </tr>
        </c:forEach>
    </table>
</div>

<script type="text/javascript">
    let totalsArr = [];

    let totals = document.getElementsByClassName("diner-total");
    for (let i=0; i<totals.length; i++) {
        totalsArr.push(totals[i].innerHTML);
    }

    console.log(totalsArr);

    let buttons = document.getElementsByClassName('btn btn-warning');

    for (let i=0; i<buttons.length; i++) {
        buttons[i].addEventListener("click", clickHandler);
    }

    function clickHandler(e) {
        let buttonId = e.target.getAttribute('id');
        let rowId = buttonId.split("_")[1];
        let pothId = `poth-total-id_\${rowId}`;
        let pothTotal = document.querySelector("#" + pothId).textContent;
        // console.log("Click", buttonId);
        // console.log(rowId);
        // console.log(pothId);
        // console.log(pothTotal);

        let pothEle = document.getElementById(pothId);
        // console.log(pothEle);
        pothEle.style.visibility = "hidden";
    }





</script>

<jsp:include page="../include/footer.jsp"/>