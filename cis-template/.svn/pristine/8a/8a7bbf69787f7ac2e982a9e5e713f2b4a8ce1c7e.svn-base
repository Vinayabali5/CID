/**
 * This is the StatementBank Type Editor Dialog Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';

    angular.module('StatementBankTypesEditorDirective')
        .controller('StatementBankTypesEditorDialogController', StatementBankTypesEditorDialogController);

    StatementBankTypesEditorDialogController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModalInstance', 'StatementBankType', 'statementBankTypesEntity'];

    function StatementBankTypesEditorDialogController($log, $scope, $state, $rootScope, $uibModalInstance, StatementBankType, statementBankTypesEntity) {
        /* jshint validthis:true */
        var vm = this;
        vm.statementBankTypes = statementBankTypesEntity !== undefined ? statementBankTypesEntity : {};

        vm.cancel = cancel;
        vm.save = save;
        vm.add = add;

        var onSaveFinished = function(result) {
            $scope.$emit('statementBankTypes-saved', result);
            $uibModalInstance.close(result);
        };

        function cancel() {
            $uibModalInstance.dismiss('cancel');
        }

        function save() {
            if (vm.statementBankTypes.id) {
                StatementBankType.save(vm.statementBankTypes, onSaveFinished);
            }
        }

        function add() {
            if (vm.statementBankTypes) {
                StatementBankType.create(vm.statementBankTypes, onSaveFinished);
            }
        }
    }

})();
