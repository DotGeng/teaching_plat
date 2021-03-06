;(function (w, d, u) {
    var page = {
        init: function () {
            pushProcessIntoDB = function () {
                if (sessionStorage.getItem("studentId") != null) {
                    var tatolTime = document.getElementById("audio_show").duration;
                    var current = document.getElementById("audio_show").currentTime;
                    var process = current * 100 / tatolTime;
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
                // 接下来使用ajax定期刷新到数据库中即可

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
                    $('#video_media_title').html(result.content.title);
                    $('#video_media_desc').html(result.content.materialDesc);
                    $('#video_media_desc').html(result.content.materialDesc);
                    $('#video_show').attr("src", result.content.url);
                    setInterval("pushProcessIntoDB()", 5000);
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
