/**
 * This is the Rooms Editor Dialog Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */


(function() {
    'use strict';

    angular
        .module('RoomsEditorDirective')
        .controller('RoomsEditorDialogController', RoomsEditorDialogController);

    RoomsEditorDialogController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModalInstance', 'Room', 'roomEntity'];

    function RoomsEditorDialogController($log, $scope, $state, $rootScope, $uibModalInstance, Room, roomEntity) {
        /* jshint validthis:true */
        var vm = this;
        vm.room = roomEntity;

        vm.cancel = cancel;
        vm.save = save;


        var onSaveFinished = function(result) {
            $scope.$emit('room-saved', result);
            $uibModalInstance.close(result);
        };

        function cancel() {
            $log.log('ExamResultsEditorDialogController::clear called');
            $uibModalInstance.dismiss('cancel');
        }

        function save() {
            if (vm.room.id) {
                Room.save(vm.room, onSaveFinished);
            } else {
                if (vm.room.id !== null) {
                    Room.create(vm.room, onSaveFinished);
                }
            }
        }

    }


})();
