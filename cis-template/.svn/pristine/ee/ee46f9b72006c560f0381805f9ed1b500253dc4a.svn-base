/**
 * This is the Year Group Editor Dialog Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';

    angular
        .module('AttendanceMonitoringsEditorDirective')
        .controller('AttendanceMonitoringsEditorDialogController', AttendanceMonitoringsEditorDialogController);

    AttendanceMonitoringsEditorDialogController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModalInstance', 'AttendanceMonitoring', 'attendanceMonitoringsEntity'];

    function AttendanceMonitoringsEditorDialogController($log, $scope, $state, $rootScope, $uibModalInstance, AttendanceMonitoring, attendanceMonitoringsEntity) {
        /* jshint validthis:true */
        var vm = this;
        vm.attendanceMonitorings = attendanceMonitoringsEntity !== undefined ? attendanceMonitoringsEntity : {};

        vm.cancel = cancel;
        vm.save = save;
        vm.add = add;

        var onSaveFinished = function(result) {
            $scope.$emit('attendance-monitorings-saved', result);
            $uibModalInstance.close(result);
        };

        function cancel() {
            $uibModalInstance.dismiss('cancel');
        }

        function add() {
            if (vm.attendanceMonitorings.id !== null) {
                AttendanceMonitoring.create(vm.attendanceMonitorings, onSaveFinished);
            }
        }

        function save() {
            if (vm.attendanceMonitorings.id) {
                AttendanceMonitoring.save(vm.attendanceMonitorings, onSaveFinished);
            }
        }

    }

})();
