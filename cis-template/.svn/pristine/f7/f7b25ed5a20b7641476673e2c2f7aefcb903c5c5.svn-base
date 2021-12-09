/**
 * This is the CourseGroupsTableDirective definition.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y023, Y024, Y070, Y072, Y074]
 *
 * @example <course-groups-table course-groups="{ ctrl.courseGroupList }"></course-groups-table>
 */
(function() {
    'use strict';

    angular
        .module('CourseGroupsTableDirective', ['EntityServices'])
        .directive('courseGroupsTable', courseGroupsTable);

    function courseGroupsTable() {
        var directive = {
            restrict: 'E',
            scope: {
                showId: '=?',
                showYearGroup: '=?',
                showYear: '=?',
                showDepartment: '=?',
                showDates: '=?',
                showEnrolmentInfo: '=?',
                showActions: '=?',
                showAll: '=?',
                includeReports: '=?',
                includeLink: '=?',
                courseGroups: '=',
                filterParams: '=?'

            },
            link: function(scope, element, attrs) {
                if (attrs.showDates === undefined) {
                    scope.showDates = true;
                }
                if (attrs.showDepartment === undefined) {
                    scope.showDepartment = true;
                }
                if (attrs.includeLink === undefined) {
                    scope.includeLink = false;
                }
            },
            templateUrl: 'js/directives/course-groups-table/course-groups-table.html',
        };
        return directive;
    }
})();
