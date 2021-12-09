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
        .module('PunctualityMonitoringsEditorDirective')
        .controller('PunctualityMonitoringsEditorDialogController', PunctualityMonitoringsEditorDialogController);

    PunctualityMonitoringsEditorDialogController.$inject = ['$log', '$scope', '$state',
        '$rootScope', '$uibModalInstance', 'PunctualityMonitoring', 'punctualityMonitoringsEntity'
    ];

    function PunctualityMonitoringsEditorDialogController($log, $scope, $state, $rootScope,
        $uibModalInstance, PunctualityMonitoring, punctualityMonitoringsEntity) {
        /* jshint validthis:true */
        var vm = this;
        vm.punctualityMonitorings = punctualityMonitoringsEntity !== undefined ? punctualityMonitoringsEntity : {};

        vm.cancel = cancel;
        vm.save = save;
        vm.add = add;

        var onSaveFinished = function(result) {
            $scope.$emit('punctuality-monitorings-saved', result);
            $uibModalInstance.close(result);
        };

        function cancel() {
            $uibModalInstance.dismiss('cancel');
        }

        function add() {
            if (vm.punctualityMonitorings.id !== null) {
                PunctualityMonitoring.create(vm.punctualityMonitorings, onSaveFinished);
            }
        }

        function save() {
            if (vm.punctualityMonitorings.id) {
                PunctualityMonitoring.save(vm.punctualityMonitorings, onSaveFinished);
            }

        }

    }

})();
