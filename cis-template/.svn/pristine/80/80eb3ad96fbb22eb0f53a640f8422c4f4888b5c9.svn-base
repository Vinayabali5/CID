/**
 * This file defines the staff data module for the CID system
 */
(function() {
    'use strict';

    angular
        .module('cid.staff-data.absence-data')
        .controller('StaffAbsenceDataController', StaffAbsenceDataController);

    StaffAbsenceDataController.$inject = ['$log', '$scope', 'staffAbsenceData', 'Auth'];

    function StaffAbsenceDataController($log, $scope, staffAbsenceData, Auth) {
        /* jshint validthis:true */
        var vm = this;

        // Public Interface - Variables
        $scope.currentUser = Auth.getUser();
        $scope.staffabsence = staffAbsenceData != null ? staffAbsenceData.data : [];

    }
})();
