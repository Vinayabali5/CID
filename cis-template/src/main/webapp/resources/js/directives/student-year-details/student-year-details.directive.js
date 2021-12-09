/**
 * This is the StudentYearDetailsDirective definition.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y023, Y024, Y070, Y072, Y074]
 *
 */

(function() {
    'use strict';

    angular
        .module('StudentYearDetailsDirective', ['EntityServices'])
        .directive('studentYearDetails', studentYearDetails);

    studentYearDetails.$inject = [];

    function studentYearDetails() {
        var directive = {
            restrict: 'E',
            scope: {
                showAll: '=?',
            },
            bindToController: {
                studentYear: '=',
            },
            controller: 'StudentYearDetailsDirectiveController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/student-year-details/student-year-details.html',
            transclude: true,
        };

        return directive;
    }
})();
