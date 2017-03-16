var loadPage = function(ele, url) {
	$(ele).load(url);
};

$(function() {
	// $("#header").load("./header.html");
	loadPage("#header", "./header.html");
});
