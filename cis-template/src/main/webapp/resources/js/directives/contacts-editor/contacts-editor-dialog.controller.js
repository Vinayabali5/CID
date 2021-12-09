/**
 * This is the Contacts Editor Dialog Controller it is used to control the dialog box used to edit a contact.
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */
(function() {
    'use strict';

    angular
        .module('ContactsEditorDirective')
        .controller('ContactsEditorDialogController', ContactsEditorDialogController);

    ContactsEditorDialogController.$inject = ['$log', '$scope', '$uibModalInstance', '$uibModal', 'contactEntity', 'Contact'];

    function ContactsEditorDialogController($log, $scope, $uibModalInstance, $uibModal, contactEntity, Contact) {
        /* jshint validthis:true */
        var vm = this;

        //Public Interface
        vm.contact = contactEntity !== undefined ? contactEntity : {};
        vm.personId = vm.contact ? vm.contact : undefined;

        vm.save = save;
        vm.cancel = cancel;
        vm.addAddress = addAddress;
        vm.deleteAddress = deleteAddress;

        // Private interface

        var onSaveFinished = function(result) {
            $scope.$emit('contact-saved', result);
            $uibModalInstance.close(result);
        };

        function save() {
            $log.log('ContactDialogController::save called');
            $log.info(vm.contact);
            if (vm.contact.id) {
                //update the contact information
                Contact.save(vm.contact, onSaveFinished);
            } else {
                // Create New Contact
                if (vm.contact.id !== null) {
                    Contact.create(vm.contact, onSaveFinished);
                }
            }
        }

        function cancel() {
            $log.log('ContactDialogController::clear called');
            $uibModalInstance.dismiss('cancel');
        }

        function addAddress(personId) {
            $log.log('AddressEditorDirectiveController::addAddress called');
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/address-editor/views/addressEditorDialog.html',
                controller: 'AddressEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                backdrop: 'static',
                keyboard: false,
                resolve: {
                    addressEntity: function() {
                        var address = {};
                        return address;
                    }
                }
            });
            modalInstance.result.then(function(response) {
                $log.info(response);
                vm.contact.contact.addressId = response.id;
                vm.contact.contact.address = response;
            });
        }

        function deleteAddress() {
            $log.log('AddressEditorDirectiveController::deleteAddress called');
            if (vm.contact.id) {
                var msg = "Are you sure you want to delete this Address?";
                if (window.confirm(msg)) {
                    Contact.deleteAddress(vm.contact, onSaveFinished);
                }
            }
        }
    }
})();
