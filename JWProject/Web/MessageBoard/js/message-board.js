$(function() {
	// $("#header").load("./html/header.html");
	// $("#main").load("./html/main.html");
	// $("#footer").load("./html/footer.html");
	loadPage("#header", "./html/header.html");
	loadPage("#main", "./html/main.html");
	loadPage("#footer", "./html/footer.html");
});

var loadPage = function(ele, url) {
	$(ele).load(url);
};