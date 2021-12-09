/**
 * This is the EntryQualificationType Editor Directive definition.
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
        .module('EntryQualificationTypesEditorDirective', ['EntityServices'])
        .directive('entryQualificationTypesEditor', entryQualificationTypesEditor);

    function entryQualificationTypesEditor() {

        var directive = {
            restrict: 'E',
            scope: {
                entryQualificationTypes: '=?',
                showActions: '=?'
            },
            controller: 'EntryQualificationTypesEditorController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/entry-qualification-types-editor/views/entry-qualification-types-editor.html',
        };

        return directive;

    }
})();
