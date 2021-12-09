/**
 * This is the Pastoral Monitor Editor Dialog Controller 
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */


(function() {
    'use strict';
    angular
        .module('PastoralMonitorEditorDirective')
        .controller('PastoralMonitorEditorDialogController', PastoralMonitorEditorDialogController);

    PastoralMonitorEditorDialogController.$inject = ['$log', '$scope', '$state', '$uibModalInstance', '$uibModal', '$rootScope', 'pastoralMonitorEntity', 'PastoralMonitor'];

    function PastoralMonitorEditorDialogController($log, $scope, $state, $uibModalInstance, $uibModal, $rootScope, pastoralMonitorEntity, PastoralMonitor) {
        /* jshint validthis:true */
        var vm = this;

        vm.pastoralMonitor = pastoralMonitorEntity !== undefined ? pastoralMonitorEntity : {};
        vm.save = save;
        vm.cancel = cancel;


        var onSaveFinished = function(result) {
            $log.info('II PastoralMonitor Saved');
            $scope.$emit('pastoralMonitor-saved', result);
            $uibModalInstance.close(result);
        };


        /**
         * This saves the pastoralMonitor and closes that dialog box
         */
        function save() {
            $log.log('PastoralMonitorDialogController::save called');
            $log.info(vm.pastoralMonitor);
            if (vm.pastoralMonitor) {
                PastoralMonitor.save(vm.pastoralMonitor, onSaveFinished);
            } else {
                return null;
            }

        }

        /**
         * This closes the pastoralMonitor editor dialog box without saving 
         */
        function cancel() {
            $log.log('PastoralMonitorDialogController::clear called');
            $uibModalInstance.dismiss('cancel');
        }
    }
})();
