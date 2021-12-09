/**
 * This is the StudentYearEditorDirective definition.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y023, Y024, Y070, Y072, Y074]
 *  
 */
(function() {
    'use strict';

    angular
        .module('StudentYearEditorDirective', ['ui.bootstrap.modal', 'EntityServices'])
        .directive('studentYearEditor', studentYearEditor);

    function studentYearEditor() {

        var directive = {
            restrict: 'E',
            scope: {
                showAll: '=?',
                showStudent: '=?',
                showYearId: '=?',
                showStudentId: '=?',
                id: '@id',
            },
            bindToController: {
                studentYear: '=',
                studentId: '=?',
                yearId: '=?',
            },
            controller: 'StudentYearEditorController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/student-year-editor/views/student-year-editor.html'
        };

        return directive;
    }
})();
