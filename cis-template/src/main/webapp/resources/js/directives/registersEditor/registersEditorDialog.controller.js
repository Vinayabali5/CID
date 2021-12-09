/**
 * This is the Registers Editor Dialog Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */


(function() {
    'use strict';

    angular
        .module('RegistersEditorDirective')
        .controller('RegistersEditorDialogController', RegistersEditorDialogController);

    RegistersEditorDialogController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModalInstance', 'registerEntity', 'MasterRegister'];

    function RegistersEditorDialogController($log, $scope, $state, $rootScope, $uibModalInstance, registerEntity, MasterRegister) {
        /* jshint validthis:true */
        var vm = this;

        vm.register = registerEntity !== undefined ? registerEntity : {};
        vm.save = save;
        vm.cancel = cancel;

        var onSaveFinished = function(result) {
            $scope.$emit('register-saved', result);
            $uibModalInstance.close(result);
        };

        function save() {
            $log.log('RegisterDialogController::save called');
            $log.info(vm.register);
            if (vm.register.id) {
                //update the register information
                MasterRegister.save(vm.register, onSaveFinished);
            } else {
                // Create New Register
                if (vm.register.id !== null) {
                    MasterRegister.create(vm.register, onSaveFinished);
                }
            }
        }

        function cancel() {
            $log.log('RegisterDialogController::clear called');
            $uibModalInstance.dismiss('cancel');
        }

    }

})();
