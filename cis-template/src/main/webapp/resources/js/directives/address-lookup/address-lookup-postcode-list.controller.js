/**
 * This controller is used by the AddressLookupDirective.
 *
 * Applied Style: [Y001, Y002, Y010, Y022, Y023, Y024, Y032, Y033, Y034] *
 *
 */

(function() {
    'use strict';

    angular
        .module('AddressLookupDirective')
        .controller('AddressLookupPostcodeListController', AddressLookupPostcodeListController);

    AddressLookupPostcodeListController.$inject = ['$log', '$scope', '$state', '$uibModal', '$uibModalInstance', 'postcodeLookups', 'PostcodeLookup'];

    function AddressLookupPostcodeListController($log, $scope, $state, $uibModal, $uibModalInstance, postcodeLookups, PostcodeLookup) {
        /* jshint validthis:true */
        var vm = this;
        vm.postcode = postcodeLookups.data;
        vm.selectedPostcodeId = null;
        vm.selectAddress = selectAddress;
        vm.clear = clear;

        function selectAddress() {
            $log.log('AddressLookupPostcodeListController::select called');
            if (vm.selectedPostCode === null) {
                // No postcode selected
            }
            PostcodeLookup.retrieve(vm.selectedPostcodeId).then(function(response) {
                $scope.$emit('address-selected', response.data);
                $uibModalInstance.close(response.data);
            });
        }

        function clear() {
            $log.log('AddressLookupPostcodeListController::clear called');
            $uibModalInstance.dismiss('cancel');
        }
    }
})();
