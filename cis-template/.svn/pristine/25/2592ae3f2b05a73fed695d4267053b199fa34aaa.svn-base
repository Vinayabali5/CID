/**
 * This is the Staff Editor Dialog Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */


(function() {
    'use strict';
    angular
        .module('StaffsEditorDirective')
        .controller('StaffsEditorDialogController', StaffsEditorDialogController);

    StaffsEditorDialogController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModalInstance', 'Staff', 'staffEntity', 'staffRoles', 'Person'];

    function StaffsEditorDialogController($log, $scope, $state, $rootScope, $uibModalInstance, Staff, staffEntity, staffRoles, Person) {
        /* jshint validthis:true */
        var vm = this;
        vm.staffs = staffEntity !== undefined ? staffEntity : {};
        vm.staffRoles = staffRoles !== undefined ? staffRoles : [];
        vm.personId = vm.staffs.personId;

        vm.cancel = cancel;
        vm.save = save;
        vm.add = add;
        vm.deleteRole = deleteRole;
        vm.loadRoles = loadRoles;

        var onSaveFinished = function(result) {
            $scope.$emit('staff-saved', result);
            $uibModalInstance.close(result);
        };

        function add() {
            if (vm.staffRoles.roleId && vm.personId) {
                var addRole = {};
                addRole.personId = vm.personId;
                addRole.roleId = vm.staffRoles.roleId;
                Person.createPersonRoles(addRole).then(function(response) {
                    vm.staffRoles = response.data;
                    vm.loadRoles(vm.personId);
                });

            }
        }

        function cancel() {
            $uibModalInstance.dismiss('cancel');
        }

        function save() {
            if (vm.staffs.id) {
                Staff.save(vm.staffs, onSaveFinished);
            } else {
                if (vm.staffs.id !== null) {
                    Staff.create(vm.staffs, onSaveFinished);
                }
            }
        }

        function loadRoles(personId) {
            $log.info('II Loading roles Data');
            Person.getRoles(personId).then(function(response) {
                $log.info('II Contacts Loaded');
                vm.staffRoles = response.data;
            }, function(response) {
                $log.error('EE Contacts could not be loaded');
            });
        }

        function deleteRole(personId, roleId) {
            $log.log('PersonRoleEditorController::deletePersonRole called');
            if (personId, roleId) {
                var msg = "Are you sure you want to delete this record?";
                if (window.confirm(msg)) {
                    Person.deletePersonRoles(personId, roleId).then(function(response) {
                        $log.info("II Request ($personId) & ($roleId) has been deleted");
                    }, function(response) {
                        alert("failed to retrieve");
                    }).finally(function() {
                        vm.loadRoles(vm.personId);
                    });
                }
            }

        }

    }


})();
