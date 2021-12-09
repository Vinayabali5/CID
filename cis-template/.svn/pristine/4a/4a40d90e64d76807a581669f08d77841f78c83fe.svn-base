/**
 * This is the Student volunteering logs Editor Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */


(function() {
    'use strict';

    angular
        .module('StudentVolunteeringLogsEditorDirective')
        .controller('StudentVolunteeringLogsEditorController', StudentVolunteeringLogsEditorController);

    StudentVolunteeringLogsEditorController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModal', 'StudentVolunteeringLog'];

    function StudentVolunteeringLogsEditorController($log, $scope, $state, $rootScope, $uibModal, StudentVolunteeringLog) {
        /* jshint validthis:true */
        var vm = this;
        vm.dialog = {};
        vm.studentId = vm.studentId ? vm.studentId : undefined;
        vm.studentVolunteeringLogs = vm.studentVolunteeringLogs ? vm.studentVolunteeringLogs : [];
        vm.init = init;
        vm.loadStudentVolunteeringLogs = loadStudentVolunteeringLogs;
        vm.editStudentVolunteeringLog = editStudentVolunteeringLog;
        vm.deleteStudentVolunteeringLog = deleteStudentVolunteeringLog;
        vm.addStudentVolunteeringLog = addStudentVolunteeringLog;

        function init() {
            $log.info('II StudentVolunteeringLogs Editor Initialised');
            vm.loadStudentVolunteeringLogs(vm.studentId);
        }

        function loadStudentVolunteeringLogs(studentId) {
            $log.info('II Loading StudentVolunteeringLogs Data');
            StudentVolunteeringLog.getByStudentId(studentId).then(function(response) {
                $log.log('StudentVolunteeringLogsEditorController::volunteering called');
                vm.studentVolunteeringLogs = response.data;
            }, function(response) {
                $log.error('EE StudentVolunteeringLogs could not be loaded');
            });
        }

        function editStudentVolunteeringLog(id) {
            $log.log('StudentVolunteeringLogsEditorController::editContact called');

            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/student-volunteering-logs-editor/views/student-volunteering-logs-editor-dialog.html',
                controller: 'StudentVolunteeringLogsEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    studentVolunteeringLogEntity: ['StudentVolunteeringLog', function(StudentVolunteeringLog) {
                        return StudentVolunteeringLog.get(id).then(function(response) {
                            return response.data;
                        }, function(response) {
                            alert("failed to retrieve");
                        });
                    }]
                }
            });
            // Reload Contacts after dialog closed
            modalInstance.result.then().finally(function() {
                vm.loadStudentVolunteeringLogs(vm.studentId);
            });
        }

        function deleteStudentVolunteeringLog(id) {
            $log.log('StudentVolunteeringLogsEditorController::deleteStudentVolunteeringLog called');
            if (id) {
                var msg = "Are you sure you want to delete this StudentVolunteeringLog?";
                if (window.confirm(msg)) {
                    StudentVolunteeringLog.delete(id).then(function(response) {
                        $log.info("II StudentVolunteeringLog ($studentId) has been deleted");
                    }, function(response) {
                        $log.info("EE A problem occurred trying to delete StudentVolunteeringLog ($studentId)");
                    }).finally(function() {
                        vm.loadStudentVolunteeringLogs(vm.studentId);
                    });
                }
            }
        }

        //Create New volunteering Log
        function addStudentVolunteeringLog(studentId) {
            $log.log('StudentVolunteeringLogsEditorController:: AddCareersRecord called');
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/student-volunteering-logs-editor/views/student-volunteering-logs-editor-dialog.html',
                controller: 'StudentVolunteeringLogsEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    studentVolunteeringLogEntity: [function() {
                        var studentVolunteeringLogs = {};
                        studentVolunteeringLogs.studentId = studentId;
                        return studentVolunteeringLogs;
                    }]
                }
            });
            modalInstance.result.then().finally(function() {
                vm.loadStudentVolunteeringLogs(vm.studentId);
            });
        }

    }
})();
