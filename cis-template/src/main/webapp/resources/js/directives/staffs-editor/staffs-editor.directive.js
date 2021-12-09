/**
 * This is the Staffs Editor Directive definition.
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
        .module('StaffsEditorDirective', ['EntityServices'])
        .directive('staffsEditor', staffsEditor);

    function staffsEditor() {

        var directive = {
            restrict: 'E',
            scope: {
                staffList: '=',
                showActions: '=?'
            },
            controller: 'StaffsEditorController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/staffs-editor/views/staffs-editor.html',
        };

        return directive;

    }
})();
