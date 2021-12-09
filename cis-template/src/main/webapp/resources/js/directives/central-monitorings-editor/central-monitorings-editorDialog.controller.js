/**
 * This is the Year Group Editor Dialog Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';

    angular
        .module('CentralMonitoringsEditorDirective')
        .controller('CentralMonitoringsEditorDialogController', CentralMonitoringsEditorDialogController);

    CentralMonitoringsEditorDialogController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModalInstance', 'CentralMonitoring', 'centralMonitoringsEntity'];

    function CentralMonitoringsEditorDialogController($log, $scope, $state, $rootScope, $uibModalInstance, CentralMonitoring, centralMonitoringsEntity) {
        /* jshint validthis:true */
        var vm = this;
        vm.centralMonitorings = centralMonitoringsEntity !== undefined ? centralMonitoringsEntity : {};

        vm.cancel = cancel;
        vm.save = save;
        vm.add = add;

        var onSaveFinished = function(result) {
            $scope.$emit('central-monitorings-saved', result);
            $uibModalInstance.close(result);
        };

        function cancel() {
            $uibModalInstance.dismiss('cancel');
        }

        function add() {
            if (vm.centralMonitorings.id !== null) {
                CentralMonitoring.create(vm.centralMonitorings, onSaveFinished);
            }
        }

        function save() {
            if (vm.centralMonitorings.id) {
                CentralMonitoring.save(vm.centralMonitorings, onSaveFinished);
            }
        }

    }

})();
