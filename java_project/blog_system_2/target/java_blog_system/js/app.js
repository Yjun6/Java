function checkLogin() {
    $.ajax({
        type: 'get',
        url: 'login',
        success: function(body) {
            //登录成功，不需要做什么
        },
        error: function(body) {
            //登录失败，返回403触发这个逻辑
            //跳转到登录页面
            location.assign("login.html");
        }
    });
}