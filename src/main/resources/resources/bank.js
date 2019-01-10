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
        dataType: "json",
        success: function () {
            console.log("Bravo")
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
        "transactionType": "WITHDRAW"
    };

    $.ajax({
        url: "/account",
        type: "POST",
        data: JSON.stringify(transaction),
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function () {
            console.log("Bravo")
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
          //  console.log(data.currency.currency);
          //  console.log(data.balance);
            $('#balanceArea p').text("Saldot är för tillfället: "+data.balance+" "+data.currency.currency);
        }
    })
}