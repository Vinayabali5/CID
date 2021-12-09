/**
 * This is the StudentSafetyPlan Viewer Directive definition.
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
        .module('StudentSafetyPlanViewerDirective', [])
        .directive('studentSafetyPlanViewer', studentSafetyPlanViewer);

    function studentSafetyPlanViewer() {

        var directive = {
            restrict: 'E',
            scope: {
                showAll: '=?',
                showStudent: '=?',
                studentSafetyPlan: '=?',
            },
            templateUrl: 'js/directives/student-safety-plan-viewer/student-safety-plan-viewer.html'
        };

        return directive;
    }
})();
