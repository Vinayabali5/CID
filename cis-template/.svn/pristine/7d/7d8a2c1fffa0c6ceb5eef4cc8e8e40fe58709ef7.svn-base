/**
 * This is the SupportType Editor Directive definition.
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
        .module('SupportTypesEditorDirective', ['EntityServices'])
        .directive('supportTypesEditor', supportTypesEditor);

    function supportTypesEditor() {

        var directive = {
            restrict: 'E',
            scope: {
                supportTypes: '=?',
                showActions: '=?'
            },
            controller: 'SupportTypesEditorController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/support-types-editor/views/support-types-editor.html',
        };

        return directive;

    }
})();
