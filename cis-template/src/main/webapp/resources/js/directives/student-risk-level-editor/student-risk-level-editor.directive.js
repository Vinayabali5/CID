/**
 * This is the StudentRiskLevel Editor Directive definition.
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
        .module('StudentRiskLevelEditorDirective', ['ui.bootstrap.modal', 'StudentRiskLevelService'])
        .directive('studentRiskLevelEditor', studentRiskLevelEditor);

    function studentRiskLevelEditor() {
        return {
            restrict: 'E',
            scope: {
                showAll: '=?',
                showId: '=?',
                showStudentRiskLevel: '=?',
                showStudentId: '=?',
                id: '@id',
            },
            bindToController: {
                studentRiskLevels: '=',
                studentId: '=',
            },
            controller: 'StudentRiskLevelEditorController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/student-risk-level-editor/views/student-risk-level-editor.html',
        };
    }
})();
