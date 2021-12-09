/**
 * This is the Student Volunteering Log Editor Dialog Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */


(function() {
    'use strict';

    angular
        .module('StudentVolunteeringLogsEditorDirective')
        .controller('StudentVolunteeringLogsEditorDialogController', StudentVolunteeringLogsEditorDialogController);

    StudentVolunteeringLogsEditorDialogController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModalInstance', 'StudentVolunteeringLog', 'studentVolunteeringLogEntity'];

    function StudentVolunteeringLogsEditorDialogController($log, $scope, $state, $rootScope, $uibModalInstance, StudentVolunteeringLog, studentVolunteeringLogEntity) {
        /* jshint validthis:true */
        var vm = this;
        vm.studentVolunteeringLog = studentVolunteeringLogEntity !== undefined ? studentVolunteeringLogEntity : {};
        vm.studentVolunteeringLog.startDate = new Date(vm.studentVolunteeringLog.startDate);

        vm.save = save;
        vm.cancel = cancel;

        var onSaveFinished = function(result) {
            $scope.$emit('StudentVolunteeringLog-saved', result);
            $uibModalInstance.close(result);
        };

        function save() {
            $log.log('StudentVolunteeringLogDialogController::save called');
            $log.info(vm.studentVolunteeringLog);
            if (vm.studentVolunteeringLog.id) {
                StudentVolunteeringLog.save(vm.studentVolunteeringLog, onSaveFinished);
            } else {
                if (vm.studentVolunteeringLog.id !== null) {
                    StudentVolunteeringLog.create(vm.studentVolunteeringLog, onSaveFinished);
                }
            }
        }

        function cancel() {
            $log.log('StudentVolunteeringLogDialogController::clear called');
            $uibModalInstance.dismiss('cancel');
        }
    }
})();
