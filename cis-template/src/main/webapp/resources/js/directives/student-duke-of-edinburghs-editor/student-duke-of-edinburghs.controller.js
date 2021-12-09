/**
 * This is the Student Duke Of Edinburghs Editor Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */


(function() {
    'use strict';

    angular
        .module('StudentDukeOfEdinburghsEditorDirective')
        .controller('StudentDukeOfEdinburghsEditorController', StudentDukeOfEdinburghsEditorController);

    StudentDukeOfEdinburghsEditorController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModal', 'StudentDukeOfEdinburgh'];

    function StudentDukeOfEdinburghsEditorController($log, $scope, $state, $rootScope, $uibModal, StudentDukeOfEdinburgh) {
        /* jshint validthis:true */
        var vm = this;
        vm.dialog = {};
        vm.studentId = vm.studentId ? vm.studentId : undefined;
        vm.studentDukeOfEdinburghs = vm.studentDukeOfEdinburghs ? vm.studentDukeOfEdinburghs : [];
        vm.init = init;
        vm.loadStudentDukeOfEdinburghs = loadStudentDukeOfEdinburghs;
        vm.editStudentDukeOfEdinburgh = editStudentDukeOfEdinburgh;
        vm.deleteStudentDukeOfEdinburgh = deleteStudentDukeOfEdinburgh;
        vm.addStudentDukeOfEdinburgh = addStudentDukeOfEdinburgh;

        function init() {
            $log.info('II Student Duke of Edinburghs Editor Initialised');
            vm.loadStudentDukeOfEdinburghs(vm.studentId);
        }

        function loadStudentDukeOfEdinburghs(studentId) {
            $log.info('II Loading StudentDukeOfEdinburghs Data');
            StudentDukeOfEdinburgh.getByStudentId(studentId).then(function(response) {
                $log.log('StudentDukeOfEdinburghsEditorController::StudentDukeOfEdinburgh called');
                vm.studentDukeOfEdinburghs = response.data;
            }, function(response) {
                $log.error('EE StudentDukeOfEdinburghs could not be loaded');
            });
        }

        function editStudentDukeOfEdinburgh(id) {
            $log.log('StudentDukeOfEdinburghsEditorController::editContact called');

            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/student-duke-of-edinburghs-editor/views/student-duke-of-edinburghs-editor-dialog.html',
                controller: 'StudentDukeOfEdinburghsEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    studentDukeOfEdinburghEntity: ['StudentDukeOfEdinburgh', function(StudentDukeOfEdinburgh) {
                        return StudentDukeOfEdinburgh.get(id).then(function(response) {
                            return response.data;
                        }, function(response) {
                            alert("failed to retrieve");
                        });
                    }]
                }
            });
            // Reload Contacts after dialog closed
            modalInstance.result.then().finally(function() {
                vm.loadStudentDukeOfEdinburghs(vm.studentId);
            });
        }

        function deleteStudentDukeOfEdinburgh(id) {
            $log.log('StudentDukeOfEdinburghsEditorController::deleteStudentDukeOfEdinburgh called');
            if (id) {
                var msg = "Are you sure you want to delete this Student Duke Of Edinburgh?";
                if (window.confirm(msg)) {
                    StudentDukeOfEdinburgh.delete(id).then(function(response) {
                        $log.info("II StudentDukeOfEdinburgh ($studentId) has been deleted");
                    }, function(response) {
                        $log.info("EE A problem occurred trying to delete StudentDukeOfEdinburgh ($studentId)");
                    }).finally(function() {
                        vm.loadStudentDukeOfEdinburghs(vm.studentId);
                    });
                }
            }
        }

        //Create New Work Placement
        function addStudentDukeOfEdinburgh(studentId) {
            $log.log('StudentDukeOfEdinburghsEditorController:: AddStudentDukeOfEdinburgh called');
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/student-duke-of-edinburghs-editor/views/student-duke-of-edinburghs-editor-dialog.html',
                controller: 'StudentDukeOfEdinburghsEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    studentDukeOfEdinburghEntity: [function() {
                        var studentDukeOfEdinburghs = {};
                        studentDukeOfEdinburghs.studentId = studentId;
                        return studentDukeOfEdinburghs;
                    }]
                }
            });
            modalInstance.result.then().finally(function() {
                vm.loadStudentDukeOfEdinburghs(vm.studentId);
            });
        }

    }
})();
