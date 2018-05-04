;(function (w, d, u) {
    var page = {
        init: function () {
            $("#studing_btn a").click(function () {
                if ($("#studing_userName").val() == null || $("#studing_userName").val() == '') {
                    $.messager.alert('警告', '用户名不能为空');
                } else if ($("#studing_userName").val() == null || $("#studing_userName").val() == '') {
                    $.messager.alert('警告', '密码不能为空');
                }
                // 发起ajax请求
                var radioVal = $("input[name='studing_radio']:checked").val();
                var url = '/studing/teacher/login';
                var userName = $('#studing_userName').val();
                var password = $('#studing_password').val();
                if (radioVal == 2) {
                    // 超级管理员登录链接
                    teacherLogin(url, userName, password, radioVal);
                } else if (radioVal == 1) {
                    // 教师登录url
                    teacherLogin(url, userName, password, radioVal);
                } else if (radioVal == 3) {
                    // 学生登录url
                    url = '';
                }
            });
        }
    };
    // 教师ajax请求
    var teacherLogin = function (url, teacherName, teacherPswd, radioVal) {
        $.ajax({
            url: url,
            type: 'post',
            data: {
                teachername: teacherName,
                teacherpw: teacherPswd,
                teacherrole: radioVal,
            },
            beforeSend: function () {
                $.messager.progress({
                    text: '正在登录中...',
                });
            },
            success: function (data, response, status) {
                $.messager.progress('close');
                if (data.code == 200 && data.token != null) {
                    if (radioVal == '1') {
                        sessionStorage.setItem("userName", teacherName);
                        sessionStorage.setItem("roleName", "普通教师");
                        window.location.href = "/static/studingplat/teacher/index";
                    }
                    if (radioVal == '2') {
                        sessionStorage.setItem("userName", teacherName);
                        sessionStorage.setItem("roleName", "超级管理员");
                        window.location.href = "/static/resource/manager/index";
                    }
                }
            }
        })
    };
    page.init();
})(window, document);
