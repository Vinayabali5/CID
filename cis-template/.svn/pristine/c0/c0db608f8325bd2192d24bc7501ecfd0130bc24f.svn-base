/**
 * This is the Departments Editor Directive definition.
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
        .module('DepartmentsEditorDirective', ['EntityServices'])
        .directive('departmentsEditor', departmentsEditor);

    function departmentsEditor() {

        var directive = {
            restrict: 'E',
            scope: {
                departments: '=?',
                showActions: '=?'
            },
            controller: 'DepartmentsEditorController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/departments-editor/views/departments-editor.html',
        };

        return directive;

    }
})();
