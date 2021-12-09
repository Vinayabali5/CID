/**
 * This is the Blocks Editor Dialog Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */


(function() {
    'use strict';

    angular
        .module('BlocksEditorDirective')
        .controller('BlocksEditorDialogController', BlocksEditorDialogController);

    BlocksEditorDialogController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModalInstance', 'Block', 'blocksEntity'];

    function BlocksEditorDialogController($log, $scope, $state, $rootScope, $uibModalInstance, Block, blocksEntity) {
        /* jshint validthis:true */
        var vm = this;
        vm.blocks = blocksEntity !== undefined ? blocksEntity : {};

        vm.cancel = cancel;
        vm.save = save;


        var onSaveFinished = function(result) {
            $scope.$emit('blocks-saved', result);
            $uibModalInstance.close(result);
        };

        function cancel() {
            $log.log('BlocksEditorDialogController::clear called');
            $uibModalInstance.dismiss('cancel');
        }

        function save() {
            if (vm.blocks.id) {
                Block.save(vm.blocks, onSaveFinished);
            } else {
                if (vm.blocks.id !== null) {
                    Block.create(vm.blocks, onSaveFinished);
                }
            }
        }

    }


})();
