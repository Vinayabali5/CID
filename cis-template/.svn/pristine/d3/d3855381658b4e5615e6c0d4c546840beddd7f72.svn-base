/**
 * This is the Level Editor Dialog Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */


(function() {
    'use strict';

    angular
        .module('LevelsEditorDirective')
        .controller('LevelsEditorDialogController', LevelsEditorDialogController);

    LevelsEditorDialogController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModalInstance', 'Level', 'levelsEntity'];

    function LevelsEditorDialogController($log, $scope, $state, $rootScope, $uibModalInstance, Level, levelsEntity) {
        /* jshint validthis:true */
        var vm = this;
        vm.levels = levelsEntity !== undefined ? levelsEntity : {};

        vm.cancel = cancel;
        vm.save = save;

        var onSaveFinished = function(result) {
            $scope.$emit('levels-saved', result);
            $uibModalInstance.close(result);
        };

        function cancel() {
            $uibModalInstance.dismiss('cancel');
        }

        function save() {
            if (vm.levels.id) {
                Level.save(vm.levels, onSaveFinished);
            } else {
                if (vm.levels.id !== null) {
                    Level.create(vm.levels, onSaveFinished);
                }
            }
        }

    }


})();
