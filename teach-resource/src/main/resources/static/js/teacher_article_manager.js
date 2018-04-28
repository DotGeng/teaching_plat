(function (w, d, u) {
    var colseDialog = function () {
        $("#article_add").form('reset');
        $('#file').val('');
        $('#file_url_fiv_row').css("display", "none");
        $("#article_add_div").dialog('close');
    };
    var colseEditDialog = function () {
        $("#article_edit").form('reset');
        $('#fileEdit').val('');
        $('#file_url_eidt_fiv_row').css("display", "none");
        $("#article_edit_div").dialog('close');
    };
    $('#searchArticle').click(function () {
        $('#teacher_article_manager').datagrid('load',{
            articleName: $('#articleTitle').val(),
            createTimeBegin: $('#createTimeBegin').val(),
            createTimeEnd: $('#createTimeEnd').val(),
        });
    });
    var tableShow = function () {
        $('#teacher_article_manager').datagrid({
            url: 'article/list',
            fit: true,
            fitColumns: true,
            striped: true,
            rownumbers: true,
            border: true,
            pagination: true,
            pageSize: 10,
            pageList: [10, 20, 30, 40, 50],
            pageNumber: 1,
            sortName: 'modify_time',
            sortOrder: 'desc',
            toolbar: '#manage_tool',
            columns: [[
                {field: 'id', title: 'id', width: 100, checkbox: true},
                {field: 'articleName', title: '文章标题', width: 100},
                {field: 'articleDscrp', title: '文章简介', width: 100,},
                {field: 'createTimeFormat', title: '创建时间', width: 100, align: 'right'},
                {field: 'updateTimeFormat', title: '修改时间', width: 100, align: 'right'}
            ]],
        });
    }
    var page = {
        init: function () {
            tableShow();
            $('#article_add_div').dialog({
                width: 400,
                title: '文章添加',
                modal: true,
                closed: true,
                buttons: [{
                    text: '新增',
                    iconCls: 'icon-add',
                    handler: function () {
                        debugger;
                        if ($('#article_add').form('validate')) {
                            // 把数据写到数据库里边
                            var articleName = $('#articleName').val();
                            var articleDscrp = $('#articleDscrp').val();
                            var articlePath = $('#fileUrl').attr("href");
                            $.ajax({
                                url: "/article/info/adding",
                                type: 'post',
                                data: {
                                    articleName: articleName,
                                    articleDscrp: articleDscrp,
                                    articlePath: articlePath
                                },
                                success: function (result) {
                                    $.messager.alert("消息", "提交成功");
                                    colseDialog();
                                    // 刷新table
                                    tableShow();
                                },
                                error: function (result) {
                                    $.messager.alert("消息", "提交失败，请稍后重试");
                                }
                            });
                        }
                    }
                }, {
                    text: '取消',
                    iconCls: 'icon-redo',
                    handler: function () {
                        $.messager.confirm('确认', '您确认关闭对话框吗？关闭后所填写数据将被清空', function (r) {
                            if (r) {
                                colseDialog();
                            }
                        });
                    }
                }],
            });
            $('#article_edit_div').dialog({
                width: 400,
                title: '文章修改',
                modal: true,
                closed: true,
                buttons: [{
                    text: '修改',
                    iconCls: 'icon-edit',
                    handler: function () {
                        if ($('#article_edit').form('validate')) {
                            // 把数据写到数据库里边
                            var id = $('#id').val();
                            var articleName = $('#articleEditName').val();
                            var articleDscrp = $('#articleEditDscrp').val();
                            var articlePath = $('#fileEidtUrl').attr("href");
                            $.ajax({
                                url: "/article/info/editing",
                                type: 'post',
                                data: {
                                    id: id,
                                    articleName: articleName,
                                    articleDscrp: articleDscrp,
                                    articlePath: articlePath
                                },
                                success: function (result) {
                                    $.messager.alert("消息", "提交成功");
                                    colseEditDialog();
                                    // 刷新table
                                    tableShow();
                                },
                                error: function (result) {
                                    $.messager.alert("消息", "提交失败，请稍后重试");
                                }
                            });
                        }
                    }
                }, {
                    text: '取消',
                    iconCls: 'icon-redo',
                    handler: function () {
                        $.messager.confirm('确认', '您确认关闭对话框吗？关闭后将放弃本次修改', function (r) {
                            if (r) {
                                colseEditDialog();
                            }
                        });
                    }
                }],
            });
            /// 验证
            $('input[name="input_add"]').validatebox({
                required: true,
                missingMessage: "请输入文章主题",
                invalidMessage: "",
            });
            manage_tool = {
                add: function () {
                    $("#article_add_div").dialog('open');
                },
                edit: function () {
                    var rows = $('#teacher_article_manager').datagrid('getSelections');
                    if (rows.length > 1) {
                        $.messager.alert("警告", "编辑记录只能选择一条");
                    } else if (rows.length == 1) {
                        $.ajax({
                            url: "/id/article",
                            type: 'post',
                            data: {
                                id: rows[0].id
                            },
                            beforeSend: function () {
                                $.messager.progress({
                                    text: '正在请求数据',
                                });
                            },
                            success: function (result) {
                                $.messager.progress('close');
                                if (result.content) {
                                    var obj = result.content;
                                    debugger;
                                    $('#article_edit_div').dialog('open');
                                    $('#id').val(obj.id);
                                    $('#articleEditName').val(obj.articleName);
                                    $('#articleEditDscrp').val(obj.articleDscrp);
                                    $('#fileEidtUrl').attr('href', obj.articlePath);

                                    var arr = result.content.articlePath.split('/');
                                    var delStr = '/file/deleting?fileName=' + arr[arr.length - 1];
                                    $('#file_url_eidt_fiv_row').css({
                                        display: 'block',
                                        margin: 0,
                                        padding: '5px 0 0 25px'
                                    });

                                    $('#deletFileEditUrl').click(function () {
                                        $.ajax({
                                            type: 'get',
                                            url: delStr,
                                            success: function (result) {
                                                $('#fileEdit').val('');
                                                $('#file_url_eidt_fiv_row').css("display", 'none');
                                                $.messager.show({
                                                    title: '我的消息',
                                                    msg: '文件删除成功',
                                                    timeout: 5000,
                                                    showType: 'slide'
                                                });
                                            },
                                            error: function (result) {
                                                $.messager.show({
                                                    title: '我的消息',
                                                    msg: '文件删除失败，请稍后重试',
                                                    timeout: 5000,
                                                    showType: 'slide'
                                                });
                                            }
                                        });
                                    })
                                }
                            },
                            error: function (result) {
                                $.messager.alert('获取失败', '未知原因导致数据获取失败');
                            }

                        })
                    } else if (rows.length == 0) {
                        $.messager.alert("警告", "编辑信息必须选中一条记录");
                    }
                },
                remove: function () {
                    var rows = $('#teacher_article_manager').datagrid('getSelections');
                    if (rows.length > 0) {
                        $.messager.confirm('确认操作', '确定要删除选中记录吗？', function (flag) {
                            if (flag) {
                                var ids = [];
                                for (var i = 0; i < rows.length; i++) {
                                    ids.push(rows[i].id);
                                }
                                $.ajax({
                                    type: 'post',
                                    url: '/article/info/deleting',
                                    data: {
                                        ids: ids.join(','),
                                    },
                                    beforeSend: function () {
                                        $('#teacher_article_manager').datagrid('loading');
                                    },
                                    success: function (result) {
                                        if (result.content) {
                                            $('#teacher_article_manager').datagrid('loaded');
                                            $('#teacher_article_manager').datagrid('load');
                                            $('#teacher_article_manager').datagrid('unselectAll');
                                        }
                                        $.messager.show({
                                            title: '提示',
                                            msg: result.content + '个记录被删除',
                                        });
                                    }
                                });
                            } else {
                                $.messager.alert('提示', '请选择要删除的数据', 'info');
                            }
                        });
                    }
                },
                reload: function () {
                    $("#teacher_article_manager").datagrid('reload');
                },
                redo: function () {
                    $("#teacher_article_manager").datagrid('unselectAll');
                }

            };
            $("#upload_file_form").click(function () {
                var formData = new FormData($('#uploadForm')[0]);
                $.ajax({
                    type: 'post',
                    url: "/file/uploading",
                    data: formData,
                    cache: false,
                    processData: false,
                    contentType: false,
                    success: function (result) {
                        var url = result.content;
                        var arr = url.split("/");
                        $('#fileUrl').attr({
                            href: url,
                        });
                        var delStr = '/file/deleting?fileName=' + arr[arr.length - 1];
                        $('#file_url_fiv_row').css({
                            display: 'block',
                            margin: 0,
                            padding: '5px 0 0 25px'
                        });

                        $('#deletFileUrl').click(function () {
                            $.ajax({
                                type: 'get',
                                url: delStr,
                                success: function (result) {
                                    $('#file').val('');
                                    $('#file_url_fiv_row').css("display", 'none');
                                    $.messager.show({
                                        title: '我的消息',
                                        msg: '文件删除成功',
                                        timeout: 5000,
                                        showType: 'slide'
                                    });
                                },
                                error: function (result) {
                                    $.messager.show({
                                        title: '我的消息',
                                        msg: '文件删除失败，请稍后重试',
                                        timeout: 5000,
                                        showType: 'slide'
                                    });
                                }
                            });
                        })
                    },
                    error: function (result) {
                        alert("上传失败,请保证文件大小小于10Mb" + result);
                    }
                });
            });
            $("#upload_file_Edit_form").click(function () {
                var formData = new FormData($('#uploadEditForm')[0]);
                $.ajax({
                    type: 'post',
                    url: "/file/uploading",
                    data: formData,
                    cache: false,
                    processData: false,
                    contentType: false,
                    success: function (result) {
                        var url = result.content;
                        var arr = url.split("/");
                        $('#fileEidtUrl').attr({
                            href: url,
                        });
                        var delStr = '/file/deleting?fileName=' + arr[arr.length - 1];
                        $('#file_url_eidt_fiv_row').css({
                            display: 'block',
                            margin: 0,
                            padding: '5px 0 0 25px'
                        });

                        $('#deletFileEditUrl').click(function () {
                            $.ajax({
                                type: 'get',
                                url: delStr,
                                success: function (result) {
                                    $('#fileEdit').val('');
                                    $('#file_url_eidt_fiv_row').css("display", 'none');
                                    $.messager.show({
                                        title: '我的消息',
                                        msg: '文件删除成功',
                                        timeout: 5000,
                                        showType: 'slide'
                                    });
                                },
                                error: function (result) {
                                    $.messager.show({
                                        title: '我的消息',
                                        msg: '文件删除失败，请稍后重试',
                                        timeout: 5000,
                                        showType: 'slide'
                                    });
                                }
                            });
                        })
                    },
                    error: function (result) {
                        alert("上传失败,请保证文件大小小于10Mb" + result);
                    }
                });
            });
        }
    };

    page.init();

})(window, document);


