/**
 * This is the Correspondence Type Editor Dialog Controller
 *
 * Applied Styles: [Y001, Y002, Y010, Y022, Y023, Y024, Y031, Y032, Y033, Y034]
 *
 * @type Controller
 */

(function() {
    'use strict';

    angular.module('CorrespondenceTypesEditorDirective')
        .controller('CorrespondenceTypesEditorDialogController', CorrespondenceTypesEditorDialogController);

    CorrespondenceTypesEditorDialogController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModalInstance', 'CorrespondenceType', 'correspondenceTypesEntity'];

    function CorrespondenceTypesEditorDialogController($log, $scope, $state, $rootScope, $uibModalInstance, CorrespondenceType, correspondenceTypesEntity) {
        /* jshint validthis:true */
        var vm = this;
        vm.correspondenceTypes = correspondenceTypesEntity !== undefined ? correspondenceTypesEntity : {};

        vm.cancel = cancel;
        vm.save = save;
        vm.add = add;

        var onSaveFinished = function(result) {
            $scope.$emit('correspondenceTypes-saved', result);
            $uibModalInstance.close(result);
        };

        function cancel() {
            $uibModalInstance.dismiss('cancel');
        }

        function save() {
            if (vm.correspondenceTypes.id) {
                CorrespondenceType.save(vm.correspondenceTypes, onSaveFinished);
            }
        }

        function add() {
            if (vm.correspondenceTypes) {
                CorrespondenceType.create(vm.correspondenceTypes, onSaveFinished);
            }
        }

    }

})();
