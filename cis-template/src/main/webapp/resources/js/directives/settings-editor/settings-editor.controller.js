/**
 * This is the Settings Editor Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */



(function() {
    'use strict';

    angular
        .module('SettingsEditorDirective')
        .controller('SettingsEditorController', SettingsEditorController);


    SettingsEditorController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModal', 'Settings'];

    function SettingsEditorController($log, $scope, $state, $rootScope, $uibModal, Settings) {
        /* jshint validthis:true */
        var vm = this;

        vm.editSettings = editSettings;
        vm.addSettings = addSettings;

        function editSettings(id) {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/settings-editor/views/settings-editorDialog.html',
                controller: 'SettingsEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    settingsEntity: function(Settings) {
                        return Settings.get(id).then(function(response) {
                            return response.data;
                        }, function(response) {
                            alert("Failed to retrieve");
                        });
                    }
                }
            });
        }

        function addSettings() {
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/settings-editor/views/settings-editorDialog.html',
                controller: 'SettingsEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    settingsEntity: function() {
                        var settings = {};
                        return settings;
                    }
                }
            });
        }

    }

})();
