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
        .module('StudentSafetyPlanEditorDirective')
        .controller('StudentSafetyPlanEditorController', StudentSafetyPlanEditorController);

    StudentSafetyPlanEditorController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModal', 'StudentSafetyPlan'];

    function StudentSafetyPlanEditorController($log, $scope, $state, $rootScope, $uibModal, StudentSafetyPlan) {
        /* jshint validthis:true */
        var vm = this;
        vm.dialog = {};
        $scope.studentId = $scope.studentId != undefined ? $scope.studentId : undefined;
        $scope.studentSafetyPlan = $scope.studentSafetyPlan ? $scope.studentSafetyPlan : {};

        vm.loadStudentSafetyPlan = loadStudentSafetyPlan;
        vm.editStudentSafetyPlan = editStudentSafetyPlan;

        function init() {
            $log.info('II SafetyPlan Editor Initialised');
            vm.loadStudentSafetyPlan($scope.studentId);
        }

        function loadStudentSafetyPlan(studentId) {
            $log.info('II Loading SafetyPlan Data');
            StudentSafetyPlan.get($scope.studentId).then(function(response) {
                $log.log('SafetyPlanEditorController::entryQualifications called');
                $scope.studentSafetyPlan = response.data;
            }, function(response) {
                $log.error('EE StudentSafetyPlan could not be loaded');
            });
        }

        function editStudentSafetyPlan(studentId) {
            $log.log('SafetyPlanEditorController::editContact called');

            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/student-safety-plan-editor/views/student-safety-plan-editor-dialog.html',
                controller: 'StudentSafetyPlanEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                scope: $scope,
                resolve: {
                    studentSafetyPlanEntity: ['StudentSafetyPlan', function(StudentSafetyPlan) {
                        return StudentSafetyPlan.get($scope.studentId).then(function(response) {
                            return response.data;
                        }, function(response) {
                            return undefined;
                        });
                    }]
                }
            });
            // Reload Contacts after dialog closed
            modalInstance.result.then().finally(function() {
                vm.loadStudentSafetyPlan($scope.studentId);
            });
        }

    }
})();
