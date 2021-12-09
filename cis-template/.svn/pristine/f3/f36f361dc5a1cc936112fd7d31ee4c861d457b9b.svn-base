/**
 * This is the Medical Notes Editor Dialog Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */


(function() {
    'use strict';

    angular
        .module('MedicalNotesEditorDirective')
        .controller('MedicalNotesEditorDialogController', MedicalNotesEditorDialogController);


    MedicalNotesEditorDialogController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModalInstance', 'Student', 'studentEntity'];

    function MedicalNotesEditorDialogController($log, $scope, $state, $rootScope, $uibModalInstance, Student, studentEntity) {
        /* jshint validthis:true */
        var vm = this;
        vm.student = studentEntity !== undefined ? studentEntity : {};
        vm.save = save;
        vm.cancel = cancel;


        var onSaveFinished = function(result) {
            $scope.$emit('student-saved', result);
            $uibModalInstance.close(result);
        };

        function save() {
            $log.log('MedicalNotesDialogController::save called');
            $log.info(vm.student);
            if (vm.student.id) {
                Student.save(vm.student, onSaveFinished);
            }
        }

        function cancel() {
            $log.log('MedicalNotesDialogController::clear called');
            $uibModalInstance.dismiss('cancel');
        }


    }


})();
