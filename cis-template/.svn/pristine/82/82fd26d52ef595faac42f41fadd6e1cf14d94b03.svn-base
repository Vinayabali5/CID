(function() {
    'use strict';

    angular.module('RestUrlService', []).service(
        'RestUrlUtils',
        function() {
            this.convertUriToId = function(uri) {
                if (uri) {
                    var arr;
                    if (uri.href) {
                        arr = uri.href.split('/');
                    } else {
                        arr = uri.split('/');
                    }
                    return arr[arr.length - 1];
                } else {
                    return null;
                }
            };
        });

}());
