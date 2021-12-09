/**
 * This is the StudentOverallAttendance Details Directive definition.
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
        .module('StudentOverallAttendanceDetailsDirective', [])
        .directive('studentOverallAttendanceDetails', studentOverallAttendanceDetails);

    function studentOverallAttendanceDetails() {
        return {
            restrict: 'E',
            scope: {
                showAll: '=?',
                showStudent: '=?',
                studentOverallAttendance: '=',
            },
            templateUrl: 'js/directives/student-overall-attendance-details/student-overall-attendance-details.html',
        };

    }
})();
