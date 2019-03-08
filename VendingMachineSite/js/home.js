$(document).ready(function () {
    displayItems();
});

function displayItems(itemArray) {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/items",
        success: function (itemArray) {
            $('.inventory').empty();
            $.each(itemArray, function (index, item) {
                var preparedHtml =
                    '<button class="col-4 col card" id="itemButton' + item.id + '" ' +
                    'onclick = selectItem(' + item.id + ')>' +
                    '<p class="text-left id">' + item.id + '</p>' +
                    '<p class="text-center name">' + item.name + '</p>' +
                    '<p class="text-center"> $' + item.price.toFixed(2) + '</p>' +
                    '<p class="text-center"> Quantity left: ' + item.quantity + '</p>' +
                    '</button>';

                $('.inventory').append(preparedHtml);
            });
        },
        error: function () {
            $('#messages').text('Inventory failed to load.');
        }
    });
}

function makePurchase() {
    var selectedItem = $('.inventory').find('.selected');

    if (selectedItem.length == 0) {
        $('#messages').text('Select an item first.');
    }
    var id = selectedItem.find('.id').text();
    var amount = $('#money').text().substr(1);

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/money/" + amount + '/item/' + id,
        success: function (change) {
            $('#messages').text('THANK YOU!!!');
            var total = change.quarters * 0.25 +
                change.dimes * 0.10 +
                change.nickels * 0.05;
            var out = '$' + total.toFixed(2);
            $('#money').text(out);
        },
        statusCode: {
            422: function (error) {
                var message = JSON.parse(error.responseText).message;
                $('#messages').text(message);
            }
        }
    });

    displayItems();
}

function selectItem(id) {
    var button = $('#itemButton' + id);
    $('.selected').removeClass('selected');
    button.addClass('selected');
    $('.itemDisplay').text(button.find('.id').text());
    console.log(id);
}

function addChange(n) {
    var total = $('#money').text();
    total = parseFloat(total.substr(1)) + n;

    $('#money').text('$' + total.toFixed(2));
}

function coinReturn() {
    var total = $('#money').text();
    total = parseFloat(total.substr(1));

    var q = 0;
    var d = 0;
    var n = 0;

    q = total / 0.25;
    q = Math.floor(q);
    total = total - q * 0.25;
    d = total / 0.10;
    d = Math.floor(d);
    total = total - d * 0.10;
    if (total > 0) {
        n = 1;
    }

    var out = '';
    if (q == 1) {
        out += '1 Quarter';
    } else if (q > 0) {
        out += q + ' Quarters ';
    }

    if (d == 1) {
        out += ' <br />1 Dime';
    } else if (d > 0) {
        out += d + ' <br />Dimes ';
    }

    if (n == 1) {
        out += ' <br />1 Nickel ';
    }

    if (out == '') {
        out = 'No change'
    }
    $('#change').html(out);
    $('#money').text('$0.00');
}