/**
 * This is the ExamBoard Editor Directive definition.
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
        .module('ExamBoardsEditorDirective', ['EntityServices'])
        .directive('examBoardsEditor', examBoardsEditor);

    function examBoardsEditor() {

        var directive = {
            restrict: 'E',
            scope: {
                examBoards: '=?',
                showActions: '=?'
            },
            controller: 'ExamBoardsEditorController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/exam-boards-editor/views/exam-boards-editor.html',
        };

        return directive;

    }
})();
