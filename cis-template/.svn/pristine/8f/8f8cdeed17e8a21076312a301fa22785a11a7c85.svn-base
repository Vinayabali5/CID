/**
 * This is the Course Editor Directive definition.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y023, Y024, Y070, Y072, Y074]
 *  
 */

(function() {
    'use strict';

    angular
        .module('CourseEditorDirective', ['ui.bootstrap.modal', 'EntityServices'])
        .directive('courseEditor', courseEditor);

    function courseEditor() {

        var directive = {

            restrict: 'E',
            scope: {
                showAll: '=?',
                showCourse: '=?',
            },
            bindToController: {
                course: '=',
            },
            controller: 'CourseEditorController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/course-editor/views/course-editor.html',
        };
        return directive;
    }

})();
