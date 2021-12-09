/**
 * This file defines the route configuration for the Import Base data section of the CID system.
 *
 */
(function() {
    'use strict';

    angular
        .module('cid.staff-data.absence-data')
        .config(StaffAbsenceData);

    StaffAbsenceData.$inject = ["$stateProvider", "$urlRouterProvider"];

    function StaffAbsenceData($stateProvider, $urlRouterProvider) {
        $stateProvider
            .state('staff-data.absence-data', {
                url: '/absence-data',
                data: {
                    roles: ['ROLE_Staff']
                },
                views: {
                    "content@": {
                        templateUrl: 'js/modules/staff-data/absence-data/absence-data.html',
                        controller: 'StaffAbsenceDataController',
                        controllerAs: 'ctrl'
                    },
                },
                resolve: {
                    staffAbsenceData: ['StaffAbsence', 'Auth', function(StaffAbsence, Auth) {
                        var currentUser = Auth.getUser();
                        return StaffAbsence.getByStaffId(currentUser.staffId);
                    }]
                },
            });
    }

})();
