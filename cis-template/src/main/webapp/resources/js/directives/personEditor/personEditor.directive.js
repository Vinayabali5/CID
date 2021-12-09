/**
 * This is the AcademicYears Editor Directive definition.
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
        .module('PersonEditorDirective', ['ui.bootstrap.modal', 'EntityServices'])
        .directive('personEditor', personEditor);

    function personEditor() {
        return {
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
            controller: 'PersonEditorController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/personEditor/views/personEditor.html',
        };
    }
})();
