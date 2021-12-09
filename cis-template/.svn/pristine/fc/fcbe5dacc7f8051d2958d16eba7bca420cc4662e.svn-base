/**
 * This controller is used by the AddressEditorDirective.
 *
 * Applied Style: [Y001, Y002, Y010, Y022, Y023, Y024, Y032, Y033, Y034] *
 *
 */

(function() {
    'use strict';

    angular
        .module('AddressEditorDirective')
        .controller('AddressEditorDialogController', AddressEditorDialogController);

    AddressEditorDialogController.$inject = ['$log', '$scope', '$filter', '$state', '$uibModalInstance', '$uibModal', '$rootScope', 'addressEntity', 'Address', 'PostcodeLookup'];

    function AddressEditorDialogController($log, $scope, $filter, $state, $uibModalInstance, $uibModal, $rootScope, addressEntity, Address, PostcodeLookup) {
        /* jshint validthis:true */
        var vm = this;

        // Public Interface
        vm.address = addressEntity !== undefined ? addressEntity : {};
        vm.postcode = [];
        vm.onSaveFinished = onSaveFinished;
        vm.save = save;
        vm.cancel = cancel;

        // Private Interface
        function onSaveFinished(result) {
            $scope.$emit('address-saved', result);
            $uibModalInstance.close(result);
        }

        /**
         * This saves the address and closes that dialog box
         */
        function save() {
            $log.log('AddressDialogController::save called');
            $log.info(vm.address);
            if (vm.address.id) {
                // update the contact information
                Address.save(vm.address, onSaveFinished);
            } else {
                // Create New Address
                Address.create(vm.address, onSaveFinished);
            }

        }

        /**
         * This closes the address editor dialog box without saving
         */
        function cancel() {
            $log.log('AddressDialogController::clear called');
            $uibModalInstance.dismiss('cancel');
        }

    }
})();
