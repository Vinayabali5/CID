/**
 * This controller is used by the AddressEditorDirective.
 *
 * Applied Style: [Y001, Y002, Y010, Y022, Y023, Y024, Y032, Y033, Y034] *
 *
 */
(function() {
    'use strict';

    angular
        .module('AddressLookupDirective')
        .controller('AddressLookupController', AddressLookupController);

    AddressLookupController.$inject = ['$log', '$scope', '$rootScope', '$uibModal', 'Address'];

    function AddressLookupController($log, $scope, $rootScope, $uibModal, Address) {
        /* jshint validthis:true */
        var vm = this;

        $scope.postcodeLookup = postcodeLookup;

        //Lookup button
        function postcodeLookup(postcode) {
            $log.log('AddressLookupPostcodeLookupController::lookup called');
            vm.modalOptions = {
                templateUrl: 'js/directives/address-lookup/views/postcode-lookup-list.html',
                controller: 'AddressLookupPostcodeListController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    postcodeLookups: ['PostcodeLookup', function(PostcodeLookup) {
                        return PostcodeLookup.search(postcode);
                    }]
                }
            };
            $uibModal.open(vm.modalOptions).result.then(function(response) {
                $scope.address.line1 = response.line1;
                $scope.address.line2 = response.line2;
                $scope.address.line3 = response.line3;
                $scope.address.line4 = response.line4;
                $scope.address.line5 = response.line5;
                $scope.address.town = response.town;
                $scope.address.county = response.county;
                $scope.address.buildingName = response.buildingName;
                $scope.address.subBuilding = response.subBuilding;
                $scope.address.postcode = response.postcode;
                $log.log(response);
            });
        }

    }
})();
