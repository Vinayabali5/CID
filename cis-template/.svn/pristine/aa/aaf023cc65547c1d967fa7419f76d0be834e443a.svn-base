/**
 * This is the StudentLLDDHealthProblemCategory Editor Directive definition.
 *
 * The required params for this directive are the studentId and referralReasons.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y023, Y024, Y070, Y072, Y074]*
 *
 *  @type Directive
 *
 */
(function() {
    'use strict';
    angular
        .module('StudentLLDDHealthProblemCategoryEditorDirective', ['StudentLLDDHealthProblemCategoryService'])
        .directive('studentLlddHealthProblemCategoryEditor', studentLlddHealthProblemCategoryEditor);

    function studentLlddHealthProblemCategoryEditor() {

        var directive = {
            restrict: 'E',
            scope: {
                showId: '=?',
                showAll: '=?',
                showStudent: '=?',
                showStudentId: '=',
                showActions: '=?'
            },
            bindToController: {
                studentId: '=',
                llddHealthProblemCategory: '='
            },
            controller: 'StudentLLDDHealthProblemCategoryEditorDirectiveController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/student-lldd-health-problem-category-editor/views/student-lldd-health-problem-category-editor.html'
        };
        return directive;
    }
})();
