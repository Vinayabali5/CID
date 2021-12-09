/**
 * This is the StatementBank Editor Directive definition.
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
        .module('StatementBanksEditorDirective', ['EntityServices'])
        .directive('statementBanksEditor', statementBanksEditor);

    function statementBanksEditor() {

        var directive = {
            restrict: 'E',
            scope: {
                statementBanks: '=?',
                showActions: '=?'
            },
            controller: 'StatementBanksEditorController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/statement-banks-editor/views/statement-banks-editor.html',
        };

        return directive;

    }
})();
