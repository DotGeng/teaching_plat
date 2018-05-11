(function (w, d, u) {
    var page = {
        init: function () {
            $('#account_edit_form').dialog({
                    width: 400,
                    title: '账户修改',
                    modal: true,
                    closed: true,
                    buttons: [{
                        text: '提交',
                        iconCls: 'icon-add',
                        handler: function () {
                            $.messager.confirm('确认', '您确认提交修改吗？', function (r) {
                                if (r) {
                                    if ($('#from_user_password').val() != $('#from_user_password').val()) {
                                        $.messager.alert("两次输入的密码不正确，请重新输入");
                                    } else {
                                        // 开始提交教师账号修改的数据
                                        $.ajax({
                                            type: 'post',
                                            url: '/teacher/account/edit',
                                            data: {
                                                teacherid: $('#id').val(),
                                                teachername: $('#from_user_name').val(),
                                                teacherpw: $('#from_user_password').val(),
                                                teacherrole: $('#teacherRole').val()
                                            },
                                            beforeSend: function () {
                                                $.messager.progress({
                                                    text: "正在提交数据..."
                                                });
                                            },
                                            success: function () {
                                                $.messager.progress('close');
                                                $('#account_edit_form').form('reset').dialog('close');
                                                // 刷新当前页面对象
                                                window.location.reload();
                                            }

                                        })
                                    }
                                }
                            });
                        }
                    }, {
                        text: '取消',
                        iconCls: 'icon-redo',
                        handler: function () {
                            $('#account_edit_form').form('reset').dialog('close');
                        }
                    }],
                }
            );
            $('#teacherName').val(sessionStorage.getItem('userName'));
            $('#roleName').val(sessionStorage.getItem('roleName'));
            $('#editAccountInfoButton').click(function () {
                $.ajax({
                    url: '/token/teacher',
                    type: 'get',
                    success: function (result) {
                        debugger;
                        $('#from_user_name').val(result.content.teachername);
                        $('#id').val(result.content.teacherid);
                        $("#teacherRole").find("option[value = '" + result.content.teacherrole + "']").attr("selected", "selected");
                    }, error: function (result) {

                    },
                });
                $('#account_edit_form').dialog('open');
            });
        }
    }
    page.init();
})(window, document);