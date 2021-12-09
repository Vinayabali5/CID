/**
 * This file defines the staff data module for the CID system
 */
(function() {
    'use strict';

    angular
        .module('cid.staff-data.inset-history')
        .controller('StaffInsetHistoryController', StaffInsetHistoryController);

    StaffInsetHistoryController.$inject = ['$log', '$scope', 'insetHistory', 'Auth'];

    function StaffInsetHistoryController($log, $scope, insetHistory, Auth) {
        /* jshint validthis:true */
        var vm = this;

        // Public Interface - Variables
        $scope.currentUser = Auth.getUser();
        $scope.staffInset = insetHistory != null ? insetHistory.data : {};

    }
})();
