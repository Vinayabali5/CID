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
        .module('OfferTypesEditorDirective')
        .controller('OfferTypesEditorDialogController', OfferTypesEditorDialogController);

    OfferTypesEditorDialogController.$inject = ['$log', '$scope', '$state', '$rootScope', '$uibModalInstance', 'OfferType', 'offerTypesEntity'];

    function OfferTypesEditorDialogController($log, $scope, $state, $rootScope, $uibModalInstance, OfferType, offerTypesEntity) {
        /* jshint validthis:true */
        var vm = this;
        vm.offerTypes = offerTypesEntity !== undefined ? offerTypesEntity : {};

        vm.cancel = cancel;
        vm.save = save;

        var onSaveFinished = function(result) {
            $scope.$emit('offerTypes-saved', result);
            $uibModalInstance.close(result);
        };

        function cancel() {
            $uibModalInstance.dismiss('cancel');
        }

        function save() {
            if (vm.offerTypes.id) {
                OfferType.save(vm.offerTypes, onSaveFinished);
            } else {
                if (vm.offerTypes.id !== null) {
                    OfferType.create(vm.offerTypes, onSaveFinished);
                }
            }
        }

    }

})();
