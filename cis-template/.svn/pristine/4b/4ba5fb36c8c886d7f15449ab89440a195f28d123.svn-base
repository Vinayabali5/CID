/**
 * This is the CristalRooms Editor Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';
    angular
        .module('CristalRoomsEditorDirective')
        .controller('CristalRoomsEditorController', CristalRoomsEditorController);

    CristalRoomsEditorController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModal', 'CristalRoom'];

    function CristalRoomsEditorController($log, $scope, $state, $rootScope, $uibModal, CristalRoom) {
        /* jshint validthis:true */
        var vm = this;
        vm.cristalRooms = [];

        vm.editCristalRooms = editCristalRooms;
        vm.addCristalRooms = addCristalRooms;

        function loadCristalRooms() {
            CristalRoom.query().then(function(response) {
                $scope.cristalRooms = response.data;
                $log.info("Loading Exam Results");
            }, function(response) {
                $log.error("Failed to load Results");
            });
        }

        function editCristalRooms(roomId) {
            $log.log("CristalRoomEditorController :: editCristalRooms called");
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/cristal-rooms-editor/views/cristal-rooms-editorDialog.html',
                controller: 'CristalRoomsEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    cristalRoomEntity: function(CristalRoom) {
                        return CristalRoom.get(roomId).then(function(response) {
                            return response.data;
                        }, function(response) {
                            alert("failed to retrieve");
                        });
                    }
                }
            });

            modalInstance.result.then().finally(function() {
                loadCristalRooms();
            });
        }

        function addCristalRooms() {
            $log.log("CristalRoomEditorController :: addCristalRooms called");
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/cristal-rooms-editor/views/cristal-rooms-editorDialog.html',
                controller: 'CristalRoomsEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    cristalRoomEntity: function() {
                        var cristalRoom = {};
                        cristalRoom.mayPrint = true;
                        cristalRoom.tutorOffice = true;
                        cristalRoom.securityCodeNotRequired = true;
                        cristalRoom.autoStart = true;
                        return cristalRoom;
                    }
                }
            });

            modalInstance.result.then().finally(function() {
                loadCristalRooms();
            });
        }

    }

})();
