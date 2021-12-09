/**
 * This is the AcademicYears Editor Directive definition.
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
        .module('AcademicYearsEditorDirective', ['EntityServices'])
        .directive('academicYearsEditor', academicYearsEditor);

    function academicYearsEditor() {

        var directive = {
            restrict: 'E',
            scope: {
                showID: '@',
                academicYears: '=?',
                showActions: '=?'
            },
            controller: 'AcademicYearsEditorController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/academic-years-editor/views/academic-years-editor.html',
        };

        return directive;

    }
})();
