/**
 * This is the StudentConcession Table Directive definition.
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
        .module('StudentConcessionTableDirective', [])
        .directive('studentConcessionTable', studentConcessionTable);

    function studentConcessionTable() {
        return {
            restrict: 'E',
            scope: {
                showAll: '=?',
                showStudent: '=?',
                showCourseDescription: '=?',
                concessions: '='
            },
            link: function(scope, elem, attr) {
                if (scope.showCourseDescription == undefined) {
                    scope.showCourseDescription = true;
                }
            },
            templateUrl: 'js/directives/student-concession-table/student-concession-table.html',
        };
    }
})();
