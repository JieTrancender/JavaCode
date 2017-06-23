/**
 * Created by JTrancender on 2017/6/22.
 */
function getData() {
    var currentUserId = "";
    var ca = document.cookie.split(";");
    for (var i = 0; i < ca.length; ++i) {
        if (ca[i].split('=')[0] == 'userId') {
            hostId = ca[i].split('=')[1];
            break;
        }
    }

    $.ajax({
        type: "get",
        async: "true",
        url: "http://localhost:8080/json/user-json?",
        dataType: "jsonp",
        jsonp: "jsoncallback",
        jsonCallback: "....",
        success: function (data) {
            $("#userId").html(data.userId);
            $("#name").html(data.name);
            $("#avatar").html(data.avatar);
            $("#identityType").html(data.identityType);
            $("#identifier").html(data.identifier);
            $("#gender").html(data.gender);
        }
    });
}

function getFriends() {
    $.ajax({
        type: "get",
        async: "true",
        url: "http://localhost:8080/json/users-json",
        dataType: "jsonp",
        jsonp: "jsoncallback",
        jsonCallback: "....",
        success: function (data) {
            $("#userId").html(data.userId);
            $("#name").html(data.name);
            $("#avatar").html(data.avatar);
            $("#identityType").html(data.identityType);
            $("#identifier").html(data.identifier);
            $("#gender").html(data.gender);
            $.each(eval(data), function (index, item) {
                $("#friends-list").append("<li><a href=\"/zone/jsp/qzon-msg-board.jsp?userId=" + item.userId + "\">" + item.name + "(" + item.identifier + ")</a></li>");
            });
        }
    });
}

$(function () {
    getData();
    getFriends();
});
