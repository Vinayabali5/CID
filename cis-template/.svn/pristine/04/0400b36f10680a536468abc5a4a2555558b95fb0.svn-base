/**
 * This is the Student Special LearningSupport Editor Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */



(function() {
    'use strict';

    angular
        .module('StudentLearningSupportEditorDirective')
        .controller('StudentLearningSupportEditorController', StudentLearningSupportEditorController);

    StudentLearningSupportEditorController.$inject = ['$log', '$scope', '$rootScope', '$uibModal', 'StudentLearningSupport'];

    function StudentLearningSupportEditorController($log, $scope, $rootScope, $uibModal, StudentLearningSupport) {
        $scope.dialog = {};
        $scope.message = '';

        // Public Interface

        $scope.studentId = $scope.studentId != undefined ? $scope.studentId : undefined;
        $scope.studentLearningSupport = $scope.studentLearningSupport ? $scope.studentLearningSupport : {};

        $scope.loadStudentLearningSupport = loadStudentLearningSupport;
        $scope.editStudentLearningSupport = editStudentLearningSupport;

        // Private Interface

        function loadStudentLearningSupport(studentId) {
            StudentLearningSupport.get($scope.studentId).then(function(response) {
                $log.info('II StudentLearningSupport Loaded');
                $scope.studentLearningSupport = response.data;
            });
        }

        //update the StudentLearningSupport information
        function editStudentLearningSupport(studentId) {
            $log.log('StudentLearningSupportDetailsDirectiveController::editContact called');

            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/student-learning-support-editor/views/student-learning-support-editor-dialog.html',
                controller: 'StudentLearningSupportEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                scope: $scope,
                resolve: {
                    studentLearningSupportEntity: ['Student', function(Student) {
                        return Student.learningSupport($scope.studentId).then(function(response) {
                            return response.data;
                        }, function(response) {
                            return undefined;
                        });
                    }]
                }
            });
            modalInstance.result.then().finally(function() {
                $scope.loadStudentLearningSupport($scope.studentId);
            });
        }
    }

})();
