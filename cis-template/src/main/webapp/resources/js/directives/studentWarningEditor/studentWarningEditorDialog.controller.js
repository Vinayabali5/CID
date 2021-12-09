/**
 * This is the Student Special Warning Editor Dialog Controller 
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */


(function() {
    'use strict';
    angular
        .module('StudentWarningEditorDirective')
        .controller('StudentWarningEditorDialogController', StudentWarningEditorDialogController);

    StudentWarningEditorDialogController.$inject = ['$log', '$scope', '$state', '$uibModalInstance', '$uibModal', '$rootScope', 'studentWarningEntity', 'StudentWarning'];

    function StudentWarningEditorDialogController($log, $scope, $state, $uibModalInstance, $uibModal, $rootScope, studentWarningEntity, StudentWarning) {
        /* jshint validthis:true */
        var vm = this;

        vm.studentWarning = studentWarningEntity !== undefined ? studentWarningEntity : {};
        vm.save = save;
        vm.cancel = cancel;


        var onSaveFinished = function(result) {
            $log.info('II StudentWarning Saved');
            $scope.$emit('studentWarning-saved', result);
            $uibModalInstance.close(result);
        };

        /**
         * This saves the studentWarning and closes that dialog box
         */
        function save() {
            $log.log('StudentWarningDialogController::save called');
            $log.info(vm.studentWarning);
            if (vm.studentWarning) {
                StudentWarning.save(vm.studentWarning, onSaveFinished);
            } else {
                return null;
            }

        }

        /**
         * This closes the studentWarning editor dialog box without saving 
         */
        function cancel() {
            $log.log('StudentWarningDialogController::clear called');
            $uibModalInstance.dismiss('cancel');
        }
    }
})();
