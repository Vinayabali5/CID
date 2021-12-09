/**
 * This is the Year Group Editor Dialog Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';

    angular
        .module('SupportTypesEditorDirective')
        .controller('SupportTypesEditorDialogController', SupportTypesEditorDialogController);

    SupportTypesEditorDialogController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModalInstance', 'SupportType', 'supportTypesEntity'];

    function SupportTypesEditorDialogController($log, $scope, $state, $rootScope, $uibModalInstance, SupportType, supportTypesEntity) {
        /* jshint validthis:true */
        var vm = this;
        vm.supportTypes = supportTypesEntity !== undefined ? supportTypesEntity : {};

        vm.cancel = cancel;
        vm.save = save;
        vm.add = add;

        var onSaveFinished = function(result) {
            $scope.$emit('support-types-saved', result);
            $uibModalInstance.close(result);
        };

        function cancel() {
            $uibModalInstance.dismiss('cancel');
        }

        function add() {
            if (vm.supportTypes.id !== null) {
                SupportType.create(vm.supportTypes, onSaveFinished);
            }
        }

        function save() {
            if (vm.supportTypes.id) {
                SupportType.save(vm.supportTypes, onSaveFinished);
            }
        }

    }

})();
