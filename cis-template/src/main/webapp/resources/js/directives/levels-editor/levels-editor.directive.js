/**
 * This is the Levels Editor Directive definition.
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
        .module('LevelsEditorDirective', ['EntityServices'])
        .directive('levelsEditor', levelsEditor);

    function levelsEditor() {

        var directive = {
            restrict: 'E',
            scope: {
                levels: '=?',
                showActions: '=?'
            },
            controller: 'LevelsEditorController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/levels-editor/views/levels-editor.html',
        };

        return directive;

    }
})();
