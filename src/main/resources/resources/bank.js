function deposit() {
    var name = $('#name');
    var amount = $('#amount');
    var currency = $('#currency');

    var transaction = {
        "customer": {
            "name": name.val()
        },
        "balance": {
            "balance": amount.val(),
            "currency": {
                "currency": currency.val()
            }
        },
        "transactionType": "DEPOSIT"
    };

    $.ajax({
        url: "/account",
        type: "POST",
        data: JSON.stringify(transaction),
        contentType: "application/json; charset=utf-8",
        success: function () {
            //$('#balanceArea p').text("deposit ok")
        }
    })
}

function withdraw() {
    var name = $('#name');
    var amount = $('#amount');
    var currency = $('#currency');

    var transaction = {
        "customer": {
            "name": name.val()
        },
        "balance": {
            "balance": amount.val(),
            "currency": {
                "currency": currency.val()
            }
        },
        "transactionType": "WITHDRAWAL"
    };

    $.ajax({
        url: "/account",
        type: "POST",
        data: JSON.stringify(transaction),
        contentType: "application/json; charset=utf-8",
        success: function () {
            //$('#balanceArea p').text("Withdraw ok")
        },
        error: function (data){
            //alert(JSON.stringify(data, null, 4))
            $('#balanceArea p').text("Error: "+data.status+", Reason: "+data.responseText)
        }
    })
}

function getBalance() {
    var name = $('#name');
    var amount = $('#amount');
    var currency = $('#currency');

    $.ajax({
        url: "/account/"+name.val(),
        type: "GET",
        contentType: "application/json; charset=utf-8",
        success: function (data) {
            $('#balanceArea p').text(name.val()+"s saldo är: "+data.balance+" "+data.currency.currency);
        }
    })
}