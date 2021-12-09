/**
 * This is the Settings Editor Dialog Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';

    angular
        .module('SettingsEditorDirective')
        .controller('SettingsEditorDialogController', SettingsEditorDialogController);

    SettingsEditorDialogController.$inject = ['settingsEntity', '$uibModalInstance', '$uibModal', 'Settings', '$scope'];

    function SettingsEditorDialogController(settingsEntity, $uibModalInstance, $uibModal, Settings, $scope) {
        /* jshint validthis:true */
        var vm = this;

        vm.settings = settingsEntity !== undefined ? settingsEntity : {};

        vm.save = save;
        vm.cancel = cancel;


        function onSaveFinished(result) {
            $scope.$emit('settings-saved', result);
            $uibModalInstance.close(result);
        }


        function save() {
            if (vm.settings.id) {
                Settings.save(vm.settings, onSaveFinished);
            } else {
                if (vm.settings.id !== null) {
                    Settings.create(vm.settings, onSaveFinished);
                }
            }
        }

        function cancel() {
            $uibModalInstance.dismiss("cancel");
        }

    }




})();
