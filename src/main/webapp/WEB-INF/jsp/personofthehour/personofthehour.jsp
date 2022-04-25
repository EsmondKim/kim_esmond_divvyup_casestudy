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
            <th id="remove-header">Remove and Split Among Diners</th>
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


<div class="col-row-12">
    <table class="table">
        <tr scope="row">
            <td><h1>New Totals After Splitting POTH's Tab</h1></td>
        </tr>
        <tr scope="row">
            <th>Diner</th>
            <th>Original Total</th>
            <th>Adding This Amount</th>
            <th>New Diner's Total</th>
        </tr>

        <tbody>
        </tbody>
    </table>
</div>

<script type="text/javascript">
    let totalsArr = [];

    let totals = document.getElementsByClassName("diner-total");
    for (let i=0; i<totals.length; i++) {
        totalsArr.push(totals[i].innerHTML);
    }

    let buttons = document.getElementsByClassName('btn btn-warning');

    for (let i=0; i<buttons.length; i++) {
        buttons[i].addEventListener("click", clickHandler);
    }

    function clickHandler(e) {
        let buttonId = e.target.getAttribute('id');
        let rowId = buttonId.split("_")[1];
        let pothId = `poth-total-id_\${rowId}`;
        let pothTotal = document.querySelector("#" + pothId).textContent;

        let pothEle = document.getElementById(pothId);
        pothEle.innerHTML = "Free";

        for (let i=0; i<buttons.length; i++) {
            buttons[i].style.visibility = "hidden";
        }
        let removeHeader = document.getElementById("remove-header");
        removeHeader.style.visibility = "hidden";

        let index = totalsArr.indexOf(pothTotal);
        console.log("Before the split and add", totalsArr);

        if (index > -1) {
            totalsArr.splice(index, 1);
        }

        let splitAmt = pothTotal/totalsArr.length;

        let newTotalsArr = [];
        totalsArr.map(function(val) {
            console.log("This is the map val.", val)
            console.log("Adding this split amt.", splitAmt);
            let newTotal = +val + +splitAmt;
            console.log("New total", newTotal);
            newTotalsArr.push(newTotal);
        })
        console.log("this is the final newTotalArr", newTotalsArr);

        function loadPOTHTableAfterSplit() {


        }





    }





</script>

<jsp:include page="../include/footer.jsp"/>