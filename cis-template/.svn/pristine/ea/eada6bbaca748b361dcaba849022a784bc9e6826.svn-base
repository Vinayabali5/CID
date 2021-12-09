/**
 * This is the StudentAlternativeUci Table Directive definition.
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
        .module('StudentAlternativeUciTableDirective', ['ui.bootstrap.modal'])
        .directive('studentAlternativeUciTable', studentAlternativeUciTable);

    function studentAlternativeUciTable() {
        return {
            restrict: 'E',
            scope: {
                showAll: '=?',
                showStudent: '=?',
                showActions: '=?'
            },
            bindToController: {
                studentId: '=',
                studentAlternativeUcis: '='

            },
            controller: 'StudentAlternativeUciTableController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/student-alternative-uci-table-editor/views/student-alternative-uci-table.html',

        };
    }
})();
