(function (w, d, u) {
    var colseDialog = function () {
        $("#studying_material_article_add").form('reset');
        $('#studying_material_file').val('');
        $('#studying_material_file_url_fiv_row').css("display", "none");
        $("#studying_material_article_add_div").dialog('close');
    };
    var colseEditDialog = function () {
        $("#studying_material_article_edit").form('reset');
        $('#studying_material_fileEdit').val('');
        $('#studying_material_file_url_eidt_fiv_row').css("display", "none");
        $("#studying_material_article_edit_div").dialog('close');
    };
    $('#studying_material_searchArticle').click(function () {
        $('#studying_material_teacher_article_manager').datagrid('load', {
            articleName: $('#studying_material_articleTitle').val(),
            createTimeBegin: $('#studying_material_createTimeBegin').val(),
            createTimeEnd: $('#studying_material_createTimeEnd').val(),
        });
    });
    detailMedia = function (value, mediaType) {
        sessionStorage.setItem("mediaId", value);
        if (mediaType == 1) { // 音频
            window.open("/static/studying_material/audio/detail");
        } else if (mediaType == 2) { //视频
            window.open("/static/studying_material/video/detail");
        } else {
            window.open("/static/studying_material/file/detail");
        }
    }
    var tableShow = function () {
        $('#studying_material_teacher_article_manager').datagrid({
            url: '/studying_material/list',
            fit: true,
            fitColumns: true,
            striped: true,
            rownumbers: true,
            border: true,
            pagination: true,
            pageSize: 10,
            pageList: [10, 20, 30, 40, 50],
            pageNumber: 1,
            sortName: 'update_time',
            sortOrder: 'desc',
            toolbar: '#studying_material_manage_tool',
            columns: [[
                {field: 'id', title: 'id', width: 100, checkbox: true},
                {field: 'title', title: '题目', width: 100},
                {field: 'materialDesc', title: '内容简介', width: 100},
                {field: 'roleFormat', title: '内容类型', width: 100},
                {field: 'createTimeFormat', title: '创建时间', width: 100, align: 'right'},
                {field: 'updateTimeFormat', title: '修改时间', width: 100, align: 'right'},
                {
                    field: 'mediaId', title: '详情', width: 100, formatter: function (value, row, index) {
                    return '<a style="color:blue" onclick="detailMedia(' + value + ',' + row.type + ');">查看</a>';
                }
                }
            ]],
        });
    }
    var page = {
        init: function () {
            tableShow();
            $('#studying_material_article_add_div').dialog({
                width: 400,
                title: '文章添加',
                modal: true,
                closed: true,
                buttons: [{
                    text: '新增',
                    iconCls: 'icon-add',
                    handler: function () {
                        if ($('#studying_material_article_add').form('validate')) {
                            // 把数据写到数据库里边
                            var articleName = $('#studying_material_articleName').val();
                            var articleDscrp = $('#studying_material_articleDscrp').val();
                            var articlePath = $('#studying_material_fileUrl').attr("href");
                            $.ajax({
                                url: "/media/info/adding",
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
            $('#studying_material_article_edit_div').dialog({
                width: 400,
                title: '文章修改',
                modal: true,
                closed: true,
                buttons: [{
                    text: '修改',
                    iconCls: 'icon-edit',
                    handler: function () {
                        if ($('#studying_material_article_edit').form('validate')) {
                            // 把数据写到数据库里边
                            var id = $('#studying_material_id').val();
                            var title = $('#studying_material_articleEditName').val();
                            var materialDesc = $('#studying_material_articleEditDscrp').val();
                            var url = $('#studying_material_fileEidtUrl').attr("href");
                            var type = $('#media_type').val();
                            $.ajax({
                                url: "/id/media/editing",
                                type: 'post',
                                data: {
                                    id: id,
                                    title: title,
                                    materialDesc: materialDesc,
                                    url: url,
                                    type: type
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
                    $("#studying_material_article_add_div").dialog('open');
                },
                edit: function () {
                    var rows = $('#studying_material_teacher_article_manager').datagrid('getSelections');
                    if (rows.length > 1) {
                        $.messager.alert("警告", "编辑记录只能选择一条");
                    } else if (rows.length == 1) {
                        $.ajax({
                            url: "/studying_material/specific",
                            type: 'post',
                            data: {
                                id: rows[0].id,
                                /*title: rows[0].title,
                                 materialDesc: rows[0].materialDesc,
                                 roleFormat: rows[0].roleFormat,
                                 updateTimeFormat: rows[0].updateTimeFormat*/
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
                                    $('#studying_material_article_edit_div').dialog('open');
                                    $('#studying_material_id').val(obj.id);
                                    $('#studying_material_articleEditName').val(obj.title);
                                    $('#studying_material_articleEditDscrp').val(obj.materialDesc);
                                    $('#media_type').val(obj.type);
                                    $('#studying_material_fileEidtUrl').attr('href', obj.url);
                                    var arr = result.content.url.split('/');
                                    var delStr = '/file/deleting?fileName=' + arr[arr.length - 1];
                                    $('#studying_material_file_url_eidt_fiv_row').css({
                                        display: 'block',
                                        margin: 0,
                                        padding: '5px 0 0 25px'
                                    });

                                    $('#studying_material_deletFileEditUrl').click(function () {
                                        $.ajax({
                                            type: 'get',
                                            url: delStr,
                                            success: function (result) {
                                                $('#studying_material_fileEdit').val('');
                                                $('#studying_material_file_url_eidt_fiv_row').css("display", 'none');
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
                    var rows = $('#studying_material_teacher_article_manager').datagrid('getSelections');
                    if (rows.length > 0) {
                        $.messager.confirm('确认操作', '确定要删除选中记录吗？', function (flag) {
                            if (flag) {
                                var ids = [];
                                for (var i = 0; i < rows.length; i++) {
                                    ids.push(rows[i].id);
                                }
                                $.ajax({
                                    type: 'post',
                                    url: '/studying_material/deleting',
                                    data: {
                                        ids: ids.join(','),
                                    },
                                    beforeSend: function () {
                                        $('#studying_material_teacher_article_manager').datagrid('loading');
                                    },
                                    success: function (result) {
                                        if (result.content) {
                                            $('#studying_material_teacher_article_manager').datagrid('loaded');
                                            $('#studying_material_teacher_article_manager').datagrid('load');
                                            $('#studying_material_teacher_article_manager').datagrid('unselectAll');
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
                    $("#studying_material_teacher_article_manager").datagrid('reload');
                },
                redo: function () {
                    $("#studying_material_teacher_article_manager").datagrid('unselectAll');
                }

            };
            $("#studying_material_upload_file_form").click(function () {
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
                        $('#studying_material_fileUrl').attr({
                            href: url,
                        });
                        var delStr = '/file/deleting?fileName=' + arr[arr.length - 1];
                        $('#studying_material_file_url_fiv_row').css({
                            display: 'block',
                            margin: 0,
                            padding: '5px 0 0 25px'
                        });

                        $('#studying_material_deletFileUrl').click(function () {
                            $.ajax({
                                type: 'get',
                                url: delStr,
                                success: function (result) {
                                    $('#studying_material_file').val('');
                                    $('#studying_material_file_url_fiv_row').css("display", 'none');
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
            $("#studying_material_upload_file_Edit_form").click(function () {
                var formData = new FormData($('#studying_material_uploadEditForm')[0]);
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
                        $('#studying_material_fileEidtUrl').attr({
                            href: url,
                        });
                        var delStr = '/file/deleting?fileName=' + arr[arr.length - 1];
                        $('#studying_material_file_url_eidt_fiv_row').css({
                            display: 'block',
                            margin: 0,
                            padding: '5px 0 0 25px'
                        });

                        $('#studying_material_deletFileEditUrl').click(function () {
                            $.ajax({
                                type: 'get',
                                url: delStr,
                                success: function (result) {
                                    $('#studying_material_fileEdit').val('');
                                    $('#studying_material_file_url_eidt_fiv_row').css("display", 'none');
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


