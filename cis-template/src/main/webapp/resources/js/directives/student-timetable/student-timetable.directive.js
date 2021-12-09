/**
 * This is the StudentTimetable Directive definition.
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
        .module('StudentTimetableDirective', [])
        .directive('studentTimetable', studentTimetable);

    function studentTimetable() {
        return {
            restrict: 'E',
            scope: {},
            bindToController: {
                studentId: '=',
            },
            controller: 'StudentTimetableController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/student-timetable/views/student-timetable.html',
        };
    }
})();
