/**
 * This is the SpecialCategories Editor Directive definition.
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
        .module('SpecialCategoriesEditorDirective', ['EntityServices'])
        .directive('specialCategoriesEditor', specialCategoriesEditor);

    function specialCategoriesEditor() {

        var directive = {
            restrict: 'E',
            scope: {
                specialCategories: '=?',
                showActions: '=?'
            },
            controller: 'SpecialCategoriesEditorController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/special-categories-editor/views/special-categories-editor.html',
        };

        return directive;

    }
})();
