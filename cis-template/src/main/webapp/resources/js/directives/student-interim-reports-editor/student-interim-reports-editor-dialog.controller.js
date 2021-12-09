/**
 * This is the Student Interim Reports Editor Dialog Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */


(function() {
    'use strict';

    angular
        .module('StudentInterimReportsEditorDirective')
        .controller('StudentInterimReportsEditorDialogController', StudentInterimReportsEditorDialogController);

    StudentInterimReportsEditorDialogController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModalInstance', 'StudentInterimReport', 'studentInterimReportEntity'];

    function StudentInterimReportsEditorDialogController($log, $scope, $state, $rootScope, $uibModalInstance, StudentInterimReport, studentInterimReportEntity) {
        /* jshint validthis:true */
        var vm = this;
        vm.studentInterimReport = studentInterimReportEntity !== undefined ? studentInterimReportEntity : {};

        vm.save = save;
        vm.cancel = cancel;

        function closeDialog() {
            $uibModalInstance.close();
        }

        function save() {
            $log.log('InterimReportDialogController::save called');
            $log.info(vm.studentInterimReport);
            if (vm.studentInterimReport.id) {
                StudentInterimReport.save(vm.studentInterimReport, closeDialog);
            }
        }

        function cancel() {
            $log.log('InterimReportDialogController::clear called');
            $uibModalInstance.dismiss('cancel');
        }
    }
})();
