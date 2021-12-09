/**
 * This is the error handler for the site.
 *
 *  Applied Styles: [Y001, Y002, Y010, Y021]
 *
 * @type Module
 */
(function() {
    'use strict';

    angular
        .module('ErrorHandler')
        .config(['$stateProvider', function($stateProvider) {
            $stateProvider
                .state('error', {
                    parent: 'site',
                    url: '/error',
                    data: {
                        roles: []
                    },
                    views: {
                        "content@": {
                            templateUrl: 'partials/error.html'
                        }
                    }
                })
                .state('accessdenied', {
                    parent: 'site',
                    url: '/accessdenied',
                    data: {
                        roles: []
                    },
                    views: {
                        "content@": {
                            templateUrl: 'partials/accessdenied.html'
                        }
                    },
                });
        }]);

})();
