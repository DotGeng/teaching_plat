;(function (w, d, u) {
    var page = {
        init: function () {
            $("#btn a").click(function () {
                if ($("#userName").val() == null || $("#userName").val() == '') {
                    $.messager.alert('警告', '用户名不能为空');
                } else if ($("#userName").val() == null || $("#userName").val() == '') {
                    $.messager.alert('警告', '密码不能为空');
                }

                // 发起ajax请求
                var radioVal = $("input[name='radio']:checked").val();
                var url = '';
                var userName = $('#userName').val();
                var password = $('#password').val();
                if (radioVal == 1) {
                    // 超级管理员登录链接
                } else if (radioVal == 2) {
                    // 教师登录url
                    url = '/teacher/session/create';
                    teacherLogin(url, userName, password);
                } else if (radioVal == 3) {
                    // 学生登录url
                    url = '';
                }
            });
        }
    };
    // 教师ajax请求
    var teacherLogin = function (url, teacherName, teacherPswd) {
        $.ajax({
            url: url,
            type: 'post',
            data: {
                teacherName: teacherName,
                teacherPswd: teacherPswd
            },
            beforeSend: function () {
                $.messager.progress({
                    text: '正在登录中...',
                });
            },
            success: function (data, response, status) {
                $.messager.progress('close');
                if (data.code == 200) {
                    sessionStorage.setItem("userName",teacherName);
                    window.location.href = "/static/resource/teacher/index";
                }
            }
        })
    };
    page.init();
})(window, document);
