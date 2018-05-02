(function (w, d, u) {
    var tableShow = function () {
        $('#visitor_list').datagrid({
            url: '/visitor/list',
            fit: true,
            fitColumns: true,
            striped: true,
            rownumbers: true,
            border: true,
            pagination: true,
            pageSize: 10,
            pageList: [10, 20, 30, 40, 50],
            pageNumber: 1,
            /* sortName: 'modify_time',
             sortOrder: 'desc',
             toolbar: '#manage_tool',*/
            columns: [[
                {field: 'ip', title: 'ip地址', width: 100},
                {field: 'visitorTimeString', title: '访问时间', width: 100,},
                {field: 'userName', title: '访问账号', width: 100, align: 'right'},
                {field: 'roleName', title: '角色', width: 100, align: 'right'}
            ]],
        });
    }
    var page = {
        init: function () {
            tableShow();
        }
    };
    page.init();
})(window, document);