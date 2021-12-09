/**
 * This is the Enrolments Editor Withdraw Dialog Controller used by EnrolmentsEditorDirective used by EnrolmentsEditorDirective
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';

    angular
        .module('EnrolmentsEditorDirective')
        .controller('EnrolmentsEditorWithdrawDialogController', enrolmentsEditorWithdrawDialogController);

    enrolmentsEditorWithdrawDialogController.$inject = ['$log', '$rootScope', '$uibModalInstance', 'enrolmentEntity', 'Enrolment'];

    function enrolmentsEditorWithdrawDialogController($log, $rootScope, $uibModalInstance, enrolmentEntity, Enrolment) {
        /* jshint validthis:true */
        var vm = this;
        vm.DEBUG = false;
        vm.withdrawDefaults = {
            completionStatusId: 3,
            outcomeId: 3
        };

        vm.enrolment = enrolmentEntity.data;
        vm.withdrawalDate = new Date();
        vm.withdrawalReason = {};
        vm.dialogTitle = "Withdraw from Course";
        vm.onSaveFinished = onSaveFinished;
        vm.save = save;
        vm.cancel = cancel;


        function onSaveFinished(result) {
            $log.log('II EnrolmentsEditorWithdrawDialogController :: save complete');
            $rootScope.$emit('enrolment-withdrawal-complete', result);
            $rootScope.$emit('enrolments-updated');
            $uibModalInstance.close(result);
        }

        function save() {
            $log.log('II EnrolmentsEditorWithdrawDialogController :: save called');
            if (!vm.withdrawalReason) {
                bootbox.alert("You must enter a withdrawal reason.");
            } else {
                bootbox.confirm('Are you sure?', function(result) {
                    if (result) {
                        vm.enrolment.endDate = vm.withdrawalDate;
                        vm.enrolment.withdrawalReasonId = vm.withdrawalReasonId;
                        vm.enrolment.completionStatusId = vm.withdrawDefaults.completionStatusId;
                        vm.enrolment.outcomeId = vm.withdrawDefaults.outcomeId;
                        Enrolment.save(vm.enrolment, onSaveFinished);
                    } else {
                        $log.log('II EnrolmentsEditorWithdrawDialogController :: save cancelled');
                    }
                });
            }
        }

        function cancel() {
            $log.log('II EnrolmentsEditorGroupChangeDialogController :: cancel called');
            $rootScope.$emit('enrolment-withdrawal-cancelled');
            $uibModalInstance.dismiss('cancel');
        }

    }

})();
