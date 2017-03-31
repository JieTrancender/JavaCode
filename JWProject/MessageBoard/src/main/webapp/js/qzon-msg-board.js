$(function(){

    $('.comment_oper button').click(function()
    {
        var name = 'Jason';
        var phone = '18681700917';
        var email = 'jie-email@jie-trancender.org';
        var title = 'Msg from qzon like msg board';
        var content = $('.comment_editor textarea').val();
        var data = 'name=' + name + '&phone=' + phone + '&email=' + email + '&title=' + title + '&content=' + content;
        submit(data);
        getData();
    })
});

var submit = function (data) {
    // htmlobj=$.ajax({
    //     url:'http://localhost:8080/AddServlet',async:false
    // });
    // $("#all_wrap").html(htmlobj.responseText);
    // document.body.innerHTML=htmlobj.responseText;

    $.ajax({
        type:'post',
        url:'http://localhost:8080/AddServlet',
        data:data,
        cache:'false',
        dataType:'string',
        async:false,
        success:function(){
            alert("Success!")
        }
    });
};

// $(function () {
//     $.ajax({
//         type: 'get',
//         url: 'http://localhost:8080/AddServlet',
//         cache: 'false',
//         async:false,
//         success: function () {
//             alert("Success!")
//         }
//     });
// });

var getData = function() {
    $.ajax({
        type:'get',
        url:'http://localhost:8080/AddServlet',
        cache:'false',
        success:function () {
            alert("Success!");
        }
    });
};

$(function () {
    loadPage("#header", "../jsp/header.jsp");
    loadPage("#footer", "../jsp/footer.jsp");
});

var loadPage = function(ele, url) {
    $(ele).load(url);
};


