/**
 * This is the StudentYearEditorController, it is used to handle the student year editor dialog data and controls.
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';

    angular
        .module('StudentYearEditorDirective')
        .controller('StudentYearEditorController', StudentYearEditorController);

    StudentYearEditorController.$inject = ['$log', '$scope', '$rootScope', '$uibModal', 'Student'];

    function StudentYearEditorController($log, $scope, $rootScope, $uibModal, Student) {
        //Public Interface
        /* jshint validthis:true */
        var vm = this;
        vm.studentYear = vm.studentYear ? vm.studentYear : {};
        vm.studentId = vm.studentId ? vm.studentId : undefined;
        vm.yearId = vm.yearId ? vm.yearId : undefined;

        //Operations
        vm.init = init;
        vm.loadStudentYear = loadStudentYear;
        vm.editStudentYear = editStudentYear;


        // Private Interface
        $scope.hasData = function() {
            if ($scope.studentYear && $scope.studentYear !== undefined) {
                return true;
            } else {
                return false;
            }
        };

        function init() {
            $log.log('StudentYearDetailsDirectiveController::init called');
            if (vm.studentYear === undefined) {
                vm.loadStudentYear(vm.studentId, vm.yearId);
            } else {
                vm.studentId = vm.studentYear.studentId;
                vm.yearId = vm.studentYear.yearId;
            }
        }

        function loadStudentYear(studentId, yearId) {
            Student.studentYears(studentId, yearId).then(function(response) {
                $log.info('II StudentYear Loaded');
                vm.studentYear = response.data;
                vm.studentId = vm.studentYear.studentId;
                vm.yearId = vm.studentYear.yearId;
                $log.info(vm.studentYear);
            }, function(response) {
                $log.error('EE students could not be loaded');
            });
        }

        function editStudentYear(studentId, yearId) {
            $log.log('StudentYearDetailsDirectiveController::editContact called');
            vm.yearId = vm.studentYear.yearId;
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/student-year-editor/views/student-year-editor-dialog.html',
                controller: 'StudentYearEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    studentYearEntity: ['Student', function(Student) {
                        return Student.studentYears(vm.studentId, vm.yearId).then(function(response) {
                            return response.data;
                        }, function(response) {
                            alert("failed to retrieve");
                        });
                    }]
                }
            });
            modalInstance.result.then().finally(function() {
                vm.loadStudentYear(vm.studentId, vm.yearId);
            });
        }

    }

})();
