/**
 * This is the StudentUciEditorController, it is used to handle the student year editor dialog data and controls.
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';

    angular
        .module('StudentUciEditorDirective')
        .controller('StudentUciEditorController', StudentUciEditorController);

    StudentUciEditorController.$inject = ['$log', '$scope', '$rootScope', '$uibModal', 'Student'];

    function StudentUciEditorController($log, $scope, $rootScope, $uibModal, Student) {
        //Public Interface
        /* jshint validthis:true */
        var vm = this;
        vm.student = vm.student ? vm.student : {};
        vm.student.id = vm.student.id ? vm.student.id : undefined;

        //Operations
        vm.init = init;
        vm.loadStudentUci = loadStudentUci;
        vm.editStudentUci = editStudentUci;


        // Private Interface
        $scope.hasData = function() {
            if ($scope.student && $scope.student !== undefined) {
                return true;
            } else {
                return false;
            }
        };



        function init() {
            $log.log('StudentUciDetailsDirectiveController::init called');
            if (vm.student === undefined) {
                vm.loadStudentUci(vm.student.id);
            } else {
                vm.student.id = vm.student.id;
            }
        }



        function loadStudentUci(studentId) {
            Student.get(vm.student.id).then(function(response) {
                $log.info('II StudentUci Loaded');
                vm.student = response.data;
                vm.student.id = vm.student.id;
                $log.info(vm.student);
            }, function(response) {
                $log.error('EE students could not be loaded');
            });
        }


        function editStudentUci(studentId) {
            $log.log('StudentUciDetailsDirectiveController::editContact called');
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/student-uci-editor/views/student-uci-editor-dialog.html',
                controller: 'StudentUciEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    studentUciEntity: function(Student) {
                        return Student.get(vm.student.id).then(function(response) {
                            return response.data;
                        }, function(response) {
                            alert("failed to retrieve");
                        });
                    }
                }
            });
            modalInstance.result.then().finally(function() {
                vm.loadStudentUci(vm.student.id);
            });
        }

    }

})();
