/**
 * This is the IdentificationViolations Editor Dialog Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */


(function() {
    'use strict';

    angular
        .module('IdentificationViolationsEditorDirective')
        .controller('IdentificationViolationsEditorDialogController', IdentificationViolationsEditorDialogController);

    IdentificationViolationsEditorDialogController.$inject = ['$rootScope', '$uibModalInstance', 'IdentificationViolation', 'identificationViolationEntity'];

    function IdentificationViolationsEditorDialogController($rootScope, $uibModalInstance, IdentificationViolation, identificationViolationEntity) {
        /* jshint validthis:true */
        var vm = this;
        vm.identificationViolation = identificationViolationEntity !== undefined ? identificationViolationEntity : {};

        vm.cancel = cancel;
        vm.save = save;

        var onSaveFinished = function(result) {
            $rootScope.$emit('identification-violation-saved', result);
            $uibModalInstance.close(result);
        };

        function cancel() {
            $uibModalInstance.dismiss('cancel');
        }

        function save() {
            if (vm.identificationViolation.id) {
                IdentificationViolation.save(vm.identificationViolation, onSaveFinished);
            } else {
                if (vm.identificationViolation.id !== null) {
                    IdentificationViolation.create(vm.identificationViolation, onSaveFinished);
                }
            }
        }

    }


})();
