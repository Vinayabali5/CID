/**
 * This is the StudentOption Editor Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';

    angular
        .module('StudentOptionEditorTableDirective')
        .controller('StudentOptionEditorTableController', StudentOptionEditorTableController);

    StudentOptionEditorTableController.$inject = ['$scope', '$log', '$uibModal', 'StudentOptionEntry'];

    function StudentOptionEditorTableController($scope, $log, $uibModal, StudentOptionEntry) {
        /* jshint validthis:true */
        var vm = this;

        vm.studentId = vm.studentId ? vm.studentId : undefined;
        vm.studentOptionEntries = vm.studentOptionEntries ? vm.studentOptionEntries : [];

        vm.getStudentOptionEntries = function(id) {
            StudentOptionEntry.getId(id).then(function(response) {
                vm.studentOptionEntries = response.data;
            });
        };

        var onSaveFinished = function(result) {
            $scope.$emit('option-entires-updated', result);
        };

        vm.loadStudentOptionEntries = function(id) {
            StudentOptionEntry.getId(id).then(function(response) {
                $log.info('II StudentYear Loaded');
                vm.studentOptionEntries = response.data;
                $log.info(vm.studentOptionEntries);
            }, function(response) {
                $log.error('EE students could not be loaded');
            });
        };

        //update the StudentOptionEntries information
        vm.editStudentOptionEntry = function(studentId, examOptionId) {
            $log.debug('StudentOptionEntriesEditorController::editContact called');

            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/student-option-editor-table/views/student-option-editor-edit-dialog.html',
                controller: 'StudentOptionEditorTableEditDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    studentOptionEntryEntity: ['StudentOptionEntry', function(StudentOptionEntry) {
                        return StudentOptionEntry.getByOptionId(studentId, examOptionId).then(function(response) {
                            return response.data;
                        }, function(response) {
                            alert("failed to retrieve");
                        });
                    }]
                }
            });
        };

        vm.addStudentOptionEntry = function(studentId) {
            $log.debug('StudentOptionEntriesEditorController::addContact called');
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/student-option-editor-table/views/student-option-editor-add-dialog.html',
                controller: 'StudentOptionEditorTableAddDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    studentId: function() {
                        return studentId;
                    }
                }
            });
        };

        this.deleteStudentOptionEntry = function(studentId, examOptionId) {
            $log.debug('StudentOptionEntriesEditorController::deleteStudentOptionEntriesEditorController called');
            if (studentId, examOptionId) {
                var msg = "Are you sure you want to delete this StudentOptionEntry ?";
                if (window.confirm(msg)) {
                    StudentOptionEntry.delete(studentId, examOptionId, onSaveFinished).then(function(response) {
                        $log.info("II StudentOptionEntry ($studentId)($examOptionId) has been deleted");
                    }, function(response) {
                        $log.info("EE A problem occurred trying to delete StudentOptionEntry ($studentId)($examOptionId)");
                    });
                }
            }
        };
        this.markAmendment = function(studentId) {
            $log.debug('StudentOptionEntriesController::markAmendment called');

            if (studentId) {
                var msg = "Are you sure you want to Mark For Ammendment ?";
                if (window.confirm(msg)) {
                    StudentOptionEntry.markExamAmendment(studentId, onSaveFinished).then(function(response) {
                        $log.info("Student $(studentId) has been marked Amendment");
                    });
                }

            }

        };
    }

})();
