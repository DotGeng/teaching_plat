(function (w, d, u) {
    var colseDialog = function () {
        $("#student_add").form('reset');
        $('#studying_material_file').val('');
        $('#studying_material_file_url_fiv_row').css("display", "none");
        $("#student_add_div").dialog('close');
    };
    var colseEditDialog = function () {
        $("#students_edit").form('reset');
        $('#studying_material_fileEdit').val('');
        $('#studying_material_file_url_eidt_fiv_row').css("display", "none");
        $("#students_edit_div").dialog('close');
    };
    $('#search_student').click(function () {
        $('#student_list_manager').datagrid('load', {
            title: $('#student_name').val()
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
        $('#student_list_manager').datagrid({
            url: '/static/student/list',
            fit: true,
            fitColumns: true,
            striped: true,
            rownumbers: true,
            border: true,
            pagination: true,
            pageSize: 10,
            pageList: [10, 20, 30, 40, 50],
            pageNumber: 1,
            toolbar: '#students_manage_tool',
            columns: [[
                {field: 'studentid', title: 'id', width: 100, checkbox: true},
                {field: 'studentno', title: '学号', width: 100},
                {field: 'studclass', title: '班级', width: 100},
                {field: 'studentname', title: '姓名', width: 100},
                {field: 'studentpw', title: '密码', width: 100, align: 'right'},
                {field: 'major', title: '专业', width: 100, align: 'right'},
                {field: 'colledge', title: '学院', width: 100, align: 'right'},
                {
                    field: 'passed',
                    title: '是否通过',
                    width: 100,
                    align: 'right',
                    formatter: function (value, row, index) {
                        if (value == 1) {
                            return '通过';
                        } else {
                            return '不通过';
                        }
                    }
                },
                {field: 'score', title: '分数', width: 100, align: 'right'},
                {field: 'examtimes', title: '考试次数', width: 100, align: 'right'},
                {
                    field: 'ischeated',
                    title: '是否作弊',
                    width: 100,
                    align: 'right',
                    formatter: function (value, row, index) {
                        if (value == 1) {
                            return '是';
                        } else {
                            return '无';
                        }
                    }
                }


            ]],
        });
    }
    var page = {
        init: function () {
            tableShow();
            $('#student_add_div').dialog({
                width: 400,
                title: '学生添加',
                modal: true,
                closed: true,
                buttons: [{
                    text: '新增',
                    iconCls: 'icon-add',
                    handler: function () {
                        if ($('#student_add').form('validate')) {
                            // 把数据写到数据库里边
                            var studentno = $('#student_add_no').val();
                            var studclass = $('#student_add_class').val();
                            var studentname = $('#student_add_name').val();
                            var studentpw = $('#student_add_pwd').val();
                            var major = $('#student_add_major').val();
                            var colledge = $('#student_add_colledge').val();
                            var passed = $('#student_add_passed').val();
                            var score = $('#student_add_score').val();
                            var examtimes = $('#student_add_exam_time').val();
                            var ischeated = $('#student_add_is_cheated').val();
                            $.ajax({
                                url: "/media/info/adding",
                                type: 'post',
                                data: {
                                    studentno: studentno,
                                    studclass: studclass,
                                    studentname: studentname,
                                    studentpw: studentpw,
                                    major: major,
                                    colledge: colledge,
                                    passed: studentpw,
                                    studentpw: studentpw,
                                    studentpw: studentpw,
                                    studentpw: studentpw,
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
            $('#students_edit_div').dialog({
                width: 400,
                title: '文章修改',
                modal: true,
                closed: true,
                buttons: [{
                    text: '修改',
                    iconCls: 'icon-edit',
                    handler: function () {
                        if ($('#students_edit').form('validate')) {
                            // 把数据写到数据库里边
                            var studentid = $('#student_id').val();
                            var studentno = $('#student_no').val();
                            var studclass = $('#student_class').val();
                            var studentname = $('#student_edit_name').val();
                            var studentpw = $('#student_edit_pwd').val();
                            var major = $('#student_edit_major').val();
                            var colledge = $('#student_edit_colledge').val();
                            var passed = $('#student_edit_passed').val();
                            var score = $('#student_edit_score').val();
                            var examtimes = $('#student_edit_exam_time').val();
                            var ischeated = $('#student_edit_is_cheated').val();
                            $.ajax({
                                url: "/student/manager/edit",
                                type: 'post',
                                data: {
                                    studentid: studentid,
                                    studentno: studentno,
                                    studclass: studclass,
                                    studentname: studentname,
                                    studentpw: studentpw,
                                    major: major,
                                    colledge: colledge,
                                    passed: passed,
                                    examtimes: examtimes,
                                    ischeated: ischeated
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
                missingMessage: "请输入学生学号",
                invalidMessage: "",
            });
            manage_tool = {
                add: function () {
                    $("#student_add_div").dialog('open');
                },
                edit: function () {
                    var rows = $('#student_list_manager').datagrid('getSelections');
                    if (rows.length > 1) {
                        $.messager.alert("警告", "编辑记录只能选择一条");
                    } else if (rows.length == 1) {
                        $.ajax({
                            url: "/id/student/specific",
                            type: 'post',
                            data: {
                                studentid: rows[0].studentid
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
                                    $('#students_edit_div').dialog('open');
                                    $('#student_id').val(obj.studentid);
                                    $('#student_no').val(obj.studentno);
                                    $('#student_class').val(obj.studclass);
                                    $('#student_edit_name').val(obj.studentname);
                                    $('#student_edit_pwd').val(obj.studentpw);
                                    $('#student_edit_major').val(obj.major);
                                    $('#student_edit_colledge').val(obj.colledge);
                                    $('#student_edit_passed').val(obj.passed);
                                    $('#student_edit_score').val(obj.score);
                                    $('#student_edit_exam_time').val(obj.examtimes);
                                    $('#student_edit_is_cheated').val(obj.ischeated);
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
                    var rows = $('#student_list_manager').datagrid('getSelections');
                    if (rows.length > 0) {
                        $.messager.confirm('确认操作', '确定要删除选中记录吗？', function (flag) {
                            if (flag) {
                                var ids = [];
                                for (var i = 0; i < rows.length; i++) {
                                    ids.push(rows[i].studentid);
                                }
                                $.ajax({
                                    type: 'post',
                                    url: '/students/manager/deleting',
                                    data: {
                                        ids: ids.join(','),
                                    },
                                    beforeSend: function () {
                                        $('#student_list_manager').datagrid('loading');
                                    },
                                    success: function (result) {
                                        if (result.content) {
                                            $('#student_list_manager').datagrid('loaded');
                                            $('#student_list_manager').datagrid('load');
                                            $('#student_list_manager').datagrid('unselectAll');
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
                    $("#student_list_manager").datagrid('reload');
                },
                redo: function () {
                    $("#student_list_manager").datagrid('unselectAll');
                }

            };
            $("#studying_material_upload_file_form").click(function () {
                var formData = new FormData($('#studying_material_uploadForm')[0]);
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