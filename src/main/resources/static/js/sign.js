$("#SignBtn").click
var username = sessionStorage.getItem("user");
function signIn() {
    alert(123)
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
