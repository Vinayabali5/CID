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
        .controller('StudentOptionEditorTableAddDialogController', StudentOptionEditorTableAddDialogController);

    StudentOptionEditorTableAddDialogController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModalInstance', '$uibModal', 'studentId', 'StudentOptionEntry', 'Option'];

    function StudentOptionEditorTableAddDialogController($log, $scope, $state, $rootScope, $uibModalInstance, $uibModal, studentId, StudentOptionEntry, Option) {
        /* jshint validthis:true */
        var vm = this;

        // Public Interface
        vm.studentId = studentId !== undefined ? studentId : {};
        vm.optionEntryCode = "";
        vm.results = [];
        vm.visible = false;
        vm.message = "";
        vm.resit = false;
        vm.privateStudent = false;

        vm.clear = clear;
        vm.search = search;
        vm.addOptionEntryCode = addOptionEntryCode;


        // Private Interface
        var loading = false;

        var onSaveFinished = function(result) {
            $scope.$emit('option-entires-updated', result);
            $uibModalInstance.close(result);
        };

        function clear() {
            $log.debug('II exam-optionsSearchController :: clear called');
            vm.optionEntryCode = "";
            loading = false;
            vm.visible = false;
            vm.results = [];
        }

        function displayMessage(message) {
            $log.debug('II exam-options-SearchController :: displayMessage called');
            vm.message = message;
        }

        function search() {
            $log.debug('II exam-options-SearchController :: search called');
            loading = true;
            displayMessage("Loading please wait!");
            vm.results = [];
            console.log(vm.optionEntryCode);
            Option.search({
                optionEntryCode: vm.optionEntryCode
            }).then(function(response) {
                loading = false;
                vm.results = response.data;
                if (vm.hasResults()) {
                    vm.showResults();
                }
                displayMessage("");
            });
        }

        function addOptionEntryCode(studentId, examOptionId) {
            $log.debug('student option Edito rController::add called');
            var studentOptionEntry = {
                studentId: studentId,
                examOptionId: examOptionId,
                resit: vm.resit,
                privateStudent: vm.privateStudent,
            };
            if (studentId) {
                StudentOptionEntry.create(studentOptionEntry, onSaveFinished).then(function(response) {
                    $log.info("II Exam Option Successfully added");
                }, function(response) {
                    $log.info("EE Failed to add the Exam Option for the student: " + studentId);
                    displayMessage(response.data.message);
                });
            }

        }


        vm.executeCallback = function(id) {
            vm.hideResults();
            vm.callback(id);
        };

        vm.hasResults = function() {
            if (vm.results.length !== 0) {
                return true;
            }
            return false;
        };

        vm.isLoading = function() {
            return loading;
        };

        vm.resultsVisible = function() {
            if (vm.hasResults()) {
                return vm.visible;
            }
            return false;
        };

        vm.toggleResults = function() {
            vm.visible = !vm.visible;
        };

        vm.hideResults = function() {
            vm.visible = false;
        };

        vm.showResults = function() {
            vm.visible = true;
        };

        vm.cancel = function() {
            $log.debug('student option editorDialogController::clear called');
            $uibModalInstance.dismiss('cancel');
        };
    }
})();
