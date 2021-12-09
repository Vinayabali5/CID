/**
 * This is the InterimReportsEditorDirective definition.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y023, Y024, Y070, Y072, Y074]*
 *
 *  @type Directive
 */
(function() {
    'use strict';

    angular
        .module('StudentInterimReportsEditorDirective', ['ui.bootstrap.modal', 'ui.bootstrap.datepicker'])
        .directive('studentInterimReportsEditor', studentInterimReportsEditor);

    function studentInterimReportsEditor() {

        var directive = {
            restrict: 'E',
            scope: {
                showAll: '=?',
                showStudent: '=?',
                showIRInfo: '=?',
                showAttendanceFigures: '=?',
                showKeyAssessments: '=?',
                studentInterimReports: '=',
                showActions: '=?'
            },
            bindToController: {
                studentId: '=',
                studentInterimReports: '='
            },
            controller: 'StudentInterimReportsEditorController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/student-interim-reports-editor/views/student-interim-reports-editor.html'
        };

        return directive;

    }

})();
