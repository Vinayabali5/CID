/**
 * This file defines the route configuration for the Interim report section of the CID system.
 *
 */
(function() {
    'use strict';

    angular
        .module('cid.interim-reports')
        .config(interimReportsRouteConfiguration);

    interimReportsRouteConfiguration.$inject = ['$stateProvider'];

    function interimReportsRouteConfiguration($stateProvider) {
        $stateProvider
            .state('interim-reports', {
                parent: 'site',
                url: '/interim-reports',
                abstract: true,
                data: {
                    roles: ['ROLE_Staff']
                },
                views: {
                    "content@": {
                        template: '<h1>Interim Reports</h1>'
                    },
                },
            });
    }

})();
