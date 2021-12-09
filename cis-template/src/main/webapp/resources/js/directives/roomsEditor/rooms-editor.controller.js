/**
 * This is the Rooms Editor Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';
    angular
        .module('RoomsEditorDirective')
        .controller('RoomsEditorController', RoomsEditorController);

    RoomsEditorController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModal', 'Room'];

    function RoomsEditorController($log, $scope, $state, $rootScope, $uibModal, Room) {
        /* jshint validthis:true */
        var vm = this;

        vm.editRooms = editRooms;
        vm.addRooms = addRooms;

        function loadRooms() {
            Room.query().then(function(response) {
                $scope.rooms = response.data;
                $log.info("Loading Exam Results");
            }, function(response) {
                $log.error("Failed to load Results");
            });
        }

        function editRooms(roomId) {
            $log.log("RoomEditorController :: editRooms called");
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/roomsEditor/views/rooms-editorDialog.html',
                controller: 'RoomsEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    roomEntity: function(Room) {
                        return Room.get(roomId).then(function(response) {
                            return response.data;
                        }, function(response) {
                            alert("failed to retrieve");
                        });
                    }
                }
            });

            modalInstance.result.then().finally(function() {
                loadRooms();
            });
        }

        function addRooms() {
            $log.log("RoomEditorController :: addRooms called");
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/roomsEditor/views/rooms-editorDialog.html',
                controller: 'RoomsEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    roomEntity: function() {
                        var rooms = {};
                        return rooms;
                    }
                }
            });

            modalInstance.result.then().finally(function() {
                loadRooms();
            });
        }

    }

})();
