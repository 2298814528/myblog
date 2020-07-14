var username = sessionStorage.getItem("user");
$(".sign").click(function () {});
function sign() {
    if (username == null || username == "") {
        alert("请先登录！")
    } else {
        $.ajax({
            url: 'signIn',
            method: 'POST',
            dataType: 'JSON',
            contentType: "application/json",
            data: {"user": username},
            success: function (msg) {
                alert(msg);
            },
            error: function (msg) {
                alert(msg);
            }
        })
    }
}