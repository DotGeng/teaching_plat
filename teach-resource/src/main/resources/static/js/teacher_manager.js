(function (w, d, u) {
    var colseDialog = function () {
        $("#teacher_add").form('reset');
        $("#teacher_add_div").dialog('close');
    };
    var colseEditDialog = function () {
        $("#teachers_edit").form('reset');
        $("#teachers_edit_div").dialog('close');
    };
    $('#search_teacher').click(function () {
        $('#teacher_list_manager').datagrid('load', {
            teachername: $('#teacher_search_name').val()
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
        $('#teacher_list_manager').datagrid({
            url: '/teacher/manager/list',
            fit: true,
            fitColumns: true,
            striped: true,
            rownumbers: true,
            border: true,
            pagination: true,
            pageSize: 10,
            pageList: [10, 20, 30, 40, 50],
            pageNumber: 1,
            toolbar: '#teachers_manage_tool',
            columns: [[
                {field: 'teacherid', title: 'id', width: 100, checkbox: true},
                {field: 'teachername', title: '姓名', width: 100},
                {field: 'teacherpw', title: '密码', width: 100},
                {
                    field: 'teacherrole', title: '角色', width: 100, formatter: function (value, row, index) {
                    if (value == 2) {
                        return '超级管理员';
                    } else if (value == 1) {
                        return '普通教师';
                    }
                }
                }
            ]],
        });
    }
    var page = {
        init: function () {
            tableShow();
            $('#teacher_add_div').dialog({
                width: 400,
                title: '教师添加',
                modal: true,
                closed: true,
                buttons: [{
                    text: '新增',
                    iconCls: 'icon-add',
                    handler: function () {
                        if ($('#teacher_add').form('validate')) {
                            // 把数据写到数据库里边
                            var teachername = $('#teacher_add_name').val();
                            var teacherpw = $('#teacher_add_pwd').val();
                            var teacherrole = $('#teacher_role').val();
                            $.ajax({
                                url: "/teacher/manager/adding",
                                type: 'post',
                                data: {
                                    teachername: teachername,
                                    teacherpw: teacherpw,
                                    teacherrole: teacherrole
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
            $('#teachers_edit_div').dialog({
                width: 400,
                title: '教师信息修改',
                modal: true,
                closed: true,
                buttons: [{
                    text: '修改',
                    iconCls: 'icon-edit',
                    handler: function () {
                        if ($('#teachers_edit').form('validate')) {
                            // 把数据写到数据库里边
                            var teachername = $('#teacher_add_name').val();
                            var teacherpw = $('#teacher_add_pwd').val();
                            var teacherrole = $('#teacher_role').val();
                            $.ajax({
                                url: "/teacher/editing",
                                type: 'post',
                                data: {
                                    teachername: teachername,
                                    teacherpw: teacherpw,
                                    teacherrole: teacherrole
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
                missingMessage: "请输入教师姓名",
                invalidMessage: "",
            });
            manage_tool = {
                add: function () {
                    $("#teacher_add_div").dialog('open');
                },
                edit: function () {
                    var rows = $('#teacher_list_manager').datagrid('getSelections');
                    if (rows.length > 1) {
                        $.messager.alert("警告", "编辑记录只能选择一条");
                    } else if (rows.length == 1) {
                        $.ajax({
                            url: "/id/teacher/special",
                            type: 'post',
                            data: {
                                teacherid: rows[0].teacherid
                            },
                            beforeSend: function () {
                                $.messager.progress({
                                    text: '正在请求数据'
                                });
                            },
                            success: function (result) {
                                $.messager.progress('close');
                                if (result.content) {
                                    var obj = result.content;
                                    $('#teachers_edit_div').dialog('open');
                                    $('#teacher_id').val(obj.teacherid);
                                    $('#teacher_edit_name').val(obj.teachername);
                                    $('#teacher_edit_pwd').val(obj.teacherpw);
                                    $('#teacher_edit_role').val(obj.teacherrole);
                                }
                            },
                            error: function (result) {
                                $.messager.alert('获取失败', '未知原因导致数据获取失败');
                                $.messager.progress('close');
                            }

                        })
                    } else if (rows.length == 0) {
                        $.messager.alert("警告", "编辑信息必须选中一条记录");
                    }
                },
                remove: function () {
                    var rows = $('#teacher_list_manager').datagrid('getSelections');
                    if (rows.length > 0) {
                        $.messager.confirm('确认操作', '确定要删除选中记录吗？', function (flag) {
                            if (flag) {
                                var ids = [];
                                for (var i = 0; i < rows.length; i++) {
                                    ids.push(rows[i].teacherid);
                                }
                                $.ajax({
                                    type: 'post',
                                    url: '/teacher/deleting',
                                    data: {
                                        ids: ids.join(','),
                                    },
                                    beforeSend: function () {
                                        $('#teacher_list_manager').datagrid('loading');
                                    },
                                    success: function (result) {
                                        if (result.content) {
                                            $('#teacher_list_manager').datagrid('loaded');
                                            $('#teacher_list_manager').datagrid('load');
                                            $('#teacher_list_manager').datagrid('unselectAll');
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
                    $("#teacher_list_manager").datagrid('reload');
                },
                redo: function () {
                    $("#teacher_list_manager").datagrid('unselectAll');
                }

            };
        }
    };
    page.init();
})(window, document);