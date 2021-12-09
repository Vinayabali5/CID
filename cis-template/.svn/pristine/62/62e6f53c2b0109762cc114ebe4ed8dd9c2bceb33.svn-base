/**
 * This is the BlocksTableDirective definition.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y023, Y024, Y070, Y072, Y074]*
 *  
 *  @type Directive
 *  
 */
(function() {
    'use strict';

    angular
        .module('BlocksEditorDirective', ['EntityServices'])
        .directive('blocksEditor', blocksEditor);

    function blocksEditor() {

        var directive = {
            restrict: 'E',
            scope: {
                blocks: '=?',
                showActions: '=?'
            },
            controller: 'BlocksEditorController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/blocks-editor/views/blocks-editor.html',
        };

        return directive;

    }
})();
