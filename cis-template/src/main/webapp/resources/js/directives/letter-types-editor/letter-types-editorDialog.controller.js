/**
 * This is the Letter Type Editor Dialog Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';

    angular.module('LetterTypesEditorDirective')
        .controller('LetterTypesEditorDialogController', LetterTypesEditorDialogController);

    LetterTypesEditorDialogController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModalInstance', 'LetterType', 'letterTypesEntity'];

    function LetterTypesEditorDialogController($log, $scope, $state, $rootScope, $uibModalInstance, LetterType, letterTypesEntity) {
        /* jshint validthis:true */
        var vm = this;
        vm.letterTypes = letterTypesEntity !== undefined ? letterTypesEntity : {};

        vm.cancel = cancel;
        vm.save = save;

        var onSaveFinished = function(result) {
            $scope.$emit('letterTypes-saved', result);
            $uibModalInstance.close(result);
        };

        function cancel() {
            $uibModalInstance.dismiss('cancel');
        }

        function save() {
            if (vm.letterTypes.id) {
                LetterType.save(vm.letterTypes, onSaveFinished);
            } else {
                if (vm.letterTypes.id !== null) {
                    LetterType.create(vm.letterTypes, onSaveFinished);
                }
            }
        }

    }

})();
