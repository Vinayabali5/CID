/**
 * This is the ExamSeries Editor Directive definition.
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
        .module('ExamSeriesEditorDirective', ['EntityServices'])
        .directive('examSeriesEditor', examSeriesEditor);

    function examSeriesEditor() {

        var directive = {
            restrict: 'E',
            scope: {
                examSeries: '=?',
                showActions: '=?'
            },
            controller: 'ExamSeriesEditorController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/exam-series-editor/views/exam-series-editor.html',
        };

        return directive;

    }
})();
