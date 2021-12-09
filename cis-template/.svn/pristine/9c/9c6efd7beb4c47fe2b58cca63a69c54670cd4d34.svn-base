/**
 * This is the requestEditorDirective definition.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y023, Y024, Y070, Y072, Y074]
 *
 * @example
 */
(function() {
    'use strict';

    angular
        .module('CourseRequestEditorDirective', ['ui.bootstrap.modal'])
        .directive('courseRequestEditor', courseRequestEditor);

    function courseRequestEditor() {
        return {
            restrict: 'E',
            scope: {
                showAll: '=?',
                showStudent: '=?',
                showActions: '=?',
            },
            bindToController: {
                studentId: '=',
                request: '='
            },
            controller: 'CourseRequestEditorController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/admissions/course-request-editor/course-request-editor.html',
        };
    }
})();
