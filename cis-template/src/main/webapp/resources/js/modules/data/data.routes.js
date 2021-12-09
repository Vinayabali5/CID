(function() {
    'use strict';

    angular
        .module('cid.data')
        .config(dataRouteConfiguration);

    dataRouteConfiguration.$inject = ['$stateProvider'];

    function dataRouteConfiguration($stateProvider) {
        $stateProvider
            .state('data', {
                abstract: true,
                parent: 'site',
                url: '/data',
            });
    }
})();
