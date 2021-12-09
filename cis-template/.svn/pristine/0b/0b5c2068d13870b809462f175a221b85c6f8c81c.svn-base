(function() {
    'use strict';

    angular
        .module('cid.data')
        .config(cristalDataRouteConfiguration);

    cristalDataRouteConfiguration.$inject = ['$stateProvider'];

    function cristalDataRouteConfiguration($stateProvider) {
        $stateProvider
            .state('data.cristal', {
                abstract: true,
                url: '/cristal',
                data: {
                    roles: ['ROLE_Developer', 'ROLE_IT Support']
                },
            })
            .state('data.cristal.cristal-rooms', {
                url: '/cristal-rooms',
                data: {
                    roles: ['ROLE_Developer', 'ROLE_IT Support']
                },
                views: {
                    "content@": {
                        templateUrl: 'js/modules/data/views/cristal-rooms.html',
                        controller: 'DataController',
                        controllerAs: 'ctrl'
                    },
                },
                resolve: {
                    dataCollection: ['CristalRoom', function(CristalRoom) {
                        return CristalRoom.query();
                    }]
                }

            });

    }
})();
