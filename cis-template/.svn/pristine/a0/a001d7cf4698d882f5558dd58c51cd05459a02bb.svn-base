/**
 * This is the ExamSeries Dialog Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';

    angular
        .module('ExamSeriesEditorDirective')
        .controller('ExamSeriesEditorDialogController', ExamSeriesEditorDialogController);

    ExamSeriesEditorDialogController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModalInstance', 'ExamSeries', 'examSeriesEntity'];

    function ExamSeriesEditorDialogController($log, $scope, $state, $rootScope, $uibModalInstance, ExamSeries, examSeriesEntity) {
        /* jshint validthis:true */
        var vm = this;
        vm.examSeries = examSeriesEntity !== undefined ? examSeriesEntity : {};

        vm.cancel = cancel;
        vm.save = save;

        var onSaveFinished = function(result) {
            $scope.$emit('current-year-changed', result);
            $uibModalInstance.close(result);
        };

        function cancel() {
            $uibModalInstance.dismiss('cancel');
        }

        function save() {
            if (vm.examSeries.id) {
                ExamSeries.save(vm.examSeries, onSaveFinished);
            } else {
                if (vm.examSeries.id !== null) {
                    ExamSeries.create(vm.examSeries, onSaveFinished);
                }
            }
        }

    }

})();
