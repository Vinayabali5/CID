/**
 * This is the StudentImage Directive definition.
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
        .module('StudentImageDirective', [])
        .directive('studentImage', studentImage);

    studentImage.$inject = [];

    function studentImage() {
        return {
            restrict: 'E',
            scope: {
                studentId: '=',
            },
            controller: 'StudentImageDirectiveController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/student-image/student-image.html',
        };
    }
})();
