/**
 * This directive is used to display a table of Enrolments Table.
 *
 * Applied Styles:
 *
 * @type Directive
 */

(function() {
    'use strict';

    angular
        .module('EnrolmentsTableDirective', [
            'tableSort',
            'EntityServices'
        ])
        .directive('enrolmentsTable', enrolmentsTableDirective);

    function enrolmentsTableDirective() {

        var directive = {
            restrict: 'E',
            scope: {
                showId: '=?',
                showStudent: '=?',
                showYear: '=?',
                showStatus: '=?',
                showMonitoring: '=?',
                showCourse: '=?',
                showCourseGroup: '=?',
                showActions: '=?',
                showIlr: '=?',
                showAll: '=?',
                enrolments: '=',
            },
            templateUrl: 'js/directives/enrolments-table/enrolments-table.html',
        };

        return directive;

    }
})();
