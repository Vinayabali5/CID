/**
 * This is the RiskAssessmentEditorDirective definition.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y023, Y024, Y070, Y072, Y074]*
 *
 *  @type Directive
 */
(function() {
    'use strict';

    angular
        .module('StudentRiskAssessmentEditorDirective', ['ui.bootstrap.modal'])
        .directive('studentRiskAssessmentEditor', studentRiskAssessmentEditor);

    function studentRiskAssessmentEditor() {

        var directive = {
            restrict: 'E',
            scope: {
                showAll: '=?',
                showStudent: '=?',
                showActions: '=?',
                studentId: '=',
                studentRiskAssessment: '='
            },
            controller: 'StudentRiskAssessmentEditorController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/student-risk-assessment-editor/views/student-risk-assessment-editor.html'
        };

        return directive;

    }

})();
