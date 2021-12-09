(function() {
    'use strict';

    angular
        .module('cid.data')
        .config(safeguardingDataRouteConfiguration);

    safeguardingDataRouteConfiguration.$inject = ['$stateProvider'];

    function safeguardingDataRouteConfiguration($stateProvider) {
        $stateProvider
            .state('data.safeguarding', {
                abstract: true,
                url: '/safeguarding',
                data: {
                    roles: ['ROLE_Core Data']
                },
            })
            .state({
                name: 'data.safeguarding.risk-levels',
                url: '/risk-levels',
                data: {
                    roles: ['ROLE_Core Data']
                },
                views: {
                    "content@": {
                        templateUrl: 'js/modules/data/views/risk-levels.html',
                        controller: 'DataController',
                        controllerAs: 'ctrl'
                    },
                },
                resolve: {
                    dataCollection: ['RiskLevel', function(RiskLevel) {
                        return RiskLevel.query();
                    }]
                }

            });
    }
})();
