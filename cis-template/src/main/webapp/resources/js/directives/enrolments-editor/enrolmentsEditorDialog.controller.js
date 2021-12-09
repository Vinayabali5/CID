/**
 * This is the Enrolments Editor Dialog Controller.
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';
    angular
        .module('EnrolmentsEditorDirective')
        .controller('EnrolmentsEditorDialogController', EnrolmentsEditorDialogController);

    EnrolmentsEditorDialogController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModalInstance', 'enrolmentEntity', 'Enrolment'];

    function EnrolmentsEditorDialogController($log, $scope, $state, $rootScope, $uibModalInstance, enrolmentEntity, Enrolment) {
        /* jshint validthis:true */
        var vm = this;

        // Public Interface
        vm.enrolment = enrolmentEntity !== undefined ? enrolmentEntity : {};
        vm.save = save;
        vm.cancel = cancel;

        // Private Interface

        var onSaveFinished = function(result) {
            $scope.$emit('enrolments-updated', result);
            $uibModalInstance.close(result);
        };

        function save() {
            $log.log('EnrolmentDialogController::save called');
            if (vm.enrolment.enrolmentId) {
                //update the enrolment information
                Enrolment.save(vm.enrolment, onSaveFinished);
            }
        }

        function cancel() {
            $log.log('EnrolmentDialogController::clear called');
            $uibModalInstance.dismiss('cancel');
        }
    }
})();
