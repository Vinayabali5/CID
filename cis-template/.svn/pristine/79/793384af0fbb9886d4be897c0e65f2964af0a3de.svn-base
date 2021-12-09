/**
 * This is the LetterType Editor Directive definition.
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
        .module('LetterTypesEditorDirective', ['EntityServices'])
        .directive('letterTypesEditor', letterTypesEditor);

    function letterTypesEditor() {

        var directive = {
            restrict: 'E',
            scope: {
                letterTypes: '=?',
                showActions: '=?'
            },
            controller: 'LetterTypesEditorController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/letter-types-editor/views/letter-types-editor.html',
        };

        return directive;

    }
})();
