$(".expandable").click(function() {
    $(".shortText", this).toggle();
    $(".longText", this).toggleClass("visible");
});

/* Hero roster module */
function removeHero() {
    var item = $("#currentHeroes").children("option:selected");
    $("#heroRoster").append(item);
    $("#currentHeroes").remove(item);
}

function addHero() {
    var item = $("#heroRoster").children("option:selected");
    $("#currentHeroes").append(item);
    $("#heroRoster").remove(item);
}
/* End Hero roster module */