var api = "http://localhost:9090/api/test" ;
var testTable;
function init(){
    console.log('inside init' );


    $("#newStockButton").click( function () {
        console.log("Inside click of newStockButton");
        $('#testModal').modal('show');
    });

    $("#editStockButton").click( function () {
        console.log("Inside click of editStockButton");
        // Get the data from selected row and fill fields in modal

            if (testTable.row($('.selected')).data() == undefined) {
                alert("Select stock first");
            }else{
                var stock = testTable.row($('.selected')).data();
                //alert(customer.id);
                $("#id").val(stock.stockId);
                $("#name").val(stock.name);


                $('#testModal').modal('show');
            }

        });

    $("#deleteStockButton").click( function () {
        console.log("Inside click of deleteStockButton");

        if (testTable.row($('.selected')).data() == undefined) {
            alert("Select Test first");
        }else{
            $('#testDeleteModal').modal('show');
        }

    });

    // Button in modal
    $("#deleteStockConfirmButton").click( function () {
        console.log("Inside click of deleteStockConfirmButton");
        deleteStock();
        $('#testDeleteModal').modal('hide');
    });

    // Add submit event to form for new and edit
    $("#stockForm").on('submit', function() {
        console.log("Submitting");
        createStock();
        $('#testModal').modal('hide');
    });

    initStockTable();
    // Get customers from backend and and update stock
    getStockData();
}
function initStockTable() {

    console.log('inside initStockTable' );

    // Create columns (with titles) for datatable: id, name, recentAmount, minAmount
    columns = [
        { "title":  "Test id",//@todo
            "data": "id" },
        { "title":  "Name",
            "data": "name" },

//            "render": function(mergeable) {
//            console.log(mergeable);
//                 if (mergeable == true) {
//                          return "Yes"
//                            } else {
//                                return "No"
//                            }
//                        }},
//        { "title": "Available",
//            "data": "available",
//              "render": function(available) {
//                                        if (available == true) {
//                                            return "Yes"
//                                        } else {
//                                            return "No"
//                                        }
//                                    }}
    ];

    // Define new table with above columns
    testTable = $("#testTable").DataTable( {
        "order": [[ 0, "asc" ]],
        "columns": columns
    });


    $("#testTable tbody").on( 'click', 'tr', function () {
        console.log("Clicking on row");
        if ( $(this).hasClass('selected') ) {
          $(this).removeClass('selected');
          // emptyRoomModals();
        }
        else {
            testTable.$('tr.selected').removeClass('selected');
          // emptyRoomModals();
            $(this).addClass('selected');
        }
    });

}

function getStockData(){

    console.log('inside getStockData' );
    // http:/localhost:9090/api/customer
    // json list of customers
    $.ajax({
        url: api,
        type: "get",
        dataType: "json",
        // success: function(customers, textStatus, jqXHR){
        success: function(stocks){

 //           console.log('Data: ' + customers );

            if (stocks) {
                testTable.clear();
                testTable.rows.add(stocks);
                testTable.columns.adjust().draw();
            }
        },

        fail: function (error) {
            console.log('Error: ' + error);
        }

    });

}
function createStock(){

    console.log('inside createStock' );

    // Put customer data from page in Javascript object --- SIMILAR TO JSON
    var stockData = {
            stockId: $("#id").val(),
            name: $("#name").val()
    }

    // Transform Javascript object to json
    var stockJson = JSON.stringify(stockData);

    console.log(stockJson);

    $.ajax({
        url: api,
        type: "post",
        data: stockJson,    // json for request body
        contentType:"application/json; charset=utf-8",   // What we send to frontend
        dataType: "json",  // get back from frontend
        // success: function(customer, textStatus, jqXHR){
        success: function(stock){

          console.log(stock);

          // Clear fields in page
          $("#id").val('');
          $("#name").val('');


          // Refresh stock data
          getStockData();

        },

        fail: function (error) {
          console.log('Error: ' + error);
        }

    });

}

function deleteStock(){

    if (testTable.row($('.selected')).data() == undefined) {
        alert("Select stock first");
    }else{
        var test = testTable.row($('.selected')).data();

        console.log(api + '/' + test.id);

            $.ajax({
                url: api + '/' + test.id,
                type: "delete",
                contentType: "application/json",
                dataType: "text",  // get back from frontend
                // success: function(customer, textStatus, jqXHR){
                success: function(message){

                  console.log(message);

                  // Refresh table data
                  getStockData();

                },

                fail: function (error) {
                  console.log('Error: ' + error);
                }

            });



    }


}


