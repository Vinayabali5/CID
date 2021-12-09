/**
 * This file defines the route configuration for the Course data section of the CID system.
 *
 */
(function() {
    'use strict';

    angular
        .module('cid.interim-reports.staff-interim-reports')
        .config(StaffInterimReportsData);

    StaffInterimReportsData.$inject = ["$stateProvider", "$urlRouterProvider"];

    function StaffInterimReportsData($stateProvider, $urlRouterProvider) {
        $stateProvider
            .state('interim-reports.staff-interim-reports', {
                url: '/staff-interim-reports',
                data: {
                    roles: ['ROLE_Staff']
                },
                views: {
                    "content@": {
                        templateUrl: 'js/modules/interim-reports/staff-interim-reports/staff-interim-reports-list.html',
                        controller: 'StaffInterimReportsController',
                        controllerAs: 'ctrl'
                    },
                },
                resolve: {
                    reviewList: ['InterimReportsDue', 'Auth', function(InterimReportsDue, Auth) {
                        var currentUser = Auth.getUser();
                        return InterimReportsDue.myInterimReports(currentUser.staffId);
                    }]
                }
            });

    }

})();
