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
        .module('ILPLetterEditorDirective', ['EntityServices', 'ngCkeditor'])
        .directive('ilpLetterEditor', ilpLetterEditor);

    function ilpLetterEditor() {

        var directive = {
            restrict: 'E',
            scope: {
                showId: '=?',
                showYear: '=?',
                letters: '=?',
                showAll: '=?',
                showActions: '=?'
            },
            controller: 'ILPLetterEditorController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/ilp-letter-editor/views/ilp-letter-editor.html',
        };
        return directive;
    }
})();
