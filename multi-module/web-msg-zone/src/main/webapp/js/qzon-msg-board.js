var loadPage = function(ele, url) {
    $(ele).load(url);
};

$(function () {
    loadPage("#header", "../jsp/header.jsp");
    loadPage("#footer", "../jsp/footer.jsp");
});

var getMsgs = function () {
    $("#comment_div").load("http://localhost:8080/zone/AddServlet");
};

window.onload=function () {
    getMsgs();
}

var submit = function (data) {
    $.ajax({
        type:'post',
        url:'http://localhost:8080/zone/AddServlet',
        data:data,
        cache:'false',
        dataType:'string',
        async:false,
    });
};

$(function(){
    $('.comment_oper button').click(function()
    {
        var name = 'Jason';
        var phone = '18681700917';
        var email = 'jie-email@jie-trancender.org';
        var title = 'Msg from qzon like msg board';
        var content = $('.comment_editor textarea').val();
        var time = new Date().toString().replace("GMT", "");
        var data = 'name=' + name + '&phone=' + phone + '&email=' + email + '&title=' + title + '&content=' + content + '&time=' + time;
        submit(data);
        getMsgs();
    })
});

