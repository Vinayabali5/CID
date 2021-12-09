(function() {
    'use strict';

    angular
        .module('cid.data')
        .config(securityDataRouteConfiguration);

    securityDataRouteConfiguration.$inject = ['$stateProvider'];

    function securityDataRouteConfiguration($stateProvider) {
        $stateProvider
            .state('data.security', {
                abstract: true,
                url: '/security',
                data: {
                    roles: ['ROLE_Developer', 'ROLE_System Admin']
                },
            })
            .state('data.security.staff', {
                url: '/staff',
                data: {
                    roles: ['ROLE_Developer', 'ROLE_System Admin']
                },
                views: {
                    "content@": {
                        templateUrl: 'js/modules/data/views/staff.html',
                        controller: 'DataController',
                        controllerAs: 'ctrl'
                    },
                },
                resolve: {
                    dataCollection: ['Staff', function(Staff) {
                        return Staff.query();
                    }]
                }

            })

            .state('data.security.roles', {
                url: '/roles',
                data: {
                    roles: ['ROLE_Developer', 'ROLE_System Admin']
                },
                views: {
                    "content@": {
                        templateUrl: 'js/modules/data/views/roles.html',
                        controller: 'DataController',
                        controllerAs: 'ctrl'
                    },
                },
                resolve: {
                    dataCollection: ['Role', function(Role) {
                        return Role.query();
                    }]
                }

            });
    }
})();
