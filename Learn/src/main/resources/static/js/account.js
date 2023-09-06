console.log("account");
//accountTable =accountTable
var api = "http://localhost:8080/api/account" ;
var accountTable;

function init(){
    console.log('inside init' );

    $("#radio_1").attr('checked', true);

//    $(function () {
//        $("#gfg").datepicker(
//            { firstDay: 1 }
//        );
//    });


    $("#newAccountButton").click( function () {
        console.log("Inside click of newAccountButton");
        $('#accountModal').modal('show');
    });

    $("#editAccountButton").click( function () {
        console.log("Inside click of editAccountButton");
        // Get the data from selected row and fill fields in modal


        if (accountTable.row($('.selected')).data() == undefined) {
            alert("Select account first");
        }else{
            var account = accountTable.row($('.selected')).data();
            alert(account.id);
            $("#id").val(account.id);
            $("#firstName").val(account.firstName);
            $("#lastName").val(account.lastName);
            $("#phoneNumber").val(account.phoneNumber);
            $("#email").val(account.email);
            $("#password").val(account.password);
            $("#role").val(account.role);

            $('#accountModal').modal('show');
        }

    });

    $("#deleteAccountButton").click( function () {
        console.log("Inside click of deleteAccountButton");

        if (accountTable.row($('.selected')).data() == undefined) {
            alert("Select account first");
        }else{
            $('#accountDeleteModal').modal('show');
        }

    });

    // Button in modal
    $("#deleteAccountConfirmButton").click( function () {
        console.log("Inside click of deleteAccountButton");
        deleteAccount();
        $('#accountDeleteModal').modal('hide');
    });

    // Add submit event to form for new and edit
    $("#accountForm").on('submit', function() {
        alert("Submitting");
        createAccount();
        $('#accountModal').modal('hide');
    });

    initAccountTable();
    // Get Account from backend and and update table
    getAccountData();



}

function initAccountTable() {

    console.log('inside initAccountTable' );

    // Create columns (with titles) for datatable: id, name, address, age
    columns = [
        { "title":  "Account ID",
            "data": "id" ,
            "visible": false },
        { "title":  "firstName",
            "data": "firstName" },
        { "title":  "lastName",
            "data": "lastName" },
        { "title": "PhoneNumber",
            "data": "phoneNumber"},
            { "title": "Email",
            "data": "email"},
            { "title": "Password",
            "data": "password"},
             { "title": "Role",
            "data": "role"},
    ];

    // Define new table with above columns
    accountTable = $("#accountTable").DataTable( {
        "order": [[ 0, "asc" ]],
        "columns": columns
    });


    $("#accountTable tbody").on( 'click', 'tr', function () {
        console.log("Clicking on row");
        if ( $(this).hasClass('selected') ) {
          $(this).removeClass('selected');
          // emptyRoomModals();
        }
        else {
            accountTable.$('tr.selected').removeClass('selected');
          // emptyRoomModals();
            $(this).addClass('selected');
        }
    });

}

function getAccountData(){

    console.log('inside getAccountData' );
    // http:/localhost:9090/api/account
    // json list of accounts
    $.ajax({
        url: api,
        type: "get",
        dataType: "json",
        // success: function(accounts, textStatus, jqXHR){
        success: function(accounts){

 //           console.log('Data: ' + accounts );

            if (accounts) {
                accountTable.clear();
                accountTable.rows.add(accounts);
                accountTable.columns.adjust().draw();
            }
        },

        fail: function (error) {
            console.log('Error: ' + error);
        }

    });

}

function createAccount(){

    console.log('inside createAccount' );

    // Put account data from page in Javascript object --- SIMILAR TO JSON
    var accountData = {
            id: $("#id").val(),
            firstName: $("#firstName").val(),
            lastName: $("#lastName").val(),
            phoneNumber: $("#phoneNumber").val(),
            email: $("#email").val(),
            password: $("#password").val(),
            role: $("#role").val()

    }

    // Transform Javascript object to json
    var accountJson = JSON.stringify(accountData);

    console.log(customerJson);

    $.ajax({
        url: api,
        type: "post",
        data: accountJson,    // json for request body
        contentType:"application/json; charset=utf-8",   // What we send to frontend
        dataType: "json",  // get back from frontend
        // success: function(account, textStatus, jqXHR){
        success: function(account){

          console.log(account);

          // Clear fields in page
          $("#id").val('');
          $("#firstName").val('');
          $("#lastName").val('');
          $("#phoneNumber").val('');
          $("#email").val('');
            $("#password").val('');
            $("#role").val('');

          // Refresh table data
          getAccountData();

        },

        fail: function (error) {
          console.log('Error: ' + error);
        }

    });

}

function deleteAccount(){

    if (accountTable.row($('.selected')).data() == undefined) {
        alert("Select account first");
    }else{
        var account = accountTable.row($('.selected')).data();

        console.log(api + '/' + account.id);

            $.ajax({
                url: api + '/' + account.id,
                type: "delete",
                contentType: "application/json",
                dataType: "text",  // get back from frontend
                // success: function(account, textStatus, jqXHR){
                success: function(message){

                  console.log(message);

                  // Refresh table data
                  getAccountData();

                },

                fail: function (error) {
                  console.log('Error: ' + error);
                }

            });



    }


}
