/**
 * This is the Student Admissions Details Editor Directive definition.
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
        .module('StudentAdmissionsDetailsDirective', ['EntityServices'])
        .directive('studentAdmissionsDetails', studentAdmissionsDetails);

    function studentAdmissionsDetails() {
        return {
            restrict: 'E',
            scope: {
                showAll: '=?',
            },
            bindToController: {
                studentAdmissions: '=',
            },
            controller: 'StudentAdmissionsDetailsDirectiveController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/student-admissions-details/student-admissions-details.html',
            transclude: true,
        };
    }
})();
