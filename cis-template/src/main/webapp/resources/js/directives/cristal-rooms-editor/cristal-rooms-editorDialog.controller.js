/**
 * This is the CristalRooms Editor Dialog Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */


(function() {
    'use strict';

    angular
        .module('CristalRoomsEditorDirective')
        .controller('CristalRoomsEditorDialogController', CristalRoomsEditorDialogController);

    CristalRoomsEditorDialogController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModalInstance', 'CristalRoom', 'cristalRoomEntity'];

    function CristalRoomsEditorDialogController($log, $scope, $state, $rootScope, $uibModalInstance, CristalRoom, cristalRoomEntity) {
        /* jshint validthis:true */
        var vm = this;
        vm.cristalRoom = cristalRoomEntity;

        vm.cancel = cancel;
        vm.save = save;


        var onSaveFinished = function(result) {
            $scope.$emit('cristalRoom-saved', result);
            $uibModalInstance.close(result);
        };

        function cancel() {
            $log.log('ExamResultsEditorDialogController::clear called');
            $uibModalInstance.dismiss('cancel');
        }

        function save() {
            if (vm.cristalRoom.roomId) {
                CristalRoom.save(vm.cristalRoom, onSaveFinished);
            } else {
                if (vm.cristalRoom.roomId !== null) {
                    CristalRoom.create(vm.cristalRoom, onSaveFinished);
                }
            }
        }

    }


})();
