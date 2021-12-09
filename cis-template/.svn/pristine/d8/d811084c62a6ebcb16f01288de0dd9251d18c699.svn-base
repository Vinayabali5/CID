/**
 * This is the RiskLevel Editor Dialog Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */


(function() {
    'use strict';

    angular
        .module('RiskLevelsEditorDirective')
        .controller('RiskLevelsEditorDialogController', riskLevelsEditorDialogController);

    riskLevelsEditorDialogController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModalInstance', 'RiskLevel', 'riskLevelsEntity'];

    function riskLevelsEditorDialogController($log, $scope, $state, $rootScope, $uibModalInstance, RiskLevel, riskLevelsEntity) {
        /* jshint validthis:true */
        var vm = this;
        vm.riskLevels = riskLevelsEntity !== undefined ? riskLevelsEntity : {};

        vm.cancel = cancel;
        vm.save = save;
        vm.add = add;

        var onSaveFinished = function(result) {
            $uibModalInstance.close(result);
        };

        function cancel() {
            $uibModalInstance.dismiss('cancel');
        }

        function add() {
            if (vm.riskLevels.id !== null) {
                RiskLevel.create(vm.riskLevels, onSaveFinished);
            }
        }

        function save() {
            if (vm.riskLevels.id) {
                RiskLevel.save(vm.riskLevels, onSaveFinished);
            }
        }

    }


})();
