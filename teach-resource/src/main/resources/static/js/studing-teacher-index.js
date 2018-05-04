(function (w, d, u) {
    var page = {
        init: function () {
            $('#studing_teacherNameP').html(sessionStorage.getItem('userName'));
            $('#studing_teacher_nav').tree({
                url: '/studingteacher/nav/create',
                line: true,
                onLoadSuccess: function (node, data) {
                    if (data) {
                        $(data).each(function () {
                            if (this.state == 'closed') {
                                $('#studing_teacher_nav').tree('expandAll');
                            }
                        });
                    }
                },
                onClick: function (node) {
                    if (node.url) {
                        if ($('#studing_teacher_tabs').tabs('exists', node.text)) {
                            $('#studing_teacher_tabs').tabs('select', node.text);
                        } else {
                            $('#studing_teacher_tabs').tabs('add', {
                                title: node.text,
                                closable: true,
                                href: node.url,
                            });
                        }
                    }
                }
            });
            $('#studing_teacher_tabs').tabs({
                fit: true,
                border: false
            });
        }
    };
    page.init();
})(window, document);
