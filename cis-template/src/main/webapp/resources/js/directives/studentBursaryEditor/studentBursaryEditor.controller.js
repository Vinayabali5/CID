/**
 * This is the Student Bursary Editor Controller, it is used to handle the student bursary editor controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */



(function() {
    'use strict';

    angular
        .module('StudentBursaryEditorDirective')
        .controller('StudentBursaryEditorController', StudentBursaryEditorController);

    StudentBursaryEditorController.$inject = ['$log', '$scope', '$rootScope', '$uibModal', 'Student'];

    function StudentBursaryEditorController($log, $scope, $rootScope, $uibModal, Student) {
        /* jshint validthis:true */
        var vm = this;
        vm.dialog = {};
        vm.message = '';
        vm.studentBursary = vm.studentBursary ? vm.studentBursary : undefined;

        //Operations
        vm.init = init;
        vm.loadStudentBursary = loadStudentBursary;
        vm.editStudentBursary = editStudentBursary;
        vm.hasData = hasData;

        //Private Interface
        function init() {
            $log.log('StudentBursaryDetailsDirectiveController::init called');
            this.loadStudentBursary(vm.studentBursary.studentId);
        }

        function loadStudentBursary(id) {
            Student.bursary(id).then(function(response) {
                $log.info('II StudentBursary Loaded');
                vm.studentBursary = response.data;
            });
        }

        function editStudentBursary(id) {
            $log.log('StudentBursaryDetailsDirectiveController::editContact called');
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/studentBursaryEditor/views/studentBursaryEditorDialog.html',
                controller: 'StudentBursaryEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    studentBursaryEntity: ['Student', function(Student) {
                        return Student.bursary(id).then(function(response) {
                            return response.data;
                        }, function(response) {
                            alert("failed to retrieve");
                        });
                    }]
                }
            });
            modalInstance.result.then().finally(function() {
                vm.loadStudentBursary(vm.studentBursary.studentId);
            });
        }

        function hasData() {
            if (vm.studentBursary && vm.studentBursary !== undefined) {
                return true;
            } else {
                return false;
            }
        }
    }

})();
