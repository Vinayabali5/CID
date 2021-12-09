/**
 * This is the PossibleGrades Directive definition.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y023, Y024, Y070, Y072, Y074]*
 *  
 *  @type Directive
 *  
 */
(function() {
    'use strict';

    angular
        .module('PossibleGradesEditorDirective', ['EntityServices'])
        .directive('possibleGradesEditor', possibleGradesEditor);

    function possibleGradesEditor() {

        var directive = {
            restrict: 'E',
            scope: {
                possibleGrades: '=?',
                showActions: '=?'
            },
            controller: 'PossibleGradesEditorController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/possible-grades-editor/views/possible-grades-editor.html',
        };

        return directive;

    }
})();
