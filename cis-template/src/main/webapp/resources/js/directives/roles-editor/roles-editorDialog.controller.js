/**
 * This is the Roles Editor Dialog Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */


(function() {
    'use strict';

    angular
        .module('RolesEditorDirective')
        .controller('RolesEditorDialogController', RolesEditorDialogController);

    RolesEditorDialogController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModalInstance', 'Role', 'roleEntity'];

    function RolesEditorDialogController($log, $scope, $state, $rootScope, $uibModalInstance, Role, roleEntity) {
        /* jshint validthis:true */
        var vm = this;
        vm.role = roleEntity;

        vm.cancel = cancel;
        vm.save = save;


        var onSaveFinished = function(result) {
            $scope.$emit('role-saved', result);
            $uibModalInstance.close(result);
        };

        function cancel() {
            $log.log('RolesEditorDialogController::clear called');
            $uibModalInstance.dismiss('cancel');
        }

        function save() {
            if (vm.role.id) {
                Role.save(vm.role, onSaveFinished);
            } else {
                if (vm.role.id !== null) {
                    Role.create(vm.role, onSaveFinished);
                }
            }
        }

    }


})();
