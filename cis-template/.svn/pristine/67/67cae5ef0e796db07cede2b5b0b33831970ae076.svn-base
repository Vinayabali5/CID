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
        .module('StudentOptionEditorTableDirective', ['ui.bootstrap.modal', 'StudentOptionEntryService'])
        .directive('studentOptionEditorTable', studentOptionEditorTable);

    function studentOptionEditorTable() {
        return {
            restrict: 'E',
            scope: {
                showAll: '=?',
                showStudent: '=?',
                showOption: '=?',
            },
            bindToController: {
                studentId: '=?',
                studentOptionEntries: '='
            },
            controller: 'StudentOptionEditorTableController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/student-option-editor-table/views/student-option-editor-table.html',
        };
    }

})();
