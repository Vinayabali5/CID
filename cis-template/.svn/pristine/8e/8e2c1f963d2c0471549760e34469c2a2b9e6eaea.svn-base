/**
 * This file defines the route configuration for the Import Base data section of the CID system.
 *
 */
(function() {
    'use strict';

    angular
        .module('cid.exams.import-base-data')
        .config(ExamsImportBaseData);

    ExamsImportBaseData.$inject = ["$stateProvider", "$urlRouterProvider"];

    function ExamsImportBaseData($stateProvider, $urlRouterProvider) {
        $stateProvider
            .state('exams.import-base-data', {
                url: '/importBaseData',
                data: {
                    roles: ['ROLE_Exams Officer']
                },
                views: {
                    "content@": {
                        templateUrl: 'js/modules/exams/import-base-data/views/import-base-data-form.html',
                        controller: 'ExamImportBaseDataController',
                        controllerAs: 'ctrl'
                    },
                },
            });
    }

})();
