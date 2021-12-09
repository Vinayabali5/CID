/**
 * 
 */

(function() {
    angular
        .module('cid.exams.base-data-viewer')
        .controller('ExamBaseDataSyllabusEditDialogController', examBaseDataSyllabusEditDialogController);

    examBaseDataSyllabusEditDialogController.$inject = ['$log', '$scope', '$uibModalInstance', 'entity', 'Syllabus'];

    function examBaseDataSyllabusEditDialogController($log, $scope, $uibModalInstance, entity, Syllabus) {
        var vm = this;

        vm.cancel = cancel;
        vm.save = save;
        vm.syllabus = entity.syllabus !== undefined ? entity.syllabus : {};

        var onSaveFinished = function(result) {
            $scope.$emit('exam-syllabus-saved', result);
            $uibModalInstance.close(result);
        };

        function cancel() {
            $log.log('ExamBaseDataSyllabusEditDialogController::clear called');
            $uibModalInstance.dismiss('cancel');
        }

        function save() {
            if (vm.syllabus.id) {
                Syllabus.save(vm.syllabus, onSaveFinished);
            } else {
                Syllabus.create(vm.syllabus, onSaveFinished);
            }
        }
    }
})();
