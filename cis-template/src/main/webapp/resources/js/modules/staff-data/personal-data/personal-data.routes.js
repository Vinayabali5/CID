/**
 * This file defines the route configuration for the Import Base data section of the CID system.
 *
 */
(function() {
    'use strict';

    angular
        .module('cid.staff-data.personal-data')
        .config(StaffPersonalData);

    StaffPersonalData.$inject = ["$stateProvider", "$urlRouterProvider"];

    function StaffPersonalData($stateProvider, $urlRouterProvider) {
        $stateProvider
            .state('staff-data.personal-data', {
                url: '/personalData',
                data: {
                    roles: ['ROLE_Staff']
                },
                views: {
                    "content@": {
                        templateUrl: 'js/modules/staff-data/personal-data/views/personal-data.html',
                        controller: 'StaffPersonalDataController',
                        controllerAs: 'ctrl'
                    },
                },
                resolve: {
                    staffEntity: ['Staff', 'Auth', function(Staff, Auth) {
                        var currentUser = Auth.getUser();
                        return Staff.get(currentUser.staffId);
                    }]
                },
            });
    }

})();
