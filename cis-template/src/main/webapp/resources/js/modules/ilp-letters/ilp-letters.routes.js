/**
 * This file defines the route configuration for the student records section of the CID system.
 *
 */
(function() {
    'use strict';

    angular.module('cid.ilp-letters').config(ilpLettersRouteConfiguration);

    ilpLettersRouteConfiguration.$inject = ['$stateProvider'];

    function ilpLettersRouteConfiguration($stateProvider) {
        $stateProvider
            .state('ilp-letters', {
                parent: 'site',
                url: '/ilp-letters',
                data: {
                    roles: ['ROLE_Staff', 'ROLE_Office Administration', 'ROLE_Core Data']
                },
                views: {
                    "content@": {
                        templateUrl: 'js/modules/ilp-letters/views/letter-list.html',
                        controller: 'ILPLettersController',
                        controllerAs: 'ctrl'
                    },
                },
            });
    }

})();
