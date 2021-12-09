/**
 * This is the Student Bursary Editor Dialog Controller, it is used to handle the student bursary editor dialog controller 
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */


(function() {
    'use strict';

    angular
        .module('StudentBursaryEditorDirective')
        .controller('StudentBursaryEditorDialogController', StudentBursaryEditorDialogController);

    StudentBursaryEditorDialogController.$inject = ['$log', '$scope', '$state', '$uibModalInstance', '$uibModal', '$rootScope', 'studentBursaryEntity', 'StudentBursary'];

    function StudentBursaryEditorDialogController($log, $scope, $state, $uibModalInstance, $uibModal, $rootScope, studentBursaryEntity, StudentBursary) {
        /* jshint validthis:true */
        var vm = this;
        vm.studentBursary = studentBursaryEntity !== undefined ? studentBursaryEntity : {};
        vm.save = save;
        vm.cancel = cancel;


        var onSaveFinished = function(result) {
            $log.info('II Student Bursary Saved');
            $scope.$emit('student-bursary-saved', result);
            $uibModalInstance.close(result);
        };


        /**
         * This saves the studentBursary and closes that dialog box
         */
        function save() {
            $log.log('StudentBursaryDialogController::save called');
            $log.info(vm.studentBursary);
            if (vm.studentBursary) {
                StudentBursary.save(vm.studentBursary, onSaveFinished);
            } else {
                return null;
            }
        }


        /**
         * This closes the studentBursary editor dialog box without saving
         */
        function cancel() {
            $log.log('StudentBursaryDialogController::clear called');
            $uibModalInstance.dismiss('cancel');
        }

    }

})();
