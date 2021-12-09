/**
 * This file defines the route configuration for the Course data section of the CID system.
 *
 */
(function() {
    'use strict';

    angular
        .module('cid.interim-reports.review-data')
        .config(InterimReportReviewData);

    InterimReportReviewData.$inject = ["$stateProvider", "$urlRouterProvider"];

    function InterimReportReviewData($stateProvider, $urlRouterProvider) {
        $stateProvider
            .state('interim-reports.review', {
                abstract: true,
                url: '/'
            })

            .state('interim-reports.review-data', {
                url: '/reviewData',
                data: {
                    roles: ['ROLE_Staff']
                },
                views: {
                    "content@": {
                        templateUrl: 'js/modules/interim-reports/review-data/views/review-data-list.html',
                        controller: 'InterimReportReviewDataController',
                        controllerAs: 'ctrl'
                    },
                },
                resolve: {
                    reviewList: ['InterimReportsDue', function(InterimReportsDue) {
                        return InterimReportsDue.query();
                    }]
                }
            });

    }

})();
