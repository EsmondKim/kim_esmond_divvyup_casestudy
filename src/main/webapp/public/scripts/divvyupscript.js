$( document ).ready(function() {
    $.ajax({
        url : '/ajaxDinerMenuGroupedBySeatNumber',
        type : 'GET',
        data : {
            'returnedDinerMenuObject': [ ],
        },
        success : function(data) {
            console.log("success " + JSON.stringify(data))
            console.log("After /ajaxDinerMenuGroupedBySeatNumber")
            //I think this is the line or area where you'd iterate through
            //the data
            // $( "#rangeValue1" ).text( data );
            let seatTester = document.getElementById("seat-tester");
            seatTester.innerHTML = JSON.stringify(data[1][0]["id"]);
        },
        error : function(request,error)
        {
            console.log("error = " + error + "  " + request)
        }
    });//ajaxDinerMenuGroupedBySeatNumber

    $.ajax({
        url : '/ajaxGetGroupedDinerDetails',
        type : 'GET',
        data : {
            'returnedGroupedDinerMenuDetails': [ ],
        },
        success : function(data) {
            console.log("success " + JSON.stringify(data))
            console.log("After /ajaxGetGroupedDinerDetails")
            let nicknameTester = document.getElementById("nickname-tester");
            nicknameTester.innerHTML = JSON.stringify(data.key[0]);
        },
        error : function(request,error)
        {
            console.log("error = " + error + "  " + request)
        }
    });//ajaxDinerMenuDetails

    $.ajax({
        url : '/ajaxSumByPricePerDiner',
        type : 'GET',
        data : {
            'returnedPricesPerDiner': [ ],
        },
        success : function(data) {
            console.log("success " + JSON.stringify(data))
            console.log("After /ajaxSumByPricePerDiner")
            // $( "#rangeValue1" ).text( data );
        },
        error : function(request,error)
        {
            console.log("error = " + error + "  " + request)
        }
    });///ajaxSumByPricePerDiner

});// (document).ready(function() { })