/**
 * This is the Periods Editor Directive definition.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y023, Y024, Y070, Y072, Y074]*
 *  
 *  @type Directive
 *  
 */

(function() {
    'use strict';

    angular
        .module('PeriodsEditorDirective', ['EntityServices'])
        .directive('periodsEditor', periodsEditor);

    function periodsEditor() {

        var directive = {

            restrict: 'E',
            scope: {
                periods: '=?',
                showActions: '=?'
            },
            controller: 'PeriodsEditorController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/periods-editor/views/periods-editor.html',

        };

        return directive;

    }

})();
