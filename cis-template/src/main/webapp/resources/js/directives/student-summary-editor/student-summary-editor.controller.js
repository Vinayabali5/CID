/**
 * This is the StudentSummaryEditorController
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';

    angular
        .module('StudentSummaryEditorDirective')
        .controller('StudentSummaryEditorController', StudentSummaryEditorController);

    StudentSummaryEditorController.$inject = ['$log', '$scope', '$rootScope', '$uibModal', 'Student'];

    function StudentSummaryEditorController($log, $scope, $rootScope, $uibModal, Student) {
        // Public Interface
        /* jshint validthis:true */
        var vm = this;
        vm.student = vm.student ? vm.student : {};
        vm.studentId = vm.studentId ? vm.studentId : undefined;

        // Public Methods
        vm.init = init;
        vm.loadStudent = loadStudent;
        vm.editStudent = editStudent;


        // Private Interface
        function init() {
            $log.log('StudentYearDetailsDirectiveController::init called');
            if (vm.student === undefined) {
                vm.loadStudent(vm.studentId);
            } else {
                vm.studentId = vm.student.studentId;
            }
        }

        function loadStudent(studentId) {
            Student.get(studentId).then(function(response) {
                $log.info('II StudentYear Loaded');
                vm.student = response.data;
                $log.info(vm.student);
            }, function(response) {
                $log.error('EE students could not be loaded');
            });

        }

        // Edit the Student information
        function editStudent(studentId) {
            $log.log('StudentSummaryDetailsDirectiveController::editSummary called');
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/student-summary-editor/views/student-summary-editor-dialog.html',
                controller: 'StudentSummaryEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    studentEntity: ['Student', function(Student) {
                        return Student.get(studentId).then(function(response) {
                            return response.data;
                        }, function(response) {
                            alert("failed to retrieve");
                        });
                    }]
                }
            });
            modalInstance.result.then().finally(function() {
                vm.loadStudent(studentId);
            });
        }


        $scope.hasData = function() {
            if ($scope.student !== null && $scope.student !== undefined) {
                return true;
            } else {
                return false;
            }
        };
    }
})();
