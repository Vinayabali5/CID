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
        .module('StudentEntryQualificationsEditorDirective')
        .controller('StudentEntryQualificationsEditorDialogController', StudentEntryQualificationsEditorDialogController);

    StudentEntryQualificationsEditorDialogController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModalInstance', 'StudentEntryQualification', 'studentEntryQualificationEntity'];

    function StudentEntryQualificationsEditorDialogController($log, $scope, $state, $rootScope, $uibModalInstance, StudentEntryQualification, studentEntryQualificationEntity) {
        /* jshint validthis:true */
        var vm = this;
        vm.studentEntryQualification = studentEntryQualificationEntity !== undefined ? studentEntryQualificationEntity : {};
        vm.studentEntryQualification.date = new Date(vm.studentEntryQualification.date);

        vm.save = save;
        vm.cancel = cancel;

        var onSaveFinished = function(result) {
            $scope.$emit('entryQualification-saved', result);
            $uibModalInstance.close(result);
        };

        function save() {
            $log.log('EntryQualificationDialogController::save called');
            $log.info(vm.studentEntryQualification);
            if (vm.studentEntryQualification.studentEntryQualificationId) {
                StudentEntryQualification.save(vm.studentEntryQualification, onSaveFinished);
            } else {
                if (vm.studentEntryQualification.id !== null) {
                    StudentEntryQualification.create(vm.studentEntryQualification, onSaveFinished);
                }
            }
        }

        function cancel() {
            $log.log('EntryQualificationDialogController::clear called');
            $uibModalInstance.dismiss('cancel');
        }
    }
})();
