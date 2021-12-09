/**
 * This is the Entry Qualifications Editor Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */


(function() {
    'use strict';

    angular
        .module('StudentEntryQualificationsEditorDirective')
        .controller('StudentEntryQualificationsEditorController', StudentEntryQualificationsEditorController);

    StudentEntryQualificationsEditorController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModal', 'StudentEntryQualification'];

    function StudentEntryQualificationsEditorController($log, $scope, $state, $rootScope, $uibModal, StudentEntryQualification) {
        /* jshint validthis:true */
        var vm = this;
        vm.dialog = {};
        vm.studentId = vm.studentId ? vm.studentId : undefined;
        vm.studentEntryQualifications = vm.studentEntryQualifications ? vm.studentEntryQualifications : [];
        vm.init = init;
        vm.loadStudentEntryQualifications = loadStudentEntryQualifications;
        vm.editStudentEntryQualification = editStudentEntryQualification;
        vm.deleteStudentEntryQualification = deleteStudentEntryQualification;
        vm.addStudentEntryQualification = addStudentEntryQualification;
        vm.markAllAsChecked = markAllAsChecked;

        function init() {
            $log.info('II EntryQualifications Editor Initialised');
            vm.loadStudentEntryQualifications(vm.studentId);
        }

        function loadStudentEntryQualifications(studentId) {
            $log.info('II Loading EntryQualifications Data');
            StudentEntryQualification.get(studentId).then(function(response) {
                $log.log('EntryQualificationsEditorController::entryQualifications called');
                vm.studentEntryQualifications = response.data;
            }, function(response) {
                $log.error('EE StudentEntryQualifications could not be loaded');
            });
        }

        function editStudentEntryQualification(studentEntryQualificationId) {
            $log.log('EntryQualificationsEditorController::editContact called');

            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/studentEntryQualificationsEditor/views/studentEntryQualificationsEditorDialog.html',
                controller: 'StudentEntryQualificationsEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    studentEntryQualificationEntity: ['StudentEntryQualification', function(StudentEntryQualification) {
                        return StudentEntryQualification.entryQualification(studentEntryQualificationId).then(function(response) {
                            return response.data;
                        }, function(response) {
                            alert("failed to retrieve");
                        });
                    }]
                }
            });
            // Reload Entry Qualification after dialog closed
            modalInstance.result.then().finally(function() {
                vm.loadStudentEntryQualifications(vm.studentId);
            });
        }

        function deleteStudentEntryQualification(id) {
            $log.log('EntryQualificationsEditorController::deleteEntryQualification called');
            if (id) {
                var msg = "Are you sure you want to delete this EntryQualification?";
                if (window.confirm(msg)) {
                    StudentEntryQualification.delete(id).then(function(response) {
                        $log.info("II EntryQualification ($studentId) has been deleted");
                    }, function(response) {
                        $log.info("EE A problem occurred trying to delete EntryQualification ($studentId)");
                    }).finally(function() {
                        vm.loadStudentEntryQualifications(vm.studentId);
                    });
                }
            }
        }

        //Create New Entry Qualifications
        function addStudentEntryQualification(studentId) {
            $log.log('EntryQualificationsEditorController:: AddEntryQualification called');
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/studentEntryQualificationsEditor/views/studentEntryQualificationsEditorDialog.html',
                controller: 'StudentEntryQualificationsEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    studentEntryQualificationEntity: [function() {
                        var studentEntryQualifications = {};
                        studentEntryQualifications.studentId = studentId;
                        return studentEntryQualifications;
                    }]
                }
            });
            modalInstance.result.then().finally(function() {
                vm.loadStudentEntryQualifications(vm.studentId);
            });
        }

        /** 
         * This method is used to mark the student checked 
         * **/
        function markAllAsChecked(studentId) {
            $log.log('EntryQualificationsEditorController:: markAllAsChecked called');
            if (vm.studentId != null) {
                var msg = "Are you sure you want to mark all the entry qualifications checked?";
                if (window.confirm(msg)) {
                    StudentEntryQualification.markChecked(vm.studentId).then(function(response) {
                        $log.info("II EntryQualification ($studentId) mark all checked");
                    }, function(response) {
                        $log.info("EE A problem occurred when trying to mark all checked EntryQualification ($studentId)");
                    }).finally(function() {
                        vm.loadStudentEntryQualifications(vm.studentId);
                    });
                }
            }
        }

    }
})();
