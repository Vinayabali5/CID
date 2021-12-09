/**
 * This file defines the staff data module for the CID system
 */
(function() {
    'use strict';

    angular
        .module('cid.interim-reports.staff-interim-reports')
        .controller('StaffInterimReportsController', StaffInterimReportsController);

    StaffInterimReportsController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModal', 'Auth', 'reviewList', 'StudentInterimReport', 'InterimReportsDue', 'Notification'];

    function StaffInterimReportsController($log, $scope, $state, $rootScope, $uibModal, Auth, reviewList, StudentInterimReport, InterimReportsDue, Notification) {
        /* jshint validthis:true */
        var vm = this;

        // Public Interface - Variables
        $scope.currentUser = Auth.getUser();
        $scope.staffId = $scope.currentUser.staffId;
        $scope.studentInterimReports = reviewList != null ? reviewList.data : [];

        if ($scope.studentInterimReports.length === 0) {
            Notification.info("No Interim Reports to complete");
        }
        //Event listener to refresh the list
        $scope.$on('$destroy', $rootScope.$on('my-interim-reports-due-list', function(data) {
            InterimReportsDue.myInterimReports($scope.staffId).then(function(response) {
                $scope.studentInterimReports = response.data;
            });
        }));

    }
})();
