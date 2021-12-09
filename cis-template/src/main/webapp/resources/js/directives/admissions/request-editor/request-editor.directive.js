/**
 * This is the requestEditorDirective definition.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y023, Y024, Y070, Y072, Y074]
 *
 * @example
 */
(function() {
    'use strict';

    angular
        .module('RequestEditorDirective', ['ui.bootstrap.modal'])
        .directive('requestEditor', requestEditor);

    function requestEditor() {
        return {
            restrict: 'E',
            scope: {
                showAll: '=?',
                showStudent: '=?',
                showActions: '=?'
            },
            bindToController: {
                studentId: '=',
                request: '='
            },
            controller: 'RequestEditorController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/admissions/request-editor/views/request-editor.html',
        };
    }
})();
