/**
 * 
 */

(function() {
    'use strict';

    angular
        .module('cid.exams.base-data-viewer')
        .controller('ExamBaseDataOptionEditDialogController', examBaseDataOptionEditDialogController);

    examBaseDataOptionEditDialogController.$inject = ['$log', '$scope', '$uibModalInstance', 'entity', 'Option'];

    function examBaseDataOptionEditDialogController($log, $scope, $uibModalInstance, entity, Option) {
        /*jshint validthis: true */
        var vm = this;

        vm.cancel = cancel;
        vm.save = save;
        vm.option = entity.option !== undefined ? entity.option : {};
        vm.option.syllabus = entity.syllabus;

        var onSaveFinished = function(result) {
            $scope.$emit('exam-option-saved', result);
            $uibModalInstance.close(result);
        };

        function cancel() {
            $log.log('ExamBaseDataOptionEditDialogController::clear called');
            $scope.$emit('exam-option-saved');
            $uibModalInstance.dismiss('cancel');
        }

        function save() {
            if (vm.option.examOptionId) {
                Option.save(vm.option, onSaveFinished);
            } else {
                Option.create(vm.option, onSaveFinished);
            }
        }
    }
})();
