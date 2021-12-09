(function() {
    'use strict';

    angular
        .module('cid.data')
        .config(monirotingDataRouteConfiguration);

    monirotingDataRouteConfiguration.$inject = ['$stateProvider'];

    function monirotingDataRouteConfiguration($stateProvider) {
        $stateProvider
            .state('data.monitoring', {
                abstract: true,
                url: '/security',
                data: {
                    roles: ['ROLE_Core Data']
                },
            })
            .state('data.monitoring.attendance-monitorings', {
                url: '/attendance-monitorings',
                data: {
                    roles: ['ROLE_Core Data']
                },
                views: {
                    "content@": {
                        templateUrl: 'js/modules/data/views/attendance-monitorings.html',
                        controller: 'DataController',
                        controllerAs: 'ctrl'
                    },
                },
                resolve: {
                    dataCollection: ['AttendanceMonitoring', function(AttendanceMonitoring) {
                        return AttendanceMonitoring.query();
                    }]
                }

            })
            .state('data.monitoring.central-monitorings', {
                url: '/central-monitorings',
                data: {
                    roles: ['ROLE_Core Data']
                },
                views: {
                    "content@": {
                        templateUrl: 'js/modules/data/views/central-monitorings.html',
                        controller: 'DataController',
                        controllerAs: 'ctrl'
                    },
                },
                resolve: {
                    dataCollection: ['CentralMonitoring', function(CentralMonitoring) {
                        return CentralMonitoring.query();
                    }]
                }

            })
            .state('data.monitoring.punctuality-monitorings', {
                url: '/punctuality-monitorings',
                data: {
                    roles: ['ROLE_Core Data']
                },
                views: {
                    "content@": {
                        templateUrl: 'js/modules/data/views/punctuality-monitorings.html',
                        controller: 'DataController',
                        controllerAs: 'ctrl'
                    },
                },
                resolve: {
                    dataCollection: ['PunctualityMonitoring', function(PunctualityMonitoring) {
                        return PunctualityMonitoring.query();
                    }]
                }

            });
    }
})();
