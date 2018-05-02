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
                                        $.messager.alert("两次输入的密码不正确，从从新输入");
                                    } else {
                                        // 开始提交修改的数据
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
            $('#editAccountInfoButton').click(function () {
                $.ajax({
                    url: '/token/teacher',
                    type: 'get',
                    success: function (result) {
                        $('#from_user_name').val(result.content.teacherName);
                        $('#id').val(result.content.teacherId);
                        $("#teacherRole").find("option[value = '" + result.content.teacherRole + "']").attr("selected", "selected");
                    }, error: function (result) {

                    },
                });
                $('#account_edit_form').dialog('open');
            });
        }
    }
    page.init();
})(window, document);