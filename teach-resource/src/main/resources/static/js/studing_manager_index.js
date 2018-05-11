(function (w, d, u) {
    var page = {
        init: function () {
            $('#studing_managerNameP').html(sessionStorage.getItem('userName'));
            $('#studing_manager_nav').tree({
                url: '/studingmanager/nav/create',
                line: true,
                onLoadSuccess: function (node, data) {
                    if (data) {
                        $(data).each(function () {
                            if (this.state == 'closed') {
                                $('#studing_manager_nav').tree('expandAll');
                            }
                        });
                    }
                },
                onClick: function (node) {
                    if (node.url) {
                        if ($('#studing_manager_tabs').tabs('exists', node.text)) {
                            $('#studing_manager_tabs').tabs('select', node.text);
                        } else {
                            $('#studing_manager_tabs').tabs('add', {
                                title: node.text,
                                closable: true,
                                href: node.url,
                            });
                        }
                    }
                }
            });
            $('#studing_manager_tabs').tabs({
                fit: true,
                border: false
            });
        }
    };
    page.init();
})(window, document);
