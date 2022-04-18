$( document ).ready(function() {
    $.ajax({
        url : '/ajaxDinerMenuGroupedBySeatNumber',
        type : 'GET',
        data : {
            'returnedDinerMenuObject': [ ],
        },
        success : function(data) {
            console.log("success " + JSON.stringify(data))
            console.log("After /ajaxDinerMenuGroupedBySeatNumber Callback")
            //I think this is the line or area where you'd iterate through
            //the data
            // $( "#rangeValue1" ).text( data );
        },
        error : function(request,error)
        {
            console.log("error = " + error + "  " + request)
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
            console.log("After /ajaxSumByPricePerDiner Callback")
            // $( "#rangeValue1" ).text( data );
        },
        error : function(request,error)
        {
            console.log("error = " + error + "  " + request)
        }
    });///ajaxSumByPricePerDiner

});// (document).ready(function() { })