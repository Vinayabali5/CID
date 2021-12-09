/**
 * This is the StudentSpecialCategory Editor Directive definition.
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
        .module('StudentSpecialCategoryEditorDirective', ['ui.bootstrap.modal'])
        .directive('studentSpecialCategoryEditor', studentSpecialCategoryEditor);

    function studentSpecialCategoryEditor() {
        return {
            restrict: 'E',
            scope: {
                showAll: '=?',
                showId: '=?',
                showStudentSpecialCategory: '=?',
                showStudentId: '=?',
                id: '@id',
            },
            bindToController: {
                specialCategories: '=',
                studentId: '=',
            },
            controller: 'StudentSpecialCategoryEditorController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/studentSpecialCategoryEditor/views/studentSpecialCategoryEditor.html',
        };
    }
})();
