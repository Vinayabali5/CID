/**
 * This file defines the route configuration for the Staff Details section of the CID system.
 *
 */
(function() {
    'use strict';

    angular
        .module('cid.staff-data')
        .config(staffDataRouteConfiguration);

    staffDataRouteConfiguration.$inject = ['$stateProvider'];

    function staffDataRouteConfiguration($stateProvider) {
        $stateProvider
            .state('staff-data', {
                parent: 'site',
                url: '/staff-data',
                abstract: true,
                data: {
                    roles: ['ROLE_Staff']
                },
                views: {
                    "content@": {
                        template: '<h1>Staff Information</h1>'
                    },
                },
            });
    }

})();
