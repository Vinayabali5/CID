/**
 * This is the Holiday Editor Dialog Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */


(function() {
    'use strict';

    angular
        .module('HolidaysEditorDirective')
        .controller('HolidaysEditorDialogController', HolidaysEditorDialogController);

    HolidaysEditorDialogController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModalInstance', 'Holiday', 'holidaysEntity'];

    function HolidaysEditorDialogController($log, $scope, $state, $rootScope, $uibModalInstance, Holiday, holidaysEntity) {
        /* jshint validthis:true */
        var vm = this;
        vm.holidays = holidaysEntity !== undefined ? holidaysEntity : {};

        vm.cancel = cancel;
        vm.save = save;

        var onSaveFinished = function(result) {
            $scope.$emit('holidays-saved', result);
            $uibModalInstance.close(result);
        };

        function cancel() {
            $uibModalInstance.dismiss('cancel');
        }

        function save() {
            if (vm.holidays.id) {
                Holiday.save(vm.holidays, onSaveFinished);
            } else {
                if (vm.holidays.id !== null) {
                    Holiday.create(vm.holidays, onSaveFinished);
                }
            }
        }

    }


})();
