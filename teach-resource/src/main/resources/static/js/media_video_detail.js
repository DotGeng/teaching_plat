;(function (w, d, u) {
    var page = {
        init: function () {
            pushProcessIntoDB = function () {
                var tatolTime = document.getElementById("audio_show").duration;
                var current = document.getElementById("audio_show").currentTime;
                var process = current * 100 / tatolTime;
                alert(process.toFixed(1) + '%')
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
                    debugger;
                    $.messager.progress('close');
                    $('#media_title').html(result.content.title);
                    $('#media_desc').html(result.content.materialDesc);
                    $('#media_desc').html(result.content.materialDesc);
                    $('#audio_show').attr("src", result.content.url);
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
