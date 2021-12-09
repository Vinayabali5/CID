/**
 * This is the StudentLearningSupport Details Directive definition.
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
        .module('StudentLearningSupportDetailsDirective', [
            'ConcessionsTableDirective'
        ])
        .directive('studentLearningSupportDetails', studentLearningSupportDetails);

    function studentLearningSupportDetails() {
        return {
            restrict: 'E',
            scope: {
                showAll: '=?',
                showStudent: '=?',
                studentLearningSupport: '=',
            },
            templateUrl: 'js/directives/student-learning-support-details/student-learning-support-details.html',
        };
    }
})();
