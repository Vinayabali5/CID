/**
 * This is the StudentLLDDHealthProblemCategory Table Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';

    angular
        .module('StudentLLDDHealthProblemCategoryEditorDirective')
        .controller('StudentLLDDHealthProblemCategoryEditorDialogController', StudentLLDDHealthProblemCategoryEditorDialogController);

    StudentLLDDHealthProblemCategoryEditorDialogController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModalInstance', 'StudentLLDDHealthProblemCategory', 'studentLLDDHealthProblemCategoryEntity'];

    function StudentLLDDHealthProblemCategoryEditorDialogController($log, $scope, $state, $rootScope, $uibModalInstance, StudentLLDDHealthProblemCategory, studentLLDDHealthProblemCategoryEntity) {
        var vm = this;

        // Public Interface

        vm.studentLLDDHealthProblemCategory = studentLLDDHealthProblemCategoryEntity !== undefined ? studentLLDDHealthProblemCategoryEntity : {};

        vm.save = save;
        vm.cancel = cancel;

        // Private Interface

        var onSaveFinished = function(result) {
            $rootScope.$emit('student-referral-reason-saved', result);
            $uibModalInstance.close(result);
        };

        function save() {
            $log.log('StudentLLDDHealthProblemCategoryDialogController::save called');
            $log.info(vm.studentLLDDHealthProblemCategory);
            if (vm.studentLLDDHealthProblemCategory.id) {
                StudentLLDDHealthProblemCategory.save(vm.studentLLDDHealthProblemCategory, onSaveFinished);
            } else {
                if (vm.studentLLDDHealthProblemCategory.id !== null) {
                    StudentLLDDHealthProblemCategory.create(vm.studentLLDDHealthProblemCategory, onSaveFinished);
                }
            }
        }


        function cancel() {
            $log.log('LLDDHealthProblemCategoryDialogController::clear called');
            $uibModalInstance.dismiss('cancel');
        }

    }
})();
