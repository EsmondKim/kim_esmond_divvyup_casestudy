$( document ).ready(function() {
    $.ajax({
        url : '/ajaxDinerMenuGroupedByDinerName',
        type : 'GET',
        data : {
            returnedDinerMenuGroupedByDinerName: { },
        },
        success : function(data) {
            console.log("success " + JSON.stringify(data))
            console.log("After /ajaxDinerMenuGroupedByDinerName")
            //This is the line where you iterate through the data
            let nameTester0 = document.getElementById("name-tester0");
            nameTester0.innerHTML = JSON.stringify(Object.keys(data)[0]);
            let nameTester1 = document.getElementById("name-tester1");
            nameTester1.innerHTML = JSON.stringify(Object.keys(data)[1]);
        },
        error : function(request,error)
        {
            console.log("error = " + JSON.stringify(error) + "  " + JSON.stringify(request));
        }
    });//ajaxDinerMenuGroupedBySeatNumber

    $.ajax({
        url : '/ajaxSumByPricePerDiner',
        type : 'GET',
        data : {
            'returnedPricesPerDiner': [ ],
        },
        success : function(data) {
            console.log("success " + JSON.stringify(data))
            console.log("After /ajaxSumByPricePerDiner")
            let priceTester0 = document.getElementById("price-tester0");
            priceTester0.innerHTML = JSON.stringify(Object.values(data)[0]);
            let priceTester1 = document.getElementById("price-tester1");
            priceTester1.innerHTML = JSON.stringify(Object.values(data)[1]);
        },
        error : function(request,error)
        {
            console.log("error = " + JSON.stringify(error) + "  " + JSON.stringify(request))
        }
    });///ajaxSumByPricePerDiner

    $.ajax({
        url : '/ajaxGetDinerMenuDetails',
        type : 'GET',
        data : {
            'returnedDinerMenuDetails': [ ],
        },
        success : function(data) {
            console.log("success " + JSON.stringify(data))
            console.log("After /ajaxGetDinerMenuDetails")
            // render logic here
        },
        error : function(request,error)
        {
            console.log("error = " + JSON.stringify(error) + "  " + JSON.stringify(request))
        }
    });///ajaxGetDinerMenuDetails


});// (document).ready(function() { })