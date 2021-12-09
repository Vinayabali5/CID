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
        .module('StudentLLDDHealthProblemCategoryEditorDirective')
        .controller('StudentLLDDHealthProblemCategoryEditorDirectiveController', StudentLLDDHealthProblemCategoryEditorDirectiveController);

    StudentLLDDHealthProblemCategoryEditorDirectiveController.$inject = ['$log', '$scope', '$rootScope', '$state', '$uibModal', 'StudentLLDDHealthProblemCategory'];

    function StudentLLDDHealthProblemCategoryEditorDirectiveController($log, $scope, $rootScope, $state, $uibModal, StudentLLDDHealthProblemCategory) {
        /* jshint validthis:true */
        var vm = this;
        vm.dialog = {};
        vm.init = init;
        vm.message = '';

        // Public Interface

        vm.studentId = vm.studentId ? vm.studentId : undefined;
        vm.llddHealthProblemCategory = vm.llddHealthProblemCategory ? vm.llddHealthProblemCategory : [];
        vm.init = init;
        vm.loadStudentLLDDHealthProblemCategory = loadStudentLLDDHealthProblemCategory;
        vm.addStudentLLDDHealthProblemCategory = addStudentLLDDHealthProblemCategory;
        vm.editStudentLLDDHealthProblemCategory = editStudentLLDDHealthProblemCategory;
        vm.deleteStudentLLDDHealthProblemCategory = deleteStudentLLDDHealthProblemCategory;

        function init() {
            $log.info('II EntryQualifications Editor Initialised');
            vm.loadStudentLLDDHealthProblemCategory(vm.studentId);
        }

        // Private Interface

        function loadStudentLLDDHealthProblemCategory(studentId) {
            StudentLLDDHealthProblemCategory.getByStudentId(studentId).then(function(response) {
                $log.info('II StudentLLDDHealthProblemCategorys Loaded');
                vm.llddHealthProblemCategory = response.data;
            }, function(response) {
                $log.error('EE students could not be loaded');
            });
        }

        /**
         * This method is used to edit a single student referralReason.
         */
        function editStudentLLDDHealthProblemCategory(studentLLDDHealthProblemCategoryId) {
            $log.log('StudentLLDDHealthProblemCategoryEditorController::eddContact called');
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/student-lldd-health-problem-category-editor/views/student-lldd-health-problem-category-editor-dialog.html',
                controller: 'StudentLLDDHealthProblemCategoryEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    studentLLDDHealthProblemCategoryEntity: ['StudentLLDDHealthProblemCategory', function(StudentLLDDHealthProblemCategory) {
                        return StudentLLDDHealthProblemCategory.get(studentLLDDHealthProblemCategoryId).then(function(response) {
                            return response.data;
                        }, function(response) {
                            alert("failed to retrieve");
                        });
                    }]
                }
            });
            modalInstance.result.then().finally(function() {
                vm.loadStudentLLDDHealthProblemCategory(vm.studentId);
            });
        }


        /**
         * This method is used to add a single student referralReason.
         */
        function addStudentLLDDHealthProblemCategory(studentId) {
            $log.log('StudentLLDDHealthProblemCategoryEditorController::addContact called');
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/student-lldd-health-problem-category-editor/views/student-lldd-health-problem-category-editor-dialog.html',
                controller: 'StudentLLDDHealthProblemCategoryEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    studentLLDDHealthProblemCategoryEntity: function() {
                        var studentLLDDHealthProblemCategory = {};
                        studentLLDDHealthProblemCategory.studentId = studentId;
                        return studentLLDDHealthProblemCategory;
                    }
                }
            });
            modalInstance.result.then().finally(function() {
                vm.loadStudentLLDDHealthProblemCategory(vm.studentId);
            });
        }

        /** This method is used to delete the StudentLLDDHealthProblemCategory using studentLLDDHealthProblemCategoryId 
         * 
         */
        function deleteStudentLLDDHealthProblemCategory(studentLLDDHealthProblemCategoryId) {
            $log.log('StudentLLDDHealthProblemCategoryDeleteController::deleteStudentLLDDHealthProblemCategory called');
            if (studentLLDDHealthProblemCategoryId) {
                var msg = "Are you sure you want to delete this studentLLDDHealthProblemCategory?";
                if (window.confirm(msg)) {
                    StudentLLDDHealthProblemCategory.delete(studentLLDDHealthProblemCategoryId).then(function(response) {
                        $log.info("II StudentLLDDHealthProblemCategory ($studentLLDDHealthProblemCategoryId) has been deleted");
                    }, function(response) {
                        $log.info("EE problem occured trying to delete studentLLDDHealthProblemCategory($studentLLDDHealthProblemCategoryId)");
                    }).finally(function() {
                        vm.loadStudentLLDDHealthProblemCategory(vm.studentId);
                    });
                }
            }
        }
    }
})();
