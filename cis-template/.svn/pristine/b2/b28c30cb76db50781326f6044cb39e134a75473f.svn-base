/**
 * This is the NoteTable Directive definition.
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
        .module('NoteTableDirective', ['ngResource', 'ui.bootstrap', 'NoteService'])
        .directive('noteTable', noteTable);

    function noteTable() {
        return {
            scope: {
                noteList: '=',
            },
            transclude: true,
            controller: 'NoteTableDirectiveController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/notes-table/note-table.html'
        };
    }
})();
