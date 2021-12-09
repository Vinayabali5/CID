(function() {
    'use strict';

    angular
        .module('StudentAdmissionEditorDirective')
        .controller('StudentAdmissionEditorDialogController', StudentAdmissionEditorDialogController);

    StudentAdmissionEditorDialogController.$inject = ['studentAdmissionEntity', 'Student', '$uibModalInstance', '$scope'];

    function StudentAdmissionEditorDialogController(studentAdmissionEntity, Student, $uibModalInstance, $scope) {
        /* jshint validthis:true */
        var vm = this;

        vm.studentAdmission = studentAdmissionEntity !== undefined ? studentAdmissionEntity : {};

        vm.save = save;
        vm.cancel = cancel;

        var options = {
            'step': 5
        };

        var onSaveFinished = function(result) {
            $scope.$emit('student-admission-updated', result);
            $uibModalInstance.close(result);
        };

        function save() {
            Student.saveAdmission(vm.studentAdmission, onSaveFinished);
        }

        function cancel() {
            $uibModalInstance.dismiss('cancel');
        }


    }


})();
