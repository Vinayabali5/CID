/**
 * This is the StudentCourseSupportType Editor Directive definition.
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
        .module('StudentCourseSupportTypesEditorDirective', ['ui.bootstrap.modal', 'ui.bootstrap.datepicker'])
        .directive('studentCourseSupportTypesEditor', studentCourseSupportTypesEditor);

    function studentCourseSupportTypesEditor() {
        var directive = {
            restrict: 'E',
            scope: {
                showAll: '=?',
                showStudent: '=?',
                studentCourseSupportTypes: '=',
                studentId: '=',
                showActions: '=?'
            },
            bindToController: {
                studentId: '=',
                studentCourseSupportTypes: '='
            },
            controller: 'StudentCourseSupportTypesEditorDirectiveController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/student-course-support-types-editor/views/student-course-support-types-editor.html',
        };

        return directive;
    }

})();
