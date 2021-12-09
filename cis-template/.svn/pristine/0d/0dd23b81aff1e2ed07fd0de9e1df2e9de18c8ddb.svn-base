/**
 * This is the RoomTable Directive definition.
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
        .module('RoomTableDirective', ['ngResource', 'ui.bootstrap', 'RoomService'])
        .directive('roomTable', roomTable);

    function roomTable() {
        return {
            scope: {
                roomList: '=',
            },
            transclude: true,
            controller: 'RoomTableDirectiveController',
            controllerAs: 'ctrl',
            templateUrl: 'js/directives/roomTable/roomTable.html'
        };
    }
})();
