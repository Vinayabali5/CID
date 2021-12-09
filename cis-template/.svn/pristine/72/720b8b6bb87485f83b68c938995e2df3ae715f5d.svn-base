/**
 * This is the StudentConcessionType Table Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';

    angular
        .module('StudentConcessionEditorDirective')
        .controller('StudentConcessionEditorDirectiveController', StudentConcessionEditorDirectiveController);

    StudentConcessionEditorDirectiveController.$inject = ['$log', '$scope', '$rootScope', '$state', '$uibModal', 'StudentCourseConcession'];

    function StudentConcessionEditorDirectiveController($log, $scope, $rootScope, $state, $uibModal, StudentCourseConcession) {
        var vm = this;

        // Public Interface

        $scope.studentId = $scope.studentId ? $scope.studentId : undefined;
        $scope.concessions = $scope.concessions ? $scope.concessions : [];

        $scope.add = addConcession;
        $scope.addAllCourses = addAllCourses;
        $scope.edit = editConcession;
        $scope.delete = deleteConcession;

        // Private Interface

        function addAllCourses() {
            if ($scope.studentId !== undefined) {
                var concession = {
                    new: true,
                    studentId: $scope.studentId
                };
                openBulkCourseConcessionDialog(concession);
            } else {
                alert("No student ID supplied");
            }
        }


        /**
         * This method is used to add a single student concession.
         */
        function addConcession() {
            if ($scope.studentId !== undefined) {
                var concession = {
                    new: true,
                    studentId: $scope.studentId
                };
                openDialog(concession);
            } else {
                alert("No student ID supplied");
            }
        }

        /**
         * This method is used to edit a single student concession.
         *
         * @param  {StudentCourseConcession} concession the instance of the StudentCourseConcession to edit
         */
        function editConcession(concession) {
            openDialog(concession);

        }

        /**
         * This method is used to delete a single instance of a StudentCourseConcession.
         * @param  {StudentCourseConcession} concession the instance of the StudentCourseConcession to delete
         * @return {[type]}            [description]
         */
        function deleteConcession(concession) {
            bootbox.confirm("You are about to delete a student's course concesssion. Are you sure you want to proceed?", function(result) {
                if (result) {
                    StudentCourseConcession.delete(concession).then(function(response) {
                        $rootScope.$emit('course-concession-saved', null);
                    });
                }
            });
        }

        function openDialog(concession) {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/student-concession-editor/views/student-concession-editor-dialog.html',
                controller: 'StudentConcessionEditorDialogDirectiveController',
                controllerAs: 'ctrl',
                size: 'md',
                resolve: {
                    concessionEntity: function() {
                        return concession;
                    },
                    studentCourses: ['Student', function(Student) {
                        return Student.courses($scope.studentId);
                    }]
                }
            });
        }

        function openBulkCourseConcessionDialog(concession) {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/student-concession-editor/views/student-bulk-course-concession-dialog.html',
                controller: 'StudentConcessionEditorDialogDirectiveController',
                controllerAs: 'ctrl',
                size: 'md',
                resolve: {
                    concessionEntity: function() {
                        return concession;
                    },
                    studentCourses: ['Student', function(Student) {
                        return Student.courses($scope.studentId);
                    }]
                }
            });
        }

    }


})();
