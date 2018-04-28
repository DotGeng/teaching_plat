(function (w, d, u) {
    var form = util.get('form');
    if (!form) {
        return;
    }
    var title = form['title'];
    var summary = form['goodsAbstract'];
    var image = form['pictureUrl'];
    var detail = form['content'];
    var price = form['goodsPrice'];
    var isSubmiting = false;
    var imgpre = util.get('imgpre');
    var page = {
        init: function () {

            $('#pictureUrl').bind('input propertychange', function () {
                $("#imgpre").attr("src", $(this).val());
            });

            $("#upload").click(function () {
                var formData = new FormData($('#uploadForm')[0]);
                $.ajax({
                    type: 'post',
                    url: "/image/upload?salerName=" + sessionStorage.getItem("salerName"),
                    data: formData,
                    cache: false,
                    processData: false,
                    contentType: false,
                    success: function (result) {
                        var url = result.content;
                        $("#pictureUrl").val(url);
                        $("#imgpre").attr("src", url);
                    },
                    error: function (result) {
                        alert("上传失败,请保证图片大小小于1Mb" + result);
                    }
                });
            });
            // 初始化页面数据
            $.ajax({
                type: 'post',
                url: "/goods/detail?salerName=" + sessionStorage.getItem("salerName"),
                data: {goodsId: sessionStorage.getItem("goodsId")},
                success: function (result) {
                    var goods = result.content;
                    $("#pictureUrl").val(goods.pictureUrl);
                    $("#title").val(goods.title);
                    $("#goodsAbstract").val(goods.goodsAbstract);
                    $("#content").val(goods.content);
                    $("#goodsPrice").val(goods.goodsPrice);
                    $("#imgpre").attr("src", goods.pictureUrl);
                },
                error: function (result) {
                    alert("数据请求失败" + result);
                }
            });
            form.addEventListener('submit', function (e) {
                if (!isSubmiting && this.check()) {
                    price.value = Number(price.value);
                    isSubmiting = true;
                    $.ajax({
                        type: 'post',
                        url: "/goods/changing?salerName=" + sessionStorage.getItem("salerName"),
                        data: {
                            goodsId: sessionStorage.getItem("goodsId"),
                            title: title.value,
                            goodsAbstract: summary.value,
                            pictureUrl: image.value,
                            content: detail.value,
                            goodsPrice: price.value
                        },
                        success: function (result) {
                            window.location.href = "/static/show/saler?salerName=" + sessionStorage.getItem("salerName");
                        },
                        error: function (result) {
                            alert("提交失败" + result);
                        }
                    });
                    /*form.submit();*/
                }
            }.bind(this), false);
            [title, summary, image, detail, price].forEach(function (item) {
                item.addEventListener('input', function (e) {
                    item.classList.remove('z-err');
                }.bind(this), false);
            }.bind(this));
            image.addEventListener('input', function (e) {
                var value = image.value.trim();
                if (value != '' && /^(http|https):\/\//.test(value) && /\.(jpg|gif|png)$/.test(value)) {
                    imgpre.src = value;
                }
            }.bind(this), false);
        },
        check: function () {
            var result = true;
            [
                [title, function (value) {
                    return value.length < 2 || value.length > 80
                }],
                [summary, function (value) {
                    return value.length < 2 || value.length > 140
                }],
                [image, function (value) {
                    return value == '' || !(/^(http|https):\/\//.test(value) && /\.(jpg|gif|png)$/.test(value))
                }],
                [detail, function (value) {
                    return value.length < 2 || value.length > 1000
                }],
                [price, function (value) {
                    return value == '' || !Number(value)
                }]
            ].forEach(function (item) {
                var value = item[0].value.trim();
                if (item[1](value)) {
                    item[0].classList.add('z-err');
                    result = false;
                }
                item[0].value = value;
            });
            return result;
        }
    };


    /*
     url: '/image/upload?salerName=' + sessionStorage.getItem("salerName"), /!*这是处理文件上传的servlet*!/
     type: 'POST',
     data: formData,
     async: false,
     cache: false,
     contentType: false,
     processData: false,
     success: function (returndata) {
     alert(returndata);
     /!*document.getElementById("showpic").src="<%=basePath%>UploadImage?picture=showpic";/!*这是预览图片用的，自己在文件上传表单外添加*!/!*!/
     },
     error: function (returndata) {
     alert(returndata);
     }
     });*/

    page.init();
})(window, document);