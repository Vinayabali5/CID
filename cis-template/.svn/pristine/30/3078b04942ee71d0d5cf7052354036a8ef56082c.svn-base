/**
 * This is the StatementBank Type Editor Dialog Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';

    angular.module('StatementBanksEditorDirective')
        .controller('StatementBanksEditorDialogController', StatementBanksEditorDialogController);

    StatementBanksEditorDialogController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModalInstance', 'StatementBank', 'statementBanksEntity'];

    function StatementBanksEditorDialogController($log, $scope, $state, $rootScope, $uibModalInstance, StatementBank, statementBanksEntity) {
        /* jshint validthis:true */
        var vm = this;
        vm.statementBanks = statementBanksEntity !== undefined ? statementBanksEntity : {};

        vm.cancel = cancel;
        vm.save = save;

        var onSaveFinished = function(result) {
            $scope.$emit('statementBanks-saved', result);
            $uibModalInstance.close(result);
        };

        function cancel() {
            $uibModalInstance.dismiss('cancel');
        }

        function save() {
            if (vm.statementBanks.id) {
                StatementBank.save(vm.statementBanks, onSaveFinished);
            } else {
                StatementBank.create(vm.statementBanks, onSaveFinished);
            }
        }

    }

})();
