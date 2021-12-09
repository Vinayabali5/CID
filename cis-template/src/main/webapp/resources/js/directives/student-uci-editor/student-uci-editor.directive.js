/**
 * This is the StudentUciEditorDirective definition.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y023, Y024, Y070, Y072, Y074]
 *  
 */
(function() {
    'use strict';

    angular
        .module('StudentUciEditorDirective', ['ui.bootstrap.modal', 'EntityServices'])
        .directive('studentUciEditor', studentUciEditor);

    function studentUciEditor() {

        var directive = {
            restrict: 'E',
            scope: {
                showAll: '=?',
                showStudent: '=?',
                showStudentId: '=?',
                id: '@id',
            },
            bindToController: {
                student: '=',
                studentId: '=?',
            },
            controller: 'StudentUciEditorController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/student-uci-editor/views/student-uci-editor.html'
        };

        return directive;
    }
})();
