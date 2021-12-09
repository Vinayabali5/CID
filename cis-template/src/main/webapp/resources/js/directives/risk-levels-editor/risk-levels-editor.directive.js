/**
 * This is the RiskLevels Editor Directive definition.
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
        .module('RiskLevelsEditorDirective', ['EntityServices'])
        .directive('riskLevelsEditor', riskLevelsEditor);

    function riskLevelsEditor() {

        var directive = {
            restrict: 'E',
            scope: {
                showID: '@',
                riskLevels: '=?',
                showActions: '=?'
            },
            controller: 'RiskLevelsEditorController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/risk-levels-editor/views/risk-levels-editor.html',
        };

        return directive;

    }
})();
