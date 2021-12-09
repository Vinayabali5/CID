/**
 * This is the Schools Editor Directive definition.
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
        .module('SchoolsEditorDirective', ['EntityServices'])
        .directive('schoolEditor', schoolEditor);

    function schoolEditor() {

        var directive = {
            restrict: 'E',
            scope: {
                schools: '=?',
                showActions: '=?'
            },
            controller: 'SchoolsEditorController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/schools-editor/views/school-editor.html'

        };

        return directive;

    }


})();
