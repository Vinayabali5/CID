/**
 * This is the StudentCourseConcession Editor Directive definition.
 *
 * The required params for this directive are the studentId and concessions.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y023, Y024, Y070, Y072, Y074]*
 *
 *  @type Directive
 *
 */
(function() {
    'use strict';
    angular
        .module('StudentConcessionEditorDirective', ['StudentCourseConcessionService'])
        .directive('studentConcessionEditor', studentConcessionEditor);

    function studentConcessionEditor() {
        return {
            restrict: 'E',
            scope: {
                showAll: '=?',
                showStudent: '=?',
                showCourseDescription: '=?',
                studentId: '=',
                concessions: '=',
                showActions: '=?'
            },
            link: function(scope, elem, attr) {
                if (scope.showCourseDescription == undefined) {
                    scope.showCourseDescription = true;
                }
            },
            controller: 'StudentConcessionEditorDirectiveController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/student-concession-editor/views/student-concession-editor.html',
        };
    }
})();
