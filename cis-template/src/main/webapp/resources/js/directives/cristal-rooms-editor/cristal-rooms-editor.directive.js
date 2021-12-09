/**
 * This is the Cristal Rooms editor Directive definition.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y023, Y024, Y070, Y072, Y074]*
 *  
 *  @type Directive
 *  
 */
(function() {
    'use strict';

    angular
        .module('CristalRoomsEditorDirective', ['EntityServices'])
        .directive('cristalRoomsEditor', cristalRoomsEditor);

    function cristalRoomsEditor() {

        var directive = {
            restrict: 'E',
            scope: {
                cristalRooms: '=?',
                showActions: '=?'
            },
            controller: 'CristalRoomsEditorController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/cristal-rooms-editor/views/cristal-rooms-editor.html',
        };

        return directive;

    }
})();
