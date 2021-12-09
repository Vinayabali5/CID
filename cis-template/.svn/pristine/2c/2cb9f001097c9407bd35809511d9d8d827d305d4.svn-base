/**
 * This is the StudentSummaryEditorDirective definition.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y023, Y024, Y070, Y072, Y074]
 *
 */
(function() {
    'use strict';

    angular
        .module('StudentSummaryEditorDirective', ['ui.bootstrap.modal', 'StudentService'])
        .directive('studentSummaryEditor', studentSummaryEditor);

    studentSummaryEditor.$inject = [];

    function studentSummaryEditor() {
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
                studentId: '=?'
            },
            controller: 'StudentSummaryEditorController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/student-summary-editor/views/student-summary-editor.html',

        };
        return directive;
    }
})();
