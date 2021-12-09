/**
 * This is the College Fund Payment Dialog Controller it is used to control the
 * dialog box used to add and edit a college fund payment.
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */
(function() {
    'use strict';

    angular
        .module('StudentAlternativeUciTableDirective')
        .controller('StudentAlternativeUciEditorDialogController', StudentAlternativeUciEditorDialogController);

    StudentAlternativeUciEditorDialogController.$inject = ['$log', '$scope', '$q', '$uibModalInstance', '$uibModal', '$window', 'studentAlternativeUciEntity', 'StudentAlternativeUci'];

    function StudentAlternativeUciEditorDialogController($log, $scope, $q, $uibModalInstance, $uibModal, $window, studentAlternativeUciEntity, StudentAlternativeUci) {
        /* jshint validthis:true */
        var vm = this;

        // Public Interface
        vm.studentAlternativeUci = studentAlternativeUciEntity !== undefined ? studentAlternativeUciEntity : {};

        vm.examBoardId = vm.studentAlternativeUci.examBoardId;

        this.saveAdd = saveAdd;
        this.saveEdit = saveEdit;
        this.cancel = cancel;

        // Private Interface

        var onSaveFinished = function(result) {
            $scope.$emit('StudentAlternativeUci-saved', result);
            $uibModalInstance.close(result);
        };

        /**
         * This method is used to save the student alternative Uci that is being
         * added in the dialog
         */
        function saveAdd() {
            $log.debug('StudentAlternativeUciEditorDialogController::AddSave called');
            if (vm.studentAlternativeUci.studentId !== null) {
                $log.debug('StudentAlternativeUciEditorDialogController::create');
                StudentAlternativeUci.create(vm.studentAlternativeUci, onSaveFinished);
            }
        }

        /**
         * This methods is used to update the student alternative Uci that is being
         * edited in the dialog
         */
        function saveEdit() {
            $log.debug('StudentAlternativeUciEditorDialogController::EditSave called');
            if (vm.examBoardId !== vm.studentAlternativeUci.examBoardId) {
                $q.all([
                    StudentAlternativeUci.delete(vm.studentAlternativeUci.studentId, vm.examBoardId),
                    StudentAlternativeUci.create(vm.studentAlternativeUci)
                ]).then(function(response) {
                    // Both promises succeed
                    $log.info("II Student Alternative UCI changed successfully");
                    onSaveFinished();
                }, function(response) {
                    // A promise failed
                    $log.info("EE A problem occurred edit the student alternaitve UCI");
                    onSaveFinished();
                });
            } else {
                StudentAlternativeUci.save(vm.studentAlternativeUci, onSaveFinished);
            }
        }


        /**
         * This method is used to cancel the edit operation and close the dialog
         * box.
         */
        function cancel() {
            $log.debug('StudentAlternativeUciEditorDialogController::clear called');
            $uibModalInstance.dismiss('cancel');
        }
    }
})();
