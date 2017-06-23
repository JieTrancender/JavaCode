var currentUserId = "";

var loadPage = function (ele, url) {
    $(ele).load(url);
};

$(function () {
    loadPage("#header", "../jsp/header.jsp");
    loadPage("#footer", "../jsp/footer.jsp");
});

function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]);
    return null;
}

function getMsgData(userId) {
    $.ajax({
        type: "get",
        async: "true",
        url: "http://localhost:8080/zone/msgs-json?userId=" + userId,
        dataType: "jsonp",
        jsonp: "jsoncallback",
        jsonCallback: "....",
        success: function (data) {
            // arr = eval('new Array(' + data + ')');
            // $("#comment_list").append(arr.length.toString());
            $.each(eval(data), function (index, item) {
                // alert(data.size());
                var str1 = "<li><div class='wrap'><div class='wrap_left'> ";
                var str2 = "<a href='#' class='peopel_photo'><img src='/zone/images/people_photo.png' width='50' height='50'/></a></div>";
                var str3 = "<div class='wrap_center'>";
                var str4 = "<span class='user_info'>" + item.name + "(" + item.friendId + ")</span>";
                var str5 = "<span class='txt_floor'>第 " + (data.length - parseInt(index)).toString() + " 楼</span>";
                var str6 = "<div class='comment_content'>" + item.content + "</div>";
                var str7 = "<span class='data_time'>" + item.time + "</span>";
                var str8 = "</div>";

                $("#comment_list").append(str1 + str2 + str3 + str4 + str5 + str6 + str7 + str8);

                // var line = "<li>第" + " index 楼 " + item.content + " " + item.friendId + " " + item.time + "</li>";
                // $("#comment_list").append(line);
                // $("#comment_list").append("<li id='commit_li'></li>");
                // $("#comment_li").append("第" + index + 1 + "楼 " + item.friendId + " " + item.time);
                // $("#comment_li").append("<li>" + item.content + "</li>");
                // var line1 = "<li><div class='wrap'><a href='#' class='peopel_photo'><img src='/images/people_photo.png' width='50' height='50'></a></div>";
                // var line2 = "<div class='wrap_center'><span class='user_info'>" + item.friendId + "</span>";
                // var line3 = "<span class='txt_floor'>第0楼</span>";
                // var line4 = "<div class='comment_content'>" + item.content + "</div>";
                // var line5 = "<span class='data_time'>" + item.time + "</span></div></div></li>";
                // var line6 = "<p>第" + index + "楼 " + item.friendId + " " + item.time + "</p>";
                // var line7 = "<p>" + item.content + "</p>";
                // $("comment_list").append(line1);
                // $("comment_list").append(line2);
                // $("comment_list").append(line3);
                // $("comment_list").append(line4);
                // $("comment_list").append(line5);
                // $("comment_list").append(line6);
                // $("comment_list").append(line7);

                $("#msgSize").html("(" + (index + 1).toString() + ")");
            });
        }
    });
}

var getMsgs = function () {
    var  userId = getQueryString("userId");
    var str = "";
    if (userId != null) {
        str = userId.toString();
        currentUserId = str;
        document.cookie = "userId=" + str;
    }
    // alert(str);
    var ca = document.cookie.split(";");
    for (var i = 0; i < ca.length; ++i) {
        if (ca[i].split('=')[0] == 'userId') {
            str = ca[i].split('=')[1];
            break;
        }
    }
    getMsgData(str);
    // $("#comment_div").load("http://localhost:8080/zone/AddServlet?userId=" + str);
};

window.onload = function () {
    getMsgs();
};

var submit = function (data) {
    $.ajax({
        type: 'post',
        url: 'http://localhost:8080/zone/AddServlet',
        data: data,
        cache: 'false',
        dataType: 'string',
        async: false
    });
};

$(function () {
    $('.comment_oper button').click(function () {
        var hostId = "";
        var ca = document.cookie.split(";");
        for (var i = 0; i < ca.length; ++i) {
            if (ca[i].split('=')[0] == 'userId') {
                hostId = ca[i].split('=')[1];
                break;
            }
        }
        var time = new Date().toString().replace("GMT", "");
        var content = $('.comment_editor textarea').val();
        var data = 'hostId=' + hostId + '&content=' + content + '&time=' + time;
        submit(data);
        getMsgs();
    });
});

