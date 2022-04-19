$( document ).ready(function() {

    let tableDataDinerSubtotal = [];
    let salesTaxPercentage = 0.03;

    function getAjaxDinerMenuGroupedByDinerName() {
        return new Promise( (resolve, reject ) => {
            $.ajax({
                url : '/ajaxDinerMenuGroupedByDinerName',
                type : 'GET',
                data : {
                    key: 'value',
                },
                success : function(data) {

                    console.log("success " + JSON.stringify(data))
                    resolve(data);
                },
                error : function(request,error)
                {
                    console.log("error = " + JSON.stringify(error) + "  " + JSON.stringify(request));
                    reject(error)
                }
            })//ajaxDinerMenuGroupedBySeatNumber
        })//Promise (( resolve, reject) {})
    }//getAjaxDinerMenuGroupedByDinerName()

    $.ajax({
        url : '/ajaxSumByPricePerDiner',
        type : 'GET',
        data : {
            'returnedPricesPerDiner': [ ],
        },
        success : function(data) {
            console.log("success " + JSON.stringify(data))

            Object.keys(data).forEach( subtotal => {
                tableDataDinerSubtotal.push(data[subtotal]);
            });
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

    getAjaxDinerMenuGroupedByDinerName().then((data) => {
            constructTableDataDinerNameArray(data)
        }).catch
        ( (error) => {
            console.log(error)
        })

    function constructTableDataDinerNameArray(data) {
        let tableDataDinerName = [];
        Object.keys(data).forEach( name => {
            tableDataDinerName.push(name);
        });

        console.log("Inside the function", tableDataDinerName);


    console.log("Outside the function", tableDataDinerName);

    for (let i = 0; i <tableDataDinerName.length; i++) {
        console.log("You're in the loop", tableDataDinerName[i], tableDataDinerSubtotal[i])
        $("tbody").append("<tr>");
        $("tbody").append(`<td>${tableDataDinerName[i]}</td>`);
        $("tbody").append(`<td>${tableDataDinerSubtotal[i]}</td>`);
        $("tbody").append(`<td>${tableDataDinerSubtotal[i] * salesTaxPercentage}</td>`);
        $("tbody").append(`<td>${tableDataDinerSubtotal[i] * salesTaxPercentage + tableDataDinerSubtotal[i] }</td>`);
        $("tbody").append("</tr>");
    }//for loop
    }//constructTableDataDinerNameArray(data)

});// (document).ready(function() { })