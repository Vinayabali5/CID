/**
 * This is the Periods Editor Dialog Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */


(function() {
    'use strict';

    angular
        .module('PeriodsEditorDirective')
        .controller('PeriodsEditorDialogController', PeriodsEditorDialogController);

    PeriodsEditorDialogController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModalInstance', 'Period', 'periodsEntity'];

    function PeriodsEditorDialogController($log, $scope, $state, $rootScope, $uibModalInstance, Period, periodsEntity) {
        /* jshint validthis:true */
        var vm = this;
        vm.periods = periodsEntity !== undefined ? periodsEntity : {};

        vm.cancel = cancel;
        vm.save = save;

        var options = {
            'step': 5
        };

        var onSaveFinished = function(result) {
            $scope.$emit('periods-saved', result);
            $uibModalInstance.close(result);
        };

        function cancel() {
            $log.log('PeriodsEditorDialogController::clear called');
            $uibModalInstance.dismiss('cancel');
        }

        function save() {
            if (vm.periods.id) {
                Period.save(vm.periods, onSaveFinished);
            } else {
                if (vm.periods.id !== null) {
                    Period.create(vm.periods, onSaveFinished);
                }
            }

        }

    }


})();
