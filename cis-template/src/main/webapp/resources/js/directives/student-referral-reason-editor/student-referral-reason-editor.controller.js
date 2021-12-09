/**
 * This is the StudentReferral Reason Table Controller
 * 
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 * 
 * @type Controller
 */

(function() {
    'use strict';

    angular
        .module('StudentReferralReasonEditorDirective')
        .controller('StudentReferralReasonEditorDirectiveController', StudentReferralReasonEditorDirectiveController);

    StudentReferralReasonEditorDirectiveController.$inject = ['$log', '$scope', '$rootScope', '$state', '$uibModal', 'StudentReferralReason'];

    function StudentReferralReasonEditorDirectiveController($log, $scope, $rootScope, $state, $uibModal, StudentReferralReason) {
        /* jshint validthis:true */
        var vm = this;
        vm.dialog = {};
        vm.init = init;
        vm.message = '';

        // Public Interface

        vm.studentId = vm.studentId ? vm.studentId : undefined;
        vm.studentReferralReason = vm.studentReferralReason ? vm.studentReferralReason : [];
        vm.init = init;
        vm.loadStudentReferralReason = loadStudentReferralReason;
        vm.addStudentReferralReason = addStudentReferralReason;
        vm.editStudentReferralReason = editStudentReferralReason;
        vm.deleteStudentReferralReason = deleteStudentReferralReason;

        function init() {
            $log.info('II EntryQualifications Editor Initialised');
            vm.loadStudentReferralReason(vm.studentId);
        }

        // Private Interface

        function loadStudentReferralReason(studentId) {
            StudentReferralReason.getByStudentId(studentId).then(function(response) {
                $log.info('II StudentReferralReasons Loaded');
                vm.studentReferralReason = response.data;
            }, function(response) {
                $log.error('EE students could not be loaded');
            });
        }

        /**
         * This method is used to edit a single student referralReason.
         */
        function editStudentReferralReason(studentReferralReasonId) {
            $log.log('StudentReferralReasonEditorController::eddContact called');
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/student-referral-reason-editor/views/student-referral-reason-editor-dialog.html',
                controller: 'StudentReferralReasonEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    studentReferralReasonEntity: ['StudentReferralReason', function(StudentReferralReason) {
                        return StudentReferralReason.get(studentReferralReasonId).then(function(response) {
                            return response.data;
                        }, function(response) {
                            alert("failed to retrieve");
                        });
                    }]
                }
            });
            modalInstance.result.then().finally(function() {
                vm.loadStudentReferralReason(vm.studentId);
            });
        }


        /**
         * This method is used to add a single student referralReason.
         */
        function addStudentReferralReason(studentId) {
            $log.log('StudentReferralReasonEditorController::addContact called');
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/student-referral-reason-editor/views/student-referral-reason-editor-dialog.html',
                controller: 'StudentReferralReasonEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    studentReferralReasonEntity: function() {
                        var studentReferralReason = {};
                        studentReferralReason.studentId = studentId;
                        return studentReferralReason;
                    }
                }
            });
            modalInstance.result.then().finally(function() {
                vm.loadStudentReferralReason(vm.studentId);
            });
        }

        /** This method is used to delete the StudentReferralReason using studentReferralReasonId 
         * 
         */
        function deleteStudentReferralReason(studentReferralReasonId) {
            $log.log('StudentReferralReasonDeleteController::deleteStudentReferralReason called');
            if (studentReferralReasonId) {
                var msg = "Are you sure you want to delete this studentReferralReason?";
                if (window.confirm(msg)) {
                    StudentReferralReason.delete(studentReferralReasonId).then(function(response) {
                        $log.info("II StudentReferralReason ($studentReferralReasonId) has been deleted");
                    }, function(response) {
                        $log.info("EE problem occured trying to delete studentReferralReason($studentReferralReasonId)");
                    }).finally(function() {
                        vm.loadStudentReferralReason(vm.studentId);
                    });
                }
            }
        }
    }
})();
