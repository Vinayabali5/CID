/**
 * This is the StudentYearEditorDialogController
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';

    angular
        .module('StudentYearEditorDirective')
        .controller('StudentYearEditorDialogController', StudentYearEditorDialogController);

    StudentYearEditorDialogController.$inject = ['$log', '$scope', '$state', '$uibModalInstance', '$uibModal', '$rootScope', 'studentYearEntity', 'Student'];

    function StudentYearEditorDialogController($log, $scope, $state, $uibModalInstance, $uibModal, $rootScope, studentYearEntity, Student) {
        /* jshint validthis:true */
        //Public Interface
        var vm = this;
        vm.studentYear = studentYearEntity !== undefined ? studentYearEntity : {};
        vm.save = save;
        vm.cancel = cancel;

        var onSaveFinished = function(result) {
            $log.info('II StudentYear Saved');
            $scope.$emit('studentYear-saved', result);
            $uibModalInstance.close(result);
        };

        /**
         * This saves the studentYear and closes that dialog box
         */
        function save() {
            $log.log('StudentYearDialogController::save called');
            $log.info(vm.studentYear);
            if (vm.studentYear.studentId, vm.studentYear.yearId, vm.studentYear) {
                Student.studentYears(vm.studentYear.studentId, vm.studentYear.yearId, vm.studentYear, onSaveFinished);
            } else {
                return null;
            }
        }

        /**
         * This closes the studentYear editor dialog box without saving 
         */
        function cancel() {
            $log.log('StudentYearDialogController::clear called');
            $uibModalInstance.dismiss('cancel');
        }
    }

})();
