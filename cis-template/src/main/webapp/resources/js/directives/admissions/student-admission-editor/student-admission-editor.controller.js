(function() {
    'use strict';
    angular
        .module('StudentAdmissionEditorDirective')
        .controller('StudentAdmissionEditorController', StudentAdmissionEditorController);

    StudentAdmissionEditorController.$inject = ['$uibModal', '$log', 'Student', '$scope', '$rootScope'];

    function StudentAdmissionEditorController($uibModal, $log, Student, $scope, $rootScope) {
        /* jshint validthis:true */
        var vm = this;

        vm.studentAdmission = [];

        vm.editStudentAdmission = editStudentAdmission;

        function editStudentAdmission(studentId) {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/admissions/student-admission-editor/views/student-admission-editorDialog.html',
                controller: 'StudentAdmissionEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    studentAdmissionEntity: ['Student', function(Student) {
                        return Student.admissions(studentId).then(function(response) {
                            return response.data;
                        }, function(response) {
                            $log.error("Failed to retreive");
                        });
                    }]
                }

            });
        }

    }

})();
