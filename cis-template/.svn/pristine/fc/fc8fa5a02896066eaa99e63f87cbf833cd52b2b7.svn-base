/**
 * This is the TextLookup Editor Directive definition.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y023, Y024, Y070, Y072, Y074]*
 *
 *  <text-look-up-editor text-look-ups="ctrl.textLookups"></text-look-up-editor>
 *
 *  @type Directive
 *
 *
 *   */
(function() {
    'use strict';

    angular
        .module('TextLookupEditorDirective', ['ui.tinymce', 'TextLookupService'])
        .directive('textLookupEditor', textLookupEditor);

    function textLookupEditor() {
        var directive = {
            restrict: 'E',
            scope: {
                textLookups: '=?',
                showActions: '=?'
            },
            controller: 'TextLookupEditorController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/text-lookup-editor/views/text-lookup-editor.html',
        };

        return directive;
    }
})();
