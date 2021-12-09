/**
 * This is the Review data Editor Dialog Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */


(function() {
    'use strict';
    angular
        .module('cid.interim-reports.review-data')
        .controller('ReviewDataViewEditorController', ReviewDataViewEditorController);

    ReviewDataViewEditorController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModalInstance', 'InterimReportsDue', 'InterimReport', 'StudentInterimReport', 'reviewStudentList', 'reviewDataEntity', 'Auth'];

    function ReviewDataViewEditorController($log, $scope, $state, $rootScope, $uibModalInstance, InterimReportsDue, InterimReport, StudentInterimReport, reviewStudentList, reviewDataEntity, Auth) {
        /* jshint validthis:true */
        var vm = this;

        // Public Interface - Variables
        $scope.reviewStudentList = reviewStudentList !== undefined ? reviewStudentList.data : [];
        $scope.currentInterimReport = reviewDataEntity.interimReportId;
        $scope.spec = reviewDataEntity.CourseGroupSpec;
        $scope.currentUser = Auth.getUser();

        // Public Interface - Methods
        $scope.cancel = cancel;
        $scope.save = save;
        $scope.loadInterimReportsDueList = loadInterimReportsDueList;

        /**
         * This is used to refresh the list after the mass submit.
         */
        function loadInterimReportsDueList() {
            $scope.$emit('interim-reports-due-list');
        }
        /**
         * This is used to cancel/close the dialog box once the save is clicked.
         */
        function cancel() {
            $uibModalInstance.dismiss('cancel');
        }

        /**
         * This method is used to create/update the StudentInterimReport data to the API. 
         */
        function save() {
            if ($scope.reviewStudentList) {
                angular.forEach($scope.reviewStudentList, function(reviewData) {
                    var studentInterimReport = {};
                    studentInterimReport.studentId = reviewData.studentId;
                    studentInterimReport.courseId = reviewData.courseId;
                    studentInterimReport.courseGroupId = reviewData.courseGroupId;
                    studentInterimReport.keyAssessment1Id = reviewData.keyAssessment1Id;
                    studentInterimReport.keyAssessment2Id = reviewData.keyAssessment2Id;
                    studentInterimReport.keyAssessment3Id = reviewData.keyAssessment3Id;
                    studentInterimReport.motivationId = reviewData.motivationId;
                    studentInterimReport.classEthicId = reviewData.classEthicId;
                    studentInterimReport.timeManagementId = reviewData.timeManagementId;
                    studentInterimReport.late = reviewData.late;
                    studentInterimReport.authorisedAbsence = reviewData.authorisedAbsence;
                    studentInterimReport.absence = reviewData.absence;
                    studentInterimReport.totalPossible = reviewData.totalPossible;
                    if (reviewData.interimReportId === $scope.currentInterimReport) {
                        studentInterimReport.id = reviewData.studentInterimReportId;
                        studentInterimReport.interimReportId = reviewData.interimReportId;
                        StudentInterimReport.save(studentInterimReport, cancel);
                    } else {
                        studentInterimReport.interimReportId = $scope.currentInterimReport;
                        StudentInterimReport.create(studentInterimReport, cancel);
                    }
                });
                $scope.loadInterimReportsDueList();
            }
        }
    }

})();
