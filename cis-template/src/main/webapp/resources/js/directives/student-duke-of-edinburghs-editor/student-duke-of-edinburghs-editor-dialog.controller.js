/**
 * This is the Student Duke of Edinburgh Editor Dialog Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */


(function() {
    'use strict';

    angular
        .module('StudentDukeOfEdinburghsEditorDirective')
        .controller('StudentDukeOfEdinburghsEditorDialogController', StudentDukeOfEdinburghsEditorDialogController);

    StudentDukeOfEdinburghsEditorDialogController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModalInstance', 'StudentDukeOfEdinburgh', 'studentDukeOfEdinburghEntity'];

    function StudentDukeOfEdinburghsEditorDialogController($log, $scope, $state, $rootScope, $uibModalInstance, StudentDukeOfEdinburgh, studentDukeOfEdinburghEntity) {
        /* jshint validthis:true */
        var vm = this;
        vm.studentDukeOfEdinburgh = studentDukeOfEdinburghEntity !== undefined ? studentDukeOfEdinburghEntity : {};

        vm.save = save;
        vm.cancel = cancel;

        var onSaveFinished = function(result) {
            $scope.$emit('student-duke-of-edinburghs-saved', result);
            $uibModalInstance.close(result);
        };

        function save() {
            $log.log('DukeOfEdinburghDialogController::save called');
            $log.info(vm.studentDukeOfEdinburgh);
            if (vm.studentDukeOfEdinburgh.id) {
                StudentDukeOfEdinburgh.save(vm.studentDukeOfEdinburgh, onSaveFinished);
            } else {
                if (vm.studentDukeOfEdinburgh.id !== null) {
                    StudentDukeOfEdinburgh.create(vm.studentDukeOfEdinburgh, onSaveFinished);
                }
            }
        }

        function cancel() {
            $log.log('DukeOfEdinburghDialogController::clear called');
            $uibModalInstance.dismiss('cancel');
        }
    }
})();
