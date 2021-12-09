/**
 * This is the StudentInterimReports Table Directive definition.
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
        .module('StudentInterimReportsTableDirective', [])
        .directive('studentInterimReportsTable', studentInterimReportsTable);

    function studentInterimReportsTable() {
        return {
            restrict: 'E',
            scope: {
                showAll: '=?',
                showStudent: '=?',
                showIRInfo: '=?',
                showAttendanceFigures: '=?',
                showKeyAssessments: '=?',
                studentInterimReports: '=',
            },
            templateUrl: 'js/directives/student-interim-reports-table/student-interim-reports-table.html',
        };
    }
})();
