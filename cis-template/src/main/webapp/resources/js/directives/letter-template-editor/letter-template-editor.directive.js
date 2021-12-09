/**
 * This is the Letter Template Editor Directive definition.
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
        .module('LetterTemplateEditorDirective', ['EntityServices', 'ngCkeditor'])
        .directive('letterTemplateEditor', letterTemplateEditor);

    function letterTemplateEditor() {

        var directive = {
            restrict: 'E',
            templateUrl: 'js/directives/letter-template-editor/views/letter-template-editor.html',
            scope: {
                letterTemplates: '=',
                showActions: '=?'
            },
            controller: 'LetterTemplateEditorController',
            controllerAs: 'ctrl'
        };

        return directive;

    }

})();
