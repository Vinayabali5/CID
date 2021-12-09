/**
 * The ContactsEditorController is used to define the ContactsEditorDirective main controller.
 *
 * Applied Styles: [Y001, Y002, Y010, Y020, Y022, Y023, Y024, Y031, Y032, Y033, Y034, Y035, Y036, Y090, Y091]
 *
 * @type Controller
 */
(function() {
    'use strict';

    angular
        .module('ContactsEditorDirective')
        .controller('ContactsEditorController', ContactsEditorController);

    ContactsEditorController.$inject = ['$log', '$uibModal', 'Person', 'Contact'];

    function ContactsEditorController($log, $uibModal, Person, Contact) {
        /* jshint validthis:true */
        var vm = this;

        // Public Interface
        vm.personId = vm.personId ? vm.personId : undefined;
        vm.contacts = vm.contacts ? vm.contacts : [];

        vm.loadContacts = loadContacts;
        vm.editContact = editContact;
        vm.addContact = addContact;
        vm.deleteContact = deleteContact;

        // Private Interface

        function loadContacts(personId) {
            $log.info('II Loading Contacts Data');
            Person.contacts(personId).then(function(response) {
                $log.info('II Contacts Loaded');
                vm.contacts = response.data;
            }, function(response) {
                $log.error('EE Contacts could not be loaded');
            });
        }

        // Create New Contact
        function addContact(personId) {
            $log.log('ContactsEditorController::addContact called');
            if (personId) {
                var modalInstance = $uibModal.open({
                    templateUrl: 'js/directives/contacts-editor/views/contactEditorDialog.html',
                    controller: 'ContactsEditorDialogController',
                    controllerAs: 'ctrl',
                    size: 'lg',
                    backdrop: 'static',
                    keyboard: false,
                    resolve: {
                        contactEntity: function() {
                            var contact = {};
                            contact.personId = personId;
                            contact.contactable = false;
                            contact.preferred = false;
                            contact.alternativeAddress = false;
                            return contact;
                        }
                    }
                });
                // Reload Contacts after dialog closed
                modalInstance.result.then().finally(function() {
                    vm.loadContacts(vm.personId);
                });
            } else {
                $log.error('EE No Person ID Specified');
            }
        }

        //update the contact information
        function editContact(contactId) {
            $log.log('ContactsEditorController::editContact called');

            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/contacts-editor/views/contactEditorDialog.html',
                controller: 'ContactsEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                backdrop: 'static',
                keyboard: false,
                resolve: {
                    contactEntity: function(Contact) {
                        return Contact.get(contactId).then(function(response) {
                            return response.data;
                        }, function(response) {
                            alert("failed to retrieve");
                        });
                    }
                }
            });
            // Reload Contacts after dialog closed
            modalInstance.result.then().finally(function() {
                vm.loadContacts(vm.personId);
            });
        }

        // Delete the contact
        function deleteContact(contactId) {
            $log.log('ContactsEditorController::deleteContact called');
            if (contactId) {
                var msg = "Are you sure you want to delete this contact?";
                if (window.confirm(msg)) {
                    Contact.delete(contactId).then(function(response) {
                        $log.info("II Contact ($contactId) has been deleted");
                    }, function(response) {
                        $log.info("EE A problem occurred trying to delete contact ($contactId)");
                    }).finally(function() {
                        vm.loadContacts(vm.personId);
                    });
                }
            }
        }
    }
})();
