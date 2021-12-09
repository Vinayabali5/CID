/**
 * This is the Entry Qualifications Editor Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */


(function() {
    'use strict';

    angular
        .module('StudentRiskAssessmentEditorDirective')
        .controller('StudentRiskAssessmentEditorController', StudentRiskAssessmentEditorController);

    StudentRiskAssessmentEditorController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModal', 'StudentRiskAssessment'];

    function StudentRiskAssessmentEditorController($log, $scope, $state, $rootScope, $uibModal, StudentRiskAssessment) {
        /* jshint validthis:true */
        var vm = this;

        $scope.studentId = $scope.studentId != undefined ? $scope.studentId : undefined;
        $scope.studentRiskAssessment = $scope.studentRiskAssessment ? $scope.studentRiskAssessment : {};

        $scope.loadStudentRiskAssessment = loadStudentRiskAssessment;
        $scope.editStudentRiskAssessment = editStudentRiskAssessment;

        function init() {
            $log.info('II RiskAssessment Editor Initialised');
            $scope.loadStudentRiskAssessment($scope.studentId);
        }

        function loadStudentRiskAssessment(studentId) {
            $log.info('II Loading RiskAssessment Data');
            StudentRiskAssessment.get($scope.studentId).then(function(response) {
                $log.log('RiskAssessmentEditorController::loadStudentRiskAssessment called');
                $scope.studentRiskAssessment = response.data;
            }, function(response) {
                $log.error('EE StudentRiskAssessment could not be loaded');
            });
        }

        function editStudentRiskAssessment(studentId) {
            $log.log('RiskAssessmentEditorController::editContact called');

            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/student-risk-assessment-editor/views/student-risk-assessment-editor-dialog.html',
                controller: 'StudentRiskAssessmentEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                scope: $scope,
                resolve: {
                    studentRiskAssessmentEntity: ['StudentRiskAssessment', function(StudentRiskAssessment) {
                        return StudentRiskAssessment.get($scope.studentId).then(function(response) {
                            return response.data;
                        }, function(response) {
                            return undefined;
                        });
                    }]
                }
            });
            // Reload Contacts after dialog closed
            modalInstance.result.then().finally(function() {
                $scope.loadStudentRiskAssessment($scope.studentId);
            });
        }

    }
})();
