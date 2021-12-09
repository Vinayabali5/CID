/**
 * This is the Entry Qualifications Editor Dialog Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */


(function() {
    'use strict';

    angular
        .module('StudentSafetyPlanEditorDirective')
        .controller('StudentSafetyPlanEditorDialogController', StudentSafetyPlanEditorDialogController);

    StudentSafetyPlanEditorDialogController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModalInstance', 'StudentSafetyPlan', 'studentSafetyPlanEntity'];

    function StudentSafetyPlanEditorDialogController($log, $scope, $state, $rootScope, $uibModalInstance, StudentSafetyPlan, studentSafetyPlanEntity) {
        /* jshint validthis:true */
        var vm = this;

        vm.studentSafetyPlan = studentSafetyPlanEntity !== undefined ? studentSafetyPlanEntity : {};

        vm.dateCompleted = new Date();

        vm.save = save;
        vm.cancel = cancel;

        var onSaveFinished = function(result) {
            $scope.$emit('entryQualification-saved', result);
            $uibModalInstance.close(result);
        };

        function save() {
            $log.log('SafetyPlanDialogController::save called');
            $log.info(vm.studentSafetyPlan);
            if (studentSafetyPlanEntity.studentId !== null) {
                StudentSafetyPlan.save(vm.studentSafetyPlan, onSaveFinished);
            } else {
                vm.studentSafetyPlan.studentId = $scope.studentId;
                StudentSafetyPlan.create(vm.studentSafetyPlan, onSaveFinished);
            }
        }

        function cancel() {
            $log.log('SafetyPlanDialogController::clear called');
            $uibModalInstance.dismiss('cancel');
        }
    }
})();
