/**
 * This is the StudentRiskLevel Directive definition.
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
        .module('StudentRiskLevelDetailsDirective', ['EntityServices'])
        .directive('studentRiskLevelDetails', studentRiskLevelDetails);

    function studentRiskLevelDetails() {
        return {
            restrict: 'E',
            scope: {
                showAll: '=?',
                studentRiskLevels: '=',
            },
            controller: 'StudentRiskLevelDetailsDirectiveController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/student-risk-level-details/student-risk-level-details.html',
        };
    }
})();
