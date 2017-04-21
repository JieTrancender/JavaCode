/**
 * Created by JTrancender on 2017/4/12.
 */
function _change(imgId) {
    var img = document.getElementById(imgId);
    img.src = "/VerifyServlet?a=" + new Date().getTime();
}
