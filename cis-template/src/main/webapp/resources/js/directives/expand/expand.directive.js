/**
 * This is the ExpandDirective Directive definition.
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
        .module('ExpandDirective', [])
        .directive('expand', ExpandDirective);

    function ExpandDirective() {
        return {
            scope: {
                visible: '=',
                expandable: '=',
                expanded: '='
            },
            controller: 'ExpandDirectiveController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/expand/expand.html',
        };
    }

})();
