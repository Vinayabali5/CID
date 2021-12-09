/**
 * This is the ExamResultsTableDirective definition.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y023, Y024, Y070, Y072, Y074]*
 *  
 *  @type Directive
 *  
 */
(function() {
    'use strict';

    angular
        .module('RolesEditorDirective', ['EntityServices'])
        .directive('rolesEditor', rolesEditor);

    function rolesEditor() {

        var directive = {
            restrict: 'E',
            scope: {
                roles: '=?',
                showActions: '=?'
            },
            controller: 'RolesEditorController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/roles-editor/views/roles-editor.html',
        };

        return directive;

    }
})();
