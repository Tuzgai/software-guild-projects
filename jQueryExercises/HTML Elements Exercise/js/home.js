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

$('.button1').on('click', function() {
    $('.red').toggle();
});

$('.button2').on('click', function() {
    $('.jumbotron').toggle();
})

$('.party-zone').hover(
    function() {
        $('body').hide();
    },
    
    function() {
        $('body').show();
    }
)


$('.row').hover(
    function() {
        var tmp = $(".orange").css("background-color");
        
        $(".orange").css("background-color", $(".blue").css("background-color"));
        $(".blue").css("background-color", $(".red").css("background-color"));
        $(".red").css("background-color", $(".yellow").css("background-color"));
        $(".yellow").css("background-color", tmp);
    },
    
    function() {
        
    }
)

$('.jumbotron').hover(
    function(){
        $('.heather').css('background-color', 'darkblue');  
        $('.heather').css('color', 'white');
    },
    function(){
    
    }
);