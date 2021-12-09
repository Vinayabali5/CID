/**
 * This is the Student Careers record Editor Dialog Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */


(function() {
    'use strict';

    angular
        .module('StudentCareersRecordsEditorDirective')
        .controller('StudentCareersRecordsEditorDialogController', StudentCareersRecordsEditorDialogController);

    StudentCareersRecordsEditorDialogController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModalInstance', 'StudentCareersRecord', 'studentCareersRecordEntity'];

    function StudentCareersRecordsEditorDialogController($log, $scope, $state, $rootScope, $uibModalInstance, StudentCareersRecord, studentCareersRecordEntity) {
        /* jshint validthis:true */
        var vm = this;
        vm.studentCareersRecord = studentCareersRecordEntity !== undefined ? studentCareersRecordEntity : {};
        vm.studentCareersRecord.startDate = new Date(vm.studentCareersRecord.startDate);
        vm.studentCareersRecord.endDate = new Date(vm.studentCareersRecord.endDate);

        vm.save = save;
        vm.cancel = cancel;

        var onSaveFinished = function(result) {
            $scope.$emit('careers-record-saved', result);
            $uibModalInstance.close(result);
        };

        function save() {
            $log.log('CareersRecordDialogController::save called');
            $log.info(vm.studentCareersRecord);
            if (vm.studentCareersRecord.id) {
                StudentCareersRecord.save(vm.studentCareersRecord, onSaveFinished);
            } else {
                if (vm.studentCareersRecord.id !== null) {
                    StudentCareersRecord.create(vm.studentCareersRecord, onSaveFinished);
                }
            }
        }

        function cancel() {
            $log.log('CareersRecordDialogController::clear called');
            $uibModalInstance.dismiss('cancel');
        }
    }
})();
