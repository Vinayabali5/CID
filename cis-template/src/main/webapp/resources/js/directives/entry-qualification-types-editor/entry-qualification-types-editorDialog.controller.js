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
        .module('EntryQualificationTypesEditorDirective')
        .controller('EntryQualificationTypesEditorDialogController', EntryQualificationTypesEditorDialogController);

    EntryQualificationTypesEditorDialogController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModalInstance', 'EntryQualificationType', 'entryQualificationTypesEntity'];

    function EntryQualificationTypesEditorDialogController($log, $scope, $state, $rootScope, $uibModalInstance, EntryQualificationType, entryQualificationTypesEntity) {
        /* jshint validthis:true */
        var vm = this;
        vm.entryQualificationTypes = entryQualificationTypesEntity !== undefined ? entryQualificationTypesEntity : {};

        vm.cancel = cancel;
        vm.save = save;

        var onSaveFinished = function(result) {
            $scope.$emit('entryQualificationTypes-saved', result);
            $uibModalInstance.close(result);
        };

        function cancel() {
            $uibModalInstance.dismiss('cancel');
        }

        function save() {
            if (vm.entryQualificationTypes.id) {
                EntryQualificationType.save(vm.entryQualificationTypes, onSaveFinished);
            } else {
                if (vm.entryQualificationTypes.id !== null) {
                    EntryQualificationType.create(vm.entryQualificationTypes, onSaveFinished);
                }
            }
        }

    }

})();
