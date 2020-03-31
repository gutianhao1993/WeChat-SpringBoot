$(function () {
    $(window).resize();

    //获取url中的openID
    var openID = window.location.search.substring(8);
    $("#openID").val(openID);
});

$(window).resize(function () {
    $("#t").css({
        position: "absolute",
        left: ($(window).width() - $("#t").outerWidth()) / 2,
        top: ($(window).height() - $("#t").outerHeight()) / 2
    });
});