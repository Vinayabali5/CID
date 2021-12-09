/**
 * This file defines the staff data module for the CID system
 */
(function() {
    'use strict';

    angular
        .module('cid.staff-data.payment-data')
        .controller('StaffPaymentDataController', StaffPaymentDataController);

    StaffPaymentDataController.$inject = ['$log', '$scope', 'staffPaymentData', 'Staff', 'Auth'];

    function StaffPaymentDataController($log, $scope, staffPaymentData, Staff, Auth) {
        /* jshint validthis:true */
        var vm = this;

        // Public Interface - Variables
        $scope.currentUser = Auth.getUser();
        $scope.staffpayment = staffPaymentData != null ? staffPaymentData.data : [];

    }
})();
