/**
 * This is the ExamSeriesTableDirective definition
 */
(function() {
    angular
        .module('ExamSeriesTableDirective', ['ngResource', 'ui.bootstrap', 'EntityServices', ])
        .directive('examSeriesTable', examSeriesTableDirective);

    function examSeriesTableDirective() {
        var directive = {
            scope: {
                examSeriesList: '='
            },
            transclude: true,
            controller: 'ExamSeriesTableDirectiveController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/exams/exam-series-table/views/exam-series-table.html',
        };

        return directive;
    }
})();
