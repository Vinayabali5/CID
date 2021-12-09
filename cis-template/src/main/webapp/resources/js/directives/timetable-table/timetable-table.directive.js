/**
 * This directive, is used to display Timetable Table
 *
 * Applied Styles: [Y001, Y002, Y010, Y020, Y021, Y022, Y023, Y024, Y070, Y074, Y075, ]
 *
 */


(function() {
    'use strict';
    angular
        .module('TimetableTableDirective', [])
        .directive('timetableTable', timetableTable);

    function timetableTable() {

        var directive = {
            restrict: 'E',
            scope: {
                showAll: '=?',
                showTeacher: '=?',
                showRoom: '=?',
                showTimes: '=?',
                showValidity: '=?',
                timetable: '=',
            },
            link: function(scope, element, attrs, ctrl) {
                if (attrs.showTeacher === undefined) {
                    scope.showTeacher = true;
                }
                if (attrs.showRoom === undefined) {
                    scope.showRoom = true;
                }
                if (attrs.showTimes === undefined) {
                    scope.showTimes = true;
                }
                if (attrs.showValidity === undefined) {
                    scope.showValidity = false;
                }
            },
            templateUrl: 'js/directives/timetable-table/timetable-table.html',
        };
        return directive;
    }

})();
