/**
 * This is the Faculties Editor Directive definition.
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
        .module('FacultiesEditorDirective', ['EntityServices'])
        .directive('facultiesEditor', facultiesEditor);

    function facultiesEditor() {

        var directive = {
            restrict: 'E',
            scope: {
                faculties: '=?',
                showActions: '=?'
            },
            controller: 'FacultiesEditorController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/faculties-editor/views/faculties-editor.html',
        };

        return directive;

    }
})();
