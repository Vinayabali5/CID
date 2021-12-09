/**
 * This file defines the route configuration for the Generate Entries section of the CID system.
 *
 */
(function() {
    'use strict';

    angular
        .module('cid.exams.generate-entries')
        .config(ExamsGenerateEntriesRouteConfiguartion);

    ExamsGenerateEntriesRouteConfiguartion.$inject = ['$stateProvider', '$urlRouterProvider'];

    function ExamsGenerateEntriesRouteConfiguartion($stateProvider, $urlRouterProvider) {
        $stateProvider
            .state('exams.generate-entries', {
                url: '/generate-entries',
                data: {
                    roles: ['ROLE_Admin', 'ROLE_Exams Officer'],
                },
                views: {
                    "content@": {
                        templateUrl: 'js/modules/exams/generate-entries/views/student-option-entries-creation.html'
                    },
                },
            });

    }
})();
