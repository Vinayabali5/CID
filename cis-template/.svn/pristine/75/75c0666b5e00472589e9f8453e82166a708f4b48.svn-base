/**
 * This is the Student Summary Editor Dialog Controller, it is used to handle the student summary editor dialog data and controls.
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */



(function() {
    'use strict';

    angular
        .module('StudentSummaryEditorDirective')
        .controller('StudentSummaryEditorDialogController', StudentSummaryEditorDialogController);

    StudentSummaryEditorDialogController.$inject = ['$log', '$scope', '$state', '$uibModalInstance', '$uibModal', '$rootScope', 'studentEntity', 'Student'];

    function StudentSummaryEditorDialogController($log, $scope, $state, $uibModalInstance, $uibModal, $rootScope, studentEntity, Student) {
        /* jshint validthis:true */
        var vm = this;
        vm.student = studentEntity !== undefined ? studentEntity : {};
        vm.save = save;
        vm.cancel = cancel;

        var onSaveFinished = function(result) {
            $log.info('II StudentSummary Saved');
            $scope.$emit('studentSummary-saved', result);
            $uibModalInstance.close(result);
        };

        function save() {
            $log.log('StudentSummaryDialogController::save called');
            $log.info(vm.student);
            if (vm.student.id !== undefined && vm.student.id !== null) {
                Student.save(vm.student, onSaveFinished);
            } else {
                return null;
            }
        }

        function cancel() {
            $log.log('StudentSummaryDialogController::clear called');
            $uibModalInstance.dismiss('cancel');
        }
    }

})();
