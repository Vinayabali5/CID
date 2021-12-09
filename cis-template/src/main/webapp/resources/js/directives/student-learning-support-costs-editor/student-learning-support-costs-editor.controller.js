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
        .module('StudentLearningSupportCostsEditorDirective')
        .controller('StudentLearningSupportCostsEditorController', StudentLearningSupportCostsEditorController);

    StudentLearningSupportCostsEditorController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModal', 'LearningSupportCost'];

    function StudentLearningSupportCostsEditorController($log, $scope, $state, $rootScope, $uibModal, LearningSupportCost) {
        /* jshint validthis:true */
        var vm = this;
        vm.dialog = {};
        vm.studentId = vm.studentId ? vm.studentId : undefined;
        vm.studentLearningSupportCosts = vm.studentLearningSupportCosts ? vm.studentLearningSupportCosts : [];
        vm.init = init;
        vm.loadStudentLearningSupportCosts = loadStudentLearningSupportCosts;
        vm.editStudentLearningSupportCost = editStudentLearningSupportCost;
        vm.addStudentLearningSupportCost = addStudentLearningSupportCost;

        function init() {
            $log.info('II EntryQualifications Editor Initialised');
            vm.loadStudentLearningSupportCosts(vm.studentId);
        }

        function loadStudentLearningSupportCosts(studentId) {
            $log.info('II Loading EntryQualifications Data');
            LearningSupportCost.getByStudent(studentId).then(function(response) {
                $log.log('EntryQualificationsEditorController::entryQualifications called');
                vm.studentLearningSupportCosts = response.data;
            }, function(response) {
                $log.error('EE StudentLearningSupportCosts could not be loaded');
            });
        }

        function editStudentLearningSupportCost(studentLearningSupportCostId) {
            $log.log('EntryQualificationsEditorController::editContact called');

            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/student-learning-support-costs-editor/views/student-learning-support-costs-editorDialog.html',
                controller: 'StudentLearningSupportCostsEditorDialogController',
                controllerAs: 'ctrl',
                size: 'md',
                resolve: {
                    studentLearningSupportCostEntity: function(LearningSupportCost) {
                        return LearningSupportCost.get(studentLearningSupportCostId).then(function(response) {
                            return response.data;
                        }, function(response) {
                            alert("failed to retrieve");
                        });
                    }
                }
            });
            // Reload Contacts after dialog closed
            modalInstance.result.then().finally(function() {
                vm.loadStudentLearningSupportCosts(vm.studentId);
            });
        }


        //Create New Entry Qualifications
        function addStudentLearningSupportCost(studentId) {
            $log.log('EntryQualificationsEditorController:: AddEntryQualification called');
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/student-learning-support-costs-editor/views/student-learning-support-costs-editorDialog.html',
                controller: 'StudentLearningSupportCostsEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    studentLearningSupportCostEntity: function() {
                        var studentLearningSupportCosts = {};
                        studentLearningSupportCosts.studentId = studentId;
                        return studentLearningSupportCosts;
                    }
                }
            });
            modalInstance.result.then().finally(function() {
                vm.loadStudentLearningSupportCosts(vm.studentId);
            });
        }

    }
})();
