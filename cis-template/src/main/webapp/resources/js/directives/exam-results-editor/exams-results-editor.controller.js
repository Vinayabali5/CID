/**
 * This is the Exam Results Editor Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';

    angular
        .module('ExamResultsEditorDirective')
        .controller('ExamResultsEditorController', ExamResultsEditorController);

    ExamResultsEditorController.$inject = ['$log', '$uibModal', 'ExamResults'];

    function ExamResultsEditorController($log, $uibModal, ExamResults) {
        /* jshint validthis:true */
        var vm = this;
        vm.results = [];
        vm.studentId = vm.studentId ? vm.studentId : null;


        vm.loadExamResults = loadExamResults;
        vm.editExamResults = editExamResults;

        function loadExamResults(studentId) {
            ExamResults.getByStudent(studentId).then(function(response) {
                vm.results = response.data;
                $log.info("Loading Exam Results");
            }, function(response) {
                $log.error("Failed to load Results");
            });
        }


        function editExamResults(examResultId) {
            $log.log("ExamResultsEditorController :: editExamResult called");
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/exam-results-editor/views/exam-results-editorDialog.html',
                controller: 'ExamResultsEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    examResultsEntity: function(ExamResults) {
                        return ExamResults.get(examResultId).then(function(response) {
                            return response.data;
                        }, function(response) {
                            alert("failed to retrieve");
                        });
                    }
                }
            });

            modalInstance.result.then().finally(function() {
                vm.loadExamResults(vm.studentId);
            });

        }
    }

})();
