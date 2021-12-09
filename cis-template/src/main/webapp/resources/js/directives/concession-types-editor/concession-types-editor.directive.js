/**
 * This is the ConcessionType Editor Directive definition.
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
        .module('ConcessionTypesEditorDirective', ['EntityServices'])
        .directive('concessionTypesEditor', concessionTypesEditor);

    function concessionTypesEditor() {

        var directive = {
            restrict: 'E',
            scope: {
                concessionTypes: '=?',
                showActions: '=?'
            },
            controller: 'ConcessionTypesEditorController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/concession-types-editor/views/concession-types-editor.html',
        };

        return directive;

    }
})();
