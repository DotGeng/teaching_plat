(function (w, d, u) {
    var page = {
        init: function () {
            $('#nav').tree({
                url: '/teacher/nav/create',
                line: true,
                onLoadSuccess: function (node, data) {
                    if (data) {
                        $(data).each(function () {
                            if (this.state == 'closed') {
                                $('#nav').tree('expandAll');

                            }
                        });

                    }
                },
                onClick: function (node) {
                    if (node.url) {
                        if ($('#tabs').tabs('exists', node.text)) {
                            $('#tabs').tabs('select', node.text);
                        } else {
                            $('#tabs').tabs('add', {
                                title: node.text,
                                closable: true,
                                href: node.url,
                            });
                        }
                    }
                }
            });
            $('#tabs').tabs({
                fit: true,
                border: false
            });
        }
    };
    page.init();
})(window, document);