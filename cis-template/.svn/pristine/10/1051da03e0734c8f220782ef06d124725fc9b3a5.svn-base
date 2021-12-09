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
        .module('StudentConcessionTypeTableDirective', ['EntityServices'])
        .directive('studentConcessionTypeTable', studentConcessionTypeTable);

    function studentConcessionTypeTable() {
        return {
            restrict: 'E',
            scope: {
                showAll: '=?',
                showStudent: '=?',
                studentId: '='
            },
            controller: 'StudentConcessionTypeTableDirectiveController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/student-concession-type-table/student-concession-type-table.html',
        };
    }
})();
