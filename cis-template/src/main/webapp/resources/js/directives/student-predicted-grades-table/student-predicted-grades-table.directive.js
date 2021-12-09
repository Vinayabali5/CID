/**
 * This is the StudentPredictedGradesTableDirective definition.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y023, Y024, Y070, Y072, Y074]*
 * 
 *  @type Directive
 */


(function() {
    'use strict';

    angular
        .module('StudentPredictedGradesTableDirective', [])
        .directive('studentPredictedGradesTable', studentPredictedGradesTable);

    function studentPredictedGradesTable() {

        var directive = {
            restrict: 'E',
            scope: {
                showAll: '=?',
                showStudent: '=?',
                studentPredictedGrades: '=?',
            },
            templateUrl: 'js/directives/student-predicted-grades-table/student-predicted-grades-table.html'
        };

        return directive;
    }
})();
