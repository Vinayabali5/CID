(function() {
    'use strict';

    angular
        .module('dialogs-edit-interim-reports-due')
        .controller('EditInterimReportsDueDirectiveController', EditInterimReportsDueDirectiveController);

    EditInterimReportsDueDirectiveController.$inject = ['Logger', '$scope', '$uibModalInstance', 'InterimReportsDue', 'StudentInterimReport', 'studentInterimReportList', 'studentInterimReportEntity', 'Auth'];

    function EditInterimReportsDueDirectiveController(Logger, $scope, $uibModalInstance, InterimReportsDue, StudentInterimReport, studentInterimReportList, studentInterimReportEntity, Auth) {
        var vm = this;

        // Public Interface - Variables
        $scope.studentInterimReportList = studentInterimReportList !== undefined ? studentInterimReportList.data : [];
        $scope.currentInterimReport = studentInterimReportEntity.interimReportId;
        $scope.spec = studentInterimReportEntity.CourseGroupSpec;
        $scope.currentUser = Auth.getUser();

        // Public Interface - Methods
        $scope.cancel = cancel;
        $scope.save = save;
        $scope.loadMyInterimReportsDueList = loadMyInterimReportsDueList;

        /**
         * This is used to refresh the list after the mass submit.
         */
        function loadMyInterimReportsDueList() {
            $scope.$emit('my-interim-reports-due-list');
        }
        /**
         * This is used to cancel/close the dialog box once the save is clicked.
         */
        function cancel() {
            $uibModalInstance.dismiss('cancel');
        }

        function closeDialog() {
            $uibModalInstance.close();
        }

        /**
         * This method is used to create/update the StudentInterimReport data to the API. 
         */
        function save() {
            if ($scope.studentInterimReportList) {
                angular.forEach($scope.studentInterimReportList, function(reviewData) {
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
                        StudentInterimReport.save(studentInterimReport, closeDialog);
                    } else {
                        studentInterimReport.interimReportId = $scope.currentInterimReport;
                        StudentInterimReport.create(studentInterimReport, closeDialog);
                    }
                });
                $scope.loadMyInterimReportsDueList();
            }
        }
    }


}());
