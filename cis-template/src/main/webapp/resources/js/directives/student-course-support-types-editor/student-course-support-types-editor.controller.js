/**
 * This is the StudentCourseSupportTypeType Table Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';

    angular
        .module('StudentCourseSupportTypesEditorDirective')
        .controller('StudentCourseSupportTypesEditorDirectiveController', StudentCourseSupportTypesEditorDirectiveController);

    StudentCourseSupportTypesEditorDirectiveController.$inject = ['$log', '$scope', '$rootScope', '$state', '$uibModal', 'StudentCourseSupportType', 'SupportType'];

    function StudentCourseSupportTypesEditorDirectiveController($log, $scope, $rootScope, $state, $uibModal, StudentCourseSupportType, SupportType) {
        var vm = this;

        // Public Interface

        $scope.studentId = $scope.studentId ? $scope.studentId : undefined;
        $scope.studentCourseSupportTypes = $scope.studentCourseSupportTypes ? $scope.studentCourseSupportTypes : [];

        $scope.add = addStudentCourseSupportType;
        $scope.edit = editStudentCourseSupportType;
        $scope.delete = deleteStudentCourseSupportType;

        // Private Interface

        /**
         * This method is used to add a single student supportType.
         */
        function addStudentCourseSupportType() {
            if ($scope.studentId !== undefined) {
                var studentCourseSupportType = {
                    new: true,
                    studentId: $scope.studentId
                };
                openDialog(studentCourseSupportType);
            } else {
                alert("No student ID supplied");
            }
        }

        /**
         * This method is used to edit a single student studentCourseSupportType.
         *
         * @param  {StudentCourseSupportType} supportType the instance of the StudentCourseSupportType to edit
         */
        function editStudentCourseSupportType(studentCourseSupportType) {
            openDialog(studentCourseSupportType);

        }

        /**
         * This method is used to delete a single instance of a StudentCourseConcession.
         * @param  {StudentCourseConcession} concession the instance of the StudentCourseConcession to delete
         * @return {[type]}            [description]
         */
        function deleteStudentCourseSupportType(studentCourseSupportType) {
            bootbox.confirm("You are about to delete a student's Course SupportType. Are you sure you want to proceed?", function(result) {
                if (result) {
                    StudentCourseSupportType.delete(studentCourseSupportType).then(function(response) {
                        $rootScope.$emit('course-support-types-saved', null);
                    });
                }
            });
        }

        function openDialog(studentCourseSupportType) {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/student-course-support-types-editor/views/student-course-support-types-editor-dialog.html',
                controller: 'StudentCourseSupportTypesEditorDialogDirectiveController',
                controllerAs: 'ctrl',
                size: 'md',
                resolve: {
                    studentCourseSupportTypeEntity: function() {
                        return studentCourseSupportType;
                    },
                    studentSupportTypes: ['SupportType', function(SupportType) {
                        return SupportType.query();
                    }],
                    studentCourses: ['Student', function(Student) {
                        return Student.courses($scope.studentId);
                    }]
                }
            });
        }


    }


})();
