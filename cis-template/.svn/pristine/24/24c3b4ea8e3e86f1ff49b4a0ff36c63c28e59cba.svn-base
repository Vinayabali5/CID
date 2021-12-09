/**
 * This is the CoursesTableDirective definition.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y023, Y024, Y070, Y072, Y074]*
 *
 */

(function() {
    'use strict';

    angular
        .module('CoursesTableDirective', ['EntityServices'])
        .directive('coursesTable', coursesTable);

    function coursesTable() {

        var directive = {
            restrict: 'E',
            scope: {
                courses: '=',
                showId: '=?',
                showExamBoard: '=?',
                showYear: '=?',
                showDetails: '=?',
                showAll: '=?',
                showReports: '=?',
                showActions: '=?',
                filterParams: '=?',
            },
            templateUrl: 'js/directives/courses-table/courses-table.html',
        };

        return directive;
    }
})();
