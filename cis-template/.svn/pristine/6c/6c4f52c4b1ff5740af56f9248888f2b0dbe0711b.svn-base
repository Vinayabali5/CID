/**
 * This is the StudentUciEditorDialogController
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';

    angular
        .module('StudentUciEditorDirective')
        .controller('StudentUciEditorDialogController', StudentUciEditorDialogController);

    StudentUciEditorDialogController.$inject = ['$log', '$scope', '$state', '$uibModalInstance', '$uibModal', '$rootScope', 'studentUciEntity', 'Student'];

    function StudentUciEditorDialogController($log, $scope, $state, $uibModalInstance, $uibModal, $rootScope, studentUciEntity, Student) {
        /* jshint validthis:true */
        //Public Interface
        var vm = this;
        vm.student = studentUciEntity !== undefined ? studentUciEntity : {};
        vm.save = save;
        vm.cancel = cancel;

        var onSaveFinished = function(result) {
            $log.info('II StudentUci Saved');
            $scope.$emit('studentUci-saved', result);
            $uibModalInstance.close(result);
        };

        /**
         * This saves the studentUci and closes that dialog box
         */
        function save() {
            $log.log('StudentUciDialogController::save called');
            $log.info(vm.student);
            if (vm.student) {
                Student.save(vm.student, onSaveFinished);
            } else {
                return null;
            }
        }

        /**
         * This closes the studentUci editor dialog box without saving 
         */
        function cancel() {
            $log.log('StudentUciDialogController::clear called');
            $uibModalInstance.dismiss('cancel');
        }
    }

})();
