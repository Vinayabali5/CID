/**
 * This is the Timetable Editor Dialog Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */


(function() {
    'use strict';

    angular
        .module('TimetableEditorDirective')
        .controller('TimetableEditorDialogController', TimetableEditorDialogController);

    TimetableEditorDialogController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModalInstance', 'Timetable', 'timetableEntity'];

    function TimetableEditorDialogController($log, $scope, $state, $rootScope, $uibModalInstance, Timetable, timetableEntity) {
        /* jshint validthis:true */
        var vm = this;
        vm.timetable = timetableEntity !== undefined ? timetableEntity : {};
        vm.courseGroupId = vm.timetable ? vm.timetable : undefined;
        vm.timetable.validFrom = new Date(vm.timetable.validFrom);
        vm.timetable.validTo = new Date(vm.timetable.validTo);

        vm.save = save;
        vm.cancel = cancel;

        var onSaveFinished = function(result) {
            $scope.$emit('timetable-saved', result);
            $uibModalInstance.close(result);
        };

        function save() {
            $log.log('EntryQualificationDialogController::save called');
            $log.info(vm.timetable);
            if (vm.timetable.id != null) {
                Timetable.save(vm.timetable, onSaveFinished);
            } else if (vm.timetable.courseGroupId != null) {
                Timetable.create(vm.timetable, onSaveFinished);
            }
        }

        function cancel() {
            $log.log('TimetableDialogController::clear called');
            $uibModalInstance.dismiss('cancel');
        }
    }
})();
