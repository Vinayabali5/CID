/**
 * This is the StudentOptions Editor Directive definition.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y023, Y024, Y070, Y072, Y074]*
 *
 *  @type Controller
 *
 *
 *   */
(function() {
    'use strict';
    angular
        .module('StudentOptionEditorTableDirective')
        .controller('StudentOptionEditorTableEditDialogController', StudentOptionEditorTableEditDialogController);

    StudentOptionEditorTableEditDialogController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModalInstance', '$uibModal', 'studentOptionEntryEntity', 'StudentOptionEntry'];

    function StudentOptionEditorTableEditDialogController($log, $scope, $state, $rootScope, $uibModalInstance, $uibModal, studentOptionEntryEntity, StudentOptionEntry) {
        /* jshint validthis:true */
        var vm = this;

        this.studentOptionEntry = studentOptionEntryEntity !== undefined ? studentOptionEntryEntity : {};

        var onSaveFinished = function(result) {
            $scope.$emit('option-entires-updated', result);
            $uibModalInstance.close(result);
        };


        this.save = function() {
            $log.debug('StudentOptionEntryDialogController::save called');
            $log.info(vm.studentOptionEntry);
            if (vm.studentOptionEntry.studentId, vm.studentOptionEntry.examOptionId, vm.studentOptionEntry) {
                //update the studentOptionEntry information
                StudentOptionEntry.save(vm.studentOptionEntry.studentId, vm.studentOptionEntry.examOptionId, vm.studentOptionEntry, onSaveFinished);
            } else {
                // Create New StudentOptionEntry
                StudentOptionEntry.create(vm.studentOptionEntry, onSaveFinished);
            }
        };

        this.cancel = function() {
            $log.debug('StudentOptionEntryDialogController::clear called');
            $uibModalInstance.dismiss('cancel');
        };
    }

})();
