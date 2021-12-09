/**
 * This is the College Fund Payment Dialog Controller it is used to control the dialog box used to add and edit a college fund payment.
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */
(function() {
    'use strict';

    angular
        .module('DataSharingOptionDirective')
        .controller('DataSharingOptionEditorDialogController', DataSharingOptionEditorDialogController);

    DataSharingOptionEditorDialogController.$inject = ['$log', '$scope', '$uibModalInstance', '$uibModal', 'dataSharingOptionEntity', 'Student'];

    function DataSharingOptionEditorDialogController($log, $scope, $uibModalInstance, $uibModal, dataSharingOptionEntity, Student) {
        /* jshint validthis:true */
        var vm = this;

        // Public Interface
        this.dataSharingOption = dataSharingOptionEntity !== undefined ? dataSharingOptionEntity : {};

        vm.save = save;
        vm.cancel = cancel;

        // Private Interface

        var onSaveFinished = function(result) {
            $scope.$emit('dataSharingOption-saved', result);
            $uibModalInstance.close(result);
        };

        /**
         * This methods is used to save the college fund payment that is being edited in the dialog
         */
        function save() {
            $log.log('dataSharingOptionDialogController::save called');
            if (vm.dataSharingOption.id) {
                //update the DataSharingOption information
                Student.saveDataSharingOption(vm.dataSharingOption, onSaveFinished);
            }
        }

        /**
         * This method is used to cancel the edit operation and close the dialog box.
         */
        function cancel() {
            $log.log('DataSharingOptionDialogController::clear called');
            $uibModalInstance.dismiss('cancel');
        }
    }
})();
