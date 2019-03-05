$(document).ready(function () {
    $("#akronInfoDiv").hide();
    $("#minneapolisInfoDiv").hide();
    $("#louisvilleInfoDiv").hide();
    $("#akronWeather").hide();
    $("#minneapolisWeather").hide();
    $("#louisvilleWeather").hide();
});

$("#mainButton").on("click", function() {
    $("#mainInfoDiv").show();
    $("#akronInfoDiv").hide();
    $("#minneapolisInfoDiv").hide();
    $("#louisvilleInfoDiv").hide();
    $("#akronWeather").hide();
    $("#minneapolisWeather").hide();
    $("#louisvilleWeather").hide();
});

$("#akronButton").on("click", function() {
    $("#mainInfoDiv").hide();
    $("#akronInfoDiv").show();
    $("#minneapolisInfoDiv").hide();
    $("#louisvilleInfoDiv").hide();
    $("#akronWeather").hide();
    $("#minneapolisWeather").hide();
    $("#louisvilleWeather").hide();
});

$("#minneapolisButton").on("click", function() {
    $("#mainInfoDiv").hide();
    $("#akronInfoDiv").hide();
    $("#minneapolisInfoDiv").show();
    $("#louisvilleInfoDiv").hide();
    $("#akronWeather").hide();
    $("#minneapolisWeather").hide();
    $("#louisvilleWeather").hide();
});

$("#louisvilleButton").on("click", function() {
    $("#mainInfoDiv").hide();
    $("#akronInfoDiv").hide();
    $("#minneapolisInfoDiv").hide();
    $("#louisvilleInfoDiv").show();
    $("#akronWeather").hide();
    $("#minneapolisWeather").hide();
    $("#louisvilleWeather").hide();
});

$("#akronWeatherButton").on("click", function() {
   $("#akronWeather").toggle(); 
});

$("#minneapolisWeatherButton").on("click", function() {
   $("#minneapolisWeather").toggle(); 
});

$("#louisvilleWeatherButton").on("click", function() {
   $("#louisvilleWeather").toggle(); 
});

$("tr + tr").hover(
    function() {
        $(this).css("background-color", "WhiteSmoke");
    },

    function() {
        $(this).css("background-color", "white");
    }
);