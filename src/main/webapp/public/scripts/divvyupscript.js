$( document ).ready(function() {

   function getAjaxDinerMenuGroupedByDinerName() {
        return new Promise( (resolve, reject ) => {
            $.ajax({
                url : '/ajaxDinerMenuGroupedByDinerName',
                type : 'GET',
                data :  {
                    key: 'value',
                },
                success : function(data) {
                    console.log("success " + JSON.stringify(data))
                    resolve(data);
                    return data;
                },
                error : function(request,error)
                {
                    console.log("error = " + JSON.stringify(error) + "  " + JSON.stringify(request));
                    reject(error)
                }
            })//ajaxDinerMenuGroupedBySeatNumber
        })//Promise (( resolve, reject) {})
    }//getAjaxDinerMenuGroupedByDinerName()

    function getAjaxSumByPricePerDiner() {
        return new Promise( (resolve, reject ) => {
                $.ajax({
                    url : '/ajaxSumByPricePerDiner',
                    type : 'GET',
                    data : {
                        'returnedPricesPerDiner': [ ],
                    },
                success : function(data) {
                    console.log("success " + JSON.stringify(data))
                    resolve(data);
                    return data;
                },
                error : function(request,error)
                {
                    console.log("error = " + JSON.stringify(error) + "  " + JSON.stringify(request))
                    reject(error)
                }
            })//ajaxDinerMenuGroupedBySeatNumber
        })//Promise (( resolve, reject) {})
    }//getAjaxDinerMenuGroupedByDinerName()

    $.ajax({
        url : '/ajaxGetDinerMenuDetails',
        type : 'GET',
        data : {
            'returnedDinerMenuDetails': [ ],
        },
        success : function(data) {
            console.log("success " + JSON.stringify(data))
            // render logic here
        },
        error : function(request,error)
        {
            console.log("error = " + JSON.stringify(error) + "  " + JSON.stringify(request))
        }
    });

    function constructForLoops() {

        getAjaxDinerMenuGroupedByDinerName().then((data) => {
            constructTableDataDinerNameArray(data)
        }).catch
        ( (error) => {
            console.log(error)
        });

         function constructTableDataDinerNameArray(data) {
            let tableDataDinerNames = [];
            Object.keys(data).map(name => {
                tableDataDinerNames.push(name);
            })
             for (let i = 0; i <tableDataDinerNames.length; i++) {
                     $("#tbody-names").append("<tr>");
                     $("#tbody-names").append(`<td>${tableDataDinerNames[i]}</td>`);
                     $("#tbody-names").append("</tr>");
                 }//for loop
         }

        getAjaxSumByPricePerDiner().then((data) => {
            constructTableDataDinerSubtotals(data)
        }).catch
        ( (error) => {
            console.log(error)
        });

        function constructTableDataDinerSubtotals(data) {
            let tableDataDinerSubtotals = [];
            Object.keys(data).map(subtotal => {
                tableDataDinerSubtotals.push(data[subtotal]);
            })

            let salesTaxPercentage = 0.03;
            for (let i = 0; i <tableDataDinerSubtotals.length; i++) {
                $("#tbody-prices").append("<tr>");
                $("#tbody-prices").append(`<td>${tableDataDinerSubtotals[i]}</td>`);
                $("#tbody-prices").append(`<td>${tableDataDinerSubtotals[i] * salesTaxPercentage}</td>`);
                $("#tbody-prices").append(`<td>${tableDataDinerSubtotals[i] * salesTaxPercentage + tableDataDinerSubtotals[i] }</td>`);
                $("#tbody-prices").append("</tr>");
            }//for loop
        }

    };//ConstructForLoops();

    constructForLoops();

});// (document).ready(function() { })