$(document).ready(function() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/items",
        success: function (itemArray) {
            displayItems(itemArray);
        },
        error: function () {
            alert("FAILURE!");
        }
    });
});

function displayItems(itemArray) {
    $.each(itemArray, function(index, item) {
        var preparedHtml = 
            '<button class="col-4 col card" id="itemButton' + item.id + '" ' +  
            'onclick = selectItem(' + item.id + ')>' +
            '<p class="text-left">' + item.id + '</p>' +
            '<p class="text-center name">' + item.name + '</p>' +
            '<p class="text-center"> $' + item.price.toFixed(2) + '</p>' +
            '<p class="text-center"> Quantity left: ' + item.quantity + '</p>' +
            '</button>';

        $('.inventory').append(preparedHtml);
    });
}

function selectItem(id) {
    var button = $('#itemButton' + id);
    $('.selected').removeClass('selected');
    button.addClass('selected');
    $('.itemDisplay').text(button.find('.name').text());
}