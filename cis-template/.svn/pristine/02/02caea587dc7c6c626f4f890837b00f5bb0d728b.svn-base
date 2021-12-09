/**
 * This controller is used by the AddressEditorDirective.
 *
 * Applied Style: [Y001, Y002, Y010, Y022, Y023, Y024, Y032, Y033, Y034] *
 *
 */
(function() {
    'use strict';

    angular
        .module('AddressEditorDirective')
        .controller('AddressEditorController', AddressEditorController);

    AddressEditorController.$inject = ['$log', '$scope', '$rootScope', '$uibModal', 'Address'];

    function AddressEditorController($log, $scope, $rootScope, $uibModal, Address) {
        /* jshint validthis:true */
        var vm = this;

        vm.message = '';
        vm.addressId = vm.addressId ? vm.addressId : undefined;
        vm.address = vm.address ? vm.address : {};
        vm.init = init;
        vm.loadAddress = loadAddress;
        vm.editAddress = editAddress;

        function init() {
            $log.log('AddressDetailsDirectiveController::init called');
            vm.loadAddress(vm.addressId);
        }

        function loadAddress(addressId) {
            Address.get(addressId).then(function(response) {
                $log.info('II Address Loaded');
                vm.address = response.data;
            });
        }

        function editAddress(id) {
            $log.log('AddressEditorDirectiveController::editAddress called');
            var addressId = id;
            var modalInstance = $uibModal.open({
                templateUrl: 'js/directives/address-editor/views/addressEditorDialog.html',
                controller: 'AddressEditorDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                backdrop: 'static',
                keyboard: false,
                resolve: {
                    addressEntity: ['Address', function(Address) {
                        return Address.get(addressId).then(function(response) {
                            return response.data;
                        }, function(response) {
                            alert("failed to retrieve");
                        });
                    }]
                }
            });
            modalInstance.result.then().finally(function() {
                vm.loadAddress(vm.addressId);
            });
        }
    }
})();
