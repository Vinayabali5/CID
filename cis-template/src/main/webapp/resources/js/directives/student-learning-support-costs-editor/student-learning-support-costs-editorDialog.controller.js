/**
 * This is the Entry Qualifications Editor Dialog Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */


(function() {
    'use strict';

    angular
        .module('StudentLearningSupportCostsEditorDirective')
        .controller('StudentLearningSupportCostsEditorDialogController', StudentLearningSupportCostsEditorDialogController);

    StudentLearningSupportCostsEditorDialogController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModalInstance', 'LearningSupportCost', 'studentLearningSupportCostEntity'];

    function StudentLearningSupportCostsEditorDialogController($log, $scope, $state, $rootScope, $uibModalInstance, LearningSupportCost, studentLearningSupportCostEntity) {
        /* jshint validthis:true */
        var vm = this;
        vm.studentLearningSupportCost = studentLearningSupportCostEntity !== undefined ? studentLearningSupportCostEntity : {};
        vm.studentLearningSupportCost.startDate = new Date(vm.studentLearningSupportCost.startDate);
        vm.studentLearningSupportCost.endDate = new Date(vm.studentLearningSupportCost.endDate);
        vm.save = save;
        vm.cancel = cancel;

        var onSaveFinished = function(result) {
            $scope.$emit('entryQualification-saved', result);
            $uibModalInstance.close(result);
        };

        function save() {
            $log.log('EntryQualificationDialogController::save called');
            $log.info(vm.studentLearningSupportCost);
            if (vm.studentLearningSupportCost.id) {
                LearningSupportCost.save(vm.studentLearningSupportCost, onSaveFinished);
            } else {
                if (vm.studentLearningSupportCost.id !== null) {
                    LearningSupportCost.create(vm.studentLearningSupportCost, onSaveFinished);
                }
            }
        }

        function cancel() {
            $log.log('EntryQualificationDialogController::clear called');
            $uibModalInstance.dismiss('cancel');
        }
    }
})();
