/**
 * This is the SafetyPlanEditorDirective definition.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y023, Y024, Y070, Y072, Y074]*
 *
 *  @type Directive
 */
(function() {
    'use strict';

    angular
        .module('StudentSafetyPlanEditorDirective', ['ui.bootstrap.modal'])
        .directive('studentSafetyPlanEditor', studentSafetyPlanEditor);

    function studentSafetyPlanEditor() {

        var directive = {
            restrict: 'E',
            scope: {
                showAll: '=?',
                showStudent: '=?',
                studentId: '=',
                studentSafetyPlan: '='
            },
            bindToController: {
                studentId: '=',
                studentSafetyPlan: '='
            },
            controller: 'StudentSafetyPlanEditorController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/student-safety-plan-editor/views/student-safety-plan-editor.html'
        };

        return directive;

    }

})();
