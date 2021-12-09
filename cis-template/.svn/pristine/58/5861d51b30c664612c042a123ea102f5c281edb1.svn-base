/**
 * This is the Registers Table Directive definition.
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
        .module('RegistersTableDirective', [])
        .directive('registersTable', registersTable);

    function registersTable() {
        return {
            restrict: 'E',
            scope: {
                showAll: '=?',
                showStudentRef: '=?',
                showSessionRef: '=?',
                registers: '=',
            },
            templateUrl: 'js/directives/registersTable/registersTable.html',
            controller: 'RegistersTableController',
            controllerAs: 'ctrl'
        };
    }
})();
