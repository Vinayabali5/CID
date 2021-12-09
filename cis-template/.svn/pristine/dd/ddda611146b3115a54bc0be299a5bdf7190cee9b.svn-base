/**
 * This is the EntryQualificationsEditorDirective definition.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y023, Y024, Y070, Y072, Y074]*
 *
 *  @type Directive
 */
(function() {
    'use strict';

    angular
        .module('StudentEntryQualificationsEditorDirective', ['ui.bootstrap.modal', 'ui.bootstrap.datepicker'])
        .directive('studentEntryQualificationsEditor', studentEntryQualificationsEditor);

    function studentEntryQualificationsEditor() {

        var directive = {
            restrict: 'E',
            scope: {
                showAll: '=?',
                showStudent: '=?',
                showActions: '=?'
            },
            bindToController: {
                studentId: '=',
                studentEntryQualifications: '='
            },
            controller: 'StudentEntryQualificationsEditorController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/studentEntryQualificationsEditor/views/studentEntryQualificationsEditor.html'
        };

        return directive;

    }

})();
