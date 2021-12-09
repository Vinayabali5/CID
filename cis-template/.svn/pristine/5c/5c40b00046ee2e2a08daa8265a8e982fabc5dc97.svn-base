/**
 * This is the StudentConcessionType Table Directive definition.
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
        .module('ConcessionsTableDirective', [])
        .directive('concessionsTable', concessionsTableDirective);

    function concessionsTableDirective() {
        var directive = {
            restrict: 'E',
            scope: {
                showAll: '@',
                showStudent: '@',
                concessions: '='
            },
            templateUrl: 'js/directives/concessions-table/concessions-table.html',
        };

        return directive;
    }
})();
