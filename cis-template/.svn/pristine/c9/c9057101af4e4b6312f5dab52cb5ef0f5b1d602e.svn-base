/**
 * This is the Student Careers Record Editor Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */


(function() {
    'use strict';

    angular
        .module('StudentCareersRecordsEditorDirective')
        .controller('StudentCareersRecordsEditorController', StudentCareersRecordsEditorController);

    StudentCareersRecordsEditorController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModal', 'StudentCareersRecord'];

    function StudentCareersRecordsEditorController($log, $scope, $state, $rootScope, $uibModal, StudentCareersRecord) {
        /* jshint validthis:true */
        var vm = this;
        vm.dialog = {};
        vm.studentId = vm.studentId ? vm.studentId : undefined;
        vm.studentCareersRecords = vm.studentCareersRecords ? vm.studentCareersRecords : [];
        vm.init = init;
        vm.loadStudentCareersRecords = loadStudentCareersRecords;
        vm.editStudentCareersRecord = editStudentCareersRecord;
        vm.deleteStudentCareersRecord = deleteStudentCareersRecord;
        vm.addStudentCareersRecord = addStudentCareersRecord;

        function init() {
            $log.info('II CareersRecords Editor Initialised');
            vm.loadStudentCareersRecords(vm.studentId);
        }

        function loadStudentCareersRecords(studentId) {
            $log.info('II Loading CareersRecords Data');
            StudentCareersRecord.getByStudentId(studentId).then(function(response) {
                $log.log('CareersRecordsEditorController::work placement called');
                vm.studentCareersRecords = response.data;
            }, function(response) {
                $log.error('EE StudentCareersRecords could not be loaded');
            });
        }

        function editStudentCareersRecord(id) {
            $log.log('CareersRecordsEditorController::editContact called');

            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/student-careers-records-editor/views/student-careers-records-editor-dialog.html',
                controller: 'StudentCareersRecordsEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    studentCareersRecordEntity: ['StudentCareersRecord', function(StudentCareersRecord) {
                        return StudentCareersRecord.get(id).then(function(response) {
                            return response.data;
                        }, function(response) {
                            alert("failed to retrieve");
                        });
                    }]
                }
            });
            // Reload Contacts after dialog closed
            modalInstance.result.then().finally(function() {
                vm.loadStudentCareersRecords(vm.studentId);
            });
        }

        function deleteStudentCareersRecord(id) {
            $log.log('StudentCareersRecordsEditorController::deleteStudentCareersRecord called');
            if (id) {
                var msg = "Are you sure you want to delete this StudentCareersRecord?";
                if (window.confirm(msg)) {
                    StudentCareersRecord.delete(id).then(function(response) {
                        $log.info("II StudentCareersRecord ($studentId) has been deleted");
                    }, function(response) {
                        $log.info("EE A problem occurred trying to delete StudentCareersRecord ($studentId)");
                    }).finally(function() {
                        vm.loadStudentCareersRecords(vm.studentId);
                    });
                }
            }
        }

        //Create New Work Placement
        function addStudentCareersRecord(studentId) {
            $log.log('CareersRecordsEditorController:: AddCareersRecord called');
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/student-careers-records-editor/views/student-careers-records-editor-dialog.html',
                controller: 'StudentCareersRecordsEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    studentCareersRecordEntity: [function() {
                        var studentCareersRecords = {};
                        studentCareersRecords.studentId = studentId;
                        return studentCareersRecords;
                    }]
                }
            });
            modalInstance.result.then().finally(function() {
                vm.loadStudentCareersRecords(vm.studentId);
            });
        }

    }
})();
