/**
 * This is the PersonNotes Editor Directive definition.
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
        .module('PersonNotesEditorDirective', ['EntityServices'])
        .directive('personNotesEditor', personNotesEditor);

    function personNotesEditor() {

        var directive = {
            restrict: 'E',
            scope: {
                showAll: '=?',
                showId: '=?',
                personId: '=',
                notes: '=',
                showActions: '=?',
                allowDelete: '=?'
            },
            controller: 'PersonNotesEditorController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/person-notes-editor/views/person-notes-editor.html',
        };

        return directive;

    }
})();
