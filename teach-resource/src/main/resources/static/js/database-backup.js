;(function (w, d, u) {
    var page = {
        init: function () {
            $('#postPath').click(function () {
                $.ajax({
                    type: 'post',
                    url: '/db/backup',
                    data: {
                        savePath: $('#path').val()
                    },
                    beforeSend: function () {
                        $.messager.progress({
                            text: '正在备份，请稍后...',
                        });
                    },
                    success: function (data) {
                        if (data.code == 200) {
                            $.messager.progress('close');
                            $.messager.alert('我的消息', '备份成功！');
                        }
                    }
                })
            });
        }
    };

    page.init();
})(window, document);
