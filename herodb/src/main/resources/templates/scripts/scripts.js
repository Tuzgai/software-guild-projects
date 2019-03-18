$(".expandable").click(function() {
    $(".shortText", this).toggle();
    $(".longText", this).toggle();
});