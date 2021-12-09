/**
 * This is the College Fund Payment Dialog Controller it is used to control the dialog box used to add and edit a college fund payment.
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */
(function() {
    'use strict';

    angular
        .module('CollegeFundPaymentEditorDirective')
        .controller('CollegeFundPaymentEditorDialogController', CollegeFundPaymentEditorDialogController);

    CollegeFundPaymentEditorDialogController.$inject = ['$log', '$scope', '$uibModalInstance', '$uibModal', 'collegeFundPaymentEntity', 'CollegeFundPayment'];

    function CollegeFundPaymentEditorDialogController($log, $scope, $uibModalInstance, $uibModal, collegeFundPaymentEntity, CollegeFundPayment) {
        /* jshint validthis:true */
        var vm = this;

        // Public Interface
        this.collegeFundPayment = collegeFundPaymentEntity !== undefined ? collegeFundPaymentEntity : {};

        vm.save = save;
        vm.cancel = cancel;

        // Private Interface

        var onSaveFinished = function(result) {
            $scope.$emit('collegeFundPayment-saved', result);
            $uibModalInstance.close(result);
        };

        /**
         * This methods is used to save the college fund payment that is being edited in the dialog
         */
        function save() {
            $log.log('CollegeFundPaymentDialogController::save called');
            if (vm.collegeFundPayment.id) {
                //update the collegeFundPayment information
                CollegeFundPayment.save(vm.collegeFundPayment, onSaveFinished);
            } else {
                // Create New CollegeFundPayment
                if (vm.collegeFundPayment.id !== null) {
                    CollegeFundPayment.create(vm.collegeFundPayment, onSaveFinished);
                }
            }
        }

        /**
         * This method is used to cancel the edit operation and close the dialog box.
         */
        function cancel() {
            $log.log('CollegeFundPaymentDialogController::clear called');
            $uibModalInstance.dismiss('cancel');
        }
    }
})();
