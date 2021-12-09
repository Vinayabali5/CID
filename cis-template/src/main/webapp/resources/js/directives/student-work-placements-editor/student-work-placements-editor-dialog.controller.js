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
        .module('StudentWorkPlacementsEditorDirective')
        .controller('StudentWorkPlacementsEditorDialogController', StudentWorkPlacementsEditorDialogController);

    StudentWorkPlacementsEditorDialogController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModalInstance', 'StudentWorkPlacement', 'studentWorkPlacementEntity'];

    function StudentWorkPlacementsEditorDialogController($log, $scope, $state, $rootScope, $uibModalInstance, StudentWorkPlacement, studentWorkPlacementEntity) {
        /* jshint validthis:true */
        var vm = this;
        vm.studentWorkPlacement = studentWorkPlacementEntity !== undefined ? studentWorkPlacementEntity : {};
        vm.studentWorkPlacement.startDate = new Date(vm.studentWorkPlacement.startDate);
        vm.studentWorkPlacement.endDate = new Date(vm.studentWorkPlacement.endDate);

        vm.save = save;
        vm.cancel = cancel;

        var onSaveFinished = function(result) {
            $scope.$emit('work-placement-saved', result);
            $uibModalInstance.close(result);
        };

        function save() {
            $log.log('WorkPlacementDialogController::save called');
            $log.info(vm.studentWorkPlacement);
            if (vm.studentWorkPlacement.id) {
                StudentWorkPlacement.save(vm.studentWorkPlacement, onSaveFinished);
            } else {
                if (vm.studentWorkPlacement.id !== null) {
                    StudentWorkPlacement.create(vm.studentWorkPlacement, onSaveFinished);
                }
            }
        }

        function cancel() {
            $log.log('WorkPlacementDialogController::clear called');
            $uibModalInstance.dismiss('cancel');
        }
    }
})();
