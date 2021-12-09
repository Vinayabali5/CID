/**
 * This is the StudentWarningDetails Directive definition.
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
        .module('StudentWarningDetailsDirective', ['EntityServices'])
        .directive('studentWarningDetails', studentWarningDetails);

    function studentWarningDetails() {
        return {
            restrict: 'E',
            scope: {
                // showAll: '=?',
                studentWarning: '=',
            },
            templateUrl: 'js/directives/studentWarningDetails/studentWarningDetails.html',
        };
    }
})();
