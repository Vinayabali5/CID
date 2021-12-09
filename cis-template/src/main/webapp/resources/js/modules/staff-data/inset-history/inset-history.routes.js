/**
 * This file defines the route configuration for the Import Base data section of the CID system.
 *
 */
(function() {
    'use strict';

    angular
        .module('cid.staff-data.inset-history')
        .config(StaffInsetHistory);

    StaffInsetHistory.$inject = ["$stateProvider", "$urlRouterProvider"];

    function StaffInsetHistory($stateProvider, $urlRouterProvider) {
        $stateProvider
            .state('staff-data.inset-history', {
                url: '/inset-history',
                data: {
                    roles: ['ROLE_Staff']
                },
                views: {
                    "content@": {
                        templateUrl: 'js/modules/staff-data/inset-history/inset-history.html',
                        controller: 'StaffInsetHistoryController',
                        controllerAs: 'ctrl'
                    },
                },
                resolve: {
                    insetHistory: ['StaffInsetCourse', 'Auth', function(StaffInsetCourse, Auth) {
                        var currentUser = Auth.getUser();
                        return StaffInsetCourse.getByStaffId(currentUser.staffId);
                    }]
                },
            });
    }

})();
