/**
 * This is the ExamResultsTableDirective definition.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y023, Y024, Y070, Y072, Y074]*
 *  
 *  @type Directive
 *  
 */
(function() {
    'use strict';

    angular
        .module('RoomsEditorDirective', ['EntityServices'])
        .directive('roomsEditor', roomsEditor);

    function roomsEditor() {

        var directive = {
            restrict: 'E',
            scope: {
                rooms: '=?',
                showActions: '=?'
            },
            controller: 'RoomsEditorController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/roomsEditor/views/rooms-editor.html',
        };

        return directive;

    }
})();
