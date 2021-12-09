/**
 * This file defines the route configuration for the exams section of the CID system.
 *
 */
(function() {
    'use strict';

    angular
        .module('cid.exams')
        .config(RouteConfiguration);

    RouteConfiguration.$inject = ['$stateProvider'];

    function RouteConfiguration($stateProvider) {
        $stateProvider
            .state('exams', {
                parent: 'site',
                url: '/exams',
                abstract: true,
                data: {
                    roles: ['ROLE_Exams Officer']
                },
                views: {
                    "content@": {
                        template: '<h1>Exams System</h1>'
                    },
                },
            });

    }
})();
