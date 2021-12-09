/**
 * This is the ExamResultsTableDirective definition.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y023, Y024, Y070, Y072, Y074]*
 *  
 *  @type Directive
 *  
 *   <Element>
 *  <exam-results-editor results="ctrl.results" show-series="true"></exam-results-editor>
    <exam-results-editor results="ctrl.results" show-all="true"></exam-results-editor>
 */
(function() {
    'use strict';

    angular
        .module('ExamResultsEditorDirective', ['EntityServices'])
        .directive('examResultsEditor', examResultsEditor);

    function examResultsEditor() {

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
            controller: 'ExamResultsEditorController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/exam-results-editor/views/exam-results-editor.html',
        };

        return directive;

    }
})();
