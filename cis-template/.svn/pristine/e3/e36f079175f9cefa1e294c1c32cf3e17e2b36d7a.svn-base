/**
 * This is the Request Dialog Controller it is used to control the dialog box used to add and edit a request.
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */
(function() {
    'use strict';

    angular
        .module('RequestEditorDirective')
        .controller('RequestEditorDialogController', RequestEditorDialogController);

    RequestEditorDialogController.$inject = ['$log', '$scope', '$uibModalInstance', '$uibModal', 'requestEntity', 'Request'];

    function RequestEditorDialogController($log, $scope, $uibModalInstance, $uibModal, requestEntity, Request) {
        /* jshint validthis:true */
        var vm = this;

        // Public Interface
        this.request = requestEntity !== undefined ? requestEntity : {};

        vm.save = save;
        vm.cancel = cancel;

        // Private Interface

        var onSaveFinished = function(result) {
            $scope.$emit('request-saved', result);
            $uibModalInstance.close(result);
        };

        /**
         * This methods is used to save the college fund payment that is being edited in the dialog
         */
        function save() {
            $log.log('RequestDialogController::save called');
            if (vm.request.id) {
                //update the request information
                Request.save(vm.request, onSaveFinished);
            } else {
                // Create New Request
                if (vm.request.id !== null) {
                    Request.create(vm.request, onSaveFinished);
                }
            }
        }

        /**
         * This method is used to cancel the edit operation and close the dialog box.
         */
        function cancel() {
            $log.log('RequestDialogController::clear called');
            $uibModalInstance.dismiss('cancel');
        }
    }
})();
