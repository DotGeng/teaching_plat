/**
 * Created by YukunGeng on 2018/5/6.
 */
;(function (w, d, u) {
    var page = {
        init: function () {
            var fileClick = function () {
                // 只要下载就触发，发送100到数据库
                if (sessionStorage.getItem("studentId") != null) {
                    var process = 100;
                    $.ajax({
                        url: '/studying_material/process/setting',
                        type: 'post',
                        data: {
                            mediaId: sessionStorage.getItem("mediaId"),
                            studentId: sessionStorage.getItem("studentId"),
                            process: process
                        }
                    });
                }
            };
            $.ajax({
                url: "/studying_material/specific",
                type: 'post',
                data: {id: sessionStorage.getItem("mediaId")},
                beforeSend: function () {
                    $.messager.progress({
                        text: '正在请求数据中...',
                    });
                },
                success: function (result) {
                    $.messager.progress('close');
                    $('#file_media_title').html(result.content.title);
                    $('#file_media_desc').html(result.content.materialDesc);
                    $('#fileShow').attr("href", result.content.url);
                    $("#fileShow").click(function () {
                        fileClick();
                    });
                },
                error: function (result) {
                    $.messager.progress('close');
                    $.messager.alert("信息", "请求数据失败，请稍后重试");
                }
            });

        }
    };
    page.init();
})(window, document);
