$(document).ready(function () {
    $("H1").css("text-align", "center");
    $("H2").css("text-align", "center");
    $(".myBannerHeading").addClass("page-header");
    $(".myBannerHeading").removeClass("myBannerHeading");
    $("#yellowHeading").text("Yellow Team");
    $(".orange").css("background-color", "orange");
    $(".blue").css("background-color", "blue");
    $(".red").css("background-color", "red");
    $(".yellow").css("background-color", "yellow");
    $("#yellowTeamList").append("<li>Joseph Banks</li>");
    $("#yellowTeamList").append("<li>Simon Jones</li>");
    $("#oops").hide();
    $("#footerPlaceholder").remove();
    $(".footer").append("<p id='footerContent'>Stuart Wilson, stu@stu.systems</p>");
    $("#footerContent").css({"font-family": "Courier", "font-size": "24px"});
});