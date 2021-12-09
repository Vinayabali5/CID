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
        .module('StudentLearningSupportVisitsEditorDirective')
        .controller('StudentLearningSupportVisitsEditorController', StudentLearningSupportVisitsEditorController);

    StudentLearningSupportVisitsEditorController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModal', 'LearningSupportVisit'];

    function StudentLearningSupportVisitsEditorController($log, $scope, $state, $rootScope, $uibModal, LearningSupportVisit) {
        /* jshint validthis:true */
        var vm = this;
        vm.dialog = {};
        vm.studentId = vm.studentId ? vm.studentId : undefined;
        vm.studentLearningSupportVisits = vm.studentLearningSupportVisits ? vm.studentLearningSupportVisits : [];
        vm.init = init;
        vm.loadStudentLearningSupportVisits = loadStudentLearningSupportVisits;
        vm.editStudentLearningSupportVisit = editStudentLearningSupportVisit;
        vm.addStudentLearningSupportVisit = addStudentLearningSupportVisit;

        function init() {
            $log.info('II EntryQualifications Editor Initialised');
            vm.loadStudentLearningSupportVisits(vm.studentId);
        }

        function loadStudentLearningSupportVisits(studentId) {
            $log.info('II Loading EntryQualifications Data');
            LearningSupportVisit.getByStudent(studentId).then(function(response) {
                $log.log('EntryQualificationsEditorController::entryQualifications called');
                vm.studentLearningSupportVisits = response.data;
            }, function(response) {
                $log.error('EE StudentLearningSupportVisits could not be loaded');
            });
        }

        function editStudentLearningSupportVisit(studentLearningSupportVisitId) {
            $log.log('EntryQualificationsEditorController::editContact called');

            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/student-learning-support-visits-editor/views/student-learning-support-visits-editorDialog.html',
                controller: 'StudentLearningSupportVisitsEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    studentLearningSupportVisitEntity: function(LearningSupportVisit) {
                        return LearningSupportVisit.get(studentLearningSupportVisitId).then(function(response) {
                            return response.data;
                        }, function(response) {
                            alert("failed to retrieve");
                        });
                    }
                }
            });
            // Reload Contacts after dialog closed
            modalInstance.result.then().finally(function() {
                vm.loadStudentLearningSupportVisits(vm.studentId);
            });
        }


        //Create New Entry Qualifications
        function addStudentLearningSupportVisit(studentId) {
            $log.log('EntryQualificationsEditorController:: AddEntryQualification called');
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/student-learning-support-visits-editor/views/student-learning-support-visits-editorDialog.html',
                controller: 'StudentLearningSupportVisitsEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    studentLearningSupportVisitEntity: function() {
                        var studentLearningSupportVisits = {};
                        studentLearningSupportVisits.studentId = studentId;
                        return studentLearningSupportVisits;
                    }
                }
            });
            modalInstance.result.then().finally(function() {
                vm.loadStudentLearningSupportVisits(vm.studentId);
            });
        }

    }
})();
