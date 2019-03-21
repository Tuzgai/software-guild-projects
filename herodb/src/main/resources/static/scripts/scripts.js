$(".hero-select-form").submit(function () {
    $(".selectedHero").attr("selected", "selected");
    return true;
});

$(".expandable").not("a").click(function() {
    $(".shortText", this).toggle();
    $(".longText", this).toggleClass("visible");
});

/* Hero roster module */
function removeHero() {
    var item = $("#selectedHeroes").children("option:selected");
    $("#heroRoster").append(item);
    $("#selectedHeroes").remove(item);
}

function addHero() {
    var item = $("#heroRoster").children("option:selected");
    $("#selectedHeroes").append(item);
    $("#heroRoster").remove(item);
}
/* End Hero roster module */