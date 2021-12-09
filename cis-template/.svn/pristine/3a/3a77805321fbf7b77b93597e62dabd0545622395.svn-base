/**
 * This file defines the route configuration for the Import Base data section of the CID system.
 *
 */
(function() {
    'use strict';

    angular
        .module('cid.staff-data.payment-data')
        .config(StaffPaymentData);

    StaffPaymentData.$inject = ["$stateProvider", "$urlRouterProvider"];

    function StaffPaymentData($stateProvider, $urlRouterProvider) {
        $stateProvider
            .state('staff-data.payment-data', {
                url: '/payment-data',
                data: {
                    roles: ['ROLE_Staff']
                },
                views: {
                    "content@": {
                        templateUrl: 'js/modules/staff-data/payment-data/payment-data.html',
                        controller: 'StaffPaymentDataController',
                        controllerAs: 'ctrl'
                    },
                },
                resolve: {
                    staffPaymentData: ['StaffPayment', 'Auth', function(StaffPayment, Auth) {
                        var currentUser = Auth.getUser();
                        return StaffPayment.getByStaffId(currentUser.staffId);
                    }]
                },
            });
    }

})();
