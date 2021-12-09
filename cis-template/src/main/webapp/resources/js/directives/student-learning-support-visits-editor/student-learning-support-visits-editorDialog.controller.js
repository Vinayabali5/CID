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
        .module('StudentLearningSupportVisitsEditorDirective')
        .controller('StudentLearningSupportVisitsEditorDialogController', StudentLearningSupportVisitsEditorDialogController);

    StudentLearningSupportVisitsEditorDialogController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModalInstance', 'LearningSupportVisit', 'studentLearningSupportVisitEntity'];

    function StudentLearningSupportVisitsEditorDialogController($log, $scope, $state, $rootScope, $uibModalInstance, LearningSupportVisit, studentLearningSupportVisitEntity) {
        /* jshint validthis:true */
        var vm = this;
        vm.studentLearningSupportVisit = studentLearningSupportVisitEntity !== undefined ? studentLearningSupportVisitEntity : {};
        vm.studentLearningSupportVisit.startDate = new Date(vm.studentLearningSupportVisit.startDate);
        vm.studentLearningSupportVisit.time = new Date(vm.studentLearningSupportVisit.time);
        vm.save = save;
        vm.cancel = cancel;

        var onSaveFinished = function(result) {
            $scope.$emit('entryQualification-saved', result);
            $uibModalInstance.close(result);
        };

        function save() {
            $log.log('EntryQualificationDialogController::save called');
            $log.info(vm.studentLearningSupportVisit);
            if (vm.studentLearningSupportVisit.id) {
                LearningSupportVisit.save(vm.studentLearningSupportVisit, onSaveFinished);
            } else {
                if (vm.studentLearningSupportVisit.id !== null) {
                    LearningSupportVisit.create(vm.studentLearningSupportVisit, onSaveFinished);
                }
            }
        }

        function cancel() {
            $log.log('EntryQualificationDialogController::clear called');
            $uibModalInstance.dismiss('cancel');
        }
    }
})();
