/**
 * This is the PersonCardEditorDirective definition.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y023, Y024, Y070, Y072, Y074]
 *  
 */
(function() {
    'use strict';

    angular
        .module('PersonCardEditorDirective', ['ui.bootstrap.modal', 'EntityServices'])
        .directive('personCardEditor', personCardEditor);

    function personCardEditor() {

        var directive = {
            restrict: 'E',
            scope: {
                showAll: '=?',
                person: '=',
                id: '@id',
            },
            bindToController: {
                person: '=',
                personId: '=',
            },
            controller: 'PersonCardEditorController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/person-card-editor/views/person-card-editor.html'
        };

        return directive;
    }
})();
