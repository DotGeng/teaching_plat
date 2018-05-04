;(function (w, d, u) {
    var page = {
        init: function () {
            $('#restore-postPath').click(function () {

                $.messager.confirm('确认', '您确认想要还原数据库到指定版本吗？', function (r) {
                    if (r) {
                        if ($('#restore-path').val() == null || $('#restore-path').val() == "") {
                            $.messager.alert('警告', '请选择数据库备份文件');
                        }
                        var formData = new FormData($('#restore-uploadForm')[0]);
                        $.ajax({
                            type: 'post',
                            url: "/db/restore",
                            data: formData,
                            cache: false,
                            processData: false,
                            contentType: false,
                            beforeSend: function () {
                                $.messager.progress({
                                    text: '正在还原，请稍后...',
                                });
                            },
                            success: function (data) {
                                if (data.code == 200) {
                                    $.messager.progress('close');
                                    $.messager.alert('我的消息', '还原成功！');
                                }
                            }
                        });
                    }
                });
            });
        }
    };

    page.init();
})(window, document);
