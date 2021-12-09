/**
 * This is the StudentReferralReason Table Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';

    angular
        .module('StudentReferralReasonEditorDirective')
        .controller('StudentReferralReasonEditorDialogController', StudentReferralReasonEditorDialogController);

    StudentReferralReasonEditorDialogController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModalInstance', 'StudentReferralReason', 'studentReferralReasonEntity'];

    function StudentReferralReasonEditorDialogController($log, $scope, $state, $rootScope, $uibModalInstance, StudentReferralReason, studentReferralReasonEntity) {
        var vm = this;

        // Public Interface

        vm.studentReferralReason = studentReferralReasonEntity !== undefined ? studentReferralReasonEntity : {};

        vm.save = save;
        vm.cancel = cancel;

        // Private Interface

        var onSaveFinished = function(result) {
            $rootScope.$emit('student-referral-reason-saved', result);
            $uibModalInstance.close(result);
        };

        function save() {
            $log.log('StudentReferralReasonDialogController::save called');
            $log.info(vm.studentReferralReason);
            if (vm.studentReferralReason.id) {
                StudentReferralReason.save(vm.studentReferralReason, onSaveFinished);
            } else {
                if (vm.studentReferralReason.id !== null) {
                    StudentReferralReason.create(vm.studentReferralReason, onSaveFinished);
                }
            }
        }


        function cancel() {
            $log.log('EntryQualificationDialogController::clear called');
            $uibModalInstance.dismiss('cancel');
        }

    }
})();
