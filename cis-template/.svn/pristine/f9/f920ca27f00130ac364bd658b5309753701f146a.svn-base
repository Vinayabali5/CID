/**
 * This file defines the staff data module for the CID system
 */
(function() {
    'use strict';

    angular
        .module('cid.interim-reports.review-data')
        .controller('InterimReportReviewDataController', InterimReportReviewDataController);

    InterimReportReviewDataController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModal', 'reviewList', 'StudentInterimReport', 'InterimReportsDue'];

    function InterimReportReviewDataController($log, $scope, $state, $rootScope, $uibModal, reviewList, StudentInterimReport, InterimReportsDue) {
        /* jshint validthis:true */
        var vm = this;

        // Public Interface - Variables
        $scope.reviewList = reviewList != null ? reviewList.data : [];

        // Public Interface - Methods
        $scope.editReviewData = editReviewData;

        //Event listener to refresh the list
        $scope.$on('$destroy', $rootScope.$on('interim-reports-due-list', function(data) {
            InterimReportsDue.query().then(function(response) {
                $scope.reviewList = response.data;
            });
        }));
        /**
         * This function is used to open the Review Dialog box and load all the associated fields
         */
        function editReviewData(reviewData) {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/modules/interim-reports/review-data/views/review-data-view.html',
                controller: 'ReviewDataViewEditorController',
                controllerAs: 'ctrl',
                size: 'xl',
                resolve: {
                    reviewStudentList: ['InterimReportsDue', function(InterimReportsDue) {
                        return InterimReportsDue.getByCourseGroupId(reviewData.courseGroupId);
                    }],
                    reviewDataEntity: reviewData
                },
            });
        }
    }
})();
