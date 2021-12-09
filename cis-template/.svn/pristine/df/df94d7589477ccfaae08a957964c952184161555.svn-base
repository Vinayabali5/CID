/**
 * This is the AcademicYears Editor Directive definition.
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
        .module('StudentDetailsDirective', ['EntityServices'])
        .directive('studentDetails', studentDetails);

    function studentDetails() {
        return {
            restrict: 'E',
            scope: {
                showAll: '=?',
                showDob: '=?',
                showGender: '=?',
                student: '=?',
            },
            bindToController: {
                studentId: '=?',
            },
            controller: 'StudentDetailsDirectiveController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/student-details/student-details.html',
            transclude: true,
        };
    }
})();
