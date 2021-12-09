/**
 * This is the AcademicYears Editor Directive definition.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y023, Y024, Y070, Y072, Y074]*
 *
 *  @type Directive
 *
 *
 *   */
(function() {
    'use strict';

    angular
        .module('SettingsEditorDirective', ['ui.bootstrap.modal'])
        .directive('settingsEditor', settingsEditor);

    function settingsEditor() {

        var directive = {
            restrict: 'E',
            scope: {
                settings: '=?',
                showActions: '=?'
            },
            templateUrl: 'js/directives/settings-editor/views/setting-editor.html',
            controller: 'SettingsEditorController',
            controllerAs: 'ctrl'
        };

        return directive;

    }


})();
