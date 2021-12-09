/**
 * This file defines the route configuration for the Import Base data section of the CID system.
 *
 */
(function() {
    'use strict';

    angular
        .module('cid.staff-data.signin-history')
        .config(StaffSigninHistory);

    StaffSigninHistory.$inject = ["$stateProvider", "$urlRouterProvider"];

    function StaffSigninHistory($stateProvider, $urlRouterProvider) {
        $stateProvider
            .state('staff-data.signin-history', {
                url: '/signin-history',
                data: {
                    roles: ['ROLE_Staff']
                },
                views: {
                    "content@": {
                        templateUrl: 'js/modules/staff-data/signin-history/signin-history.html',
                        controller: 'StaffSigninHistoryController',
                        controllerAs: 'ctrl'
                    },
                },
                resolve: {
                    signinHistory: ['StaffSignin', 'Auth', function(StaffSignin, Auth) {
                        var currentUser = Auth.getUser();
                        return StaffSignin.getByStaffId(currentUser.staffId);
                    }]
                },
            });
    }

})();
