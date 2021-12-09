/**
 * This is the PossibleGradeSets Directive definition.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y023, Y024, Y070, Y072, Y074]*
 *  
 *  @type Directive
 *  
 */
(function() {
    'use strict';

    angular
        .module('PossibleGradeSetsEditorDirective', ['EntityServices'])
        .directive('possibleGradeSetsEditor', possibleGradeSetsEditor);

    possibleGradeSetsEditor.$inject = ['$log', '$uibModal'];

    function possibleGradeSetsEditor($log, $uibModal) {

        var directive = {
            restrict: 'E',
            scope: {
                possibleGradeSets: '=?',
                showActions: '=?'
            },
            controller: 'PossibleGradeSetsEditorController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/possible-grade-set-editor/views/possible-grade-sets-editor.html',
        };

        return directive;

    }
})();
