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
        .module('EntryQualificationsEditorDirective')
        .controller('EntryQualificationsEditorDialogController', EntryQualificationsEditorDialogController);

    EntryQualificationsEditorDialogController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModalInstance', 'EntryQualification', 'entryQualificationsEntity'];

    function EntryQualificationsEditorDialogController($log, $scope, $state, $rootScope, $uibModalInstance, EntryQualification, entryQualificationsEntity) {
        /* jshint validthis:true */
        var vm = this;
        vm.entryQualifications = entryQualificationsEntity !== undefined ? entryQualificationsEntity : {};

        vm.cancel = cancel;
        vm.save = save;

        var onSaveFinished = function(result) {
            $scope.$emit('entryQualifications-saved', result);
            $uibModalInstance.close(result);
        };

        function cancel() {
            $uibModalInstance.dismiss('cancel');
        }

        function save() {
            if (vm.entryQualifications.id) {
                EntryQualification.save(vm.entryQualifications, onSaveFinished);
            } else {
                if (vm.entryQualifications.id !== null) {
                    EntryQualification.create(vm.entryQualifications,
                        onSaveFinished);
                }
            }
        }

    }

})();
