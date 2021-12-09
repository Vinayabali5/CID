/**
 * This is the ExamResultsTableDirective definition.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y023, Y024, Y070, Y072, Y074]*
 *
 *  @type Directive
 */
(function() {
    'use strict';

    angular
        .module('ExamResultsTableDirective', ['EntityServices'])
        .directive('examResultsTable', examResultsTable);

    function examResultsTable() {
        var directive = {
            restrict: 'E',
            scope: {
                showStudent: '=?',
                showYear: '=?',
                showBoard: '=?',
                showSeries: '=?',
                showAll: '=?',
                results: '=?',
            },
            templateUrl: 'js/directives/exam-results-table/exam-results-table.html',
        };

        return directive;
    }

})();
