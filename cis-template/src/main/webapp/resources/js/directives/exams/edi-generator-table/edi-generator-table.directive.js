/**
 * This is the ExamSeriesTableDirective definition
 */
(function() {
    angular
        .module('cid.exams.EDIGeneratorTableDirective', ['ngResource', 'ui.bootstrap', 'EntityServices', ])
        .directive('ediGeneratorTable', ediGeneratorTableDirective);

    function ediGeneratorTableDirective() {
        var directive = {
            scope: {
                examSeriesList: '='
            },
            controller: 'EDIGeneratorTableDirectiveController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/exams/edi-generator-table/views/edi-generator-table.html',
        };

        return directive;
    }
})();
