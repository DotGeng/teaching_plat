;(function (w, d, u) {
    var page = {
        init: function () {
            $('#managerNameP').html(sessionStorage.getItem('userName'));
            $('#report_manager_nav').tree({
                url: '/report/manager/navs',
                line: true,
                onLoadSuccess: function (node, data) {
                    if (data) {
                        $(data).each(function () {
                            if (this.state == 'closed') {
                                $('#report_manager_nav').tree('expandAll');
                            }
                        });
                    }
                },
                onClick: function (node) {
                    if (node.url) {
                        if ($('#manager_tabs').tabs('exists', node.text)) {
                            $('#manager_tabs').tabs('select', node.text);
                        } else {
                            $('#manager_tabs').tabs('add', {
                                title: node.text,
                                closable: true,
                                href: node.url,
                            });
                        }
                    }
                }
            });
            $('#manager_tabs').tabs({
                fit: true,
                border: false
            });
        }
    };
    page.init();
})(window, document);
