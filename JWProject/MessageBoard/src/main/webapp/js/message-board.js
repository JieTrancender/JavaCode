$(function () {
    loadPage("#header", "./jsp/header.jsp");
});

var loadPage = function(ele, url) {
    $(ele).load(url);
};