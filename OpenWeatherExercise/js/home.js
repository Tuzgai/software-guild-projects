var apiKey = '7b1664ed6c4e68628d85bef41d3f63dc';

$(document).ready(function () {

});

function validateZip(zip) {
    // Convert to an int, then back to a string
    if (parseInt(zip).toString().length == 5) {
        return true;
    }
    return false;
}

function getWeather() {
    var zip = $('#zipcode').val();
    var units = $('#units').val();

    if (!validateZip(zip)) {
        alert("Bad! Bad!"); // make this a proper thing later
        return;
    }

    $.ajax({
        type: "GET",
        url: "http://api.openweathermap.org/data/2.5/weather?" +
            "zip=" + zip + ",us" +
            "&APPID=" + apiKey +
            "&units=" + units,
        success: function (ajaxObject) {
            displayCurrentWeather(ajaxObject);
        },
        error: function () {
            alert("FAILURE!");
        }
    });

    $.ajax({
        type: "GET",
        url: "http://api.openweathermap.org/data/2.5/forecast?" +
            "zip=" + zip + ",us" +
            "&APPID=" + apiKey +
            "&units=" + units,
        success: function (ajaxObject) {
            displayFiveDayForecast(ajaxObject);
        },
        error: function () {
            alert("FAILURE!");
        }
    });
}

function displayCurrentWeather(weather) {
    // Clear last run
    $('.WeatherType').empty();
    $('.CurrentWeatherStats').empty();

    $('.forecast').show();
    $('.CurrentConditionsHeader').text('Current Conditions in ' + weather.name);
    var icon = weather.weather[0].icon + '.png';
    $('.WeatherType').append('<img src="http://openweathermap.org/img/w/' + icon + '">');
    $('.WeatherType').append('&emsp;' + weather.weather[0].main + ":&nbsp;" + weather.weather[0].description);

    if ($('#units').val() == 'Imperial') {
        $('.CurrentWeatherStats').append('<p>Temperature:&nbsp;' + weather.main.temp + '&nbsp;F</p>')
    } else {
        $('.CurrentWeatherStats').append('<p>Temperature:&nbsp;' + weather.main.temp + '&nbsp;C</p>')
    }

    $('.CurrentWeatherStats').append('<p>Humidity:&nbsp;' + weather.main.humidity + '%</p>')

    if ($('#units').val() == 'Imperial') {
        $('.CurrentWeatherStats').append('<p>Wind:&nbsp;' + weather.wind.speed + '&nbsp;miles/hour</p>')
    } else {
        $('.CurrentWeatherStats').append('<p>Wind:&nbsp;' + weather.wind.speed + '&nbsp;meters/sec</p>')
    }
}

function displayFiveDayForecast(weatherList) {
    var months = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
    var n = 0;
    for (i = 0; i < weatherList.list.length; i += 8) {
        n++;
        // Start by clearing the cell
        $('#date' + n).empty();
        $('#outlook' + n).empty();
        $('#stats' + n).empty();

        var w = weatherList.list[i];
        var date = new Date(0);
        date.setUTCSeconds(w.dt);
        var icon = w.weather[0].icon + '.png';
        var stats;

        if ($('#units').val() == 'Imperial') {
            stats =
                'H &nbsp;' + w.main.temp_max + 'F &nbsp;' +
                'L &nbsp;' + w.main.temp_min + 'F &nbsp;';
        } else {
            stats =
                'H &nbsp;' + w.main.temp_max + 'C &nbsp;' +
                'L &nbsp;' + w.main.temp_min + 'C &nbsp;';
        }

        $('#date' + n).html((date.getDay()+1) + '&nbsp;' + months[date.getMonth()]);
        $('#outlook' + n).append('<img src="http://openweathermap.org/img/w/' + icon + '">');
        $('#outlook' + n).append('&emsp;' + w.weather[0].main + ":&nbsp;" + w.weather[0].description);
        $('#stats' + n).html(stats);
        console.log(w);
    }
}