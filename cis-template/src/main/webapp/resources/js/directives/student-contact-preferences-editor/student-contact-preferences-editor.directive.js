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
        .module('StudentContactPreferencesEditorDirective', ['ui.bootstrap.modal', 'EntityServices'])
        .directive('studentContactPreferencesEditor', studentContactPreferencesEditor);

    function studentContactPreferencesEditor() {
        return {
            restrict: 'E',
            scope: {
                showAll: '=?',
                showStudent: '=?',
                showStudentId: '=?',
                id: '@id',
            },
            bindToController: {
                student: '=',
                studentId: '=?'
            },
            controller: 'StudentContactPreferencesEditorController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/student-contact-preferences-editor/views/student-contact-preferences-editor.html',
        };
    }
})();
