/**
 * This is the Exam Results Editor Dialog Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */


(function() {
    'use strict';

    angular
        .module('ExamResultsEditorDirective')
        .controller('ExamResultsEditorDialogController', ExamResultsEditorDialogController);

    ExamResultsEditorDialogController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModalInstance', 'ExamResults', 'examResultsEntity'];

    function ExamResultsEditorDialogController($log, $scope, $state, $rootScope, $uibModalInstance, ExamResults, examResultsEntity) {
        /* jshint validthis:true */
        var vm = this;
        vm.examResults = examResultsEntity !== undefined ? examResultsEntity : {};

        vm.cancel = cancel;
        vm.save = save;


        var onSaveFinished = function(result) {
            $scope.$emit('exam-results-saved', result);
            $uibModalInstance.close(result);
        };

        function cancel() {
            $log.log('ExamResultsEditorDialogController::clear called');
            $uibModalInstance.dismiss('cancel');
        }

        function save() {
            if (vm.examResults.id) {
                ExamResults.save(vm.examResults, onSaveFinished);
            }
        }

    }


})();
