/**
 * This is the MyInterimReportsTableDirective definition.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y023, Y024, Y070, Y072, Y074]*
 *
 */

(function() {
    'use strict';

    angular
        .module('MyInterimReportsTableDirective', ['EntityServices'])
        .directive('myInterimReportsTable', myInterimReportsTable);

    function myInterimReportsTable() {

        var directive = {
            restrict: 'E',
            scope: {
                interimReports: '=',
                filterParams: '=?',
            },
            templateUrl: 'js/directives/my-interim-reports-table/my-interim-reports-table.html',
        };

        return directive;
    }
})();
