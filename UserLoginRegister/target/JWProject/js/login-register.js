/**
 * Created by JTrancender on 2017/3/10.
 */
function _change(imgId) {
    var img = document.getElementById(imgId);
    img.src = "/VerifyServlet?a=" + new Date().getTime();
}
