<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>

<link rel="stylesheet" href="../../../public/css/styles_navbar_and_tables.css">
<title>Richie M's | Person of the Hour</title>

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
                <td class="diner-names">${divvyUpTaxAndTotalRow.diner_nickname}</td>
                <td>${divvyUpTaxAndTotalRow.subtotal}</td>
                <td>${divvyUpTaxAndTotalRow.salestax}</td>
                <td  class="diner-total" id="poth-total-id_${loop.index}">${divvyUpTaxAndTotalRow.total}</td>
                <td><button type="button" class="btn btn-success" id="split-btn_${loop.index}">Split</button></td>
            </tr>
        </c:forEach>
    </table>
</div>


<div class="col-row-12">
    <table class="table">
        <tr scope="row">
            <td><h1>New Totals After Splitting POTH's Tab</h1></td>
            <td><p>*The Amounts Added Below Include The POTH-Diner's Salestax but no gratuity.</p></td>
        </tr>
        <tr scope="row">
            <th>Diner</th>
            <th>Original Total</th>
            <th>Adding This Amount</th>
            <th>New Diner's Total</th>
        </tr>

        <tbody id="split-tbody">
        </tbody>
    </table>
</div>

<script type="text/javascript">
    let totalsArr = [];

    let totals = document.getElementsByClassName("diner-total");
    for (let i=0; i<totals.length; i++) {
        totalsArr.push(totals[i].innerHTML);
    }

    let buttons = document.getElementsByClassName('btn btn-success');

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

        let indexToRemove = totalsArr.indexOf(pothTotal);
        console.log("Before the split and add", totalsArr);

        if (indexToRemove > -1) {
            totalsArr.splice(indexToRemove, 1);
        }
        console.log("This is the totalsArr with the poth total spliced out", totalsArr)

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

        dinerNamesArr = [];
        let dinerNames = document.getElementsByClassName("diner-names");
        for (let i=0; i<dinerNames.length; i++) {
            dinerNamesArr.push(dinerNames[i].textContent);
        }

        if (indexToRemove > -1) {
            dinerNamesArr.splice(indexToRemove, 1);
        }
        console.log("dinerNamesArr post slice", dinerNamesArr);

        console.log("dinerNames len", dinerNamesArr.length);
        console.log("this is totals array immediately before forLoop", totalsArr);
        console.log("totalsArr len",totalsArr.length);

        let formatter = new Intl.NumberFormat('en-US', {
            style: 'currency',
            currency: 'USD',
        });

        function loadPOTHTableAfterSplit() {
            for (let i=0; i<dinerNames.length-1; i++) {
                let dinerName = dinerNamesArr[i];
                let originalTotal = totalsArr[i];
                let addAmt = splitAmt;
                let newTotal = formatter.format(+originalTotal + +splitAmt);

                $("#split-tbody").append("<tr>");
                $("#split-tbody").append(`<td>\${dinerName}</td>`);
                $("#split-tbody").append(`<td>\${originalTotal}</td>`);
                $("#split-tbody").append(`<td>\${addAmt}</td>`);
                $("#split-tbody").append(`<td>\${newTotal}</td>`);
                $("#split-tbody").append("</tr>");
            }
        }

        loadPOTHTableAfterSplit();

    }
</script>

<jsp:include page="../include/footer.jsp"/>