/**
 * This is the StatementBankType Editor Directive definition.
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
        .module('StatementBankTypesEditorDirective', ['EntityServices'])
        .directive('statementBankTypesEditor', statementBankTypesEditor);

    function statementBankTypesEditor() {

        var directive = {
            restrict: 'E',
            scope: {
                statementBankTypes: '=?',
                showActions: '=?'
            },
            controller: 'StatementBankTypesEditorController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/statement-bank-types-editor/views/statement-bank-types-editor.html',
        };

        return directive;

    }
})();
